package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgn implements zzgr {
    private /* synthetic */ Activity val$activity;

    zzgn(zzgj zzgj, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
