package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;

final class zzs extends zzn<CapabilityApi.RemoveLocalCapabilityResult> {
    private /* synthetic */ String zzbRV;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzo zzo, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzbRV = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Api.zzb zzb) throws RemoteException {
        ((zzdn) ((zzfw) zzb).zzrf()).zzb(new zzft(this), this.zzbRV);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result zzb(Status status) {
        return new zzu(status);
    }
}
