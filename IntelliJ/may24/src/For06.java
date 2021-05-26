import java.util.Scanner;

public class For06 {

    public static void main(String[] args) {

        int random = (int)(Math.random() * 100);

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            int input = sc.nextInt();
            if (input > random) {
                System.out.println("DOWN");
            } else if (input < random) {
                System.out.println("UP");
            } else {
                System.out.println("congraturation!");
                break;
            }
        }
    }
}
