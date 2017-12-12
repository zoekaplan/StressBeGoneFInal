package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ThirdAnswer extends AppCompatActivity implements View.OnClickListener {

    private ImageView yesButton, noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_answer);

        wireWidgets();
        setOnClickListeners();
    }

    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_yes);
        noButton = (ImageView) findViewById(R.id.imageView_no);
    }

    private void setOnClickListeners() {
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_yes:
                Intent i = new Intent(ThirdAnswer.this, FourthQuestion.class);
                startActivity(i);
                break;
            case R.id.imageView_no:
                i = new Intent(ThirdAnswer.this, FeelBetter.class);
                startActivity(i);
                break;
        }
    }
}
