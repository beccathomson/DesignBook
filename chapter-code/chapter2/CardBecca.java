/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java"
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 *
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter2;

import java.util.Arrays;

/**
 * Implementation of a playing card. This class yields immutable objects.
 */
public class CardBecca
{
    private Rank aRank;
    private Suit aSuit;


    public CardBecca(boolean red, boolean roundSuit, boolean bit1, boolean bit2, boolean bit3, boolean bit4)
    {
        aSuit = calculateSuit(red, roundSuit);
        boolean[] bits = {bit1, bit2, bit3, bit4};
        aRank = calculateRank(bits);
    }

    private Rank calculateRank(boolean[] bits) {
        int rank = 0, n = 0;
        for (int i=bits.length-1; i>= 0; i--)  {
            int digit = bits[i] ? 1 : 0; // true = 1. false = 0
            rank += digit*Math.pow(2, n);
            n++;
        }
        return Rank.values()[rank];
    }

    private Suit calculateSuit(boolean red, boolean roundSuit) {
        if (red) {
            if (roundSuit)
                return Suit.HEARTS;
            else
                return Suit.DIAMONDS;
        } else {
            if (roundSuit)
                return Suit.CLUBS;
            else
                return Suit.SPADES;
        }
    }

    /**
     * @return The rank of the card.
     */
    public Rank getRank()
    {
        return aRank;
    }

    /**
     * @return The suit of the card.
     */
    public Suit getSuit()
    {
        return aSuit;
    }

    public static void main(String[] args) {
        CardBecca cardBecca = new CardBecca(true, true, false, true, true, true);
        System.out.println(cardBecca.toString());
        System.out.println("test");

    }
}
