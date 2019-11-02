package com.beerasta.service;

import com.beerasta.domain.Item;
import com.beerasta.domain.ItemOrder;
import com.beerasta.domain.User;
import com.beerasta.repository.ItemOrderRepository;
import com.beerasta.repository.ItemRepository;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemOrderService {

    private final ItemOrderRepository itemOrderRepository;
    private final UserService userService;
    private final ItemService itemService;

    public ItemOrder addItemOrder(Long itemId,
                                  User user) throws NotFoundException {
        Item item = itemService.getItemById(itemId);
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setItem(item);
        itemOrder.setUser(user);
        return itemOrderRepository.save(itemOrder);
    }

    public List<Item> getListItemByUserId(Long userId) throws NotFoundException {
        User user = userService.findById(userId);
        return itemOrderRepository.getAllByUser(user)
                .stream().map(ItemOrder::getItem).collect(Collectors.toList());
    }

}
