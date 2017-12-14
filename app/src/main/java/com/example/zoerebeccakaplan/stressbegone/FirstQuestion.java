package com.example.zoerebeccakaplan.stressbegone;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Locale;

public class FirstQuestion extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    private ImageView noButton, yesButton;
    private ToggleButton speak;
    private TextToSpeech tts;

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

        speak = (ToggleButton) findViewById(R.id.toggleButton_speech);

        tts = new TextToSpeech(this, this);
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

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.UK);
        tts.speak("Do you have a headache?", i, null);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
    }
}
