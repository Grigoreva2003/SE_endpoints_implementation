package com.harbour.space.grigoreva.homework6.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "quests_details")
@ToString
public class QuestDetails {

    @Id
    @Column(name = "quest_id", nullable = false)
    private int questId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "hours_duration", nullable = false)
    private int hoursDuration;

    @Column(name = "order_threshold", nullable = false)
    private int orderThreshold;

    @Column(name = "reward_amount")
    private int rewardAmount;

    @Column(name = "is_finished")
    private boolean isFinished;

    @ManyToMany
    @JoinTable(name = "involvement",
            joinColumns = @JoinColumn(name = "quest_id"),
            inverseJoinColumns = @JoinColumn(name = "courier_id"))
    private Set<Courier> couriers = new HashSet<>();
}
