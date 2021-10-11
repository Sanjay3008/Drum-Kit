package com.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.bbksoundrecorder.R;
import com.android.common.utils.C1387D;
import com.android.common.utils.C1411k;
import com.android.common.utils.C1413m;
import com.android.common.utils.C1419r;
import com.vivo.common.BbkTitleView;
import p050c.p051a.p058e.p059a.C0938a;
import p050c.p051a.p064h.C1026c;

public class SettingActivity extends Activity implements View.OnClickListener {

    /* renamed from: a */
    private RelativeLayout f5372a;

    /* renamed from: b */
    private RelativeLayout f5373b;

    /* renamed from: c */
    private TextView f5374c;

    /* renamed from: d */
    private ImageView f5375d;

    /* renamed from: e */
    private ImageView f5376e;

    /* renamed from: f */
    public BbkTitleView f5377f;

    /* renamed from: g */
    private View.OnClickListener f5378g = new C1261Ka(this);

    /* renamed from: a */
    private void m6579a() {
        String d = C1387D.m6769d(getApplicationContext());
        this.f5374c.setText("V" + d);
        if (!C1387D.m6766b(this)) {
        }
    }

    /* renamed from: b */
    private void m6580b() {
        this.f5377f = findViewById(R.id.setting_bbktitleview);
        this.f5377f.setVisibility(0);
        if (Build.VERSION.SDK_INT > 23) {
            this.f5377f.showDivider(true);
        }
        if (C1413m.m6846h()) {
            this.f5377f.showDivider(false);
        }
        this.f5377f.showLeftButton();
        this.f5377f.setLeftButtonIcon(R.drawable.btn_titleview_back_selector);
        this.f5377f.setLeftButtonClickListener(this.f5378g);
        this.f5377f.setCenterText(getResources().getString(R.string.permission_dialog_button_settings));
    }

    /* renamed from: c */
    private void m6581c() {
        this.f5374c = (TextView) findViewById(R.id.version_update_version_name);
        this.f5375d = (ImageView) findViewById(R.id.version_update_red_dot);
        this.f5372a = (RelativeLayout) findViewById(R.id.version_update_layout);
        this.f5373b = (RelativeLayout) findViewById(R.id.service_and_privacy);
        this.f5376e = (ImageView) findViewById(R.id.arrow);
        this.f5373b.setVisibility(8);
        this.f5372a.setOnClickListener(this);
        this.f5373b.setOnClickListener(this);
        m6582d();
    }

    /* renamed from: d */
    private void m6582d() {
        ImageView imageView;
        if (C1411k.m6827i() && (imageView = this.f5376e) != null) {
            imageView.setRotation(180.0f);
        }
    }

    /* renamed from: e */
    private void m6583e() {
        setContentView(R.layout.recorder_setting);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.service_and_privacy) {
            startActivity(new Intent(this, ServicePrivacyActivity.class));
        } else if (id == R.id.version_update_layout) {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        m6583e();
        m6580b();
        m6581c();
        m6579a();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        C0938a.m5002a("SettingActivity", "onRequestPermissionsResult()  ");
        if (i == 1001 && iArr.length > 0) {
            boolean z = false;
            if (iArr[0] == 0) {
                z = true;
            }
            if (z && C1419r.m6858a(getApplicationContext()) == C1419r.C1420a.WIFI) {
                C0938a.m5002a("SettingActivity", " onRequestPermissionsResult() , CHECK_UPDATE_USER  ");
                C1026c.m5447a(this, 2);
            }
        }
    }
}
