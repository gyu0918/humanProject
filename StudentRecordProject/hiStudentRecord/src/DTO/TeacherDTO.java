package DTO;
import lombok.*;

@Getter
@Builder
public class TeacherDTO {
    private String id;
    private String pwd;
    private String teacherName;
    private String gender;
    private int classNumber;
    private String subject;
    private String rank;
}
