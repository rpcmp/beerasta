package com.beerasta.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "items")
@ToString
@EqualsAndHashCode
public class Item {

    @Id
    private Long id;

    @NotNull
    @ManyToOne
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "people_count")
    private Integer peopleCount;

    @Column(name = "time")
    private String time;

    @Column(name = "level_alco")
    private Integer levelAlco;

    @Column(name = "money")
    private Integer money;

}
