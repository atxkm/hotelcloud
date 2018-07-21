package cn.zhsit.common.utils;

/**
 * Created by Administrator on 2017/10/14.
 */
public class ZhsByteUtil {
//    一个16进制数有两个字节组成，例如：A9。
//    高字节就是指16进制数的前8位（权重高的8位），如上例中的A。
//    低字节就是指16进制数的后8位（权重低的8位），如上例中的9。
//Little endian：将低序字节存储在起始地址
//Big endian：将高序字节存储在起始地址


    /**
     * 高低字节转换器
     *
     * @param bte
     * @return
     */
    public static byte convertHL(byte bte) {
        int high = ((bte & 0xf0) >> 4);
        int low = (bte & 0x0f) << 4;
        return (byte) (high + low);
    }

    /**
     * 高低字节转换器
     *
     * @param bytes
     * @return
     */
    public static byte[] convertHL(byte[] bytes) {
        byte[] back = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            back[i] = convertHL(bytes[i]);
        }
        return back;
    }


    public static int getHeight4(byte bte) {//获取高四位
        return ((bte & 0xF0) >> 4);
    }

    public static int getLow4(byte bte) {//获取低四位
        return (bte & 0x0F);
    }

    //获取高八位
    public static int getHeight8(int bte) {
        return ((bte & 0xFF00) >> 8);
    }

    //获取低八位
    public static int getLow8(int bte) {
        return (bte & 0xFF);
    }

    /**
     * java为Big Endian字节序
     * 低地址 ------> 高地址
     * 高位           低位
     *
     * @param bytes
     * @return
     */
    public static int bytes4ToInt(byte[] bytes) {
        int num = bytes[3] & 0xFF;
        num |= ((bytes[2] << 8) & 0xFF00);
        num |= ((bytes[1] << 16) & 0xFF0000);
        num |= ((bytes[0] << 24) & 0xFF000000);
        return num;
    }

    public static int bytes3ToInt(byte[] bytes) {
        int num = bytes[2] & 0xFF;
        num |= ((bytes[1] << 8) & 0xFF00);
        num |= ((bytes[0] << 16) & 0xFF0000);
        return num;
    }

    public static int bytes2ToInt(byte[] bytes) {
        int num = bytes[1] & 0xFF;
        num |= ((bytes[0] << 8) & 0xFF00);
        return num;
    }

    public static int bytes1ToInt(byte[] bytes) {
        int num = bytes[0] & 0xFF;
        return num;
    }
//
//    public static void main(String[] args) {
//        System.out.println(bytes1ToInt(intToByte1(255)));
//        System.out.println(bytes2ToInt(intToByte2(32767)));
//        System.out.println(bytes3ToInt(intToByte3(524287)));
//        System.out.println(bytes4ToInt(intToByte4(2147483647)));
//
//
//        System.out.println(bytesNToInt(intToByte1(127)));
//        System.out.println(bytesNToInt(intToByte2(32767)));
//        System.out.println(bytesNToInt(intToByte3(524287)));
//        System.out.println(bytesNToInt(intToByte4(2147483647)));
//
//    }

    /**
     * 将不定长byte数组转换成int值
     *
     * @param bytes
     * @return
     */
    public static int bytesNToInt(byte[] bytes) {
        int length=bytes.length;
        switch (length){
            case 1:
                return bytes1ToInt(bytes);
            case 2:
                return bytes2ToInt(bytes);
            case 3:
                return bytes3ToInt(bytes);
            case 4:
                return bytes4ToInt(bytes);
        }
        return bytes4ToInt(bytes);
    }

    /**
     * <pre>
     * 将32位int转换为由1个8位byte数字.
     * </pre>
     *
     * @param sum
     * @return
     */
    public static byte intToByte(int sum) {
        byte bte = (byte) (sum & 0xFF);
        return bte;
    }

//    /**
//     * <pre>
//     * 将32位int转换为由1个8位byte数字.
//     * </pre>
//     *
//     * @param sum
//     * @return
//     */
//    public static byte[] intToByte1(int sum) {
//        byte[] arr = new byte[1];
//        arr[0] = (byte) (sum & 0xFF);
//        return arr;
//    }

    /**
     * <pre>
     * 将32位int转换为由2个8位byte数字.
     * </pre>
     *
     * @param sum
     * @return
     */
    public static byte[] intToByte2(int sum) {
        byte[] arr = new byte[2];
        arr[0] = (byte) (sum >> 8);
        arr[1] = (byte) (sum & 0xFF);
        return arr;
    }

    public static byte[] intToByte3(int sum) {
        byte[] arr = new byte[3];
        arr[0] = (byte) (sum >> 16);
        arr[1] = (byte) (sum >> 8);
        arr[2] = (byte) (sum & 0xFF);
        return arr;
    }

    public static byte[] intToByte1(int sum) {
        byte[] arr = new byte[1];
        arr[0] = (byte) (sum & 0xFF);
        return arr;
    }

    /**
     * <pre>
     * 将32位int转换为由四个8位byte数字.
     * </pre>
     *
     * @param sum
     * @return
     */
    public static byte[] intToByte4(int sum) {
        byte[] arr = new byte[4];
        arr[0] = (byte) (sum >> 24);
        arr[1] = (byte) (sum >> 16);
        arr[2] = (byte) (sum >> 8);
        arr[3] = (byte) (sum & 0xFF);
        return arr;
    }

    /**
     * <pre>
     * 将int转换为32位byte.
     * 实际上每个8位byte只存储了一个0或1的数字
     * 比较浪费.
     * </pre>
     *
     * @param num
     * @return
     */
    public static byte[] intToByte32(int num) {
        byte[] arr = new byte[32];
        for (int i = 31; i >= 0; i--) {
            // &1 也可以改为num&0x01,表示取最地位数字.
            arr[i] = (byte) (num & 1);
            // 右移一位.
            num >>= 1;
        }
        return arr;
    }

    public static Integer byteToUnsignedInt(byte data) {
        return data & 0xFF;
    }

    /**
     * <pre>
     * 将4个byte数字组成的数组合并为一个float数.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static float byte4ToFloat(byte[] arr) {
        if (arr == null || arr.length != 4) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是4位!");
        }
        int i = byte4ToInt(arr);
        return Float.intBitsToFloat(i);
    }

    /**
     * <pre>
     * 将一个float数字转换为4个byte数字组成的数组.
     * </pre>
     *
     * @param f
     * @return
     */
    public static byte[] floatToByte4(float f) {
        int i = Float.floatToIntBits(f);
        return intToByte4(i);
    }

    /**
     * <pre>
     * 将八个byte数字组成的数组转换为一个double数字.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static double byte8ToDouble(byte[] arr) {
        if (arr == null || arr.length != 8) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是8位!");
        }
        long l = byte8ToLong(arr);
        return Double.longBitsToDouble(l);
    }

    /**
     * <pre>
     * 将一个double数字转换为8个byte数字组成的数组.
     * </pre>
     *
     * @param i
     * @return
     */
    public static byte[] doubleToByte8(double i) {
        long j = Double.doubleToLongBits(i);
        return longToByte8(j);
    }

    /**
     * <pre>
     * 将一个char字符转换为两个byte数字转换为的数组.
     * </pre>
     *
     * @param c
     * @return
     */
    public static byte[] charToByte2(char c) {
        byte[] arr = new byte[2];
        arr[0] = (byte) (c >> 8);
        arr[1] = (byte) (c & 0xFF);
        return arr;
    }

    /**
     * <pre>
     * 将2个byte数字组成的数组转换为一个char字符.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static char byte2ToChar(byte[] arr) {
        if (arr == null || arr.length != 2) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是2位!");
        }
        return (char) (((char) (arr[0] << 8)) | ((char) arr[1]));
    }

    /**
     * <pre>
     * 将一个16位的short转换为长度为2的8位byte数组.
     * </pre>
     *
     * @param s
     * @return
     */
    public static byte[] shortToByte2(Short s) {
        byte[] arr = new byte[2];
        arr[0] = (byte) (s >> 8);
        arr[1] = (byte) (s & 0xFF);
        return arr;
    }

    /**
     * <pre>
     * 长度为2的8位byte数组转换为一个16位short数字.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static short byte2ToShort(byte[] arr) {
        if (arr != null && arr.length != 2) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是2位!");
        }
        return (short) (((short) arr[0] << 8) | ((short) arr[1] & 0xFF));
    }

    /**
     * <pre>
     * 将short转换为长度为16的byte数组.
     * 实际上每个8位byte只存储了一个0或1的数字
     * 比较浪费.
     * </pre>
     *
     * @param s
     * @return
     */
    public static byte[] shortToByte16(short s) {
        byte[] arr = new byte[16];
        for (int i = 15; i >= 0; i--) {
            arr[i] = (byte) (s & 1);
            s >>= 1;
        }
        return arr;
    }

    public static short byte16ToShort(byte[] arr) {
        if (arr == null || arr.length != 16) {
            throw new IllegalArgumentException("byte数组必须不为空,并且长度为16!");
        }
        short sum = 0;
        for (int i = 0; i < 16; ++i) {
            sum |= (arr[i] << (15 - i));
        }
        return sum;
    }


    /**
     * <pre>
     * 将长度为4的8位byte数组转换为32位int.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static int byte4ToInt(byte[] arr) {
        if (arr == null || arr.length != 4) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是4位!");
        }
        return (int) (((arr[0] & 0xFF) << 24) | ((arr[1] & 0xFF) << 16) | ((arr[2] & 0xFF) << 8) | ((arr[3] & 0xFF)));
    }

    //arr 大字节在前 Big endion
    public static int byte2ToInt(byte[] arr) {
        if (arr == null || arr.length != 2) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是2位!");
        }
        return (int) (((arr[0] & 0xFF) << 8) | ((arr[1] & 0xFF)));
    }

    /**
     * <pre>
     * 将长度为8的8位byte数组转换为64位long.
     * </pre>
     * <p>
     * 0xFF对应16进制,f代表1111,0xFF刚好是8位 byte[]
     * arr,byte[i]&0xFF刚好满足一位byte计算,不会导致数据丢失. 如果是int计算. int[] arr,arr[i]&0xFFFF
     *
     * @param arr
     * @return
     */
    public static long byte8ToLong(byte[] arr) {
        if (arr == null || arr.length != 8) {
            throw new IllegalArgumentException("byte数组必须不为空,并且是8位!");
        }
        return (long) (((long) (arr[0] & 0xFF) << 56) | ((long) (arr[1] & 0xFF) << 48) | ((long) (arr[2] & 0xFF) << 40)
                | ((long) (arr[3] & 0xFF) << 32) | ((long) (arr[4] & 0xFF) << 24)
                | ((long) (arr[5] & 0xFF) << 16) | ((long) (arr[6] & 0xFF) << 8) | ((long) (arr[7] & 0xFF)));
    }

    /**
     * 将一个long数字转换为8个byte数组组成的数组.
     */
    public static byte[] longToByte8(long sum) {
        byte[] arr = new byte[8];
        arr[0] = (byte) (sum >> 56);
        arr[1] = (byte) (sum >> 48);
        arr[2] = (byte) (sum >> 40);
        arr[3] = (byte) (sum >> 32);
        arr[4] = (byte) (sum >> 24);
        arr[5] = (byte) (sum >> 16);
        arr[6] = (byte) (sum >> 8);
        arr[7] = (byte) (sum & 0xFF);
        return arr;
    }


    /**
     * <pre>
     * 将长度为32的byte数组转换为一个int类型值.
     * 每一个8位byte都只存储了0或1的数字.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static int byte32ToInt(byte[] arr) {
        if (arr == null || arr.length != 32) {
            throw new IllegalArgumentException("byte数组必须不为空,并且长度是32!");
        }
        int sum = 0;
        for (int i = 0; i < 32; ++i) {
            sum |= (arr[i] << (31 - i));
        }
        return sum;
    }

    /**
     * <pre>
     * 将长度为64的byte数组转换为一个long类型值.
     * 每一个8位byte都只存储了0或1的数字.
     * </pre>
     *
     * @param arr
     * @return
     */
    public static long byte64ToLong(byte[] arr) {
        if (arr == null || arr.length != 64) {
            throw new IllegalArgumentException("byte数组必须不为空,并且长度是64!");
        }
        long sum = 0L;
        for (int i = 0; i < 64; ++i) {
            sum |= ((long) arr[i] << (63 - i));
        }
        return sum;
    }

    /**
     * <pre>
     * 将一个long值转换为长度为64的8位byte数组.
     * 每一个8位byte都只存储了0或1的数字.
     * </pre>
     *
     * @param sum
     * @return
     */
    public static byte[] longToByte64(long sum) {
        byte[] arr = new byte[64];
        for (int i = 63; i >= 0; i--) {
            arr[i] = (byte) (sum & 1);
            sum >>= 1;
        }
        return arr;
    }


    /**
     * Convert byte[] to hex string.这里我们可以将byte转换成int，
     * 然后利用Integer.toHexString(int)来转换成16进制字符串。
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexString(byte[] bytes, int startIndexInclude, int endIndexExclude) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            if (i >= startIndexInclude && i < endIndexExclude) {
                sb.append(byteToHexString(bytes[i]));
            }
        }
        return sb.toString().toUpperCase();
    }

    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(byteToHexString(bytes[i]));
        }
        return stringBuilder.toString().toUpperCase();
    }


    /**
     * Convert byte to hex string
     *
     * @param bte
     * @return
     */
    public static String byteToHexString(byte bte) {
        StringBuilder stringBuilder = new StringBuilder("");
        int v = bte & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
        return stringBuilder.toString().toUpperCase();
    }


    /**
     * Convert hex string to byte[]
     *
     * @param hex the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hex) {
        if (hex == null || hex.equals("")) {
            return null;
        }
        hex = hex.toUpperCase();
        int length = hex.length() / 2;
        char[] hexChars = hex.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }


    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }


    public static byte[] subArray(byte[] bytes, int startIndexInclude, int length) {
        byte[] r = new byte[length];
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (i >= startIndexInclude && index < length) {
                r[index++] = bytes[i];
            }
        }
        return r;
    }


}
