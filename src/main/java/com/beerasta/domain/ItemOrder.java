package com.beerasta.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "item_order")
@ToString
@EqualsAndHashCode
public class ItemOrder {

    @Id
    private Long id;

    @NotNull
    @ManyToMany
    private User user;

    @NotNull
    @ManyToMany
    private Item item;

}
