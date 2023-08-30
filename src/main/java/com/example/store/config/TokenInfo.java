package com.example.store.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor @NoArgsConstructor
@Builder @Getter
public class TokenInfo  { //토근에 들어갈 정보가 들어갈거다. 패스워드를 제외한 것들이 들어가면 되겠다.
    private UUID id;
    private String name;
    private String number;
    private String role;

}
