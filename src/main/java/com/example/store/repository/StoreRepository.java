package com.example.store.repository;

import com.example.store.domain.entity.Store;
import com.example.store.domain.response.StoreResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("select " +
            "new com.example.store.domain.response " +
            ".StoreResponse(s.id, s.location, s.name, s.img) " +
            "from Store s " +
            "where s.owner.id = :ownerId" )
    List<StoreResponse> getByOwnerId(@Param("ownerId") UUID ownerId);

    @Query("select " +
            "new com.example.store.domain.response " +
            ".StoreResponse(s.id, s.name, s.location, s.img) " +
            "from Store s " +
            "where s.location = :location")
    Page<StoreResponse> getByLocation(@Param("location") String location, PageRequest request);

}
