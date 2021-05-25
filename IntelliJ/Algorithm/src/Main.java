import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        N2562();
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
        for (int i = 0; i < input.length(); i++)
        {
            int key = input.charAt(i);
            if (map.containsKey(key) == false)
            {
                map.put(key, i);
            }
        }

        for (int i = 'a'; i < 'z'; i++)
        {
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

    public static void N1157()
    {
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
                map.entrySet()){
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
}
