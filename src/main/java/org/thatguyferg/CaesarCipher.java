package org.thatguyferg;

import java.util.stream.Collectors;

import com.google.common.base.Preconditions;

public class CaesarCipher {

    final private int shift;

    public CaesarCipher(final int shift) {
      this.shift = shift;
    }

    public String encrypt(final String s){
      Preconditions.checkArgument(s.matches("[a-zA-Z]+"),
        "Caesar Cipher is only for alphabetic characters.");
      return s.toUpperCase()
        .chars()
        .boxed()
        .map(c -> String.valueOf((char)((((c.intValue()-65)+shift)%26)+65)))
        .collect(Collectors.joining());
    }
}
