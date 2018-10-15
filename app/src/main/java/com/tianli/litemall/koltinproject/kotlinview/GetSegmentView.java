package com.tianli.litemall.koltinproject.kotlinview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.tianli.litemall.koltinproject.R;

public class GetSegmentView extends View {

    private Path mCirclePath;
    private Paint mPaint;
    private float mCurAnimValue;
    private PathMeasure mPathMeasure;
    private Path mDstPath;

    private float[] pos = new float[2];
    private float[] tan = new float[2];

    float startValue = 0;
    private ValueAnimator valueAnimator;
    private Bitmap mArrawBmp;
    private Path mRightPath;
    private PathMeasure mRightPathMeasure;

    public GetSegmentView(Context context) {
        this(context, null);
    }

    public GetSegmentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GetSegmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.BLUE);
        mPaint.setTextSize(30);

        //画圆
        mCirclePath = new Path();
        mCirclePath.addCircle(100, 100, 50, Path.Direction.CW);

        mDstPath = new Path();
        mPathMeasure = new PathMeasure(mCirclePath, true);

        valueAnimator = ValueAnimator.ofFloat(0, 2);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.start();

        mArrawBmp = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_arrow);

        //关联path路径
        mRightPath = new Path();
        mRightPath.moveTo(50, 50);
        mRightPath.lineTo(100, 100);
        mRightPath.lineTo(200, 50);
        mRightPathMeasure = new PathMeasure(mRightPath, false);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        float endValue = mPathMeasure.getLength() * mCurAnimValue;

        float arrowValue = mRightPathMeasure.getLength() * mCurAnimValue;

        //每次重绘的时候都需要重新设置路径
        mDstPath.reset();
        mRightPath.reset();

        if (mCurAnimValue < 0.5) {
            startValue = 0;
        } else {
            startValue = 2 * mCurAnimValue - 1;
        }
        //startD 表示绘制   path的起点到绘制开始的点的距离  endvalue表示的是path的起点到绘制结束的点的距离
        mPathMeasure.getSegment(startValue * mPathMeasure.getLength(), endValue, mDstPath, true);
        canvas.drawPath(mDstPath, mPaint);

        //绘制指定的path路径

        mRightPathMeasure.getSegment(0f,arrowValue,mRightPath,false);

        canvas.drawPath(mRightPath,mPaint);

//        //旋转箭头 并且进行绘制
//        mPathMeasure.getPosTan(endValue, pos, tan);
//
//        //这里需要绘制的path太多，建议用接口回调回来,然后轮训next，再次进行绘制
//        if (mCurAnimValue < 1) {
//            float degress = (float) (Math.atan2(tan[0], tan[1]) * 180.0 / Math.PI);
//            Matrix matrix = new Matrix();
//            matrix.postRotate(degress, mArrawBmp.getWidth() / 2, mArrawBmp.getHeight() / 2);
//            matrix.postTranslate(pos[0] - mArrawBmp.getWidth() / 2, pos[1] - mArrawBmp.getHeight() / 2);
//            //随着path 路径进行绘制
//            canvas.drawBitmap(mArrawBmp, matrix, mPaint);
//        } else {
//            float currentValue = mPathMeasure.getLength() * (mCurAnimValue - 1);
//            mRightPathMeasure.getSegment(0, currentValue, mDstPath, true);
//            mRightPathMeasure.nextContour();
//            canvas.drawPath(mRightPath, mPaint);
//        }


    }


    public void recycle() {
        if (valueAnimator != null) {
            synchronized (this) {
                valueAnimator.cancel();
                valueAnimator = null;
            }
        }
    }

}
