package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;

public enum CameraEffectFeature implements DialogFeature {
    SHARE_CAMERA_EFFECT(NativeProtocol.PROTOCOL_VERSION_20170417);
    
    private int minVersion;

    private CameraEffectFeature(int minVersion2) {
        this.minVersion = minVersion2;
    }

    public String getAction() {
        return NativeProtocol.ACTION_CAMERA_EFFECT;
    }

    public int getMinVersion() {
        return this.minVersion;
    }
}
