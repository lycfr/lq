package com.google.android.gms.games.internal;

import android.os.Binder;
import android.view.View;

public class zzn {
    protected GamesClientImpl zzbaK;
    protected zzp zzbaL;

    private zzn(GamesClientImpl gamesClientImpl, int i) {
        this.zzbaK = gamesClientImpl;
        zzbb(i);
    }

    /* access modifiers changed from: protected */
    public void zzbb(int i) {
        this.zzbaL = new zzp(i, new Binder());
    }

    public void zzt(View view) {
    }

    public void zzuV() {
        this.zzbaK.zza(this.zzbaL.zzbaM, this.zzbaL.zzuW());
    }
}
