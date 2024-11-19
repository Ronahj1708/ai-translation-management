package com.example.translation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TranslationApplication {

	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.jpa.repository.JpaRepository;
	import jakarta.persistence.*;
	import java.util.List;

	@SpringBootApplication
	public class TranslationApplication {
	    public static void main(String[] args) {
	        SpringApplication.run(TranslationApplication.class, args);
	    }
	}

	// Datenbank-Entity für Modelle
	@Entity
	class Model {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String version;
	    private Double bleuScore;
	    private String status;

	    // Getter und Setter
	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getVersion() {
	        return version;
	    }
	    public void setVersion(String version) {
	        this.version = version;
	    }
	    public Double getBleuScore() {
	        return bleuScore;
	    }
	    public void setBleuScore(Double bleuScore) {
	        this.bleuScore = bleuScore;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	}

	// Datenbank-Entity für Feedback
	@Entity
	class Feedback {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String comment;
	    private int rating;

	    @ManyToOne
	    private Model model;

	    // Getter und Setter
	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
	    public String getComment() {
	        return comment;
	    }
	    public void setComment(String comment) {
	        this.comment = comment;
	    }
	    public int getRating() {
	        return rating;
	    }
	    public void setRating(int rating) {
	        this.rating = rating;
	    }
	    public Model getModel() {
	        return model;
	    }
	    public void setModel(Model model) {
	        this.model = model;
	    }
	}

	// Repository für Modelle
	interface ModelRepository extends JpaRepository<Model, Long> {}

	// Repository für Feedback
	interface FeedbackRepository extends JpaRepository<Feedback, Long> {}

	// Controller für API-Endpunkte
	@RestController
	@RequestMapping("/api")
	class ApiController {

	    @Autowired
	    private ModelRepository modelRepository;

	    @Autowired
	    private FeedbackRepository feedbackRepository;

	    // Alle Modelle abrufen
	    @GetMapping("/models")
	    public List<Model> getAllModels() {
	        return modelRepository.findAll();
	    }

	    // Modell hinzufügen
	    @PostMapping("/models")
	    public Model addModel(@RequestBody Model model) {
	        return modelRepository.save(model);
	    }

	    // Feedback hinzufügen
	    @PostMapping("/feedback")
	    public Feedback addFeedback(@RequestBody Feedback feedback) {
	        return feedbackRepository.save(feedback);
	    }

	    // Feedback für ein Modell abrufen
	    @GetMapping("/models/{id}/feedback")
	    public List<Feedback> getFeedbackForModel(@PathVariable Long id) {
	        return feedbackRepository.findAll().stream()
	            .filter(f -> f.getModel().getId().equals(id))
	            .toList();
	    }
	}

	
	public static void main(String[] args) {
		SpringApplication.run(TranslationApplication.class, args);
	}
	

}
