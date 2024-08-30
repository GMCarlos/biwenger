package com.biwenger.backend.controller;

import com.biwenger.backend.controller.model.PlayerResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biwenger.backend.service.PlayerService;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PlayerResponse>> findPlayers(@RequestParam String playerName)
      throws IOException, URISyntaxException {
    return ResponseEntity.ok(playerService.findApplicablePlayers(playerName));
  }
}
