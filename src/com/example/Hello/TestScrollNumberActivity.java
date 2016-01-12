package com.example.Hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ScrollView;


/**
 * Created by lichao22 on 16/1/12.
 */
public class TestScrollNumberActivity extends Activity {
    private VerticalScrollNumberView scroll_view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_scroll_number);
        scroll_view = (VerticalScrollNumberView) findViewById(R.id.scroll_view);
        scroll_view.setData(345123);
    }

    @Override
    protected void onResume() {

        // Start or restart the Marquee if paused.
        //scroll_view.resumeMarque();
        super.onResume();
    }

    /*
    @Override
    protected void onPause() {

        // Pause the Marquee when the Activity pauses.
        VMTV.pauseMarquee();
        super.onPause();
    }

    @Override
    protected void onDestroy() {

        VMTV.stopMarquee();
        super.onDestroy();
    }
    */
}
