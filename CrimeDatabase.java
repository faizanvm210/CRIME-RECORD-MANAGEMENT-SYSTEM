import java.io.*;
import java.util.*;

class CrimeDatabase {
    private final String FILE_NAME = "crimes.dat";

    public void saveCrime(Crime crime) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(crime.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving record: " + e.getMessage());
        }
    }

    public List<Crime> getAllCrimes() {
        List<Crime> crimes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                crimes.add(new Crime(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]));
            }
        } catch (IOException e) {
            System.out.println("No records found yet.");
        }
        return crimes;
    }
}

