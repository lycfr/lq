package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcib implements Runnable {
    private /* synthetic */ zzchz zzbtQ;
    private /* synthetic */ zzcic zzbtR;

    zzcib(zzchz zzchz, zzcic zzcic) {
        this.zzbtQ = zzchz;
        this.zzbtR = zzcic;
    }

    public final void run() {
        this.zzbtQ.zza(this.zzbtR);
        this.zzbtQ.zzbtE = null;
        this.zzbtQ.zzww().zza((AppMeasurement.zzb) null);
    }
}
