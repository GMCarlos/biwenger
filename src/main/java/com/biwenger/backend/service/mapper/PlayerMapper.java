package com.biwenger.backend.service.mapper;

import com.biwenger.backend.repository.model.Player;
import com.biwenger.backend.controller.model.PlayerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "id", source = "player.id")
    @Mapping(target = "name", source = "player.name")
    PlayerResponse toPlayerResponse(Player player);
}
