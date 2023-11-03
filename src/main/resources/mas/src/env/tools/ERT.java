package tools;

import java.io.*;
import java.net.Socket;
import cartago.*;


public class ERT extends Artifact {
    String serverName = "127.0.0.1";
	int port = 4445;

    void init(){

        defineObsProperty("angle", 0);
        defineObsProperty("positionY", 0);
        defineObsProperty("empty", true);

    }




    @OPERATION
	void rotate() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ROTATE ERT");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//int angle = Math.round(Float.parseFloat(in.readUTF()));
            clientSocket.close();

			//updateObsProperty("angle", angle);
          
           
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    @OPERATION
	void up() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("UP ERT");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//int position = Integer.parseInt(in.readUTF());
            clientSocket.close();

           // updateObsProperty("positionY", position);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    @OPERATION
	void down() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("DOWN ERT");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//int position = Integer.parseInt(in.readUTF());
            clientSocket.close();

           
			//updateObsProperty("positionY", position);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    @OPERATION
	void checkEmpty() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK ERT IS EMPTY");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();
            
			updateObsProperty("empty", empty);
           
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OPERATION
	void checkAngle() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK ANGLE ERT");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			int angle = Math.round(Float.parseFloat(in.readUTF()));
			clientSocket.close();

		
            updateObsProperty("angle", angle);
          
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OPERATION
	void checkPositionY() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("CHECK POSY ERT");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			int position = Integer.parseInt(in.readUTF());
			clientSocket.close();

		
     
			updateObsProperty("positionY", position);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OPERATION
	void transferTo(){
		
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("TRANFERTO TO ERT");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//int position = Integer.parseInt(in.readUTF());
			clientSocket.close();

		
     
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}






}
