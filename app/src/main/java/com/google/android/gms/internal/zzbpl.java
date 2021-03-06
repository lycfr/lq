package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.drive.zzv;

public final class zzbpl extends zzv {
    public static final Parcelable.Creator<zzbpl> CREATOR = new zzbpm();
    final boolean zzaNP;
    final DataHolder zzaPi;

    public zzbpl(DataHolder dataHolder, boolean z) {
        this.zzaPi = dataHolder;
        this.zzaNP = z;
    }

    /* access modifiers changed from: protected */
    public final void zzJ(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, (Parcelable) this.zzaPi, i, false);
        zzd.zza(parcel, 3, this.zzaNP);
        zzd.zzI(parcel, zze);
    }
}
