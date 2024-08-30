package com.biwenger.backend.controller;

import com.biwenger.backend.controller.model.TeamListResponse;
import com.biwenger.backend.service.TeamService;
import java.io.IOException;
import java.net.URISyntaxException;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {
  private final TeamService teamService;

  @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TeamListResponse> findTeamByName(@RequestParam String teamName)
      throws IOException, URISyntaxException {
    return ResponseEntity.ok(teamService.findTeamByName(teamName));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TeamListResponse> findTeams() throws IOException, URISyntaxException {
    return ResponseEntity.ok(teamService.findAllTeams());
  }
}
