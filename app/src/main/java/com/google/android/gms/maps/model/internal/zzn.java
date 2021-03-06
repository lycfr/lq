package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzef;

public abstract class zzn extends zzee implements zzm {
    public static zzm zzae(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
        return queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzm zzo;
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String name = getName();
                parcel2.writeNoException();
                parcel2.writeString(name);
                break;
            case 2:
                String shortName = getShortName();
                parcel2.writeNoException();
                parcel2.writeString(shortName);
                break;
            case 3:
                activate();
                parcel2.writeNoException();
                break;
            case 4:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzo = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
                    zzo = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(readStrongBinder);
                }
                boolean zza = zza(zzo);
                parcel2.writeNoException();
                zzef.zza(parcel2, zza);
                break;
            case 5:
                int hashCodeRemote = hashCodeRemote();
                parcel2.writeNoException();
                parcel2.writeInt(hashCodeRemote);
                break;
            default:
                return false;
        }
        return true;
    }
}
