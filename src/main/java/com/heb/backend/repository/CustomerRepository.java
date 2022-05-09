package com.heb.backend.repository;

import com.heb.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query(value = "SELECT c FROM Customer c WHERE c.city = :city")
  List<Customer> findByCity(@Param("city") String city);

  @Query(value = "SELECT c FROM Customer c WHERE c.id = :id")
  Optional<Customer> findById(@Param("id") Long id);
}
