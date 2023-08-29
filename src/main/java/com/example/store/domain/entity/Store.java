package com.example.store.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Stores")
@Entity
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @Getter
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String name;
    private String img;

    @ManyToOne //나는 많은데 나의 오너는 한명이야
    private  Owner owner;

    @OneToMany(mappedBy = "store")
    private List<Menu> menus;
}

