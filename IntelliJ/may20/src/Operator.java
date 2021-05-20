public class Operator {
    
    public static void main(String[] args)
    {
        int num01 = 1;
        int num02 = ++num01;
        int num03 = --num01 + ++num02;
        int num04 = ++num01 - --num02;

        num01 = 0; num02 = 0; num03 = 0; num04 = 0;
        num02 = num01++;
        num03 = num02++ + num01;

        System.out.println(num01);
        System.out.println(num02);
        System.out.println(num03);
        System.out.println(num04);

        int bitNum01 = ~1;
        System.out.print(Integer.toBinaryString(bitNum01));
    }
}
