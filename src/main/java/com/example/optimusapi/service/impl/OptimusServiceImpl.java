package com.example.optimusapi.service.impl;

import com.example.optimusapi.dto.request.OptimusCreateRequest;
import com.example.optimusapi.dto.request.OptimusUpdateRequest;
import com.example.optimusapi.entity.Optimus;
import com.example.optimusapi.repository.IOptimusRepository;
import com.example.optimusapi.service.service.IOptimusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OptimusServiceImpl implements IOptimusService {


    private final IOptimusRepository optimusRepository;

    @Override
    public List<Optimus> findAll() {
        return optimusRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Optional<Optimus> findById(Long id) {
        return optimusRepository.findById(id);
    }

    @Override
    public Optimus save(OptimusCreateRequest optimusCreateRequest) {
        Optimus optimus = Optimus.builder()
                .firstName(optimusCreateRequest.getFirstName())
                .lastName(optimusCreateRequest.getLastName())
                .email(optimusCreateRequest.getEmail())
                .title(optimusCreateRequest.getTitle())
                .build();

        return optimusRepository.save(optimus);
    }

    @Override
    public Optimus update(Long id, OptimusUpdateRequest optimusUpdateRequest) {
        Optimus optimus = optimusRepository.getReferenceById(id);

        optimus.setEmail(optimusUpdateRequest.getEmail());
        optimus.setTitle(optimusUpdateRequest.getTitle());

        return optimusRepository.save(optimus);
    }

    @Override
    public void deleteById(Long id) {
        optimusRepository.deleteById(id);
    }

}


