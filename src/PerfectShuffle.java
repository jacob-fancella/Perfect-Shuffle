//Jacob Fancella

import java.util.*;

public class PerfectShuffle {

    private int[] deck, oDeck, tempDeck;
    private int deckS;

    PerfectShuffle(int n) {
        deckS = n;
        oDeck = new int[n];
        deck = new int[n];
        tempDeck = new int[n];
        for (int i = 0; i < n; i++) {
            oDeck[i] = i;
            deck[i] = i;
        }
    }

    public int[] inShuffle(int[] i) {
        for (int x = 0; x < i.length; x++) {
            tempDeck[x] = i[x];
        }
        for (int x = 0; x < deckS; x += 2) {
            i[x] = tempDeck[(x / 2) + 26];
            i[x + 1] = tempDeck[x / 2];
        }
        return i;
    }

    public int perfectInShuffle() {
        int count = 0;
        do {
            deck = this.inShuffle(deck);
            count++;
        } while (!Arrays.equals(deck, oDeck));
        return count;
    }

    public int[] outShuffle(int[] i) {
        for (int x = 0; x < i.length; x++) {
            tempDeck[x] = i[x];
        }
        for (int x = 0; x < deckS; x += 2) {
            i[x] = tempDeck[x / 2];
            i[x + 1] = tempDeck[(x / 2) + 26];
        }
        return i;
    }

    public int perfectOutShuffle() {
        int count = 0;
        do {
            deck = this.outShuffle(deck);

            count++;
        } while (!Arrays.equals(deck, oDeck));
        return count;
    }

    public int[] moveTopCard(int z) {
        int[] deckChange = new int[deck.length];
        for (int x = 0; x < deck.length; x++) {
            deckChange[x] = deck[x];
        }
        String binary = Integer.toBinaryString(z);
        for (int x = 0; x < binary.length(); x++) {
            if (binary.charAt(x) == 49) {
                deckChange = this.inShuffle(deckChange);
            } else if (binary.charAt(x) == 48) {
                deckChange = this.outShuffle(deckChange);
            }
        }
        return deckChange;
    }
}
