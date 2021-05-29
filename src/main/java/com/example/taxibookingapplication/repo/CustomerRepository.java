package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Modifying
    @Query("Delete from Customer where customerId in ?1")
    @Transactional
    void delete(Integer id);
}
