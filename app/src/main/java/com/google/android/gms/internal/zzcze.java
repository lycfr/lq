package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;

public final class zzcze extends zzcxq {
    /* access modifiers changed from: protected */
    public final dp<?> zza(zzcwa zzcwa, dp<?>... dpVarArr) {
        zzbo.zzaf(true);
        zzbo.zzaf(dpVarArr.length == 2);
        zzbo.zzaf(dpVarArr[0] instanceof eb);
        String value = dpVarArr[0].value();
        if (zzcwa.has(value)) {
            zzcwa.zzb(value, dpVarArr[1]);
            return dpVarArr[1];
        }
        String valueOf = String.valueOf(value);
        throw new IllegalStateException(valueOf.length() != 0 ? "Attempting to assign to undefined variable ".concat(valueOf) : new String("Attempting to assign to undefined variable "));
    }
}
