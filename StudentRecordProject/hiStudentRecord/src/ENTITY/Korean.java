package ENTITY;

import DTO.ScoreDTO;
import lombok.AllArgsConstructor;


public class Korean extends Score {
    int koreanScore;

    @Override
    public void setInfo(ScoreDTO scoreDTO) {
        super.studentName = studentName;
        super.classNumber = classNumber;
        super.studentNumber = studentNumber;
    }
}
