package com.beerasta.repository;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    Optional<Item> findById(Long id);

    boolean removeByOwner(User user);

}
