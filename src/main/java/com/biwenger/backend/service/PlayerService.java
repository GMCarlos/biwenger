package com.biwenger.backend.service;

import com.biwenger.backend.controller.model.PlayerListResponse;
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

  public PlayerListResponse findPlayerByName(String playerName)
      throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return PlayerListResponse.builder()
        .playerListResponse(getPlayerResponseMapper(playerRepository.findByName(playerName)))
        .build();
  }

  public PlayerListResponse findAllPlayers() throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return PlayerListResponse.builder()
        .playerListResponse(getPlayerResponseMapper(playerRepository.findAll()))
        .build();
  }

  private List<PlayerResponse> getPlayerResponseMapper(List<Player> player) {

    return playerMapper.toPlayerResponse(player);
  }
}
