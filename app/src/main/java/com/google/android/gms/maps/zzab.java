package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzaq;

final class zzab extends zzaq {
    private /* synthetic */ OnMapReadyCallback zzbmr;

    zzab(MapView.zza zza, OnMapReadyCallback onMapReadyCallback) {
        this.zzbmr = onMapReadyCallback;
    }

    public final void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.zzbmr.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
