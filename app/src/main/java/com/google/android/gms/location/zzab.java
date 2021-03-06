package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public final class zzab implements Parcelable.Creator<zzaa> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        String str = "";
        PendingIntent pendingIntent = null;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = zzb.zzC(parcel, readInt);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 3:
                    str = zzb.zzq(parcel, readInt);
                    break;
                default:
                    zzb.zzb(parcel, readInt);
                    break;
            }
        }
        zzb.zzF(parcel, zzd);
        return new zzaa(arrayList, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaa[i];
    }
}
