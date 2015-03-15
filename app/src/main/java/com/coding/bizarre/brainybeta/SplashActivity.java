package com.coding.bizarre.brainybeta;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashActivity extends Activity {

    public ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ImageView logo = (ImageView)findViewById(R.id.imageView4);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        anim.setAnimationListener( new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity( new Intent(SplashActivity.this, MenuActivity. class));
                SplashActivity.this.finish();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        logo.startAnimation(anim);
    }
}
