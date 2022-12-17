package com.isep.rpg;

public class Weapon extends Item {
	private int degats;
	private int nombre_utilisation;

	public Weapon(int degats, int nombre_utilisation) {
		this.degats = degats;
		this.nombre_utilisation = nombre_utilisation;
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
