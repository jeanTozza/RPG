package com.isep.rpg;

public class Item {
	private int number;
	private int life_given;
	private int mana_given;
	private int degats;
	private int nombre_utilisation;

	public Item() {

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int new_number) {
		this.number = new_number;
	}

	public int getLife_given() {
		return life_given;
	}

	public void setLife_given(int new_life_given) {
		this.life_given = new_life_given;
	}

	public int getMana_given() {
		return mana_given;
	}

	public void setMana_given(int new_mana_given) {
		this.mana_given = new_mana_given;
	}

	public int getNombre_Utilisation() {
		return nombre_utilisation;
	}

	public int getDegats() {
		return degats;
	}

	public void setDegats(int new_degats) {
		this.degats = new_degats;
	}

	public void setNombre_Utilisation(int new_nombre) {
		this.nombre_utilisation = new_nombre;
	}

}
