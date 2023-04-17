package com.example.watch_shop.repository;

import com.example.watch_shop.model.TypeWatch;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITypeWatchRepository extends JpaRepository<TypeWatch,Integer> {
    List<TypeWatch> findAll();
}
