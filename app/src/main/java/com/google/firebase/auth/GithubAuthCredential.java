package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.lj;

public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzm();
    private String zzakv;

    GithubAuthCredential(@NonNull String str) {
        this.zzakv = zzbo.zzcF(str);
    }

    public static lj zza(@NonNull GithubAuthCredential githubAuthCredential) {
        zzbo.zzu(githubAuthCredential);
        return new lj((String) null, githubAuthCredential.zzakv, githubAuthCredential.getProvider(), (String) null, (String) null);
    }

    public String getProvider() {
        return GithubAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, this.zzakv, false);
        zzd.zzI(parcel, zze);
    }
}
