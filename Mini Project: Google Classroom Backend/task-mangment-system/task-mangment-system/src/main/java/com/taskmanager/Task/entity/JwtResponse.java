package com.taskmanager.Task.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data

public class JwtResponse {
    private String jwtToken;

    private String username;
}
