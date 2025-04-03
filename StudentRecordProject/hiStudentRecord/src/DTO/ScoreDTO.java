package DTO;
import lombok.*;

@Getter
@Builder
public class ScoreDTO {
    private String studentName;
    private int classNumber;
    private int studentNumber;
    private int subjectScore;

}
