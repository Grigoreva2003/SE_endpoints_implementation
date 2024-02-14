package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.cookies.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entities.Courier;
import com.harbour.space.grigoreva.homework6.entities.QuestDetails;
import com.harbour.space.grigoreva.homework6.entities.QuestDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainCourierService implements CourierService {
    private static final Map<Integer, Courier> couriers = new HashMap<>();
    private static final List<QuestDetails> activeQuests = new ArrayList<>();

    private static final Map<String, QuestDetails> allQuests = new HashMap<>();

    private final QuestDetailsRepository questDetailsRepository;

//    public MainCourierService() {
//        //mock data
//        initializeMockData();
//    }
//
//    private void initializeMockData() {
//        couriers.put(123,
//                new Courier(
//                        123,
//                        0,
//                        List.of(),
//                        List.of(new QuestDetails(
//                                0,
//                                "name",
//                                "description",
//                                60,
//                                7,
//                                100))));
//        activeQuests.add(new QuestDetails(
//                0,
//                "name",
//                "description",
//                60,
//                7,
//                100));
//        allQuests.put("name", new QuestDetails(
//                0,
//                "name",
//                "description",
//                60,
//                7,
//                100));
//    }

    @Override
    public List<QuestDetails> getActiveQuests() {
        return activeQuests;
    }

    @Override
    public List<QuestDetails> getQuestsHistory(AuthenticationData authenticationData) {
        if (couriers.containsKey(authenticationData.getCourierId()))
            return couriers.get(authenticationData.getCourierId()).getQuestHistory();
        return null;
    }

    @Override
    public QuestDetails getQuestsDetails(Integer questId) {
        return questDetailsRepository.getReferenceById(questId);
    }

    @Override
    public void joinQuest(AuthenticationData authenticationData, Integer questId) {
        couriers.get(authenticationData.getCourierId()).joinQuest(allQuests.get(questId));
    }
}
