package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.nearby.connection.Connections;

@Deprecated
final class zzclc extends zzcmq {
    private final zzbdw<Connections.MessageListener> zzbwU;

    zzclc(zzbdw<Connections.MessageListener> zzbdw) {
        this.zzbwU = (zzbdw) zzbo.zzu(zzbdw);
    }

    public final void zza(zzcnw zzcnw) {
        this.zzbwU.zza(new zzcle(this, zzcnw));
    }

    public final void zza(zzcoc zzcoc) {
        this.zzbwU.zza(new zzcld(this, zzcoc));
    }

    public final void zza(zzcoe zzcoe) {
    }
}
