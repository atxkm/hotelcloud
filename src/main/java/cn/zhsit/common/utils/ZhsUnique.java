package cn.zhsit.common.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Darren on 2017/7/3.
 */
public final class ZhsUnique {
    private final long mostSigBits;
    private final long leastSigBits;

    private static class Holder {
        static final SecureRandom numberGenerator = new SecureRandom();
    }

    private ZhsUnique(byte[] data) {
        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++)
            msb = (msb << 8) | (data[i] & 0xff);
        for (int i = 8; i < 16; i++)
            lsb = (lsb << 8) | (data[i] & 0xff);
        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    public static String unique25() {
        return new BigInteger(unique32(), 16).toString(36);
    }

    public static String unique32() {
        SecureRandom ng = Holder.numberGenerator;
        byte[] randomBytes = new byte[16];
        ng.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;
        randomBytes[6] |= 0x40;
        randomBytes[8] &= 0x3f;
        randomBytes[8] |= 0x80;
        return new ZhsUnique(randomBytes).getString();
    }

    private String getString() {
        return (digits(mostSigBits >> 32, 8) +
                digits(mostSigBits >> 16, 4) +
                digits(mostSigBits, 4) +
                digits(leastSigBits >> 48, 4) +
                digits(leastSigBits, 12));
    }


    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }


}
