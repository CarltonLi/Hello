package com.example.Hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button start_test;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        start_test = (Button) findViewById(R.id.start_test);
        start_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.start_test) {
            Intent intent = new Intent(MainActivity.this, TestScrollNumberActivity.class);
            startActivity(intent);
        }
    }
}
