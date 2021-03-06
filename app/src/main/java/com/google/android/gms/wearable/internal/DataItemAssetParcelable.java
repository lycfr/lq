package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.wearable.DataItemAsset;

@KeepName
public class DataItemAssetParcelable extends zza implements ReflectedParcelable, DataItemAsset {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzby();
    private final String zzBN;
    private final String zzIi;

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.zzIi = (String) zzbo.zzu(dataItemAsset.getId());
        this.zzBN = (String) zzbo.zzu(dataItemAsset.getDataItemKey());
    }

    DataItemAssetParcelable(String str, String str2) {
        this.zzIi = str;
        this.zzBN = str2;
    }

    public /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public String getDataItemKey() {
        return this.zzBN;
    }

    public String getId() {
        return this.zzIi;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataItemAssetParcelable[");
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzIi == null) {
            sb.append(",noid");
        } else {
            sb.append(",");
            sb.append(this.zzIi);
        }
        sb.append(", key=");
        sb.append(this.zzBN);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 2, getId(), false);
        zzd.zza(parcel, 3, getDataItemKey(), false);
        zzd.zzI(parcel, zze);
    }
}
