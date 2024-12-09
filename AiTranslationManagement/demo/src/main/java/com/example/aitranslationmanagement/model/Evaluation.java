package com.example.aitranslationmanagement.model;

import javax.persistence.*;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String metric;
    private Double score;
    private String userFeedback;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    // Getter und Setter
    // ...
}
