package VotingSystem;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static ArrayList<User> user = new ArrayList<>();
    static Admin admin;

    public static void updateUser(User userData) {
        for (User existingUser : user) {
            if (existingUser.getUserId().equals(userData.getUserId())) {
                existingUser.setUserName(userData.getUserName());
                existingUser.setPassword(userData.getPassword());
                existingUser.setDateOfBirth(userData.getDateOfBirth());
                break;
            }
        }
    }

    public static void main(String[] args) {

        String userDataFile = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Avi\\Concepts\\Concept\\VotingSystem\\UserData.csv";
        Scanner scanner = new Scanner(System.in);
        String adminConfigFile = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Avi\\Concepts\\Concept\\VotingSystem\\admin_config.properties";

        // Read admin credentials from configuration file
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream(adminConfigFile)) {
            properties.load(inputStream);
            String adminId = properties.getProperty("admin_id");
            String adminPassword = properties.getProperty("admin_password");
            admin = new Admin("Admin", adminId, adminPassword, new Date());
        } catch (FileNotFoundException FileNotFoundException) {
            System.out.println("Admin configuration file not found: " + FileNotFoundException.getMessage());

            return;
        } catch (IOException IOException) {
            System.out.println("Error reading admin configuration file: " + IOException.getMessage());

            return;
        }

        try (BufferedReader csvReader = new BufferedReader(new FileReader(userDataFile))) {
            String currentLine;

            while ((currentLine = csvReader.readLine()) != null) {
                String[] userDetails = currentLine.split(",");
                if (userDetails.length >= 3) {
                    String userName = userDetails[2];
                    String userId = userDetails[0];
                    String userPassword = userDetails[1];
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    try {
                        Date dateObject = sdf.parse(userDetails[1]);
                        user.add(new User(userName, userId, userPassword, dateObject));
                    } catch (ParseException ParseException) {
                        throw new RuntimeException(ParseException);
                    }
                } else {
                    System.out.println("Invalid format in CSV: " + currentLine);
                }
            }
        } catch (FileNotFoundException FileNotFoundException) {
            throw new RuntimeException(FileNotFoundException);
        } catch (IOException IOException) {
            throw new RuntimeException(IOException);
        }
        System.out.println(user.toString());

        try {
            while (true) {
                System.out.println("1.Registration");
                System.out.println("2.Update User Details");
                System.out.println("3.Print All registered users");
                System.out.println("4.Enter Admin Panel");
                System.out.println("6.Vote");

                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        VotingSystem.Registration(user);
                        break;

                    case 2:
                        boolean validInput = false;
                        String name = null;
                        String id = null;
                        String password = null;
                        while (!validInput) {
                            try {

                                System.out.println("Enter user Id (no special characters allowed): ");
                                id = scanner.nextLine();
                                if (!id.matches("^[a-zA-Z0-9]*$")) {
                                    throw new IllegalArgumentException("Invalid Id. Special characters are not allowed.");
                                }

                                boolean idFlag = false;
                                boolean passwordFlag = false;

                                for (User iteratorThroughUser : user) {
                                    if (Objects.equals(iteratorThroughUser.getUserId(), id)) {
                                        System.out.println("Enter User Password (no special characters allowed): ");
                                        password = scanner.nextLine();
                                        idFlag = true;

                                        if (Objects.equals(iteratorThroughUser.getPassword(), password)) {
                                            passwordFlag = true;
                                            System.out.println("1.Change UserName");
                                            System.out.println("2.Change Password");
                                            System.out.println("3.Change Both");
                                            System.out.println("4.Exit");
                                            int option = scanner.nextInt();
                                            scanner.nextLine();

                                            switch (option) {
                                                case 1:
                                                    System.out.println("Enter the UserName: ");
                                                    name = scanner.nextLine();
                                                    if (name.matches(".*\\d.*") || name.matches(".*[^a-zA-Z0-9].*")) {
                                                        throw new IllegalArgumentException("Invalid Id. Only alphabetic characters are allowed.");
                                                    }

                                                    updateUser(new User(name, id, iteratorThroughUser.getPassword(), new Date()));
                                                    VotingSystem.updateUserInCSV(new User(name, id, iteratorThroughUser.getPassword(), new Date()));
                                                    System.out.println("Username has been Changed");
                                                    validInput = true;
                                                    break;

                                                case 2:
                                                    System.out.println("Enter User Password (no special characters allowed): ");
                                                    String newPassword = scanner.nextLine();

                                                    updateUser(new User(iteratorThroughUser.getUserName(), id, newPassword, new Date()));
                                                    VotingSystem.updateUserInCSV(new User(iteratorThroughUser.getUserName(), id, newPassword, new Date()));
                                                    System.out.println("Password has been Changed");
                                                    validInput = true;
                                                    break;

                                                case 3:
                                                    System.out.println("Enter User Password (no special characters allowed): ");
                                                    String newPasswordUser = scanner.nextLine();

                                                    System.out.println("Enter the UserName: ");
                                                    String newName = scanner.nextLine();
                                                    if (newName.matches(".*\\d.*") || newName.matches(".*[^a-zA-Z0-9].*")) {
                                                        throw new IllegalArgumentException("Invalid Id. Only alphabetic characters are allowed.");
                                                    }

                                                    updateUser(new User(newName, id, newPasswordUser, new Date()));
                                                    VotingSystem.updateUserInCSV(new User(newName, id, newPasswordUser, new Date()));
                                                    System.out.println("Both password and username have been changed");
                                                    validInput = true;
                                                    break;

                                                case 4:
                                                    validInput = true;
                                                    break;
                                            }
                                        }
                                    }
                                }

                                if (!idFlag) {
                                    System.out.println("Invalid Id");
                                } else if (!passwordFlag) {
                                    System.out.println("Invalid password");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                System.out.println("Please try again.");
                            }
                        }

                        break;

                    case 3:
                        VotingSystem.PrintVoters();
                        break;

                    case 4:
                        Admin loggedInAdmin = authenticateAdmin();
                        if (loggedInAdmin != null) {
                            AdminPanel.adminActions(loggedInAdmin);
                        } else {
                            System.out.println("Admin not found or invalid credentials.");
                        }
                        break;

                    case 6:
                        System.out.println("Welcome for Voting");
                        System.out.println("Enter Your Id");
                        String userId = scanner.next();

                        VotingSystem.Vote(userId);
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Admin authenticateAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Admin Password: ");
        String passwordForAdmin = scanner.nextLine();

        if (admin.getPassword().equals(passwordForAdmin)) {
            System.out.println("Admin login successful.");
            return admin;
        }
        return null;
    }
}
