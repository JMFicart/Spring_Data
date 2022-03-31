package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "Professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Professor {
    @Id
    @Column(name = "professor_id", columnDefinition = "INT(11)")
    private Integer id;
    @Column(name = "professor_name", length = 30)
    private String name;
    @Column(name = "professor_surname", length = 30)
    private String surname;
    @Column(name = "section_id", columnDefinition = "INT(11)")
    private Integer sectionid;
    @Column(name = "professor_office", columnDefinition = "INT(11)")
    private Integer office;
    @Column(name = "professor_email", length = 30)
    private String email;
    @Column(name = "professor_hire_date", columnDefinition = "LOCALDATETIME()")
    private LocalDateTime hiredate;
    @Column(name = "professor_wage", columnDefinition = "INT(11)")
    private float wage;
}


