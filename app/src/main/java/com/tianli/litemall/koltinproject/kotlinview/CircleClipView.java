package com.tianli.litemall.koltinproject.kotlinview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.tianli.litemall.koltinproject.R;

public class CircleClipView extends AppCompatImageView {

    private Path mClipPath;
    private Bitmap bitmap;
    private Rect rect;

    public CircleClipView(Context context) {
        this(context,null);
    }

    public CircleClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mClipPath = new Path();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.swapforfun);
        mClipPath.addCircle(bitmap.getWidth()/4,bitmap.getHeight()/4,bitmap.getHeight()/2, Path.Direction.CW);
        rect = new Rect(0,0,400,200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //构造两个画笔，一个红色，一个绿色
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 10);
        Paint paint_red   = generatePaint(Color.RED, Paint.Style.STROKE, 10);

        canvas.drawRect(rect,paint_green);
        canvas.save();
        canvas.rotate(30);

        canvas.translate(30,30);
        canvas.drawRect(rect,paint_red);
        canvas.drawText("aaaa",10,10,paint_green);
        canvas.restore();
        canvas.drawText("aaaa",10,10,paint_green);

    }

    private Paint generatePaint(int color, Paint.Style style, int width)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }

}
