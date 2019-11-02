package com.beerasta.repository.specificaion;

import com.beerasta.domain.Item;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ItemSpecification implements Specification<Item> {

    private String name;
    private Integer levelAlco;
    private String time;

    public ItemSpecification setName(String name) {
        this.name = name;
        return this;
    }

    public ItemSpecification setLevelAlco(Integer levelAlco) {
        this.levelAlco = levelAlco;
        return this;
    }

    public ItemSpecification setTime(String time) {
        this.time = time;
        return this;
    }

    @Override
    public Predicate toPredicate(Root<Item> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        }
        if (levelAlco != null) {
            predicates.add(criteriaBuilder.equal(root.get("levelAlco"), levelAlco));
        }
        if (time != null) {
            predicates.add(criteriaBuilder.equal(root.get("time"), time));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
