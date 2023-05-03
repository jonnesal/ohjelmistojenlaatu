import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.simplilearn.mavenproject.Asiakas;
import com.simplilearn.mavenproject.FakeHinnoittelija;
import com.simplilearn.mavenproject.IHinnoittelija;
import com.simplilearn.mavenproject.Tilaus;
import com.simplilearn.mavenproject.TilaustenKäsittely;
import com.simplilearn.mavenproject.Tuote;

public class TilaustenKäsittelyFakeTest {

	
	@Test
	 public void testaaKäsittelijäWithFakeHinnoittelija() {
	// Arrange
	 float alkuSaldo = 100.0f;
	 float listaHinta = 30.0f;
	 float alennus = 20.0f;
	 float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
	 Asiakas asiakas = new Asiakas(alkuSaldo);
	 Tuote tuote = new Tuote("TDD in Action", listaHinta);
	 IHinnoittelija hinnoittelija = new FakeHinnoittelija(alennus);
	// Act
	 TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
	 käsittelijä.setHinnoittelija(hinnoittelija);
	 käsittelijä.käsittele(new Tilaus(asiakas, tuote));
	 // Assert
	 assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
	 }
	
}
