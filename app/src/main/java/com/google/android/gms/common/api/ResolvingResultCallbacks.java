package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzbo;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity mActivity;
    private final int zzaBk;

    protected ResolvingResultCallbacks(@NonNull Activity activity, int i) {
        this.mActivity = (Activity) zzbo.zzb(activity, (Object) "Activity must not be null");
        this.zzaBk = i;
    }

    @KeepForSdk
    public final void onFailure(@NonNull Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.mActivity, this.zzaBk);
            } catch (IntentSender.SendIntentException e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
            }
        } else {
            onUnresolvableFailure(status);
        }
    }

    public abstract void onSuccess(@NonNull R r);

    public abstract void onUnresolvableFailure(@NonNull Status status);
}
