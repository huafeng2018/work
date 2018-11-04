package chat.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String args[]) {
		try {
			Socket socket = new Socket("127.0.0.1", 4000);
			PrintWriter output = new PrintWriter(socket.getOutputStream());
			BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
			String consoleInStr = "";

			while (!consoleInStr.contains("/q")) {
				consoleInStr = consoleIn.readLine();
				output.println(consoleInStr);
				output.flush();
			}

			output.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}