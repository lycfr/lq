package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

/* compiled from: TXCFocusIndicatorView */
public class a extends View {
    private Paint a;
    private int b = 0;
    private int c = 2;
    private ScaleAnimation d;
    private Runnable e = new Runnable() {
        public void run() {
            a.this.setVisibility(8);
        }
    };

    public a(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    private void a(AttributeSet attributeSet, int i) {
        this.a = new Paint();
        this.c = (int) ((getContext().getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.d = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.d.setDuration(200);
    }

    public void a(int i, int i2, int i3) {
        removeCallbacks(this.e);
        this.d.cancel();
        this.b = i3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.width = this.b;
        layoutParams.height = this.b;
        setVisibility(0);
        requestLayout();
        this.d.reset();
        startAnimation(this.d);
        postDelayed(this.e, 1000);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.save();
        Rect rect = new Rect(0, 0, this.b, this.b);
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth((float) this.c);
        canvas.drawRect(rect, this.a);
        canvas.restore();
        super.onDraw(canvas);
    }
}
