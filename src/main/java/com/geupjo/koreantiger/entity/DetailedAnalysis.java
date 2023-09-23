package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
@Table(schema = "geupjo")
@Entity
public class DetailedAnalysis extends BaseEntity {
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int grammar;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int assignment;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int algorithm;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int recursive;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int string;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private int total;

    @Column(nullable = false)
    private long memberId;

}
