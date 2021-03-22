package com.lb.base.utils.log;

import android.util.Log;



/**
 * Create by liub on 2021/3/4
 * Describe:
 *
 */
public class BaseLog {

    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int length = msg.length();
        int countOfSub = length / MAX_LENGTH;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + MAX_LENGTH);
                printSub(type, tag, sub);
                index += MAX_LENGTH;
            }
            printSub(type, tag, msg.substring(index, length));
        } else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case Lmsg.V:
                Log.v(tag, sub);
                break;
            case Lmsg.D:
                Log.d(tag, sub);
                break;
            case Lmsg.I:
                Log.i(tag, sub);
                break;
            case Lmsg.W:
                Log.w(tag, sub);
                break;
            case Lmsg.E:
                Log.e(tag, sub);
                break;
            case Lmsg.A:
                Log.wtf(tag, sub);
                break;
        }
    }

}
