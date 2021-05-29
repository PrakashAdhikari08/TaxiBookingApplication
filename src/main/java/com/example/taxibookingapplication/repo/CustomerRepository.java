package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
