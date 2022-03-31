package modelentity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT", length = 5)
    private Long id;

    @Column(name = "voit_marque", nullable = false, length = 20)
    private String marque;

    @Column(name = "modele", nullable = false, length = 20)
    private String modele;

    @Column(name = "disponible", nullable = false)
    private boolean disponible = false;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Carburant carburant;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Carburant carburant_2;

}