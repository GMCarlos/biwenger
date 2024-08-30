package com.biwenger.backend.service.mapper;

import com.biwenger.backend.controller.model.PlayerResponse;
import com.biwenger.backend.repository.model.Player;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  PlayerResponse toPlayerResponse(Player player);

  List<PlayerResponse> toPlayerResponse(List<Player> players);
}
