import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("서버가 8080 포트에서 시작되었습니다. ");

        ExecutorService executor = Executors.newFixedThreadPool(10);
        // 최대 10개의 동시 작업을 처리할 수 있는 스레드 풀 생성

        while(true){
            Socket socket = serverSocket.accept();
            executor.execute(new ClientHandler(socket));
            // 클라이언트 연결에 대한 처리를 clientHandler 스레드에 위임
        }
    }
}
