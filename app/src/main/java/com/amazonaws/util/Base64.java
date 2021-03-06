package com.amazonaws.util;

public enum Base64 {
    ;
    
    private static final Base64Codec codec = null;

    static {
        codec = new Base64Codec();
    }

    public static String encodeAsString(byte... bytes) {
        if (bytes == null) {
            return null;
        }
        return bytes.length == 0 ? "" : CodecUtils.toStringDirect(codec.encode(bytes));
    }

    public static byte[] encode(byte[] bytes) {
        return (bytes == null || bytes.length == 0) ? bytes : codec.encode(bytes);
    }

    public static byte[] decode(String b64) {
        if (b64 == null) {
            return null;
        }
        if (b64.length() == 0) {
            return new byte[0];
        }
        byte[] buf = new byte[b64.length()];
        return codec.decode(buf, CodecUtils.sanitize(b64, buf));
    }

    public static byte[] decode(byte[] b64) {
        return (b64 == null || b64.length == 0) ? b64 : codec.decode(b64, b64.length);
    }
}
