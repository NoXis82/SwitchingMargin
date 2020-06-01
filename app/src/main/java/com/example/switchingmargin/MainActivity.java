package com.example.switchingmargin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        Button button = findViewById(R.id.button);
        final Spinner spinnerLanguage = findViewById(R.id.spinner_language);
        final Spinner spinnerMargin = findViewById(R.id.spinner_margin);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (spinnerLanguage.getSelectedItemPosition()) {
                    case 0:
                        changeLocale("ru");
                        break;
                    case 1:
                        changeLocale("en");
                        break;
                    case 2:
                        changeLocale("de");
                        break;
                }
                switch (spinnerMargin.getSelectedItemPosition()) {
                    case 0:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_SMALL);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MIDDLE);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this, Utils.THEME_MAJOR);
                        break;
                }
            }
        });
    }

    public void changeLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext()
                .getResources()
                .getDisplayMetrics());
        recreate();
    }

}
