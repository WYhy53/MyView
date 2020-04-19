package com.coolweather.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class HistogramView extends View {

    public HistogramView(Context context) {
        super(context);
    }
    public HistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public HistogramView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        //默认以w/h : 16/12 的形式展现
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(screenWidth, (int) (screenWidth*12f/16f));
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(screenWidth, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, (int) (screenWidth*12f/16f));
        }
    }

    Paint paint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        //开始直方图绘制
        //我们首先绘制竖向的一条黑色直线
        paint.setColor(Color.BLACK);
        //线的粗细先设置一下
        paint.setStrokeWidth(5);
        //坐标系都是针对自己view的顶点坐标(注意不是屏幕坐标哦) 点的坐标 x轴的值是一样的 所以可以得知这肯定是一条笔直的竖线
        canvas.drawLine(100, 200, 100, 800, paint);
        //然后依葫芦画瓢画一条横向的黑色直线 与上面这条竖着的直线 组成一个x轴和y轴
        canvas.drawLine(100, 800, 800, 800, paint);
        //绘制第一个矩形直方
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        //注意坐标都是 left, top, right, bottom
        canvas.drawRect(150, 700, 200, 800, paint);
        //然后在我们的直方下面绘制对应的文字
        paint.setTextSize(35);
        canvas.drawText("三星", 140, 840, paint);
        //多画几个直方模组 组成一个完整的直方图
        canvas.drawRect(250, 500, 300, 800, paint);
        canvas.drawText("苹果", 240, 840, paint);
        canvas.drawRect(350, 300, 400, 800, paint);
        canvas.drawText("小米", 340, 840, paint);
        canvas.drawRect(450, 200, 500, 800, paint);
        paint.setColor(Color.BLUE);
        canvas.drawText("华为", 440, 840, paint);

    }
}