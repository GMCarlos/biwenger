package com.biwenger.backend.repository.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
  private Long id;
  private String name;
  private String slug;
  private List<NextGames> nextGames;
}
