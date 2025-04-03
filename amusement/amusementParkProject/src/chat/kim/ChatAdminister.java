package javaproject.chat.kim;

import javaproject.DAO.AdminDAO;
import javaproject.DTO.AdminDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatAdminister {
    private AdminDAO adminDAO;
    private Socket socket;
    private ObjectOutputStream writer;
    private ObjectInputStream reader;

    public ChatAdminister(String id) throws IOException, ClassNotFoundException {
        adminDAO = new AdminDAO();
        AdminDTO adminDTO = adminDAO.select(id);
        int port = Integer.parseInt(adminDTO.getAName());

        // 서버와 연결된 소켓을 한 번만 열어두고 재사용
        try {
//            socket = new Socket("192.168.0.28", port);  // 소켓을 한 번만 열기
//            김정규  172.30.1.12
            socket = new Socket("172.30.1.12", port);  // 소켓을 한 번만 열기

            writer = new ObjectOutputStream(socket.getOutputStream());
            try{
                reader = new ObjectInputStream(socket.getInputStream());
            }catch (Exception e){
                return ;
            }


            // 포트별로 관리자 설정
            switch (port) {
                case 1004:
                    setFlagFromClient(writer, 0);
                    break;
                case 1005:
                    setFlagFromClient(writer, 1);
                    break;
                case 1006:
                    setFlagFromClient(writer, 2);
                    break;
                default:
                    return;
            }

            new ChatClient().service(socket,writer,reader,port, true, id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 서버로 플래그를 보내는 메서드
    public void setFlagFromClient(ObjectOutputStream writer, int checkAdminIndex) throws IOException {
        // 서버로 플래그 설정 요청
        System.out.println(" fffffffffffffffffffffffffffffff");
        ChatDTO dto = new ChatDTO();
        dto.setCommand(Info.SET_FLAG);
        dto.setCheckAdminIndex(checkAdminIndex);
        dto.setCheckFlag(true);
        writer.writeObject(dto);
        writer.flush();
    }
}
