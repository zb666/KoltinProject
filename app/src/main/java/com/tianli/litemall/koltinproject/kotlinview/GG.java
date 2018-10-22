package com.tianli.litemall.koltinproject.kotlinview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class GG extends View {

    private Paint mPaint;
    private Path mPath;

    public GG(Context context) {
        this(context, null);
    }

    public GG(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GG(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPath = new Path();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                mPath.addCircle(event.getX(), event.getY(), 50, Path.Direction.CW);
                invalidate();
                return false;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.YELLOW);
        canvas.clipPath(mPath);
    }
}
