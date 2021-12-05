package com.example.calculator;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    private Switch TrollSwitch;
    private EditText newNumberField;
    private EditText resultField;
    private Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonDot,
            buttonClear, buttonPercent, buttonDiv,
            buttonMult, buttonMinus, buttonPlus, buttonEq;
    private ImageButton buttonbackSpace;


    private static final String STATE_OPERAND1 = "Operant1";

    //for random switch
    List<Integer> numbers = new ArrayList<Integer>();
    private boolean ran_buttons = false;
    //for calculation
    private String calculation = "";
    private String num1 = "";
    private String num2 = "";
    private String operator;



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSave: in");

        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSave: out");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideNavBar();

        //assigning buttons to the elements on the screen
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
        //buttonPercent = findViewById(R.id.buttonPercent);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMult = findViewById(R.id.buttonMult);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEq = findViewById(R.id.buttonEq);


        resultField = findViewById(R.id.ResultText);
        newNumberField = findViewById(R.id.NewNumber);

        TrollSwitch = findViewById(R.id.trollSwitch);
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

        //creating listener so everytime a button gets clicked, it will show the corresponding element from the array(a random one)
        // instead of the actual button that is represented
        //e.g you press number 6 and instead of showing 6 it shows the 6th element from the array
        View.OnClickListener trollListener = view -> {
            Button b = (Button) view;

            newNumberField.append(String.valueOf(numbers.get(Integer.parseInt(b.getText().toString()))));

            try {
                //checks if current char and last was operator,if yes replace the new with the old
                if (isOperator(b.getText().toString()) && isOperator(calculation.substring(calculation.length() - 1))) {

                    StringBuffer sb = new StringBuffer(calculation);
                    calculation = String.valueOf(sb.deleteCharAt(sb.length() - 1));

                }
            } catch (Exception e) {
                Log.d(TAG, "mainVoid: Exception");
            }

            newNumberField.setText(calculation + String.valueOf(numbers.get(Integer.parseInt(b.getText().toString()))));

            calculation = String.valueOf(newNumberField.getText());
            Expression exp = new Expression(calculation);
            if(!String.valueOf(exp.calculate()).equals("NaN")){
                resultField.setText(String.valueOf(exp.calculate())); }

        };

        //normal listener
        View.OnClickListener listener = view -> {
            Button b = (Button) view;

            calculation = String.valueOf(newNumberField.getText());
            try {
                //checks if current char and last was operator,if yes replace the new with the old
                if (isOperator(b.getText().toString()) && isOperator(calculation.substring(calculation.length() - 1))) {

                    StringBuffer sb = new StringBuffer(calculation);
                    calculation = String.valueOf(sb.deleteCharAt(sb.length() - 1));

                }
            } catch (Exception e) {
                Log.d(TAG, "mainVoid: Exception");
            }

            newNumberField.setText(calculation + b.getText().toString());

            calculation = String.valueOf(newNumberField.getText());
            Expression exp = new Expression(calculation);
            if(!String.valueOf(exp.calculate()).equals("NaN")){
                resultField.setText(String.valueOf(exp.calculate())); }

        };

        View.OnClickListener SwitchListener = view -> {

            if (!ran_buttons) {

                button0.setOnClickListener(null);
                button1.setOnClickListener(null);
                button2.setOnClickListener(null);
                button3.setOnClickListener(null);
                button4.setOnClickListener(null);
                button5.setOnClickListener(null);
                button6.setOnClickListener(null);
                button7.setOnClickListener(null);
                button8.setOnClickListener(null);
                button9.setOnClickListener(null);


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
            } else {

                button0.setOnClickListener(null);
                button1.setOnClickListener(null);
                button2.setOnClickListener(null);
                button3.setOnClickListener(null);
                button4.setOnClickListener(null);
                button5.setOnClickListener(null);
                button6.setOnClickListener(null);
                button7.setOnClickListener(null);
                button8.setOnClickListener(null);
                button9.setOnClickListener(null);

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
            ran_buttons = !ran_buttons;
        };

        TrollSwitch.setOnClickListener(SwitchListener);


        if (ran_buttons) {
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
        } else {
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
            newNumberField.setText("");
            resultField.setText("");
            num1 = "";
            num2 = "";
            calculation = "";
            operator = null;

        };

        //action for button Back
        View.OnClickListener buttonBackListener = view -> {
            if (newNumberField.getText().length() > 0) {
                //calling constructor for StringBuffer class
                StringBuffer sb = new StringBuffer(String.valueOf(calculation));
                calculation = String.valueOf(sb.deleteCharAt(sb.length() - 1));
                newNumberField.setText(calculation);

                Expression exp = new Expression(calculation);
                if(!String.valueOf(exp.calculate()).equals("NaN")){
                    resultField.setText(String.valueOf(exp.calculate())); }

            }
        };

        //listener for Equals Button
        View.OnClickListener EqualsListener = view -> {
            if (resultField != null) {
                //newNumberField.setText(resultField.getText().toString());
               //check if a number is .0 then turn it into integer
                if(isPointZero(resultField.getText().toString())){
                    //newNumberField.setText(Integer.parseInt(resultField.getText().toString()));
                    StringBuffer sb = new StringBuffer(resultField.getText());
                    String res = String.valueOf(sb.deleteCharAt(sb.length() - 1));
                    res = String.valueOf(sb.deleteCharAt(sb.length() - 1));
                    newNumberField.setText(res);
                }else{
                    newNumberField.setText(resultField.getText().toString());
                }
                calculation = resultField.getText().toString();
                resultField.setText("");


            }
        };


        View.OnClickListener opListener = view -> {
            Button b = (Button) view;
            //operationSign.setText(b.getText());
            //calculation = calculation + operationSign;


        };

        //buttonPercent.setOnClickListener(listener);
        buttonEq.setOnClickListener(EqualsListener);
        buttonClear.setOnClickListener(buttonClearListener);
        buttonbackSpace.setOnClickListener(buttonBackListener);

        buttonPlus.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonMult.setOnClickListener(listener);
        buttonDiv.setOnClickListener(listener);


    }

    private boolean isOperator(String text) {
        return text.matches("[-+*/]");
    }
    private boolean isPointZero(String text) {
        return text.matches("([0-9]+[.]+0)");
    }

    private String preformOperation() {
        switch (operator) {
            case "+":
                return String.valueOf((Float.parseFloat(num1) + Float.parseFloat(num2)));
            case "-":
                return String.valueOf((Float.parseFloat(num1) - Float.parseFloat(num2)));

            case "*":
                return String.valueOf((Float.parseFloat(num1) * Float.parseFloat(num2)));

            case "/":
                return String.valueOf((Float.parseFloat(num1) / Float.parseFloat(num2)));
        }
        return "";
    }


}

