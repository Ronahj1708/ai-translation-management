package com.example.aitranslationmanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String description;
    private Double bleuScore;
    private Boolean fineTuned;

    @OneToMany(mappedBy = "model")
    private List<Evaluation> evaluations;

    // Getter und Setter
    // ...
}
