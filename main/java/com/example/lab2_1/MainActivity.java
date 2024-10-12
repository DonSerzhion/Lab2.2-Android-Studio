package com.example.lab2_1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lab2_1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ecoef1 = findViewById(R.id.ed1);
        ecoef1.setEnabled(false);
        EditText ecoef2 = findViewById(R.id.ed2);
        ecoef2.setEnabled(false);
        EditText ecoef3 = findViewById(R.id.ed3);
        ecoef3.setEnabled(false);
    }

    @SuppressLint("SetTextI18n")
    public void calculate(View view) {
        EditText e1 = findViewById(R.id.editTextText3);
        double c1;
        double c2;
        double c3;
        double D;
        double x1, x2;
        EditText e2, e3, e4;


        if (e1.getText().toString().matches("-?\\d+"))
        {
            c1 = Double.parseDouble(e1.getText().toString());
            e2 = findViewById(R.id.editTextText4);
            if (e2.getText().toString().matches("-?\\d+")) {
                c2 = Double.parseDouble(e2.getText().toString());
                e3 = findViewById(R.id.editTextText5);
                if (e3.getText().toString().matches("-?\\d+")){
                    c3 = Double.parseDouble(e3.getText().toString());
                    e4 = findViewById(R.id.editTextText6);
                    //e4.setText("Coef 1: " + c1 + ", coef 2: " + c2 + ", coef 3: " + c3);
                    D=c2*c2-4*c1*c3;
                    if(D>0) {
                        x1 = (- c2 + Math.sqrt(D))/2/c1;
                        x2 = (- c2 - Math.sqrt(D))/2/c1;
                        e4.setText("Решение: x1 = " + x1 + ", x2 = " + x2);
                    } else if (D==0) {
                        x1 = -c2/2/c1;
                        e3.setText("Решение: x = " + x1);
                    }
                    else {
                        e4.setText("Решения нет");
                    }
                }else {
                    e3.setText("Введите число");
                }
            } else {
                e2.setText("Введите число");
            }
        } else {
            e1.setText("Введите число");
        }
    }

}