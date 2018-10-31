package com.tianli.litemall.koltinproject.kotlinview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceCanvasView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint mPaint;

    public SurfaceCanvasView(Context context) {
        this(context,null);
    }

    public SurfaceCanvasView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SurfaceCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.argb(0x1F,0XFF,0XFF,0Xff));
        mPaint.setTextSize(30);

        getHolder().addCallback(this);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawRect(holder);
    }

    //开始绘制矩形区域
    private void drawRect(final SurfaceHolder holder) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    Rect dirtyRect = new Rect(0,0,1,1);
                    Canvas canvas = holder.lockCanvas(dirtyRect);
                    Rect canvasRect = canvas.getClipBounds();
                    //需要绘制的矩形是否填充了当前画布的宽度
                    if (getWidth() == canvasRect.width()&&getHeight()  == canvasRect.height()){
                        canvas.drawColor(Color.BLACK);
                        //画完之后 替换画布
                        holder.unlockCanvasAndPost(canvas);
                    }else {
                        //不然就直接进行替换
                        holder.unlockCanvasAndPost(canvas);
                    }
                    break;
                }
                //这里得到解锁完之后的画布画布
                Canvas canvas = holder.lockCanvas(new Rect(10, 10, 600, 600));
                canvas.drawColor(Color.RED);
                holder.unlockCanvasAndPost(canvas);
            }
        }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
