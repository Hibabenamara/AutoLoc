package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String telephone;

    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules = new ArrayList<>();

    @OneToMany(mappedBy = "agence")
    private List<Employe> employes = new ArrayList<>();
}