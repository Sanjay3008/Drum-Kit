package com.android.activity;

import android.content.DialogInterface;
import com.android.common.utils.C1413m;

/* renamed from: com.android.activity.U */
class C1295U implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int[] f5503a;

    /* renamed from: b */
    final /* synthetic */ String[] f5504b;

    /* renamed from: c */
    final /* synthetic */ RecNotesActivity f5505c;

    C1295U(RecNotesActivity recNotesActivity, int[] iArr, String[] strArr) {
        this.f5505c = recNotesActivity;
        this.f5503a = iArr;
        this.f5504b = strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C1413m.f5709g = 1;
        this.f5505c.m6300a(this.f5503a, this.f5504b);
    }
}
