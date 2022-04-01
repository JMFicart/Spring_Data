package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cours {
    @Id
    @Column(name = "course_id", length = 8, nullable = false, columnDefinition = "VARCHAR(8)")
    private String id;
    @Column(name = "course_name", length = 200, nullable = false, columnDefinition = "VARCHAR(200)")
    private String name;
    @Column(columnDefinition = "decimal(3,1)",name = "course_ects", nullable = false)
    private float ects;
//    @Column(columnDefinition = "INT(11)", nullable = false)
//    private long professorId;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

}
