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

    public GetSegmentView(Context context) {
        this(context,null);
    }

    public GetSegmentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GetSegmentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(30);

        //画圆
        mCirclePath = new Path();
        mCirclePath.addCircle(100,100,50,Path.Direction.CW);

        mDstPath = new Path();
        mPathMeasure = new PathMeasure(mCirclePath,true);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        float endValue = mPathMeasure.getLength() * mCurAnimValue;

        mDstPath.reset();

        //---开始点到结束点，设置为true表示的是路径的绘制是连续的
        mPathMeasure.getSegment(0,endValue,mDstPath,true);
        canvas.drawPath(mDstPath,mPaint);
//        canvas.drawText(""+mCurAnimValue,200,100,mPaint);
    }
}
