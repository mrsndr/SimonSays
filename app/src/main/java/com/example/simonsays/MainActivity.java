package com.example.simonsays;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // My internal name for the first buton
        final ImageView button1 = (ImageView) findViewById(R.id.myButton1);

        // My internal name for seek bar
        final SeekBar mySeekBar = (SeekBar) findViewById(R.id.seekBar);


        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int seekBarProgress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                button1.setRotationY((float) (seekBarProgress - 90));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        button1.setImageResource(R.drawable.ic_pressed);
                        break;

                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        button1.setImageResource(R.drawable.ic_not_pressed);
                        break;

                    case MotionEvent.ACTION_MOVE:
                        int x = (int) motionEvent.getRawX();
                        int y = (int) motionEvent.getRawY();

                        button1.setX((float) x);
                        button1.setY((float) y);

                }

                /*
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                // Pressed the image/button
                    button1.setImageResource(R.drawable.ic_pressed);
                }
                */

                return true;       // True if we consumed the touch event
            }
        });

    }


}