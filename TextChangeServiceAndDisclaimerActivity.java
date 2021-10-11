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

public class TextChangeServiceAndDisclaimerActivity extends Activity {

    /* renamed from: a */
    private BbkTitleView f5498a;

    /* renamed from: b */
    private FrameLayout f5499b = null;

    /* renamed from: c */
    private WebView f5500c = null;

    /* renamed from: d */
    private String f5501d = C1882a.f6747d;

    /* renamed from: e */
    private View.OnClickListener f5502e = new C1364sb(this);

    /* renamed from: a */
    private void m6719a() {
        this.f5501d = "file:///android_asset/text_conversion_disclaimer_zh.html";
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        String language = locale.getLanguage();
        if (!TextUtils.equals(country, "CN")) {
            String str = "user_instructions_" + country.toLowerCase() + ".html";
            try {
                InputStream open = getAssets().open(str);
                if (open != null) {
                    this.f5501d = "file:///android_asset/" + str;
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            } finally {
                this.f5501d = "file:///android_asset/text_conversion_disclaimer_EN.html";
            }
        } else if (TextUtils.equals(language, "bo")) {
            this.f5501d = "file:///android_asset/text_conversion_disclaimer_cn_bo.html";
        } else if (TextUtils.equals(language, "ug")) {
            this.f5501d = "file:///android_asset/text_conversion_disclaimer_cn_ug.html";
        }
    }

    /* renamed from: b */
    private void m6720b() {
        this.f5498a = findViewById(R.id.service_and_disclaimer_bbktitleview);
        this.f5498a.setVisibility(0);
        this.f5498a.showLeftButton();
        this.f5498a.setLeftButtonIcon(BbkTitleView.TITLE_BTN_BACK);
        this.f5498a.setCenterText(getString(R.string.rtot_conversion_disclaimer));
        this.f5498a.showLeftButton();
        this.f5498a.setLeftButtonClickListener(this.f5502e);
        if (C1413m.m6844f()) {
            m6723e();
            this.f5498a.setLeftButtonIcon(R.drawable.iqoo_details_backup);
            this.f5498a.setLeftButtonIcon(R.drawable.iqoo_details_backup);
        }
    }

    /* renamed from: c */
    private void m6721c() {
        this.f5499b = (FrameLayout) findViewById(R.id.text_change_service_and_disclaimer_webview);
        this.f5500c = (WebView) findViewById(R.id.text_change_webview_instruction);
        m6719a();
    }

    /* renamed from: d */
    private void m6722d() {
        C0938a.m5002a("SR/TextChangeServiceAndDisclaimerActivity", "html path" + this.f5501d);
        this.f5500c.loadUrl(this.f5501d);
    }

    /* renamed from: e */
    private void m6723e() {
        getWindow().setStatusBarColor(C1413m.f5721s);
        getWindow().setNavigationBarColor(C1413m.f5721s);
    }

    /* renamed from: f */
    private void m6724f() {
        this.f5500c.getSettings().setAllowContentAccess(true);
        this.f5500c.getSettings().setJavaScriptEnabled(true);
        this.f5500c.setScrollbarFadingEnabled(true);
        this.f5500c.setScrollBarStyle(0);
        this.f5500c.setMapTrackballToArrowKeys(false);
        this.f5500c.setOverScrollMode(2);
        this.f5500c.getSettings().setBuiltInZoomControls(false);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f5500c.getSettings().setDefaultTextEncodingName("utf-8");
            this.f5500c.getSettings().setUseWideViewPort(false);
            this.f5500c.setInitialScale(100);
        }
        PackageManager packageManager = getPackageManager();
        this.f5500c.getSettings().setDisplayZoomControls(!(packageManager.hasSystemFeature("android.hardware.touchscreen.multitouch") || packageManager.hasSystemFeature("android.hardware.faketouch.multitouch.distinct")));
        this.f5500c.getSettings().setAllowFileAccess(true);
        this.f5500c.getSettings().setDefaultFontSize((int) getResources().getDimension(R.dimen.user_instruction_text_size));
        this.f5500c.setHorizontalScrollBarEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (C1413m.m6844f()) {
            setContentView(R.layout.iqoo_activity_text_change_service_and_disclaimer);
        } else {
            setContentView(R.layout.activity_text_change_service_and_disclaimer);
        }
        m6720b();
        m6721c();
        m6724f();
        m6722d();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.f5500c;
        if (webView != null) {
            webView.removeAllViews();
            this.f5500c.destroy();
        }
        FrameLayout frameLayout = this.f5499b;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        WebView webView = this.f5500c;
        if (webView != null) {
            webView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        WebView webView = this.f5500c;
        if (webView != null) {
            webView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
    }
}
