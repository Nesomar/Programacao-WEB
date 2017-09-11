
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        server = new ServerSocket(8080);
        
        while(true) {
            
            Socket socket = server.accept();
            Thread t = new Thread(new Requisicao(socket));
            t.start();

        }
        
    }
}

