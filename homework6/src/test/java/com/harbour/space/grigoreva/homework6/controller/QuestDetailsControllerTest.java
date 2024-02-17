package com.harbour.space.grigoreva.homework6.controller;

import com.harbour.space.grigoreva.homework6.controller.QuestDetailsController;
import com.harbour.space.grigoreva.homework6.cookie.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entity.QuestDetails;
import com.harbour.space.grigoreva.homework6.service.CourierService;
import com.harbour.space.grigoreva.homework6.service.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class QuestDetailsControllerTest {

    @Mock
    private CourierService courierService;

    @Mock
    private QuestService questService;

    private QuestDetailsController questDetailsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        questDetailsController = new QuestDetailsController(courierService, questService);
    }

    public QuestDetails createQuestDetailsInstance(int questId, String title, String description, int hoursDuration, int orderThreshold, int rewardAmount, boolean isFinished) {
        QuestDetails questDetails = new QuestDetails();
        questDetails.setQuestId(questId);
        questDetails.setTitle(title);
        questDetails.setDescription(description);
        questDetails.setHoursDuration(hoursDuration);
        questDetails.setOrderThreshold(orderThreshold);
        questDetails.setRewardAmount(rewardAmount);
        questDetails.setFinished(isFinished);

        return questDetails;
    }

    @Test
    void testQuestsActiveGet() {
        QuestDetails questDetails = createQuestDetailsInstance(
                1,
                "Quest1",
                "Quest description",
                10,
                50,
                100,
                false);
        when(questService.getActiveQuests()).thenReturn(List.of(questDetails));

        ResponseEntity<String> response = questDetailsController.questsActiveGet();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(questDetails).toString(), response.getBody());
    }

    @Test
    void testQuestsHistoryGet() {
        QuestDetails questDetails = createQuestDetailsInstance(
                1,
                "Quest1",
                "Quest description",
                10,
                50,
                100,
                true);

        when(questService.getFinishedQuests()).thenReturn(List.of(questDetails));

        ResponseEntity<String> response = questDetailsController.questsHistoryGet();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(List.of(questDetails).toString(), response.getBody());
    }

    @Test
    void testQuestsQuestIdDetailsGetFound() {
        QuestDetails questDetails = new QuestDetails();
        questDetails.setQuestId(1);
        when(questService.getQuestDetails(1)).thenReturn(questDetails);

        ResponseEntity<String> response = questDetailsController.questsQuestIdDetailsGet(1);

        assertEquals(questDetails.toString(), response.getBody());
    }

    @Test
    void testQuestsQuestIdDetailsGetNotFound() {
        when(questService.getQuestDetails(1)).thenReturn(null);

        ResponseEntity<String> response = questDetailsController.questsQuestIdDetailsGet(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testQuestsQuestIdJoinPostJoinedSuccessfully() {
        int questId = 1;
        when(courierService.joinQuest(any(AuthenticationData.class), eq(questId))).thenReturn(true);

        ResponseEntity response = questDetailsController.questsQuestIdJoinPost(questId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Joined quest successfully", response.getBody());
    }

    @Test
    void testQuestsQuestIdJoinPostQuestNotFoundOrAlreadyJoined() {
        int questId = 1;
        when(courierService.joinQuest(any(AuthenticationData.class), eq(questId))).thenReturn(false);

        ResponseEntity response = questDetailsController.questsQuestIdJoinPost(questId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Quest not found or already joined", response.getBody());
    }
}
