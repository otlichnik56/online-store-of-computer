package com.example.onlinestoreofcomputer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "desktop_computers")
public class DesktopComputer extends BaseEntity{

    @Column(name = "form_factor")
    private String formFactor;

}
