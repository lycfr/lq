package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbo;
import com.tencent.imsdk.framework.request.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    private Map<String, String> zzafu = new HashMap();

    public ProductAction(String str) {
        put("&pa", str);
    }

    private final void put(String str, String str2) {
        zzbo.zzb(str, (Object) "Name should be non-null");
        this.zzafu.put(str, str2);
    }

    public final Map<String, String> build() {
        return new HashMap(this.zzafu);
    }

    public ProductAction setCheckoutOptions(String str) {
        put("&col", str);
        return this;
    }

    public ProductAction setCheckoutStep(int i) {
        put("&cos", Integer.toString(i));
        return this;
    }

    public ProductAction setProductActionList(String str) {
        put("&pal", str);
        return this;
    }

    public ProductAction setProductListSource(String str) {
        put("&pls", str);
        return this;
    }

    public ProductAction setTransactionAffiliation(String str) {
        put("&ta", str);
        return this;
    }

    public ProductAction setTransactionCouponCode(String str) {
        put("&tcc", str);
        return this;
    }

    public ProductAction setTransactionId(String str) {
        put("&ti", str);
        return this;
    }

    public ProductAction setTransactionRevenue(double d) {
        put("&tr", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionShipping(double d) {
        put("&ts", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionTax(double d) {
        put("&tt", Double.toString(d));
        return this;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.zzafu.entrySet()) {
            if (((String) next.getKey()).startsWith(HttpRequest.HTTP_REQ_ENTITY_JOIN)) {
                hashMap.put(((String) next.getKey()).substring(1), (String) next.getValue());
            } else {
                hashMap.put((String) next.getKey(), (String) next.getValue());
            }
        }
        return zzj.zzk(hashMap);
    }
}
