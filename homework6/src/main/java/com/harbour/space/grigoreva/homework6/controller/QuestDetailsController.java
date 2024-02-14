package com.harbour.space.grigoreva.homework6.controller;

import com.harbour.space.grigoreva.homework6.cookies.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entities.QuestDetails;
import com.harbour.space.grigoreva.homework6.service.CourierService;
import org.openapitools.api.QuestsApiController;
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
    public ResponseEntity<String> questsActiveGet() {
        return ok(courierService.getActiveQuests().toString());
    }

    @Override
    public ResponseEntity<String> questsHistoryGet() {
        List<QuestDetails> questDetailsList = courierService.getQuestsHistory(authenticationData);

        if (questDetailsList.isEmpty())
            return ResponseEntity.notFound().build();
        return ok(questDetailsList.toString());
    }

    @Override
    public ResponseEntity<String> questsQuestIdDetailsGet(int questId) {
        QuestDetails questDetails = courierService.getQuestsDetails(questId);

        if (questDetails == null)
            return ResponseEntity.notFound().build();
        return ok(questDetails.toString());
    }

    @Override
    public ResponseEntity questsQuestIdJoinPost(int questId) {
        courierService.joinQuest(authenticationData, questId);
        return ok().build();
    }
}
