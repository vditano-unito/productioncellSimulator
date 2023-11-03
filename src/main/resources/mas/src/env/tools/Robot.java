package tools;

import java.io.*;
import java.net.Socket;
import cartago.*;

public class Robot extends Artifact{
    String serverName = "127.0.0.1";
	int port = 4445;

    void init(){

        defineObsProperty("anglerobot", 0);
        defineObsProperty("emptyarm1", true);
        defineObsProperty("emptyarm2", true);
		defineObsProperty("pickERT", false);
        defineObsProperty("pickPress", false);
		
    }

	@OPERATION
	void setPickPress(Boolean condition){
		
		updateObsProperty("pickPress", condition);
	}
	@OPERATION
	void setPickERT(Boolean condition){
		updateObsProperty("pickERT", condition);
	}
    @OPERATION
	void checkEmptyArm1() {
	
        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ARM1 IS EMPTY");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();
            
         
			updateObsProperty("emptyarm1", empty);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    @OPERATION
	void checkEmptyArm2() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ARM2 IS EMPTY");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			Boolean empty = Boolean.parseBoolean(in.readUTF());
            clientSocket.close();

            updateObsProperty("emptyarm2", empty);
            
			
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
            
			out.writeUTF("CHECK ANGLE ROBOT");
			InputStream inFromServer = clientSocket.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			int angle = Math.round(Float.parseFloat(in.readUTF()));
			clientSocket.close();

			updateObsProperty("anglerobot", angle);
          
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    @OPERATION 
	void rotateUp() {
		
       try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ROBOT ROTATE UP");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//int angle = Math.round(Float.parseFloat(in.readUTF()));
            clientSocket.close();

			
           // updateObsProperty("anglerobot", angle);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    

	}

    @OPERATION
	void rotateDown() {

        try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ROBOT ROTATE DOWN");
			//InputStream inFromServer = clientSocket.getInputStream();
			//DataInputStream in = new DataInputStream(inFromServer);
			//int angle = Math.round(Float.parseFloat(in.readUTF()));
            clientSocket.close();

          //  updateObsProperty("anglerobot", angle);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@OPERATION
	void activateMagnet1(){
		try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ACTIVATE MAGNET1");
			
            clientSocket.close();

           
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OPERATION
	void activateMagnet2(){
		try {
			//System.out.println("Connessione al server " + serverName + " sulla porta " + port);
			Socket clientSocket = new Socket(serverName, port);

			//System.out.println("Connesso a " + clientSocket.getRemoteSocketAddress());
			OutputStream outToServer = clientSocket.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
            
			out.writeUTF("ACTIVATE MAGNET2");

            clientSocket.close();

           
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}


