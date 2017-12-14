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

public class FifthAnswer extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener{

    private ImageView yesButton, noButton;
    private TextToSpeech tts;
    private ToggleButton speak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_answer);

        wireWidgets();
        setOnClickListeners();

        speak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        onInit(0);
                    }
                }
            });

    }




    private void wireWidgets(){
        yesButton = (ImageView) findViewById(R.id.imageView_yes);
        noButton = (ImageView) findViewById(R.id.imageView_no);

        speak = (ToggleButton) findViewById(R.id.toggleButton_speech);

        tts = new TextToSpeech(this, this);
    }

    private void setOnClickListeners() {
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_yes:
                Intent i = new Intent(FifthAnswer.this, SixthQuestion.class);
                startActivity(i);
                break;
            case R.id.imageView_no:
                i = new Intent(FifthAnswer.this, FeelBetter.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.UK);
        tts.speak("Close your eyes. Focus on your breathing.", i, null);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
