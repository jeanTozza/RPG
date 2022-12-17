package com.isep.rpg;

abstract class Consumable extends Item {
	private int number;

	public Consumable( int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int new_number) {
		this.number = new_number;
	}
}
