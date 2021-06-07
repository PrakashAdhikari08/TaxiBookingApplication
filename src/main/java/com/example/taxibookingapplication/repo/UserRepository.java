package com.example.taxibookingapplication.repo;

import com.example.taxibookingapplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {

    Long countByEmail(String email);
//    @Modifying
//    @Query("Delete from Customer where customerId in ?1")
//    @Transactional
//    void delete(Integer id);
}
