import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket; // 클라이언트와의 통신을 위한 소켓
    //클라이언트 -서버 간 연결이 되면 이 소켓을 통해 데이터를 주고 받음

    //여러 클라이언트와 동시 연결을 처리하기 위해, 각 클라이언트 연결에 해당하는 소켓을 전달해야한다.
    // 각 스레드는 자신만의 소켓 인스턴스를 갖고 독립적으로 작동한다.
    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            //데이터 입력 스트림 생성
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //데이터 출력 스트림 생성
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            //클라이언트로부터 메시지 읽기
            String message = dataInputStream.readUTF();
            System.out.println("Client received: " + message);

            //클라이언트에 응답 보내기
            dataOutputStream.writeUTF("메시지 받았습니다." + message);

            //스트림과 소켓 닫기
            // 닫지 않으면
            // 1. 리소스 누수가 발생할 수 있다. -> 시스템 성능 저하, 안정성 문제
            // 2. 버퍼에 남은 데이터가 손실될 수 있다.
            // 3. 소켓을 열어두면 불필요한 네트워크 자원 사용과 보험 위험을 야기 할 수 있다.

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
