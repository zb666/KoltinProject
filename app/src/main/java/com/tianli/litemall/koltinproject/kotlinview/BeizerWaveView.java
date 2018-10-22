package com.tianli.litemall.koltinproject.kotlinview;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.tianli.litemall.koltinproject.R;

public class BeizerWaveView extends View {

    private Paint mPaint;
    private Path mWavePath;
    private int originY = 300;
    private int mItemWaveLength = 1000;

    private float mWaveDx = 0;
    private Bitmap mTopBitmap, mBottomBitmap;

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
        //禁用硬件加速
        setLayerType(View.LAYER_TYPE_NONE, null);

        mTopBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample_footer_loading);
        mBottomBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bbb);

    }

    @SuppressLint("DrawAllocation")
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

        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        int width = getWidth() / 2;
        int height = width * mTopBitmap.getHeight() / mTopBitmap.getWidth();

        canvas.drawBitmap(mTopBitmap, null, new Rect(0, 0, width, height), mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        canvas.restoreToCount(layerId);

        //下面是xfermode的绘制的流程步骤
        // 1 获取到xfermode的宽高 2 设置离屏缓冲的id 3 绘制底部的图层 4 xfermode设置图层混合的模式  5 设置需要和源文件图片合成的图层 6 还原之前离屏缓冲的图层

        int originalWidth = getWidth()/2;
        int original = originalWidth * mTopBitmap.getHeight() / mTopBitmap.getWidth();
        //这里代表 开始绘制xfermode相关的图层
        int layerSavedId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mTopBitmap,null,new Rect(0,0,width,height),mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(mBottomBitmap,null,new Rect(0,0,width,height),mPaint);

        canvas.restoreToCount(layerSavedId);

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

    public void setWaveColor() {
        mPaint.setColor(Color.BLUE);
    }

}
