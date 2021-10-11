package com.android.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.bbksoundrecorder.AppFeature;
import com.android.bbksoundrecorder.R;
import com.android.common.utils.C1413m;
import com.android.view.widget.C1492b;
import java.util.ArrayList;
import java.util.List;
import p050c.p051a.p058e.p059a.C0938a;

public class SpecifiedShareActivity extends Activity {

    /* renamed from: a */
    private Context f5475a;

    /* renamed from: b */
    private RelativeLayout f5476b;

    /* renamed from: c */
    private RelativeLayout f5477c;

    /* renamed from: d */
    private LinearLayout f5478d;

    /* renamed from: e */
    private LinearLayout f5479e;

    /* renamed from: f */
    private LinearLayout f5480f;

    /* renamed from: g */
    private LinearLayout f5481g;

    /* renamed from: h */
    private int f5482h;

    /* renamed from: i */
    private ImageView f5483i;

    /* renamed from: j */
    private ImageView f5484j;

    /* renamed from: k */
    private ImageView f5485k;

    /* renamed from: l */
    private ImageView f5486l;

    /* renamed from: m */
    private TextView f5487m;

    /* renamed from: n */
    private TextView f5488n;

    /* renamed from: o */
    private TextView f5489o;

    /* renamed from: p */
    private TextView f5490p;

    /* renamed from: q */
    private int f5491q = -1;

    /* renamed from: r */
    private int f5492r = -1;

    /* renamed from: s */
    private int f5493s = -1;

    /* renamed from: t */
    private View f5494t;

    /* renamed from: c */
    private void m6713c() {
        List<PackageInfo> installedPackages = getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo next : installedPackages) {
                if (next.packageName.equals("com.tencent.mm")) {
                    this.f5491q = 1;
                } else if (next.packageName.equals("com.tencent.mobileqq")) {
                    this.f5492r = 1;
                } else if (next.packageName.equals("com.android.bluetooth")) {
                    this.f5493s = 1;
                }
            }
            return;
        }
        this.f5491q = -1;
        this.f5492r = -1;
        this.f5493s = -1;
    }

    /* renamed from: d */
    private void m6714d() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("com.tencent.mm");
        arrayList.add("com.tencent.mobileqq");
        arrayList.add("com.android.bluetooth");
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent("android.intent.action.SEND");
        for (String str : arrayList) {
            intent.setType("text/*");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities != null) {
                for (ResolveInfo loadIcon : queryIntentActivities) {
                    loadIcon.loadIcon(packageManager);
                    if (!str.equals("com.tencent.mm") && !str.equals("com.tencent.mobileqq")) {
                        str.equals("com.android.bluetooth");
                    }
                }
            }
        }
        arrayList.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6715e() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.addFlags(524288);
        intent.setType("audio/*");
        intent.putExtra("android.intent.extra.STREAM", ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5482h));
        try {
            startActivity(Intent.createChooser(intent, getString(R.string.share)));
            m6711b();
        } catch (ActivityNotFoundException unused) {
            C0938a.m5004b("SR/SpecifiedShareActivity", "<shareMore> shareDialog fail");
        }
    }

    /* renamed from: f */
    private void m6716f() {
        this.f5476b.setOnClickListener(new C1340kb(this));
        this.f5477c.setOnClickListener(new C1343lb(this));
        this.f5478d.setOnClickListener(new C1346mb(this));
        this.f5479e.setOnClickListener(new C1349nb(this));
        this.f5480f.setOnClickListener(new C1352ob(this));
        this.f5481g.setOnClickListener(new C1355pb(this));
        this.f5490p.setOnClickListener(new C1358qb(this));
    }

    /* renamed from: g */
    private void m6717g() {
        getWindow().getDecorView().setSystemUiVisibility(1024);
        getWindow().setStatusBarColor(Color.parseColor("#00FFFFFF"));
        getWindow().setNavigationBarColor(-1);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6718h() {
        m6711b();
    }

    public void finish() {
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.activity_specified_share);
        this.f5475a = AppFeature.m6734b().getApplicationContext();
        this.f5476b = (RelativeLayout) findViewById(R.id.specfied_share_viewcombine);
        this.f5477c = (RelativeLayout) findViewById(R.id.card);
        this.f5478d = (LinearLayout) findViewById(R.id.specified_share_wechat);
        this.f5479e = (LinearLayout) findViewById(R.id.specified_share_qq);
        this.f5480f = (LinearLayout) findViewById(R.id.specified_share_blueteeth);
        this.f5481g = (LinearLayout) findViewById(R.id.specified_share_more);
        this.f5483i = (ImageView) findViewById(R.id.share_wechat_icon);
        this.f5484j = (ImageView) findViewById(R.id.share_qq_icon);
        this.f5485k = (ImageView) findViewById(R.id.share_blueteeth_icon);
        this.f5486l = (ImageView) findViewById(R.id.more_share);
        this.f5487m = (TextView) findViewById(R.id.share_wechat_text);
        this.f5488n = (TextView) findViewById(R.id.share_qq_text);
        this.f5489o = (TextView) findViewById(R.id.share_blueteeth_text);
        this.f5490p = (TextView) findViewById(R.id.specified_cancel);
        this.f5494t = findViewById(R.id.divider_line);
        if (C1413m.m6841c(this.f5475a)) {
            this.f5486l.setBackgroundResource(R.drawable.specified_more_black);
            C1413m.m6834a((View) this.f5486l, 0);
        }
        C1413m.m6834a(this.f5494t, 0);
        m6706a();
        m6707a(getIntent());
        m6716f();
        m6713c();
        m6714d();
        m6717g();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: b */
    private void m6711b() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f5477c, "translationY", new float[]{0.0f, (float) getWindowManager().getDefaultDisplay().getHeight()}).setDuration(240);
        duration.start();
        duration.addListener(new C1361rb(this));
    }

    /* renamed from: a */
    private void m6706a() {
        this.f5477c.setVisibility(0);
        ObjectAnimator.ofFloat(this.f5477c, "translationY", new float[]{(float) getWindowManager().getDefaultDisplay().getHeight(), 0.0f}).setDuration(240).start();
    }

    /* renamed from: a */
    private void m6707a(Intent intent) {
        if (intent != null) {
            this.f5482h = intent.getIntExtra("shareId", -1);
        }
    }

    /* renamed from: a */
    private int m6705a(String str) {
        if (str.equals("com.tencent.mm") && this.f5491q == -1) {
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.app_not_installed), 0).show();
            return -1;
        } else if (str.equals("com.tencent.mobileqq") && this.f5492r == -1) {
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.app_not_installed), 0).show();
            return -1;
        } else if (!str.equals("com.android.bluetooth") || this.f5493s != -1) {
            return 1;
        } else {
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.app_not_installed), 0).show();
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6710a(String str, String str2) {
        if (-1 != m6705a(str)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(524288);
            intent.setType("text/*");
            intent.setClassName(str, str2);
            intent.putExtra("android.intent.extra.STREAM", ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5482h));
            try {
                startActivity(intent);
                m6711b();
            } catch (ActivityNotFoundException unused) {
                C0938a.m5004b("SR/SpecifiedShareActivity", "<shareOperation> shareDialog fail");
            }
        }
    }
}
