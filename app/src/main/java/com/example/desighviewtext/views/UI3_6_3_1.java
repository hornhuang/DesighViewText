package com.example.desighviewtext.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public class UI3_6_3_1 extends View {

    /*
    数据成员
     */
    private float mCircleXY   = 0 ;
    private float mRadius     = 0 ;
    private float length      = 0 ;
    private float mSweepValue = 0;

    /*
    Paint
     */
    private Paint mCirclePaint;
    private Paint mArcPaint;
    private Paint mTextPaint;
    private Paint mPaint;

    /*
    RectF
     */
    private RectF mRectF;

    /*
    Text
     */
    private String mShowText;

    /*
    构造方法
     */
    public UI3_6_3_1(Context context) {
        super(context);
        iniView();
    }

    public UI3_6_3_1(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniView();
    }

    public UI3_6_3_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniView();
    }

    /*
    配置绘笔
     */
    private void iniView(){
        /*
        Paint
          */
        mCirclePaint = new Paint();//中心圆
        mCirclePaint.setColor(Color.RED);
        mCirclePaint.setAntiAlias(true);

        mTextPaint = new Paint();//中心文字
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(30);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStrokeWidth(0);

        mArcPaint = new Paint();//外围圆（ 未填充的轨道部分 ）
        mArcPaint.setStrokeWidth(100);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.STROKE);

        mPaint = new Paint();//外围圆（ 填充后 ）
        mPaint.setStrokeWidth(100);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        /*
        Text
        */
        mShowText = "0%";
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        Point p = new Point();
//        //获取窗口管理器
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        wm.getDefaultDisplay().getSize(p);
        length = w; // 屏幕宽度
        mCircleXY = length/2;
        mRadius   = (float)(length*0.5/2);
    }

    /*
    绘图
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
        RectF
        必须写在 onDraw 里
         */
        mRectF = new RectF(
                (float)(length*0.1),
                (float)(length*0.1),
                (float)(length*0.9),
                (float)(length*0.9)
        );
        // 绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        // 绘制弧线
        canvas.drawArc(mRectF, 200, 360, false, mPaint);//外围圆形轨道
        canvas.drawArc(mRectF, 200, mSweepValue, false, mArcPaint);//占满部分 0 ～ 360 圆心角换算
        // 绘制文字
        float textWidth = mTextPaint.measureText(mShowText);// 测量字体宽度，我们需要根据宽度设置文字居中
        canvas.drawText(mShowText, (int)(length/2 - textWidth/2), (int)(length/2 + textWidth/2), mTextPaint);

    }


    public void setProgress(float mSweepValue) {
        float a = (float) mSweepValue;
        if (a != 0) {
            this.mSweepValue = (float) (360.0 * (a / 100.0));
            mShowText = mSweepValue + "%";
            Log.e("this.mSweepValue:", this.mSweepValue + "");
        } else {
            this.mSweepValue = 25;
            mShowText = 25 + "%";
        }

        invalidate();
    }

}


class MViewOne extends View {
    private Paint mArcPaint, mCirclePaint, mTextPaint, mPaint;

    private float length;

    private float mRadius;

    private float mCircleXY;

    private float mSweepValue = 0;

    private String mShowText = "0%";

    private RectF mRectF;

    public MViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MViewOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MViewOne(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mArcPaint = new Paint();
        mArcPaint.setStrokeWidth(50);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.GREEN);
        mArcPaint.setStyle(Paint.Style.STROKE);

        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.GREEN);
        mCirclePaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setStrokeWidth(0);

        mPaint = new Paint();
        mPaint.setStrokeWidth(40);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.STROKE);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        length = w;
        mCircleXY = length / 2;
        mRadius = (float) (length * 0.5 / 2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画圆
        mRectF = new RectF((float) (length * 0.1), (float) (length * 0.1),
                (float) (length * 0.9), (float) (length * 0.9));
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        // 画弧线
        canvas.drawArc(mRectF, 270, 360, false, mPaint);

        canvas.drawArc(mRectF, 270, mSweepValue, false, mArcPaint);

        // 绘制文字
        float textWidth = mTextPaint.measureText(mShowText);   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间

        canvas.drawText(mShowText, (int)(length/2-textWidth/2), (int)(length/2+textWidth/2) , mTextPaint);

    }

    public void setProgress(float mSweepValue) {
        float a = (float) mSweepValue;
        if (a != 0) {
            this.mSweepValue = (float) (360.0 * (a / 100.0));
            mShowText = mSweepValue + "%";
            Log.e("this.mSweepValue:", this.mSweepValue + "");
        } else {
            this.mSweepValue = 25;
            mShowText = 25 + "%";
        }

        invalidate();
    }

}
