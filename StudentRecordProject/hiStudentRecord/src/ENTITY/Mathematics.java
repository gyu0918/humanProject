package ENTITY;

import DTO.ScoreDTO;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;


public class Mathematics extends Score {
    int mathematicsScore;

    @Override
    public void setInfo(ScoreDTO scoreDTO) {
        super.studentName = scoreDTO.getStudentName();
        super.classNumber = scoreDTO.getClassNumber();
        super.studentNumber = scoreDTO.getStudentNumber();
        this.mathematicsScore = scoreDTO.getSubjectScore();
    }
}
