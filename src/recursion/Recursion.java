package recursion;

public class Recursion {
    void count(int n) {
        if (n >= 0) {
            System.out.print(n + " ");
            count(n - 1);
        }
    }

    int factorial(int n) {
        if (n <= 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    int fib(int k) {
        if (k < 2)
            return k;
        else
            return fib(k - 1) + fib(k - 2);
    }

    static void move(int n, char a, char b, char c) {
        if (n == 1)
            System.out.println(a + " --> " + c);
        else {
            move(n - 1, a, c, b);
            move(1, a, ' ', c);
            move(n - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        new Recursion().count(10);
    }
}