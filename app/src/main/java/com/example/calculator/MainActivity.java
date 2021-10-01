package com.example.calculator;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    private EditText newNumber, result;
    private TextView operation;
    private Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonDot,
            buttonClear, buttonbackSpace, buttonPercent, buttonDiv,
            buttonMult, buttonMinus, buttonPlus, buttonEq;
    //private Button[] buttons = new Button[10];
    List<Integer> numbers = new ArrayList<Integer>();
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideNavBar();



        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);


        buttonClear = findViewById(R.id.buttonClear);
        buttonbackSpace = findViewById(R.id.buttonBackSpace);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMult = findViewById(R.id.buttonMult);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEq = findViewById(R.id.buttonEq);


        operation = findViewById(R.id.operation);
        result = findViewById(R.id.ResultText);
        newNumber = findViewById(R.id.NewNumber);


        mainVoid();


    }




    private void hideNavBar() {
        getSupportActionBar().hide();
        this.getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                );
    }

    private void mainVoid() {
        //shuffles an array of numbers
        for (int i = 0; i <= 9; ++i) numbers.add(i);
        Collections.shuffle(numbers);

        //creating listener so everytime a button gets clicked, it will sho the corresponding element from the array(a random one)
        // instead of the actual button that is represented
        View.OnClickListener listener0 = view -> {
            Button b = (Button) view;
            newNumber.append(String.valueOf(numbers.get(Integer.parseInt(b.getText().toString()))));

        };
        View.OnClickListener listener = view -> {
            Button b = (Button) view;
            newNumber.append(b.getText().toString());
        };



        button0.setOnClickListener(listener0);
        button1.setOnClickListener(listener0);
        button2.setOnClickListener(listener0);
        button3.setOnClickListener(listener0);
        button4.setOnClickListener(listener0);
        button5.setOnClickListener(listener0);
        button6.setOnClickListener(listener0);
        button7.setOnClickListener(listener0);
        button8.setOnClickListener(listener0);
        button9.setOnClickListener(listener0);
        buttonDot.setOnClickListener(listener);


        //action for button Clear
        View.OnClickListener buttonClearListener = view -> {
            newNumber.setText("");
        };
        buttonClear.setOnClickListener(buttonClearListener);

        //action for button Back
        View.OnClickListener buttonBackListener = view -> {
            if (newNumber.getText().length() > 0) {
                //calling constructor for StringBuffer class
                StringBuffer sb = new StringBuffer(String.valueOf(newNumber.getText()));
                //invoking the method
                newNumber.setText(sb.deleteCharAt(sb.length() - 1));
            }
        };
        buttonbackSpace.setOnClickListener(buttonBackListener);

    }
}
