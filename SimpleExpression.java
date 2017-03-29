package com.cornez.calculator;

import android.content.Intent;


/*
* Programmer: Candace Keith
* Date: 2/26/17
* Lab: 11
* Purpose: To build a working calculator using Android Studio
*/

public class SimpleExpression {
    private Integer mOperand1;// declare mOperand1 an integer
    private Integer mOperand2;// declare mOperand2 an integer
    private String mOperator;// declare mOperator string
    private Integer mValue;// declare mValue an integer

    public SimpleExpression() {
        mOperand1 = 0; //set mOperand1 to 0
        mOperand2 = 0; //set mOperand2 to 0
        mOperator = "+"; //set mOperator to +
        mValue = 0; //set mValue to 0
    }//end SimpleExpression

    public void setOperand1(int v) {
        mOperand1 = v;
    }

    public int getOperand1() {
        return mOperand1;
    }

    public void setOperand2(int v) {
        mOperand2 = v;
    }

    public int getOperand2() {
        return mOperand2;
    }

    public void setOperator(String s) {
        mOperator = s;
    }

    public String getOperator() {
        return mOperator;
    }

    public Integer getValue() {
        computeValue();
        return mValue;
    }//End getValue

    /*
     * Clears the operands within an expression
     */
    public void clearOperands() {
        mOperand1 = 0;
        mOperand2 = 0;
    }//End clearOperands

    /*
     * Computes the integer value of the expression
     */
    private void computeValue() {
        mValue = 0;
        if (mOperator.contentEquals("+"))
            mValue = mOperand1 + mOperand2;
        else if (mOperator.contentEquals("-"))
            mValue = mOperand1 - mOperand2;
        else if (mOperator.contentEquals("x"))
            mValue = mOperand1 * mOperand2;
        else if (mOperator.contentEquals("/") && mOperand2 != 0)
            mValue = mOperand1 / mOperand2;
        else
            mValue = mOperand1 % mOperand2;
    }//End computeValue
}//End class SimpleExpression
