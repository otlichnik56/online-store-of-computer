package com.example.onlinestoreofcomputer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "notebooks")
public class Notebook extends BaseEntity{

    @Column(name = "size")
    private Integer size;

}
