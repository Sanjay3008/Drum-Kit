package com.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.android.bbksoundrecorder.R;
import com.android.common.utils.C1413m;
import com.vivo.common.BbkTitleView;
import p050c.p051a.p060f.C0992ba;

public class ServicePrivacyActivity extends Activity {

    /* renamed from: a */
    public BbkTitleView f5365a;

    /* renamed from: b */
    private View.OnClickListener f5366b = new C1257Ia(this);

    /* renamed from: a */
    private void m6572a() {
        getWindow().setStatusBarColor(C1413m.f5721s);
        getWindow().setNavigationBarColor(C1413m.f5721s);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (C1413m.m6844f()) {
            setContentView(R.layout.iqoo_activity_service_privacy);
        } else {
            setContentView(R.layout.activity_service_privacy);
        }
        this.f5365a = findViewById(R.id.ssetting_bbktitleview);
        this.f5365a.setVisibility(0);
        this.f5365a.showLeftButton();
        this.f5365a.setLeftButtonIcon(BbkTitleView.TITLE_BTN_BACK);
        this.f5365a.setCenterText(getString(R.string.rtot_service_and_privacy_policy));
        this.f5365a.showLeftButton();
        this.f5365a.setLeftButtonClickListener(this.f5366b);
        if (C1413m.m6844f()) {
            m6572a();
            this.f5365a.setLeftButtonIcon(R.drawable.iqoo_details_backup);
        }
        getFragmentManager().beginTransaction().replace(R.id.activity_service_privacy_container, new C0992ba()).commit();
    }
}
