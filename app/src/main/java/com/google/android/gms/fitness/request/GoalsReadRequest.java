package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzbuf;
import com.google.android.gms.internal.zzbwe;
import com.google.android.gms.internal.zzbwf;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoalsReadRequest extends zza {
    public static final Parcelable.Creator<GoalsReadRequest> CREATOR = new zzac();
    private final int versionCode;
    private final List<Integer> zzaUJ;
    private final zzbwe zzaWN;
    private final List<DataType> zzaWO;
    private final List<Integer> zzaWP;

    public static class Builder {
        /* access modifiers changed from: private */
        public final List<Integer> zzaUJ = new ArrayList();
        /* access modifiers changed from: private */
        public final List<DataType> zzaWO = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Integer> zzaWP = new ArrayList();

        public Builder addActivity(String str) {
            int zzcW = com.google.android.gms.fitness.zza.zzcW(str);
            zzbo.zza(zzcW != 4, (Object) "Attempting to add an unknown activity");
            zzbuf.zza(Integer.valueOf(zzcW), this.zzaUJ);
            return this;
        }

        public Builder addDataType(DataType dataType) {
            zzbo.zzb(dataType, (Object) "Attempting to use a null data type");
            if (!this.zzaWO.contains(dataType)) {
                this.zzaWO.add(dataType);
            }
            return this;
        }

        public Builder addObjectiveType(int i) {
            boolean z = true;
            if (!(i == 1 || i == 2 || i == 3)) {
                z = false;
            }
            zzbo.zza(z, (Object) "Attempting to add an invalid objective type");
            if (!this.zzaWP.contains(Integer.valueOf(i))) {
                this.zzaWP.add(Integer.valueOf(i));
            }
            return this;
        }

        public GoalsReadRequest build() {
            zzbo.zza(!this.zzaWO.isEmpty(), (Object) "At least one data type should be specified.");
            return new GoalsReadRequest(this);
        }
    }

    GoalsReadRequest(int i, IBinder iBinder, List<DataType> list, List<Integer> list2, List<Integer> list3) {
        this.versionCode = i;
        this.zzaWN = iBinder == null ? null : zzbwf.zzS(iBinder);
        this.zzaWO = list;
        this.zzaWP = list2;
        this.zzaUJ = list3;
    }

    private GoalsReadRequest(Builder builder) {
        this((zzbwe) null, builder.zzaWO, builder.zzaWP, builder.zzaUJ);
    }

    public GoalsReadRequest(GoalsReadRequest goalsReadRequest, zzbwe zzbwe) {
        this(zzbwe, goalsReadRequest.getDataTypes(), goalsReadRequest.zzaWP, goalsReadRequest.zzaUJ);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private GoalsReadRequest(zzbwe zzbwe, List<DataType> list, List<Integer> list2, List<Integer> list3) {
        this(1, zzbwe == null ? null : zzbwe.asBinder(), list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof GoalsReadRequest)) {
                return false;
            }
            GoalsReadRequest goalsReadRequest = (GoalsReadRequest) obj;
            if (!(zzbe.equal(this.zzaWO, goalsReadRequest.zzaWO) && zzbe.equal(this.zzaWP, goalsReadRequest.zzaWP) && zzbe.equal(this.zzaUJ, goalsReadRequest.zzaUJ))) {
                return false;
            }
        }
        return true;
    }

    public List<String> getActivityNames() {
        if (this.zzaUJ.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.zzaUJ) {
            arrayList.add(com.google.android.gms.fitness.zza.getName(intValue.intValue()));
        }
        return arrayList;
    }

    public List<DataType> getDataTypes() {
        return this.zzaWO;
    }

    public List<Integer> getObjectiveTypes() {
        if (this.zzaWP.isEmpty()) {
            return null;
        }
        return this.zzaWP;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzaWO, this.zzaWP, getActivityNames()});
    }

    public String toString() {
        return zzbe.zzt(this).zzg("dataTypes", this.zzaWO).zzg("objectiveTypes", this.zzaWP).zzg(VKApiUserFull.ACTIVITIES, getActivityNames()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, this.zzaWN.asBinder(), false);
        zzd.zzd(parcel, 2, getDataTypes(), false);
        zzd.zzd(parcel, 3, this.zzaWP, false);
        zzd.zzd(parcel, 4, this.zzaUJ, false);
        zzd.zzc(parcel, 1000, this.versionCode);
        zzd.zzI(parcel, zze);
    }
}
