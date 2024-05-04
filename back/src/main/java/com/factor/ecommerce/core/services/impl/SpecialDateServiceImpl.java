package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.core.persistence.repository.SpecialDateRepository;
import com.factor.ecommerce.core.services.interfaces.SpecialDateService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SpecialDateServiceImpl implements SpecialDateService {

    private final SpecialDateRepository specialDateRepository;

    public SpecialDateServiceImpl(SpecialDateRepository specialDateRepository) {
        this.specialDateRepository = specialDateRepository;
    }

    @Override
    public Boolean isASpecialDate() {
        LocalDate today = LocalDate.now();
        return specialDateRepository.findSpecialDateByDate(today).isPresent();
    }
}
