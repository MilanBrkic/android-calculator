package com.hfad.comascalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button[] numbers = new Button[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        initializeNumbers();
        text.setText(numbers[9].getText());

    }

    private void initializeNumbers(){
        numbers[0] = (Button) findViewById(R.id.btn0);
        numbers[1] = (Button) findViewById(R.id.btn1);
        numbers[2] = (Button) findViewById(R.id.btn2);
        numbers[3] = (Button) findViewById(R.id.btn3);
        numbers[4] = (Button) findViewById(R.id.btn4);
        numbers[5] = (Button) findViewById(R.id.btn5);
        numbers[6] = (Button) findViewById(R.id.btn6);
        numbers[7] = (Button) findViewById(R.id.btn7);
        numbers[8] = (Button) findViewById(R.id.btn8);
        numbers[9] = (Button) findViewById(R.id.btn9);
        numbers[10] = (Button) findViewById(R.id.btnComma);
    }

    private void addNumberListeners(){
        for (int i = 0;i<numbers.length;i++){
            numbers[i].setOnClickListener(numListener);
        }
    }

    private View.OnClickListener numListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.setText(String.valueOf(v.getId()));
        }
    };

}
