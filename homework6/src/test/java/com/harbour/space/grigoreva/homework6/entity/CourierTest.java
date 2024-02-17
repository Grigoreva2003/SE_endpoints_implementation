package com.harbour.space.grigoreva.homework6.entity;

import com.harbour.space.grigoreva.homework6.cookie.AuthenticationData;
import com.harbour.space.grigoreva.homework6.service.CourierService;
import com.harbour.space.grigoreva.homework6.service.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
class CourierTest {

    @Mock
    private CourierService courierService;

    @Mock
    private QuestService questService;
    private Courier courier;
    private AuthenticationData authenticationData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        courier = new Courier();
        courier.setCourierId(1);
        courier.setCompletedOrdersNum(5);
        courier.setName("John");
        courier.setSurname("Doe");
        courier.setQuests(Set.of());

        authenticationData = new AuthenticationData(courier.getCourierId(), "login", "password");
    }

    @Test
    void testCourierGetters() {
        // Assert
        assertEquals(1, courier.getCourierId());
        assertEquals(5, courier.getCompletedOrdersNum());
        assertEquals("John", courier.getName());
        assertEquals("Doe", courier.getSurname());
        assertEquals(Set.of(), courier.getQuests());
    }

    @Test
    void testCourierQuestsAssociation() {
        QuestDetails questDetails = new QuestDetails();
        questDetails.setQuestId(1);
        questDetails.setTitle("Delivery Quest");
        questDetails.setDescription("Deliver packages within the city");

        Set<QuestDetails> quests = new HashSet<>();
        quests.add(questDetails);

        when(courierService.joinQuest(authenticationData, 1)).thenReturn(true);
        when(questService.getQuestDetails(1)).thenReturn(questDetails);

        courier.setQuests(quests);

        boolean retrievedQuests = courierService.joinQuest(authenticationData, 1);

        assertTrue(retrievedQuests);
        assertEquals(1, courier.getQuests().size());
        assertTrue(courier.getQuests().contains(questDetails));
    }
}
