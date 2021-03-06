package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.gcm.Task;

public class OneoffTask extends Task {
    public static final Parcelable.Creator<OneoffTask> CREATOR = new zzf();
    private final long zzbfV;
    private final long zzbfW;

    public static class Builder extends Task.Builder {
        /* access modifiers changed from: private */
        public long zzbfX = -1;
        /* access modifiers changed from: private */
        public long zzbfY = -1;

        public Builder() {
            this.isPersisted = false;
        }

        public OneoffTask build() {
            checkConditions();
            return new OneoffTask(this, (zzf) null);
        }

        /* access modifiers changed from: protected */
        public void checkConditions() {
            super.checkConditions();
            if (this.zzbfX == -1 || this.zzbfY == -1) {
                throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
            } else if (this.zzbfX >= this.zzbfY) {
                throw new IllegalArgumentException("Window start must be shorter than window end.");
            }
        }

        public Builder setExecutionWindow(long j, long j2) {
            this.zzbfX = j;
            this.zzbfY = j2;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setPersisted(boolean z) {
            this.isPersisted = z;
            return this;
        }

        public Builder setRequiredNetwork(int i) {
            this.requiredNetworkState = i;
            return this;
        }

        public Builder setRequiresCharging(boolean z) {
            this.requiresCharging = z;
            return this;
        }

        public Builder setService(Class<? extends GcmTaskService> cls) {
            this.gcmTaskService = cls.getName();
            return this;
        }

        public Builder setTag(String str) {
            this.tag = str;
            return this;
        }

        public Builder setUpdateCurrent(boolean z) {
            this.updateCurrent = z;
            return this;
        }
    }

    @Deprecated
    private OneoffTask(Parcel parcel) {
        super(parcel);
        this.zzbfV = parcel.readLong();
        this.zzbfW = parcel.readLong();
    }

    /* synthetic */ OneoffTask(Parcel parcel, zzf zzf) {
        this(parcel);
    }

    private OneoffTask(Builder builder) {
        super((Task.Builder) builder);
        this.zzbfV = builder.zzbfX;
        this.zzbfW = builder.zzbfY;
    }

    /* synthetic */ OneoffTask(Builder builder, zzf zzf) {
        this(builder);
    }

    public long getWindowEnd() {
        return this.zzbfW;
    }

    public long getWindowStart() {
        return this.zzbfV;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putLong("window_start", this.zzbfV);
        bundle.putLong("window_end", this.zzbfW);
    }

    public String toString() {
        String valueOf = String.valueOf(super.toString());
        long windowStart = getWindowStart();
        return new StringBuilder(String.valueOf(valueOf).length() + 64).append(valueOf).append(" windowStart=").append(windowStart).append(" windowEnd=").append(getWindowEnd()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.zzbfV);
        parcel.writeLong(this.zzbfW);
    }
}
