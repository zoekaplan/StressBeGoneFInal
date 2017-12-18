package com.example.zoerebeccakaplan.stressbegone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView introButton;
    private TextToSpeech tts;
    private ToggleButton speak;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setOnClickListeners();

        sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    private void setOnClickListeners() {
        introButton.setOnClickListener(this);

        speak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tts.speak("Feeling Stressed? Click here!", 0, null);
                    editor.putBoolean("hi", true);
                    editor.commit();
                }
                else {
                    editor.putBoolean("hi", false);
                    editor.commit();
                }
            }
        });
    }


    private void wireWidgets() {
        introButton = (ImageView) findViewById(R.id.imageView_intro);

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
       Intent i = new Intent(MainActivity.this, FirstQuestion.class);
        startActivity(i);

    }


}
