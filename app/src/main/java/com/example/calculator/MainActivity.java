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

    List<Integer> numbers = new ArrayList<Integer>();
    private boolean ran_buttons =false;


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
        View.OnClickListener trollListener = view -> {
            Button b = (Button) view;
            newNumber.append(String.valueOf(numbers.get(Integer.parseInt(b.getText().toString()))));

        };
        View.OnClickListener listener = view -> {
            Button b = (Button) view;
            newNumber.append(b.getText().toString());
        };


    if(ran_buttons){
        button0.setOnClickListener(trollListener);
        button1.setOnClickListener(trollListener);
        button2.setOnClickListener(trollListener);
        button3.setOnClickListener(trollListener);
        button4.setOnClickListener(trollListener);
        button5.setOnClickListener(trollListener);
        button6.setOnClickListener(trollListener);
        button7.setOnClickListener(trollListener);
        button8.setOnClickListener(trollListener);
        button9.setOnClickListener(trollListener);
    }else{
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);

    }

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
