import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        int i = 0;
        String in_string1;
        do {
            in_string1 = sc.nextLine();
            words.add(in_string1);
            i += 1;
        } while (in_string1.compareTo("0") != 0);
        for (int count = 0; count < i -1; count += 1) System.out.println(words.get(count));
        }
    }
