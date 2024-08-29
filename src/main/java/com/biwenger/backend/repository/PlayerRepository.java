package com.biwenger.backend.repository;

import com.biwenger.backend.repository.model.Player;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository {

  public Optional<Player> findByName(String playerName) throws IOException {
    JSONObject json =
        new JSONObject(
            IOUtils.toString(
                new URL("https://cf.biwenger.com/api/v2/competitions/la-liga/data?lang=es&score=2"),
                StandardCharsets.UTF_8));
    JSONObject data = (JSONObject) json.get("data");
    JSONObject players = (JSONObject) data.get("players");
    Set<String> keyset = players.keySet();
    Iterator<String> keys = keyset.iterator();

    ObjectMapper mapper = new ObjectMapper();

    List<Player> playerList = new ArrayList<>();

    while(keys.hasNext()){
      String key = keys.next();
      Object value = players.get(key);
      playerList.add(mapper.readValue(value.toString(), Player.class));
      System.out.println( key +" : " + value);
    }


    return null;
  }
}
