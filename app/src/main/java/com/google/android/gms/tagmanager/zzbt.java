package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbf;
import com.google.android.gms.internal.zzbr;
import java.util.Map;

final class zzbt extends zzdz {
    private static final String ID = zzbf.GREATER_EQUALS.toString();

    public zzbt() {
        super(ID);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzgj zzgj, zzgj zzgj2, Map<String, zzbr> map) {
        return zzgj.compareTo(zzgj2) >= 0;
    }
}
