package bstorm.jmficart.demo_jpa.modele.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Section {
    @Id
    @Column(name = "section_id", columnDefinition = "INT(11)")
    private long id;
    @Column(name = "section_name")
    private String name;
    @Column(columnDefinition = "INT(11)")
    private Long delegateId;
    // Long accepte null

//    public Section(long id, String name, Long delegateId) {
//        this.id = id;
//        this.name = name;
//        this.delegateId = delegateId;
//    }

//    public Section() {
//    }
}
