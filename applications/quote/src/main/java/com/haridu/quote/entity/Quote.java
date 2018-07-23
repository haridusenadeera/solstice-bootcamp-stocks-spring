package com.haridu.quote.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "symbol_id")
    private long symbol;

    private int volume;

    private double price;

    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss.SSS")
    private Date date;

}
