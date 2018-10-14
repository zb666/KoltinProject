package com.tianli.litemall.koltinproject.kotlinview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class GetSegmentView extends View {

    private Path mCirclePath;
    private Paint mPaint;
    private float mCurAnimValue;
    private PathMeasure mPathMeasure;
    private Path mDstPath;

    float startValue = 0;
    private ValueAnimator valueAnimator;

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

        valueAnimator = ValueAnimator.ofFloat(0, 1);
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        float endValue = mPathMeasure.getLength() * mCurAnimValue;

        //每次重绘的时候都需要重新设置路径
        mDstPath.reset();

        if (mCurAnimValue < 0.5) {
            startValue = 0;
        } else {
            startValue = 2 * mCurAnimValue - 1;
        }
        //startD 表示绘制   path的起点到绘制开始的点的距离  endvalue表示的是path的起点到绘制结束的点的距离
        mPathMeasure.getSegment(startValue * mPathMeasure.getLength(), endValue, mDstPath, true);
        canvas.drawPath(mDstPath, mPaint);
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
