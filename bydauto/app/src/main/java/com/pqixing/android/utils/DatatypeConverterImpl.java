package com.pqixing.android.utils;


public final class DatatypeConverterImpl {

    public static String printBase64Binary(byte[] val) {
        return _printBase64Binary(val);
    }

    public static String _printBase64Binary(byte[] input) {
        return _printBase64Binary(input, 0, input.length);
    }

    public static String _printBase64Binary(byte[] input, int offset, int len) {
        char[] buf = new char[(len + 2) / 3 * 4];
        int ptr = _printBase64Binary(input, offset, len, (char[]) buf, 0);

        assert ptr == buf.length;

        return new String(buf);
    }

    public static int _printBase64Binary(byte[] input, int offset, int len, char[] buf, int ptr) {
        int remaining = len;

        int i;
        for (i = offset; remaining >= 3; i += 3) {
            buf[ptr++] = encode(input[i] >> 2);
            buf[ptr++] = encode((input[i] & 3) << 4 | input[i + 1] >> 4 & 15);
            buf[ptr++] = encode((input[i + 1] & 15) << 2 | input[i + 2] >> 6 & 3);
            buf[ptr++] = encode(input[i + 2] & 63);
            remaining -= 3;
        }

        if (remaining == 1) {
            buf[ptr++] = encode(input[i] >> 2);
            buf[ptr++] = encode((input[i] & 3) << 4);
            buf[ptr++] = '=';
            buf[ptr++] = '=';
        }

        if (remaining == 2) {
            buf[ptr++] = encode(input[i] >> 2);
            buf[ptr++] = encode((input[i] & 3) << 4 | input[i + 1] >> 4 & 15);
            buf[ptr++] = encode((input[i + 1] & 15) << 2);
            buf[ptr++] = '=';
        }

        return ptr;
    }

    private static final char[] encodeMap = initEncodeMap();

    private static char[] initEncodeMap() {
        char[] map = new char[64];

        int i;
        for (i = 0; i < 26; ++i) {
            map[i] = (char) (65 + i);
        }

        for (i = 26; i < 52; ++i) {
            map[i] = (char) (97 + (i - 26));
        }

        for (i = 52; i < 62; ++i) {
            map[i] = (char) (48 + (i - 52));
        }

        map[62] = '+';
        map[63] = '/';
        return map;
    }

    public static char encode(int i) {
        return encodeMap[i & 63];
    }
}