package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.entity.QuestDetails;
import com.harbour.space.grigoreva.homework6.repository.QuestDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class QuestServiceTest {

    @Mock
    private QuestDetailsRepository questDetailsRepository;

    private QuestService questService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        questService = new QuestService(questDetailsRepository);
    }

    @Test
    void testGetActiveQuests() {
        // Create sample quest details
        QuestDetails quest1 = new QuestDetails();
        quest1.setQuestId(1);
        quest1.setTitle("Quest 1");
        quest1.setFinished(false);

        QuestDetails quest2 = new QuestDetails();
        quest2.setQuestId(2);
        quest2.setTitle("Quest 2");
        quest2.setFinished(false);

        // Mock repository behavior
        when(questDetailsRepository.findByIsFinishedFalse()).thenReturn(Arrays.asList(quest1, quest2));

        // Call the service method
        List<QuestDetails> activeQuests = questService.getActiveQuests();

        // Assert
        assertEquals(2, activeQuests.size());
        assertEquals("Quest 1", activeQuests.get(0).getTitle());
        assertEquals("Quest 2", activeQuests.get(1).getTitle());
    }

    @Test
    void testGetFinishedQuests() {
        // Create sample quest details
        QuestDetails quest1 = new QuestDetails();
        quest1.setQuestId(1);
        quest1.setTitle("Quest 1");
        quest1.setFinished(true);

        QuestDetails quest2 = new QuestDetails();
        quest2.setQuestId(2);
        quest2.setTitle("Quest 2");
        quest2.setFinished(true);

        // Mock repository behavior
        when(questDetailsRepository.findByIsFinishedTrue()).thenReturn(Arrays.asList(quest1, quest2));

        // Call the service method
        List<QuestDetails> finishedQuests = questService.getFinishedQuests();

        // Assert
        assertEquals(2, finishedQuests.size());
        assertEquals("Quest 1", finishedQuests.get(0).getTitle());
        assertEquals("Quest 2", finishedQuests.get(1).getTitle());
    }

    @Test
    void testGetQuestDetails() {
        // Create sample quest details
        QuestDetails quest = new QuestDetails();
        quest.setQuestId(1);
        quest.setTitle("Quest 1");
        quest.setFinished(false);

        // Mock repository behavior
        when(questDetailsRepository.findById(1)).thenReturn(Optional.of(quest));

        // Call the service method
        QuestDetails foundQuest = questService.getQuestDetails(1);

        // Assert
        assertEquals("Quest 1", foundQuest.getTitle());
    }
}
