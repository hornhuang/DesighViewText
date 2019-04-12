package com.example.desighviewtext.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
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
    private float mCircleXY = 0 ;
    private float mRadius   = 0 ;
    private int length      = 0 ;
    private RectF mArcRectF ;

    public UI3_6_3_1(Context context) {
        super(context);
        Point p = new Point();
        //获取窗口管理器
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getSize(p);
        length = p.x; // 屏幕宽度
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCircleXY = length/2;
        mRadius   = (float)(length*0.5/2);
        mArcRectF = new RectF(
            (float)(length*0.1),
            (float)(length*0.1),
            (float)(length*0.9),
            (float)(length*0.9)
        );
        // Paint
        Paint mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.RED);
        Paint mArcPaint = new Paint();
        mArcPaint.setColor(Color.BLUE);
        Paint mTextPaint = new Paint();
        mTextPaint.setColor(Color.GREEN);
        // Text
        CharSequence mShowText = new CharSequence() {
            @Override
            public int length() {
                return 0;
            }

            @Override
            public char charAt(int index) {
                return 0;
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                return null;
            }
        };

        // 绘制圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        // 绘制弧线
        canvas.drawArc(mArcRectF, 270, 270, false, mArcPaint);
        // 绘制文字
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, mCircleXY+(length/2), mTextPaint);
    }
}
