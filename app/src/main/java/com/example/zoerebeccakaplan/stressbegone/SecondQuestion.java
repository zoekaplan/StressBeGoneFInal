package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SecondQuestion extends AppCompatActivity implements View.OnClickListener {

    private ImageView yesButton, noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        wireWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_button_yes);
        noButton = (ImageView) findViewById(R.id.imageView_button_no);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_button_yes:
                Intent i = new Intent(SecondQuestion.this, SecondAnswer.class);
                startActivity(i);
                break;
            case R.id.imageView_button_no:
                Intent x = new Intent(SecondQuestion.this, ThirdQuestion.class);
                startActivity(x);
                break;
        }
    }
}
