package com.biwenger.backend.service;

import com.biwenger.backend.controller.model.TeamListResponse;
import com.biwenger.backend.controller.model.TeamResponse;
import com.biwenger.backend.repository.TeamRepository;
import com.biwenger.backend.repository.model.Team;
import com.biwenger.backend.service.mapper.TeamMapper;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
  public static final String imageUrl =
      "https://cdn.biwenger.com/cdn-cgi/image/f=avif/i/t/replace.png";
  private final TeamRepository teamRepository;

  private final TeamMapper teamMapper;

  @Cacheable(value = "teamName")
  public TeamListResponse findTeamByName(String teamName) throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    List<TeamResponse> teamResponseList =
        getTeamResponseMapper(teamRepository.findByName(teamName));
    teamResponseList.forEach(
        team -> team.setImageUrl(imageUrl.replace("replace", team.getId().toString())));
    return TeamListResponse.builder().teamListResponse(teamResponseList).build();
  }

  @Cacheable(value = "allTeams")
  public TeamListResponse findAllTeams() throws IOException, URISyntaxException {
    // ToDo try catch para capturar las excepciones
    return TeamListResponse.builder()
        .teamListResponse(getTeamResponseMapper(teamRepository.findAll()))
        .build();
  }

  private List<TeamResponse> getTeamResponseMapper(List<Team> team) {
    return teamMapper.toTeamResponse(team);
  }
}
