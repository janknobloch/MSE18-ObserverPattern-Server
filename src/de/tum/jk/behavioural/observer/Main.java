package de.tum.jk.behavioural.observer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.glassfish.tyrus.server.Server;

public class Main {
	public static void main(String[] args) throws IOException {
		runServer();
	}

	public static void runServer() {
		Server server = new Server("localhost", 8025, "/websockets", null, ChatEndPoint.class);

		try {
			server.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please press a key to stop the server.");
			reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.stop();
		}
	}
}