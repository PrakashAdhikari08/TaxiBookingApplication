package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

}
