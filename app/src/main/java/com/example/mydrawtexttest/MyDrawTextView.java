package com.example.mydrawtexttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class MyDrawTextView extends AppCompatTextView {

    public MyDrawTextView(@NonNull Context context) {
        super(context);
    }

    public MyDrawTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDrawTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "绘制文本";

        // ********************* 演示1 *********************
        Paint paint = new Paint();
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true); // 防锯齿
        paint.setDither(true);    // 防抖动
        float x = 0;
        float baseLine = 100;
        canvas.drawText(text, x, baseLine, paint);

        // ********************* 演示2 *********************
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
        paint.setColor(Color.RED);
        paint.setAntiAlias(true); // 防锯齿
        paint.setDither(true);    // 防抖动
        x = getWidth() / 2;
        baseLine = 100 + paint.getFontSpacing();
        canvas.drawText(text, x, baseLine, paint);

        // ********************* 演示3 *********************
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.CENTER); // 居中对齐，默认值LEFT
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true); // 防锯齿
        paint.setDither(true);    // 防抖动
        x = getWidth() / 2;
        baseLine = 100 + paint.getFontSpacing() * 2;
        canvas.drawText(text, x, baseLine, paint);

        // ********************* 演示4 *********************
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.RIGHT); // 右对齐，默认值LEFT
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true); // 防锯齿
        paint.setDither(true);    // 防抖动
        x = getWidth() / 2;
        baseLine = 100 + paint.getFontSpacing() * 3;
        canvas.drawText(text, x, baseLine, paint);

        // ********************* 演示5 错误效果 *********************
//        paint.setTextSize(100); // 文字大小
//        paint.setTextAlign(Paint.Align.CENTER); // 右对齐，默认值LEFT
//        paint.setColor(Color.BLUE);
//        paint.setAntiAlias(true); // 防锯齿
//        paint.setDither(true);    // 防抖动
//        x = getWidth() / 2;
//        baseLine = 50 + getHeight() / 2;
//        canvas.drawText(text, x, baseLine, paint);

        // ********************* 演示5 正确效果 *********************
        paint.setTextSize(100); // 文字大小
        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true); // 防锯齿
        paint.setDither(true);    // 防抖动

        // 当默认左对齐的情况下
        // 仅仅getWidth() / 2 ，文字会出现在中间的右方，如演示2的效果
        // 当 减去文本宽度的一半时，即向左平移了文本的一半，正好左右居中了
        x = getWidth() / 2 - paint.measureText(text) / 2;

        // 再来解决上下居中
        // getHeight() / 2 这样设置的话，baseLine就是正好中间上方的位置，需要再向下平移一部分
        // getFontMetrics() 可以获取到 accent、descent，如截图中的标识部分
        // descent为正的，ascent为负的，他们相加 再 除以2，正好是需要向下偏移的距离
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        baseLine = getHeight() / 2 - (fontMetrics.descent + fontMetrics.ascent)/2;
        canvas.drawText(text, x, baseLine, paint);

//        // ********************* 图层演示 *********************
//        // 先进行保存
//        canvas.save();
//
//        String text = "绘制文本";
//
//        Paint paint = new Paint();
//        paint.setTextSize(100); // 文字大小
//        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
//        paint.setColor(Color.BLUE);
//        paint.setAntiAlias(true); // 防锯齿
//        paint.setDither(true);    // 防抖动
//        float x = 0;
//        float baseLine = 100;
//        canvas.drawText(text, x, baseLine, paint);
//
//        // 缩小
//        canvas.scale(0.5f, 0.5f);
//
//        // 恢复
//        canvas.restore();
//
//        paint.setTextSize(100); // 文字大小
//        paint.setTextAlign(Paint.Align.LEFT); // 默认值LEFT
//        paint.setColor(Color.RED);
//        paint.setAntiAlias(true); // 防锯齿
//        paint.setDither(true);    // 防抖动
//        x = getWidth() / 2 - paint.measureText(text) / 2;
//        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
//        baseLine = getHeight() / 2 - (fontMetrics.descent + fontMetrics.ascent)/2;
//        canvas.drawText(text, x, baseLine, paint);
    }
}
