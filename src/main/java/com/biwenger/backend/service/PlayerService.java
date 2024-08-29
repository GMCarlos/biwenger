package com.biwenger.backend.service;

import com.biwenger.backend.controller.model.PlayerResponse;
import com.biwenger.backend.repository.model.Player;
import com.biwenger.backend.service.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.biwenger.backend.repository.PlayerRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  public PlayerResponse findApplicablePlayers(String playerName) throws IOException {

    return getPlayerResponseMapper(playerRepository.findByName(playerName).orElse(new Player()));
  }

  private PlayerResponse getPlayerResponseMapper(Player player) {
    return playerMapper.toPlayerResponse(player);
  }
}
