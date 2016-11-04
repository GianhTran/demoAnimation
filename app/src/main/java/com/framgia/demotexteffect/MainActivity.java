package com.framgia.demotexteffect;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private Button mBtnGoal;
    private Button mBtnOpenChest;
    private Button mBtnConfident;
    private LinearLayout linear;
    private MainActivity mainActivity;
    int code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        initView();
        handleEvent();
    }

    private void handleEvent() {
        mBtnGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAnim(text1);
            }
        });
        mBtnOpenChest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mainActivity, TreasureChestActivity.class));
            }
        });
        mBtnConfident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mainActivity, ConfidentActivity.class));
            }
        });
    }

    private void initView() {
        text1 = (TextView) findViewById(R.id.text_1);
        text2 = (TextView) findViewById(R.id.text_2);
        text3 = (TextView) findViewById(R.id.text_3);
        text4 = (TextView) findViewById(R.id.text_4);
        text5 = (TextView) findViewById(R.id.text_5);
        mBtnGoal = (Button) findViewById(R.id.button_goal);
        mBtnOpenChest = (Button) findViewById(R.id.button_open_chest);
        mBtnConfident = (Button) findViewById(R.id.button_confident);
        linear = (LinearLayout) findViewById(R.id.linear);
    }

    private void showAnim(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate().alpha(1)
                .scaleX(1.5f)
                .setDuration(100)
                .scaleY(1.5f)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        switch (code) {
                            case 0:
                                hideAnim(text1);
                                showAnim(text2);
                                code++;
                                break;
                            case 1:
                                hideAnim(text2);
                                showAnim(text3);
                                code++;
                                break;
                            case 2:
                                hideAnim(text3);
                                showAnim(text4);
                                code++;
                                break;
                            case 3:
                                hideAnim(text4);
                                showAnim(text5);
                                code++;
                                break;
                            default:
                                finishAnim(linear);
                                break;
                        }
                    }
                })
                .start();
        }
    }

    private void hideAnim(View view) {
        view.animate().alpha(1)
            .scaleX(1)
            .setDuration(50)
            .scaleY(1)
            .start();
    }

    private void finishAnim(View view) {
        view.animate().alpha(0)
            .translationY(-20)
            .start();
    }
}
