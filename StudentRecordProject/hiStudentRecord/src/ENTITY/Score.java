package ENTITY;

import DTO.ScoreDTO;
import lombok.*;

import java.sql.ResultSet;


public abstract class Score {
    String studentName;
    int classNumber;
    int studentNumber;

    public abstract void setInfo(ScoreDTO scoreDTO);
}
