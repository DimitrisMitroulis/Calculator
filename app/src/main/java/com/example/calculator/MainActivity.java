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
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        hideNavBar();

        userInput = findViewById(R.id.NewNumber);
        button0 = findViewById(R.id.button0);
        buttonbackSpace = findViewById(R.id.buttonBackSpace);

        mainVoid();



    }
    private void hideNavBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                );


    }

    private void mainVoid() {
        View.OnClickListener button0Listener = view -> {
            userInput.append("0");

        };
        button0.setOnClickListener(button0Listener);


        View.OnClickListener buttonBackListener = view -> {
            if(userInput.getText().length()>0) {
                //calling constructor for StringBuffer class
                StringBuffer sb = new StringBuffer(String.valueOf(userInput.getText()));
                //invoking the method
                userInput.setText(sb.deleteCharAt(sb.length() - 1));
            }
        };
        buttonbackSpace.setOnClickListener(buttonBackListener);

    }
}
