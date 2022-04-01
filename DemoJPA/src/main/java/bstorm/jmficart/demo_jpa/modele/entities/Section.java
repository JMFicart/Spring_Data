package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    @Id
    @Column(name = "section_id", columnDefinition = "INT(11)", nullable = false)
    private long id;
    @Column(name = "section_name", columnDefinition = "VARCHAR(50)", nullable = true)
    private String name;
    @Column(name = "delegate_id", columnDefinition = "INT(11)", nullable = true)
    private Long delegateId;
    // Long accepte null

    @OneToMany(mappedBy = "section")
    private List<Professor> professors = new ArrayList<>();
}
