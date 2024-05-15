package org.generation.italy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		ArrayList<Integer> mazzo = new ArrayList<Integer>();
		int balance1 = 100, balance2 = 100, bet1, bet2;
		double card, player1Score = 0, player2Score = 0, houseScore = 0, houseCard, playerCard;
		String seme = "pippo", carta = null;
		int extrCard = 0;
		boolean checkBet, checkCard = false;
		System.out.println("Giochiamo a 7 e mezzo!");
		do {
			mazzo.clear();// svuotiamo il mazzo e riempiamolo di carte da 1 a 40
			player1Score = 0;
			player2Score = 0;
			houseScore = 0;
			for (int i = 0; i < 40; i++) {
				mazzo.add(i + 1);
			}
			do {
				System.out.println("Giocatore 1, quanto vuoi puntare? Hai " + balance1 + "€");// puntata
				bet1 = sc.nextInt();
				sc.nextLine();
				if (bet1 <= balance1) {
					balance1 -= bet1;
					checkBet = true;
				} else {
					System.out.println("Non penso proprioh!");
					checkBet = false;
				}
			} while (!checkBet);
			do {
				System.out.println("Giocatore 2, quanto vuoi puntare? Hai " + balance2 + "€");// puntata
				bet2 = sc.nextInt();
				sc.nextLine();
				if (bet2 <= balance2) {
					balance2 -= bet2;
					checkBet = true;
				} else {
					System.out.println("Non penso proprioh!");
					checkBet = false;
				}
			} while (!checkBet);
			System.out.println("Iniziamo!");
			// punteggio iniziale mazziere
			extrCard = r.nextInt(mazzo.size());
			card = mazzo.get(extrCard);
			mazzo.remove(extrCard);
			if (card < 11) {
				seme = "bastoni";
				if (card > 7)
					houseCard = 0.5;
			} else if (card < 21) {
				card -= 10;
				seme = "denara";
			} else if (card < 31) {
				card -= 20;
				seme = "spade";
			} else {
				card -= 30;
				seme = "coppe";
			}
			if (card > 7)
				houseCard = 0.5;
			else
				houseCard = card;
			System.out.println("Il banco ha estratto il " + card + " di " + seme);
			houseScore += houseCard;
			// punteggio iniziale player1
			extrCard = r.nextInt(mazzo.size());
			card = mazzo.get(extrCard);
			mazzo.remove(extrCard);
			if (card < 11) {
				seme = "bastoni";
				if (card > 7)
					playerCard = 0.5;
			} else if (card < 21) {
				card -= 10;
				seme = "denara";
			} else if (card < 31) {
				card -= 20;
				seme = "spade";
			} else {
				card -= 30;
				seme = "coppe";
			}
			if (card > 7)
				playerCard = 0.5;
			else
				playerCard = card;
			if (card == 20) {
				System.out.println("Hai pescato la matta!! Quanto la vuoi far valere?");
				playerCard = sc.nextInt();
				sc.nextLine();
			} else
				System.out.println("Giocatore 1 ha estratto il " + card + " di " + seme);
			player1Score += playerCard;
			// punteggio iniziale player2
			extrCard = r.nextInt(mazzo.size());
			card = mazzo.get(extrCard);
			mazzo.remove(extrCard);
			if (card < 11) {
				seme = "bastoni";
				if (card > 7)
					playerCard = 0.5;
			} else if (card < 21) {
				card -= 10;
				seme = "denara";
			} else if (card < 31) {
				card -= 20;
				seme = "spade";
			} else {
				card -= 30;
				seme = "coppe";
			}
			if (card > 7)
				playerCard = 0.5;
			else
				playerCard = card;
			if (card == 20) {
				System.out.println("Hai pescato la matta!! Quanto la vuoi far valere?");
				playerCard = sc.nextInt();
				sc.nextLine();
			} else
				System.out.println("Giocatore 2 ha estratto il " + card + " di " + seme);
			player2Score += playerCard;
			// scrive punteggi
			System.out.println("Il Banco ha un punteggio di " + houseScore);
			System.out.println("Giocatore 1 ha un punteggio di " + player1Score);
			System.out.println("Giocatore 2 ha un punteggio di " + player2Score);
			// g1 carta o stai
			System.out.println("Giocatore 1, chiedi una carta o stai?");
			carta = sc.nextLine();
			if (carta.equalsIgnoreCase("carta"))
				checkCard = true;
			else
				checkCard = false;
			do {
				if (checkCard) {
					extrCard = r.nextInt(mazzo.size());
					card = mazzo.get(extrCard);
					mazzo.remove(extrCard);
					if (card < 11) {
						seme = "bastoni";
						if (card > 7)
							playerCard = 0.5;
					} else if (card < 21) {
						card -= 10;
						seme = "denara";
					} else if (card < 31) {
						card -= 20;
						seme = "spade";
					} else {
						card -= 30;
						seme = "coppe";
					}
					if (card > 7)
						playerCard = 0.5;
					else
						playerCard = card;
					if (card == 20) {
						System.out.println("Hai pescato la matta!! Quanto la vuoi far valere?");
						playerCard = sc.nextInt();
						sc.nextLine();
					} else
						System.out.println("Hai estratto il " + card + " di " + seme);
					player1Score += playerCard;
					// controlla se il player ha sballato
					if (player1Score > 7.5) {
						System.out.println("Hai fatto " + player1Score + ", hai sballato!!");
						break;
					} else {
						// scrive punteggi
						System.out.println("Il Banco ha un punteggio di " + houseScore);
						System.out.println("Tu hai un punteggio di " + player1Score);

						System.out.println("Chiedi una carta o stai?");
						carta = sc.nextLine();
						if (carta.equalsIgnoreCase("carta"))
							checkCard = true;
						else
							checkCard = false;
					}
				}
			} while (checkCard);

			System.out.println("Giocatore 2, chiedi una carta o stai?");
			carta = sc.nextLine();
			if (carta.equalsIgnoreCase("carta"))
				checkCard = true;
			else
				checkCard = false;
			do {
				if (checkCard) {
					extrCard = r.nextInt(mazzo.size());
					card = mazzo.get(extrCard);
					mazzo.remove(extrCard);
					if (card < 11) {
						seme = "bastoni";
						if (card > 7)
							playerCard = 0.5;
					} else if (card < 21) {
						card -= 10;
						seme = "denara";
					} else if (card < 31) {
						card -= 20;
						seme = "spade";
					} else {
						card -= 30;
						seme = "coppe";
					}
					if (card > 7)
						playerCard = 0.5;
					else
						playerCard = card;
					if (card == 20) {
						System.out.println("Hai pescato la matta!! Quanto la vuoi far valere?");
						playerCard = sc.nextInt();
						sc.nextLine();
					} else
						System.out.println("Hai estratto il " + card + " di " + seme);
					player2Score += playerCard;
					// controlla se il player ha sballato
					if (player2Score > 7.5) {
						System.out.println("Hai fatto " + player2Score + ", hai sballato!! Vince il banco!");
						break;
					} else {
						// scrive punteggi
						System.out.println("Il Banco ha un punteggio di " + houseScore);
						System.out.println("Giocatore 1 ha un punteggio di " + player1Score);
						System.out.println("Tu hai un punteggio di " + player2Score);
						System.out.println("Chiedi una carta o stai?");
						carta = sc.nextLine();
						if (carta.equalsIgnoreCase("carta"))
							checkCard = true;
						else
							checkCard = false;
					}
				}
			} while (checkCard);
			do {
				if (player1Score > 7.5 && player2Score > 7.5)
					break;
				if (houseScore < 5) {
					extrCard = r.nextInt(mazzo.size());
					card = mazzo.get(extrCard);
					mazzo.remove(extrCard);
					if (card < 11) {
						seme = "bastoni";
						if (card > 7)
							playerCard = 0.5;
					} else if (card < 21) {
						card -= 10;
						seme = "denara";
					} else if (card < 31) {
						card -= 20;
						seme = "spade";
					} else {
						card -= 30;
						seme = "coppe";
					}
					if (card > 7)
						houseCard = 0.5;
					else
						houseCard = card;
					System.out.println("Il banco ha estratto il " + card + " di " + seme);
					houseScore += houseCard;
					System.out.println("Il Banco ha un punteggio di " + houseScore);
				}
			} while (houseScore < 5);

			// controlla se il banco ha sballato
			if (houseScore > 7.5 && player1Score <= 7.5 && player2Score <= 7.5) {
				System.out.println("Il banco ha sballato!! Vincono tutti!!");
				balance1 += bet1 * 2;
				balance2 += bet2 * 2;
			} else if (houseScore > 7.5 && player1Score <= 7.5 && player2Score > 7.5) {
				System.out.println("Il banco ha sballato!! Il giocatore 1 vince!!");
				balance1 += bet1 * 2;
			} else if (houseScore > 7.5 && player1Score > 7.5 && player2Score <= 7.5) {
				balance2 += bet2 * 2;
				System.out.println("Il banco ha sballato!! Il giocatore 1 vince!!");
			} else {
				if (houseScore >= player1Score && player1Score <= 7.5)
					// condizione pareggio/vittoria banco
					System.out.println("Il giocatore 1 ha perso!");
				else if (player1Score > houseScore && player1Score <= 7.5) {
					System.out.println("Giocatore 1 vince!!");
					balance1 += bet1 * 2;
				}
				if (houseScore >= player2Score && player2Score <= 7.5)
					// condizione pareggio/vittoria banco
					System.out.println("Il giocatore 2 ha perso!");
				else if (player2Score > houseScore && player2Score <= 7.5) {
					System.out.println("Giocatore 2 vince!!");
					balance2 += bet2 * 2;
				}
			}
		} while (true);
	}

}
