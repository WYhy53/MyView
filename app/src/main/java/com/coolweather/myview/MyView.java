package com.coolweather.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.security.KeyStore;
import java.text.AttributedCharacterIterator;
import java.util.jar.Attributes;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context,@Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    //视图
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(100,100,getWidth()-100,getWidth()-100);
        //第二个参数表示的是从多少度开始画,第三个参数表示的是画多少度
        canvas.drawArc(rectF,0,90,true,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(rectF,90,45,true,paint);
        Log.d("运行了","wwwwwwwwwwwwwwwwww");
        canvas.drawArc(rectF,135,90,true,paint);
        canvas.drawArc(rectF,225,90,true,paint);
        canvas.drawArc(rectF,315,45,true,paint);
    }
}
