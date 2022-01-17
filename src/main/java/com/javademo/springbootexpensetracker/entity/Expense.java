package com.javademo.springbootexpensetracker.entity;

import java.time.Instant;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="EXPENCE_TBL")
public class Expense {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date expensedate;

    private String description;

    private float amount;

    private String currency;

    //@ManyToOne
    //private Category category;

  //  @JsonIgnore
   // @ManyToOne
    //private Client client;


}
