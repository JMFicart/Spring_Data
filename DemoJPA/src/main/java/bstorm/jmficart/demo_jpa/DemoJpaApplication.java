package bstorm.jmficart.demo_jpa;

import bstorm.jmficart.demo_jpa.data.SectionDAO;
import bstorm.jmficart.demo_jpa.modele.entities.Section;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.persistence.criteria.Predicate;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);
		SectionDAO dao = context.getBean(SectionDAO.class);
		Section section = dao.getOne(1010);
		System.out.println(section);
	}
}
