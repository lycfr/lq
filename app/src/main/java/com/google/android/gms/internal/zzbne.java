package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

final class zzbne implements DriveFolder.DriveFolderResult {
    private final Status mStatus;
    private final DriveFolder zzaOx;

    public zzbne(Status status, DriveFolder driveFolder) {
        this.mStatus = status;
        this.zzaOx = driveFolder;
    }

    public final DriveFolder getDriveFolder() {
        return this.zzaOx;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
