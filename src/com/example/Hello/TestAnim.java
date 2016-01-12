package com.example.Hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by lichao22 on 16/1/11.
 */
public class TestAnim extends Activity implements View.OnClickListener {
    private TextView number;
    private boolean bool = false;
    private static final String BACK_STR = "9999";
    private static final String FRONT_STR = "2222";
    @Override
    public void onCreate(Bundle saveInstance) {
        super.onCreate(saveInstance);
        setContentView(R.layout.test_scale);
        number = (TextView) findViewById(R.id.number);
        number.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(TestAnim.this, R.anim.front);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                if(bool){
                    number.setText(BACK_STR);
                    number.setBackgroundColor(0xFFf2460c);
                    bool = false;
                }else {
                    number.setText(FRONT_STR);
                    number.setBackgroundColor(0xFF3385ff);
                    bool = true;
                }
                //通过AnimationUtils得到动画配置文件(/res/anim/front_scale.xml),然后在把动画交给ImageView
                number.startAnimation(AnimationUtils.loadAnimation(TestAnim.this, R.anim.back_scale));
            }
        });
        number.startAnimation(animation);
    }
}
