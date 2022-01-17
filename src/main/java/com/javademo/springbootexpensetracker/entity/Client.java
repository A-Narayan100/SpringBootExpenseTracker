package com.javademo.springbootexpensetracker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENT_TBL")
public class Client {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String gstId;

}

