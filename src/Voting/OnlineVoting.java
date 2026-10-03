package Voting;

import java.util.Scanner;

public class OnlineVoting {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VotingService service = new VotingService();

        service.addCandidate(new Candidate(1, "Arun"));
        service.addCandidate(new Candidate(2, "Bala"));
        service.addCandidate(new Candidate(3, "Kumar"));

        while (true) {

            System.out.println("........ONLINE VOTING SYSTEM.......");
            System.out.println("1. Register");
            System.out.println("2. Login and Vote");
            System.out.println("3. Candidate List");
            System.out.println("4. View Total Votes");
            System.out.println("5. Display Result");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                case 1:

                    System.out.println("\n----- REGISTRATION -----");

                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    try {
                        service.register(username, password);
                    } catch (VotingException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 2:

                    System.out.println("------ LOGIN -----");

                    System.out.print("Enter username: ");
                    username = sc.nextLine();

                    System.out.print("Enter password: ");
                    password = sc.nextLine();

                    try {

                        service.login(username, password);

                        System.out.println("Login successful");

                        service.displayCandidates();

                        System.out.print("Enter candidate ID: ");
                        int candidateId = Integer.parseInt(sc.nextLine());

                        service.castVote(username, candidateId);

                    } catch (VotingException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 3:

                    service.displayCandidates();
                    break;

                case 4:

                    service.displayTotalVotes();
                    break;

                case 5:

                    service.displayResult();
                    break;

                case 6:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid choice");
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter numbers only");
            }
        }
    }

}
