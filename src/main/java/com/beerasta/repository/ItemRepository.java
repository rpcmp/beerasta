package com.beerasta.repository;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByUser(User user);

    Optional<Item> findById(Long id);

}
