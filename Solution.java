import java.util.*;

class User {
    int userID;
    int balance;

    User(int userID, int balance) {
        this.userID = userID;
        this.balance = balance;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner

        int N = scanner.nextInt();  // Number of users
        Map<Integer, User> users = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int userID = scanner.nextInt();
            int balance = scanner.nextInt();
            users.put(userID, new User(userID, balance));
        }

        int T = scanner.nextInt();  // Number of transactions
        List<String> transactionResults = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int from_userID = scanner.nextInt();
            int to_userID = scanner.nextInt();
            int amount = scanner.nextInt();
            User fromUser = users.get(from_userID);
            User toUser = users.get(to_userID);

            if (fromUser.balance >= amount) {
                fromUser.balance -= amount;
                toUser.balance += amount;
                transactionResults.add("Success");
            } else {
                transactionResults.add("Failure");
            }
        }

        for (String result : transactionResults) {
            System.out.println(result);
        }

        System.out.println();  // Print the empty line

        List<User> sortedUsers = new ArrayList<>(users.values());
        Collections.sort(sortedUsers, (a, b) -> {
            if (a.balance == b.balance) {
                return Integer.compare(a.userID, b.userID);
            }
            return Integer.compare(a.balance, b.balance);
        });

        for (User user : sortedUsers) {
            System.out.println(user.userID + " " + user.balance);
        }

        scanner.close();  // Close the scanner
    }
}

