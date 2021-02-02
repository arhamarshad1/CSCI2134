/**
   File: ChickenBot.java
   Author: Alex Brodsky
   Date: September 21, 2015
   Purpose: CSCI 1110, Assignment 4 Solution

   Description: This class specifies the ChickenBot class.
*/


/**
   This is the ChickenBot class for representing ChickenBots and their 
   behaviours on the planet DohNat.  
*/
public class ChickenBot extends TimBot {

  public static final int EMPTY_DISTRICT_PENALTY = 2000;
  public static final int ADJACENT_DISTRICT_PENALTY = 1000;

  /**
     This is the only constructor for this class.  This constructor 
     initializes the Tibot and sets its ID and the initial amount of
     energy that it has.

     parameter: id    : ID of the TimBot
                jolts : Initial amount of energy
   */
  public ChickenBot( int id, int jolts ) {
    super( id, jolts );
    personality = 'C';
  }

  /** 
     This method is called during the Move phase of each round and
     requires the TimBot to decide whether or not to move to another
     district.  If the TimBot wishes to move, it returns, District.NORTH,
     District.EAST, District.SOUTH, or District.WEST, indicating which 
     direction it wishes to move.  If it does not wish to move, it 
     returns District.CURRENT.

     returns: the one of District.NORTH, District.EAST, District.SOUTH, 
              District.WEST, or District.CURRENT
   */
  public int getNextMove() {
    // Allocate a scores array to score moves.  Lower score is better
    // score = 2000 * (bot sensed in district) + 1000 * (adjacent bots) + 
    //         spresso cont
    // We initially assume no robots are adjacent and initial move is to stay.
    int [] scores = new int[botsSensed.length];
    int adj = 0;
    int move = District.CURRENT;

    // If we have energy, consider moving
    if( energyLevel > 0 ) {
      // Loop through all possibilities and compute the scores.
      for( int i = 0; i < scores.length; i++ ) {
        scores[i] = spressoSensed[i];
        if( ( i != District.CURRENT ) && botsSensed[i] ) {
          scores[i] += EMPTY_DISTRICT_PENALTY;
          adj = ADJACENT_DISTRICT_PENALTY;
        }
      }
      // Only the current district can have an adjacency score.
      scores[District.CURRENT] += adj;

      // Choose the move with the minimum score
      move = getMoveWithLowestScore(scores, move);

      // Decrement energy level if we are moving.
      if( move != District.CURRENT ) {
        energyLevel--;
      }
    }
    return move;
  }

  public int getMoveWithLowestScore(int[] scores, int move) {
    int min = scores[District.CURRENT] + 1;
    for( int i = 0; i < scores.length; i++ ) {
      if( min > scores[i] ) {
        min = scores[i];
        move = i;
      }
    }
    return move;
  }
}
