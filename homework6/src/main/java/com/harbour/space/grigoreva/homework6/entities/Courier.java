package com.harbour.space.grigoreva.homework6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "couriers")
    private Set<QuestDetails> quests = new HashSet<>();
}
