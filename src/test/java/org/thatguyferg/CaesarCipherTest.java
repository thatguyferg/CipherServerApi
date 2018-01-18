package org.thatguyferg;

import static org.junit.Assert.assertEquals;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class CaesarCipherTest {

  @Test
  public void doesitWork() {

    CaesarCipher cipher = new CaesarCipher(4);
    assertEquals("HSK", cipher.encrypt("dog"));
  }

  @Test
  public void numbersNotSupported() {

    assertThatThrownBy(() -> new CaesarCipher(3).encrypt("417"))
     .isInstanceOf(IllegalArgumentException.class)
     .hasMessage("Caesar Cipher is only for alphabetic characters.").hasNoCause();
  }

  @Test
  public void numbersNextToCharacters(){

    assertThatThrownBy(() -> new CaesarCipher(3).encrypt("6dog"))
     .isInstanceOf(IllegalArgumentException.class)
     .hasMessage("Caesar Cipher is only for alphabetic characters.").hasNoCause();
  }

  @Test
  public void noShift(){

    CaesarCipher cipher = new CaesarCipher(0);
    assertEquals("WOW", cipher.encrypt("wow"));
  }
}
