
package mockesimerkki;

import com.simplilearn.mavenproject.Asiakas;
import com.simplilearn.mavenproject.IHinnoittelija;
import com.simplilearn.mavenproject.Tilaus;
import com.simplilearn.mavenproject.Tuote;

/*
 * public void käsittele(Tilaus tilaus) {
 Asiakas asiakas = tilaus.getAsiakas();
 Tuote tuote = tilaus.getTuote();
 hinnoittelija.aloita();
 float prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);
 if (tuote.getHinta() >= 100) {
 hinnoittelija.setAlennusProsentti(asiakas, prosentti + 5);
 }
 prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);
 float alennusHinta = tuote.getHinta() * (1 - (prosentti / 100));
 asiakas.setSaldo(asiakas.getSaldo() - alennusHinta);
 
 */
public class TilaustenKäsittely {

	private IHinnoittelija hinnoittelija;

	public void setHinnoittelija(IHinnoittelija hinnoittelija) {
		this.hinnoittelija = hinnoittelija;
	}

	public void käsittele(Tilaus tilaus) {

		Asiakas asiakas = tilaus.getAsiakas();
		Tuote tuote = tilaus.getTuote();

		hinnoittelija.aloita();
		float prosentti = hinnoittelija.getAlennusProsentti(asiakas, tuote);

		if (tuote.getHinta() >= 100) {
			hinnoittelija.setAlennusProsentti(asiakas, prosentti + 5);
			prosentti += 5;
		}

		float alennusHinta = tuote.getHinta() * (1 - (prosentti / 100));
		asiakas.setSaldo(asiakas.getSaldo() - alennusHinta);
		hinnoittelija.lopeta();
	}

}
