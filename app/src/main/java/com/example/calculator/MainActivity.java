package com.example.calculator;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
            buttonClear, buttonbackSpace, buttonPercent, buttonDiv,
            buttonMult, buttonMinus, buttonPlus, buttonEq;


    private static final String STATE_OPERAND1 = "Operant1";

    //for random switch
    List<Integer> numbers = new ArrayList<Integer>();
    private boolean ran_buttons = false;
    //for calculation
    private String calculation = "";
    private String num1 = "";
    private String num2 = "";
    private Float result;
    private String operator;
    private String prevChar = "";
    private String all;


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSave: in");

//        if (operant1 != null) {
//            outState.putString(STATE_OPERAND1, String.valueOf(operant1));
//        }// saving must be happening before super is called
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

        };

        //normal listener
        View.OnClickListener listener = view -> {
            Button b = (Button) view;

            all = String.valueOf(newNumberField.getText());

            if (isOperator(b.getText().toString())) {
                try {
                    if (isOperator(all.substring(all.length() - 1))) {
                        StringBuffer sb = new StringBuffer(all);
                        all = String.valueOf(sb.deleteCharAt(sb.length() - 1));
                        newNumberField.setText(all + b.getText().toString());
                    }
                } catch (Exception e) {
                    Log.d(TAG, "mainVoid: Exception");
                }
            }

            newNumberField.setText(all + b.getText().toString());

            all = String.valueOf(newNumberField.getText());
            Expression exp = new Expression(all);
            String result = String.valueOf(exp.calculate());
            resultField.setText(result);

            Log.d(TAG, "num1: " + num1 + " operator " + operator + " num2 " + num2 + " all " + all);
            //prevChar = b.getText().toString();
        };

        View.OnClickListener SwitchListener = view -> {

            if (!ran_buttons) {
                Log.d(TAG, "mainVoid: Activated");
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
                Log.d(TAG, "mainVoid: Deactivated");
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
            result = Float.valueOf(0);
            operator = null;
            prevChar = "";

        };

        buttonClear.setOnClickListener(buttonClearListener);

        //action for button Back
        View.OnClickListener buttonBackListener = view -> {
            if (newNumberField.getText().length() > 0) {
                //calling constructor for StringBuffer class
                StringBuffer sb = new StringBuffer(String.valueOf(all));
                all = String.valueOf(sb.deleteCharAt(sb.length() - 1));
                newNumberField.setText(all);

                Expression exp = new Expression(all);
                String result = String.valueOf(exp.calculate());
                resultField.setText(result);

            }
        };
        buttonbackSpace.setOnClickListener(buttonBackListener);

//        View.OnClickListener opListener = view -> {
//
//            Button b = (Button) view;
//            operationSign.setText(b.getText());
//            pendingOp = b.getText().toString();
//            String value = newNumber.getText().toString();
//            if (value.length() > 0) {
//
//                //result.setText();
//                preformOperation(value, pendingOp);
//
//            }
//        };

        View.OnClickListener opListener = view -> {
            Button b = (Button) view;
            //operationSign.setText(b.getText());
            //calculation = calculation + operationSign;


        };

        View.OnClickListener EqualsListener = view -> {
            if (resultField != null) {
                newNumberField.setText(resultField.getText().toString());
                resultField.setText("");
                all = resultField.getText().toString();
            }
        };

        buttonEq.setOnClickListener(EqualsListener);

        //buttonPercent.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonMult.setOnClickListener(listener);
        buttonDiv.setOnClickListener(listener);


    }

    private boolean isOperator(String text) {
        return text.matches("[-+*/]");
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

