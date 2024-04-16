package com.harbour.space.grigoreva.homework6.service;

import com.harbour.space.grigoreva.homework6.cookies.AuthenticationData;
import com.harbour.space.grigoreva.homework6.entities.Courier;
import com.harbour.space.grigoreva.homework6.entities.QuestDetails;
import com.harbour.space.grigoreva.homework6.repository.CourierRepository;
import com.harbour.space.grigoreva.homework6.repository.QuestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierService {
    private final QuestDetailsRepository questDetailsRepository;
    private final CourierRepository courierRepository;

    @Autowired
    public CourierService(QuestDetailsRepository questDetailsRepository, CourierRepository courierRepository) {
        this.questDetailsRepository = questDetailsRepository;
        this.courierRepository = courierRepository;
    }

    public Courier getCourierById(Integer courierId) {
        return courierRepository.findByCourierId(courierId);
    }

    public boolean joinQuest(AuthenticationData authenticationData, int questId) {
        int courierId = authenticationData.getCourierId();

        QuestDetails questDetails = questDetailsRepository.findById(questId).orElse(null);
        if (questDetails == null) {
            return false; // Quest not found
        }

        Courier courier = getCourierById(courierId);

        questDetails.getCouriers().add(courier);
        questDetailsRepository.save(questDetails);

        return true; // Courier joined the quest successfully
    }
}
