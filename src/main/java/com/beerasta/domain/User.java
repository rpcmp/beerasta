package com.beerasta.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String username;

    private final String password;

/*    @OneToMany(mappedBy = "owner")
//    @JoinColumn(name = "items", referencedColumnName = "id")
    private List<Item> personalItems = new ArrayList<>();

    @ManyToMany(mappedBy = "visitors")
//    @JoinColumn(name = "items", referencedColumnName = "id")
    private List<Item> bookedItems = new ArrayList<>();*/

}
