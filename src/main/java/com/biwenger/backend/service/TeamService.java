package com.biwenger.backend.service;

import com.biwenger.backend.controller.model.TeamResponse;
import com.biwenger.backend.repository.TeamRepository;
import com.biwenger.backend.repository.model.Team;
import com.biwenger.backend.service.mapper.TeamMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
  private final TeamRepository teamRepository;

  private final TeamMapper teamMapper;

  public List<TeamResponse> findTeamByName(String teamName) throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return getTeamResponseMapper(teamRepository.findByName(teamName));
  }

  public List<TeamResponse> findAllTeams() throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return getTeamResponseMapper(teamRepository.findAll());
  }

  private List<TeamResponse> getTeamResponseMapper(List<Team> team) {
    return teamMapper.toTeamResponse(team);
  }
}
