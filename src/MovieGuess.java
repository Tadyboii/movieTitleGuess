import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MovieGuess {
    ArrayList<String> titles = new ArrayList<>();
    int movie, wrongLetterCounter = 0;
    StringBuilder currentBlanks = new StringBuilder();
    StringBuilder wrongLetter = new StringBuilder();
    boolean blankCreation = true;
    boolean gameNotOver;

    public MovieGuess(Scanner a) {
        while (a.hasNextLine()) {
            String line = a.nextLine();
            titles.add(line);
        }
        this.movie = new Random().nextInt(titles.size());
        currentBlanks.append(titles.get(movie));
        gameNotOver = true;
    }

    public void guessLetter(Scanner s) {
        blankReplacer('_');
        System.out.println(currentBlanks);
        while (gameNotOver) {
            System.out.println(titles.get(movie));
            System.out.println("wrong letter(" + wrongLetterCounter + "): " + wrongLetter);
            char letter = s.nextLine().charAt(0);
            showBlank(letter);
            wrongChecker(letter);
            winnerChecker();
        }
    }

    public void showBlank(char letter) {
        blankReplacer(letter);
        System.out.println(currentBlanks);
        blankCreation = false;
    }

    public void blankReplacer(char letter) {
        for (int i = 0; i < titles.get(movie).length(); i++) {
            if (titles.get(movie).charAt(i) == ' ') {
                currentBlanks.setCharAt(i, ' ');
            } else if (titles.get(movie).charAt(i) == '\'') {
                currentBlanks.setCharAt(i, '\'');
            } else if (titles.get(movie).charAt(i) == letter) {
                currentBlanks.setCharAt(i, letter);
            } else if (blankCreation) {
                currentBlanks.setCharAt(i, '_');
            }
        }
    }

    public void wrongChecker(char letter) {
        if (!titles.get(movie).contains(String.valueOf(letter))) {
            if (wrongLetter.indexOf(String.valueOf(letter)) == -1) {
                wrongLetter.append(letter);
                wrongLetter.append(" ");
            }
            wrongLetterCounter += 1;
        }
    }

    public void winnerChecker() {
        if (currentBlanks.indexOf("_") == -1) {
            System.out.println("You Win!");
            gameNotOver = false;
        }
    }
}

