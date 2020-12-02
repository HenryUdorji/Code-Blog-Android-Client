package com.codemountain.codeblog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthResponse {

    private String email;
    private String authenticationToken;
    private String refreshToken;
    private Long expiresAt;
}
