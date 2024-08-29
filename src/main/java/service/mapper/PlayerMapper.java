package service.mapper;

import controller.model.PlayerResponse;
import org.mapstruct.Mapping;
import repository.model.Player;

public interface PlayerMapper {

    @Mapping(target = "id", source = "player.id")
    @Mapping(target = "name", source = "player.name")
    PlayerResponse toPlayerResponse(Player player);
}
