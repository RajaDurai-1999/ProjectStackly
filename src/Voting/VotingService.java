package Voting;

import java.util.HashMap;
import java.util.Map;

public class VotingService {

    private Map<String, User> users = new HashMap<>();
    private Map<String, Boolean> votedUsers = new HashMap<>();
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private Map<Integer, Integer> candidateVotes = new HashMap<>();

    public void addCandidate(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
        candidateVotes.put(candidate.getId(), 0);
    }

    public void register(String username, String password) throws VotingException {

        if (users.containsKey(username)) {
            throw new VotingException("Username already exists");
        }

        User user = new User(username, password);

        users.put(username, user);
        votedUsers.put(username, false);

        System.out.println("Registration successful");
    }

    public User login(String username, String password) throws VotingException {

        if (!users.containsKey(username)) {
            throw new VotingException("User not registered");
        }

        User user = users.get(username);

        if (!user.getPassword().equals(password)) {
            throw new VotingException("Invalid password");
        }

        return user;
    }

    public void displayCandidates() {

        System.out.println("----- CANDIDATES -----");

        for (Candidate candidate : candidates.values()) {
            System.out.println(candidate.getId() + " - " + candidate.getName());
        }
    }

    public void castVote(String username, int candidateId) throws VotingException {

        if (!users.containsKey(username)) {
            throw new VotingException("User not registered");
        }

        if (votedUsers.get(username)) {
            throw new VotingException("You have already voted");
        }

        if (!candidates.containsKey(candidateId)) {
            throw new VotingException("Invalid candidate ID");
        }

        int currentVotes = candidateVotes.get(candidateId);

        candidateVotes.put(candidateId, currentVotes + 1);

        votedUsers.put(username, true);

        System.out.println("Vote cast successfully");
    }

    public void displayTotalVotes() {

        System.out.println("----- TOTAL VOTES -----");

        for (Candidate candidate : candidates.values()) {

            int votes = candidateVotes.get(candidate.getId());

            System.out.println(candidate.getName() + " : " + votes + " votes");
        }
    }

    public void displayResult() {

        if (candidates.isEmpty()) {
            System.out.println("No candidates available");
            return;
        }

        int totalVotes = 0;

        for (int votes : candidateVotes.values()) {
            totalVotes = totalVotes + votes;
        }

        if (totalVotes == 0) {
            System.out.println("No votes have been cast yet");
            return;
        }

        Candidate winner = null;
        Candidate runnerUp = null;

        int highestVotes = -1;
        int secondHighestVotes = -1;

        for (Candidate candidate : candidates.values()) {

            int votes = candidateVotes.get(candidate.getId());

            if (votes > highestVotes) {

                secondHighestVotes = highestVotes;
                runnerUp = winner;

                highestVotes = votes;
                winner = candidate;

            } else if (votes > secondHighestVotes) {

                secondHighestVotes = votes;
                runnerUp = candidate;
            }
        }

        System.out.println(".........ELECTION RESULT.........");

        System.out.println("Winner: " + winner.getName());
        System.out.println("Votes : " + highestVotes);

        if (runnerUp != null) {
            System.out.println("Runner-Up : " + runnerUp.getName());
            System.out.println("Votes : " + secondHighestVotes);
        }
    }
}