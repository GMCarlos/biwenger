package com.biwenger.backend.controller;

import com.biwenger.backend.controller.model.PlayerListResponse;
import com.biwenger.backend.service.PlayerService;
import java.io.IOException;
import java.net.URISyntaxException;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlayerListResponse> findPlayerByName(@RequestParam String playerName)
      throws IOException, URISyntaxException {
    return ResponseEntity.ok(playerService.findPlayerByName(playerName));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PlayerListResponse> findPlayers() throws IOException, URISyntaxException {
    return ResponseEntity.ok(playerService.findAllPlayers());
  }
}
