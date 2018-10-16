package com.tianli.litemall.koltinproject.kotlinview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class BeizerWaveView extends View {

    private Paint mPaint;
    private Path mWavePath;
    private int originY = 300;
    private int mItemWaveLength = 1000;

    private float mWaveDx = 0;

    public BeizerWaveView(Context context) {
        this(context, null);
    }

    public BeizerWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BeizerWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(15);

        mWavePath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //每次都用最新的path波浪线进行绘制 而不是用旧的不去  所以需要进行清除
        mWavePath.reset();
        //从左边开始，然后想右移动多少距离波浪就会移动多少
        mWavePath.moveTo(-mItemWaveLength + mWaveDx, originY);
        //高度是最大高度的一半
        int halfWaveLength = mItemWaveLength / 2;
        //这是进行一次dx移动之后  我们的整体贝塞尔曲线的重新绘制
        for (int i = -mItemWaveLength; i <= getWidth() + mItemWaveLength; i += mItemWaveLength) {
            //就是~类型曲线
            mWavePath.rQuadTo(halfWaveLength / 2, -100, halfWaveLength, 0);
            mWavePath.rQuadTo(halfWaveLength / 2, 100, halfWaveLength, 0);
        }
        //进行曲线的闭合
        mWavePath.lineTo(getWidth(), getHeight());
        mWavePath.lineTo(0, getHeight());
        mWavePath.close();
        canvas.drawPath(mWavePath, mPaint);
    }

    public void startAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, mItemWaveLength);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mWaveDx = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.start();
    }

    public void setWaveColor(){
        mPaint.setColor(Color.BLUE);
    }

}
