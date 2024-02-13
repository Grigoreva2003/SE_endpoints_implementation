package com.harbour.space.grigoreva.homework6.controller;

import com.harbour.space.grigoreva.homework6.entities.AuthenticationData;
import com.harbour.space.grigoreva.homework6.service.CourierService;
import org.openapitools.api.QuestsApiController;
import org.openapitools.model.QuestDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Component
public class QuestDetailsController extends QuestsApiController {
    private final CourierService courierService;
    private final AuthenticationData authenticationData =
            new AuthenticationData(
                    123,
                    "login",
                    "password");

    public QuestDetailsController(CourierService courierService) {
        this.courierService = courierService;
    }

    @Override
    public ResponseEntity<List<QuestDetails>> questsActiveGet() {
        return ok(courierService.getActiveQuests());
    }

    @Override
    public ResponseEntity<List<QuestDetails>> questsHistoryGet() {
        List<QuestDetails> questDetailsList = courierService.getQuestsHistory(authenticationData);

        if (questDetailsList.isEmpty())
            return ResponseEntity.notFound().build();
        return ok(questDetailsList);
    }

    @Override
    public ResponseEntity<QuestDetails> questsQuestIdDetailsGet(String questId) {
        QuestDetails questDetails = courierService.getQuestsDetails(questId);

        if (questDetails == null)
            return ResponseEntity.notFound().build();
        return ok(questDetails);
    }

    @Override
    public ResponseEntity questsQuestIdJoinPost(String questId) {
        courierService.joinQuest(authenticationData, questId);
        return ok().build();
    }
}
