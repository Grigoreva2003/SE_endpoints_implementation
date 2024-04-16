package com.harbour.space.grigoreva.homework6.repository;

import com.harbour.space.grigoreva.homework6.entity.QuestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestDetailsRepository extends JpaRepository<QuestDetails, Integer> {
    List<QuestDetails> findByIsFinishedFalse();
    List<QuestDetails> findByIsFinishedTrue();
}
