package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class db {
    private String zzaxs;
    private final List<dg> zzbKW;
    private final Map<String, dd> zzbKX;
    private int zzbKY = 0;

    public db(List<dg> list, Map<String, dd> map, String str, int i) {
        this.zzbKW = Collections.unmodifiableList(list);
        this.zzbKX = Collections.unmodifiableMap(map);
        this.zzaxs = str;
    }

    public final String getVersion() {
        return this.zzaxs;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzbKW);
        String valueOf2 = String.valueOf(this.zzbKX);
        return new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length()).append("Rules: ").append(valueOf).append("\n  Macros: ").append(valueOf2).toString();
    }

    public final List<dg> zzCX() {
        return this.zzbKW;
    }

    public final dd zzfV(String str) {
        return this.zzbKX.get(str);
    }
}
