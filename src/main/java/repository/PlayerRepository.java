package repository;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import repository.model.Player;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Repository
public class PlayerRepository {

  public Optional<Player> findByName(String playerName) throws IOException {
      JSONObject json = new JSONObject(IOUtils.toString(new URL("https://cf.biwenger.com/api/v2/competitions/la-liga/data?lang=es&score=2"), StandardCharsets.UTF_8));


      return null;
  }
}
