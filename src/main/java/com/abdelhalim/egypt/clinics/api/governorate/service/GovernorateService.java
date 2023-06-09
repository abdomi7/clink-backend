package com.abdelhalim.egypt.clinics.api.governorate.service;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.governorate.mapper.GovernorateMapperBase;
import com.abdelhalim.egypt.clinics.entities.governorate.Governorate;
import com.abdelhalim.egypt.clinics.entities.governorate.GovernorateRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
public class GovernorateService {
    @Autowired
    private GovernorateRepository repository;
    @Autowired
    private GovernorateMapperBase governorateMapper;

    public GovernorateDto save(GovernorateDto governorateDto) {
        Governorate entity = governorateMapper.toEntity(governorateDto);
        return governorateMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public GovernorateDto findById(Long id) {
        return governorateMapper.toDto(repository.findById(id).orElseThrow());
    }

    public Page<Governorate> findByCondition(Pageable pageable) {
        Page<Governorate> entityPage = repository.findAll(pageable);
        List<Governorate> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public void update(Long id, GovernorateDto governorateDto) {
        Governorate governorate1 = repository.getReferenceById(id);
        governorate1.setName(governorateDto.getName());
        governorate1.setNameAr(governorateDto.getNameAr());

        repository.save(governorate1);
    }
}