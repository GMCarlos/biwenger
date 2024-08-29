package service;

import controller.model.PlayerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.PlayerRepository;
import repository.model.Player;
import service.mapper.PlayerMapper;

import java.io.IOException;
import java.util.List;

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
