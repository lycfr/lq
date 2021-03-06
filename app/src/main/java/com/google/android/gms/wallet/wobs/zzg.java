package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzg extends zza {
    public static final Parcelable.Creator<zzg> CREATOR = new zzj();
    private String label;
    private String type;
    private zzm zzbPe;
    private zzh zzbQK;

    zzg() {
    }

    zzg(String str, zzh zzh, String str2, zzm zzm) {
        this.label = str;
        this.zzbQK = zzh;
        this.type = str2;
        this.zzbPe = zzm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, this.label, false);
        zzd.zza(parcel, 3, (Parcelable) this.zzbQK, i, false);
        zzd.zza(parcel, 4, this.type, false);
        zzd.zza(parcel, 5, (Parcelable) this.zzbPe, i, false);
        zzd.zzI(parcel, zze);
    }
}
