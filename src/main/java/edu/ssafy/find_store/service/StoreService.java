package edu.ssafy.find_store.service;

import edu.ssafy.find_store.entitiy.Store;

import java.util.List;

public interface StoreService {
    public List<Store> getNearStore(Float lon, Float lat);
}
