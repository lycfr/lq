package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

final class zzavz implements View.OnClickListener {
    private /* synthetic */ zzavy zzavz;

    zzavz(zzavy zzavy) {
        this.zzavz = zzavy;
    }

    public final void onClick(View view) {
        Activity activity = (Activity) this.zzavz.zzavm.get();
        if (activity != null) {
            Intent intent = new Intent();
            intent.setComponent(this.zzavz.zzavy);
            activity.startActivity(intent);
        }
    }
}
