package com.google.android.gms.internal;

import com.amazonaws.services.s3.internal.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public final class yr {
    private static void zza(Object obj, JSONStringer jSONStringer) throws IOException, JSONException {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                zza(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
        } else if (obj instanceof Collection) {
            jSONStringer.array();
            for (Object zza : (Collection) obj) {
                zza(zza, jSONStringer);
            }
            jSONStringer.endArray();
        } else {
            jSONStringer.value(obj);
        }
    }

    public static String zzak(Object obj) throws IOException {
        if (obj == null) {
            return Constants.NULL_VERSION_ID;
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (JSONException e) {
                throw new IOException("Could not serialize number", e);
            }
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        } else {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                zza(obj, jSONStringer);
                return jSONStringer.toString();
            } catch (JSONException e2) {
                throw new IOException("Failed to serialize JSON", e2);
            }
        }
    }

    private static Object zzal(Object obj) throws JSONException {
        if (obj instanceof JSONObject) {
            return zzs((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(zzal(jSONArray.get(i)));
            }
            return arrayList;
        } else if (obj.equals(JSONObject.NULL)) {
            return null;
        } else {
            return obj;
        }
    }

    public static Map<String, Object> zzgV(String str) throws IOException {
        try {
            return zzs(new JSONObject(str));
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    public static Object zzgW(String str) throws IOException {
        try {
            return zzal(new JSONTokener(str).nextValue());
        } catch (JSONException e) {
            throw new IOException(e);
        }
    }

    private static Map<String, Object> zzs(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, zzal(jSONObject.get(next)));
        }
        return hashMap;
    }
}
