package com.tianli.litemall.koltinproject.kotlinview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.tianli.litemall.koltinproject.R;

import retrofit2.http.PATCH;

public class TelSeaView extends View {

    private Paint mPaint;
    private Bitmap mBitmap, mSeaBitmap;
    private int mDx, mDy;
    private Canvas mCanvas;
    private Bitmap bitmapBG;
    private Canvas canvasBG;

    public TelSeaView(Context context) {
        this(context, null);
    }

    public TelSeaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TelSeaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(30);
        mPaint.setColor(Color.WHITE );

        mSeaBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sea);

        mPaint.setShader(new BitmapShader(mSeaBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDx = (int) event.getX();
                mDy = (int) event.getY();
                postInvalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                mDx = (int) event.getX();
                mDy = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mDx = 0;
                mDy = 0;
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(mSeaBitmap, 0, 0, mPaint);
        if (bitmapBG == null) {
            //绘制背景色
            bitmapBG = BitmapFactory.decodeResource(getResources(), R.drawable.sea).copy(Bitmap.Config.ARGB_8888,true);
            //创建画布 绑定bitmap图像 自己生成的图像需要暂时保存到到bitmap中
            canvasBG = new Canvas(bitmapBG);
            //并且关联到当前的bitmap上
            canvasBG.drawBitmap(mSeaBitmap, null, new Rect(0, 0, getWidth(), getHeight()), mPaint);
        }
        //将生成的"bitmap图像"绑定到画布上
        canvas.drawBitmap(bitmapBG,0,0,mPaint);
        canvas.drawCircle(mDx,mDy,50,mPaint);
    }
}
