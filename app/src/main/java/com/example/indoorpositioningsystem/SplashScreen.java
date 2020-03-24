package com.example.indoorpositioningsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ImageView iv;
    TextView t1,t2,t3;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        iv = (ImageView)findViewById(R.id.iv);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);
        pb = (ProgressBar)findViewById(R.id.pb);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork(){
        for (int p=0;p<100;p+=10){
            try {
                Thread.sleep(1000);
                pb.setProgress(p);
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }
    private void startApp(){
        Intent i = new Intent(SplashScreen.this, SecondScreen.class);
        startActivity(i);
    }
}
