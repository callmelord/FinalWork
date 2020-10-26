package com.example.finalwork;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class music extends AppCompatActivity {
    private ObjectAnimator mAnimator;
    private MediaPlayer player;
    private ImageView iv_music;
    private Integer m = 0;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        initAnimator();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.music);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.music:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext()
                                ,About.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext()
                                ,user.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext()
                                ,DashBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;

            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void play(View v) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.music);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPlayer();
                }
            });
        }
        if (m != 1) {
            mAnimator.start();
            player.start();
        }
        else if (m == 1) {
            mAnimator.resume();
            player.start();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void pause(View v) {
        if (player != null) {
            mAnimator.pause();
            player.pause();
            m = 1;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void stop(View v) {
        stopPlayer();
        mAnimator.end();
        m = 0;
    }

    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    protected void onStop() {
        super.onStop();
        stopPlayer();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initAnimator() {
        iv_music = findViewById(R.id.iv_music);
        mAnimator = ObjectAnimator.ofFloat(iv_music, "rotation", 0.0f, 360.0f);
        mAnimator.setDuration(9000);//设定转一圈的时间
        mAnimator.setRepeatCount(Animation.INFINITE);//设定无限循环
        mAnimator.setRepeatMode(ObjectAnimator.RESTART);// 循环模式
        mAnimator.setInterpolator(new LinearInterpolator());// 匀速
        mAnimator.start();//动画开始
        mAnimator.pause();//动画暂停

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private int startAnimator() {

        return 1;
    }

}