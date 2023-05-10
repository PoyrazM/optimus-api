package com.example.optimusapi.service.service;

import com.example.optimusapi.dto.request.OptimusCreateRequest;
import com.example.optimusapi.dto.request.OptimusUpdateRequest;
import com.example.optimusapi.entity.Optimus;
import java.util.List;
import java.util.Optional;

public interface IOptimusService {

    List<Optimus> findAll();

    Optional<Optimus> findById(Long id);

    Optimus save(OptimusCreateRequest optimusCreateRequest);

    Optimus update(Long id, OptimusUpdateRequest optimusUpdateRequest);

    void deleteById(Long id);

}
