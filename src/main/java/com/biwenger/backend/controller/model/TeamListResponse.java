package com.biwenger.backend.controller.model;

import java.util.List;
import lombok.Builder;

@Builder
public class TeamListResponse {
  public List<TeamResponse> teamListResponse;
}
