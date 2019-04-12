package com.example.desighviewtext.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.desighviewtext.R;

public class UI_3_6_3_2 extends View {

    /*
    数据成员
     */
    private int mRectCount;//小矩形的数目
    private int mWidth;
    private int mRectWidth;//每个小矩形的宽度
    private int mRectHeight;//每个小矩形的高度
    private int offset = 5;//每个小矩形之间的偏移量
    private float currentHeight;


    /*
    LinearGradient
     */
    private LinearGradient mLinearGradient;//产生渐变效果

    /*
    Paint
     */
    private Paint mPaint;//绘制小矩形的画笔
    private double mRandom;

    public UI_3_6_3_2(Context context) {
        super(context);
        iniView();
    }

    public UI_3_6_3_2(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniView();
    }

    public UI_3_6_3_2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniView();
    }

    private void iniView(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 12;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.WHITE,
                Color.RED,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for ( int i = 0 ; i < mRectCount ; i++ ){
            mRandom = Math.random();
            currentHeight = (float) (mRectHeight * mRandom);
            canvas.drawRect(
                    (float)(mWidth*0.4/2 + mRectWidth*i + offset),
                    currentHeight,
                    (float)(mWidth*0.4/2 + mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint);
        }
        postInvalidateDelayed(300);
    }

}

class VolumeView extends View {
    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPaint;
    private int mRectCount;
    private int offset = 5;
    private double mRandom;
    private LinearGradient mLinearGradient;
    public VolumeView(Context context) {
        super(context);
        initView();
    }
    public VolumeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public VolumeView(Context context, AttributeSet attrs,
                      int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mRectCount = 12;
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight() / 2;
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        //android.graphics.LinearGradient.LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, TileMode tile)

        //颜色渐变
        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    //绘制一个个的高度随机变化的小矩形
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();

            //高度随机变化

            float currentHeight = (float) (mRectHeight * mRandom);
            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint);
        }

        //void android.view.View.postInvalidateDelayed(long delayMilliseconds)
        //每隔300ms通知View重绘
        postInvalidateDelayed(300);
    }
}

///**
// * 自定义的音频模拟条形图
// * Created by shize on 2016/9/5.
// */
//class MyAF extends View {
//    // 音频矩形的数量
//    private int mRectCount;
//    // 音频矩形的画笔
//    private Paint mRectPaint;
//    // 渐变颜色的两种
//    private int topColor, downColor;
//    // 音频矩形的宽和高
//    private int mRectWidth, mRectHeight;
//    // 偏移量
//    private int offset;
//    // 频率速度
//    private int mSpeed;
//    public MyAF(Context context) {
//        super(context);
//    }
//
//    public MyAF(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        setPaint(context, attrs);
//    }
//
//    public MyAF(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        setPaint(context, attrs);
//    }
//
//    public void setPaint(Context context, AttributeSet attrs){
//        // 将属性存储到TypedArray中
//        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.MyAF);
//        mRectPaint = new Paint();
//        // 添加矩形画笔的基础颜色
//        mRectPaint.setColor(ta.getColor(R.styleable.MyAF_AFTopColor,
//                ContextCompat.getColor(context, R.color.top_color)));
//        // 添加矩形渐变色的上面部分
//        topColor=ta.getColor(R.styleable.MyAF_AFTopColor,
//                ContextCompat.getColor(context, R.color.top_color));
//        // 添加矩形渐变色的下面部分
//        downColor=ta.getColor(R.styleable.MyAF_AFDownColor,
//                ContextCompat.getColor(context, R.color.down_color));
//        // 设置矩形的数量
//        mRectCount=ta.getInt(R.styleable.MyAF_AFCount, 10);
//        // 设置重绘的时间间隔，也就是变化速度
//        mSpeed=ta.getInt(R.styleable.MyAF_AFSpeed, 300);
//        // 每个矩形的间隔
//        offset=ta.getInt(R.styleable.MyAF_AFOffset, 5);
//        // 回收TypeArray
//        ta.recycle();
//    }
//
//    @Override
//    protected void onSizeChanged(int w,int h,int oldW,int oldH) {
//        super.onSizeChanged(w, h, oldW, oldH);
//        // 渐变效果
//        LinearGradient mLinearGradient;
//        // 画布的宽
//        int mWidth;
//        // 获取画布的宽
//        mWidth = getWidth();
//        // 获取矩形的最大高度
//        mRectHeight = getHeight();
//        // 获取单个矩形的宽度(减去的部分为到右边界的间距)
//        mRectWidth = (mWidth-offset) / mRectCount;
//        // 实例化一个线性渐变
//        mLinearGradient = new LinearGradient(
//                0,
//                0,
//                mRectWidth,
//                mRectHeight,
//                topColor,
//                downColor,
//                Shader.TileMode.CLAMP
//        );
//        // 添加进画笔的着色器
//        mRectPaint.setShader(mLinearGradient);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        double mRandom;
//        float currentHeight;
//        for (int i = 0; i < mRectCount; i++) {
//            // 由于只是简单的案例就不监听音频输入，随机模拟一些数字即可
//            mRandom = Math.random();
//            currentHeight = (float) (mRectHeight * mRandom);
//
//            // 矩形的绘制是从左边开始到上、右、下边（左右边距离左边画布边界的距离，上下边距离上边画布边界的距离）
//            canvas.drawRect(
//                    (float) (mRectWidth * i + offset),
//                    currentHeight,
//                    (float) ( mRectWidth * (i + 1)),
//                    mRectHeight,
//                    mRectPaint
//            );
//        }
//        // 使得view延迟重绘
//        postInvalidateDelayed(mSpeed);
//    }
//
//}
//
