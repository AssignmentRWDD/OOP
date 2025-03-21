import java.io.*;

public class UserManager {
    private static final String FILE_NAME = "users.txt";

    public static void addUser(User user) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(user.getId() + "," + user.getName() + "," + user.getPassword() + "," + user.getType());
            bw.newLine();
        } catch (IOException e) {
        }
    }

    public static User searchUser(String idOrName) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Debug: Reading line - " + line); // Debugging log
                String[] details = line.split(",");
                if (details[0].trim().equalsIgnoreCase(idOrName.trim()) || 
                    details[1].trim().equalsIgnoreCase(idOrName.trim())) { // Check both ID and name
                    return new User(details[0].trim(), details[1].trim(), details[2].trim(), details[3].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users file: " + e.getMessage());
        }
        return null; // User not found
    }
}
