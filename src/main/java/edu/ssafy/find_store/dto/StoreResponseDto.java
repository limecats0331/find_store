package edu.ssafy.find_store.dto;

import edu.ssafy.find_store.entitiy.Store;
import lombok.Data;

import java.util.List;

@Data
public class StoreResponseDto {
    List<Store> stores;
}
