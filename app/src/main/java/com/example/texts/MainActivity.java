package com.example.texts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Dictionary;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button strButton;
    EditText responseText;
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        strButton =findViewById(R.id.strButton);
        responseText=findViewById(R.id.responseEditText);
        displayText=findViewById(R.id.textBox);
        strButton.setEnabled(false);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testButton","Typed text: " + responseText.getText());
                displayText.setText(responseText.getText() + ": ");
                submitButton.setEnabled(false);
                strButton.setEnabled(true);
            }
        });
    }

    int iter = 0;
    public void changeStr(View view) {
        Resources res = getResources();
        String[] planets = res.getStringArray(R.array.planets_array);
        displayText.setText(displayText.getText()+" "+ planets[iter%planets.length]);
        Log.i("display","" + displayText.getText());
        iter++;
    }
}
