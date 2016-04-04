package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Klasa Twitter
 * @author Dane
 * @version 2.8.1
 */
public class Twitter {
	/**
	 * Lista poruka
	 */
	private LinkedList<TwitterPoruka> poruke =
	new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja vraca listu svih poruka
	 * @return Sve poruke
	 **/
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda koja unosi novu Twitter poruku
	 * @param korisnik ime korisnika
	 * @param poruka sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda koja vraca sve poruke zadatog kapaciteta i koje u sebi sadrze zadati tag
	 *  @throws java.lang.RuntimeException Ako tag ima vrednost:
  	 * <ul> 
  	 * 		<li>null</li>
  	 * 		<li>prazan string</li>
  	 * </ul>
	 * @param maxBroj maksimalan broj poruka
	 * @param tag string koji zelimo da pretrazimo
	 * @return niz poruka koje sadrze tag
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
		throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		 //Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; 
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
			if (brojac < maxBroj){
			rezultat[brojac]=poruke.get(i);
			brojac++;
		}
		else break;
		return rezultat;
		}
}