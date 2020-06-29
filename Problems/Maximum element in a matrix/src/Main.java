import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxColumn = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                if (a > max) {
                    max = a;
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }
        System.out.println(maxRow + " " + maxColumn);
    }
}