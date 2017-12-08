package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class FirstQuestion extends AppCompatActivity implements View.OnClickListener {

    private ImageView noButton;
    private ImageView yesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wireWidgets();
        setOnClickListeners();

    }

    private void wireWidgets() {
        noButton = (ImageView) findViewById(R.id.imageView_no);
        yesButton = (ImageView) findViewById(R.id.imageView_yess);
    }

    private void setOnClickListeners() {
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.imageView_no:
                Intent i = new Intent(FirstQuestion.this, SecondQuestion.class);
                startActivity(i);
                break;
            case R.id.imageView_yess:
                Intent x = new Intent(FirstQuestion.this, FirstAnswer.class);
                startActivity(x);
                break;
        }
    }
}
