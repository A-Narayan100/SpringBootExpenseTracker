package com.javademo.springbootexpensetracker.controller;

import com.javademo.springbootexpensetracker.entity.Expense;
import com.javademo.springbootexpensetracker.repository.ExpenseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class ExpenseController {

    private ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }


    @GetMapping("/expenses")
    Collection<Expense> expense(){
        return expenseRepository.findAll();
    }

    //category/2
    @GetMapping("/expense/{id}")
    ResponseEntity<?> getExpense (@PathVariable Long id){
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }



    @PostMapping("/expense")
    ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) throws URISyntaxException{
        Expense result= expenseRepository.save(expense);
        return ResponseEntity.created(new URI("/api/expense" + result.getId())).body(result);

    }


    @PutMapping("/expense/{id}")
    ResponseEntity<Expense> updateCategory(@Valid @RequestBody Expense expense){
        Expense result= expenseRepository.save(expense);
        return ResponseEntity.ok().body(result);
    }



    @DeleteMapping("/expense/{id}")
    ResponseEntity<?> deleteexpense(@PathVariable Long id){
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
