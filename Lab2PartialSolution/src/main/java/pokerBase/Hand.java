package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	// private ArrayList<Card> Kickers = new ArrayList<Card>(); TODO: implement kickers for all hands (future labs)
	private HandScore HS = new HandScore();
	private ArrayList<Card> CardsInHand;

	public Hand () { // Makes a Hand
		Deck deck1 = new Deck();
		ArrayList <Card> CardsInHand = new ArrayList<Card>();
		for (int i = 0; i<5; i++) { // Draws five cards from the deck
			CardsInHand.add(deck1.Draw());
		}
		Collections.sort(CardsInHand);  // Sorts by descending rank
	}
	
	public void setCardsInHand(ArrayList<Card> cardsInHand) {
		CardsInHand = cardsInHand;
	}
	
	public HandScore getHandScore() {
		return HS;
	}
	
	public void EvalHand(){ // Evaluates given hand for possible hand types (two pair, full house, etc.)
		Card FirstCard = CardsInHand.get(0); // Indexes Array into separate Cards. Enums could be implemented here.
		Card SecondCard = CardsInHand.get(1);
		Card ThirdCard = CardsInHand.get(2);
		Card FourthCard = CardsInHand.get(3);
		Card FifthCard = CardsInHand.get(4);
		
		// First if loop checks for all possible flushes (all suits are the same)
		if (FirstCard.geteSuit().getiSuitNbr() == SecondCard.geteSuit().getiSuitNbr() && SecondCard.geteSuit().getiSuitNbr() == ThirdCard.geteSuit().getiSuitNbr() && ThirdCard.geteSuit().getiSuitNbr() == FourthCard.geteSuit().getiSuitNbr() && FourthCard.geteSuit().getiSuitNbr() == FifthCard.geteSuit().getiSuitNbr()) {
			if (FifthCard.geteRank().getiRankNbr() == 10) { 
				HS.setHandStrength(100); // ROYAL FLUSH
				HS.setHiHand(0);
				HS.setLoHand(0);
				return;
				}
			else if (FirstCard.geteRank().getiRankNbr() - 1 == SecondCard.geteRank().getiRankNbr() && SecondCard.geteRank().getiRankNbr() - 1 == ThirdCard.geteRank().getiRankNbr() && ThirdCard.geteRank().getiRankNbr() - 1 == FourthCard.geteRank().getiRankNbr() && FourthCard.geteRank().getiRankNbr() - 1 == FifthCard.geteRank().getiRankNbr()){
				HS.setHandStrength(90); // STRAIGHT FLUSH
				HS.setHiHand(FirstCard.geteRank().getiRankNbr());
				HS.setLoHand(0);
				return;
				}
			else {
				HS.setHandStrength(60); // FLUSH
				HS.setHiHand(FirstCard.geteRank().getiRankNbr());
				HS.setLoHand(0);
				return;
				}
		}
		else if (FirstCard.geteRank().getiRankNbr() == FourthCard.geteRank().getiRankNbr() || SecondCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr()){
			HS.setHandStrength(80); // FOUR OF A KIND (1st and 4th card or 2nd and 5th card are the same)
			HS.setHiHand(SecondCard.geteRank().getiRankNbr());
			HS.setLoHand(0);
			return;
		}
		else if ((FirstCard.geteRank().getiRankNbr() == ThirdCard.geteRank().getiRankNbr() && FourthCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr()) || (FirstCard.geteRank().getiRankNbr() == SecondCard.geteRank().getiRankNbr() && ThirdCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr())){
			HS.setHandStrength(70); // FULL HOUSE (1st and 3rd card or 3rd and 5th card are the same)
			if (ThirdCard.geteRank().getiRankNbr() < SecondCard.geteRank().getiRankNbr()) {
				HS.setHiHand(SecondCard.geteRank().getiRankNbr());
				HS.setLoHand(ThirdCard.geteRank().getiRankNbr());
			}
			else {
				HS.setLoHand(FourthCard.geteRank().getiRankNbr());
				HS.setHiHand(SecondCard.geteRank().getiRankNbr());
			}
			return;
		}
		else if (FirstCard.geteRank().getiRankNbr() - 1 == SecondCard.geteRank().getiRankNbr() && SecondCard.geteRank().getiRankNbr() - 1 == ThirdCard.geteRank().getiRankNbr() && ThirdCard.geteRank().getiRankNbr() - 1 == FourthCard.geteRank().getiRankNbr() && FourthCard.geteRank().getiRankNbr() - 1 == FifthCard.geteRank().getiRankNbr()){
			HS.setHandStrength(50); // STRAIGHT (card ranks descend by one)
			HS.setHiHand(FirstCard.geteRank().getiRankNbr());
			HS.setLoHand(0);
			return;
		}
		else if ((FirstCard.geteRank().getiRankNbr() == SecondCard.geteRank().getiRankNbr() && SecondCard.geteRank().getiRankNbr() == ThirdCard.geteRank().getiRankNbr()) || (SecondCard.geteRank().getiRankNbr() == ThirdCard.geteRank().getiRankNbr() && ThirdCard.geteRank().getiRankNbr() == FourthCard.geteRank().getiRankNbr()) || (ThirdCard.geteRank().getiRankNbr() == FourthCard.geteRank().getiRankNbr() && FourthCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr())){
			HS.setHandStrength(40); // THREE OF A KIND (checks 3 permutations)
			HS.setHiHand(ThirdCard.geteRank().getiRankNbr()); // Middle card will always be the one in the 3-of-a-kind
			HS.setLoHand(0);
			return;
		}
		else if ((FirstCard.geteRank().getiRankNbr() == SecondCard.geteRank().getiRankNbr() && FourthCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr()) || (FirstCard.geteRank().getiRankNbr() == SecondCard.geteRank().getiRankNbr() && ThirdCard.geteRank().getiRankNbr() == FourthCard.geteRank().getiRankNbr()) || (SecondCard.geteRank().getiRankNbr() == ThirdCard.geteRank().getiRankNbr() && FourthCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr())){ 
			HS.setHandStrength(30); // 2 PAIRS (checks 3 permutations)
			HS.setHiHand(SecondCard.geteRank().getiRankNbr()); // 2nd card will always be within the higher pair
			HS.setLoHand(FourthCard.geteRank().getiRankNbr()); // conversely, 4th card will always be within the lower pair
			return;
		}
		else if (FirstCard.geteRank().getiRankNbr() == SecondCard.geteRank().getiRankNbr() || SecondCard.geteRank().getiRankNbr() == ThirdCard.geteRank().getiRankNbr() || ThirdCard.geteRank().getiRankNbr() == FourthCard.geteRank().getiRankNbr() || FourthCard.geteRank().getiRankNbr() == FifthCard.geteRank().getiRankNbr()){
			HS.setHandStrength(20); // 1 PAIR (checks 4 permutations)
			HS.setLoHand(0);
			if (FirstCard.geteRank().getiRankNbr() == SecondCard.geteRank().getiRankNbr()){
				HS.setHiHand(FirstCard.geteRank().getiRankNbr());
			}
			else if (SecondCard.geteRank().getiRankNbr() == ThirdCard.geteRank().getiRankNbr()){
				HS.setHiHand(SecondCard.geteRank().getiRankNbr());
				}
			else if (ThirdCard.geteRank().getiRankNbr() == FourthCard.geteRank().getiRankNbr()){
				HS.setHiHand(ThirdCard.geteRank().getiRankNbr());
			}
			else {
				HS.setHiHand(FourthCard.geteRank().getiRankNbr());
			}
			return;
		}
		else {
			HS.setHandStrength(10); // Nothing -> HIGH CARD
			HS.setHiHand(FifthCard.geteRank().getiRankNbr());
			HS.setLoHand(0);
			return;
		}
	}
	}
	
	