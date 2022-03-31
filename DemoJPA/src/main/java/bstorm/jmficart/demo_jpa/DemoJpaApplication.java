package bstorm.jmficart.demo_jpa;

import bstorm.jmficart.demo_jpa.data.CoursRepository;
import bstorm.jmficart.demo_jpa.data.ProfessorRepository;
import bstorm.jmficart.demo_jpa.data.SectionRepository;
import bstorm.jmficart.demo_jpa.modele.entities.Cours;
import bstorm.jmficart.demo_jpa.modele.entities.Professor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);
		SectionRepository dao = context.getBean(SectionRepository.class);
//		Section section = dao.getOne(1010);
//		System.out.println(section);
//
//		Section toAdd = new Section (10000L, "Ma section", 6L);
//		if (dao.insert(toAdd)) {
//			System.out.println("Ajouté");
//		}
//		else {
//			System.out.println("Pas ajouté");
//		}

//		Section toUpdate = dao.getOne(3333);
//		toUpdate.setName("au final tu seras deleted");
//		toUpdate.setDelegateId(1L);
//
//		dao.update(10000, toUpdate);

//		List<Cours> list = dao.getAll();
//		list.forEach(System.out::println);

//		CoursRepository repo = context.getBean(CoursRepository.class);
//		Cours c = repo.getOne("EG1010");
//		System.out.println(c);

//		List<Cours> list = repo.getAll();
//		list.forEach(System.out::println);

//		Cours c1 = new Cours("GG0000", "to delete", 0, 1);
//		repo.insert(c1);

//		Cours c2 = repo.delete("GG0000");
//		System.out.println(c2);

//		c1.setName("nom modifié");
//		Cours coursmodifie = repo.update(c1);
//		System.out.println(coursmodifie);

		// Professor
		ProfessorRepository repoprof = context.getBean(ProfessorRepository.class);
//		Professor p = repoprof.getOne(1);
//		System.out.println(p);

//		List<Professor> list = repoprof.getAll();
//		list.forEach(System.out::println);

//		Professor c1 = new Professor(7, "Sherman Trump", "Titus", 7777, 412, "sherman.trump@ubc.us",
//										LocalDateTime.of(2022,02,01,00,00), 2500);
//		repoprof.insert(c1);

//		c1.setSurname("Professeur Foldingue");
//		Professor profmodifie = repoprof.update(c1);
//		System.out.println(profmodifie);

//		Professor c2 = repoprof.delete(7);
//		System.out.println(c2);
	}
}
