package com.google.android.gms.internal;

import android.content.SharedPreferences;
import org.json.JSONObject;

final class zzmh extends zzme<Long> {
    zzmh(int i, String str, Long l) {
        super(i, str, l, (zzmf) null);
    }

    public final /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdI()).longValue()));
    }

    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(getKey(), ((Long) obj).longValue());
    }

    public final /* synthetic */ Object zzb(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), ((Long) zzdI()).longValue()));
    }
}
