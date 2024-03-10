package VotingSystem;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VotingSystem {
    static HashMap<String, String> CandidateSymbols = new HashMap<>();

    static ArrayList<User> voters = new ArrayList<>();
    static HashMap<User,Boolean>VotersRecord=new HashMap<>();
    static HashMap<String,Integer>CandidatesDetails = new HashMap<>();

    static ArrayList<User>nonVoter = new ArrayList<>();
    public static void ViewEligibleNonVoters()
    {
        for (Map.Entry<User,Boolean>entry:VotersRecord.entrySet() )
        {
            User user  =  entry.getKey();
            Boolean voteCheck = entry.getValue();
            if(voteCheck==false)
            {
                nonVoter.add(user);
            }
        }

        System.out.println(nonVoter.toString());
    }
    public static void addCandidates()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter candidate: ");
        String candidate = scanner.nextLine();

        CandidatesDetails.put(candidate,0);

    }

    public static void removeCandidates()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter candidate name: ");
        String candidateToBeRemoved = scanner.nextLine();

        if(CandidatesDetails.containsKey(candidateToBeRemoved))
        {
            CandidatesDetails.remove(candidateToBeRemoved);

            System.out.println("Candidate has been removed Successfully");
        }
        else{
            System.out.println("Candidate not Found");
        }

    }


    public static void  PrintVoters()
    {
        System.out.println(voters.toString());
    }

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
        if (!flag) System.out.println("Id Does not exists"); validInput = true;

    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        System.out.println("Please try again.");
    }
}

    }

    public static void updateUserInCSV(User user) {
        String userDataFile = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Avi\\Concepts\\Concept\\VotingSystem\\UserData.csv";
        String updatedUserInfo = user.getUserId() + "," + user.getPassword() + "," + user.getUserName();
        updateVotersList(user);

        List<String> lines = new ArrayList<>();

        // Read the contents of the CSV file and update the information of the specified user
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Write the updated list back to the CSV file
        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(userDataFile))) {
            for (String line : lines) {
                csvWriter.write(line);
                csvWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateVotersList(User user) {
        for (User usersRegistered : voters) {
            if (usersRegistered.getUserId().equals(user.getUserId())) {
                voters.remove(usersRegistered); // Remove the existing user with the same ID
                voters.add(user); // Add the updated user to the voters list
                break; // Break the loop to avoid ConcurrentModificationException
            }

        }
    }
    public static void Vote(String userId) {
        Scanner scanner = new Scanner(System.in);

        // Check if the user is registered
        boolean isRegistered = false;


        User currentUser = null;
        for (User user : voters) {
            if (user.getUserId().equals(userId)) {
                System.out.println("Enter Password for Voting: ");
                String password = scanner.nextLine();
                if(user.getPassword().equals(password)) {
                    isRegistered = true;                            // enter pass 3 times.
                    currentUser = user;
                    break;
                }
                else {
                    System.out.println("Wrong Password");
                }
            }
        }

        if (!isRegistered) {
            System.out.println("User not registered.");
            return;
        }

        // Check if voting is paused
        if (AdminPanel.isVotingPaused()) {
            System.out.println("Voting is currently paused. Please try again later.");
            return;
        }


        // Check if the user has already voted

            if(VotersRecord.get(currentUser)==true)
            {
                System.out.println("You have already voted.");
                return;
            }
            else
            {
                System.out.println("You are eligible to vote");
            }

            if(CandidatesDetails.isEmpty())
            {
                System.out.println("No Candidates Available to vote");
                return;
            }
        System.out.println("Candidates List:");
        CandidatesDetails.forEach((candidate, votes) -> System.out.println(candidate));

        System.out.println("Enter candidate name to vote: ");
        String candidateName = scanner.nextLine();

        if (CandidatesDetails.containsKey(candidateName)) {
            CandidatesDetails.put(candidateName, CandidatesDetails.get(candidateName) + 1);
            System.out.println("Vote casted successfully.");
            VotersRecord.put(currentUser, true); // Record that the user has voted
        } else {
            System.out.println("Invalid candidate name.");
        }
    }

    public static void showElectionResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : CandidatesDetails.entrySet()) {
            System.out.println("Candidate: " + entry.getKey() + ", Votes: " + entry.getValue());
        }
        // Determine the winner (candidate with the most votes)
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

