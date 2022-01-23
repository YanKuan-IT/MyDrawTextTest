package com.example.mydrawtexttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MyDrawTextView2 extends AppCompatTextView {
    private float progess = 0.01f;

    public MyDrawTextView2(@NonNull Context context) {
        super(context);
    }

    public MyDrawTextView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawTextView2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        myDraw(canvas, 0, (int) (getWidth() * progess), Color.BLUE);
        myDraw(canvas, (int) (getWidth() * progess), getWidth(), Color.RED);
    }

    private void myDraw(Canvas canvas, int left, int right, int colorValue) {
        canvas.save();

        Rect rect = new Rect(left, 0, right, getHeight());
        canvas.clipRect(rect);

        Paint paint = new Paint();
        paint.setTextSize(getTextSize()); // 文字大小
        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
        paint.setColor(colorValue);
        paint.setAntiAlias(true); // 防锯齿
        paint.setDither(true);    // 防抖动

        String text = getText().toString();
        if (TextUtils.isEmpty(text)) return;

        float dx = 0;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float dy = (fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        float baseLine = getHeight() / 2 + dy;
        canvas.drawText(text, dx, baseLine, paint);

        canvas.restore();
    }

    public void setProgress(float progress) {
        this.progess = progress;
        // 重新绘制
        invalidate();
    }
}
