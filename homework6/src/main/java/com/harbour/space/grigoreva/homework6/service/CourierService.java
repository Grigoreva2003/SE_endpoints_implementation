package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.cookies.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entities.QuestDetails;

import java.util.List;

public interface CourierService {
    List<QuestDetails> getActiveQuests();

    List<QuestDetails> getQuestsHistory(AuthenticationData authenticationData);

    QuestDetails getQuestsDetails(Integer questId);

    void joinQuest(AuthenticationData authenticationData, Integer questId);
}