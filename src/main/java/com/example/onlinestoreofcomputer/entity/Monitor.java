package com.example.onlinestoreofcomputer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "monitors")
public class Monitor extends BaseEntity {

    @Column(name = "diagonal")
    private Integer diagonal;

}
