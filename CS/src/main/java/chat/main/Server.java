package chat.main;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(4000);
			int order = 0;
			while (true) {
				System.out.println("サーバーは稼働しています。");
				Socket socket = server.accept();
				order += 1;
				Scanner input = new Scanner(socket.getInputStream());
				System.out.println("クライアントから送られてきたメッセージは「");
				StringBuffer sb = new StringBuffer();

				String getString ="";

				while (!getString.contains("/q")) {
					getString = input.nextLine();
					sb.append(getString);
					sb.append("\r\n");

				}
				int start = sb.indexOf("/q");
				int end = sb.length();
				sb.delete(start, end);
				System.out.println(sb.toString());

				System.out.println("」です");
				String clientIpAddress = socket.getRemoteSocketAddress().toString();
				System.out.println("クライアントのIPアドレスとport番号は「" + clientIpAddress + "」");

				Date time = new Date();
				System.out.println("時刻：「" + time + "」");
				System.out.println("このクライアントは「" + order + "」番目です。");

				socket.close();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}