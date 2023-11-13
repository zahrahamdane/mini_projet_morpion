package fr.game.morpion;

import static fr.game.morpion.StringConstants.LINE_SEPARATOR;
import static fr.game.morpion.StringConstants.SPACE;

public class Morpion {

	/*
	 * L'attribut grid est un tableau de caractère à deux dimensions de taille 3x3,
	 * ce qui nous permet de définir la grille de jeu du Morpion. Chaque cellule est
	 * initialisée avec un '.' ce qui représente une cellule vide qui n'a pas encore
	 * été remplie par un des joueurs.
	 */
	private char[][] grid = new char[][] { 
		{ '.', '.', '.' }, 
		{ '.', '.', '.' }, 
		{ '.', '.', '.' } 
	};

	public void processInput(Player player, int inputUser) {
		final int row = (inputUser - 1) / 3;
		final int column = (inputUser - 1) % 3;
		
		if(grid[row][column] == '.') {
			if(player.equals(Player.FIRST)) {
				grid[row][column] = 'X';
			}else {
				grid[row][column] = 'O';
			}
		}
	}

	/*
	 * Ensuite, la méthode toString nous permet de définir la fonction d'affichage
	 * de la grille de jeu qui sera appelée à chaque tour de jeu pour montrer son
	 * évolution.
	 */
	@Override
	public String toString() {
		/*
		 * StringBuilder permet de concaténer des chaînes de caractères de manière
		 * optimisée. On alloue un gros bloc de mémoire dès le début et on ajoute au fur
		 * et à mesure des caractères dans ce bloc.  Une fois la chaîne de caractère
		 * complètement construire avec le Builder, on peut la construire avec la
		 * méthode toString de StringBuilder.
		 */
		final StringBuilder builder = new StringBuilder();
		builder.append("Grille du Morpion :").append(LINE_SEPARATOR);

		/*
		 * Pour parcourir la grille de jeu, nous utilisons deux boucles for afin de
		 * parcourir les deux dimensions du tableau.
		 */
		for (char[] lines : grid) {
			for (char cell : lines) {
				builder.append(SPACE).append(cell).append(SPACE);
			}
			builder.append(LINE_SEPARATOR);
		}
		return builder.toString();
	}

}
