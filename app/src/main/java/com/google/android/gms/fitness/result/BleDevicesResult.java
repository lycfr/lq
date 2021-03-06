package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult extends zza implements Result {
    public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
    private final Status mStatus;
    private final List<BleDevice> zzaXt;
    private final int zzaku;

    BleDevicesResult(int i, List<BleDevice> list, Status status) {
        this.zzaku = i;
        this.zzaXt = Collections.unmodifiableList(list);
        this.mStatus = status;
    }

    private BleDevicesResult(List<BleDevice> list, Status status) {
        this.zzaku = 3;
        this.zzaXt = Collections.unmodifiableList(list);
        this.mStatus = status;
    }

    public static BleDevicesResult zzB(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof BleDevicesResult)) {
                return false;
            }
            BleDevicesResult bleDevicesResult = (BleDevicesResult) obj;
            if (!(this.mStatus.equals(bleDevicesResult.mStatus) && zzbe.equal(this.zzaXt, bleDevicesResult.zzaXt))) {
                return false;
            }
        }
        return true;
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzaXt;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (BleDevice next : this.zzaXt) {
            if (next.getDataTypes().contains(dataType)) {
                arrayList.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.mStatus, this.zzaXt});
    }

    public String toString() {
        return zzbe.zzt(this).zzg("status", this.mStatus).zzg("bleDevices", this.zzaXt).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, getClaimedBleDevices(), false);
        zzd.zza(parcel, 2, (Parcelable) getStatus(), i, false);
        zzd.zzc(parcel, 1000, this.zzaku);
        zzd.zzI(parcel, zze);
    }
}
