package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.panorama.PanoramaApi;

public final class zzcqe implements PanoramaApi {
    /* access modifiers changed from: private */
    public static void zza(Context context, zzcqc zzcqc, zzcqa zzcqa, Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzcqc.zza(new zzcqh(context, uri, zzcqa), uri, (Bundle) null, true);
        } catch (RemoteException e) {
            context.revokeUriPermission(uri, 1);
            throw e;
        } catch (RuntimeException e2) {
            context.revokeUriPermission(uri, 1);
            throw e2;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    public final PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.zzd(new zzcqf(this, googleApiClient, uri));
    }

    public final PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, Uri uri) {
        return googleApiClient.zzd(new zzcqg(this, googleApiClient, uri));
    }
}
