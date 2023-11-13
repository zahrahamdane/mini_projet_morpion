package fr.game.morpion;

import java.util.Scanner;
/*
 *  programmer un morpion très simple.
 *  Il faut afficher la grille du jeu et faire jouer deux joueurs 
 *  qui vont mettre successivement une croix et un cercle.
 *  Le premier joueur qui arrive à faire une ligne gagne. 
 *  Il faut aussi prévoir le cas où il y a égalité.
 */

public class Main {

	public static void main(String[] args) {
		/*
		 * La classe du Scanner pour les entrées utilisateur. nous allons avoir besoin
		 * de saisir un chiffre entre 1 et 9, il faudra donc par la suite gérer les cas
		 * d'erreurs pour toute saisie non attendue.
		 */
		final Scanner input = new Scanner(System.in);
		final Morpion game = new Morpion();
		Player player = Player.FIRST;

		while (true) {

			System.out.println(game);

			/*
			 * A chaque tour du jeu, un joueur entrera un chiffre correspondant à l'une des
			 * cases (0 à 9) Il faudra ensuite remplir la case avec son symbole (croix ou
			 * rond) et passer au deuxième joueur.
			 */
			System.out.println(player + " PLAYER / saisissez un number entre 1 et 9 :");
			final int inputUser = input.nextInt();
			
			game.processInput(player, inputUser);

			// Passer au joueur suivant
			player = nextPlayer(player);

			/*
			 * Il faudra également vérifier les conditions de victoire ou de match nul lors
			 * de chaque tour.
			 */
		}
	}

	private static Player nextPlayer(Player player) {

		if (player.equals(Player.FIRST)) {
			return Player.SECOND;
		} else {
			return Player.FIRST;
		}
	}

}
