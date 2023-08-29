package com.example.store.service;

import com.example.store.domain.request.StoreRequest;
import com.example.store.domain.response.StoreResponse;
import com.example.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public void save(StoreRequest request, UUID ownerId) {
        storeRepository.save(request.toEntity(ownerId));
    }

    public List<StoreResponse> getAll() {
        return storeRepository.findAll()
                .stream().map(StoreResponse::of).toList();
    }

    public List<StoreResponse> getByOwnerId(UUID ownerId) {
        return storeRepository.getByOwnerId(ownerId);

    }

    public Page<StoreResponse> getByLocation(String location, PageRequest request) {
        return storeRepository.getByLocation(location, request);
    }
}
