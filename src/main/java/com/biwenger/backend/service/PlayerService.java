package com.biwenger.backend.service;

import com.biwenger.backend.controller.model.PlayerResponse;
import com.biwenger.backend.repository.PlayerRepository;
import com.biwenger.backend.repository.model.Player;
import com.biwenger.backend.service.mapper.PlayerMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  public List<PlayerResponse> findPlayerByName(String playerName)
      throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return getPlayerResponseMapper(playerRepository.findByName(playerName));
  }

  public List<PlayerResponse> findAllPlayers() throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return getPlayerResponseMapper(playerRepository.findAll());
  }

  private List<PlayerResponse> getPlayerResponseMapper(List<Player> player) {

    return playerMapper.toPlayerResponse(player);
  }
}
