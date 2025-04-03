import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException{

        //서버의 주소와 포트 번호를 사용하여 소켓 생성
        Socket socket = new Socket("localhost", 8080);

        //서버에 데이터를 보내기 위한 데이터 출력 스트림 생성
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        //서버로부터 데이터를

    }
}
