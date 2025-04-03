package DAO;

import DTO.ScoreDTO;
import DTO.StudentDTO;
import ENTITY.English;
import ENTITY.Korean;
import ENTITY.Mathematics;
import ENTITY.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO extends SuperDAO{
    private Connection conn;
    private List<Score> scoreList;
    public ScoreDAO(List<Score> scoreList) throws SQLException {
        this.conn = super.getConnection();
        this.scoreList = scoreList;
    }

    public void getScoreDB ()  {
        String query = "select * from Score,Student where Student.id = Score.id";
        List<Score> scoreList = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            //성적db에서 이제 클래스로
            //db에는 과목, 성적,
            while (rs.next()) {
                Score score = null;
                String subject = rs.getString("subject");
                switch (subject){
                    case "english" :
                        score = new English();
                        break ;
                    case "korean" :
                        score = new Korean();
                        break ;
                    case "mathematics" :
                        score = new Mathematics();
                        break ;
                    default:
                        break;
                }
                if (score != null) {
                    ScoreDTO scoreDTO = ScoreDTO.builder()
                            .studentName(rs.getString("studentName"))
                            .classNumber(rs.getInt("classNumber"))
                            .studentNumber(rs.getInt("studentNumber"))
                            .subjectScore(rs.getInt(subject))
                            .build();
                    //db에 자료들 이제 해당 클래스랑 부모클래스에 정보 넣기
                    score.setInfo(scoreDTO);
                }
                scoreList.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        //이떄까지 만들어준 리스트 넣기
        this.scoreList = scoreList;
    }

}
