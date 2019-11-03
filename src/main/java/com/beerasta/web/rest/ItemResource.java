package com.beerasta.web.rest;

import com.beerasta.domain.Item;
import com.beerasta.domain.User;
import com.beerasta.service.ItemService;
import com.beerasta.service.UserService;
import com.beerasta.web.rest.errors.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Object> getAllItems(@RequestParam(value = "name", required = false) String name,
                                              @RequestParam(value = "levelAlco", required = false) Integer levelAlco,
                                              @RequestParam(value = "time", required = false) String time) {
        List<Item> items = itemService.getAllItems(name, levelAlco, time);
        log.info(items.stream().map(Item::toString).collect(Collectors.joining(", ")));
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Object> addItem(@RequestBody Item item) {
        return ResponseEntity.ok(itemService.addItem(item));
    }

}
