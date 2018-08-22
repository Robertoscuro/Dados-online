package com.rol.robert.dados;

import android.view.View;

import java.io.*;
import java.net.*;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Conex {
    DadosApp dado;
 //  private static String HOST = "localhost";
    private static String HOST= "192.168.1.8";
    private static int PUERTO = 28197;
    Socket socket;
    DataOutputStream mensaje;
    BufferedReader entrada;
  //  GestorIO g = GestorIO.getGestorIO();
    public Conex(DadosApp dados){
        this.dado = dados;
    }

   // public static void main(String args[]) {
    public void duelo(final int x, final String Nombre, final View view) {
       final String[] recibido = new String[1];
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    socket = new Socket(HOST, PUERTO);
                    // mensaje = new DataOutputStream(socket.getOutputStream());
                    entrada = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
                    //   mensaje.writeUTF(Nombre+" ha sacado "+x);
                    OutputStream os = socket.getOutputStream();
                    BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(os));
                    bws.write(Nombre+" ha sacado " + x);
                    bws.newLine();
                    bws.flush();
                     recibido[0] = entrada.readLine();
                    System.out.println(recibido[0]);
                    //recibido[0]=String.valueOf(x);
                    System.out.println(String.valueOf(x));
                   // System.out.println(entrada.readLine());

                    //    g.escribir("\n"+recibido);

                    socket.close();

                } catch (UnknownHostException e) {
                    System.out.println("El host no existe o no está activo.");
                } catch (IOException e) {
                    System.out.println("Error de entrada/salida.");
                }

            }
        });
        t.start();
        try{
            t.join();
            dado.master(recibido, view);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public void simple(final int y, final String n) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(HOST, PUERTO);
                    BufferedWriter bws;
                    OutputStream os;
                    os = socket.getOutputStream();
                    bws = new BufferedWriter(new OutputStreamWriter(os));
                    bws.write(n + " ha sacado " + y);
                    bws.newLine();
                    bws.flush();
                    socket.close();
                } catch (UnknownHostException e) {
                    System.out.println("El host no existe o no está activo.");

                } catch (IOException e) {
                    System.out.println("Error de entrada/salida.");

                }
            }
    });
        t.start();
    }

    public void ver() {
        final String[] recibido = new String[1];
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    socket = new Socket(HOST, PUERTO);
                    entrada = new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
                    recibido[0] = entrada.readLine();



                    socket.close();

                } catch (UnknownHostException e) {
                    System.out.println("El host no existe o no está activo.");
                } catch (IOException e) {
                    System.out.println("Error de entrada/salida.");
                }

            }
        });
        t.start();
        try{
            t.join();
            dado.mostrar(recibido[0]);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
