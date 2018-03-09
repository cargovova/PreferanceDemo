package com.mygame.preferance.demo;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public void CreateFullDeck() {
		for (Suit cardSuit : Suit.values()) {
			for (Value cardValue : Value.values()) {
				this.cards.add(new Card(cardSuit, cardValue));
			}
		}
	}

	public void shuffle() {
		ArrayList<Card> tmpDeck = new ArrayList<Card>();
		Random random = new Random();
		int randomCardIndex = 0;
		int originalSize = this.cards.size();
		for (int i = 0; i < originalSize; i++) {
			// Generate Random
			randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			tmpDeck.add(this.cards.get(randomCardIndex));
			// remove from original deck
			this.cards.remove(randomCardIndex);
		}

		this.cards = tmpDeck;

	}

	// check the number of cards
	public String toString() {
		String cardListOutput = "";
		for (Card aCard : this.cards) {
			cardListOutput += aCard.toString() + "\r\n";
		}
		return cardListOutput;
	}

	// Remove a card from the deck
	public void removeCard(int i) {
		this.cards.remove(i);
	}

	// Get card from deck
	public Card getCard(int i) {
		return this.cards.get(i);
	}

	// Add card to deck
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}

	// Draw a top card from deck
	public void draw(Deck comingFrom) {
		// Add card to this deck from whatever deck its coming from
		this.cards.add(comingFrom.getCard(0));
		// Remove the card in the deck its coming from
		comingFrom.removeCard(0);
	}
}
