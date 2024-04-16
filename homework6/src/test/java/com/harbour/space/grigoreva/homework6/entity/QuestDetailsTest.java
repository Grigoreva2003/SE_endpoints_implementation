package com.harbour.space.grigoreva.homework6.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuestDetailsTest {

    @Test
    void testQuestDetailsConstructorAndGetters() {
        int questId = 1;
        String title = "Sample Quest";
        String description = "Sample quest description";
        int hoursDuration = 10;
        int orderThreshold = 5;
        int rewardAmount = 100;

        QuestDetails questDetails = new QuestDetails();
        questDetails.setQuestId(questId);
        questDetails.setTitle(title);
        questDetails.setDescription(description);
        questDetails.setHoursDuration(hoursDuration);
        questDetails.setOrderThreshold(orderThreshold);
        questDetails.setRewardAmount(rewardAmount);
        questDetails.setFinished(true);

        // Assert
        assertEquals(questId, questDetails.getQuestId());
        assertEquals(title, questDetails.getTitle());
        assertEquals(description, questDetails.getDescription());
        assertEquals(hoursDuration, questDetails.getHoursDuration());
        assertEquals(orderThreshold, questDetails.getOrderThreshold());
        assertEquals(rewardAmount, questDetails.getRewardAmount());
        assertTrue(questDetails.isFinished());
    }

    @Test
    void testQuestDetailsCouriersAssociation() {
        QuestDetails questDetails = new QuestDetails();

        final int COURIER_ID = 1;
        final String COURIER_NAME = "John";
        final String COURIER_SURNAME = "Doe";

        Courier courier = new Courier();
        courier.setCourierId(COURIER_ID);
        courier.setName(COURIER_NAME);
        courier.setSurname(COURIER_SURNAME);

        Set<Courier> couriers = new HashSet<>();
        couriers.add(courier);

        questDetails.setCouriers(couriers);

        // Assert
        assertNotNull(questDetails.getCouriers());
        assertEquals(1, questDetails.getCouriers().size());

        assertEquals(COURIER_ID, questDetails.getCouriers().iterator().next().getCourierId());
        assertEquals(COURIER_NAME, questDetails.getCouriers().iterator().next().getName());
        assertEquals(COURIER_SURNAME, questDetails.getCouriers().iterator().next().getSurname());
    }
}
