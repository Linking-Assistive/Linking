package com.Linking.Leftslidelib;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class TouchListenLinearLayout extends LinearLayout{
    public static final String TAG = "TouchListenLinearLayout";

    private OnTouchListener mOnTouchListener;

    private Point mPoint;

    public TouchListenLinearLayout(Context context) {
        super(context);
    }

    public TouchListenLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchListenLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        mOnTouchListener = onTouchListener;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int actionMasked = event.getActionMasked();

        Log.e(TAG, "onTouchEvent: actionMasked = " + actionMasked);


        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int actionMasked = ev.getActionMasked();
        switch (actionMasked) {


            case MotionEvent.ACTION_DOWN:
                if (mOnTouchListener != null) {

                    mPoint = new Point((int)ev.getRawX(), (int)ev.getRawY());

                    mOnTouchListener.doTouch(mPoint);
                }
                break;

            default:

                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    public interface OnTouchListener {

        void doTouch(Point point);
    }
}
