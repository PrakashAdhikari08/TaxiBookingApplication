package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
