package CsvHandling;

import java.io.*;
import java.util.ArrayList;

public class FileHandle {
    public static void main(String[] args) {

        // File path to read from
        String file = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Avi\\yoyoy\\employees - employees.csv";

        // ArrayList to store Employee objects
        ArrayList<Employee> employee = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;

            // Skipping the header line
            br.readLine();
            // Reading data line by line
            while ((currentLine =br.readLine() )!=null)
            {
                // Splitting each line by comma to get individual data
                String[] details = currentLine.split(",");

                // Extracting relevant data
                String firstName = details[1];
                String lastName = details[2];
                int salary = Integer.parseInt(details[7]);

                // Creating Employee object and adding to the list
                employee.add(new Employee(firstName,lastName,salary));

            }

            // Printing the list of employees
            System.out.println(employee);

        }
        catch (IOException e){
            // Handling IOException
            System.out.println(e.getMessage());
        }
        
        // Calculating average salary
        double avg=0;
        for (int i = 0; i < employee.size(); i++) {
            avg+= employee.get(i).getSalary();
        }
        avg = avg/ employee.size();

        // Printing average salary
        System.out.println(avg);
        
        try {
            // Creating a new file
            File fo = new File("demo.csv");
            fo.createNewFile();
        }
        catch (IOException e)
        {
            // Handling IOException
            System.out.println(e.getMessage());
        }
        
        try(BufferedWriter fw =  new BufferedWriter( new FileWriter("demo.csv"))){
             // Writing header to the file
             fw.write("FirstName,LastName,Salary"+"\n" );
             
            // Writing data to the file
            for (Employee value : employee) {
                if (value.getSalary() > avg)
                    fw.write(value.getFirstName() + "," + value.getLastName() + "," + value.getSalary() + "\n");
            }
        }
        catch (IOException e)
        {
            // Handling IOException
            System.out.println(e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader("demo.csv"))) {
            // Reading and printing data from the created file
            while (br.ready())
            {
                System.out.println(br.readLine());
            }
            // This line will print null because the reader has already reached the end of the file in the previous loop
            System.out.println("You typed: "+ br.readLine());
        }
        catch (IOException e){
            // Handling IOException
            System.out.println(e.getMessage());
        }

    }

}
