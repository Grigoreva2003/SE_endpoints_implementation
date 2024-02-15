package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.entities.QuestDetails;
import com.harbour.space.grigoreva.homework6.repository.QuestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final QuestDetailsRepository questDetailsRepository;

    @Autowired
    public QuestService(QuestDetailsRepository questDetailsRepository) {
        this.questDetailsRepository = questDetailsRepository;
    }

    public List<QuestDetails> getActiveQuests() {
        return questDetailsRepository.findByIsFinishedFalse();
    }

    public List<QuestDetails> getFinishedQuests() {
        return questDetailsRepository.findByIsFinishedTrue();
    }

    public QuestDetails getQuestDetails(int questId) {
        return questDetailsRepository.findById(questId).orElse(null);
    }
}
