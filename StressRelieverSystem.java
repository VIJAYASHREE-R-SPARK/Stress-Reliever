import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StressRelieverSystem {
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final String JOURNAL_FILE = "stress_journal.txt";
    
    // Motivational quotes collection
    private static final String[] QUOTES = {
        "This too shall pass. — Persian Proverb",
        "You are stronger than you think.",
        "Breathe. It's just a bad day, not a bad life.",
        "The greatest weapon against stress is our ability to choose one thought over another. — William James",
        "Almost everything will work again if you unplug it for a few minutes, including you. — Anne Lamott",
        "You don't have to control your thoughts. You just have to stop letting them control you. — Dan Millman",
        "Stress is caused by being 'here' but wanting to be 'there.' — Eckhart Tolle",
        "In the middle of difficulty lies opportunity. — Albert Einstein",
        "Peace is the result of retraining your mind to process life as it is. — Wayne Dyer",
        "You are not your thoughts. You are the observer of your thoughts.",
        "Take a deep breath. It's just a bad moment, not a bad life.",
        "Worrying does not take away tomorrow's troubles. It takes away today's peace."
    };
    
    // Calming activities
    private static final String[] CALMING_ACTIVITIES = {
        "Take a short walk outside",
        "Listen to your favorite calming music",
        "Drink a warm cup of tea or water",
        "Stretch your body for 5 minutes",
        "Look at nature photos or videos",
        "Call or text someone you love",
        "Write down three things you're grateful for",
        "Organize a small space around you",
        "Watch funny animal videos",
        "Take a power nap (15-20 minutes)"
    };
    
    public static void main(String[] args) {
        displayWelcomeBanner();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ", 1, 7);
            
            switch (choice) {
                case 1 -> breathingExercise();
                case 2 -> displayMotivationalQuote();
                case 3 -> playMiniGame();
                case 4 -> journalEntry();
                case 5 -> stressLevelAssessment();
                case 6 -> suggestCalmingActivity();
                case 7 -> {
                    displayGoodbye();
                    running = false;
                }
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayWelcomeBanner() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("     ✨ WELCOME TO THE STRESS RELIEVER SYSTEM ✨");
        System.out.println("=".repeat(60));
        System.out.println("      Take a moment to relax and find your peace.");
        System.out.println("=".repeat(60) + "\n");
    }
    
    private static void displayMainMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                 │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│  1. 🌬️  Breathing Exercise          │");
        System.out.println("│  2. 💭  Motivational Quote          │");
        System.out.println("│  3. 🎮  Play Mini Game              │");
        System.out.println("│  4. 📝  Journal Your Thoughts       │");
        System.out.println("│  5. 📊  Stress Level Assessment     │");
        System.out.println("│  6. 🎯  Get Activity Suggestion     │");
        System.out.println("│  7. 🚪  Exit                        │");
        System.out.println("└─────────────────────────────────────┘");
    }
    
    // ==================== BREATHING EXERCISE ====================
    private static void breathingExercise() {
        System.out.println("\n" + "~".repeat(50));
        System.out.println("         🌬️ GUIDED BREATHING EXERCISE 🌬️");
        System.out.println("~".repeat(50));
        
        System.out.println("\nChoose a breathing technique:");
        System.out.println("1. 4-7-8 Technique (Relaxation)");
        System.out.println("2. Box Breathing (Focus)");
        System.out.println("3. Quick Calm (2 minutes)");
        
        int technique = getIntInput("Select technique: ", 1, 3);
        int cycles = getIntInput("How many cycles? (1-5): ", 1, 5);
        
        System.out.println("\nGet comfortable and close your eyes if you'd like.");
        System.out.println("Starting in 3 seconds...\n");
        sleep(3000);
        
        for (int i = 1; i <= cycles; i++) {
            System.out.println("━━━ Cycle " + i + " of " + cycles + " ━━━\n");
            
            switch (technique) {
                case 1 -> breathe478();
                case 2 -> boxBreathing();
                case 3 -> quickCalm();
            }
            
            if (i < cycles) {
                System.out.println("\nPreparing for next cycle...\n");
                sleep(2000);
            }
        }
        
        System.out.println("\n✨ Excellent! You completed the breathing exercise.");
        System.out.println("   Notice how your body feels now.");
    }
    
    private static void breathe478() {
        System.out.println("   INHALE slowly through your nose...");
        countdown(4, "   Breathing in");
        
        System.out.println("\n   HOLD your breath gently...");
        countdown(7, "   Holding");
        
        System.out.println("\n   EXHALE slowly through your mouth...");
        countdown(8, "   Breathing out");
    }
    
    private static void boxBreathing() {
        String[] phases = {"INHALE", "HOLD", "EXHALE", "HOLD"};
        String[] actions = {"Breathing in", "Holding", "Breathing out", "Holding"};
        
        for (int i = 0; i < 4; i++) {
            System.out.println("   " + phases[i] + "...");
            countdown(4, "   " + actions[i]);
            if (i < 3) System.out.println();
        }
    }
    
    private static void quickCalm() {
        for (int i = 0; i < 4; i++) {
            System.out.println("   INHALE deeply...");
            countdown(3, "   In");
            System.out.println("\n   EXHALE completely...");
            countdown(3, "   Out");
            if (i < 3) System.out.println();
        }
    }
    
    private static void countdown(int seconds, String label) {
        for (int i = seconds; i > 0; i--) {
            System.out.print("\r" + label + "... " + i + " ");
            sleep(1000);
        }
        System.out.print("\r" + label + "... ✓   \n");
    }
    
    // ==================== MOTIVATIONAL QUOTES ====================
    private static void displayMotivationalQuote() {
        System.out.println("\n" + "~".repeat(50));
        System.out.println("           💭 MOTIVATIONAL QUOTE 💭");
        System.out.println("~".repeat(50));
        
        String quote = QUOTES[random.nextInt(QUOTES.length)];
        
        System.out.println("\n   ┌" + "─".repeat(46) + "┐");
        
        // Word wrap the quote
        String[] words = quote.split(" ");
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() + 1 > 44) {
                System.out.printf("   │ %-44s │%n", line.toString().trim());
                line = new StringBuilder();
            }
            line.append(word).append(" ");
        }
        if (line.length() > 0) {
            System.out.printf("   │ %-44s │%n", line.toString().trim());
        }
        
        System.out.println("   └" + "─".repeat(46) + "┘");
        
        System.out.println("\n   Take a moment to reflect on these words. 🌟");
    }
    
    // ==================== MINI GAMES ====================
    private static void playMiniGame() {
        System.out.println("\n" + "~".repeat(50));
        System.out.println("           🎮 MINI GAMES 🎮");
        System.out.println("~".repeat(50));
        
        System.out.println("\nChoose a game to distract your mind:");
        System.out.println("1. 🔢 Number Guessing Game");
        System.out.println("2. 🧮 Quick Math Challenge");
        System.out.println("3. 📝 Word Scramble");
        System.out.println("4. ✊ Rock Paper Scissors");
        
        int choice = getIntInput("Select game: ", 1, 4);
        
        switch (choice) {
            case 1 -> numberGuessingGame();
            case 2 -> mathChallenge();
            case 3 -> wordScramble();
            case 4 -> rockPaperScissors();
        }
    }
    
    private static void numberGuessingGame() {
        System.out.println("\n🔢 NUMBER GUESSING GAME");
        System.out.println("I'm thinking of a number between 1 and 50.");
        System.out.println("You have 7 attempts to guess it!\n");
        
        int target = random.nextInt(50) + 1;
        int attempts = 7;
        
        while (attempts > 0) {
            int guess = getIntInput("Your guess (" + attempts + " left): ", 1, 50);
            
            if (guess == target) {
                System.out.println("\n🎉 CONGRATULATIONS! You guessed it!");
                System.out.println("   The number was " + target);
                System.out.println("   Great job keeping your mind sharp! 🧠");
                return;
            } else if (guess < target) {
                System.out.println("   ⬆️ Higher!");
            } else {
                System.out.println("   ⬇️ Lower!");
            }
            attempts--;
        }
        
        System.out.println("\n😊 The number was " + target);
        System.out.println("   Nice try! Want to play again next time?");
    }
    
    private static void mathChallenge() {
        System.out.println("\n🧮 QUICK MATH CHALLENGE");
        System.out.println("Solve 5 simple math problems to exercise your brain!\n");
        
        int score = 0;
        String[] operators = {"+", "-", "×"};
        
        for (int i = 1; i <= 5; i++) {
            int a = random.nextInt(20) + 1;
            int b = random.nextInt(15) + 1;
            String op = operators[random.nextInt(3)];
            
            int answer = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "×" -> a * b;
                default -> 0;
            };
            
            // Ensure no negative results for subtraction
            if (op.equals("-") && b > a) {
                int temp = a;
                a = b;
                b = temp;
            }
            
            int finalAnswer = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "×" -> a * b;
                default -> 0;
            };
            
            System.out.print("   Problem " + i + ": " + a + " " + op + " " + b + " = ");
            int userAnswer = scanner.nextInt();
            scanner.nextLine();
            
            if (userAnswer == finalAnswer) {
                System.out.println("   ✓ Correct!\n");
                score++;
            } else {
                System.out.println("   ✗ The answer was " + finalAnswer + "\n");
            }
        }
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("   Your score: " + score + "/5");
        if (score == 5) {
            System.out.println("   🌟 Perfect score! Amazing!");
        } else if (score >= 3) {
            System.out.println("   👍 Good job! Keep it up!");
        } else {
            System.out.println("   😊 Nice effort! Practice makes perfect!");
        }
    }
    
    private static void wordScramble() {
        String[] words = {"PEACEFUL", "RELAXING", "SERENE", "TRANQUIL", "CALM", 
                          "HARMONY", "BALANCE", "MINDFUL", "GENTLE", "SOOTHING"};
        
        System.out.println("\n📝 WORD SCRAMBLE");
        System.out.println("Unscramble these calming words!\n");
        
        int score = 0;
        Set<Integer> used = new HashSet<>();
        
        for (int round = 1; round <= 3; round++) {
            int idx;
            do {
                idx = random.nextInt(words.length);
            } while (used.contains(idx));
            used.add(idx);
            
            String original = words[idx];
            String scrambled = scrambleWord(original);
            
            System.out.println("   Round " + round + ": " + scrambled);
            System.out.print("   Your answer: ");
            String answer = scanner.nextLine().toUpperCase().trim();
            
            if (answer.equals(original)) {
                System.out.println("   ✓ Correct! 🎉\n");
                score++;
            } else {
                System.out.println("   ✗ It was: " + original + "\n");
            }
        }
        
        System.out.println("   Final Score: " + score + "/3");
        System.out.println("   Words can be soothing, just like these! 🌸");
    }
    
    private static String scrambleWord(String word) {
        List<Character> chars = new ArrayList<>();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder scrambled = new StringBuilder();
        for (char c : chars) {
            scrambled.append(c);
        }
        // Make sure it's actually scrambled
        if (scrambled.toString().equals(word)) {
            return scrambleWord(word);
        }
        return scrambled.toString();
    }
    
    private static void rockPaperScissors() {
        System.out.println("\n✊ ROCK PAPER SCISSORS");
        System.out.println("Best of 3 rounds!\n");
        
        String[] moves = {"ROCK", "PAPER", "SCISSORS"};
        String[] emojis = {"✊", "✋", "✌️"};
        int playerWins = 0, computerWins = 0;
        int round = 1;
        
        while (playerWins < 2 && computerWins < 2) {
            System.out.println("Round " + round + ":");
            System.out.println("   1. ✊ Rock");
            System.out.println("   2. ✋ Paper");
            System.out.println("   3. ✌️ Scissors");
            
            int playerChoice = getIntInput("   Your choice: ", 1, 3) - 1;
            int computerChoice = random.nextInt(3);
            
            System.out.println("\n   You: " + emojis[playerChoice] + " " + moves[playerChoice]);
            System.out.println("   Computer: " + emojis[computerChoice] + " " + moves[computerChoice]);
            
            if (playerChoice == computerChoice) {
                System.out.println("   → It's a tie! Playing again...\n");
            } else if ((playerChoice == 0 && computerChoice == 2) ||
                       (playerChoice == 1 && computerChoice == 0) ||
                       (playerChoice == 2 && computerChoice == 1)) {
                System.out.println("   → You win this round! 🎉\n");
                playerWins++;
                round++;
            } else {
                System.out.println("   → Computer wins this round.\n");
                computerWins++;
                round++;
            }
        }
        
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        if (playerWins > computerWins) {
            System.out.println("   🏆 You won the match! Great job!");
        } else {
            System.out.println("   😊 Computer won, but you played well!");
        }
    }
    
    // ==================== JOURNALING ====================
    private static void journalEntry() {
        System.out.println("\n" + "~".repeat(50));
        System.out.println("           📝 STRESS JOURNAL 📝");
        System.out.println("~".repeat(50));
        
        System.out.println("\n1. Write a new entry");
        System.out.println("2. View past entries");
        System.out.println("3. Back to main menu");
        
        int choice = getIntInput("Choose an option: ", 1, 3);
        
        switch (choice) {
            case 1 -> writeJournalEntry();
            case 2 -> viewJournalEntries();
            case 3 -> { }
        }
    }
    
    private static void writeJournalEntry() {
        System.out.println("\nWriting can help release stress. Express yourself freely.");
        System.out.println("(Type your thoughts and press Enter twice when done)\n");
        
        System.out.println("What's on your mind today?");
        System.out.println("-".repeat(40));
        
        StringBuilder entry = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            entry.append(line).append("\n");
        }
        
        if (entry.length() > 0) {
            saveJournalEntry(entry.toString());
            System.out.println("\n✨ Your thoughts have been saved.");
            System.out.println("   Remember: It's okay to feel what you're feeling.");
        } else {
            System.out.println("\n   No entry saved. That's okay too!");
        }
    }
    
    private static void saveJournalEntry(String entry) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(JOURNAL_FILE, true))) {
            String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            writer.println("═".repeat(50));
            writer.println("Date: " + timestamp);
            writer.println("─".repeat(50));
            writer.println(entry);
            writer.println();
        } catch (IOException e) {
            System.out.println("   (Could not save to file, but your thoughts are valid!)");
        }
    }
    
    private static void viewJournalEntries() {
        File file = new File(JOURNAL_FILE);
        if (!file.exists()) {
            System.out.println("\n   No journal entries yet. Start writing today!");
            return;
        }
        
        System.out.println("\n📖 Your Journal Entries:\n");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("   Could not read journal entries.");
        }
    }
    
    // ==================== STRESS ASSESSMENT ====================
    private static void stressLevelAssessment() {
        System.out.println("\n" + "~".repeat(50));
        System.out.println("         📊 STRESS LEVEL ASSESSMENT 📊");
        System.out.println("~".repeat(50));
        
        System.out.println("\nAnswer honestly on a scale of 1-5:");
        System.out.println("(1 = Not at all, 5 = Extremely)\n");
        
        String[] questions = {
            "How overwhelmed do you feel right now?",
            "How tense are your muscles?",
            "How racing are your thoughts?",
            "How difficult is it to relax?",
            "How irritable do you feel?"
        };
        
        int totalScore = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            int answer = getIntInput("   Your rating (1-5): ", 1, 5);
            totalScore += answer;
            System.out.println();
        }
        
        System.out.println("━".repeat(40));
        System.out.println("Your Stress Score: " + totalScore + "/25");
        System.out.println("━".repeat(40));
        
        if (totalScore <= 8) {
            System.out.println("\n🟢 LOW STRESS");
            System.out.println("   You're doing great! Keep up the good habits.");
            System.out.println("   Consider a breathing exercise to maintain balance.");
        } else if (totalScore <= 15) {
            System.out.println("\n🟡 MODERATE STRESS");
            System.out.println("   You're managing, but could use some relaxation.");
            System.out.println("   Try a breathing exercise or the mini-games!");
        } else if (totalScore <= 20) {
            System.out.println("\n🟠 HIGH STRESS");
            System.out.println("   Take a break. You deserve some peace.");
            System.out.println("   The 4-7-8 breathing technique can really help.");
        } else {
            System.out.println("\n🔴 VERY HIGH STRESS");
            System.out.println("   Please take care of yourself right now.");
            System.out.println("   Consider talking to someone you trust.");
            System.out.println("   Try multiple relaxation techniques today.");
        }
    }
    
    // ==================== ACTIVITY SUGGESTIONS ====================
    private static void suggestCalmingActivity() {
        System.out.println("\n" + "~".repeat(50));
        System.out.println("         🎯 CALMING ACTIVITY SUGGESTION 🎯");
        System.out.println("~".repeat(50));
        
        String activity = CALMING_ACTIVITIES[random.nextInt(CALMING_ACTIVITIES.length)];
        
        System.out.println("\n   Here's something you could try:\n");
        System.out.println("   ╔" + "═".repeat(44) + "╗");
        System.out.printf("   ║  %-42s║%n", activity);
        System.out.println("   ╚" + "═".repeat(44) + "╝");
        
        System.out.println("\n   Would you like another suggestion? (y/n)");
        String response = scanner.nextLine().trim().toLowerCase();
        
        if (response.equals("y") || response.equals("yes")) {
            suggestCalmingActivity();
        }
    }
    
    // ==================== UTILITY METHODS ====================
    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("   Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("   Please enter a valid number.");
            }
        }
    }
    
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private static void displayGoodbye() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("        Thank you for using the Stress Reliever System");
        System.out.println("     Remember: It's okay to take breaks. Be kind to yourself.");
        System.out.println("                    Take care! 🌟💙");
        System.out.println("=".repeat(60) + "\n");
    }
}
