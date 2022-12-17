package com.isep.rpg;

import java.util.*;

abstract class Combatant {
	private int hp;
	private int attack;
	private int defence;

	public Combatant(int hp, int attack, int defence) {
		this.hp = hp;
		this.attack = attack;
		this.defence = defence;

	}

	public int getHp() {
		return hp;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setHp(int new_hp) {
		this.hp = new_hp;
	}

	public void setAttack(int new_attack) {
		this.attack = new_attack;
	}

	public void setDefence(int new_defence) {
		this.defence = new_defence;
	}

	public static void delete(Combatant liste[],Combatant element) {
		Combatant[] new_liste = new Combatant[liste.length-1];
		int k=0;
		for (Combatant i:liste) {
			if (i.getClass()!=element.getClass()) {
			new_liste[k]=i;	
			}
			
			else {
				k=k-1;
			}
			k=k+1;
		}
		liste=new_liste;
		System.out.println(liste[0]);
		
	}


public static void main(String[]args) {
Warrior warrior=new Warrior("Jean",20,3,4);
Simple_Enemy enemy=new Simple_Enemy(20,3,4);
Combatant[] tableau= {enemy,warrior};
delete(tableau,enemy);
}
	
}