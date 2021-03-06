package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

final class zzcuw {
    private final long zzaid;
    private final long zzbEO;
    private final long zzbEP;
    private String zzbEQ;
    private String zzbIi;
    private Map<String, String> zzbIj;
    private String zzbIk;

    zzcuw(long j, long j2, long j3) {
        this.zzbEO = j;
        this.zzaid = j2;
        this.zzbEP = j3;
    }

    /* access modifiers changed from: package-private */
    public final long zzBm() {
        return this.zzbEO;
    }

    /* access modifiers changed from: package-private */
    public final long zzBn() {
        return this.zzbEP;
    }

    /* access modifiers changed from: package-private */
    public final String zzBo() {
        return this.zzbEQ;
    }

    /* access modifiers changed from: package-private */
    public final String zzCo() {
        return this.zzbIi;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzCp() {
        return this.zzbIj;
    }

    /* access modifiers changed from: package-private */
    public final String zzCq() {
        return this.zzbIk;
    }

    /* access modifiers changed from: package-private */
    public final void zzfD(String str) {
        this.zzbIi = str;
    }

    /* access modifiers changed from: package-private */
    public final void zzfE(String str) {
        this.zzbIk = str;
    }

    /* access modifiers changed from: package-private */
    public final void zzfl(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzbEQ = str;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu(Map<String, String> map) {
        this.zzbIj = map;
    }
}
