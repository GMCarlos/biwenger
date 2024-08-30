package com.biwenger.backend.repository;

import com.biwenger.backend.repository.model.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository {

  public static final String imageUrl =
      "https://cdn.biwenger.com/cdn-cgi/image/f=avif/i/p/replace.png";

  public List<Player> findAll() throws IOException, URISyntaxException {
    JSONObject json =
        new JSONObject(
            IOUtils.toString(
                new URI("https://cf.biwenger.com/api/v2/competitions/la-liga/data?lang=es&score=2")
                    .toURL(),
                StandardCharsets.UTF_8));
    JSONObject data = (JSONObject) json.get("data");
    JSONObject players = (JSONObject) data.get("players");
    Set<String> keyset = players.keySet();
    Iterator<String> keys = keyset.iterator();

    ObjectMapper mapper = new ObjectMapper();

    List<Player> playerList = new ArrayList<>();

    while (keys.hasNext()) {
      String key = keys.next();
      Object value = players.get(key);
      Player player = mapper.readValue(value.toString(), Player.class);
      player.setIconHero(imageUrl.replace("replace", player.getId().toString()));
      playerList.add(player);
      System.out.println(key + " : " + value);
    }

    return playerList;
  }

  public List<Player> findByName(String playerName) throws IOException, URISyntaxException {
    List<Player> playerList = findAll();

    return playerList.stream()
        .filter(player -> player.getName().toUpperCase().contains(playerName.toUpperCase()))
        .toList();
  }
}
