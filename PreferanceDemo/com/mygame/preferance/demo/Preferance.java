package com.mygame.preferance.demo;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Preferance {
	private static Logger log = Logger.getLogger(Preferance.class.getName());

	public static void main(String[] args) {
		try {
			LogManager.getLogManager().readConfiguration(Preferance.class.getResourceAsStream("/logging.properties"));
		} catch (IOException e) {
			System.err.println("Could not setup logger configuration: " + e.toString());
		}

		log.info("Welcome to Preferance" + "\n");

		// Create playing deck
		Deck playingDeck = new Deck();
		playingDeck.CreateFullDeck();
		playingDeck.shuffle();

		// Create a deck for players
		Deck cardForFirstPlayer = new Deck();
		Deck cardForSecondPlayer = new Deck();
		Deck cardForThirdPlayer = new Deck();
		Deck dealerCards = new Deck();

		// Player ten cards
		for (int i = 0; i < 10; i++) {
			cardForFirstPlayer.draw(playingDeck);
		}
		log.info("First Player: ");
		log.info(cardForFirstPlayer.toString());

		for (int i = 0; i < 10; i++) {
			cardForSecondPlayer.draw(playingDeck);
		}
		log.info("Second Player: ");
		log.info(cardForSecondPlayer.toString());

		for (int i = 0; i < 10; i++) {
			cardForThirdPlayer.draw(playingDeck);
		}
		log.info("Third Player: ");
		log.info(cardForThirdPlayer.toString());

		// Dealer gets two cards
		dealerCards.draw(playingDeck);
		dealerCards.draw(playingDeck);
		log.info("Cards on deck: ");
		log.info(dealerCards.toString());
	}
}
