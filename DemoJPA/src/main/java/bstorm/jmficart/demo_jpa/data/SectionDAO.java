package bstorm.jmficart.demo_jpa.data;

import bstorm.jmficart.demo_jpa.modele.entities.Section;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;

@Component
public class SectionDAO {
    private final EntityManager manager;

    public SectionDAO(EntityManager manager) {
        this.manager = manager;
    }

    public Section getOne(long id){
        Section s = manager.find(Section.class, id);
        return s;
    }
}
