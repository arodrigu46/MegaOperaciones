package com.example.android.megaoperaciones;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private Resources resources;
    private TextView res;
    private EditText n1, n2;
    private Spinner operaciones;
    private String op[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        //llamados
        res = (TextView) findViewById(R.id.lblResultado);
        n1 = (EditText) findViewById(R.id.txtNum1);
        n2 =(EditText) findViewById(R.id.txtNum2);
        resources = this.getResources();
        //asignamos el cmboperaciones
        operaciones = (Spinner)findViewById(R.id.cmbOperaciones);
        //guardamos el array de strings en un vector.
        op =  resources.getStringArray(R.array.operaciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op);
        operaciones.setAdapter(adapter);
    }
    public boolean validar (){
        if(n1.getText().toString().isEmpty()){
            n1.setError(resources.getString(R.string.mensaje_error_num1));
            return false;
        }
        if (n2.getText().toString().isEmpty()){
            n2.setError(resources.getString(R.string.mensaje_error_num2));
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
