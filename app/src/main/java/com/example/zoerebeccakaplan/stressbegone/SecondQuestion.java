package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Locale;

public class SecondQuestion extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    private ImageView yesButton, noButton;
    private ToggleButton speak;
    private TextToSpeech tts;

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

        speak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    onInit(0);
                }
            }
        });
    }

    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_button_yes);
        noButton = (ImageView) findViewById(R.id.imageView_button_no);

        speak = (ToggleButton) findViewById(R.id.toggleButton_speak);

        tts = new TextToSpeech(this, this);
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

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.UK);
        tts.speak("Are you feeling fatigued?", i, null);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
