package org.thatguyferg;
import static spark.Spark.*;
import com.google.gson.Gson;

public class CipherResource {

  public static class Encrypted {

    final private String message;

    public Encrypted (final String message) {
      this.message = message;
    }
  }

  public static void main(String[] args) {
    Gson gson = new Gson();

    get("/encrypt/:value", (req, res) -> {
      res.type("application/json");
      CaesarCipher cipher = new CaesarCipher(4);
      return new Encrypted(cipher.encrypt(req.params(":value")));
    },gson::toJson);
  }
}
