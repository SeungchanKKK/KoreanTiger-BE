package com.geupjo.koreantiger.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;
}
