package com.example.store.controller;

import com.example.store.domain.request.StoreRequest;
import com.example.store.domain.response.StoreResponse;
import com.example.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    public final StoreService storeService;
    public static UUID uuid = UUID.fromString("405ed220-c89e-4fb1-a405-faaabb4f7ca0"); //토큰을 까서 uuid를 가져와야해서. 우린 테스트 하는거니 그냥 이런식으로 작성.

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postStore(@RequestBody StoreRequest request) {
        storeService.save(request, uuid);
    }

    @GetMapping("/owner")
    public List<StoreResponse> getByOwnerId() {
        return storeService. getByOwnerId(uuid);
    }

    @GetMapping
    public Page<StoreResponse> getByLocation(
            @RequestParam(required = true, name = "location") String location,
            @RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, name = "size", defaultValue = "10") Integer size
    ) {
        return storeService.getByLocation(location, PageRequest.of(page, size));
    }

}
