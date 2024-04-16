package com.harbour.space.grigoreva.homework6.controller;

import com.harbour.space.grigoreva.homework6.cookie.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entity.QuestDetails;
import com.harbour.space.grigoreva.homework6.service.CourierService;
import com.harbour.space.grigoreva.homework6.service.QuestService;
import org.openapitools.api.QuestsApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.ResponseEntity.ok;

@Component
public class QuestDetailsController extends QuestsApiController {
    private final CourierService courierService;
    private final QuestService questService;
    private final AuthenticationData authenticationData =
            new AuthenticationData(
                    1,
                    "login",
                    "password");

    public QuestDetailsController(CourierService courierService, QuestService questService) {
        this.courierService = courierService;
        this.questService = questService;
    }

    @Override
    public ResponseEntity<String> questsActiveGet() {
        return ok(questService.getActiveQuests().toString());
    }

    @Override
    public ResponseEntity<String> questsHistoryGet() {
        return ok(questService.getFinishedQuests().toString());
    }

    @Override
    public ResponseEntity<String> questsQuestIdDetailsGet(int questId) {
        QuestDetails questDetails = questService.getQuestDetails(questId);

        if (questDetails == null)
            return ResponseEntity.notFound().build();
        return ok(questDetails.toString());
    }

    @Override
    public ResponseEntity questsQuestIdJoinPost(int questId) {
        boolean joined = courierService.joinQuest(authenticationData, questId);
        if (joined) {
            return ResponseEntity.ok("Joined quest successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quest not found or already joined");
        }
    }
}
