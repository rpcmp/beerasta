package com.beerasta.web.rest;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.service.ItemService;
import com.beerasta.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/api/item")
public class ItemResource {

    private final ItemService itemService;
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Object> getAllItems(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam(value = "levelAlco", required = false) Integer levelAlco,
                                              @RequestParam(value = "time", required = false) String time,
                                              @RequestParam("username") String username) {
        User user = userService.findByUsername(username);
        log.info(user.toString());
        List<Item> items = itemService.getAllItems(name, levelAlco, time, user);
        log.info(items.stream().map(Item::toString).collect(Collectors.joining(", ")));
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Object> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

}
