package com.example.android.megaoperaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private TextView res;
    private EditText n1, n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        //llamados
        res = (TextView) findViewById(R.id.lblResultado);
        n1 = (EditText) findViewById(R.id.txtNum1);
        n2 =(EditText) findViewById(R.id.txtNum2);



    }
    public boolean validar (){
        if(n1.getText().toString().isEmpty()){
            n1.setError("Digite el número 1");
            return false;
        }
        if (n2.getText().toString().isEmpty()){
            n2.setError("Digite el número 2");
            return false;
        }
        return true;
    }
    public void calcular(View v){
        if (validar()) {
            int num1 = Integer.parseInt(n1.getText().toString());
            int num2 = Integer.parseInt(n2.getText().toString());
            int resultado = num1 + num2;
            res.setText(String.valueOf(resultado));
        }

    }
    public void borrar(View v){
        res.setText("");
        n1.setText("");
        n2.setText("");
        n1.requestFocus();
    }
}
