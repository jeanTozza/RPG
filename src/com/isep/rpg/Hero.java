package com.isep.rpg;

abstract class Hero extends Combatant {
	private String HeroName;
	private int mana;

	public Hero(String HeroName, int hp, int attack, int defence) {
		super(hp, attack, defence);
		this.HeroName = HeroName;

	}

	public String getHeroName() {
		return HeroName;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int new_mana) {
		this.mana = new_mana;

	}
}
