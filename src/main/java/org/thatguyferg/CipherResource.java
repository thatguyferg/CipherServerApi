package org.thatguyferg;
import static spark.Spark.*;

public class CipherResource {

  public static void main(String[] args) {
    get("/hello/:name", (req, res) -> {
      return "Hello: " + req.params(":name");
    });
  }
}
