package com.cornez.calculator;

/*
* Programmer: Candace Keith
* Date: 2/26/17
* Lab: 11
* Purpose: To build a working calculator using Android Studio
*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    private TextView mNumberDisplay;
    private SimpleExpression mExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberDisplay = (TextView) findViewById(R.id.textView1);

        mExpression = new SimpleExpression();
    }//End onCreate

    public void goAC (View view){
        mExpression.clearOperands();
        mNumberDisplay.setText("0");
    }//End goAC

    public void goOperand (View view){
        String val = (String) mNumberDisplay.getText();
        String digit = (String) view.getContentDescription();
        if (val.charAt(0) == '0')
            mNumberDisplay.setText(digit);
        else
            mNumberDisplay.setText((String) mNumberDisplay.getText()
                    + digit.charAt(0));
    }//End goOperand

    public void goOperator (View view) {
        String operator = (String) view.getContentDescription();
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperand1((int)
                Integer.parseInt(val.toString()));
        }//End try
        catch (NumberFormatException e){
            mExpression.setOperand1(0);
        }//End catch
        mNumberDisplay.setText("0");
        mExpression.setOperator(operator);
    }//End goOperator

    //WHEN THE = BUTTON IS CLICKED, COMPUTE AND DISPLAY THE VALUE
    public void goCompute (View view){
        try{
            String val = (String) mNumberDisplay.getText();
            mExpression.setOperand2((int)
                Integer.parseInt(val.toString()));
        }//End try
        catch (NumberFormatException e){
            mExpression.setOperand2(0);
        }//End catch
        mNumberDisplay.setText(mExpression.getValue().toString());
    }//End goCompute


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }//End boolean onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }//End if
        return super.onOptionsItemSelected(item);
    }//End boolean onOptionsItemSelected
}//End class MyActivity
