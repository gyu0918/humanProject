package DTO;

import lombok.*;

@Getter
@Builder
public class StudentDTO {

    private String id;
    private String pwd;
    private String studentName;
    private String gender;
    private int classNumber;
    private int studentNumber;
    private int scoreAVG;


}
