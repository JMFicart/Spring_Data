package com.example.demoJPARef;

import com.example.demoJPARef.modelentity.Carburant;
import com.example.demoJPARef.modelentity.Utilisateur;
import com.example.demoJPARef.modelentity.Voiture;
import com.example.demoJPARef.repository.UtilisateurRepository;
import com.example.demoJPARef.repository.VoitureRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoJpaRefApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoJpaRefApplication.class, args);

		VoitureRepository vRepo = ctx.getBean(VoitureRepository.class);
		UtilisateurRepository uRepo = ctx.getBean(UtilisateurRepository.class);

		Voiture v = new Voiture(
				0L,
				"marque",
				"modele",
				true,
				Carburant.Electrique,
				null);
		Utilisateur u = new Utilisateur(
				10L,
				"username",
				"password",
				"nom",
				"prenom",
				null,
				null,
				null);

		v = vRepo.save(v);
		u.setVoitures(List.of(v));
		u = uRepo.save(u);

		// Liaison faible : ne fera rien
//		u = uRepo.save(u);
//		v.setProprietaires(List.of(u));
//		v = vRepo.save(v);
	}
}
