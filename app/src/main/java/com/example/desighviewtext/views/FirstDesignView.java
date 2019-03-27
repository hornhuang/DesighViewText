package com.example.desighviewtext.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class FirstDesignView extends android.support.v7.widget.AppCompatImageView {

    // 这三个构造方法都必须写，否则找不到报错
    public FirstDesignView(Context context) {
        super(context);
    }

    public FirstDesignView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstDesignView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension( measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth( int measureSpec ){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

    private int measureHeight( int measureSpec ){
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }

        return result;
    }

}
