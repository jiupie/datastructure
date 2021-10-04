package com.wl;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class TestDemo {
    @Test
    public void test() {
//        Integer a = new Integer(9);
//        Integer b = new Integer(9);
        Integer a = 9;
        Integer b = 9;

        Long c = new Long(9);
        System.out.println(a == b);
//        System.out.println(b == c);
        System.out.println(a.equals(b));
        System.out.println(b.equals(new Integer(9)));


    }

    @Test
    public void test1() throws ParseException {
        String number = "431126200009188414";
        String substring = number.substring(6, 14);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        Date parse = simpleDateFormat.parse(substring);
        System.out.println(parse);
        Calendar instance = Calendar.getInstance();

    }

}
