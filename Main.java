import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "C:\\Users\\mz032929\\Documents\\GitHub\\CS201Lab\\input";
        String outputFilePath = "output.txt";

        ArrayList<Integer> arrayList = readInputFromFile(inputFilePath);

        ArrayList<String> results = new ArrayList<>();
        for (int num : arrayList) {
            if (isPrime(num)) {
                results.add(num + " is prime.");
            } else {
                results.add(num + " is not prime.");
            }
        }

        writeOutputToFile(outputFilePath, results);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> readInputFromFile(String filePath) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                arrayList.add(num);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return arrayList;
    }

    public static void writeOutputToFile(String filePath, ArrayList<String> results) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String result : results) {
                writer.write(result);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
