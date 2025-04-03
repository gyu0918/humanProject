package DAO;

import DTO.StudentDTO;

import java.sql.*;
import java.util.*;

public class StudentDAO extends SuperDAO<StudentDTO>{
    private  Connection conn;

    public StudentDAO() throws SQLException {
        this.conn = super.getConnection();
    }

    public boolean checkStudent(String id, String pwd) throws SQLException {
        String query = "select * from student";
        PreparedStatement ps = conn.prepareStatement(query);

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                if (rs.getString("id").equals(id) && rs.getString("pwd").equals(pwd)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return false;

    }


//    private String id;
//    private String pwd;
//    private String StudentName;
//    private String gender;
//    private int classNumber;
//    private int StudentNumber;
//    private int ScoreAVG;

    @Override
    public List<StudentDTO> selectAll() {
        String query = "select * from student";
        List<StudentDTO> studentDTOList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                StudentDTO studentDTO = StudentDTO.builder()
                        .studentName(rs.getString("studentName"))
                        .gender(rs.getString("gender"))
                        .classNumber(rs.getInt("classNumber"))
                        .studentNumber(rs.getInt("studentNumber"))
                        .scoreAVG(rs.getInt("scoreAVG"))
                        .build();
                studentDTOList.add(studentDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return  studentDTOList;

    }


}
