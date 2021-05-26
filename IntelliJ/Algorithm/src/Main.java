import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Daum();
    }

    public static void N11720() {
        /* 숫자의 합
        N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
        입력) 첫째 줄에 숫자의 개수 N(1 <= n <= 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
         */
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String input = sc.next();

        int total = 0;
        for (int i = 0; i < count; i++) {
            char value = input.charAt(i);
            total += Character.getNumericValue(value);
        }

        System.out.print(total);
    }

    public static void N10809() {
        /* 알파벳 찾기
        알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서,
        단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는
        -1을 출력하는 프로그램을 작성하시오.
        입력) 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
        출력) 각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치,
        ...z가 처음 등장하는 위치를 공백으로 구분해서 출력한다. 만약 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다.
        단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
         */
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length(); i++) {
            int key = input.charAt(i);
            if (map.containsKey(key) == false) {
                map.put(key, i);
            }
        }

        for (int i = 'a'; i < 'z'; i++) {
            if (map.containsKey(i))
                System.out.printf("%d ", map.get(i));
            else
                System.out.printf("%d ", -1);
        }
    }

    public static void N2562() {
        /* 최댓값
        9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고
        그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
        예를 들어, 서로 다른 9개의 자연수
        3, 29, 38, 12, 57, 74, 40, 85, 61
        이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
        입력) 첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다.
        주어지는 자연수는 100 보다 작다.
        출력) 첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.
         */

        Scanner sc = new Scanner(System.in);

        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {
            array[i] = sc.nextInt();
        }

        int max = -1;
        int position = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                position = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(position);
    }

    public static void N1157() {
        /* 단어 공부
         * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된
         * 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
         *
         * 입력) 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
         * 출력) 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
         * 단, 가장 많이 사용된 알파벳이 여러개 존재하는 경우에는 ?를 출력한다.
         */

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = Character.toUpperCase(input.charAt(i));
            Integer value = map.getOrDefault(ch, 0);
            value++;

            map.put(ch, value);
        }

        int highestValue = -1;
        char highestChar = '0';
        for (Map.Entry<Character, Integer> entry :
                map.entrySet()) {
            int value = entry.getValue();
            if (value > highestValue) {
                highestValue = value;
                highestChar = entry.getKey();
            } else if (value == highestValue) {
                highestChar = '?';
            }
        }

        System.out.print(highestChar);

        sc.close();
    }

    public static void N1152() {
        /* 단어의 개수
           영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다.
           이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
           단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
           입력) 첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문자열이 주어진다.
           이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 띄어쓰 한 개로 구분되며,
           공백이 연속해서 나오는 경우는 없다. 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.
         */

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.trim();
        String[] words = input.split(" ");

        System.out.print(words.length);

        sc.close();
    }

    public static void N3052() {
        /* 나머지
        두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
        수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
        입력) 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
        출력) 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
         */

        Scanner sc = new Scanner(System.in);
        int[] array = new int[42];

        for (int i = 0; i < 10; i++) {
            int index = sc.nextInt() % 42;
            array[index]++;
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }

        System.out.print(count);

        sc.close();
    }

    public static void Daum() {
        /*
        1차원의 점들이 주어졌을 때 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오.
        (단 점들의 배열은 모두 정렬되어있다고 가정한다.)
        예를들어 S={1, 3, 4, 8, 13, 17, 20} 이 주어졌다면, 결과값은 (3, 4)가 될 것이다.
         */

        int[] array = new int[] {1, 3, 4, 8, 13, 17, 20};

        int index = -1;
        int nearestDist = array.length;
        for (int i = 0; i < array.length - 1; i++) {
            int dist = array[i + 1] - array[i];
            if (dist < nearestDist) {
                nearestDist = dist;
                index = i;
            }
        }

        System.out.printf("(%d, %d)", array[index], array[index + 1]);
    }
}