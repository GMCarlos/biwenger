package controller;

import controller.model.PlayerResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PlayerService;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlayerResponse> findPlayers(@RequestParam String playerName)
      throws IOException {
    return ResponseEntity.ok(playerService.findApplicablePlayers(playerName));
  }
}
