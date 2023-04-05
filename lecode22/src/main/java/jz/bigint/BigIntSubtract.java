package jz.bigint;

public class BigIntSubtract {
    public static void main(String[] args) {
        BigIntSubtract bigIntSubtract = new BigIntSubtract();
        System.out.println(bigIntSubtract.subtract("23", "2"));
        System.out.println(bigIntSubtract.subtract("20", "8"));
        System.out.println(bigIntSubtract.subtract("200", "8"));
        System.out.println(bigIntSubtract.subtract("20", "800"));
        System.out.println(bigIntSubtract.subtract("21", "218"));

    }

    public String subtract(String num1, String num2) {
        boolean exchange = false;

        if (num1.length() < num2.length()) {
            exchange = true;
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        if (num1Arr.length == num2Arr.length) {
            for (int i = num1Arr.length - 1; i >= 0; i--) {
                if (num2Arr[i] > num1Arr[i]) {
                    exchange = true;
                }
            }
            if (exchange) {
                char[] temp = num1Arr;
                num1Arr = num2Arr;
                num2Arr = temp;
            }
        }

        int len1 = num1Arr.length - 1;
        int len2 = num2Arr.length - 1;


        int brow = 0;
        StringBuffer stringBuffer = new StringBuffer();

        //020
        //008
        while (len1 >= 0 || len2 >= 0) {
            int n1 = len1 >= 0 ? num1Arr[len1--] - '0' : 0;
            int n2 = len2 >= 0 ? num2Arr[len2--] - '0' : 0;
            int res = 0;
            if (brow == 1) {
                if (n1 == 0) {
                    n1 = 9;
                }else {
                    n1--;
                }
            }
            if (n1 >= n2) {
                res = n1 - n2;
                brow = 0;
            } else if (len1 < 0 ) {
                res = n1 - n2;
                res = -res;
                brow = 1;
            } else {
                res = n1 + 10 - n2;
                brow = 1;
            }
            stringBuffer.append(res);
        }
        if (brow == 1 || exchange) {
            stringBuffer.append("-");
        }
        return stringBuffer.reverse().toString();
    }
}
