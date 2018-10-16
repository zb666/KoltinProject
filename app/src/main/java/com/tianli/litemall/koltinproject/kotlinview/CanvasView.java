package com.tianli.litemall.koltinproject.kotlinview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {

    private Paint mPaint;
    private Path mBeizierPath;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(6);
        mPaint.setStyle(Paint.Style.STROKE);

        mBeizierPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(40);
        canvas.drawRect(100, 0, 200, 100, mPaint);
        canvas.restore();

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(100, 0, 200, 100, mPaint);

        mBeizierPath.moveTo(100, 300);
        mBeizierPath.quadTo(200, 200, 300, 300);
        mBeizierPath.quadTo(400, 400, 500, 300);
        //canvas.drawPath(mBeizierPath,mPaint);

        mBeizierPath.reset();
        mBeizierPath.moveTo(100, 300);
        //针对的是起始点位置的偏移
        mBeizierPath.rQuadTo(100, -100, 200, 0);
        //这里针对的是进行过一次移动后的点的位置的偏移 300,300  ->根据偏移量 需要得到400,400,500,300的话 需要进行rQuadTo 300+100,300+100,300+200,300+0
        mBeizierPath.rQuadTo(100, 100, 200, 0);
        canvas.drawPath(mBeizierPath, mPaint);

    }
}
