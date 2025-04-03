package DAO;


import DTO.StudentDTO;
import DTO.TeacherDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO extends SuperDAO<TeacherDTO>{
    private Connection conn;

    public TeacherDAO() throws SQLException {
        this.conn = super.getConnection();
    }
    public boolean checkTeacher(String id, String pwd)  {
        String query = "select * from teacher";

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

    @Override
    public List<TeacherDTO> selectAll() {
        String query = "select * from teacher";
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                TeacherDTO teacherDTO = TeacherDTO.builder()
                        .teacherName(rs.getString("teacherName"))
                        .gender(rs.getString("gender"))
                        .classNumber(rs.getInt("classNumber"))
                        .subject(rs.getString("subject"))
                        .rank(rs.getString("rank"))
                        .build();
                teacherDTOList.add(teacherDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return  teacherDTOList;
    }
}
