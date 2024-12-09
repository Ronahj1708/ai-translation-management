package com.example.aitranslationmanagement.repository;

import com.example.aitranslationmanagement.model.TrainingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingDataRepository extends JpaRepository<TrainingData, Long> {
}
