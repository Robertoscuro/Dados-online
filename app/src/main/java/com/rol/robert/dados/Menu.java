package com.rol.robert.dados;

import android.view.View;

import java.io.IOException;

public class Menu {
    Dados dado;
    Conex con;

    public Menu() {
        dado = new Dados();
  //      gestorIO = GestorIO.getGestorIO();

    }

    public int Opciones(int op) {
        int x;
        switch (op) {
            case 4:
                x = dado.Dado4();
                break;
            case 6:
                x = dado.Dado6();
                break;
            case 8:
                x = dado.Dado8();
                break;
            case 10:
                x = dado.Dado10();
                break;
            case 12:
                x = dado.Dado12();
                break;
            case 20:
                x = dado.Dado20();
                break;
            case 30:
                x = dado.Dado30();
                break;
            case 100:
                x = dado.Dado100();
                break;

            default:
                x = 0;
                break;


        }
        return x;
    }
    public void mandarTirada (int y, String n, View view,DadosApp dado){
        con = new Conex(dado);
        con.duelo(y, n,view);
    }


    public void mandarTiradaSimple(int y,String n,DadosApp dado){
        con = new Conex(dado);

        con.simple(y,n);
    }
    public void verTirada(DadosApp dado){
        con = new Conex(dado);
        con.ver();
    }
}

