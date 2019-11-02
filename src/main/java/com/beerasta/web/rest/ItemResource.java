package com.beerasta.web.rest;

import com.beerasta.domain.Item;
import com.beerasta.service.ItemService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RequestMapping("/item")
public class ItemResource {

    private final ItemService itemService;

    @GetMapping("/list")
    public ResponseEntity<Object> getAllItems() {
        List<Item> items = itemService.getAllItems();
        log.info(items.stream().map(Item::toString).collect(Collectors.joining(", ")));
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Object> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

    @GetMapping("/list/by-user-id")
    public ResponseEntity<Object> getAllByUser(@RequestParam Long userId) throws NotFoundException {
        List<Item> items = itemService.getAllByUserId(userId);
        log.info(items.stream().map(Item::toString).collect(Collectors.joining(", ")));
        return ResponseEntity.ok(items);
    }

}
