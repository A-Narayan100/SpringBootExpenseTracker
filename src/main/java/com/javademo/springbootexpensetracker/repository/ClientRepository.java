package com.javademo.springbootexpensetracker.repository;

import com.javademo.springbootexpensetracker.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByName(String name);
}
