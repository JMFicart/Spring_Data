package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cours {
    @Id
    @Column(name = "course_id", length = 8)
    private String id;
    @Column(name = "course_name", length = 200)
    private String name;
    @Column(columnDefinition = "decimal(3,1)",name = "course_ects")
    private float ects;
    @Column(columnDefinition = "INT(11)")
    private long professorId;
}
