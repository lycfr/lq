package com.google.android.gms.internal;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

final class ya extends ThreadLocal<CharsetDecoder> {
    ya() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(CodingErrorAction.REPORT);
        newDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        return newDecoder;
    }
}
