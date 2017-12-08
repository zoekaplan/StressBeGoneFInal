package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class ThirdQuestion extends AppCompatActivity implements View.OnClickListener {

    private ImageView yesButton, noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wireWidgets();
        setOnClickListeners();
    }

    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_yess);
        noButton = (ImageView) findViewById(R.id.imageView_noo);
    }

    private void setOnClickListeners(){
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_yess:
                Intent i = new Intent(ThirdQuestion.this, ThirdAnswer.class);
                startActivity(i);
                break;
            case R.id.imageView_noo:
                i = new Intent(ThirdQuestion.this, FourthQuestion.class);
                startActivity(i);
                break;
        }
    }
}
