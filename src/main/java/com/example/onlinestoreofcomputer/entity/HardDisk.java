package com.example.onlinestoreofcomputer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hard_disks")
public class HardDisk extends BaseEntity {

    @Column(name = "capacity")
    private Integer capacity;

}
