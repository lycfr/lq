package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class zzbsb implements Parcelable.Creator<zzbsa> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        while (parcel.dataPosition() < zzd) {
            zzb.zzb(parcel, parcel.readInt());
        }
        zzb.zzF(parcel, zzd);
        return new zzbsa();
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbsa[i];
    }
}
