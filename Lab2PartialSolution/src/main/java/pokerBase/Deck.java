package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {
	
	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				deckCards.add(new Card(eSuit, eRank, iCardNbr++));
			}
		}
		Collections.shuffle(deckCards);
	}
	
	public ArrayList<Card> getDeckCards() {
		return deckCards;
	}

	public Card Draw(){
		Card drawnCard = deckCards.get(0);
		deckCards.remove(0);
		System.out.println("You drew a " + drawnCard.geteRank() + " of " + drawnCard.geteSuit());
		return drawnCard;
	}
	
	public int DeckSize(){
		return deckCards.size();
	}
	
	
}
