package sockets;
import java.io.*;
import java.net.*;


public class ClienteSMTP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String servidor="mail.tecnoweb.org.bo";
		String user_receptor="grupo20sc@tecnoweb.org.bo";
		String user_emisor="jchilelaime38@gmail.com";
		String comando="";
		int puerto=25;
		try {
			Socket skCliente = new Socket(servidor,puerto);
			BufferedReader entrada= new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
			DataOutputStream salida= new DataOutputStream(skCliente.getOutputStream());
			
			if(skCliente!= null && entrada != null && salida !=null) {
				System.out.println("S: "+ entrada.readLine());
	
				comando="HELO "+servidor+"\n\r";
				System.out.print("C: "+comando);//El servidor manda este comando
				salida.writeBytes(comando);//Con esto le va a enviar al servidor
				System.out.println("S: "+entrada.readLine());//Leo lo q me responde el servidor
				
				
				comando="MAIL FROM : <"+user_emisor+"> \r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
			
				comando="RCPT TO : <"+user_receptor+"> \r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				comando="DATA \r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				comando= "SUBJECT : DEMO VIA SOCKET \n";
				comando+="Hola como estas \n";
				comando+="bien.. gracias. \n";
				comando+=".\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				comando="QUIT \r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
//				
			
			salida.close();
			entrada.close();
			skCliente.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
