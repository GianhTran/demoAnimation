package com.framgia.demotexteffect;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by framgia on 03/11/2016.
 */
public class TreasureChestActivity extends AppCompatActivity {
    private ImageView mImageViewChest1;
    private ImageView mImageViewChest2;
    private ImageView mImageViewChest3;
    private ImageView mImageViewCard;
    private RelativeLayout mRelativeLayoutCard;
    private ImageView mImageViewLight;
    private Button mBtnStart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure_chest);
        mImageViewChest1 = (ImageView) findViewById(R.id.image_chest_1);
        mImageViewChest2 = (ImageView) findViewById(R.id.image_chest_2);
        mImageViewChest3 = (ImageView) findViewById(R.id.image_chest_3);
        mImageViewCard = (ImageView) findViewById(R.id.image_card);
        mImageViewLight = (ImageView) findViewById(R.id.image_light);
        mRelativeLayoutCard = (RelativeLayout) findViewById(R.id.relative_card);
        mBtnStart = (Button) findViewById(R.id.button_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageViewChest1.setAlpha(0f);
                up(mImageViewChest2);
                mBtnStart.setVisibility(View.GONE);
            }
        });
    }

    private void show(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate().alpha(1)
                .setDuration(100)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                    }
                })
                .start();
        }
    }

    private void up(final View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate()
                .alpha(1)
                .setDuration(200)
                .translationY(-100)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        downAndHide(view);
                    }
                })
                .start();
        }
    }

    private void hide(View view, long duration) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate()
                .alpha(0)
                .setDuration(duration)
                .start();
        }
    }

    private void downAndHide(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate()
                .alpha(0)
                .setDuration(100)
                .translationY(100)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        show(mImageViewChest3);
                        cardMoveUp(mRelativeLayoutCard);
                    }
                })
                .start();
        }
    }

    private void cardMoveUp(final View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate()
                .alpha(1)
                .translationY(-100)
                .translationX(50)
                .setDuration(300)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        cardMoveDownAndScale(view);
                    }
                })
                .start();
        }
    }

    private void cardMoveDownAndScale(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate()
                .alpha(1)
                .scaleX(1)
                .scaleY(1)
                .translationY(50)
                .translationX(-30)
                .setDuration(500)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        rotate(mImageViewLight, true);
                    }
                })
                .start();
        }
    }

    private void rotate(final View view, final boolean rote) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.animate()
                .rotation(rote ? 90 : -90)
                .setDuration(2000)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        if (rote) {
                            rotate(view, false);
                            hide(mRelativeLayoutCard, 2000);
                        } else {
                            finishAnim();
                        }
                    }
                })
                .start();
        }
    }

    private void finishAnim() {
        mRelativeLayoutCard.setScaleX(0.3f);
        mRelativeLayoutCard.setScaleY(0.3f);
        mBtnStart.setVisibility(View.VISIBLE);
        mImageViewChest3.setAlpha(0f);
        mImageViewChest1.setAlpha(1f);
    }
}
