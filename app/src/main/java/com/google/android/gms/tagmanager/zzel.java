package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbf;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbr;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzel extends zzbr {
    private static final String ID = zzbf.REGEX_GROUP.toString();
    private static final String zzbFP = zzbg.ARG0.toString();
    private static final String zzbFQ = zzbg.ARG1.toString();
    private static final String zzbFR = zzbg.IGNORE_CASE.toString();
    private static final String zzbFS = zzbg.GROUP.toString();

    public zzel() {
        super(ID, zzbFP, zzbFQ);
    }

    public final boolean zzAE() {
        return true;
    }

    public final zzbr zzo(Map<String, zzbr> map) {
        int i;
        zzbr zzbr = map.get(zzbFP);
        zzbr zzbr2 = map.get(zzbFQ);
        if (zzbr == null || zzbr == zzgk.zzCh() || zzbr2 == null || zzbr2 == zzgk.zzCh()) {
            return zzgk.zzCh();
        }
        int i2 = 64;
        if (zzgk.zzf(map.get(zzbFR)).booleanValue()) {
            i2 = 66;
        }
        zzbr zzbr3 = map.get(zzbFS);
        if (zzbr3 != null) {
            Long zzd = zzgk.zzd(zzbr3);
            if (zzd == zzgk.zzCc()) {
                return zzgk.zzCh();
            }
            i = zzd.intValue();
            if (i < 0) {
                return zzgk.zzCh();
            }
        } else {
            i = 1;
        }
        try {
            String zzb = zzgk.zzb(zzbr);
            String str = null;
            Matcher matcher = Pattern.compile(zzgk.zzb(zzbr2), i2).matcher(zzb);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? zzgk.zzCh() : zzgk.zzI(str);
        } catch (PatternSyntaxException e) {
            return zzgk.zzCh();
        }
    }
}
