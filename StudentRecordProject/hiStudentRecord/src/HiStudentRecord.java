import DAO.*;
import DTO.*;
import ENTITY.Score;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class HiStudentRecord {

    public HiStudentRecord() throws IOException, SQLException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag){
            System.out.println("1. Hi 학생 2. Hi 선생 3. End");
            int choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    if (login(1)){
                        System.out.println("1. 학생 조회 2. 선생 조회 3. 성적 조회");
                        int choiceNum = Integer.parseInt(br.readLine());
                        switch (choiceNum){
                            case 1:
                                searchStudent();
                                break;
                            case 2:
                                searchTeacher();
                                break;
                            case 3:
                                searchScore();
                                break;
                                default:
                                    break;
                        }
                    }
                    break;
                case 2:
                    if (login(2)){
                        System.out.println("1. 등록 2. 조회 3. 삭제 4. 수정");
                        int choiceNum = Integer.parseInt(br.readLine());
                        switch (choiceNum){
                            case 1: // 등록
                                System.out.println("1. 학생 등록 2. 성적 등록");
                                break ;
                            case 2: // 조회
                                System.out.println("1. 학생 조회 2. 선생 조회 3. 성적 조회");
                                break ;
                            case 3: // 삭제
                                System.out.println("1. 학생 삭제 2. 선생 삭제 3. 성적 삭제");
                                break ;
                            case 4: // 수정
                                System.out.println("1. 학생 수정 2. 선생 수정 3. 성적 수정");
                                break ;
                            default:
                                break ;
                        }
                    }
                    break ;
                case 3:
                    flag = false;
                    break;
            }
        }
    }

    //성적 조회
    public void searchScore() throws SQLException {
        //성적 db에서 정보를 가지고와서 리스트를 만들어준다.
        List<Score> scoreList = new ArrayList<>();

        ScoreDAO scoreDAO = new ScoreDAO(scoreList);

        //ScoreDB 에서 정보를 받아서 Score리스트를 만든다
        scoreDAO.getScoreDB();



    }

    //학생 이름으로 조회
    public void searchStudent() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //다형성 부분
        SuperDAO<StudentDTO> superDAO = new StudentDAO();
        System.out.println("조회하고 싶은 학생이름을 입력하세요.");
        String studentName = br.readLine();

        List<StudentDTO> studentDTOList = superDAO.selectAll();

        long count = studentDTOList.stream()
                .filter(studentDTO -> studentDTO.getStudentName().equals(studentName))
                .peek(student -> System.out.println("이름 : " + student.getId() +
                        " 성별 : " + student.getGender() +
                        " 반 : " + student.getClassNumber() +
                        " 번호 : " + student.getStudentNumber() +
                        " 평균점 : " + student.getScoreAVG()))
                .count();  // 필터링된 학생 수 세기

        if (count == 0)
            System.out.println("해당 학생을 찾을 수 없습니다.");
    }

    //선생 반으로 조회 (원래 이름으로 할려다가 바꿈 )
    public void searchTeacher() throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //다형성 부분
        SuperDAO<TeacherDTO> superDAO = new TeacherDAO();

        System.out.println("조회하고 선생님이 있는 반, 과목을 입력하세요.");
        int choicClassForTeacher = Integer.parseInt(br.readLine());
        String teacherSubject = br.readLine();
        List<TeacherDTO> teacherDTOList = superDAO.selectAll();

        long count = teacherDTOList.stream()
                .filter(teacherDTO -> teacherDTO.getClassNumber() == choicClassForTeacher
                        && teacherDTO.getSubject().equals(teacherSubject))
                .peek(teacherDTO -> System.out.println("이름 : " + teacherDTO.getTeacherName()
                        + ", 과목 : " + teacherDTO.getSubject()
                        + ", 반 : " + teacherDTO.getClassNumber()
                        + ", 직급 : " + teacherDTO.getRank()
                        + ", 성별 : " + teacherDTO.getGender()))
                .count();

        if (count == 0)
            System.out.println("해당 선생님이 없습니다.");
    }

    public boolean login(int choice) throws IOException, SQLException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("아이디 비번을 입력하세요.");
        String id = br.readLine();
        String password = br.readLine();

        // 1 = 학생 로그인
        if (choice == 1){
            StudentDAO studentDAO = new StudentDAO();
            if (studentDAO.checkStudent(id, password)){
                System.out.println("로그인 완료되었습니다.");
                return true ;
            }
            System.out.println("아이디 비번이 잘못되었습니다.");
        }else if (choice == 2){    // 2 = 선생 로그인
            TeacherDAO teacherDAO = new TeacherDAO();
            if (teacherDAO.checkTeacher(id, password)){
                System.out.println("로그인 완료되었습니다.");
                return true ;
            }
            System.out.println("아이디 비번이 잘못되었습니다.");
        }else{
            System.out.println("없는 번호나 잘못된 번호를 입력하였습니다.");
        }
        return false;
    }





}
