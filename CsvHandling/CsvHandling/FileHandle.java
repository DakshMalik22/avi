package CsvHandling;

import java.io.*;
import java.util.ArrayList;

public class FileHandle {
    public static void main(String[] args) {

        String file = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Avi\\yoyoy\\employees - employees.csv";

        ArrayList<Employee> employee = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine;

            br.readLine();
            while ((currentLine =br.readLine() )!=null)
            {
                String[] details = currentLine.split(",");

                String firstName = details[1];
                String lastName = details[2];
                int salary = Integer.parseInt(details[7]);
                employee.add(new Employee(firstName,lastName,salary));

            }

            System.out.println(employee);

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
       double avg=0;
        for (int i = 0; i < employee.size(); i++) {
            avg+= employee.get(i).getSalary();
        }

        avg = avg/ employee.size();


        System.out.println(avg);
        try {
            File fo = new File("demo.csv");
            fo.createNewFile();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        try(BufferedWriter fw =  new BufferedWriter( new FileWriter("demo.csv"))){
             fw.write("FirstName,LastName,Salaray"+"\n" );
            for (Employee value : employee) {
                if (value.getSalary() > avg)

                    fw.write(value.getFirstName() + "," + value.getLastName() + "," + value.getSalary() + "\n");


            }
        }
         catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader("demo.csv"))) {
            while (br.ready())
            {
                System.out.println(br.readLine());
            }
            System.out.println("You types: "+ br.readLine());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}

