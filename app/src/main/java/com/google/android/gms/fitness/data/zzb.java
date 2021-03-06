package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbo;
import java.util.Arrays;

public final class zzb extends zza {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();
    public static final zzb zzaTj = new zzb("com.google.android.gms", (String) null, (String) null);
    private final String packageName;
    private final String version;
    private final int versionCode;
    private final String zzaTk;

    zzb(int i, String str, String str2, String str3) {
        this.versionCode = i;
        this.packageName = (String) zzbo.zzu(str);
        this.version = "";
        this.zzaTk = str3;
    }

    private zzb(String str, String str2, String str3) {
        this(1, str, "", (String) null);
    }

    public static zzb zzcX(String str) {
        return "com.google.android.gms".equals(str) ? zzaTj : new zzb(str, (String) null, (String) null);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!(this.packageName.equals(zzb.packageName) && zzbe.equal(this.version, zzb.version) && zzbe.equal(this.zzaTk, zzb.zzaTk))) {
                return false;
            }
        }
        return true;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.packageName, this.version, this.zzaTk});
    }

    public final String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.packageName, this.version, this.zzaTk});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, this.packageName, false);
        zzd.zza(parcel, 2, this.version, false);
        zzd.zza(parcel, 3, this.zzaTk, false);
        zzd.zzc(parcel, 1000, this.versionCode);
        zzd.zzI(parcel, zze);
    }
}
