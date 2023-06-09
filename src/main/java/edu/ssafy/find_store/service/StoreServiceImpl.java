package edu.ssafy.find_store.service;

import edu.ssafy.find_store.entitiy.Store;
import edu.ssafy.find_store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    @Override
    public List<Store> getNearStore(Float lon, Float lat) {
        return storeRepository.findStoreByDistance(lat, lon);
    }
}
