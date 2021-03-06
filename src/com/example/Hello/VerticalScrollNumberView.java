package com.example.Hello;

import android.content.Context;
import android.graphics.Canvas;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import util.StringUtil;

import java.util.Random;

/**
 * Created by lichao22 on 16/1/12.
 */
public class VerticalScrollNumberView extends LinearLayout {
    public final static int LIMIT_MIN = 0;
    public final static int LIMIT_MAX = 999999999;
    public final static String START_NUMBER = "0\n";
    private Context mContext = null;
    public VerticalScrollNumberView(Context context) {
        super(context);
        init(context);
    }

    public VerticalScrollNumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VerticalScrollNumberView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        setBackgroundColor(0xFF26bf85);
    }

    public void setData(int number) {
        if(number < LIMIT_MIN) {
            number = LIMIT_MIN;
        }
        if(number > LIMIT_MAX) {
            number = LIMIT_MAX;
        }
        String text = String.valueOf(number);

        for(int i = 0; i != text.length(); i++) {
            String scrollStr = StringUtil.string(START_NUMBER, text.charAt(i));
            addSubView(scrollStr);
        }

        int count = 0;
        for(int i = getChildCount() - 1; i != 0; i--) {
            if(getChildAt(i) instanceof ScrollTextView) {
                LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                if(count == 2) {
                    params.setMargins(5, 0, 0, 0);
                    count = 0;
                } else {
                    params.setMargins(2, 0, 0 ,0);
                    count++;
                }
                getChildAt(i).setLayoutParams(params);
            }
        }
    }

    private void addSubView(String text) {
        /*
        VerticalMarqueeTextView textView = new VerticalMarqueeTextView(mContext);
        textView.setText(text);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.pauseMarquee();
        this.addView(textView);
        */
        ScrollTextView textView = new ScrollTextView(mContext);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(0xFF000000);
        textView.setTextColor(0xFFff5460);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setContinuousScrolling(false);
        textView.setSpeed((float) (Math.random() * 5 + 10));
        this.addView(textView);
    }

    public void resumeMarque() {
        for (int i = 0; i != getChildCount(); i++) {
            if(getChildAt(i) instanceof VerticalMarqueeTextView) {
                VerticalMarqueeTextView textView = (VerticalMarqueeTextView) getChildAt(i);
                textView.resumeMarquee();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*
        for (int i = 0; i != getChildCount(); i++) {
            if(getChildAt(i) instanceof VerticalMarqueeTextView) {
                VerticalMarqueeTextView textView = (VerticalMarqueeTextView) getChildAt(i);
                textView.resumeMarquee();
            }
        }
        */
        super.onDraw(canvas);
    }
}
