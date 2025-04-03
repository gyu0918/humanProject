package ENTITY;

import DTO.ScoreDTO;
import lombok.AllArgsConstructor;


public class English extends Score {
    int englishScore;

    @Override
    public void setInfo(ScoreDTO scoreDTO) {
        super.studentName = studentName;
        super.classNumber = classNumber;
        super.studentNumber = studentNumber;
    }
}
