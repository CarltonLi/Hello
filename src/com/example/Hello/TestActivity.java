package com.example.Hello;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lichao22 on 16/1/7.
 */
public class TestActivity extends Activity {
    private CountView test_txt;
    @Override
    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        setContentView(R.layout.test);
        test_txt = (CountView) findViewById(R.id.test_txt);
        test_txt.showNumberWithAnimation(9);
    }
}
