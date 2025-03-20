
package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * The VotingMachine class represents a simple electronic voting system
 */
public class VotingMachine {
    private Map<String, Integer> votes;

    public VotingMachine() {
        this.votes = new HashMap<>();
    }

    /**
     * Add a candidate to the election
     * @param name The name of the candidate to be added
     */
    public void addCandidate(String name) {
        votes.put(name, 0);
    }

    /**
     * Casts a vote for a given candidate
     * @param name The name of the candidate receiving the vote
     * @return true if the vote was successful, false if the candidate does not exist
     */
    public boolean castVote(String name) {
        if (!votes.containsKey(name)) {
            return false;
        }
        votes.put(name, votes.get(name) + 1);
        return true;
    }

    /**
     * Determines the winner of the election based on the highest number of votes
     * @return A string announcing the winning candidate and their vote count
     */
    public String getWinner() {
        String winner = "";
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
