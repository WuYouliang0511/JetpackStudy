package com.loto.databinding;

/**
 * @Author: Wu Youliang
 * @CreateDate: 2021/6/2 上午10:15
 * @Company LotoGram
 */

public class StartUtil {

    public static String getStart(int start) {
        switch (start) {
            case 1:
                return "1星";
            case 2:
                return "2星";
            case 3:
                return "3星";
            case 4:
                return "4星";
            case 5:
                return "5星";
            default:
                return "5星以上";
        }
    }
}
