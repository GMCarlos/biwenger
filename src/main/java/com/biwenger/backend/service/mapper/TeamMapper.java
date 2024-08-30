package com.biwenger.backend.service.mapper;

import com.biwenger.backend.controller.model.TeamResponse;
import com.biwenger.backend.repository.model.Team;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeamMapper {
  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  TeamResponse toTeamResponse(Team team);

  List<TeamResponse> toTeamResponse(List<Team> teamList);
}
