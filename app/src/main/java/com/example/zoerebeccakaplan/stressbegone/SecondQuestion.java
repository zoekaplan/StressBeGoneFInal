package com.example.zoerebeccakaplan.stressbegone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Locale;

public class SecondQuestion extends AppCompatActivity implements View.OnClickListener{

    private ImageView yesButton, noButton;
    private ToggleButton speak;
    private TextToSpeech tts;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        wireWidgets();
        setOnClickListeners();

        sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        speak.setChecked(sharedPref.getBoolean("hi", false));

    }

    private void setOnClickListeners() {
        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        speak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("hi", isChecked);
                    editor.commit();
                    speak();
            }
        });
    }

    private void speak() {
        if(speak.isChecked()) {
            CountDownTimer c = new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    tts.speak("Are you feeling fatigued?",
                            0, null);
                }
            };
            c.start();
        }
    }

    private void wireWidgets() {
        yesButton = (ImageView) findViewById(R.id.imageView_button_yes);
        noButton = (ImageView) findViewById(R.id.imageView_button_no);

        speak = (ToggleButton) findViewById(R.id.toggleButton_speak);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                tts.setLanguage(Locale.UK);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView_button_yes:
                Intent i = new Intent(SecondQuestion.this, SecondAnswer.class);
                startActivity(i);
                finish();
                break;
            case R.id.imageView_button_no:
                Intent x = new Intent(SecondQuestion.this, ThirdQuestion.class);
                startActivity(x);
                break;
        }
    }


}
