package com.example.aitranslationmanagement.service;

import com.example.aitranslationmanagement.model.TrainingData;
import com.example.aitranslationmanagement.repository.TrainingDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingDataService {

    @Autowired
    private TrainingDataRepository trainingDataRepository;

    public List<TrainingData> getAllTrainingData() {
        return trainingDataRepository.findAll();
    }

    public TrainingData createTrainingData(TrainingData trainingData) {
        return trainingDataRepository.save(trainingData);
    }
}
