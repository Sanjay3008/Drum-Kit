package com.android.activity;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.android.bbksoundrecorder.R;
import com.android.common.utils.C1413m;
import com.vivo.common.BbkTitleView;
import com.vivo.easytransfer.C1882a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import p050c.p051a.p058e.p059a.C0938a;

public class ServicePrivacyNoteActivity extends Activity {

    /* renamed from: a */
    private BbkTitleView f5367a;

    /* renamed from: b */
    private FrameLayout f5368b = null;

    /* renamed from: c */
    private WebView f5369c = null;

    /* renamed from: d */
    private String f5370d = C1882a.f6747d;

    /* renamed from: e */
    private View.OnClickListener f5371e = new C1259Ja(this);

    /* renamed from: a */
    private void m6573a() {
        this.f5370d = "file:///android_asset/service_privacy_note_zh.html";
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        String language = locale.getLanguage();
        if (!TextUtils.equals(country, "CN")) {
            String str = "user_instructions_" + country.toLowerCase() + ".html";
            try {
                InputStream open = getAssets().open(str);
                if (open != null) {
                    this.f5370d = "file:///android_asset/" + str;
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            } finally {
                this.f5370d = "file:///android_asset/service_privacy_note_EN.html";
            }
        } else if (TextUtils.equals(language, "bo")) {
            this.f5370d = "file:///android_asset/service_privacy_note_cn_bo.html";
        } else if (TextUtils.equals(language, "ug")) {
            this.f5370d = "file:///android_asset/service_privacy_note_cn_ug.html";
        }
    }

    /* renamed from: b */
    private void m6574b() {
        this.f5367a = findViewById(R.id.service_and_privacy_note_bbktitleview);
        this.f5367a.setVisibility(0);
        this.f5367a.showLeftButton();
        this.f5367a.setLeftButtonIcon(BbkTitleView.TITLE_BTN_BACK);
        this.f5367a.setCenterText(getString(R.string.rtot_service_and_privacy_note));
        this.f5367a.showLeftButton();
        this.f5367a.setLeftButtonClickListener(this.f5371e);
        if (C1413m.m6844f()) {
            m6577e();
            this.f5367a.setLeftButtonIcon(R.drawable.iqoo_details_backup);
            this.f5367a.setLeftButtonIcon(R.drawable.iqoo_details_backup);
        }
    }

    /* renamed from: c */
    private void m6575c() {
        this.f5368b = (FrameLayout) findViewById(R.id.service_privacy_note_webview);
        this.f5369c = (WebView) findViewById(R.id.service_privacy_webview_instruction);
        m6573a();
    }

    /* renamed from: d */
    private void m6576d() {
        C0938a.m5002a("SR/ServicePrivacyNoteActivity", "html path" + this.f5370d);
        this.f5369c.loadUrl(this.f5370d);
    }

    /* renamed from: e */
    private void m6577e() {
        getWindow().setStatusBarColor(C1413m.f5721s);
        getWindow().setNavigationBarColor(C1413m.f5721s);
    }

    /* renamed from: f */
    private void m6578f() {
        this.f5369c.getSettings().setAllowContentAccess(true);
        this.f5369c.getSettings().setJavaScriptEnabled(true);
        this.f5369c.setScrollbarFadingEnabled(true);
        this.f5369c.setScrollBarStyle(0);
        this.f5369c.setMapTrackballToArrowKeys(false);
        this.f5369c.setOverScrollMode(2);
        this.f5369c.getSettings().setBuiltInZoomControls(false);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f5369c.getSettings().setDefaultTextEncodingName("utf-8");
            this.f5369c.getSettings().setUseWideViewPort(false);
            this.f5369c.setInitialScale(100);
        }
        PackageManager packageManager = getPackageManager();
        this.f5369c.getSettings().setDisplayZoomControls(!(packageManager.hasSystemFeature("android.hardware.touchscreen.multitouch") || packageManager.hasSystemFeature("android.hardware.faketouch.multitouch.distinct")));
        this.f5369c.getSettings().setAllowFileAccess(true);
        this.f5369c.getSettings().setDefaultFontSize((int) getResources().getDimension(R.dimen.user_instruction_text_size));
        this.f5369c.setHorizontalScrollBarEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (C1413m.m6844f()) {
            setContentView(R.layout.iqoo_activity_service_privacy_note);
        } else {
            setContentView(R.layout.activity_service_privacy_note);
        }
        m6574b();
        m6575c();
        m6578f();
        m6576d();
    }
}
