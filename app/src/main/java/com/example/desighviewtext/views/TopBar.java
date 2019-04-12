package com.example.desighviewtext.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.desighviewtext.R;

public class TopBar extends RelativeLayout {
    // 组件
    private Button mLeftButton, mRightButton;
    private TextView mTitleView;
    // 布局元素
    private LayoutParams mLeftParams, mRightParams, mTitlepParams;
    // 属性
    private int mLeftTextColor, mRightTextColor, mTitleTextColor;
    private Drawable mLeftBackground, mRightBackground;
    private String mLeftText, mRightText, mTitle;
    private float mTitleTextSize;
    private TopBarOnClickListener mListner;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        ConfigurationAttributes(context, attrs);
        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        // 为创建的组件元素赋值
        // 值来源于我们引用的 xml 为减重给对应属性的赋值
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);

        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        // 为组件元素设置对应布局
        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        // 添加到 ViewGroup
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton,mRightParams);

        mTitlepParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        mTitlepParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitlepParams);
        ConfigurationListner();
    }

    private void ConfigurationAttributes(Context context, AttributeSet attrs){
        // 通过这个方法将你在 atts.xml 中定义的 declare-styleable
        // 的所有属性的值存储到 TypeArray 中
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar );
//        从 TypeArray 中取出对应的值来为要设置的属性赋值
        mLeftTextColor = typedArray.getColor(
                R.styleable.TopBar_leftTextColor, 0);
        mLeftBackground = typedArray.getDrawable(
                R.styleable.TopBar_leftBackground);
        mLeftText = typedArray.getString(
                R.styleable.TopBar_leftText);

        mRightTextColor = typedArray.getColor(
                R.styleable.TopBar_rightTextColor, 0);
        mRightBackground = typedArray.getDrawable(
                R.styleable.TopBar_rightBackground);

        mRightText = typedArray.getString(
                R.styleable.TopBar_rightText);

        mTitleTextSize = typedArray.getDimension(
                R.styleable.TopBar_titleTextSize, 10);
        mTitleTextColor = typedArray.getColor(
                R.styleable.TopBar_titleTextColor, 0);
        mTitle = typedArray.getString(
                R.styleable.TopBar_title);

        // 获取完 TypeArray 的值后，一般要调用
        // recyle 方法避免新创建时候的错误
        typedArray.recycle();

    }

    private void ConfigurationListner(){
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListner.RightClick();
            }
        });

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListner.LeftClick();
            }
        });
    }

    /*
    监听事件接口实现
     */
    public void setOnTopBarClickListner(TopBarOnClickListener topBarClickListner){
        this.mListner = topBarClickListner;
    }

    public void setButtonVisable(int id, boolean flag){
        if (flag){
            if (id == 0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else {
            if (id == 0){
                mLeftButton.setVisibility(View.GONE);
            }else {
                mRightButton.setVisibility(View.GONE);
            }
        }
    }

}
