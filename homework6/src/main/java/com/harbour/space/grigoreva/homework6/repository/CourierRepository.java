package com.harbour.space.grigoreva.homework6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.harbour.space.grigoreva.homework6.entity.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Integer> {
    Courier findByCourierId(Integer courierId);
}

