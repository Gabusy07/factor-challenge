package com.factor.ecommerce.core.persistence.repository;

import com.factor.ecommerce.core.model.SpecialDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SpecialDateRepository extends JpaRepository<SpecialDate, Integer> {
    @Query("SELECT sd FROM SpecialDate sd WHERE sd.date = :today")
    Optional<SpecialDate> findSpecialDateByDate(LocalDate today);
}
