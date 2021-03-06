package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.safeparcel.zze;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.internal.zzbue;
import com.tencent.component.net.download.multiplex.http.Apn;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint extends zza implements ReflectedParcelable {
    public static final Parcelable.Creator<DataPoint> CREATOR = new zzh();
    private final int versionCode;
    private long zzaTA;
    private final DataSource zzaTa;
    private long zzaTv;
    private long zzaTw;
    private final Value[] zzaTx;
    private DataSource zzaTy;
    private long zzaTz;

    DataPoint(int i, DataSource dataSource, long j, long j2, Value[] valueArr, DataSource dataSource2, long j3, long j4) {
        this.versionCode = i;
        this.zzaTa = dataSource;
        this.zzaTy = dataSource2;
        this.zzaTv = j;
        this.zzaTw = j2;
        this.zzaTx = valueArr;
        this.zzaTz = j3;
        this.zzaTA = j4;
    }

    private DataPoint(DataSource dataSource) {
        this.versionCode = 4;
        this.zzaTa = (DataSource) zzbo.zzb(dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzaTx = new Value[fields.size()];
        int i = 0;
        Iterator<Field> it = fields.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                this.zzaTx[i2] = new Value(it.next().getFormat());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private DataPoint(DataSource dataSource, DataSource dataSource2, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzaUW), 0), zza(Long.valueOf(rawDataPoint.zzaUX), 0), rawDataPoint.zzaUY, dataSource2, zza(Long.valueOf(rawDataPoint.zzaVb), 0), zza(Long.valueOf(rawDataPoint.zzaVc), 0));
    }

    DataPoint(List<DataSource> list, RawDataPoint rawDataPoint) {
        this(zzc(list, rawDataPoint.zzaUZ), zzc(list, rawDataPoint.zzaVa), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataPoint) zze.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    private final void zzaU(int i) {
        List<Field> fields = getDataType().getFields();
        int size = fields.size();
        zzbo.zzb(i == size, "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(size), fields);
    }

    private static DataSource zzc(List<DataSource> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof DataPoint)) {
                return false;
            }
            DataPoint dataPoint = (DataPoint) obj;
            if (!(zzbe.equal(this.zzaTa, dataPoint.zzaTa) && this.zzaTv == dataPoint.zzaTv && this.zzaTw == dataPoint.zzaTw && Arrays.equals(this.zzaTx, dataPoint.zzaTx) && zzbe.equal(getOriginalDataSource(), dataPoint.getOriginalDataSource()))) {
                return false;
            }
        }
        return true;
    }

    public final DataSource getDataSource() {
        return this.zzaTa;
    }

    public final DataType getDataType() {
        return this.zzaTa.getDataType();
    }

    public final long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaTv, TimeUnit.NANOSECONDS);
    }

    public final DataSource getOriginalDataSource() {
        return this.zzaTy != null ? this.zzaTy : this.zzaTa;
    }

    public final long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaTw, TimeUnit.NANOSECONDS);
    }

    public final long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaTv, TimeUnit.NANOSECONDS);
    }

    public final Value getValue(Field field) {
        return this.zzaTx[getDataType().indexOf(field)];
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzaTa, Long.valueOf(this.zzaTv), Long.valueOf(this.zzaTw)});
    }

    public final DataPoint setFloatValues(float... fArr) {
        zzaU(fArr.length);
        for (int i = 0; i < fArr.length; i++) {
            this.zzaTx[i].setFloat(fArr[i]);
        }
        return this;
    }

    public final DataPoint setIntValues(int... iArr) {
        zzaU(iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            this.zzaTx[i].setInt(iArr[i]);
        }
        return this;
    }

    public final DataPoint setTimeInterval(long j, long j2, TimeUnit timeUnit) {
        this.zzaTw = timeUnit.toNanos(j);
        this.zzaTv = timeUnit.toNanos(j2);
        return this;
    }

    public final DataPoint setTimestamp(long j, TimeUnit timeUnit) {
        this.zzaTv = timeUnit.toNanos(j);
        if ((getDataType() == DataType.TYPE_LOCATION_SAMPLE) && zzbue.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzaTv = zzbue.zza(this.zzaTv, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final String toString() {
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzaTx);
        objArr[1] = Long.valueOf(this.zzaTw);
        objArr[2] = Long.valueOf(this.zzaTv);
        objArr[3] = Long.valueOf(this.zzaTz);
        objArr[4] = Long.valueOf(this.zzaTA);
        objArr[5] = this.zzaTa.toDebugString();
        objArr[6] = this.zzaTy != null ? this.zzaTy.toDebugString() : Apn.APN_UNKNOWN;
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzd.zze(parcel);
        zzd.zza(parcel, 1, (Parcelable) getDataSource(), i, false);
        zzd.zza(parcel, 3, this.zzaTv);
        zzd.zza(parcel, 4, this.zzaTw);
        zzd.zza(parcel, 5, (T[]) this.zzaTx, i, false);
        zzd.zza(parcel, 6, (Parcelable) this.zzaTy, i, false);
        zzd.zza(parcel, 7, this.zzaTz);
        zzd.zzc(parcel, 1000, this.versionCode);
        zzd.zza(parcel, 8, this.zzaTA);
        zzd.zzI(parcel, zze);
    }

    public final Value zzaT(int i) {
        DataType dataType = getDataType();
        if (i >= 0 && i < dataType.getFields().size()) {
            return this.zzaTx[i];
        }
        throw new IllegalArgumentException(String.format("fieldIndex %s is out of range for %s", new Object[]{Integer.valueOf(i), dataType}));
    }

    public final Value[] zztG() {
        return this.zzaTx;
    }

    public final DataSource zztH() {
        return this.zzaTy;
    }

    public final long zztI() {
        return this.zzaTz;
    }

    public final long zztJ() {
        return this.zzaTA;
    }

    public final void zztK() {
        zzbo.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzbo.zzb(this.zzaTv > 0, "Data point does not have the timestamp set: %s", this);
        zzbo.zzb(this.zzaTw <= this.zzaTv, "Data point with start time greater than end time found: %s", this);
    }
}
