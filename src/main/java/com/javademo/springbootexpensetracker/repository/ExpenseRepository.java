package com.javademo.springbootexpensetracker.repository;

import com.javademo.springbootexpensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Expense findByName(String name);

}