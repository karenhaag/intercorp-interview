package com.intercorp.interview.repository;

import com.intercorp.interview.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
    @Query("SELECT ct.age FROM ClientEntity ct")
    List<Integer> getAges();
}
