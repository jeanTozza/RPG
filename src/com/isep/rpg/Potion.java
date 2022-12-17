package com.isep.rpg;

public class Potion extends Consumable {
private int mana_given;
public Potion(int number, int mana_given) {
	super(number);
	this.mana_given=mana_given;
	
}
public int getMana_given() {
	return mana_given;
}
public void setMana_given(int new_mana_given) {
	this.mana_given=new_mana_given;
}

}
