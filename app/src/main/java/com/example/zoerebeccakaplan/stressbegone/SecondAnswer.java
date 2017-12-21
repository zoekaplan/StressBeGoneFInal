package com.example.zoerebeccakaplan.stressbegone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Locale;

public class SecondAnswer extends AppCompatActivity implements View.OnClickListener {

    private Button clickHere, noHere, waitHere;
    private ImageView yesButton, noButton;
    private ToggleButton speak;
    private TextToSpeech tts;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        clickHere.setOnClickListener(this);
        noHere.setOnClickListener(this);
        waitHere.setOnClickListener(this);

        speak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("hi", isChecked);
                    editor.commit();
                    speak();
            }
        });

        sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    private void speak() {
        if(speak.isChecked()) {
            CountDownTimer c = new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    tts.speak("Here are some Zumba video links!", 0, null);
                }
            };
            c.start();
        }
    }

    private void wireWidgets() {
        clickHere = (Button) findViewById(R.id.button_click_here);
        noHere = (Button) findViewById(R.id.button_no_click_here);
        waitHere = (Button) findViewById(R.id.button_wait_click_here);

        yesButton = (ImageView) findViewById(R.id.imageView_yess);
        noButton = (ImageView) findViewById(R.id.imageView_no);

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
        switch (view.getId()){
            case R.id.imageView_no:
                Intent i = new Intent(SecondAnswer.this, FeelBetter.class);
                startActivity(i);
                finish();
                break;
            case R.id.imageView_yess:
                Intent x = new Intent(SecondAnswer.this, ThirdQuestion.class);
                startActivity(x);
                finish();
                break;
            case R.id.button_click_here:
                Intent a = new Intent(android.content.Intent.ACTION_VIEW);
                a.setData(Uri.parse("https://www.youtube.com/watch?v=7OBUSTrZOMk&t=2s"));
                startActivity(a);
                break;
            case R.id.button_no_click_here:
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse("https://www.youtube.com/watch?v=tj9d6aBOzDo&t=2s"));
                startActivity(b);
                break;
            case R.id.button_wait_click_here:
                Intent c = new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse("https://www.youtube.com/watch?v=brb738C4Rj4"));
                startActivity(c);
                break;
        }

    }
}
