package com.example.mydrawtexttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class MyDrawLineView extends View {
    public MyDrawLineView(Context context) {
        super(context);
    }

    public MyDrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawLineView(Context context, @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCenterLineX(canvas);
        drawCenterLineY(canvas);
    }

    /**
     * 绘制x轴的中间竖线
     */
    private void drawCenterLineX(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        canvas.drawLine(getWidth()/2, 0, getWidth()/2, getHeight(), paint);
    }

    /**
     * 绘制y轴的中间横线
     */
    private void drawCenterLineY(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        canvas.drawLine(0, getHeight()/2, getWidth(), getHeight()/2, paint);
    }
}
