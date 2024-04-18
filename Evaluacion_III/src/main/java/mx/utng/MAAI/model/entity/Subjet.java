package mx.utng.MAAI.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Subjet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 90)
    private String subjetName;

    @NotEmpty
    @Column(length = 90)
    private String profesorName;

    @NotEmpty
    @Column(length = 90)
    private String groupName;

    @NotEmpty
    @Column(length = 90)
    private String schoolGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjetName() {
        return subjetName;
    }

    public void setSubjetName(String subjetName) {
        this.subjetName = subjetName;
    }

    public String getProfesorName() {
        return profesorName;
    }

    public void setProfesorName(String profesorName) {
        this.profesorName = profesorName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(String schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    
    
    

    
}
