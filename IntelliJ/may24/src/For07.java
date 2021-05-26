public class For07 {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i < 6; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < 5; i++ ) {
            if (i == 0 || i == 4) {
                for (int j = 0; j < 5; j++) {
                    System.out.print("*");
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    if (j == 0 || j == 4) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }


        //*___*
        //**__*
        //*_*_*
        //*__**
        //*___*
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0 || j == 4) {
                    System.out.print("*");
                } else {
                    if (i == j)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
