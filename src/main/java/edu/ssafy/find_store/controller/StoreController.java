package edu.ssafy.find_store.controller;

import edu.ssafy.find_store.entitiy.Store;
import edu.ssafy.find_store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public List<Store> getNearStores(@RequestParam("lon") Float lon, @RequestParam("lat") Float lat) {
        return storeService.getNearStore(lon, lat);
    }
}
