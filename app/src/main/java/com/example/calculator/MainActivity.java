package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Переменная текстбокса
    EditText calcDialogDisplay;

    /**Переменные кнопок*/
    TextView allClear;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView division;
    TextView four;
    TextView five;
    TextView six;
    TextView multiply;
    TextView one;
    TextView two;
    TextView three;
    TextView subtract;
    TextView percent;
    TextView zero;
    TextView equals;
    TextView addition;
    TextView point;
    TextView negative;


    //Результат который заносится в масив для обработки
    ArrayList<Float> result = new ArrayList<Float>();

    //Первое введенное число
    float number1;

    //Второе введенное число
    float number2;

    int currentOperation = 0;
    int nextOperation;

    //Сложение
    final static int ADD = 1;

    //Вычитание
    final static int SUBTRACT = 2;

    //Умножение
    final static int MULTIPLY = 3;

    //Деление
    final static int DIVISION = 4;

    //Равно
    final static int EQUALS = 5;

    //Вычисление процентов
    final static int PERCENT = 6;

    //Запись отрицательного числа
    final static int NEGATIVE = 7;

    //Очистка экрана
    final static int CLEAR = 1;
    final static int DONT_CLEAR = 0;
    int clearCalcDisplay = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcDialogDisplay = (EditText) findViewById(R.id.editText1);
        allClear = (TextView) findViewById(R.id.button15);
        seven = (TextView) findViewById(R.id.button11);
        eight = (TextView) findViewById(R.id.button12);
        nine = (TextView) findViewById(R.id.button13);
        division =(TextView) findViewById(R.id.button18);
        four = (TextView) findViewById(R.id.button7);
        five = (TextView) findViewById(R.id.button8);
        six =(TextView) findViewById(R.id.button9);
        multiply = (TextView) findViewById(R.id.button14);
        one = (TextView) findViewById(R.id.button4);
        two = (TextView) findViewById(R.id.button5);
        three = (TextView) findViewById(R.id.button19);
        subtract = (TextView) findViewById(R.id.button10);
        zero = (TextView) findViewById(R.id.button1);
        equals = (TextView) findViewById(R.id.button3);
        addition = (TextView) findViewById(R.id.button6);
        percent = (TextView) findViewById(R.id.button17);
        point = (TextView) findViewById(R.id.button2);
        negative = (TextView) findViewById(R.id.button16);
        calcDialogDisplay.setKeyListener(DigitsKeyListener.getInstance(true,true));

        registerListeners();
    }

    /*Обработка нажатия на экран*/
    public void registerListeners () {

        seven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("8");

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("9");

            }
        });

        percent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(PERCENT);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(DIVISION);
            }
        });

        allClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcDialogDisplay.setText("");
                number1 = 0;
                number2 = 0;
                result.removeAll(result);
                currentOperation = 0;
                nextOperation = 0;
            }
        });

        four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("4");

            }
        });

        five.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("6");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("0");
            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(MULTIPLY);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("1");

            }
        });

        two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("2");

            }
        });

        three.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append("3");

            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(SUBTRACT);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(EQUALS);

            }
        });

        addition.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcLogic(ADD);

            }
        });

        point.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clearCalcDisplay == CLEAR) {
                    calcDialogDisplay.setText("");
                }
                clearCalcDisplay = DONT_CLEAR;
                calcDialogDisplay.append(".");
            }
        });

        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLogic(NEGATIVE);
            }
        });


    }

    //Функция расчета введенных значений
    private void calcLogic(int operator) {

        result.add(Float.parseFloat(calcDialogDisplay.getText().toString()));

        if (operator != EQUALS) {
            nextOperation = operator;
        }else if (operator == EQUALS){
            nextOperation = 0;
        }

        switch (currentOperation) {

        //Сложение
            case ADD:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 + number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;

        //Вычитание
            case SUBTRACT:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 - number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;

        //Умножение
            case MULTIPLY:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 * number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;
        //Деление
            case DIVISION:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add(number1 / number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;
        //Проценты
            case PERCENT:
                number1 = result.get(0);
                number2 = result.get(1);

                result.removeAll(result);

                result.add((100 / number1) * number2);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;
        //Отрицательное число
            case NEGATIVE:
                number1 = result.get(1);
                number2 = 0;

                result.removeAll(result);

                result.add(number2 - number1);

                calcDialogDisplay.setText(String.format("%.0f", result.get(0)));
                break;
        }

        clearCalcDisplay = CLEAR;
        currentOperation = nextOperation;
        if (operator == EQUALS) {
            number1 = 0;
            number2 = 0;
            result.removeAll(result);
        }
    }


    }
