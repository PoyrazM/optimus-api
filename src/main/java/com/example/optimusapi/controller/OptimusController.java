package com.example.optimusapi.controller;

import com.example.optimusapi.dto.request.OptimusCreateRequest;
import com.example.optimusapi.dto.request.OptimusUpdateRequest;
import com.example.optimusapi.entity.Optimus;
import com.example.optimusapi.exceptions.OptimusMemberNotDeletedException;
import com.example.optimusapi.exceptions.OptimusMemberNotFoundException;
import com.example.optimusapi.service.service.IOptimusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/optimus")
@RequiredArgsConstructor
@Slf4j
public class OptimusController {

    private final IOptimusService optimusService;

    // http://localhost:4000/api/v1/optimus
    @GetMapping
    public ResponseEntity<List<Optimus>> getAllOptimusMembers() {
        List<Optimus> optimusMembers = optimusService.findAll();

        if (!optimusMembers.isEmpty()) {
            log.info("Optimus Members was successfully returned " + optimusMembers);
        } else throw new OptimusMemberNotFoundException("Optimus members are empty !");

        return new ResponseEntity<>(optimusMembers, HttpStatus.OK);
    }

    // http://localhost:4000/api/v1/optimus/{id}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Optimus>> getOptimusMember(@PathVariable Long id) {
        Optional<Optimus> optimusMember = optimusService.findById(id);

        if (optimusMember.isPresent()) {
            log.info("Optimus member was successfully getted by id : " + id);
        } else throw new OptimusMemberNotFoundException("Optimus member is invalid with id: " + id);

        return new ResponseEntity<>(optimusMember, HttpStatus.OK);
    }

    // http://localhost:4000/api/v1/optimus
    @PostMapping
    public ResponseEntity<Optimus> createOptimusMember(@RequestBody OptimusCreateRequest optimusCreateRequest) {
        Optimus optimus = optimusService.save(optimusCreateRequest);

        return new ResponseEntity<>(optimus, HttpStatus.CREATED);
    }

    // http://localhost:4000/api/v1/optimus/{id}
    @PutMapping(value = "/{id}")
    public ResponseEntity<Optimus> updateOptimusMember(@PathVariable Long id, @RequestBody OptimusUpdateRequest optimusUpdateRequest) {
        Optimus optimus = optimusService.update(id, optimusUpdateRequest);

        return new ResponseEntity<>(optimus, HttpStatus.OK);
    }

    // http://localhost:4000/api/v1/optimus/{id}
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Optional<Optimus>> deleteOptimusMember(@PathVariable Long id) {
        Optional<Optimus> optimusMember = optimusService.findById(id);

        if (optimusMember.isPresent()) {
            optimusService.deleteById(id);
            log.info("Optimus member successfully deleted with id : " + id);
        } else throw new OptimusMemberNotDeletedException("Optimus member was not deleted with id :" + id);

        return new ResponseEntity<>(optimusMember, HttpStatus.NO_CONTENT);
    }

}
