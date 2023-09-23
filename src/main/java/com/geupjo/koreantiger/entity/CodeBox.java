package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(schema = "geupjo")
@Entity
public class CodeBox extends BaseEntity {
    @Column
    private String code;

    @Column(nullable = false)
    private long memberId;
}
