package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private TextView score;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score= findViewById(R.id.sa_score);
        done = findViewById(R.id.sa_done);
        String score_str = getIntent().getStringExtra("SCORE");
        score.setText(score_str);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Score.this,MainActivity.class);

               startActivity(intent);

                Score.this.finish();
            }
        });
    }
}
