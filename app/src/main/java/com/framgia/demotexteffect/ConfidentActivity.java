package com.framgia.demotexteffect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.plattysoft.leonids.ParticleSystem;

public class ConfidentActivity extends AppCompatActivity {
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confident);
        mStartButton = (Button) findViewById(R.id.button1);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    private void show() {
        new ParticleSystem(this, 80, R.drawable.confeti2, 10000)
            .setSpeedModuleAndAngleRange(0f, 0.1f, 0, 180)
            .setRotationSpeed(144)
            .setAcceleration(0.000017f, 90)
            .emit(findViewById(R.id.emiter_top_right), 8);
        new ParticleSystem(this, 80, R.drawable.confeti3, 10000)
            .setSpeedModuleAndAngleRange(0f, 0.1f, 0, 180)
            .setRotationSpeed(144)
            .setAcceleration(0.000017f, 90)
            .emit(findViewById(R.id.emiter_top_left), 8);
    }
}
