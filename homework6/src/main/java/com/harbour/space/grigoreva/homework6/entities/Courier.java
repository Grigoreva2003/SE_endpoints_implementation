package com.harbour.space.grigoreva.homework6.entities;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.model.QuestDetails;

import java.util.List;

@Setter
@Getter
public class Courier {
    private Integer courierId;
    private Integer numberOfCompletedOrders;
    private List<QuestDetails> questHistory;
    private List<QuestDetails> activeQuests;

    public <E> Courier(int courierId,
                       int numberOfCompletedOrders,
                       List<QuestDetails> questHistory,
                       List<QuestDetails> activeQuests) {
        this.courierId = courierId;
        this.numberOfCompletedOrders = numberOfCompletedOrders;
        this.questHistory = questHistory;
        this.activeQuests = activeQuests;
    }

    public void joinQuest(QuestDetails quest) {
        activeQuests.add(quest);
    }
}
