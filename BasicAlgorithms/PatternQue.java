public class PatternQue {
    public static void main(String[] args) {
        System.out.println();
        // printMixStarPattern(10);
        // printReverseStarPattern(5);
        // printMixPatternWithDoubleRows(10);
        printNoInDia(10);
        // printFullDiamond(5);
    }

    static void printNoPattern(int nLines) {
        for (int i = 0; i <= nLines; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d  ", j);
            }
            System.out.println();
        }
    }

    static void printStarPattern(int nLines) {
        for (int i = 0; i <= nLines; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printReverseStarPattern(int nLines) {
        /*
         * for (int i = 0; i <= nLines; i++) {
         * for (int j = nLines; j >= i; j--) {
         * System.out.print("* ");
         * }
         * System.out.println();
         * }
         */
        // Another method to print this pattern by using formula nLines + 1 - i
        // If nLines = 5 and i = 1 ==> this is for the colunms looop
        // 5 + 1 - 1 = 5 col

        for (int i = 1; i <= nLines; i++) {
            for (int j = 1; j <= nLines + 1 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printMixStarPattern(int nLines) {
        for (int i = 0; i <= nLines / 2; i++) {
            for (int j = nLines / 2; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i <= nLines / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printMixPatternWithDoubleRows(int nLines) {
        for (int i = 0; i <= 2 * nLines; i++) {
            int col = i > nLines ? 2 * nLines - i : i;
            for (int j = 0; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printHalfDiamond(int nLines) {
        for (int i = 0; i < nLines; i++) {
            // int col = nLines - i;
            int spaces = nLines - i;
            for (int k = 0; k <= spaces; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printFullDiamond(int nLines) {
        for (int i = 0; i <= 2 * nLines; i++) {
            int col = i > nLines ? 2 * nLines - i : i;
            int spaces = nLines - col;
            for (int k = 0; k <= spaces; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printNoInDia(int nLines) {
        for (int i = 1; i <= nLines; i++) {
            for (int j = 0; j <= nLines - i; j++) {
                System.out.print(" ");
            }

            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            for (int l = 2; l <= i; l++) {
                System.out.print(l);
            }
            System.out.println();
        }
    }
}
