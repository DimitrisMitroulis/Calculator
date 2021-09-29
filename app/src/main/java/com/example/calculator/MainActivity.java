package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button button0,buttonbackSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.editText);
        button0 = findViewById(R.id.button0);
        buttonbackSpace = findViewById(R.id.buttonBackSpace);
        mainVoid();


    }

    private void mainVoid() {
        View.OnClickListener button0Listener = view -> {
            userInput.append("0");

        };
        button0.setOnClickListener(button0Listener);


        View.OnClickListener buttonBackListener = view -> {
            String input = String.valueOf(userInput.getText());
            //calling constructor for StringBuffer class
            StringBuffer sb= new StringBuffer(input);
            //invoking the method
            sb.deleteCharAt(sb.length()-1);
            userInput.setText(sb);
        };
        buttonbackSpace.setOnClickListener(buttonBackListener);

    }
}
