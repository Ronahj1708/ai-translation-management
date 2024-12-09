package com.example.aitranslationmanagement.model;

import javax.persistence.*;

@Entity
public class TrainingData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Lob
    private String data;

    // Getter und Setter
    // ...
}
