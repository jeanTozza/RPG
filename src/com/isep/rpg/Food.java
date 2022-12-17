package com.isep.rpg;

public class Food extends Consumable {
	private int life_given;

	public Food(int number, int life_given) {
		super(number);
		this.life_given = life_given;
	}

	public int getLife_given() {
		return life_given;
	}

	public void setLife_given(int new_life_given) {
		this.life_given = new_life_given;
	}
}
