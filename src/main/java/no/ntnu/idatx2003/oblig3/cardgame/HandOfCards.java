package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.Collection;


/**
 *  A class representing a hand of cards.
 *  A hand of cards is a collection of playing cards.
 *  It has methods to calculate the sum of the cards, get all the cards of a suit, check if a card is in the hand, and check if the hand contains a flush.
 *  It also has a constructor to create a hand of cards with a given collection of cards.
 */
public record HandOfCards(Collection<PlayingCard> cards) {
  /**
   * Creates an instance of a hand of cards with a given collection of cards
   *
   * @param cards the cards in the hand
   */
  public HandOfCards {
    if (cards == null) {
      throw new IllegalArgumentException("List of cards cannot be null");
    }

  }

  /**
   * Returns the cards in the hand
   *
   * @return the cards in the hand
   */
  @Override
  public Collection<PlayingCard> cards() {
    return this.cards;
  }

  /**
   * Calculates and returns the sum of the cards
   *
   * @return sum of the card's faces
   */
  public int getSum() {
    return cards.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Returns all the cards of a suit in the hand
   *
   * @return collection of cards of the suit
   * @throws IllegalArgumentException if the suit is invalid
   */
  public Collection<PlayingCard> getSuit(char suit) throws IllegalArgumentException {
    if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
      throw new IllegalArgumentException("Suit must be one of S, H, D, or C");
    }

    return cards.stream().filter(card -> card.getSuit() == suit).toList();
  }

  /**
   * Checks if a card is in the hand
   *
   * @param suit suit of the card to check for
   * @param face face of the card to check for
   * @return true if the card is in the hand, false otherwise
   * @throws IllegalArgumentException if the suit or face is invalid
   */
  public boolean containsCard(char suit, int face) throws IllegalArgumentException {
    if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C') {
      throw new IllegalArgumentException("Suit must be one of S, H, D, or C");
    }

    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Face must be between 1 and 13");
    }

    return cards.stream().anyMatch(
        card -> card.getSuit() == suit && card.getFace() == face);
  }

  /**
   * Check if the hand contains a flush
   *
   * <p> Internally checks the number of distinct stuis and if the number is 1
   * Then returns true, otherwise false
   *
   * @return true if the hand contains a flush, false otherwise
   */
  public boolean isFlush() {
    return cards.stream().map(PlayingCard::getSuit).distinct().count() == 1;
  }
}