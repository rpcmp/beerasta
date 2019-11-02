package com.beerasta.web.rest;

import com.beerasta.domain.Item;
import com.beerasta.domain.ItemOrder;
import com.beerasta.domain.User;
import com.beerasta.service.ItemOrderService;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class ItemOrderResource {

    private final ItemOrderService itemOrderService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Object> addItemOrder(@RequestParam Long itemId,
                                               @AuthenticationPrincipal UserDetails userDetails) throws NotFoundException {
        User user = userService.findByUsername(userDetails.getUsername());
        log.info(user.toString());
        ItemOrder itemOrder = itemOrderService.addItemOrder(itemId, user);
        log.info(itemOrder.toString());
        return ResponseEntity.ok(itemOrder);
    }

    @GetMapping("/list/by-user-id")
    public ResponseEntity<Object> getItemListByUserId(@RequestParam Long userId) throws NotFoundException {
        List<Item> items = itemOrderService.getListItemByUserId(userId);
        log.info(items.stream().map(Item::toString).collect(Collectors.joining(", ")));
        return ResponseEntity.ok(items);
    }

}
