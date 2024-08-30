package com.biwenger.backend.controller.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponse {
    public Long id;
    public String name;
    public String imageUrl;
}
