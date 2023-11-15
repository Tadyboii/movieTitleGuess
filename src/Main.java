import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        File file = new File("src\\MovieList.txt");
        Scanner fileScan = new Scanner(file);
        MovieGuess newGame = new MovieGuess(fileScan);

        Scanner input = new Scanner(System.in);
        newGame.guessLetter(input);
    }
}