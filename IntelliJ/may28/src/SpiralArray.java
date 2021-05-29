import java.util.Arrays;
import java.util.Scanner;

public class SpiralArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("배열 크기를 입력해주세요 (ex : 6 6): ");
        String input = sc.nextLine();

        String[] sizeArr = input.split(" ");
        int sizeX = Integer.parseInt(sizeArr[0]);
        int sizeY = Integer.parseInt(sizeArr[0]);

        int[][] array = new int[sizeY][sizeX];

        int x = -1;
        int y = 0;
        int directionX = 1;
        int directionY = 0;

        for (int i = 1; i <= sizeX * sizeY; i++) {
            int nextIndexX = x + directionX;
            int nextIndexY = y + directionY;

            if (nextIndexX < 0 || nextIndexX == array.length || nextIndexY == array.length) {
                if (directionX == 1) {
                    directionX = 0;
                    directionY = 1;
                } else if (directionY == 1) {
                    directionY = 0;
                    directionX = -1;
                } else if (directionX == -1) {
                    directionX = 0;
                    directionY = -1;
                } else if (directionY == -1) {
                    directionY = 0;
                    directionX = 1;
                }
                i -= 1;
                continue;
            }

            if (array[nextIndexY][nextIndexX] == 0) {
                x = nextIndexX;
                y = nextIndexY;
                array[y][x] = i;
            } else {
                if (directionX == 1) {
                    directionX = 0;
                    directionY = 1;
                } else if (directionY == 1) {
                    directionY = 0;
                    directionX = -1;
                } else if (directionX == -1) {
                    directionX = 0;
                    directionY = -1;
                } else if (directionY == -1) {
                    directionY = 0;
                    directionX = 1;
                }
                i -= 1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%2d ", array[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
