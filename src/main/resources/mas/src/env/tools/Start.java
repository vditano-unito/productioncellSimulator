// CArtAgO artifact code for project productioncell

package tools;

import java.io.*;
import java.net.Socket;
import cartago.*;


public class Start extends Artifact {
	String serverName = "127.0.0.1";
	int port = 4445;

	void init()   {

		try {
			System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("ACTIVATE CELL PRODUCTION");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//System.out.println("Risposta dal server: " + in.readUTF());

			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);

			out.writeUTF("ACTIVATE ADD SUPPLY");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//System.out.println("Risposta dal server: " + in.readUTF());

			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}

