package org.lc.dataTypeTrans;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/25.
 */
public class typeTrans {

    public static void main(String[] args) {
        factorial(100);
    }

    //整数的阶乘
    public static void factorial(int value) {
        ArrayList result = new ArrayList();
        int carryBit = 0;

        result.add(new Integer(1));
        for (int out = 2; out <= value; out++) {
            for (int in = 0; in < result.size(); in++) {
                int temp = ((Integer) result.get(in)).intValue() * out
                        + carryBit;
                result.set(in, new Integer(temp % 10));
                carryBit = temp / 10;
            }
            while (carryBit != 0) {
                result.add(new Integer(carryBit % 10));
                carryBit = carryBit / 10;
            }
        }
        StringBuffer sb=new StringBuffer(result.size());
        for(int i=0;i<result.size();i++)
        {
            sb.append(result.get(i));
        }
        sb=sb.reverse();
        System.out.println("result="+sb);
        System.out.println("结果位数"+result.size());
    }

    public void test(){

    }
}
