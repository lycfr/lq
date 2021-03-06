package com.google.android.gms.internal;

import android.os.Build;
import android.os.ConditionVariable;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzcn {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzpK = new ConditionVariable();
    protected static volatile zzazn zzpL = null;
    private static volatile Random zzpN = null;
    /* access modifiers changed from: private */
    public zzdb zzpJ;
    protected volatile Boolean zzpM;

    public zzcn(zzdb zzdb) {
        this.zzpJ = zzdb;
        zzdb.zzC().execute(new zzco(this));
    }

    public static int zzy() {
        try {
            return Build.VERSION.SDK_INT >= 21 ? ThreadLocalRandom.current().nextInt() : zzz().nextInt();
        } catch (RuntimeException e) {
            return zzz().nextInt();
        }
    }

    private static Random zzz() {
        if (zzpN == null) {
            synchronized (zzcn.class) {
                if (zzpN == null) {
                    zzpN = new Random();
                }
            }
        }
        return zzpN;
    }

    public final void zza(int i, int i2, long j) throws IOException {
        try {
            zzpK.block();
            if (this.zzpM.booleanValue() && zzpL != null && this.zzpJ.zzqT) {
                zzat zzat = new zzat();
                zzat.zzaH = this.zzpJ.zzqD.getPackageName();
                zzat.zzaI = Long.valueOf(j);
                zzazp zze = zzpL.zze(adp.zzc(zzat));
                zze.zzaj(i2);
                zze.zzai(i);
                this.zzpJ.zzG();
                zze.zzoT();
            }
        } catch (Exception e) {
        }
    }
}
