package com.rol.robert.dados;

import java.io.*;
import java.net.*;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class Conex {
    DadosApp dado = new DadosApp();
 //  private static String HOST = "localhost";
    private static String HOST= "82.158.41.88";
    private static int PUERTO = 28197;
    Socket socket;
    DataOutputStream mensaje;
    BufferedReader entrada;
  //  GestorIO g = GestorIO.getGestorIO();
    public Conex(){

    }

   // public static void main(String args[]) {
    public void run(int x,String Nombre){


        try {

            socket = new Socket(HOST, PUERTO);
           // mensaje = new DataOutputStream(socket.getOutputStream());
            entrada = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
         //   mensaje.writeUTF(Nombre+" ha sacado "+x);
            OutputStream os = socket.getOutputStream();
            BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(os));
            bws.write("El resultado del Master es: "+T);
            bws.newLine();
            bws.flush();
          String recibido = entrada.readLine();
          dado.master(recibido);
        //    g.escribir("\n"+recibido);

            socket.close();

        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }

    }

    public void simple(int y, String n) throws IOException {
        try {
            socket = new Socket(HOST, PUERTO);
            BufferedWriter bws;
            BufferedReader br = null;
            OutputStream os;
            os = socket.getOutputStream();
            bws = new BufferedWriter(new OutputStreamWriter(os));
            bws.write(n+" ha sacado " + y);
            bws.newLine();
            bws.flush();
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("El host no existe o no está activo.");

        }catch (IOException e) {
        System.out.println("Error de entrada/salida.");
    }
    }

    public void ver() throws IOException {
        try{
            socket = new Socket(HOST, PUERTO);
        entrada = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        String recibido = entrada.readLine();
     //   g.escribir("\n"+recibido);

        socket.close();
    } catch (UnknownHostException e) {
        System.out.println("El host no existe o no está activo.");

    }catch (IOException e) {
        System.out.println("Error de entrada/salida.");
    }

    }
}
