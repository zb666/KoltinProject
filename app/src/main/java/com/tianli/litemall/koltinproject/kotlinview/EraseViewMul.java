package com.tianli.litemall.koltinproject.kotlinview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.tianli.litemall.koltinproject.R;

public class EraseViewMul extends View {

    private Paint mPaint;
    private Path mPath;
    private Bitmap mBitmapSrc, mBitmapDST;
    private float mPreX, mPreY;
    private Canvas mSelfCanvas;
    private Xfermode mXferMode;
    private Paint mGrilPaint;

    public EraseViewMul(Context context) {
        this(context, null);
    }

    public EraseViewMul(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EraseViewMul(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);

        mPath = new Path();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        mBitmapSrc = BitmapFactory.decodeResource(getResources(), R.drawable.swapforfun);

        mBitmapDST = Bitmap.createBitmap(mBitmapSrc.getWidth(), mBitmapSrc.getHeight(), Bitmap.Config.ARGB_8888);

        mSelfCanvas = new Canvas(mBitmapDST);

        mXferMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);

        mGrilPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mGrilPaint.setTextSize(36);
        mGrilPaint.setColor(Color.BLUE);
        mGrilPaint.setStrokeWidth(16);
        mGrilPaint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX = (mPreX + event.getX()) / 2;
                float endY = (mPreY + event.getY()) / 2;
                mPath.quadTo(mPreX, mPreY, endX, endY);
                //move 的时候 需要更新当前的进度
                mPreX = event.getX();
                mPreY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("恭喜你 喜提 海边 别墅一套",300,100,mGrilPaint);
        //离屏缓冲
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        mSelfCanvas.drawPath(mPath,mPaint);
        //然后就是绘制到画布上
        canvas.drawBitmap(mBitmapDST,0,0,mPaint);
        mPaint.setXfermode(mXferMode);
        canvas.drawBitmap(mBitmapSrc,0,0,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }
}
