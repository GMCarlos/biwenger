package com.biwenger.backend.service;

import com.biwenger.backend.controller.model.PlayerResponse;
import com.biwenger.backend.repository.model.Player;
import com.biwenger.backend.service.mapper.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.biwenger.backend.repository.PlayerRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerRepository playerRepository;

  private final PlayerMapper playerMapper;

  public List<PlayerResponse> findApplicablePlayers(String playerName) throws IOException, URISyntaxException {

    return getPlayerResponseMapper(playerRepository.findByName(playerName));
  }

  private List<PlayerResponse> getPlayerResponseMapper(List<Player> player) {
    return playerMapper.toPlayerResponse(player);
  }
}
