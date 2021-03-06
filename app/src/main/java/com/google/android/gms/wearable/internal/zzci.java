package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzci extends zza {
    public static final Parcelable.Creator<zzci> CREATOR = new zzcj();
    public final int statusCode;
    public final zzaa zzbSH;

    public zzci(int i, zzaa zzaa) {
        this.statusCode = i;
        this.zzbSH = zzaa;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 2, this.statusCode);
        zzd.zza(parcel, 3, (Parcelable) this.zzbSH, i, false);
        zzd.zzI(parcel, zze);
    }
}
