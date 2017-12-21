package com.example.zoerebeccakaplan.stressbegone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Locale;

public class FirstQuestion extends AppCompatActivity implements View.OnClickListener {

    private ImageView noButton, yesButton;
    private ToggleButton speak;
    private TextToSpeech tts;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wireWidgets();
        setOnClickListeners();

        sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        speak.setChecked(sharedPref.getBoolean("hi", false));


    }

    private void speak() {
        if(speak.isChecked()){
            CountDownTimer c = new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    tts.speak("Do you have a headache?", 0, null);
                }
            };
            c.start();

        }
    }

    private void wireWidgets() {
        noButton = (ImageView) findViewById(R.id.imageView_no);
        yesButton = (ImageView) findViewById(R.id.imageView_yess);

        speak = (ToggleButton) findViewById(R.id.toggleButton_speech);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                    tts.setLanguage(Locale.UK);
            }
        });
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

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.imageView_no:
                Intent i = new Intent(FirstQuestion.this, SecondQuestion.class);
                startActivity(i);
                finish();
                break;
            case R.id.imageView_yess:
                Intent x = new Intent(FirstQuestion.this, FirstAnswer.class);
                startActivity(x);
                finish();
                break;
        }
    }



}
