package com.example.store.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Mens")
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;

    @ManyToOne //나는 많은데 하나의 스토어에 종속되어 있음
    private Store store;
}
