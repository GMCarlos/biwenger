package com.biwenger.backend.repository.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NextGames {
    private int date;
    private Away away;
    private Round round;
    private long id;
    private Home home;
}
