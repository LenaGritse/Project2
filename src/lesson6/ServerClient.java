package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerClient {
    final static String IP_ADRESS = "000.0.0.0";
    final static int PORT = 8189;
    static ServerSocket server = null;
    static Socket socket = null;
    static DataInputStream in = null;
    static DataOutputStream out = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        if (startServer()) {
            System.out.println("Сервер");
            try {
                socket = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
                closeMsg();
            }
        }
        else {
            System.out.println("Клиент");
            try {
                socket = new Socket(IP_ADRESS, PORT);
            } catch (IOException e) {
                e.printStackTrace();
                closeMsg();
            }
        }

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            closeMsg();
        }

        Thread messaging = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        String str = in.readUTF();
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeMsg();
                }
            }
        });

        messaging.start();

        while (true) {
            String msg = scanner.nextLine();
            if (msg.equals("/end")) {
                break;
            }
            sendMessage(msg);
        }
        messaging.interrupt();
    }

    public static boolean startServer() {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void closeMsg() {
        try {
            if (in != null) {
                in.close();
                in = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
                out = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (!server.isClosed()) {
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
