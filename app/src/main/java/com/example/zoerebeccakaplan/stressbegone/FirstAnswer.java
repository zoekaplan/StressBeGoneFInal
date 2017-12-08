package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;



public class FirstAnswer extends AppCompatActivity implements View.OnClickListener {
    private ImageView answer, yesButton, noButton;
    private ArrayList<Integer> answerOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_answer);


        wireWidgets();
        setOnClickListeners();
        answerOptions();
        answerSelect();
    }


    private void answerSelect() {
        double doub = Math.random() * answerOpt.size();
        int ans = (int) doub;
        answer.setImageResource(answerOpt.get(ans));
    }



    private void answerOptions() {
        answerOpt = new ArrayList<Integer>();
        answerOpt.add(R.drawable.breathe_answer);
        answerOpt.add(R.drawable.advil_answer);

    }

    private void setOnClickListeners() {
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_yes);
        noButton = (ImageView) findViewById(R.id.imageView_no);
        answer = (ImageView) findViewById(R.id.imageView_answer);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_no:
                Intent i = new Intent(FirstAnswer.this, FeelBetter.class);
                startActivity(i);
                break;
            case R.id.imageView_yes:
                i = new Intent(FirstAnswer.this, SecondQuestion.class);
                startActivity(i);
                break;
        }

    }
}
