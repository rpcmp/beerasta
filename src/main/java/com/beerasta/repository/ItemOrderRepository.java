package com.beerasta.repository;

import com.beerasta.domain.ItemOrder;
import com.beerasta.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {

    List<ItemOrder> getAllByUser(User user);

}
