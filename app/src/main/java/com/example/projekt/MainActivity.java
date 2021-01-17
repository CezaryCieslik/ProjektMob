package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAX_NUMBER = 1000;
    public static final Random RANDOM = new Random();
    private TextView msgA;
    private EditText numberEntered;
    private Button validate;
    private int numberTries, numberToFind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgA = (TextView) findViewById(R.id.msg);
        numberEntered = (EditText) findViewById(R.id.numberEntered);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
        newGame();
    }

    @Override
    public void onClick(View view){
        if (view == validate){
            validate();
        }
    }

    private void validate(){
        int n = Integer.parseInt((numberEntered.getText().toString()));
        numberTries++;

        if (n == numberToFind){
            Toast.makeText(this, "Brawo! Trafiles" + numberToFind + "w" + numberTries
                    + "probach", Toast.LENGTH_SHORT).show();
            newGame();
        } else if (n > numberToFind){
            msgA.setText(R.string.too_high);
        } else if (n < numberToFind){
            msgA.setText(R.string.too_low);
        }
    }

    private void newGame(){
        numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
        msgA.setText(R.string.start_msg);
        numberEntered.setText("");
        numberTries = 0;
    }
}