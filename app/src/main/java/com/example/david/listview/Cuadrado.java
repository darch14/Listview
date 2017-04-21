package com.example.david.listview;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Cuadrado extends AppCompatActivity {
    private EditText val;
    private Resources res;
    private Bundle b;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        res=this.getResources();
        i=new Intent(this,Resultados.class);
        b=new Bundle();
        val=(EditText)findViewById(R.id.txtValorCuadrado);
    }

    public void Calcular_cuadrado(View v){
        if (validar()){
            int resultado,a;
            String tipo,dato,valor;
            valor=val.getText().toString().trim();
            a=Integer.parseInt(valor);
            tipo=res.getString(R.string.tipo_cuadrado);
            resultado=a*a;
            dato=res.getString(R.string.lado)+": "+valor;

            Operacion o=new Operacion(tipo,dato,resultado);
            o.guardar();
            b.putString("Resultado",String.valueOf(resultado));
            b.putString("Tipo",res.getString(R.string.area));
            b.putString("Figura",res.getString(R.string.cuadrado));
            Limpiar_cuadrado();
            i.putExtras(b);
            startActivity(i);
        }
    }

    public void borrar(View v){
        Limpiar_cuadrado();
    }

    public void Limpiar_cuadrado(){
        val.setText("");
        val.requestFocus();
    }

    public boolean validar(){
        if (val.getText().toString().isEmpty()){
            val.setError(res.getString(R.string.error));
            return false;
        }
        return true;
    }
}
