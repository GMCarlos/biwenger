package com.biwenger.backend.controller.model;

import lombok.Builder;

import java.util.List;
@Builder
public class PlayerListResponse {
  public List<PlayerResponse> playerListResponse;
}
