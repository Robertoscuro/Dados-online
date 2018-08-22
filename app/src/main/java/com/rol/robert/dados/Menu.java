package com.rol.robert.dados;

import java.io.IOException;

public class Menu {
    Dados dado;
 //   GestorIO gestorIO;
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
    public void mandarTirada ( int y, String n){
        con = new Conex();
        con.run(y, n);
    }
   /* public void iniciar() throws InterruptedException, IOException {
        int x, y;
        int op;
        String n;
        while (true) {
            op = gestorIO.leerInt("\nEscriba que desea hacer(1 duelo, 2 tirada simple,3 ver tirada simple,4 offline, 0 salir): ");
            if (op == 1) {
                n = gestorIO.leerString("\nIntroduzca el nombre del jugador: ");
                x = gestorIO.leerInt("Escriba el dado que desea lanzar: ");
                y = this.Opciones(x);
                gestorIO.escribir("Su resultado es: " + y);
                this.mandarTirada(y, n);
            } else if (op == 2) {
                n = gestorIO.leerString("\nIntroduzca el nombre del jugador: ");
                x = gestorIO.leerInt("Escriba el dado que desea lanzar: ");
                y = this.Opciones(x);
                gestorIO.escribir("Su resultado es: " + y);
                this.mandarTiradaSimple(y,n);

            } else if (op == 3) {
                con.ver();
            } else if (op == 4) {
                x = gestorIO.leerInt("Escriba el dado que desea lanzar: ");
                y = this.Opciones(x);
                gestorIO.escribir("Su resultado es: " + y);
            } else {
                return;
            }
       /* int x;
        String n;
        n=gestorIO.leerString("\nIntroduzca el nombre del jugador: ");
        while (true){

            x=gestorIO.leerInt("\nEscriba el dado que desea lanzar: ");
            if(x==0){
                return;
            }
            else
                this.Opciones(x,n);
        }

        /*
        int x;
        x=gestorIO.leerInt("Escriba el dado que desea lanzar(1 tirada normal): ");
      //  Thread.sleep(125);
        gestorIO.escribir("Su resultado es: ");
      //  Thread.sleep(125);
        System.out.println(this.Opciones(x));


        }



    }*/

    private void mandarTiradaSimple(int y,String n) throws IOException {
        con.simple(y,n);
    }
}

