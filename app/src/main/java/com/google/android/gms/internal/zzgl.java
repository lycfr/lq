package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;

final class zzgl implements zzgr {
    private /* synthetic */ Activity val$activity;

    zzgl(zzgj zzgj, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.val$activity);
    }
}
