package org.example;

import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter file path");
        Scanner find = new Scanner(System.in) ;
        String input;
        input = find.next();
        if(input.equals("C:\\Java\\doit\\src\\main\\java\\org\\example\\student_data.json")) {
            try {


                // Read the content of the JSON file into a string
                String content = new String(Files.readAllBytes(Paths.get("C:\\Java\\doit\\src\\main\\java\\org\\example\\student_data.json")));


                // Parse the string content into a JSONArray
                JSONArray jsonArray = new JSONArray(content);


                HashMap<String, Integer> map = new HashMap<>();
                int avg = 0;
                int totalSum = 0;
                // Iterate through the JSON array and process each JSON object
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    // Now you can access the data using methods like getString(), getInt(), etc.
                    // For example:
                    String name = json.getString("name");
                    int mathsMarks = json.getInt("maths");
                    int phyMarks = json.getInt("physics");
                    int englishMarks = json.getInt("english");

                    int sum = mathsMarks + phyMarks + englishMarks / 3;
                    avg += sum;
                    map.put(name, sum);

                    System.out.println("Name:" + name + " Maths-Marks:" + mathsMarks + " Physics-Marks:" + phyMarks + " English-marks:" + englishMarks);

                    System.out.println();
                }

                avg /= jsonArray.length();


                System.out.println("Avg is: " + avg);
                JSONArray resultArray = new JSONArray();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    String name = entry.getKey();
                    int sum = entry.getValue();

                    if (sum > avg) {
                        // Create a JSON object for each student
                        JSONObject studentObject = new JSONObject();
                        studentObject.put("name", name);
                        studentObject.put("sum_of_marks", sum);

                        // Add the student object to the result array
                        resultArray.put(studentObject);
                    }
                }

                // Write the JSON array to a file
                FileWriter fileWriter = new FileWriter("result.json");
                fileWriter.write(resultArray.toString());
                fileWriter.close();

                System.out.println("Data written to result.json successfully.");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Bye bye");
        }


    }
}
