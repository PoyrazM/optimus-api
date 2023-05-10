package com.example.optimusapi.repository;

import com.example.optimusapi.entity.Optimus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IOptimusRepository extends JpaRepository<Optimus, Long> {

    List<Optimus> findAllByOrderByFirstNameAsc();

}
