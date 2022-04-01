package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

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
    @Column(name = "professor_name", columnDefinition = "VARCHAR(30)", nullable = false)
    private String name;
    @Column(name = "professor_surname",  columnDefinition = "VARCHAR(30)", nullable = false)
    private String surname;
//    @Column(name = "section_id", columnDefinition = "INT(11)")
//    private Integer sectionid;
    @Column(name = "professor_office", columnDefinition = "INT(11)")
    private Integer office;
    @Column(name = "professor_email",  columnDefinition = "VARCHAR(30)", nullable = false)
    private String email;
    @Column(name = "professor_hire_date", columnDefinition = "LOCALDATETIME()")
    private LocalDateTime hiredate;
    @Column(name = "professor_wage", columnDefinition = "INT(11)")
    private float wage;

//    @JoinColumn(name="professor_id", foreignKey = @ForeignKey(name = "FK_PROFESSOR_COURS"))
    @OneToMany(mappedBy = "professor")
    private Set<Cours> cours = new LinkedHashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

}


