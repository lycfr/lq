package com.google.android.gms.common.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzab implements zzg {
    private /* synthetic */ GoogleApiClient.OnConnectionFailedListener zzaHD;

    zzab(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzaHD = onConnectionFailedListener;
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzaHD.onConnectionFailed(connectionResult);
    }
}
