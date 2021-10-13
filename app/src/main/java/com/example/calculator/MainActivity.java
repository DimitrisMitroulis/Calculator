package com.example.calculator;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    private Switch TrollSwitch;
    private EditText newNumber, result;
    private TextView operationSign;
    private Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonDot,
            buttonClear, buttonbackSpace, buttonPercent, buttonDiv,
            buttonMult, buttonMinus, buttonPlus, buttonEq,buttonNeg;
    private Double operant1, operant2;
    private String pendingOp;
    private static final String STATE_PENDING_OPERATION = "Pending Operation";
    private static final String STATE_OPERAND1 = "Operant1";

    List<Integer> numbers = new ArrayList<Integer>();
    private boolean ran_buttons = false;


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOp = savedInstanceState.getString(STATE_PENDING_OPERATION);
        operant1 = Double.valueOf(savedInstanceState.getString(STATE_OPERAND1));
        operationSign.setText(pendingOp);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSave: in");
        outState.putString(STATE_PENDING_OPERATION, pendingOp);
        if (operant1 != null) {
            outState.putString(STATE_OPERAND1, String.valueOf(operant1));
        }// saving must be happening before super is called
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

        buttonNeg =findViewById(R.id.buttonNeg);
        buttonClear = findViewById(R.id.buttonClear);
        buttonbackSpace = findViewById(R.id.buttonBackSpace);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMult = findViewById(R.id.buttonMult);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEq = findViewById(R.id.buttonEq);


        operationSign = findViewById(R.id.operation);
        result = findViewById(R.id.ResultText);
        newNumber = findViewById(R.id.NewNumber);

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
            newNumber.append(String.valueOf(numbers.get(Integer.parseInt(b.getText().toString()))));

        };
        //normal listener
        View.OnClickListener listener = view -> {
            Button b = (Button) view;
            newNumber.append(b.getText().toString());
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
                ran_buttons = !ran_buttons;
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
                ran_buttons = !ran_buttons;

            }
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
        }
        else {
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
        //action from negative button
        View.OnClickListener buttonNegativeListener = view -> {
            if(newNumber.getText().length()>0) {

                newNumber.setText(String.valueOf(-Double.parseDouble(String.valueOf(newNumber.getText()))));
            }else if(newNumber.getText().length()==0){
                newNumber.setText("-");

            }
        };
        buttonNeg.setOnClickListener(buttonNegativeListener);

        //action for button Clear
        View.OnClickListener buttonClearListener = view -> {
            newNumber.setText("");
            result.setText("");
            operant1 = 0.0;
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

        View.OnClickListener opListener = view -> {

            Button b = (Button) view;
            operationSign.setText(b.getText());
            pendingOp = b.getText().toString();
            String value = newNumber.getText().toString();
            if (value.length() > 0) {

                //result.setText();
                preformOperation(value, pendingOp);

            }
        };

        buttonEq.setOnClickListener(opListener);
        buttonPercent.setOnClickListener(opListener);
        buttonPlus.setOnClickListener(opListener);
        buttonMinus.setOnClickListener(opListener);
        buttonMult.setOnClickListener(opListener);
        buttonDiv.setOnClickListener(opListener);

    }

    private void preformOperation(String value, String op) {


        if (operant1 == null) {

            try {
                operant1 = Double.valueOf(value);
            } catch (NumberFormatException e) {
                newNumber.setText("");
            }

        } else {
            operant2 = Double.valueOf(value);
            if (pendingOp.equals("=")) {
                pendingOp = op;


            }
            switch (pendingOp) {
                case "=":
                    operant1 = operant2;
                    break;
                case "/":
                    if (operant2 == 0) {
                        operant1 = 0.0;

                    } else {
                        operant1 /= operant2;
                    }
                    break;
                case "*":
                    operant1 *= operant2;
                    break;
                case "-":
                    operant1 -= operant2;
                    break;
                case "+":
                    operant1 += operant2;
                    break;
            }

            result.setText(operant1.toString());
            newNumber.setText("");
        }


    }
}
