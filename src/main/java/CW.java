import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CW {
    public static void main(String[] args) {
        System.out.println();
    }

    public boolean check(String sentence) {
        String copy = sentence.toLowerCase();
        char[] chr = copy.toCharArray();
        for (int i = 97; i <= 122; i++) {
            if (!Arrays.asList(chr).contains(i))
                return false;
        }
        return true;
    }

    public static int persistence(long n) {
        long copy = n;
        int mult = 1;
        int count = 0;
        while (copy > 9) {
            while (copy > 0) {
                mult *= copy % 10;
                copy /= 10;
            }
            count++;
            copy = mult;
            mult = 1;
        }
        return count;
    }

    public static int[] sumParts(int[] ls) {
        int[] resp = new int[ls.length + 1];
        int tempSum = 0;
        for (int i = ls.length - 1; i >= 0; i--) {
            tempSum += ls[i];
            resp[i] = tempSum;
        }
        return resp;
    }

    public static long[] step(int g, long m, long n) {
        long[] resp = new long[2];
        for (long i = m; i < n; i++) {
            if (isPrime(i) && isPrime(i + g) && i + g <= n) {
                resp[0] = i;
                resp[1] = i + g;
                return resp;
            }
        }
        return null;

    }

    public static boolean isPrime(long m) {
        boolean resp = true;
        for (int i = 2; i < m / 2; i++)
            if (m % i == 0)
                return false;
        return true;
    }

    public static String meeting(String s) {
        s = s.toUpperCase();
        String[] str = s.split(";");
        String resp = "";
        for (int i = 0; i < str.length; i++) {
            String[] tm;
            tm = str[i].split(":");
            str[i] = tm[1] + ", " + tm[0];
        }
        Arrays.sort(str);
        for (String k : str)
            resp += "(" + k + ")";
        return resp;
    }

    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0 || k > strarr.length || k <= 0)
            return "";
        String curr = "";
        boolean stop = false;
        int maxL = 0;
        String resp = "";
        for (int i = 0; i < strarr.length; i++) {
            curr = "";
            for (int j = 0; j < k; j++) {
                if (i + j >= strarr.length) {
                    stop = true;
                    break;
                }
                curr += strarr[i + j];
            }
            if (stop)
                break;
            else if (curr.length() > maxL) {
                maxL = curr.length();
                resp = curr;
            }
        }
        return resp;

        // if (strarr.length == 0 || k<=0 || k > strarr.length)
        //     return "";
        // int maxL = 0;
        // int maxI = 0;
        // String maxS = "";
        // String resp = "";
        // for (int i = 0; i < k; i++) {
        //     for (int j = 0; j < strarr.length; j++) {
        //         if (strarr[j].length() > maxL) {
        //             maxI = j;
        //             maxL = strarr[j].length();
        //             maxS = strarr[j];
        //         }
        //     }
        //     resp += strarr[maxI];
        //     for (int p = 0; p < strarr.length; p++) {
        //         if (strarr[p].equals(maxS))
        //             strarr[p] = "";
        //     }
        //     maxL = 0;
        //     maxI = 0;
        //     maxS = "";
        // }
        // return resp;
    }

    public static int[][] twosDifference(int[] array) {
        Arrays.sort(array);
        List<Integer> resp1 = new ArrayList();
        for (int i = 0; i < array.length; i++)
            for (int j = i; j < array.length; j++) {
                if (array[j] - array[i] == 2) {
                    resp1.add(array[i]);
                    resp1.add(array[j]);
                }
            }


        int[][] resp = new int[resp1.size() / 2][2];
        for (int i = 0; i < resp1.size(); i++) {
            if (i % 2 == 0) {
                resp[i / 2][0] = resp1.get(i);
            } else {
                resp[i / 2][1] = resp1.get(i);
            }
        }
        return resp;

    }


    public static String encryptThis(String text) {
        if (text.equals(""))
            return "";
        String respons = "";
        String[] str = text.split(" ");
        for (String i : str) {
            int counter = 0;
            char[] ch = i.toCharArray();
            String asc = "";
            for (char j : ch) {
                if (Character.isDigit(j)) {
                    asc += j;
                    counter++;
                }
            }
            int asc1 = Integer.parseInt(asc);
            respons += Character.toString((char) asc1);
            for (int t = 0; t < ch.length - counter; t++) {
                respons += ch[ch.length - t - 1];
            }
            respons += " ";
        }
        return respons.trim();
    }

    public static int digital_root(int n) {
        String k = Integer.toString(n);
        String[] l = k.split("");
        int[] h = new int[k.length()];
        for (int i = 0; i < k.length(); i++)
            h[i] = Integer.parseInt(l[i]);

        int resp = Arrays.stream(h).sum();

        return resp > 10 ? digital_root(resp) : resp;
    }

    public static boolean fortune(int f0, double p, int c0, int n, double i) {
        double fn = f0;
        double cn = c0;
        for (int j = 1; j <= n; j++) {
            fn = fn + Math.ceil((p / 100) * fn) - cn;
            cn = cn + Math.ceil((i / 100) * cn);
            fn = Math.ceil(fn);
            cn = Math.ceil(cn);
        }
        return fn > 0;
    }

    public static int countBits(int n) {
        char[] ch = Integer.toBinaryString(n).toCharArray();
        int counter = 0;
        for (char i : ch) {
            if (i == '1')
                counter++;
        }
        return counter;
    }

    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        char[] ch = text.toCharArray();
        int count = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 0)
                continue;
            boolean isd = false;
            for (int j = i + 1; j < ch.length; j++)
                if (ch[i] == ch[j]) {
                    ch[j] = 0;
                    isd = true;
                }
            if (isd)
                count++;
        }
        return count;
    }

    public static boolean comp(int[] a, int[] b) {
        boolean resp = true;
        if (a == null || b == null)
            return false;
        if (a.length != b.length)
            return false;
        for (int i = 0; i < b.length; ++i)
            a[i] = a[i] * a[i];
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; ++i)
            if (a[i] != b[i])
                return false;
        return resp;

    }

    public static boolean comp1(int[] a, int[] b) {
        int sum1 = Arrays.stream(a).sum();
        int sum2 = Arrays.stream(b).sum();
        int[] sm;
        int[] lg;
        if (sum1 > sum2) {
            sm = b;
            lg = a;
        } else {
            sm = a;
            lg = b;
        }
        Arrays.sort(sm);
        Arrays.sort(lg);
        for (int i = 0; i < sm.length; i++) {
            if (Math.pow(sm[i], 2) != lg[i])
                return false;
        }
        return true;
    }

    public static int findEvenIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            while (j < i) {
                sum += arr[j];
                j++;
            }
            if (j == i)
                j++;
            while (j < arr.length) {
                sum -= arr[j];
                j++;
            }
            if (sum == 0)
                return i;
            else sum = 0;
        }
        return -1;
    }

    // public static String decode(String r) {
    //     char[] str = r.toCharArray();
    //     String sBase = "";
    //     int base;
    //     int counter = 0;
    //     for (char i : str) {
    //         if (Character.isDigit(i)) {
    //             sBase += i;
    //             counter++;
    //         }
    //     }
//
    //     for (int j = counter; j < str.length; j++){
    //         str[j] =
    //     }
//
    //         base = Integer.parseInt(sBase);
    // }

    static int find(int[] integers) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0)
                count++;
            else count--;
        }
        if (count > 0)
            for (int k : integers) {
                if (k % 2 != 0)
                    return k;
            }
        if (count < 0)
            for (int k : integers) {
                if (k % 2 == 0)
                    return k;
            }
        return 0;
    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        int count = 0;
        int cur = p0;
        while (cur < p) {
            cur += cur * (percent / 100) + aug;
            count++;
        }
        return count;
    }

    public static int breakChocolate(int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        return n * m - 1;
    }

    public static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int cur = upSpeed;
        int count = 0;
        while (cur < desiredHeight) {
            cur += upSpeed - downSpeed;
            count++;
        }
        return count;
    }

    public static int Digits(long n) {
        if (n == 0)
            return 1;
        int counter = 0;
        while (n > 0) {
            n /= 10;
            counter++;
        }
        return counter;
    }

    public static boolean isAscOrder(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

    public static String findScreenHeight(int width, String ratio) {
        String[] s = ratio.split(":");
        int height = Integer.parseInt(s[1]) * width / Integer.parseInt(s[0]);
        return width + "x" + height;
    }

    public String hydrate(String drinkString) {
        int resp = 0;
        String[] s = drinkString.split(" ");
        for (String k : s) {
            if (k.length() == 1)
                resp += Integer.parseInt(k);
        }
        if (resp == 1)
            return resp + " glass of water";
        return resp + " glasses of water";
    }

    public static Double calculate(final double numberOne, final String operation, final double numberTwo) {
        switch (operation) {
            case ("+"):
                return numberOne + numberTwo;
            case ("-"):
                return numberOne - numberTwo;
            case ("*"):
                if (numberOne == 0 || numberTwo == 0)
                    return 0.0;
                return numberOne * numberTwo;
            case ("/"):
                if (numberTwo == 0)
                    return null;
                return numberOne / numberTwo;
            case ("m"):
                if (numberOne % numberTwo == 0)
                    return null;
                return numberOne % numberTwo;
        }
        return null;
    }

    public static String splitInParts(String s, int partLength) {
        String respons = "";
        char[] symb = s.toCharArray();
        for (int i = 0; i < symb.length; i++) {
            if (i % partLength == 0 && i != 0)
                respons += " ";
            respons += symb[i];
        }
        return respons;
    }

    public int solve(int n) {
        int[] nom = {500, 200, 100, 50, 20, 10};
        int count = 0;
        if (n % 10 != 0)
            return -1;
        for (int i = 0; i < nom.length; i++)
            while (n >= nom[i]) {
                n -= nom[i];
                count++;
            }
        return count;
    }

    public static String greet(String name) {
        name = name.toLowerCase();
        return "Hello " + Character.toString(name.charAt(0) - 32) + name.substring(1) + "!";
    }

    public int GetSum(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int resp = 0;
        for (int i = a; a <= b; a++) {
            resp += a;
        }
        return resp;
    }

    public static int[] multiples(int m, int n) {
        int[] resp = new int[m];
        for (int i = 1; i <= m; i++)
            resp[i - 1] = n * i;
        return resp;
    }

    int halvingSum(int n) {
        int sum = 0;
        while (n >= 1) {
            sum += n;
            n /= 2;
        }
        return sum;
    }

    public static int modifiedSum(int[] array, int power) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += Math.pow(array[i], power) - array[i];
        }

        return sum;
    }

    public static int roundToNext5(int number) {
        if (number % 5 == 0)
            return number;
        for (int i = 1; i < 5; i++) {
            number++;
            if (number % 5 == 0)
                return number;
        }
        return 0;
    }

    public static String initials(String name) {
        name = name.toLowerCase();
        String respons = "";
        String[] sub = name.split(" ");
        for (int i = 0; i < sub.length; i++) {
            respons += Character.toString(sub[i].charAt(0) - 32);
            if (i < sub.length - 1)
                respons += ".";
        }
        respons += sub[sub.length - 1].substring(1);
        return respons;
    }

    public static int nbDig(int n, int d) {
        String squares = "";
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            squares += Integer.toString(i * i);
        }
        char[] sub = squares.toCharArray();
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] - 48 == d)
                counter++;
        }
        return counter;
    }

    public static String[] capitalize(String s) {
        String[] resp = new String[]{"", ""};
        char[] sub = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                resp[1] += (char) (sub[i] - 32);
                resp[0] += (char) sub[i];
            } else {
                resp[1] += (char) sub[i];
                resp[0] += (char) (sub[i] - 32);
            }
        }
        return resp;
    }

    public static String capitalize(String s, int[] ind) {
        String resp = "";
        char[] sub = s.toCharArray();
        for (int i : ind) {
            if (i <= s.length())
                sub[i] -= 32;
            else continue;
        }
        for (char k : sub) {
            resp += k;
        }
        return resp;
    }

    public static int[] findMultiples(int x, int n) {
        int[] response = new int[x];
        for (int i = 1; i <= x; i++) {
            response[i - 1] = i * n;
        }
        return response;
    }

    public static int countOddPositionChars(String[] array) {
        if (array == null)
            return 0;
        int respons = 0;
        for (int i = 1; i <= array.length; i++)
            if (i % 2 != 0) {
                respons += array[i - 1].length();
            }
        return respons;
    }

    public static int findSmallestElement(int[] nums) {
        java.util.Arrays.sort(nums);
        if (nums.length == 0 || nums == null)
            return 0;
        return nums[0];
    }

    public static char getLastCharacter(String input) {
        char[] mass = input.toCharArray();
        return mass[mass.length - 1];
    }

    public static int stringLength(String input) {
        if (input == null)
            return 0;
        return input.length();
    }


    public static String[] stringToArray(String s) {

        return s.split(" ");
    }

    public static String twoSort(String[] s) {
        Arrays.sort(s);
        char[] word = s[0].toCharArray();
        String resp = "";
        for (int i = 0; i < word.length - 1; i++)
            resp += word[i] + "***";
        return resp += word[word.length - 1];
    }

    public static Integer calculateTip(double amount, String rating) {
        double tip = 0;
        rating = rating.toLowerCase();
        if (rating.equals("terrible"))
            tip = 0;
        else if (rating.equals("poor"))
            tip = Math.ceil(amount * 0.05);
        else if (rating.equals("good"))
            tip = Math.ceil(amount * 0.1);
        else if (rating.equals("great"))
            tip = Math.ceil(amount * 0.15);
        else if (rating.equals("excellent"))
            tip = Math.ceil(amount * 0.2);
        else return null;

        return (int) tip;
    }

    public static int expressionsMatter(int a, int b, int c) {
        int[] answ = new int[4];
        answ[0] = a + b + c;
        answ[1] = a * (b + c);
        answ[2] = (a + b) * c;
        answ[3] = a * b * c;
        Arrays.sort(answ);
        return answ[answ.length - 1];
    }

    public static int[] divisibleBy(int[] numbers, int divider) {
        int count = 0;
        int j = 0;
        for (int i : numbers) {
            if (i % divider == 0)
                count++;
        }
        int[] resp = new int[count];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                resp[j] = numbers[i];
                j++;
            }
        }
        return resp;
        //return Arrays.stream(numbers)
        //        .filter(i -> (i % divider) == 0)
        //        .toArray();
    }

    public static String solution(String str) {
        char[] symb = str.toCharArray();
        String resp = "";
        for (int i = str.length() - 1; i >= 0; i--)
            resp += symb[i];
        return resp;
        //return new StringBuilder(str).reverse().toString();
    }

    public static int sumOfDifferences(int[] arr) {
        int sum = 0;
        java.util.Arrays.sort(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            sum += (arr[i] - arr[i - 1]);
        }
        return sum;
    }

    public static String remove(String str) {
        char[] symb = str.toCharArray();
        String resp = "";
        for (int i = 1; i < symb.length - 1; i++)
            resp += symb[i];
        return resp;
    }

    public static boolean isDigit(String s) {
        char[] symb = s.toCharArray();
        if (s == "" || symb.length > 1)
            return false;
        for (int i = 0; i < symb.length; i++) {
            if (symb[i] < 48 || symb[i] > 57)
                return false;
        }
        return true;
    }

    static String noSpace(final String x) {
        return x.replaceAll("\\s", "");
    }

    public static int nthEven(int n) {
        return n * 2 - 2;
    }

    public static String abbrevName(String name) {
        String[] str = new String[2];
        int count = 0;
        for (String i : name.split(" ")) {
            str[count] = i;
            count++;
        }
        return (str[0].toCharArray()[0] + "." + str[1].toCharArray()[0]).toUpperCase();
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length < 1) {
            return new int[0];
        }
        int[] array = new int[2];

        for (int i = 0; i < input.length; i++) {
            if (input[i] <= 0) {
                array[1] += input[i];
            } else {
                array[0] += 1;
            }
        }
        return array;
    }

    public static String well(String[] x) {
        int res = 0;
        for (String i : x) {
            if (i.equals("good"))
                res++;
        }
        if (res == 0)
            return "Fail!";
        else if (res == 1 || res == 2)
            return "Publish!";
        else return "I smell a series!";
    }

    public static int findSmallestInt(int[] args) {
        return java.util.Arrays.stream(args).min().getAsInt();
    }

    public static int[] invert1(int[] array) {
        if (array != null)
            return Arrays.stream(array).map(x -> x * (-1)).toArray();
        else return null;
    }

    public static int[] map(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++)
            arr[i] *= 2;
        return arr;
    }

    public static int[] invert(int[] array) {
        return java.util.Arrays.stream(array).map(i -> -i).toArray();
    }

    public static int[] monkeyCount(final int n) {
        int[] resp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            resp[i] = i + 1;
        }
        return resp;
    }

    public static int century(int number) {
        if (number == 1 || number == 0)
            return 1;
        if (number % 100 == 00)
            return (number / 100);
        return (number / 100) + 1;
    }

    static String greet(String name, String owner) {
        if (name.equals(owner))
            return "Hello boss";
        return "Hello guest";
    }
}
