package com.android.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p050c.p051a.p058e.p059a.C0938a;

/* renamed from: com.android.activity.A */
class C1234A extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RecNotesActivity f5017a;

    C1234A(RecNotesActivity recNotesActivity) {
        this.f5017a = recNotesActivity;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C0938a.m5002a("SR/RecNotesActivity", "sAction = " + action);
        if (!"android.intent.action.MEDIA_MOUNTED".equals(action)) {
            this.f5017a.finish();
        }
    }
}
