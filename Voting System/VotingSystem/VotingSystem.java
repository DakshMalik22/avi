package VotingSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

public class VotingSystem {
    // Mapping of symbols to candidate names
    static HashMap<String, String> CandidateSymbols = new HashMap<>();
    static {
        CandidateSymbols.put("$", "Modi");
        CandidateSymbols.put("@", "Rahul");
        CandidateSymbols.put("*", "Lalu");
        // Add more symbols and corresponding candidate names as needed
    }

    static ArrayList<User> voters = new ArrayList<>();
    static HashMap<User, Boolean> VotersRecord = new HashMap<>();
    static HashMap<String, Integer> CandidatesDetails = new HashMap<>();
    static ArrayList<User> nonVoter = new ArrayList<>();

    // View eligible non-voters
    public static void ViewEligibleNonVoters() {
        for (Map.Entry<User, Boolean> entry : VotersRecord.entrySet()) {
            User user = entry.getKey();
            Boolean voteCheck = entry.getValue();
            if (!voteCheck) {
                nonVoter.add(user);
            }
        }
        System.out.println(nonVoter.toString());
    }

    // Add candidates to the election
    public static void addCandidates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter candidate: ");
        String candidate = scanner.nextLine();

        CandidatesDetails.put(candidate, 0);
        System.out.println(candidate + " was added successfully");
    }

    // Remove a candidate from the election
    public static void removeCandidates() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter candidate name: ");
        String candidateToBeRemoved = scanner.nextLine();

        if (CandidatesDetails.containsKey(candidateToBeRemoved)) {
            CandidatesDetails.remove(candidateToBeRemoved);
            System.out.println("Candidate has been removed Successfully");
        } else {
            System.out.println("Candidate not Found");
        }
    }

    // Print list of voters
    public static void PrintVoters() {
        System.out.println(voters.toString());
    }

    // Register a new voter
    public static void Registration(ArrayList<User> users) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Please enter your ID: ");
                String userId = scanner.next();
                if (!userId.matches("^[a-zA-Z0-9]*$")) {
                    throw new IllegalArgumentException("Invalid Id. Special characters are not allowed.");
                }
                boolean flag = false;
                LocalDate currentYear = LocalDate.now();
                for (User user : users) {
                    if (Objects.equals(user.getUserId(), userId)) {
                        flag = true;
                        int count = 3;
                        while (count > 0) {
                            System.out.println("Please enter your password: ");
                            String password = scanner.next();
                            if (Objects.equals(user.getPassword(), password)) {
                                LocalDate currentDate = LocalDate.now();
                                LocalDate birthDate = user.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                int age = Period.between(birthDate, currentDate).getYears();
                                if (age > 18) {
                                    if (voters.contains(user)) {
                                        System.out.println("You already exist");
                                        break;
                                    }
                                    voters.add(user);
                                    VotersRecord.put(user, false);
                                    System.out.println("You are registered");
                                    return;
                                }
                            } else {
                                count--;
                                System.out.println("Wrong password Attempts remaining :" + count);
                            }
                        }
                    }
                }
                if (!flag) System.out.println("Id Does not exists");
                validInput = true;

            } catch (IllegalArgumentException IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
                System.out.println("Please try again.");
            }
        }
    }

    // Update user information in the CSV file
    public static void updateUserInCSV(User user) {
        String userDataFile = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Avi\\Concepts\\Concept\\VotingSystem\\UserData.csv";
        String updatedUserInfo = user.getUserId() + "," + user.getPassword() + "," + user.getUserName();
        updateVotersList(user);

        List<String> lines = new ArrayList<>();

        try (BufferedReader csvReader = new BufferedReader(new FileReader(userDataFile))) {
            String currentLine;
            while ((currentLine = csvReader.readLine()) != null) {
                String[] userDetails = currentLine.split(",");
                if (Objects.equals(user.getUserId(), userDetails[0])) {
                    lines.add(updatedUserInfo);
                } else {
                    lines.add(currentLine);
                }
            }
        } catch (IOException IOException) {
            throw new RuntimeException(IOException);
        }

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(userDataFile))) {
            for (String line : lines) {
                csvWriter.write(line);
                csvWriter.newLine();
            }
        } catch (IOException IOException) {
            throw new RuntimeException(IOException);
        }
    }

    // Update the voters list
    public static void updateVotersList(User user) {
        for (User usersRegistered : voters) {
            if (usersRegistered.getUserId().equals(user.getUserId())) {
                voters.remove(usersRegistered);
                voters.add(user);
                break;
            }

        }
    }

    // Allow a voter to cast their vote
    public static void Vote(String userId) {
        Scanner scanner = new Scanner(System.in);

        boolean isRegistered = false;
        User currentUser = null;
        for (User user : voters) {
            if (user.getUserId().equals(userId)) {
                System.out.println("Enter Password for Voting: ");
                String password = scanner.nextLine();
                if (user.getPassword().equals(password)) {
                    isRegistered = true;
                    currentUser = user;
                    break;
                } else {
                    System.out.println("Wrong Password");
                }
            }
        }

        if (!isRegistered) {
            System.out.println("User not registered.");
            return;
        }

        if (AdminPanel.isVotingPaused()) {
            System.out.println("Voting is currently paused. Please try again later.");
            return;
        }

        if (VotersRecord.get(currentUser)) {
            System.out.println("You have already voted.");
            return;
        } else {
            System.out.println("You are eligible to vote");
        }

        if (CandidatesDetails.isEmpty()) {
            System.out.println("No Candidates Available to vote");
            return;
        }

        System.out.println("Candidates List:");
        CandidatesDetails.forEach((candidate, votes) -> System.out.println(candidate));

        String symbol;
        String candidateName;
        boolean validSymbol = false;

        while (!validSymbol) {
            try {
                System.out.println("Enter the symbol of the candidate to vote: ");
                symbol = scanner.nextLine();

                if (!symbol.matches("[A-Z]")) {
                    throw new IllegalArgumentException("Invalid symbol. Please enter a single uppercase letter.");
                }

                if (CandidateSymbols.containsKey(symbol)) {
                    candidateName = CandidateSymbols.get(symbol);
                    if (CandidatesDetails.containsKey(candidateName)) {
                        CandidatesDetails.put(candidateName, CandidatesDetails.get(candidateName) + 1);
                        System.out.println("Vote casted successfully for " + candidateName);
                        VotersRecord.put(currentUser, true);
                        validSymbol = true;
                    } else {
                        System.out.println("Invalid candidate name.");
                    }
                } else {
                    System.out.println("Invalid symbol. Please enter a valid symbol.");
                }
            } catch (IllegalArgumentException IllegalArgumentException) {
                System.out.println(IllegalArgumentException.getMessage());
            }
        }
    }

    // Display election results
    public static void showElectionResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : CandidatesDetails.entrySet()) {
            System.out.println("Candidate: " + entry.getKey() + ", Votes: " + entry.getValue());
        }

        int maxVotes = 0;
        String winner = null;
        for (Map.Entry<String, Integer> entry : CandidatesDetails.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        if (winner != null) {
            System.out.println("Winner: " + winner);
        } else {
            System.out.println("No winner yet.");
        }
    }
}
