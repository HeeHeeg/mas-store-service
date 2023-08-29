package com.example.store.domain.response;

import com.example.store.domain.entity.Store;

public record StoreResponse(
        Long id,
        String location,
        String name,
        String img
) {
    public static StoreResponse of(Store store) {
        return new StoreResponse(store.getId(), store.getLocation(), store.getName(), store.getImg());
    }
}
