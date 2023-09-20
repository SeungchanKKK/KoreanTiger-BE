package com.geupjo.koreantiger.entity;

import com.geupjo.koreantiger.common.jpa.BaseEntity;
import com.geupjo.koreantiger.enums.Authority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class Member extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Authority authority;

}
