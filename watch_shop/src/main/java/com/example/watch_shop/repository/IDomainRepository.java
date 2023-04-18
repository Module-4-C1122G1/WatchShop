package com.example.watch_shop.repository;

import com.example.watch_shop.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomainRepository extends JpaRepository<Domain , Integer> {
}
