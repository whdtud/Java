import java.util.Arrays;

public class Lotto {
/* 로또
1~45 6개 숫자 중복 불가
 */

    public static void main(String[] args) {

        final int NUMBER_COUNT = 6;

        int[] random = new int[NUMBER_COUNT];
        // random
        for (int i = 0; i < random.length; i++) {
            random[i] = (int)(Math.random() * 44 + 1);
            for (int j = 0; j < i; j++) {
                if (random[i] == random[j]) {
                    random[i] = (int) (Math.random() * 45 + 1);
                    j = 0;
                }
            }
        }

        System.out.println(Arrays.toString(random));
    }
}
