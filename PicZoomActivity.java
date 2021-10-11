package com.android.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import com.android.bbksoundrecorder.R;

public class PicZoomActivity extends Activity {

    /* renamed from: a */
    private ImageView f5112a;

    /* renamed from: b */
    private int f5113b;

    /* renamed from: c */
    private int f5114c;

    /* renamed from: a */
    private void m6241a() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f5113b = displayMetrics.heightPixels;
        this.f5114c = displayMetrics.widthPixels;
    }

    /* renamed from: b */
    private void m6242b() {
        requestWindowFeature(1);
    }

    /* renamed from: c */
    private void m6243c() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.systemUiVisibility = 2050;
        getWindow().setAttributes(attributes);
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6242b();
        m6243c();
        setContentView(R.layout.activity_pic_zoom);
        m6241a();
        this.f5112a = (ImageView) findViewById(R.id.zoom_picture);
        this.f5112a.setImageURI(Uri.parse(getIntent().getStringExtra("ZoomInPicture")));
        this.f5112a.setOnClickListener(new C1335j(this));
    }
}
