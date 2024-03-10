package VotingSystem;

import java.util.Scanner;

class AdminPanel {
    private static boolean votingPaused = false;

    public static void adminActions(Admin admin) {

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("1. Add Candidate");
                System.out.println("2. Remove Candidate");
                System.out.println("3. Show Election Results");
                System.out.println("4. Show User Details");
                System.out.println("5. Show Registered user Details");
                System.out.println("6. Show All Non-Voters");
                System.out.println("7. Pause/Start Voting");
                System.out.println("8. Exit Admin Panel");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        VotingSystem.addCandidates();
                        break;
                    case 2:
                        VotingSystem.removeCandidates();
                        break;
                    case 3:
                        VotingSystem.showElectionResults();
                        break;
                    case 4:
                        System.out.println(Main.user.toString());
                        break;
                    case 5:
                        System.out.println("Here are Registered User details: \n \n");
                        System.out.println(VotingSystem.voters.toString());
                        break;
                    case 6:
                        System.out.println("Here are the Details of all non-voters: ");
                        VotingSystem.ViewEligibleNonVoters();
                        break;
                    case 7:
                        toggleVotingStatus();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void toggleVotingStatus() {
        votingPaused = !votingPaused;
        if (votingPaused) {
            System.out.println("Voting Paused");
        } else {
            System.out.println("Voting Started");
        }
    }

    public static boolean isVotingPaused() {
        return votingPaused;
    }
}
