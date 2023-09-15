package sockets;
import java.io.*;
import java.net.*;

public class ClientePOP3 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String servidor="mail.tecnoweb.org.bo";
		String user="grupo20sc";
		String pass="grup020grup020";
		String comando="";
		int puerto=110;
		try {
			Socket socket = new Socket(servidor,puerto);
			BufferedReader entrada= new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream salida= new DataOutputStream(socket.getOutputStream());
			if(socket!= null && entrada != null && salida !=null) {
				System.out.println("S: "+ entrada.readLine());
				
				comando="USER "+user+"\r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				comando="PASS "+pass+"\r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				comando="STAT\r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				comando="RETR 1\r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+getMultiline(entrada));
				
				comando="QUIT\r\n";
				System.out.print("C: "+comando);
				salida.writeBytes(comando);
				System.out.println("S: "+entrada.readLine());
				
				
				
				
			}
			salida.close();
			entrada.close();
			socket.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	//MULTILINEA DEL POP3 ES DISTINTO DEL DE EL SMTP 
	static protected String getMultiline(BufferedReader in) throws IOException{
		String lines="";
		while(true) {
			String line=in.readLine();
			if (line==null) {
				throw new IOException("S: error");
			}
			if (line.equals(".")) {
				break;
			}
			if ((line.length()>0)&&(line.charAt(0)=='.')) {
				line= line.substring(1);
			}                                 
			lines=lines+"\n"+line;
		}
		return lines;
		//POSIBLEMENTE ESTE CODIGO DE ARRIBA, SEA EL DE SMPT O ALGO ASÍ Y POR ESO NO DA
	}
	}
