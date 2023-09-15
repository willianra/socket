package sockets;
import java.io.*;
import java.net.*;

public class cliente {
//static final String HOST = "172.20.172.251";
static final String HOST = "localhost";
static final int PUERTO=5000;
public  cliente() {
	try {
		Socket skCliente = new Socket(HOST,PUERTO);
		BufferedReader entrada= new BufferedReader(new InputStreamReader(skCliente.getInputStream()));//leer informacion
		System.out.println("C: Conectado A "+HOST);
		System.out.println("S: "+ entrada.readLine()); //recibir informacion
		
		DataOutputStream salida = new DataOutputStream(skCliente.getOutputStream()); //salida de informacion
		salida.writeBytes("Hola Servidor tu IP es: "+ skCliente.getInetAddress() + "\n\\n");
		
		skCliente.close();
		System.out.println(" C : Desconectado del < "+HOST+ " >");
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("C: "+e.getMessage()); 
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cliente c=new cliente();
	}

}
