package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Locale;


public class FirstAnswer extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    private ImageView answer, yesButton, noButton;
    private ArrayList<Integer> answerOpt;
    private ToggleButton speak;
    private TextToSpeech tts;

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

        speak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    onInit(0);
                }
            }
        });
    }


    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_yess);
        noButton = (ImageView) findViewById(R.id.imageView_no);
        answer = (ImageView) findViewById(R.id.imageView_answer);

        speak = (ToggleButton) findViewById(R.id.toggleButton_speak);
        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_no:
                Intent i = new Intent(FirstAnswer.this, FeelBetter.class);
                startActivity(i);
                break;
            case R.id.imageView_yess:
                i = new Intent(FirstAnswer.this, SecondQuestion.class);
                startActivity(i);
                break;
        }

    }

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.UK);
        tts.speak("Take an advil.", i, null);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
