package com.biwenger.backend.repository.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
  @Id private Long id;
  @NotNull private String name;
  @NotNull private String slug;
  @NotNull private String teamID;
  @NotNull private int position;
  @NotNull private int price;
  @NotNull private int fantasyPrice;
  @NotNull private String status;
  @NotNull private int priceIncrement;
  @NotNull private String statusInfo;
  @NotNull private String iconHero;
  @NotNull private int playedHome;
  @NotNull private int playedAway;
  @NotNull private List<String> fitness;
  @NotNull private int points;
  @NotNull private int pointsHome;
  @NotNull private int pointsAway;
  @NotNull private int pointsLastSeason;

  /*
  "id": 30477,
          "name": "Bellingham",
          "slug": "jude-bellingham",
          "teamID": 15,
          "position": 3,
          "price": 16930000,
          "fantasyPrice": 58000000,
          "status": "injured",
          "priceIncrement": -270000,
          "statusInfo": "Lesión en el músculo delgado plantar de su pierna derecha. Retorno estimado: Finales de Septiembre.",
          "iconHero": "i/p/hero/30477.png",
          "playedHome": 0,
          "playedAway": 1,
          "fitness": [
          "injured",
          8],
          "points": 8,
          "pointsHome": 0,
          "pointsAway": 8,
          "pointsLastSeason": 339

   */
}
