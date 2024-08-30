package com.biwenger.backend.repository.model;

import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
  private Long id;
  private String name;
  private String slug;
  private String teamID;
  private int position;
  private int price;
  private int fantasyPrice;
  private String status;
  private int priceIncrement;
  private String statusInfo;
  private String iconHero;
  private int playedHome;
  private int playedAway;
  private List<String> fitness;
  private int points;
  private int pointsHome;
  private int pointsAway;
  private int pointsLastSeason;
}
