package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.cookie.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entity.Courier;
import com.harbour.space.grigoreva.homework6.entity.QuestDetails;
import com.harbour.space.grigoreva.homework6.repository.CourierRepository;
import com.harbour.space.grigoreva.homework6.repository.QuestDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class CourierServiceTest {

    @Mock
    private QuestDetailsRepository questDetailsRepository;

    @Mock
    private CourierRepository courierRepository;

    private CourierService courierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        courierService = new CourierService(questDetailsRepository, courierRepository);
    }

    @Test
    void testJoinQuest() {
        AuthenticationData authenticationData = new AuthenticationData(1, "login", "password");
        int questId = 1;
        int courierId = 1;

        // Mock quest details
        QuestDetails questDetails = new QuestDetails();
        questDetails.setQuestId(questId);

        // Mock courier
        Courier courier = new Courier();
        courier.setCourierId(courierId);

        // Mock repository behavior
        when(questDetailsRepository.findById(questId)).thenReturn(Optional.of(questDetails));
        when(courierRepository.findByCourierId(courierId)).thenReturn(courier);

        // Test joinQuest method
        boolean result = courierService.joinQuest(authenticationData, questId);

        // Assert
        assertTrue(result, "Joining quest should be successful");
    }

    @Test
    void testJoinQuest_WhenQuestNotFound() {
        AuthenticationData authenticationData = new AuthenticationData(1, "login", "password");
        int questId = 1;

        // Mock repository behavior
        when(questDetailsRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Test joinQuest method
        boolean result = courierService.joinQuest(authenticationData, questId);

        // Assert
        assertFalse(result, "Joining quest should fail if quest not found");
    }
}
