package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzbps extends zza {
    public static final Parcelable.Creator<zzbps> CREATOR = new zzbpt();
    private zzbqg zzaPk;

    zzbps(zzbqg zzbqg) {
        this.zzaPk = zzbqg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, (Parcelable) this.zzaPk, i, false);
        zzd.zzI(parcel, zze);
    }
}
