package com.isep.rpg;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Game {
	public static int scannerInt(String msg, int min, int max) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println(msg);
			choice = scanner.nextInt();
			if ((choice < min) || (choice > max)) {
				System.out.println("Réponse incorrect,veuillez recommencer");
			}
		} while ((choice < min) || (choice > max));
		return choice;

	}

	public static String scannerHero(String msg) {
		Scanner scanner = new Scanner(System.in);
		String choice =null;
		do {
			System.out.println(msg);
			choice=scanner.next();
			if ((!choice.contentEquals("Warrior"))&&(!choice.contentEquals("Hunter"))&&(!choice.contentEquals("Mage"))&&(!choice.contentEquals("Healer"))) {
				System.out.println("Réponse incorrect,veuillez recommencer");
			}
		}while((!choice.contentEquals("Warrior"))&&(!choice.contentEquals("Hunter"))&&(!choice.contentEquals("Mage"))&&(!choice.contentEquals("Healer")));
		return choice;
	}

	public static void creation_heros(List<Hero> liste, int n) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			String nom_hero = scannerHero("Sélectionnez un type de héro: Warrior, Hunter,Mage,Healer.");
			if (nom_hero.contentEquals("Warrior")) {
				System.out.println("Nommez votre héro");
				String new_name = scanner.next();
				Warrior player = new Warrior(new_name, 20, 5, 3);
				liste.add(player);
			}
			if (nom_hero.contentEquals("Hunter")) {
				System.out.println("Nommez votre héro");
				String new_name = scanner.next();
				Hunter player = new Hunter(new_name, 17, 6, 4);
				liste.add(player);

			}
			if (nom_hero.contentEquals("Mage")) {
				System.out.println("Nommez votre héro");
				String new_name = scanner.next();
				Mage player = new Mage(new_name, 30, 12, 0, 30);

				liste.add(player);
			}
			if (nom_hero.contentEquals("Healer")) {
				System.out.println("Nommez votre héro");
				String new_name = scanner.next();
				Healer player = new Healer(new_name, 20, 1, 1, 20);

				liste.add(player);

			}
		}

		System.out.print("Voici votre équipe de choc: ");
		for (Hero j : liste) {
			System.out.print(j.getClass().getSimpleName() + " " + j.getHeroName() + ", ");
		}
		System.out.println();
	}

	public static void creation_enemy(List<Enemy> liste, int nombre) {
		for (int i = 0; i < nombre; i++) {
			Simple_Enemy enemy = new Simple_Enemy(15, 6, 3);
			liste.add(enemy);
		}
		for (int j = 0; j < liste.size() - 1; j++) {
			System.out.print(liste.get(j).getClass().getSimpleName());
		}
		System.out.println(liste.get(liste.size() - 1).getClass().getSimpleName());

	}

	public static void creation_item(List<List<Item>> liste_item, List<Hero> liste_hero) {
		for (int i = 0; i < liste_hero.size(); i++) {
			if (liste_hero.get(i).getClass().getSimpleName().contentEquals("Warrior")) {
				List<Item> liste = new ArrayList<>();
				liste_item.add(liste);
				Weapon Epee = new Weapon(12, 1000000000);
				liste_item.get(i).add(Epee);
				Food food = new Food(2, 5);
				liste_item.get(i).add(food);
			}
			if (liste_hero.get(i).getClass().getSimpleName().contentEquals("Hunter")) {
				List<Item> liste = new ArrayList<>();
				liste_item.add(liste);
				Weapon Arc = new Weapon(14, 8);
				liste_item.get(i).add(Arc);
				Food fooda = new Food(2, 5);
				liste_item.get(i).add(fooda);

			}
			if (liste_hero.get(i).getClass().getSimpleName().contentEquals("Mage")) {
				List<Item> liste = new ArrayList<>();
				liste_item.add(liste);
				Weapon Boule_feu = new Weapon(18, 5);
				liste_item.get(i).add(Boule_feu);
				Food fooda = new Food(2, 15);
				liste_item.get(i).add(fooda);
				Potion potion_magique = new Potion(2, 15);
				liste_item.get(i).add(potion_magique);

			}
			if (liste_hero.get(i).getClass().getSimpleName().contentEquals("Healer")) {
				List<Item> liste = new ArrayList<>();
				liste_item.add(liste);
				Weapon baton_magique = new Weapon(5, 5);
				liste_item.get(i).add(baton_magique);
				Food fooda = new Food(2, 15);
				liste_item.get(i).add(fooda);
				Potion potion_magique = new Potion(2, 15);
				liste_item.get(i).add(potion_magique);

			}

		}
	}

	public static void caracteristiques(List<List<Item>> liste_item, List<Hero> liste_hero) {
		int choix = scannerInt("Voulez-vous connaitre les caractéristiques de vos héros?    1-Oui   2-Non", 1, 2);
		if (choix == 1) {
			for (int i = 0; i < liste_hero.size(); i++) {
				System.out.println(
						liste_hero.get(i).getClass().getSimpleName() + " " + liste_hero.get(i).getHeroName() + " :");
				System.out.println("Dégats de l'arme: " + liste_item.get(i).get(0).getDegats());
				System.out.println("Défense: " + liste_hero.get(i).getDefence());
				System.out.println("Nourriture: " + liste_item.get(i).get(1).getNumber() + " steaks");
				if ((liste_hero.get(i).getClass().getSimpleName().contentEquals("Mage"))
						|| (liste_hero.get(i).getClass().getSimpleName().contentEquals("Healer"))) {
					System.out.println("Mana: " + liste_hero.get(i).getMana());
				}
			}
		}
	}

	public static void caractennemy(List<Enemy> liste) {
		int choix = scannerInt("Voulez-vous connaitre les caractéristiques de vos ennemis?    1-Oui   2-Non", 1, 2);
		if (choix == 1) {
			for (int i = 0; i < liste.size(); i++) {
				System.out.println(liste.get(i).getClass().getSimpleName());
				System.out.println("Dégats de l'arme: " + liste.get(i).getAttack());
				System.out.println("Défense: " + liste.get(i).getDefence());

			}
			System.out.println("***********");
		}
	}

	public static void methode_combat(Hero player, Combatant enemy, List<List<Item>> liste_item, int i) {
		int attack;
		if (player.getClass().getSimpleName().contentEquals("Mage")) {
			if (player.getMana() - liste_item.get(i).get(0).getNombre_Utilisation() > 0) {
				attack = liste_item.get(i).get(0).getDegats();
				player.setMana(player.getMana() - liste_item.get(i).get(0).getNombre_Utilisation());
				System.out.println("Il vous reste " + player.getMana() + " manas");
			} else {
				attack = player.getAttack();
			}
		} else {
			if (liste_item.get(i).get(0).getNombre_Utilisation() != 0) {
				attack = liste_item.get(i).get(0).getDegats();
				liste_item.get(i).get(0).setNombre_Utilisation(liste_item.get(i).get(0).getNombre_Utilisation() - 1);

			} else {
				attack = player.getAttack();
			}
		}
		int after_defence = attack - enemy.getDefence();
		if (after_defence > 0) {

			int new_hp = enemy.getHp() - after_defence;

			if (new_hp > 0) {
				enemy.setHp(new_hp);
			}
			if (new_hp <= 0) {
				enemy.setHp(0);
			}

		}
		if (player.getClass().getSimpleName().contentEquals("Hunter")) {
			System.out.println(
					"Il ne vous reste plus que " + liste_item.get(i).get(0).getNombre_Utilisation() + " flèches");
		}
	}

	public static void guerison(Hero player, Hero player1, List<List<Item>> liste_item, int i) {
		int heal;
		int yo = player1.getMana() - liste_item.get(i).get(0).getNombre_Utilisation();
		if (yo >= 0) {
			heal = liste_item.get(i).get(0).getDegats();
			player1.setMana(yo);
		} else {
			heal = player1.getAttack();
		}
		player.setHp(player.getHp() + heal);
		System.out.println("Il vous reste " + player1.getMana() + " manas");
		System.out.println(
				"Santé de " + player.getClass().getSimpleName() + " " + player.getHeroName() + " : " + player.getHp());
	}

	public static void methode_combat1(Combatant player, Combatant enemy) {
		int after_defence = player.getAttack() - enemy.getDefence();
		if (after_defence > 0) {

			int new_hp = enemy.getHp() - after_defence;

			if (new_hp > 0) {
				enemy.setHp(new_hp);
			}
			if (new_hp <= 0) {
				enemy.setHp(0);
			}

		}
	}

	public static void combat(List<Enemy> enemy_liste, List<Hero> hero_liste, List<List<Item>> liste_item) {
		while ((enemy_liste.size() != 0) && (hero_liste.size() != 0)) {

			for (int i = 0; i < hero_liste.size(); i++) {
				System.out.println("C'est au tour de " + hero_liste.get(i).getClass().getSimpleName() + " "
						+ hero_liste.get(i).getHeroName());
				int choix = 0;
				if (hero_liste.get(i).getClass().getSimpleName().contentEquals("Healer")) {
					choix = scannerInt(
							"Choisissez:1-Guérir un héro, 2- Se défendre, 3-Manger de la nourriture, 4-Boire une potion",
							1, 4);
				} else {
					if (liste_item.get(i).get(1).getNumber() == 0) {
						choix = scannerInt("Choisissez:1-Attaquer, 2- Se défendre, 4-Boire une potion(si Spellcaster)",
								1, 4);
					} else {
						choix = scannerInt(
								"Choisissez:1-Attaquer, 2- Se défendre, 3-Manger de la nourriture, 4-Boire une potion(si Spellcaster)",
								1, 4);
					}
				}
				Scanner scanner = new Scanner(System.in);

				if (choix == 1) {
					if (hero_liste.get(i).getClass().getSimpleName().contentEquals("Healer")) {
						System.out.print("Choisissez un héro à guérir:");
						for (int k = 0; k < hero_liste.size(); k++) {
							System.out.print(", " + k + "-" + hero_liste.get(k).getClass().getSimpleName() + " "
									+ hero_liste.get(k).getHeroName());
						}
						int choix1 = scanner.nextInt();
						guerison(hero_liste.get(choix1), hero_liste.get(i), liste_item, i);
					} else {
						if (enemy_liste.size() != 0) {
							methode_combat(hero_liste.get(i), enemy_liste.get(0), liste_item, i);
							System.out.println("Santé de l'ennemi:  " + enemy_liste.get(0).getHp());
							if (enemy_liste.get(0).getHp() == 0) {
								System.out.println("Vous avez vaincu un ennemi");
								enemy_liste.remove(0);
							}
						}
					}
				}
				if (choix == 2) {
				}
				if (choix == 3) {
					int l = liste_item.get(i).get(1).getNumber();
					hero_liste.get(i).setHp(hero_liste.get(i).getHp() + liste_item.get(i).get(1).getLife_given());
					l--;
					liste_item.get(i).get(1).setNumber(l);
					System.out.println("Santé de " + hero_liste.get(i).getClass().getSimpleName() + " "
							+ hero_liste.get(i).getHeroName() + ": " + hero_liste.get(i).getHp());
					System.out.println("Vous n'avez plus que " + liste_item.get(i).get(1).getNumber() + " steak");
				}
				if (choix == 4) {
					int l = liste_item.get(i).get(2).getNumber();
					hero_liste.get(i).setMana(hero_liste.get(i).getMana() + liste_item.get(i).get(2).getMana_given());
					l--;
					liste_item.get(i).get(2).setNumber(l);
					System.out.println("Point de mana de " + hero_liste.get(i).getClass().getSimpleName() + " "
							+ hero_liste.get(i).getHeroName() + ":" + hero_liste.get(i).getHp());
					System.out.println("Vous n'avez plus que " + liste_item.get(i).get(2).getNumber() + " potions");
				}
				if ((enemy_liste.size() != 0) && (choix != 2)) {
					System.out.println("L'ennemi vous attaque");
					methode_combat1(enemy_liste.get(0), hero_liste.get(i));
					System.out.println("Santé de " + hero_liste.get(i).getClass().getSimpleName() + ": "
							+ hero_liste.get(i).getHp());
					if (hero_liste.get(i).getHp() == 0) {
						System.out.println("Vous avez perdu votre " + hero_liste.get(i).getClass().getSimpleName() + " "
								+ hero_liste.get(i).getHeroName());
						for (int k = 0; k < hero_liste.size(); k++) {
							if (hero_liste.get(k).getHeroName() == hero_liste.get(i).getHeroName()) {
								hero_liste.remove(k);
								liste_item.remove(k);

							}
						}
					}

				}
			}
		}

		if (enemy_liste.size() == 0) {
			System.out.println("Vous avez vaincu tout les ennemis de la manche!Bravo à vous");
		} else {
			System.out.println("Vous avez perdu,veuillez recommencer la manche");
		}
	}

	public static void victoire(List<Hero> hero_liste, List<List<Item>> liste_item) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Vous pouvez améliorer vos héros, choisissez entre:1-augmenter les dégats de votre héro,2-augmenter la défense de votre héro,3-augmenter l'efficacité de la potion,4-augmenter l'efficacité de la nourriture,5-augmenter le nombre de nourriture,6- augmenter le nombre de potion,7-augmenter le nombre de flèches(Pour Hunter) , 8-augmenter le mana(Pour Spellcaster)");

		for (int i = 0; i < hero_liste.size(); i++) {
			int choix = scannerInt("Pour le héro " + hero_liste.get(i).getClass().getSimpleName() + " "
					+ hero_liste.get(i).getHeroName(), 1, 8);
			if (choix == 1) {
				liste_item.get(i).get(0).setDegats(liste_item.get(i).get(0).getDegats() + 5);
				System.out.println("nouveau nombre de dégats de l'attaque: " + liste_item.get(i).get(0).getDegats());
			} else if (choix == 2) {
				hero_liste.get(i).setDefence(hero_liste.get(i).getDefence() + 3);
				System.out.println("nouvelle efficacité de la défense: " + hero_liste.get(i).getDefence());
			} else if (choix == 3) {
				liste_item.get(i).get(2).setMana_given(liste_item.get(i).get(2).getMana_given() + 4);
				System.out.println("Nouveau taux de mana de la potion: " + liste_item.get(i).get(2).getMana_given());
			} else if (choix == 4) {
				liste_item.get(i).get(1).setLife_given(liste_item.get(i).get(1).getLife_given() + 4);
				System.out.println("Nouvelle vie générée par un steak: " + liste_item.get(i).get(1).getLife_given());
			} else if (choix == 5) {
				liste_item.get(i).get(1).setNumber(liste_item.get(i).get(1).getNumber() + 2);
				System.out.println("Nombre de steaks: " + liste_item.get(i).get(1).getNumber());
			} else if (choix == 6) {
				liste_item.get(i).get(1).setNumber(liste_item.get(i).get(2).getNumber() + 2);
				System.out.println("Nombre de potions: " + liste_item.get(i).get(2).getNumber());
			} else if (choix == 7) {
				liste_item.get(i).get(0).setNombre_Utilisation(liste_item.get(i).get(0).getNombre_Utilisation() + 4);
				System.out.println("Nombre de flèches:" + liste_item.get(i).get(0).getNombre_Utilisation());
			} else if (choix == 8) {
				hero_liste.get(i).setMana(hero_liste.get(i).getMana() + 10);
				System.out.println("Vous disposez de " + hero_liste.get(i).getMana() + " manas");
			}

		}

	}

	public static void main(String[] args) {

		int nombre_hero = scannerInt("choisissez un nombre de héro(maximum 5 joueurs)", 0, 5);
		List<Hero> liste_hero = new ArrayList<>();
		List<Enemy> liste_enemy = new ArrayList<>();
		List<List<Item>> liste_item = new ArrayList<>();
		creation_heros(liste_hero, nombre_hero);

		creation_item(liste_item, liste_hero);
		caracteristiques(liste_item, liste_hero);
		System.out.println("********************************");
		System.out.println("1ère vague:");
		System.out.print("Vous allez affronter:");
		creation_enemy(liste_enemy, nombre_hero);
		caractennemy(liste_enemy);

		combat(liste_enemy, liste_hero, liste_item);
		victoire(liste_hero, liste_item);

	}
}
