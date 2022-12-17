package com.isep.rpg;

abstract class Spellcaster extends Hero {
	private int mana;

	public Spellcaster(String HeroName, int hp, int attack, int defence, int mana) {
		super( HeroName,hp, attack, defence);
		this.mana = mana;
	}

	public int getMana() {
		return mana;
	}
	public void setMana(int new_mana) {
		this.mana=new_mana;
		
	}
}
