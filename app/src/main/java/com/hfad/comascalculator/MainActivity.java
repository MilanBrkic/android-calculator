package com.hfad.comascalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button[] numbers = new Button[11];
    private int firstNum;
    private int secondNum;
    private char operation ='#';
    Button[] operations;
    final int PINK = 0xFFFF80C0;
    final int YELLOW = 0xFFFFEB3B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        initalize();

    }

    private void initalize(){
        initializeNumbers();
        initializeClear();
        initializeOperations();
        initializeEquals();
    }

    private void initializeEquals(){
        View.OnClickListener equalsOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation!='#'){
                    if(!text.getText().toString().contains(".")){
                        secondNum = Integer.parseInt(String.valueOf(text.getText()));
                        text.setText(String.valueOf(firstNum) + String.valueOf(operation) + String.valueOf(secondNum));
                        revertColors();
                    }

                }
            }
        };

        Button equals = (Button) findViewById(R.id.btnEqual);
        equals.setOnClickListener(equalsOnClickListener);
    }

    private void revertColors(){
        for(int i = 0;i<operations.length;i++){
            operations[i].setTextColor(PINK);
            operations[i].setBackgroundColor(YELLOW);
        }
    }

    private void initializeOperations(){
        View.OnClickListener operationOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                if(text.getText()!=""){
                    operation =btn.getText().charAt(0);
                    if(!text.getText().toString().contains(".")){
                        firstNum = Integer.parseInt(String.valueOf(text.getText()));
                    }
                }
                btn.setTextColor(YELLOW);
                btn.setBackgroundColor(PINK);
            }
        };

        operations = new Button[3];//witout percent and dived
        operations[0] = (Button) findViewById(R.id.btnMinus);
        operations[1] = (Button) findViewById(R.id.btnPlus);
        operations[2] = (Button) findViewById(R.id.btnMulti);
//        operations[3] = (Button) findViewById(R.id.btnDived);
//        operations[4] = (Button) findViewById(R.id.btnPercent);
        for(int i = 0;i<operations.length;i++){
            operations[i].setOnClickListener(operationOnClickListener);
        }
    }

    private void initializeClear(){
        View.OnClickListener clearListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("");
            }
        };

        Button clear = (Button) findViewById(R.id.btnClear);
        clear.setOnClickListener(clearListener);
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

        addNumberListeners();
    }

    private void addNumberListeners(){

        View.OnClickListener numListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation!='#'){
                    text.setText("");
                }

                Button btn = (Button) v;
                text.append(String.valueOf(btn.getText()));
            }
        };

        for (int i = 0;i<numbers.length;i++){
            numbers[i].setOnClickListener(numListener);
        }
    }





}
