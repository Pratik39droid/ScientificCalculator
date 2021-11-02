package com.example.scientificcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculation);
        display = findViewById(R.id.displayEditText);

    }

    private void updateText(String stringTodAdd) {
        String oldString = display.getText().toString();
        int cursorPosition = display.getSelectionStart();
        String leftString = oldString.substring(0, cursorPosition);
        String rightString = oldString.substring(cursorPosition);

//        oldString = 8, stringTodAdd = 1 == 81
        display.setText(String.format("%s%s%s", leftString, stringTodAdd, rightString));
        display.setSelection(cursorPosition + stringTodAdd.length());

//        prevent the default keyboard popping up
        display.setShowSoftInputOnFocus(false);


    }

    public void zero(View view){
        updateText(getResources().getString(R.string.zeroText));
    }

   public void one(View view){
       updateText(getResources().getString(R.string.oneText));
    }

   public void two(View view){
       updateText(getResources().getString(R.string.twoText));
    }

   public void three(View view){
       updateText(getResources().getString(R.string.threeText));
    }

   public void four(View view){
       updateText(getResources().getString(R.string.fourText));
    }

   public void five(View view){
       updateText(getResources().getString(R.string.fiveText));
    }

   public void six(View view){
       updateText(getResources().getString(R.string.sixText));
    }

   public void seven(View view){
       updateText(getResources().getString(R.string.sevenText));
    }

   public void eight(View view){
       updateText(getResources().getString(R.string.eightText));
    }

   public void nine(View view){
       updateText(getResources().getString(R.string.nineText));
    }

   public void parenthesisOpen(View view){
       updateText(getResources().getString(R.string.parenthesesOpenText));
    }

   public void parenthesisClose(View view){
       updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void decimal(View view){
        updateText(getResources().getString(R.string.decimalText));
    }

    public void add(View view){
        updateText(getResources().getString(R.string.addText));
    }

    public void subtract(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void multiply(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divide(View view){
        updateText(getResources().getString(R.string.divideText));
    }


    public void sin(View view){
        updateText("sin(");
    }


    public void cos(View view){
        updateText("cos(");
    }


    public void tan(View view){
        updateText("tan(");
    }


    public void sinIn(View view){
        updateText("arcsin(");
    }


    public void cosIn(View view){
        updateText("arccos(");
    }


    public void tanIn(View view){
        updateText("arctan(");
    }


    public void log(View view){
        updateText(	"log10(");
    }


    public void naturalLog(View view){
        updateText("ln(");
    }


    public void root(View view){
        updateText("sqrt(");
    }


    public void square(View view){
        updateText("^(2)");
    }


    public void fibonacci(View view){
        updateText(	"Fib(");
    }


    public void pi(View view){
        updateText("pi(");
    }


    public void absolute(View view){
        updateText("abs(");
    }


    public void degree(View view){
        updateText("deg(");
    }


    public void radian(View view){
        updateText("rad(");
    }


    public void XpowerY(View view){
        updateText("^(");
    }



    public void clear(View view){
       display.setText("");
       previousCalculation.setText("");
    }

   public void equal(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression expression = new Expression(userExp);
       String result = String.valueOf(expression.calculate());

        display.setText(result);
//        shifting cursor to  the end
        display.setSelection(result.length());
    }

   public void backspace(View view){
      int cursorPosition = display.getSelectionStart();
      int textLength = display.getText().length();

      if (cursorPosition != 0 && textLength != 0){
          SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
          selection.replace(cursorPosition - 1,cursorPosition,  "" );
          display.setText(selection);
          display.setSelection(cursorPosition-1);
      }
    }



}