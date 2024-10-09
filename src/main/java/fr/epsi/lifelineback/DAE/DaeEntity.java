package fr.epsi.lifelineback.DAE;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "Dae")
public class DaeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude", precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private BigDecimal longitude;

    @Column(name = "adresse_num")
    private String adresseNum;

    @Column(name = "adresse_voie")
    private String adresseVoie;

    @Column(name = "adresse_cp")
    private String adresseCp;

    @Column(name = "adresse_commune")
    private String adresseCommune;

    @Column(name = "acces")
    private String acces;

    @Column(name = "acces_libre")
    private Boolean accesLibre;

    @Column(name = "photo")
    private String photo;

    @Column(name = "dispo_jour")
    private String dispoJour;

    @Column(name = "dispo_heure")
    private String dispoHeure;

    @Column(name = "etat_fonctionnement")
    private String etatFonctionnement;


    public enum Acces {
        Exterieur,
        Interieur

    }

}
