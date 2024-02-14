package com.harbour.space.grigoreva.homework6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @Column(name = "courier_id")
    private Integer courierId;

    @Column(name = "completed_orders_num")
    private Integer completedOrdersNum;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany
    private List<QuestDetails> questHistory;
    @ManyToMany
    private List<QuestDetails> activeQuests;

    public <E> Courier(Integer courierId,
                       Integer completedOrdersNum,
                       List<QuestDetails> questHistory,
                       List<QuestDetails> activeQuests) {
        this.courierId = courierId;
        this.completedOrdersNum = completedOrdersNum;
        this.questHistory = questHistory;
        this.activeQuests = activeQuests;
    }

    public void joinQuest(QuestDetails quest) {
        activeQuests.add(quest);
    }
}
