package pro.alexblack.socketapp;

import java.io.*;
import java.net.Socket;

public class SocketApp {

    private static final String SERVER_URL = "vm2.skycelot.ru";
    private static final int SERVER_PORT = 7080;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_URL, SERVER_PORT);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String name = "Chernyi,Aleksandr\n";
            dos.writeBytes(name);
            dos.flush();

            StringBuilder message = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }

            System.out.println(message.toString());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
