//PROGRAM
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public PerformOperation isOdd() {
        return n -> n % 2 != 0;
    }

    public PerformOperation isPrime() {
        return n -> {
            if (n < 2)
                return false;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0)
                    return false;
            }

            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return n -> {
            int original = n;
            int reverse = 0;

            while (n > 0) {
                reverse = reverse * 10 + n % 10;
                n /= 10;
            }

            return original == reverse;
        };
    }

    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyMath ob = new MyMath();

        int T = sc.nextInt();

        while (T-- > 0) {

            int ch = sc.nextInt();
            int num = sc.nextInt();

            if (ch == 1) {
                if (ob.checker(ob.isOdd(), num))
                    System.out.println("ODD");
                else
                    System.out.println("EVEN");
            } else if (ch == 2) {
                if (ob.checker(ob.isPrime(), num))
                    System.out.println("PRIME");
                else
                    System.out.println("COMPOSITE");
            } else if (ch == 3) {
                if (ob.checker(ob.isPalindrome(), num))
                    System.out.println("PALINDROME");
                else
                    System.out.println("NOT PALINDROME");
            }
        }

        sc.close();
    }
}
// Input 
5
1 4
2 5
3 898
1 3
2 12
//Your Output (stdout)
EVEN
PRIME
PALINDROME
ODD
COMPOSITE
