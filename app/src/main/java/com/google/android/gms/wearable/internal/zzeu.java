package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

final class zzeu implements ChannelApi.ChannelListener {
    private final String zzakv;
    private final ChannelApi.ChannelListener zzbTd;

    zzeu(String str, ChannelApi.ChannelListener channelListener) {
        this.zzakv = (String) zzbo.zzu(str);
        this.zzbTd = (ChannelApi.ChannelListener) zzbo.zzu(channelListener);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeu)) {
            return false;
        }
        zzeu zzeu = (zzeu) obj;
        return this.zzbTd.equals(zzeu.zzbTd) && this.zzakv.equals(zzeu.zzakv);
    }

    public final int hashCode() {
        return (this.zzakv.hashCode() * 31) + this.zzbTd.hashCode();
    }

    public final void onChannelClosed(Channel channel, int i, int i2) {
        this.zzbTd.onChannelClosed(channel, i, i2);
    }

    public final void onChannelOpened(Channel channel) {
        this.zzbTd.onChannelOpened(channel);
    }

    public final void onInputClosed(Channel channel, int i, int i2) {
        this.zzbTd.onInputClosed(channel, i, i2);
    }

    public final void onOutputClosed(Channel channel, int i, int i2) {
        this.zzbTd.onOutputClosed(channel, i, i2);
    }
}
