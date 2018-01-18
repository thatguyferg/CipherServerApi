package org.thatguyferg;
import static spark.Spark.*;

public class CipherResource {

  public static void main(String[] args) {
    get("/encrypt/:value", (req, res) -> {
      CaesarCipher cipher = new CaesarCipher(4);
      return "Encrypted: " + cipher.encrypt(req.params(":value"));
    });
  }
}
