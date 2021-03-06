package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;

public final class zzl extends zza {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    private String mValue;

    public zzl(String str) {
        this.mValue = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, this.mValue, false);
        zzd.zzI(parcel, zze);
    }

    public final <F> F zza(zzj<F> zzj) {
        return zzj.zzcU(this.mValue);
    }
}
