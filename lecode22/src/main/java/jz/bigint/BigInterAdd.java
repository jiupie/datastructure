package jz.bigint;

/**
 * 大数相加
 */
public class BigInterAdd {
    public static void main(String[] args) {
        BigInterAdd bigInterAdd = new BigInterAdd();
        System.out.println(bigInterAdd.add("19", "91"));
    }

    public String add(String num1, String num2) {
        if(num1==null||num2==null){
            return null;
        }
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        int len1 = num1Arr.length - 1;
        int len2 = num2Arr.length - 1;

        StringBuffer stringBuffer = new StringBuffer();
        int jw = 0;
        while (len1 >= 0 || len2 >= 0) {
            int n1 = len1 >= 0 ? num1Arr[len1--] - '0' : 0;
            int n2 = len2 >= 0 ? num2Arr[len2--] - '0' : 0;

            int s = n1 + n2 + jw;
            jw = s / 10;
            stringBuffer.append(s % 10);
        }
        if (jw > 0) {
            stringBuffer.append(jw);
        }
        return stringBuffer.reverse().toString();
    }
}

