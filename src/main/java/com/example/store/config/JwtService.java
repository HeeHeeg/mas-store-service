package com.example.store.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JwtService {
    @Value("${jwt.secret}")
    private String secret;  // 시크릿 키 넣는것.

    //토큰 까는 로직 / 파싱하기
    public TokenInfo parseToken(String token) {
        Claims body = (Claims)Jwts.parserBuilder() // 바디를 Claims로 까줄거임.
                .setSigningKey(secret.getBytes()) //이걸로 까고
                .build()
                .parse(token)
                .getBody();//바디에 모든 데이터가 들어가있으니까 바디를 뽑아주는데,
        TokenInfo info = TokenInfo.builder()
                .id(UUID.fromString(body.get("id", String.class)))
                .number(body.get("number", String.class))
                .name(body.get("name", String.class))
                .role(body.get("role", String.class))
                .build();
        if(info.getRole().equals("OWNER"))
            throw new IllegalArgumentException("403");
        return info;
    }
}
