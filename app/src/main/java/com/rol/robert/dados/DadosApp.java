package com.rol.robert.dados;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class DadosApp extends AppCompatActivity {
    private TextView r,m;
    private EditText j;
    public int x=0;
    Menu menu;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_app);
        r=(TextView)findViewById(R.id.Resultado);
        j=(EditText)findViewById(R.id.Nombre);
        m=(TextView)findViewById(R.id.master);

    }

    public void Duelo(View view) throws IOException, InterruptedException {
        menu = new Menu();
        String n;
        n=this.nombre(view);

        menu.mandarTirada(this.x,n,view,this);

    }

    public void Simple(View view) {
        menu = new Menu();
        String n;
        n=this.nombre(view);
       menu.mandarTiradaSimple(this.x,n,this);
        String resultado = String.valueOf(this.x);
        r.setText("Mi resultado es: "+resultado);

    }

    public void Ver(View view){
        menu = new Menu();
        menu.verTirada(this);
    }
    public String nombre(View view){
        String n;
        if(j.getText().toString().isEmpty()){
            n="Jugador No Identificado";
        }
        else{
            n=j.getText().toString();
        }
        return n;
    }
    public void op100(View view){
        menu = new Menu();
        this.x= menu.Opciones(100);
    }

    public void op10(View view){
        menu = new Menu();
        this.x= menu.Opciones(10);
    }
    public void op20(View view){
        menu = new Menu();
        this.x= menu.Opciones(20);
    }
    public void op30(View view){
        menu = new Menu();
        this.x=0+ menu.Opciones(30);
    }
    public void op12(View view){
        menu = new Menu();
        this.x= menu.Opciones(12);
    }
    public void op4(View view){
        menu = new Menu();
        this.x= menu.Opciones(4);
    }
    public void op6(View view){
        menu = new Menu();
        this.x= menu.Opciones(6);
    }
    public void op8(View view){
        menu = new Menu();
        this.x= menu.Opciones(8);
    }
    public void offline(View view) throws InterruptedException {
       // Thread.sleep(2000);
        String resultado = String.valueOf(this.x);
        r.setText("Mi resultado es: "+resultado);
    }

    public void master(String[] recibido, View view) {
        m.setText(recibido[0]);
        String resultado = String.valueOf(this.x);
        r.setText("Mi resultado es: "+resultado);
    }

    public void mostrar(String s) {
        m.setText(s);
        r.setText("Resultado");
    }
}
