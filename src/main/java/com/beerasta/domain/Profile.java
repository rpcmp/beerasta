package com.beerasta.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@ToString
@EqualsAndHashCode
public class Profile {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "image")
    private String image;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Profile> friends;

    public void setFriend(Profile profile) {
        friends.add(profile);
    }

}
