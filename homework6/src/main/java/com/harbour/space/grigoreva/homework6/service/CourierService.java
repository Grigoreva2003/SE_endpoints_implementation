package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.entities.AuthenticationData;
import org.openapitools.model.QuestDetails;

import java.util.List;

public interface CourierService {
    List<QuestDetails> getActiveQuests();

    List<QuestDetails> getQuestsHistory(AuthenticationData authenticationData);

    QuestDetails getQuestsDetails(String questId);

    void joinQuest(AuthenticationData authenticationData, String questId);
}