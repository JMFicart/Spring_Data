package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
public class Section {
    @Id
    @Column(name = "section_id", columnDefinition = "INT(11)")
    private long id;
    @Column(name = "section_name")
    private String name;
    @Column(columnDefinition = "INT(11)")
    private Long delegateId;
    // Integer accepte null
}
