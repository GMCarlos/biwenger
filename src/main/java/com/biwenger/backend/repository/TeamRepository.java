package com.biwenger.backend.repository;

import com.biwenger.backend.repository.model.Team;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository {

  public List<Team> findAll() throws IOException, URISyntaxException {
    JSONObject json =
        new JSONObject(
            IOUtils.toString(
                new URI("https://cf.biwenger.com/api/v2/competitions/la-liga/data?lang=es&score=2")
                    .toURL(),
                StandardCharsets.UTF_8));
    JSONObject data = (JSONObject) json.get("data");
    JSONObject teams = (JSONObject) data.get("teams");
    Set<String> keyset = teams.keySet();
    Iterator<String> keys = keyset.iterator();

    ObjectMapper mapper = new ObjectMapper();

    List<Team> teamList = new ArrayList<>();

    while (keys.hasNext()) {
      String key = keys.next();
      Object value = teams.get(key);
      teamList.add(mapper.readValue(value.toString(), Team.class));
      System.out.println(key + " : " + value);
    }

    return teamList;
  }

  public List<Team> findByName(String teamName) throws IOException, URISyntaxException {
    List<Team> teamList = findAll();

    return teamList.stream()
        .filter(team -> team.getName().toUpperCase().contains(teamName.toUpperCase()))
        .toList();
  }
}
