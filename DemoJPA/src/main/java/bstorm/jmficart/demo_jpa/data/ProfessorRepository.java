package bstorm.jmficart.demo_jpa.data;

import bstorm.jmficart.demo_jpa.exception.ElementAlreadyExistsException;
import bstorm.jmficart.demo_jpa.modele.entities.Professor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProfessorRepository {
    private EntityManager manager;

    public ProfessorRepository(EntityManager manager) {this.manager = manager;}

    public Professor getOne(Integer id){
        return manager.find(Professor.class, id);
    }

    public List<Professor> getAll(){
        TypedQuery<Professor> query = manager.createQuery("select p from Professor p", Professor.class);
        return query.getResultList();
    }

    @Transactional
    public void insert(Professor toInsert){
        if(getOne(toInsert.getId()) != null){
            throw new ElementAlreadyExistsException();
        }
        manager.persist(toInsert);
    }

    @Transactional
    public Professor delete(Integer id) {
        Professor toDelete = getOne(id);
        if(toDelete != null){
            manager.remove(toDelete);
        }
        return toDelete;
    }

    @Transactional
    public Professor update(Professor toUpdate){
        Professor p = getOne(toUpdate.getId());
        if(p != null) {
            p.setName(toUpdate.getName());
            p.setSurname(toUpdate.getSurname());
            p.setSectionid(toUpdate.getSectionid());
            p.setEmail(toUpdate.getEmail());
            p.setOffice(toUpdate.getOffice());
            p.setHiredate(toUpdate.getHiredate());
            p.setWage(toUpdate.getWage());
        }
        return p;
    }

}
