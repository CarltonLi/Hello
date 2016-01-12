package com.example.Hello;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lichao22 on 16/1/12.
 */
public class TestScrollTextView extends Activity {
    private TextView scroll_text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_textview);
        scroll_text = (TextView) findViewById(R.id.scroll_text);
        //scroll_text.setMovementMethod(ScrollingMovementMethod.getInstance());
        scroll_text.setClickable(false);
        scroll_text.setLongClickable(false);
        scroll_text.setSelected(true);
        scroll_text.measure(0, 0);
        scroll_text.setScrollY(scroll_text.getMeasuredHeight());
    }
}
