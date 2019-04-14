package com.example.desighviewtext.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * 定义 ViewGroup 实现类似：ScrollView 的功能
 */
public class ViewGroup_3_7 extends ViewGroup {
    /*
    数据成员
     */
    private int mScreenHeight = 0;
    private int childCount = 0;
    private int mLastY = 0;
    private int mStart = 0;
    private int mEnd = 0;
    private Scroller mScroller ;


    /*
    构造方法
     */
    public ViewGroup_3_7(Context context) {
        super(context);
        mScroller = new Scroller(context);
    }

    public ViewGroup_3_7(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public ViewGroup_3_7(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    /*
    确定 ViewGroup 的高度
     */
    private void initView(){
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for ( int i = 0 ; i < count ; i++ ){
            View childViews = getChildAt(i);
            measureChild(childViews, widthMeasureSpec, heightMeasureSpec);
        }
    }

    /*
    确定子 View 的位置
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        // 设置 ViewGroup 的高度
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight * childCount;
        setLayoutParams(mlp);
        for (int i = 0 ; i < childCount ; i++ ){
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE){
                child.layout(1, i * mScreenHeight,
                        r, (i + 1) * mScreenHeight);
            }
        }
    }

    /*
    粘性实现滑动
     */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;

            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                int dy = mLastY - y;
                if (getScrollY() < 0){
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mScreenHeight){
                    dy = 0;
                }
                scrollBy(0, dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrollY = mEnd - mStart;
                if (dScrollY > 0){
                    if (dScrollY < mScreenHeight / 3){
                        mScroller.startScroll(
                                0 , getScrollY(),
                                0, -dScrollY
                        );
                    }else {
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, mScreenHeight - dScrollY
                        );
                    }
                }else {
                    if (-dScrollY < mScreenHeight / 3){
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, -dScrollY
                        );
                    }else {
                        mScroller.startScroll(
                                0, getScrollY(),
                                0, -mScreenHeight - dScrollY
                        );
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }

    /*

     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()){
            scrollTo(0, mScroller.getCurrY());
            postInvalidate();
        }
    }
}
