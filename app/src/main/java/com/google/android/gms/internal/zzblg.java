package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.zzc;

public final class zzblg implements Parcelable.Creator<zzblf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzb.zzd(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        Integer num = null;
        zzc zzc = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    driveId = (DriveId) zzb.zza(parcel, readInt, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zzb.zza(parcel, readInt, MetadataBundle.CREATOR);
                    break;
                case 4:
                    zzc = (zzc) zzb.zza(parcel, readInt, zzc.CREATOR);
                    break;
                case 5:
                    num = zzb.zzh(parcel, readInt);
                    break;
                case 6:
                    z = zzb.zzc(parcel, readInt);
                    break;
                case 7:
                    str2 = zzb.zzq(parcel, readInt);
                    break;
                case 8:
                    i2 = zzb.zzg(parcel, readInt);
                    break;
                case 9:
                    i = zzb.zzg(parcel, readInt);
                    break;
                case 10:
                    str = zzb.zzq(parcel, readInt);
                    break;
                default:
                    zzb.zzb(parcel, readInt);
                    break;
            }
        }
        zzb.zzF(parcel, zzd);
        return new zzblf(driveId, metadataBundle, zzc, num, z, str2, i2, i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzblf[i];
    }
}
