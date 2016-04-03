package com.twitter.poruke;
/**
 * Klasa TwitterPoruka
 * 
 * @author Dane Nikolic
 *
 */

public class TwitterPoruka {
	/**
	 * Ime korisnika
	 */
	private String korisnik;
	/**
	 * Poruka
	 */
	private String poruka;
	/**
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Unosi vrednost za ime korisnika
	 * @param korisnik Nova vrednost za ime korisnika
	 * @throws RuntimeException kada ime korisnika nije uneto
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
		throw new RuntimeException(
		"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * 
	 * @return tekst poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Postavlja tekst poruke
	 * @param poruka
	 * @throws RuntimeException kada tekst poruke nije unet ili je tekst kraci od 140 znakova
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
		throw new RuntimeException(
		"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * @return ime korisnika i tekst poruke
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
