package com.geupjo.koreantiger.entity;

import jakarta.persistence.*;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long studentId;

    @Column(nullable = false)
    private long teacherId;

    @Column(nullable = false)
    private long classId;

    @Column(nullable = false)
    private long institutionId;

}
