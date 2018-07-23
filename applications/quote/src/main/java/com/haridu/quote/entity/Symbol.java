package com.haridu.quote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Symbol {

    @Id
    private long id;

    @Column(nullable = false)
    private String symbol;
}
