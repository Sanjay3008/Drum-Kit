package com.android.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.bbksoundrecorder.AppFeature;
import com.android.bbksoundrecorder.R;
import com.android.bbksoundrecorder.filename.C1382a;
import com.android.bbksoundrecorder.filename.C1383b;
import com.android.common.utils.C1384A;
import com.android.common.utils.C1387D;
import com.android.common.utils.C1390G;
import com.android.common.utils.C1398b;
import com.android.common.utils.C1400d;
import com.android.common.utils.C1411k;
import com.android.common.utils.C1413m;
import com.android.common.utils.C1418q;
import com.android.common.utils.C1422t;
import com.android.common.utils.C1424v;
import com.android.common.utils.C1425w;
import com.android.common.utils.C1426x;
import com.android.service.RecordService;
import com.android.view.timeview.TimeView;
import com.android.view.widget.C1492b;
import com.android.view.widget.RecordView;
import com.android.view.widget.TwoStateLayout;
import com.android.view.widget.XRecordView;
import com.vivo.easytransfer.C1882a;
import java.io.File;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p007b.p044k.p045a.C0900b;
import p050c.p051a.p052a.p053a.C0927a;
import p050c.p051a.p054b.C0931d;
import p050c.p051a.p057d.C0937a;
import p050c.p051a.p058e.p059a.C0938a;
import p050c.p051a.p062g.p063a.C1018a;
import p050c.p051a.p062g.p063a.C1020b;
import p050c.p051a.p067j.p068a.C1042j;

public class SoundRecorder extends Activity implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    /* renamed from: a */
    public static boolean f5379a = false;

    /* renamed from: b */
    public static boolean f5380b = false;

    /* renamed from: A */
    private long f5381A = 0;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ArrayList<C0937a> f5382B = new ArrayList<>();

    /* renamed from: C */
    private AlertDialog f5383C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public TwoStateLayout f5384D;

    /* renamed from: E */
    private TwoStateLayout f5385E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public TwoStateLayout f5386F;

    /* renamed from: G */
    private TimeView f5387G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public TextView f5388H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public Context f5389I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public EditText f5390J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public XRecordView f5391K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public RecordView f5392L;

    /* renamed from: M */
    private AnimationDrawable f5393M;

    /* renamed from: N */
    private final Handler f5394N = new Handler();

    /* renamed from: O */
    private TelephonyManager f5395O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public C1288b f5396P = new C1288b(this, (C1296Ua) null);

    /* renamed from: Q */
    private C1290d f5397Q = null;

    /* renamed from: R */
    private BroadcastReceiver f5398R = null;
    /* access modifiers changed from: private */

    /* renamed from: S */
    public C1425w f5399S = null;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public ProgressDialog f5400T = null;
    /* access modifiers changed from: private */

    /* renamed from: U */
    public RecordService.C1445b f5401U;

    /* renamed from: V */
    private Intent f5402V;

    /* renamed from: W */
    private ServiceConnection f5403W;

    /* renamed from: X */
    private C1018a f5404X;

    /* renamed from: Y */
    private AudioManager f5405Y;

    /* renamed from: Z */
    private KeyguardManager f5406Z;

    /* renamed from: aa */
    private int f5407aa = 0;

    /* renamed from: ba */
    private boolean f5408ba;

    /* renamed from: c */
    private String f5409c = null;

    /* renamed from: ca */
    private ImageView f5410ca;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f5411d;

    /* renamed from: da */
    private TextView f5412da;

    /* renamed from: e */
    private String f5413e = "00:00";

    /* renamed from: ea */
    private boolean f5414ea;

    /* renamed from: f */
    private String f5415f = "audio/aac_mp4";

    /* renamed from: fa */
    private ImageView f5416fa;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f5417g = false;

    /* renamed from: ga */
    private int f5418ga = 0;

    /* renamed from: h */
    private boolean f5419h = false;

    /* renamed from: ha */
    private long f5420ha = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f5421i = false;
    /* access modifiers changed from: private */

    /* renamed from: ia */
    public boolean f5422ia = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f5423j = false;
    /* access modifiers changed from: private */

    /* renamed from: ja */
    public RecyclerView f5424ja;

    /* renamed from: k */
    private boolean f5425k = false;
    /* access modifiers changed from: private */

    /* renamed from: ka */
    public C0931d f5426ka;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f5427l = false;

    /* renamed from: la */
    private ScreenBroadcastReceiver f5428la = new ScreenBroadcastReceiver();

    /* renamed from: m */
    private boolean f5429m = false;

    /* renamed from: ma */
    private RecordPageAddMarkReceiver f5430ma = new RecordPageAddMarkReceiver();

    /* renamed from: n */
    private boolean f5431n = false;

    /* renamed from: na */
    private Vibrator f5432na;

    /* renamed from: o */
    private Boolean f5433o = false;

    /* renamed from: oa */
    private View f5434oa;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f5435p = 0;

    /* renamed from: pa */
    private RelativeLayout f5436pa;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f5437q = 0;

    /* renamed from: qa */
    private LinearLayout f5438qa;

    /* renamed from: r */
    private int f5439r = 0;

    /* renamed from: ra */
    private C1287a f5440ra;

    /* renamed from: s */
    private float f5441s = 0.0f;

    /* renamed from: sa */
    private Intent f5442sa;

    /* renamed from: t */
    private long f5443t = 0;

    /* renamed from: ta */
    private Handler f5444ta = new C1296Ua(this);
    /* access modifiers changed from: private */

    /* renamed from: u */
    public long f5445u = 0;

    /* renamed from: ua */
    Runnable f5446ua = new C1316cb(this);

    /* renamed from: v */
    private long f5447v = 0;

    /* renamed from: va */
    private DialogInterface.OnClickListener f5448va = new C1319db(this);

    /* renamed from: w */
    private long f5449w = -1000;

    /* renamed from: wa */
    private DialogInterface.OnClickListener f5450wa = new C1322eb(this);

    /* renamed from: x */
    private long f5451x = 0;

    /* renamed from: xa */
    private DialogInterface.OnClickListener f5452xa = new C1328gb(this);

    /* renamed from: y */
    private long f5453y = -1;

    /* renamed from: ya */
    private DialogInterface.OnKeyListener f5454ya = new C1331hb(this);
    /* access modifiers changed from: private */

    /* renamed from: z */
    public long f5455z = 0;

    /* renamed from: za */
    private C1289c f5456za;

    public class RecordPageAddMarkReceiver extends BroadcastReceiver {
        public RecordPageAddMarkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("addMark", -1) == 100) {
                SoundRecorder.this.f5386F.performClick();
                C0938a.m5004b("SR/SoundRecorder", "add mark from notification page");
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "1");
                    C1390G.m6779b("A107|7|1|10", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/SoundRecorder", "vcode error");
                }
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("from", "2");
                    C1390G.m6779b("A107|7|1|10", hashMap2);
                } catch (Exception unused2) {
                    C0938a.m5004b("SR/SoundRecorder", "vcode error");
                }
            }
        }
    }

    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        public ScreenBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (SoundRecorder.this.f5401U != null) {
                String action = intent.getAction();
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    if (SoundRecorder.this.f5435p != 0) {
                        if (SoundRecorder.this.f5435p == 1 || SoundRecorder.this.f5435p == 2 || SoundRecorder.this.f5435p == 4) {
                            SoundRecorder.this.f5401U.mo6340a(false);
                        }
                    }
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    SoundRecorder.this.f5401U.mo6340a(false);
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("from", "2");
                        C1390G.m6779b("A107|7|2|7", hashMap);
                    } catch (Exception unused) {
                        C0938a.m5004b("SR/SoundRecorder", "vcode error");
                    }
                } else if (action.equals("android.intent.action.USER_PRESENT")) {
                    SoundRecorder.this.f5401U.mo6335a();
                    if ((SoundRecorder.this.f5435p == 1 || SoundRecorder.this.f5435p == 2 || SoundRecorder.this.f5435p == 4) && !SoundRecorder.f5379a) {
                        SoundRecorder.this.f5401U.mo6340a(true);
                    }
                }
            }
        }
    }

    /* renamed from: com.android.activity.SoundRecorder$b */
    private class C1288b extends Handler {
        private C1288b() {
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    SoundRecorder.this.mo5996r();
                }
            } else if (SoundRecorder.this.f5411d != null) {
                SoundRecorder soundRecorder = SoundRecorder.this;
                soundRecorder.m6629b(soundRecorder.f5411d);
            }
        }

        /* synthetic */ C1288b(SoundRecorder soundRecorder, C1296Ua ua) {
            this();
        }
    }

    /* renamed from: com.android.activity.SoundRecorder$c */
    private class C1289c extends AsyncTask<String, Void, Uri> {
        private C1289c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Uri doInBackground(String... strArr) {
            Uri uri;
            SoundRecorder.this.f5401U.mo6353n();
            C0938a.m5002a("SR/SoundRecorder", "<returnToMessageActivity>, displayName = " + strArr[0]);
            Cursor a = C1426x.m6909a(SoundRecorder.this.f5389I).mo6192a(false);
            int a2 = C1426x.m6908a(a, strArr[0]);
            if (a2 != -1) {
                uri = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) a2);
                Intent intent = new Intent();
                intent.setData(uri);
                intent.addFlags(1);
                SoundRecorder.this.setResult(-1, intent);
            } else {
                uri = null;
            }
            SoundRecorder.this.m6614a(a);
            C0938a.m5002a("SR/SoundRecorder", "<returnToMessageActivity>,uri = " + uri);
            return uri;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* synthetic */ C1289c(SoundRecorder soundRecorder, C1296Ua ua) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Uri uri) {
            super.onPostExecute(uri);
            if (uri == null) {
                if (SoundRecorder.this.f5400T == null || !SoundRecorder.this.f5400T.isShowing()) {
                    SoundRecorder soundRecorder = SoundRecorder.this;
                    ProgressDialog unused = soundRecorder.f5400T = new ProgressDialog(soundRecorder);
                    SoundRecorder.this.f5400T.setMessage(SoundRecorder.this.getString(R.string.progressdialog_save));
                    SoundRecorder.this.f5400T.setIndeterminate(true);
                    SoundRecorder.this.f5400T.show();
                    SoundRecorder.this.f5400T.setOnCancelListener(new C1334ib(this));
                }
                C0938a.m5002a("SR/SoundRecorder", "<checkSavedInMediaDatebase>,obtainMessage,save");
                SoundRecorder.this.f5396P.sendMessageDelayed(SoundRecorder.this.f5396P.obtainMessage(0), 200);
                return;
            }
            C0938a.m5002a("SR/SoundRecorder", "<checkSavedInMediaDatebase>,removeMessages,save");
            SoundRecorder.this.f5396P.removeMessages(0);
            if (C1413m.m6844f()) {
                SoundRecorder.this.f5392L.setRecordState(false);
            } else if (SoundRecorder.this.m6595L()) {
                SoundRecorder.this.f5391K.setRecordState(false);
            } else {
                SoundRecorder.this.f5392L.setRecordState(false);
            }
            C1492b.m7431a(SoundRecorder.this.f5389I, (CharSequence) SoundRecorder.this.getString(R.string.save), 0).show();
            boolean unused2 = SoundRecorder.this.f5427l = false;
            C1413m.f5712j = 0;
            boolean unused3 = SoundRecorder.this.f5417g = false;
            boolean unused4 = SoundRecorder.this.f5421i = false;
            SoundRecorder.this.f5399S.mo6172e("1");
            if (SoundRecorder.this.f5400T != null && SoundRecorder.this.mo5973j()) {
                SoundRecorder.this.f5400T.dismiss();
            }
            SoundRecorder.this.finish();
        }
    }

    /* renamed from: com.android.activity.SoundRecorder$d */
    private class C1290d extends BroadcastReceiver {
        private C1290d() {
        }

        public void onReceive(Context context, Intent intent) {
            if (SoundRecorder.this.f5401U == null || SoundRecorder.this.f5401U.mo6342c() != 102) {
                String action = intent.getAction();
                if (action.equals("com.android.bbksoundrecorder.intent.action.RECORDER_STATE")) {
                    int intExtra = intent.getIntExtra("recorder_state", 0);
                    C0938a.m5002a("SR/SoundRecorder", "MsgFromServiceReceiver state: " + intExtra);
                    SoundRecorder.this.m6631c(intExtra);
                } else if (action.equals("com.android.bbksoundrecorder.intent.action.HANDLE_ERROR")) {
                    SoundRecorder.this.mo5958a(intent.getIntExtra("handle_error", 0));
                } else if (action.equals("android.intent.action.USER_SWITCHED")) {
                    SoundRecorder.this.mo5958a(11);
                }
            }
        }

        /* synthetic */ C1290d(SoundRecorder soundRecorder, C1296Ua ua) {
            this();
        }
    }

    /* renamed from: com.android.activity.SoundRecorder$e */
    private class C1291e implements ServiceConnection {
        private C1291e() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RecordService.C1445b unused = SoundRecorder.this.f5401U = (RecordService.C1445b) iBinder;
            C0938a.m5002a("SR/SoundRecorder", "<onServiceConnected> , RecordState: " + SoundRecorder.this.f5401U.mo6345f());
            if (SoundRecorder.this.f5401U != null) {
                int f = SoundRecorder.this.f5401U.mo6345f();
                if (!SoundRecorder.this.f5427l || !(f == 2 || f == 4 || SoundRecorder.this.f5401U.mo6347h() != null)) {
                    if (SoundRecorder.this.f5401U.mo6345f() == 4) {
                        C0938a.m5002a("SR/SoundRecorder", "<onServiceConnected> current is paused.");
                        SoundRecorder.this.m6631c(4);
                    } else if (SoundRecorder.this.f5401U.mo6345f() == 2) {
                        C0938a.m5002a("SR/SoundRecorder", "<onServiceConnected> current is paused.");
                        SoundRecorder.this.m6631c(2);
                    }
                    if (!C1424v.m6870a("android.permission.RECORD_AUDIO", SoundRecorder.this) || !C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", SoundRecorder.this)) {
                        SoundRecorder.this.f5401U.mo6335a();
                    }
                } else {
                    SoundRecorder soundRecorder = SoundRecorder.this;
                    C1492b.m7431a((Context) soundRecorder, (CharSequence) soundRecorder.getString(R.string.please_close_background_recorder), 0).show();
                    SoundRecorder.this.finish();
                    return;
                }
            }
            SoundRecorder soundRecorder2 = SoundRecorder.this;
            soundRecorder2.m6632c(soundRecorder2.getIntent());
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0938a.m5002a("SR/SoundRecorder", "<onServiceDisconnected>");
        }

        /* synthetic */ C1291e(SoundRecorder soundRecorder, C1296Ua ua) {
            this();
        }
    }

    /* renamed from: A */
    private void m6584A() {
        this.f5414ea = C1387D.m6761a();
        if (this.f5414ea) {
            this.f5405Y.setParameters("audio_recordaec_enable=1");
            this.f5410ca.setImageResource(R.drawable.btn_aec_on_selector);
            return;
        }
        this.f5405Y.setParameters("audio_recordaec_enable=0");
        this.f5410ca.setImageResource(R.drawable.btn_aec_off_selector);
    }

    /* renamed from: B */
    private void m6585B() {
        this.f5395O = (TelephonyManager) getSystemService("phone");
        this.f5399S = new C1425w(this.f5389I);
        this.f5404X = C1018a.m5416a(this.f5389I);
    }

    /* renamed from: C */
    private void m6586C() {
        this.f5424ja.setLayoutManager(new LinearLayoutManager(this));
        this.f5426ka = new C0931d(this, this.f5382B, 0);
        this.f5424ja.setItemAnimator(new C1042j());
        this.f5426ka.mo5054a((C0931d.C0932a) new C1313bb(this));
        this.f5424ja.setAdapter(this.f5426ka);
    }

    /* renamed from: D */
    private void m6587D() {
        if (C1413m.m6841c(this.f5389I)) {
            setTheme(R.style.notitleBarStyle_nightmode);
            if (C1413m.m6844f()) {
                setContentView(R.layout.mainiqoo_night);
            } else if (!m6595L()) {
                setContentView(R.layout.mainline_night);
            } else if (C1413m.m6838b() <= 4.0f || C1384A.m6754a()) {
                setContentView(R.layout.main_nightmode_low_rom_version);
            } else {
                setContentView(R.layout.main_nightmode);
            }
        } else {
            setTheme(R.style.notitleBarStyle);
            if (C1413m.m6844f()) {
                setContentView(R.layout.mainiqoo);
            } else if (!m6595L()) {
                setContentView(R.layout.mainline);
            } else if (C1413m.m6838b() <= 4.0f || C1384A.m6754a()) {
                setContentView(R.layout.main_low_rom_version);
            } else {
                setContentView(R.layout.main);
            }
        }
        this.f5410ca = (ImageView) findViewById(R.id.iv_aec);
        this.f5434oa = findViewById(R.id.center_flag);
        if (AppFeature.f5611g) {
            this.f5410ca.setVisibility(0);
            this.f5410ca.setOnClickListener(this);
            m6584A();
        }
        if (m6595L()) {
            this.f5412da = (TextView) findViewById(R.id.tv_record_name);
        }
        this.f5424ja = (RecyclerView) findViewById(R.id.rv_mark);
        m6586C();
        this.f5384D = (TwoStateLayout) findViewById(R.id.record_control);
        this.f5385E = (TwoStateLayout) findViewById(R.id.done_or_filelist);
        this.f5386F = (TwoStateLayout) findViewById(R.id.mark_control);
        this.f5416fa = (ImageView) findViewById(R.id.mask);
        this.f5436pa = (RelativeLayout) findViewById(R.id.background_view);
        this.f5438qa = (LinearLayout) findViewById(R.id.bottom_layout);
        if (!C1413m.m6844f()) {
            C1413m.m6834a((View) this.f5384D, 10);
        }
        if (C1413m.f5711i != null) {
            mo5957a();
        } else {
            m6622a(false);
        }
    }

    /* renamed from: E */
    private void m6588E() {
        C0938a.m5002a("SR/SoundRecorder", "<initResourceRefs>");
        if (C1413m.m6844f()) {
            this.f5386F.mo6533a(getResources().getString(R.string.new_mark_name), (int) R.drawable.iqoo_btn_recorder_mark_selector, getResources().getDimensionPixelSize(R.dimen.side_text_margin_diff));
            this.f5385E.mo6533a(getResources().getString(R.string.done), (int) R.drawable.iqoo_btn_recorder_stop_selector, getResources().getDimensionPixelSize(R.dimen.side_text_margin_diff));
        } else {
            this.f5386F.mo6533a(getResources().getString(R.string.new_mark_name), (int) R.drawable.btn_recorder_mark_selector, getResources().getDimensionPixelSize(R.dimen.side_text_margin_diff_x50));
            this.f5385E.mo6533a(getResources().getString(R.string.done), (int) R.drawable.btn_recorder_stop_selector, getResources().getDimensionPixelSize(R.dimen.side_text_margin_diff_x50));
        }
        if (!C1413m.m6844f()) {
            this.f5384D.mo6533a(getResources().getString(R.string.manager_title), (int) R.drawable.btn_play_0, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
        }
        if (C1413m.m6845g()) {
            this.f5386F.setTextSize(12.0f);
        } else {
            this.f5386F.setTextSize(14.0f);
        }
        if (C1413m.m6845g()) {
            this.f5384D.setTextSize(12.0f);
        } else {
            this.f5384D.setTextSize(14.0f);
        }
        if (C1411k.m6820b(this)) {
            TwoStateLayout twoStateLayout = this.f5384D;
            twoStateLayout.setContentDescription(getResources().getString(R.string.manager_title) + "，" + getResources().getString(R.string.button_talkback));
            TwoStateLayout twoStateLayout2 = this.f5386F;
            twoStateLayout2.setContentDescription(getResources().getString(R.string.new_mark_name) + "，" + getResources().getString(R.string.button_talkback));
            TwoStateLayout twoStateLayout3 = this.f5385E;
            twoStateLayout3.setContentDescription(getResources().getString(R.string.done) + "," + getResources().getString(R.string.button_talkback));
        }
        if (C1413m.m6845g()) {
            this.f5385E.setTextSize(12.0f);
        } else {
            this.f5385E.setTextSize(14.0f);
        }
        this.f5387G = (TimeView) findViewById(R.id.record_time_show);
        this.f5384D.setOnClickListener(this);
        this.f5385E.setOnClickListener(this);
        this.f5386F.setOnClickListener(this);
        this.f5384D.setClickable(false);
        this.f5385E.setClickable(false);
        if (C1413m.m6844f()) {
            this.f5392L = (RecordView) findViewById(R.id.record_wave1);
        } else if (m6595L()) {
            this.f5391K = (XRecordView) findViewById(R.id.record_wave1);
        } else {
            this.f5392L = (RecordView) findViewById(R.id.record_wave1);
        }
        m6605V();
    }

    /* renamed from: F */
    private void m6589F() {
        C1413m.f5712j = 1;
        this.f5402V = new Intent(this, RecordService.class);
        this.f5402V.putExtra("record_activity_type", 101);
        this.f5403W = new C1291e(this, (C1296Ua) null);
        C0938a.m5002a("SR/SoundRecorder", "<initService> isAppForeground: ");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                startForegroundService(this.f5402V);
            } else {
                startService(this.f5402V);
            }
        } catch (Exception e) {
            C0938a.m5004b("SR/SoundRecorder", "initService" + e);
        }
        bindService(this.f5402V, this.f5403W, 1);
        this.f5429m = true;
        m6600Q();
        m6599P();
    }

    /* renamed from: G */
    private void m6590G() {
        if (!this.f5429m) {
            m6589F();
        }
    }

    /* renamed from: H */
    private void m6591H() {
        if (!isFinishing()) {
            f5379a = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: I */
    public boolean m6592I() {
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (activityManager.getLockTaskModeState() != 0) {
                return true;
            }
            return false;
        } else if (i >= 21) {
            return activityManager.isInLockTaskMode();
        } else {
            return false;
        }
    }

    /* renamed from: J */
    private boolean m6593J() {
        RecordService.C1445b bVar = this.f5401U;
        if (bVar == null) {
            return false;
        }
        long i = bVar.mo6348i();
        long j = this.f5455z;
        if (i - j <= 1000 && j != 0) {
            return true;
        }
        if (this.f5435p == 4) {
            i -= 100;
        }
        this.f5455z = i;
        int i2 = this.f5435p;
        if (i2 == 0 || i2 == 1 || i2 == 3) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060 A[SYNTHETIC, Splitter:B:18:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ Exception -> 0x0068 }] */
    /* renamed from: K */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6594K() {
        /*
            r8 = this;
            java.lang.String r0 = "yes"
            java.lang.String r1 = "noValue"
            java.lang.String r2 = "nightMode"
            com.android.bbksoundrecorder.AppFeature r3 = com.android.bbksoundrecorder.AppFeature.m6734b()     // Catch:{ Exception -> 0x0068 }
            r4 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r2, r4)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r5 = r3.getString(r2, r1)     // Catch:{ Exception -> 0x0068 }
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0068 }
            r6 = 1
            java.lang.String r7 = "no"
            if (r5 == 0) goto L_0x002b
            android.content.Context r5 = r8.f5389I     // Catch:{ Exception -> 0x0068 }
            boolean r5 = com.android.common.utils.C1413m.m6841c(r5)     // Catch:{ Exception -> 0x0068 }
            if (r5 == 0) goto L_0x002b
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0068 }
            r8.f5433o = r1     // Catch:{ Exception -> 0x0068 }
            goto L_0x004a
        L_0x002b:
            java.lang.String r1 = r3.getString(r2, r1)     // Catch:{ Exception -> 0x0068 }
            boolean r1 = r1.equals(r7)     // Catch:{ Exception -> 0x0068 }
            if (r1 == 0) goto L_0x0044
            android.content.Context r1 = r8.f5389I     // Catch:{ Exception -> 0x0068 }
            boolean r1 = com.android.common.utils.C1413m.m6841c(r1)     // Catch:{ Exception -> 0x0068 }
            if (r1 != 0) goto L_0x0044
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch:{ Exception -> 0x0068 }
            r8.f5433o = r1     // Catch:{ Exception -> 0x0068 }
            goto L_0x004a
        L_0x0044:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0068 }
            r8.f5433o = r1     // Catch:{ Exception -> 0x0068 }
        L_0x004a:
            com.android.bbksoundrecorder.AppFeature r1 = com.android.bbksoundrecorder.AppFeature.m6734b()     // Catch:{ Exception -> 0x0068 }
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r4)     // Catch:{ Exception -> 0x0068 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0068 }
            android.content.Context r2 = r8.f5389I     // Catch:{ Exception -> 0x0068 }
            boolean r2 = com.android.common.utils.C1413m.m6841c(r2)     // Catch:{ Exception -> 0x0068 }
            java.lang.String r3 = "night"
            if (r2 == 0) goto L_0x0064
            r1.putString(r3, r0)     // Catch:{ Exception -> 0x0068 }
            goto L_0x006f
        L_0x0064:
            r1.putString(r3, r7)     // Catch:{ Exception -> 0x0068 }
            goto L_0x006f
        L_0x0068:
            java.lang.String r0 = "SR/SoundRecorder"
            java.lang.String r1 = "isNightModeChanged error"
            p050c.p051a.p058e.p059a.C0938a.m5004b(r0, r1)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.activity.SoundRecorder.m6594K():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public boolean m6595L() {
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: M */
    public void m6596M() {
        C0938a.m5002a("SR/SoundRecorder", "<performDeleteOperation>");
        AlertDialog create = new AlertDialog.Builder(this, 51314692).setTitle(getString(R.string.delete_file_new)).setPositiveButton(R.string.delete, new C1325fb(this)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.setOwnerActivity(this);
        if (!isDestroyed() && !isFinishing()) {
            create.show();
            create.getWindow().setGravity(80);
            create.getButton(-1).setTextColor(Color.parseColor(C1413m.f5728z));
        }
    }

    /* renamed from: N */
    private void m6597N() {
        C0938a.m5002a("SR/SoundRecorder", "<popClearDialogBox>");
        String lowerCase = this.f5399S.mo6173f().getAbsolutePath().toLowerCase();
        if (this.f5419h) {
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.phone_mtp_space_expired_smartkey), 1).show();
            this.f5419h = false;
        }
        Intent intent = new Intent("com.iqoo.secure.LOW_MEMORY_WARNING");
        intent.addFlags(268435456);
        intent.putExtra("require_size", 5242880);
        intent.putExtra("pkg_name", getPackageName());
        intent.putExtra("extra_loc", 1);
        intent.putExtra("tips_title", getResources().getString(R.string.manager_title));
        intent.putExtra("tips_title_all", getResources().getString(R.string.unable_to_record));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            Intent intent2 = new Intent();
            intent2.putExtra("BBKPhoneCardName", lowerCase);
            intent2.setComponent(new ComponentName("com.android.filemanager", "com.android.filemanager.FileManagerActivity"));
            startActivity(intent2);
        }
    }

    /* renamed from: O */
    private String m6598O() {
        try {
            Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
            declaredField.setAccessible(true);
            return (String) declaredField.get(this);
        } catch (Exception e) {
            C0938a.m5004b("SR/SoundRecorder", "<reflectGetReferrer>,Exception: " + e.toString());
            return null;
        }
    }

    /* renamed from: P */
    private void m6599P() {
        if (this.f5398R == null) {
            this.f5398R = new C1269Oa(this);
            registerReceiver(this.f5398R, new IntentFilter("android.vivo.bbklog.action.CHANGED"));
        }
    }

    /* renamed from: Q */
    private void m6600Q() {
        this.f5397Q = new C1290d(this, (C1296Ua) null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.RECORDER_STATE");
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.HANDLE_ERROR");
        intentFilter.addAction("android.intent.action.USER_SWITCHED");
        C0900b.m4902a(this.f5389I).mo4900a(this.f5397Q, intentFilter);
    }

    /* renamed from: R */
    private void m6601R() {
        if (AppFeature.f5609e) {
            this.f5399S.mo6174f("0");
        }
        this.f5399S.mo6172e("1");
    }

    /* renamed from: S */
    private void m6602S() {
        XRecordView xRecordView;
        if (C1413m.m6844f()) {
            getWindow().setStatusBarColor(C1413m.f5721s);
            getWindow().setNavigationBarColor(C1413m.f5721s);
        }
        if (C1418q.m6857a(this) && (xRecordView = this.f5391K) != null && this.f5434oa != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) xRecordView.getLayoutParams();
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.trackview_layout_height_x_hasnar);
            this.f5391K.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f5434oa.getLayoutParams();
            layoutParams2.height = getResources().getDimensionPixelSize(R.dimen.trackview_height_x_hasnor);
            this.f5434oa.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: T */
    private void m6603T() {
        RecordService.C1445b bVar;
        if (!isFinishing() && !this.f5427l && (bVar = this.f5401U) != null) {
            bVar.mo6340a(true);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("from", "1");
                C1390G.m6779b("A107|7|2|7", hashMap);
            } catch (Exception unused) {
                C0938a.m5004b("SR/SoundRecorder", "vcode error");
            }
        }
    }

    /* renamed from: U */
    private void m6604U() {
        RecordService.C1445b bVar;
        C0938a.m5002a("SR/SoundRecorder", "<stopRecording>");
        int i = this.f5435p;
        if ((i != 2 && i != 4) || (bVar = this.f5401U) == null) {
            return;
        }
        if (!this.f5427l) {
            try {
                if (this.f5435p == 2) {
                    bVar.mo6349j();
                    this.f5437q = 2;
                } else {
                    this.f5437q = 4;
                }
                if (this.f5401U.mo6347h() != null) {
                    this.f5440ra = new C1287a(this, (C1296Ua) null);
                    this.f5440ra.execute(new Boolean[0]);
                }
            } catch (Exception e) {
                this.f5435p = 0;
                C0938a.m5004b("SR/SoundRecorder", "<stopRecorderSaveSample>,mRecorder.stop(),Exception : " + e);
            }
        } else {
            m6629b(this.f5411d);
        }
    }

    /* renamed from: V */
    private void m6605V() {
        if (C1422t.m6866a()) {
            String.format("%02d:%02d:%02d", new Object[]{0, 0, 0});
            this.f5387G.setCurrentTime(0);
            return;
        }
        this.f5387G.setCurrentTime(0);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
        if (r1 != 4) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* renamed from: W */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6606W() {
        /*
            r17 = this;
            r0 = r17
            com.android.service.RecordService$b r1 = r0.f5401U
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "<updateTimerView>,mState = "
            r1.append(r2)
            int r2 = r0.f5435p
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SR/SoundRecorder"
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r1)
            com.android.service.RecordService$b r1 = r0.f5401U
            long r3 = r1.mo6348i()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r7 = r3 / r5
            r0.f5420ha = r7
            com.android.service.RecordService$b r1 = r0.f5401U
            long r9 = r1.mo6346g()
            int r1 = r0.f5435p
            r11 = 3
            r12 = 4
            r13 = 1
            r14 = 2
            r5 = 0
            if (r1 == 0) goto L_0x009a
            if (r1 == r13) goto L_0x0043
            if (r1 == r14) goto L_0x0055
            if (r1 == r11) goto L_0x0045
            if (r1 == r12) goto L_0x00a1
        L_0x0043:
            r7 = r5
            goto L_0x00a1
        L_0x0045:
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x004b
            r7 = r5
            goto L_0x004d
        L_0x004b:
            r0.f5451x = r5
        L_0x004d:
            android.os.Handler r1 = r0.f5394N
            java.lang.Runnable r3 = r0.f5446ua
            r1.removeCallbacks(r3)
            goto L_0x00a1
        L_0x0055:
            r0.f5449w = r3
            int r1 = r0.f5439r
            if (r1 != r12) goto L_0x006b
            android.os.Handler r1 = r0.f5394N
            java.lang.Runnable r3 = r0.f5446ua
            long r7 = r0.f5451x
            r15 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r15
            long r12 = r0.f5449w
            long r7 = r7 - r12
            r1.postDelayed(r3, r7)
            goto L_0x007f
        L_0x006b:
            r15 = 1000(0x3e8, double:4.94E-321)
            android.os.Handler r1 = r0.f5394N
            java.lang.Runnable r3 = r0.f5446ua
            long r7 = r0.f5451x
            r12 = 1
            long r7 = r7 + r12
            r0.f5451x = r7
            long r7 = r7 * r15
            long r12 = r0.f5449w
            long r7 = r7 - r12
            r1.postDelayed(r3, r7)
        L_0x007f:
            long r7 = r0.f5449w
            r12 = 500(0x1f4, double:2.47E-321)
            long r7 = r7 + r12
            long r7 = r7 / r15
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "<updateTimerView>,currentTime = "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r1)
            goto L_0x00a1
        L_0x009a:
            r0.f5451x = r5
            r7 = -1000(0xfffffffffffffc18, double:NaN)
            r0.f5449w = r7
            goto L_0x0043
        L_0x00a1:
            java.lang.Object[] r1 = new java.lang.Object[r11]
            r3 = 0
            r11 = 3600(0xe10, double:1.7786E-320)
            long r15 = r7 / r11
            java.lang.Long r13 = java.lang.Long.valueOf(r15)
            r1[r3] = r13
            long r11 = r7 % r11
            r15 = 60
            long r11 = r11 / r15
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            r11 = 1
            r1[r11] = r3
            long r11 = r7 % r15
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            r1[r14] = r3
            java.lang.String r3 = "%02d:%02d:%02d"
            java.lang.String r1 = java.lang.String.format(r3, r1)
            r0.f5413e = r1
            int r1 = r0.f5435p
            if (r1 == r14) goto L_0x00d1
            r3 = 4
            if (r1 != r3) goto L_0x00d6
        L_0x00d1:
            com.android.view.timeview.TimeView r1 = r0.f5387G
            r1.setCurrentTime(r7)
        L_0x00d6:
            int r1 = r0.f5435p
            r0.f5439r = r1
            com.android.service.RecordService$b r1 = r0.f5401U
            if (r1 == 0) goto L_0x012f
            boolean r1 = r0.f5425k
            if (r1 != 0) goto L_0x012f
            boolean r1 = r0.f5421i
            if (r1 == 0) goto L_0x012f
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x012f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "<updateTimerView>,mHasFileSizeLimitation : "
            r1.append(r3)
            boolean r3 = r0.f5421i
            r1.append(r3)
            java.lang.String r3 = ",mRecorder.getRemainingTime(): "
            r1.append(r3)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r1)
            android.os.Handler r1 = r0.f5394N
            java.lang.Runnable r3 = r0.f5446ua
            r1.removeCallbacks(r3)
            r1 = 1
            r0.f5425k = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "<updateTimerView>, mState = "
            r1.append(r3)
            int r3 = r0.f5435p
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r1)
            int r1 = r0.f5435p
            if (r1 != r14) goto L_0x012f
            r17.m6604U()
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.activity.SoundRecorder.m6606W():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: X */
    public void m6607X() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("is_rename", "0");
            C1390G.m6779b("A107|1|3|10", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("mark_num", String.valueOf(this.f5418ga));
            C1390G.m6779b("A107|1|3|10", hashMap2);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("rec_time", String.valueOf(this.f5420ha));
            C1390G.m6779b("A107|1|3|10", hashMap3);
        } catch (Exception e) {
            C0938a.m5004b("SR/SoundRecorder", "A107|1|3|10Vcode error:" + e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m6608Y() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("is_rename", "1");
            C1390G.m6779b("A107|1|3|10", hashMap);
        } catch (Exception e) {
            C0938a.m5004b("SR/SoundRecorder", "A107|1|3|10Vcode error:" + e);
        }
    }

    public void onBackPressed() {
        C0938a.m5002a("SR/SoundRecorder", "<onBackPressed>, mState: " + this.f5435p);
        if (!this.f5417g) {
            int i = this.f5435p;
            if (i != 2 && i != 4) {
                super.onBackPressed();
            } else if (this.f5427l) {
                C1413m.f5712j = 0;
                m6604U();
            } else {
                moveTaskToBack(true);
            }
            if (this.f5435p == 3) {
                finish();
            }
        }
    }

    public void onClick(View view) {
        C1425w wVar;
        C1425w wVar2;
        String str = "1";
        switch (view.getId()) {
            case R.id.done_or_filelist /*2131230818*/:
                int i = this.f5435p;
                if (i == 2 || i == 4) {
                    if (Math.abs(this.f5447v - SystemClock.uptimeMillis()) >= 500) {
                        this.f5447v = SystemClock.uptimeMillis();
                        C0938a.m5002a("SR/SoundRecorder", "Load new name: <restartLoader>");
                        m6604U();
                    } else {
                        return;
                    }
                } else if (Math.abs(this.f5447v - SystemClock.uptimeMillis()) >= 500) {
                    this.f5447v = SystemClock.uptimeMillis();
                    if (Settings.System.getInt(getContentResolver(), "motor_mode_enabled", 0) == 1) {
                        C1492b.m7431a((Context) this, (CharSequence) getString(R.string.motor_mode_disabled_tips), 0).show();
                        return;
                    }
                } else {
                    return;
                }
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("button_name", "3");
                    C1390G.m6779b("A107|1|1|10", hashMap);
                } catch (Exception e) {
                    C0938a.m5004b("SR/SoundRecorder", "A107|1|1|10Vcode error:" + e);
                }
                C1413m.f5712j = 0;
                return;
            case R.id.iv_aec /*2131230868*/:
                m6669y();
                return;
            case R.id.mark_control /*2131230882*/:
                C0938a.m5002a("SR/SoundRecorder", "<onClick> record Mark !");
                if (!m6593J()) {
                    C0937a aVar = new C0937a();
                    aVar.mo5063a(C1020b.m5434a(this.f5382B));
                    aVar.mo5062a(this.f5455z);
                    this.f5382B.add(0, aVar);
                    this.f5426ka.mo3274d(0);
                    this.f5424ja.mo3183h(0);
                    this.f5431n = true;
                    if (this.f5435p == 4) {
                        try {
                            if (C1413m.m6844f()) {
                                this.f5392L.mo6498a(this.f5443t, this.f5431n);
                                this.f5392L.mo6500b(this.f5441s);
                                this.f5392L.invalidate();
                            } else if (m6595L()) {
                                this.f5391K.mo6585a(this.f5443t, this.f5431n);
                                this.f5391K.mo6586b(this.f5441s);
                                this.f5391K.invalidate();
                            } else {
                                this.f5392L.mo6498a(this.f5443t, this.f5431n);
                                this.f5392L.mo6500b(this.f5441s);
                                this.f5392L.invalidate();
                            }
                            this.f5431n = false;
                        } catch (Exception unused) {
                            C0938a.m5004b("SR/SoundRecorder", "RecordView or RecognizeVoiceView error:");
                        }
                    }
                    try {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("button_name", str);
                        C1390G.m6779b("A107|1|1|10", hashMap2);
                        return;
                    } catch (Exception e2) {
                        C0938a.m5004b("SR/SoundRecorder", "A107|1|1|10Vcode error:" + e2);
                        return;
                    }
                } else {
                    return;
                }
            case R.id.record_control /*2131230937*/:
                if (Math.abs(this.f5445u - SystemClock.uptimeMillis()) >= 500) {
                    this.f5445u = SystemClock.uptimeMillis();
                    if (this.f5395O.getCallState() == 2) {
                        C0938a.m5002a("SR/SoundRecorder", "<onClick>, mTelephonyManager.getCallState() = " + this.f5395O.getCallState());
                        this.f5409c = getResources().getString(R.string.call_not_record);
                        C1492b.m7431a((Context) this, (CharSequence) this.f5409c, 0).show();
                        return;
                    }
                    if (this.f5421i && (wVar2 = this.f5399S) != null) {
                        wVar2.mo6172e("0");
                        C0938a.m5002a("SR/SoundRecorder", "<onClick> ,mRecConfigFile.setRecorderFileType(0) for  attachment recorder");
                    }
                    int i2 = this.f5435p;
                    if (i2 == 2 || i2 == 4 || (wVar = this.f5399S) == null || !wVar.mo6163a(5120)) {
                        C0938a.m5002a("SR/SoundRecorder", "<onClick>,mState = " + this.f5435p);
                        int i3 = this.f5435p;
                        if (i3 == 2) {
                            RecordService.C1445b bVar = this.f5401U;
                            if (bVar != null) {
                                bVar.mo6349j();
                                C1288b bVar2 = this.f5396P;
                                if (bVar2 != null) {
                                    bVar2.removeMessages(1);
                                    if (C1413m.m6844f()) {
                                        this.f5392L.setRecordState(false);
                                    } else if (m6595L()) {
                                        this.f5391K.setRecordState(false);
                                    } else {
                                        this.f5392L.setRecordState(false);
                                    }
                                }
                                try {
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("button_name", "2");
                                    C1390G.m6779b("A107|1|1|10", hashMap3);
                                    return;
                                } catch (Exception e3) {
                                    C0938a.m5004b("SR/SoundRecorder", "A107|1|1|10Vcode error:" + e3);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (i3 == 0) {
                            if (this.f5427l) {
                                m6656s();
                            }
                            if (this.f5421i && this.f5453y != -1) {
                                this.f5425k = false;
                            }
                            try {
                                str = this.f5399S.mo6179j();
                            } catch (Exception e4) {
                                C0938a.m5004b("SR/SoundRecorder", "<onClick>,SoundRecorder onClick reminderType = " + e4);
                            }
                            if (str.equals("0")) {
                                C0938a.m5002a("SR/SoundRecorder", "<onClick>,SoundRecorder onClick reminderType = " + str);
                                this.f5415f = "audio/amr";
                            } else {
                                C0938a.m5002a("SR/SoundRecorder", "<onClick>,SoundRecorder onClick reminderType = " + str);
                                this.f5415f = "audio/aac_mp4";
                            }
                            C0938a.m5002a("SR/SoundRecorder", "<onClick>,SoundRecorder mRequestType = " + this.f5415f);
                            m6663v();
                            try {
                                this.f5401U.mo6338a(this.f5453y, -1);
                                this.f5401U.mo6336a(1, this.f5415f, this.f5411d, false);
                                if (this.f5422ia) {
                                    this.f5422ia = false;
                                }
                                ArrayList<C0937a> arrayList = this.f5382B;
                                if (arrayList != null && arrayList.size() > 0) {
                                    C0938a.m5002a("SR/SoundRecorder", "<onClick>, mMarkItemsList != null, mMarkItemsList.clear()!");
                                    this.f5382B.clear();
                                    this.f5426ka.mo3271c();
                                    return;
                                }
                                return;
                            } catch (RuntimeException e5) {
                                C0938a.m5004b("SR/SoundRecorder", "<onClick>, RuntimeException = " + e5);
                                return;
                            }
                        } else if (i3 == 4) {
                            RecordService.C1445b bVar3 = this.f5401U;
                            if (bVar3 != null) {
                                bVar3.mo6351l();
                            }
                            m6656s();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        C1425w wVar3 = this.f5399S;
                        mo5959a(wVar3.mo6158a(wVar3.mo6173f()));
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6615a(bundle);
        m6587D();
        m6585B();
        m6588E();
        m6601R();
        m6627b(getIntent());
        m6666x();
        m6602S();
        mo5978o();
        mo5976m();
        m6594K();
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        C0938a.m5002a("SR/SoundRecorder", "Load new name: <onCreateLoader>");
        return new C1382a(i, this.f5389I);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C0938a.m5006c("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onDestroy");
        m6659t();
        ServiceConnection serviceConnection = this.f5403W;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        C0938a.m5002a("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onNewIntent");
        m6632c(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C0938a.m5006c("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onPause");
        if (this.f5396P != null) {
            if (C1413m.m6844f()) {
                this.f5392L.setRecordState(false);
            } else if (m6595L()) {
                this.f5391K.setRecordState(false);
            } else {
                this.f5392L.setRecordState(false);
            }
        }
        if (isFinishing()) {
            f5379a = false;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        if (iArr.length != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("android.permission.RECORD_AUDIO", 0);
            hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", 0);
            if (i == 101) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (((Integer) hashMap.get("android.permission.RECORD_AUDIO")).intValue() == -1) {
                    str = C1882a.f6747d + getString(R.string.permission_microphone);
                } else {
                    str = C1882a.f6747d;
                }
                if (((Integer) hashMap.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == -1) {
                    if (!str.equals(C1882a.f6747d)) {
                        str = str + ", ";
                    }
                    str = str + getString(R.string.permission_storage);
                }
                if (!str.equals(C1882a.f6747d)) {
                    mo5962a(str, (Activity) this);
                    this.f5423j = true;
                }
            }
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        ArrayList<C0937a> arrayList;
        super.onRestoreInstanceState(bundle);
        C0938a.m5002a("SR/SoundRecorder", "<onRestoreInstanceState(" + bundle + ")>");
        if (bundle != null && (arrayList = (ArrayList) bundle.getSerializable("MARKLIST")) != null && arrayList.size() > 0) {
            this.f5382B = arrayList;
            this.f5426ka.mo5056a((List<C0937a>) this.f5382B);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C0938a.m5006c("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onResume");
        if (!this.f5423j) {
            m6590G();
            mo5970g();
            m6671z();
            mo5977n();
            mo5972i();
            m6613a(this.f5442sa);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("MARKLIST", this.f5382B);
        bundle.putInt("save_state", this.f5435p);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        C0938a.m5006c("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStart");
        f5379a = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C0938a.m5006c("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStop");
        m6591H();
        m6664w();
        this.f5417g = false;
        AlertDialog alertDialog = this.f5383C;
        if (alertDialog == null || !alertDialog.isShowing()) {
            m6603T();
        }
    }

    /* renamed from: com.android.activity.SoundRecorder$f */
    public class C1292f {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public ImageView f5471a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int[] f5472b;

        /* renamed from: c */
        private int[] f5473c;

        public C1292f(ImageView imageView, int[] iArr, int[] iArr2) {
            this.f5471a = imageView;
            this.f5473c = iArr2;
            this.f5472b = iArr;
            this.f5471a.setImageResource(this.f5472b[0]);
            m6701a(0);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6701a(int i) {
            this.f5471a.postDelayed(new C1337jb(this, i), (long) this.f5473c[i]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m6656s() {
        if (Build.VERSION.SDK_INT >= 26 && this.f5405Y.getRingerMode() != 0) {
            this.f5432na.vibrate(VibrationEffect.createOneShot(12, 75));
        }
    }

    /* renamed from: t */
    private void m6659t() {
        C0938a.m5002a("SR/SoundRecorder", "destroyObjects().");
        if (this.f5397Q != null) {
            C0900b.m4902a(this.f5389I).mo4899a((BroadcastReceiver) this.f5397Q);
            this.f5397Q = null;
        }
        BroadcastReceiver broadcastReceiver = this.f5398R;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f5398R = null;
        }
        mo5995q();
        RecordPageAddMarkReceiver recordPageAddMarkReceiver = this.f5430ma;
        if (recordPageAddMarkReceiver != null) {
            unregisterReceiver(recordPageAddMarkReceiver);
            this.f5430ma = null;
        }
        if (this.f5400T != null && mo5973j()) {
            this.f5400T.dismiss();
            this.f5427l = false;
        }
        AlertDialog alertDialog = this.f5383C;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f5383C.getButton(-1).performClick();
        }
        C1288b bVar = this.f5396P;
        if (bVar != null) {
            bVar.removeMessages(0);
            this.f5396P.removeMessages(1);
            if (C1413m.m6844f()) {
                this.f5392L.setRecordState(false);
            } else if (m6595L()) {
                this.f5391K.setRecordState(false);
            } else {
                this.f5392L.setRecordState(false);
            }
        }
        C1425w wVar = this.f5399S;
        if (wVar != null) {
            wVar.mo6189t();
            this.f5399S = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m6661u() {
        if (this.f5435p == 0) {
            this.f5386F.setEnabled(false);
            this.f5385E.setEnabled(false);
        }
    }

    /* renamed from: v */
    private void m6663v() {
        this.f5386F.setEnabled(true);
        this.f5385E.setEnabled(true);
    }

    /* renamed from: w */
    private void m6664w() {
        C0938a.m5002a("SR/SoundRecorder", "<onStop>,messageAddRecorder = " + this.f5427l);
        if (this.f5427l) {
            C0938a.m5002a("SR/SoundRecorder", "<onStop>,mState = " + this.f5435p);
            if (this.f5435p != 0) {
                m6604U();
            }
        }
    }

    /* renamed from: x */
    private void m6666x() {
        if (C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", this)) {
            C0927a.m4982a().mo5050a(new C1306Za(this), 0);
        }
    }

    /* renamed from: y */
    private void m6669y() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f5381A;
        if (currentTimeMillis - j > 200 || j == 0) {
            this.f5381A = currentTimeMillis;
            AudioManager audioManager = this.f5405Y;
            if (audioManager != null) {
                if (this.f5414ea) {
                    audioManager.setParameters("audio_recordaec_enable=0");
                    this.f5410ca.setImageResource(R.drawable.btn_aec_off_selector);
                    this.f5414ea = false;
                    C1492b.m7433a((Context) AppFeature.m6734b(), getResources().getString(R.string.aec_close), 0);
                } else {
                    audioManager.setParameters("audio_recordaec_enable=1");
                    this.f5410ca.setImageResource(R.drawable.btn_aec_on_selector);
                    this.f5414ea = true;
                    C1492b.m7433a((Context) AppFeature.m6734b(), getResources().getString(R.string.aec_open), 0);
                }
                C1387D.m6763a(this.f5414ea);
            }
        }
    }

    /* renamed from: z */
    private void m6671z() {
        f5380b = false;
        RecordService.C1445b bVar = this.f5401U;
        if (bVar != null) {
            bVar.mo6335a();
        }
    }

    /* renamed from: f */
    public void mo5969f() {
        this.f5416fa.setVisibility(0);
        this.f5416fa.setImageBitmap(C1413m.f5711i);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f5416fa, "translationY", new float[]{0.0f, -((float) C1413m.f5711i.getHeight())}).setDuration(350);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f5416fa, "alpha", new float[]{1.0f, 0.9f, 0.8f, 0.7f, 0.55f, 0.35f, 0.2f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}).setDuration(350);
        duration.start();
        duration2.start();
        long j = (long) 240;
        ObjectAnimator.ofFloat(this.f5386F, "alpha", new float[]{0.0f, 1.0f}).setDuration(j).start();
        ObjectAnimator.ofFloat(this.f5384D, "alpha", new float[]{0.0f, 1.0f}).setDuration(j).start();
        ObjectAnimator.ofFloat(this.f5385E, "alpha", new float[]{0.0f, 1.0f}).setDuration(j).start();
        this.f5384D.getTexView().setText(getResources().getString(R.string.pause));
        duration.addListener(new C1298Va(this));
    }

    /* renamed from: g */
    public void mo5970g() {
        if (!C1424v.m6870a("android.permission.RECORD_AUDIO", this) || !C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", this)) {
            this.f5384D.setClickable(false);
            this.f5385E.setClickable(false);
            C0938a.m5002a("SR/SoundRecorder", "set button can not clickable");
            return;
        }
        this.f5384D.setClickable(true);
        this.f5385E.setClickable(true);
        C0938a.m5002a("SR/SoundRecorder", "<onResume>: initLoader()");
        C0938a.m5002a("SR/SoundRecorder", "set button clickable");
    }

    /* renamed from: h */
    public int mo5971h() {
        return getSharedPreferences("setNightModeChangeVolumeValue", 0).getInt("vol", 0);
    }

    /* renamed from: i */
    public void mo5972i() {
        int i = this.f5435p;
        if (i == 2) {
            this.f5396P.sendEmptyMessage(1);
            try {
                if (C1413m.m6844f()) {
                    this.f5392L.setRecordState(true);
                } else if (m6595L()) {
                    this.f5391K.setRecordState(true);
                } else {
                    this.f5392L.setRecordState(true);
                }
            } catch (Exception unused) {
                C0938a.m5004b("SR/SoundRecorder", "onResume() RecordView or RecognizeVoiceView error:");
            }
        } else if (i == 4) {
            try {
                if (C1413m.m6844f()) {
                    this.f5392L.setRecordState(false);
                } else if (m6595L()) {
                    this.f5391K.setRecordState(false);
                } else {
                    this.f5392L.setRecordState(false);
                }
            } catch (Exception unused2) {
                C0938a.m5004b("SR/SoundRecorder", "onResume() RecordView or RecognizeVoiceView error:");
            }
        }
    }

    /* renamed from: j */
    public boolean mo5973j() {
        return !isDestroyed() && !isFinishing();
    }

    /* renamed from: k */
    public /* synthetic */ void mo5974k() {
        this.f5426ka.mo3271c();
    }

    /* renamed from: l */
    public void mo5975l() {
        new C1292f(this.f5384D.getmImageView(), new int[]{R.drawable.iqoo_btn_play_15, R.drawable.iqoo_btn_play_14, R.drawable.iqoo_btn_play_13, R.drawable.iqoo_btn_play_12, R.drawable.iqoo_btn_play_11, R.drawable.iqoo_btn_play_10, R.drawable.iqoo_btn_play_9, R.drawable.iqoo_btn_play_8, R.drawable.iqoo_btn_play_7, R.drawable.iqoo_btn_play_6, R.drawable.iqoo_btn_play_5, R.drawable.iqoo_btn_play_4, R.drawable.iqoo_btn_play_3, R.drawable.iqoo_btn_play_2, R.drawable.iqoo_btn_play_1, R.drawable.iqoo_btn_play_0}, new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3});
    }

    /* renamed from: m */
    public void mo5976m() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.activity.SoundRecorder.MARKRECEIVER");
        registerReceiver(this.f5430ma, intentFilter);
    }

    /* renamed from: n */
    public void mo5977n() {
        this.f5394N.postDelayed(new C1273Qa(this, new String[]{"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"}), 300);
    }

    /* renamed from: o */
    public void mo5978o() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (AppFeature.f5621q) {
            registerReceiver(this.f5428la, intentFilter);
        }
    }

    /* renamed from: p */
    public void mo5994p() {
        this.f5411d = this.f5389I.getString(R.string.new_recording) + " " + C1398b.m6805a();
        C1413m.f5726x = this.f5411d;
    }

    /* renamed from: q */
    public void mo5995q() {
        ScreenBroadcastReceiver screenBroadcastReceiver;
        if (AppFeature.f5621q && (screenBroadcastReceiver = this.f5428la) != null) {
            unregisterReceiver(screenBroadcastReceiver);
            this.f5428la = null;
        }
    }

    /* renamed from: r */
    public void mo5996r() {
        Message obtainMessage = this.f5396P.obtainMessage(1);
        this.f5396P.removeMessages(1);
        this.f5396P.sendMessageDelayed(obtainMessage, 16);
        RecordService.C1445b bVar = this.f5401U;
        if (bVar != null) {
            this.f5441s = (float) bVar.mo6344e();
            this.f5443t = this.f5401U.mo6348i();
        }
        if (C1413m.m6844f()) {
            this.f5392L.mo6498a(this.f5443t, this.f5431n);
            this.f5392L.mo6500b(this.f5441s);
        } else if (m6595L()) {
            this.f5391K.mo6585a(this.f5443t, this.f5431n);
            this.f5391K.mo6586b(this.f5441s);
        } else {
            this.f5392L.mo6498a(this.f5443t, this.f5431n);
            this.f5392L.mo6500b(this.f5441s);
        }
        this.f5431n = false;
    }

    /* renamed from: d */
    private void m6637d(int i) {
        C0938a.m5002a("SR/SoundRecorder", "<setWaveFormUpdate>,frequency = " + i);
        if (this.f5435p == 2) {
            if (this.f5396P == null) {
                this.f5396P = new C1288b(this, (C1296Ua) null);
            }
            if (C1413m.m6844f()) {
                RecordView recordView = this.f5392L;
                if (recordView != null) {
                    recordView.setRecordState(true);
                } else {
                    return;
                }
            } else if (m6595L()) {
                XRecordView xRecordView = this.f5391K;
                if (xRecordView != null) {
                    xRecordView.setRecordState(true);
                } else {
                    return;
                }
            } else {
                RecordView recordView2 = this.f5392L;
                if (recordView2 != null) {
                    recordView2.setRecordState(true);
                } else {
                    return;
                }
            }
            mo5996r();
        }
    }

    /* renamed from: e */
    public void mo5968e() {
        this.f5416fa.setVisibility(0);
        this.f5416fa.setImageBitmap(C1413m.f5711i);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f5416fa, "translationY", new float[]{-((float) C1413m.f5711i.getHeight()), 0.0f}).setDuration(240);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f5416fa, "alpha", new float[]{0.0f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f}).setDuration(240);
        duration.start();
        duration2.start();
        long j = (long) 160;
        ObjectAnimator.ofFloat(this.f5436pa, "alpha", new float[]{1.0f, 0.9f, 0.8f, 0.7f, 0.6f, 0.5f, 0.4f, 0.3f, 0.2f, 0.0f}).setDuration(j).start();
        ObjectAnimator.ofFloat(this.f5438qa, "alpha", new float[]{1.0f, 0.0f}).setDuration(j).start();
        duration.addListener(new C1302Xa(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6632c(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("com.vivo.smartkey.SOUNDRECORDER_EXTRA");
            String action = intent.getAction();
            if (stringExtra != null && (intent.getFlags() & 1048576) == 0) {
                C0938a.m5002a("SR/SoundRecorder", "<parseQuickStartIntent>, smartkey makes the recorder record");
                if (!C1400d.m6806a().mo6136b()) {
                    if (!C1424v.m6870a("android.permission.RECORD_AUDIO", this) || !C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", this)) {
                        C1492b.m7431a((Context) this, (CharSequence) getString(R.string.unable_quick_start), 0).show();
                        finish();
                        return;
                    }
                    this.f5419h = true;
                    if (this.f5401U != null && !this.f5433o.booleanValue()) {
                        onClick(this.f5384D);
                        m6622a(true);
                        this.f5401U.mo6340a(this.f5406Z.isKeyguardLocked());
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("from", "1");
                            C1390G.m6779b("A107|7|2|7", hashMap);
                        } catch (Exception unused) {
                            C0938a.m5004b("SR/SoundRecorder", "vcode error");
                        }
                    }
                } else {
                    return;
                }
            }
            if (action != null && action.equals("com.record.finish.soundrecord")) {
                m6604U();
                C0927a.m4982a().mo5050a(new C1271Pa(this), 0);
            }
        }
    }

    /* renamed from: b */
    private void m6627b(Intent intent) {
        String action = intent.getAction();
        C0938a.m5002a("SR/SoundRecorder", "<parseNormalIntent>,getAction =" + action);
        if ("android.provider.MediaStore.RECORD_SOUND".equals(action) || "android.intent.action.GET_CONTENT".equals(action) || "android.intent.action.PICK".equals(action)) {
            String type = intent.getType();
            C0938a.m5002a("SR/SoundRecorder", "<parseNormalIntent>,getType =" + type);
            if (type != null) {
                if (type.equals("audio/mp4") || type.equals("audio/amr") || type.equals("audio/evrc") || type.equals("audio/qcelp") || type.equals("audio/aac_mp4") || type.equals("audio/*") || type.equals("*/*")) {
                    this.f5415f = "audio/aac_mp4";
                } else {
                    setResult(0);
                    finish();
                    return;
                }
            }
            String O = m6598O();
            C0938a.m5002a("SR/SoundRecorder", "<parseNormalIntent>, referrerStr: " + O);
            if (O == null || !O.contains("com.vivo.easyshare")) {
                this.f5427l = true;
                m6661u();
            } else {
                m6661u();
            }
            this.f5453y = intent.getLongExtra("android.provider.MediaStore.extra.MAX_BYTES", -1);
            long j = this.f5453y;
            if (-1 == j) {
                this.f5421i = false;
            } else if (j > 2048) {
                this.f5421i = true;
            } else {
                this.f5453y = -1;
                this.f5421i = false;
                setResult(0);
                finish();
                return;
            }
            C0938a.m5006c("SR/SoundRecorder", "<parseNormalIntent>,mMaxFileSize = " + this.f5453y + ",mHasFileSizeLimitation = " + this.f5421i + ",messageAddRecorder = " + this.f5427l);
        }
    }

    /* renamed from: com.android.activity.SoundRecorder$a */
    private class C1287a extends AsyncTask<Boolean, Void, Integer> {

        /* renamed from: a */
        private Cursor f5459a;

        /* renamed from: b */
        private String f5460b;

        /* renamed from: c */
        private File f5461c;

        /* renamed from: d */
        private String f5462d;

        /* renamed from: e */
        private boolean f5463e;

        /* renamed from: f */
        private String f5464f;

        /* renamed from: g */
        private boolean f5465g;

        private C1287a() {
            this.f5460b = ".m4a";
            this.f5461c = SoundRecorder.this.f5401U.mo6347h();
            this.f5463e = false;
            this.f5464f = null;
            this.f5465g = false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Integer doInBackground(Boolean... boolArr) {
            String str;
            this.f5459a = C1426x.m6909a(SoundRecorder.this.f5389I).mo6192a(false);
            if (C1426x.m6908a(this.f5459a, SoundRecorder.this.f5411d + this.f5460b) > 0) {
                this.f5465g = false;
                SoundRecorder.this.m6614a(this.f5459a);
                return -1;
            }
            this.f5465g = true;
            if (SoundRecorder.this.f5411d != null && SoundRecorder.this.f5411d.length() > 0 && SoundRecorder.this.f5411d.getBytes().length <= C1383b.f5641d && this.f5465g) {
                if (!this.f5461c.exists()) {
                    return -2;
                }
                SoundRecorder.this.f5401U.mo6352m();
                long unused = SoundRecorder.this.f5455z = 0;
                if (AppFeature.f5615k) {
                    str = SoundRecorder.this.f5399S.mo6171e() + File.separator;
                } else {
                    String str2 = this.f5462d;
                    str = str2.substring(0, C1383b.m6740a(str2, File.separatorChar, 2) + 1);
                }
                this.f5464f = str + SoundRecorder.this.f5411d + this.f5460b;
                String str3 = this.f5464f;
                File file = new File(str3);
                C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>,newFilePath = " + this.f5464f);
                if (this.f5462d.equalsIgnoreCase(this.f5464f)) {
                    File file2 = new File(this.f5462d + Long.toString(C1383b.m6742b(this.f5462d)));
                    this.f5461c.renameTo(file2);
                    this.f5463e = file2.renameTo(file);
                    C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, sampleFile != null equalsIgnoreCase bool: " + this.f5463e);
                } else if (file.exists()) {
                    C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, sampleFile != null exists");
                    SoundRecorder.this.m6614a(this.f5459a);
                    return -3;
                } else {
                    this.f5463e = this.f5461c.renameTo(file);
                    C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, sampleFile != null renameTo bool: " + this.f5463e);
                }
                if (this.f5463e) {
                    SoundRecorder.this.f5401U.mo6339a(file);
                    SoundRecorder.this.m6621a(str3);
                    long unused2 = SoundRecorder.this.f5445u = SystemClock.uptimeMillis();
                    SoundRecorder.this.m6608Y();
                }
                SoundRecorder.this.m6607X();
                SoundRecorder.this.m6614a(this.f5459a);
            }
            return 1;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntryNow>");
            if (SoundRecorder.this.f5411d == null) {
                C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntryNow> mTempFileName is null");
                return;
            }
            File h = SoundRecorder.this.f5401U.mo6347h();
            if (h == null) {
                C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntryNow> sampleFile is null");
                return;
            }
            C1413m.f5726x = SoundRecorder.this.f5411d;
            this.f5462d = h.getAbsolutePath();
        }

        /* synthetic */ C1287a(SoundRecorder soundRecorder, C1296Ua ua) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            if (-1 == num.intValue()) {
                SoundRecorder.this.mo5994p();
            } else if (-2 == num.intValue()) {
                SoundRecorder.this.f5401U.mo6350k();
                C1492b.m7434a(SoundRecorder.this.getString(R.string.file_rename_not_exit));
                SoundRecorder.this.finish();
                SoundRecorder.this.overridePendingTransition(0, 0);
            } else if (-3 == num.intValue()) {
                SoundRecorder.this.f5388H.setText(SoundRecorder.this.getString(R.string.tip));
                SoundRecorder.this.f5388H.setTextColor(-65536);
                SoundRecorder.this.f5390J.selectAll();
            } else if (1 != num.intValue()) {
            } else {
                if (C1413m.f5711i != null) {
                    C1413m.f5712j = 0;
                    SoundRecorder.this.mo5966c();
                    return;
                }
                C1413m.f5712j = 0;
                SoundRecorder.this.finish();
                SoundRecorder.this.startActivity(new Intent(SoundRecorder.this, ReclistActivity.class));
            }
        }
    }

    /* renamed from: a */
    private void m6615a(Bundle bundle) {
        C0938a.m5006c("SR/SoundRecorder", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onCreate");
        setVolumeControlStream(3);
        this.f5405Y = (AudioManager) getSystemService("audio");
        this.f5406Z = (KeyguardManager) getSystemService(KeyguardManager.class);
        this.f5389I = getApplicationContext();
        this.f5429m = false;
        getWindow().clearFlags(67108864);
        if (bundle != null) {
            this.f5435p = bundle.getInt("save_state");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5432na = (Vibrator) getSystemService("vibrator");
        }
        this.f5442sa = getIntent();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6639d(String str) {
        String f = C1383b.m6746f(this.f5390J.getText().toString());
        C0938a.m5002a("SR/SoundRecorder", "<setEntryName> after removeIllChar: " + f);
        if (f == null || f.length() <= 0) {
            this.f5390J.setText(str);
            return;
        }
        String trim = f.trim();
        if (trim == null || trim.length() <= 0) {
            this.f5390J.setText(str);
        } else {
            this.f5390J.setText(trim);
        }
    }

    /* renamed from: a */
    private void m6622a(boolean z) {
        if (C1413m.m6844f()) {
            if (z) {
                this.f5384D.mo6533a(getResources().getString(R.string.pause), (int) R.drawable.iqoo_btn_play_15, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
            } else {
                this.f5384D.mo6533a(getResources().getString(R.string.manager_title), (int) R.drawable.iqoo_btn_play_0, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
            }
        } else if (z) {
            this.f5384D.mo6533a(getResources().getString(R.string.pause), (int) R.drawable.btn_play_15, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
        } else {
            this.f5384D.mo6533a(getResources().getString(R.string.manager_title), (int) R.drawable.btn_play_0, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6631c(int i) {
        XRecordView xRecordView;
        C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,state = " + i);
        this.f5435p = i;
        m6606W();
        if (i == 0) {
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_IDLE");
            m6622a(false);
            this.f5385E.setEnabled(true);
            C1288b bVar = this.f5396P;
            if (bVar != null) {
                bVar.removeMessages(1);
                try {
                    if (C1413m.m6844f()) {
                        this.f5392L.setRecordState(false);
                    } else if (m6595L()) {
                        this.f5391K.setRecordState(false);
                    } else {
                        this.f5392L.setRecordState(false);
                    }
                } catch (Exception unused) {
                    C0938a.m5004b("SR/SoundRecorder", "setState() RecordView or RecognizeVoiceView error:");
                }
            }
            if (this.f5425k) {
                C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,fileSizeSet = " + this.f5425k);
                this.f5425k = false;
                this.f5453y = -1;
                this.f5409c = getResources().getString(R.string.max_filesize_reached);
                C1492b.m7431a((Context) this, (CharSequence) this.f5409c, 0).show();
            }
        } else if (i == 1) {
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_CREATED");
            m6622a(true);
        } else if (i == 2) {
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_STARTED");
            m6622a(true);
            if (C1411k.m6820b(this)) {
                TwoStateLayout twoStateLayout = this.f5384D;
                twoStateLayout.setContentDescription(getResources().getString(R.string.pause) + "," + getResources().getString(R.string.button_talkback));
            }
            m6637d(16);
            if (!this.f5427l) {
                this.f5386F.setEnabled(true);
            } else {
                this.f5385E.setEnabled(true);
            }
        } else if (i == 3) {
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_STOPPED");
            m6622a(false);
            if (C1413m.m6844f()) {
                mo5975l();
            }
            C0938a.m5002a("SR/SoundRecorder", "RecordState.RECORDER_STOPPED:preventAnimationOOMReverse()");
            if (m6595L() && (xRecordView = this.f5391K) != null) {
                xRecordView.mo6584a();
            }
            this.f5441s = 0.0f;
            this.f5443t = 0;
            C1288b bVar2 = this.f5396P;
            if (bVar2 != null) {
                bVar2.removeMessages(1);
                try {
                    if (C1413m.m6844f()) {
                        this.f5392L.setRecordState(false);
                    } else if (m6595L()) {
                        this.f5391K.setRecordState(false);
                    } else {
                        this.f5392L.setRecordState(false);
                    }
                } catch (Exception unused2) {
                    C0938a.m5004b("SR/SoundRecorder", "setState() RecordView or RecognizeVoiceView error:");
                }
            }
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_STOPED");
        } else if (i == 4) {
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_PAUSED");
            this.f5407aa = mo5971h();
            mo5965b(this.f5407aa);
            C0938a.m5002a("SR/SoundRecorder", "<onStateChanged>,RECORDER_PAUSED");
            m6622a(false);
            C0938a.m5002a("SR/SoundRecorder", "RecordState.RECORDER_PAUSED:preventAnimationOOMReverse()");
            if (C1411k.m6820b(this)) {
                TwoStateLayout twoStateLayout2 = this.f5384D;
                twoStateLayout2.setContentDescription(getResources().getString(R.string.manager_title) + "," + getResources().getString(R.string.button_talkback));
            }
            C1288b bVar3 = this.f5396P;
            if (bVar3 != null) {
                bVar3.removeMessages(1);
                try {
                    if (C1413m.m6844f()) {
                        this.f5392L.setRecordState(false);
                    } else if (m6595L()) {
                        this.f5391K.setRecordState(false);
                    } else {
                        this.f5392L.setRecordState(false);
                    }
                } catch (Exception unused3) {
                    C0938a.m5004b("SR/SoundRecorder", "setState() RecordView or RecognizeVoiceView error:");
                }
            }
        }
    }

    /* renamed from: d */
    public void mo5967d() {
        this.f5416fa.setVisibility(0);
        this.f5416fa.setImageBitmap(C1413m.f5711i);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f5416fa, "translationY", new float[]{-((float) C1413m.f5711i.getHeight()), 0.0f}).setDuration(240);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f5416fa, "alpha", new float[]{0.0f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f}).setDuration(240);
        duration.start();
        duration2.start();
        long j = (long) 240;
        ObjectAnimator.ofFloat(this.f5436pa, "alpha", new float[]{1.0f, 0.9f, 0.8f, 0.7f, 0.6f, 0.5f, 0.4f, 0.3f, 0.2f, 0.0f}).setDuration(j).start();
        LinearLayout linearLayout = this.f5438qa;
        ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{0.0f, (float) ((linearLayout.getMeasuredHeight() - this.f5384D.getmImageViewHeight()) - C1413m.m6828a(27, this.f5389I))}).setDuration(j).start();
        ObjectAnimator.ofFloat(this.f5438qa, "alpha", new float[]{1.0f, 0.0f}).setDuration(j).start();
        duration.addListener(new C1304Ya(this));
    }

    /* renamed from: a */
    public void mo5960a(DialogInterface dialogInterface, boolean z) {
        C0938a.m5002a("SR/SoundRecorder", "<checkDialogExit(DialogInterface dialogRename, " + z + ")>");
        if (dialogInterface != null) {
            try {
                Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                declaredField.setAccessible(true);
                declaredField.set(dialogInterface, Boolean.valueOf(z));
                if (mo5973j()) {
                    dialogInterface.dismiss();
                }
            } catch (Exception e) {
                C0938a.m5004b("SR/SoundRecorder", "<checkDialogExit>,Exception = " + e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6629b(String str) {
        C0938a.m5002a("SR/SoundRecorder", "<checkSavedInMediaDatebase>,filenamePrefixFullName = " + str);
        if (!this.f5427l || this.f5401U == null) {
            C0938a.m5002a("SR/SoundRecorder", "<checkSavedInMediaDatebase>,mServiceController == null " + this.f5427l);
            this.f5401U.mo6353n();
            return;
        }
        this.f5417g = true;
        m6635c(str + this.f5401U.mo6343d());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6626b(DialogInterface dialogInterface) {
        try {
            Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
            boolean z = true;
            declaredField.setAccessible(true);
            if (m6592I()) {
                z = false;
            }
            declaredField.set(dialogInterface, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5963a(DialogInterface dialogInterface) {
        boolean z;
        C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry(DialogInterface dialogRename)>");
        String obj = this.f5390J.getText().toString();
        if (obj == null) {
            return true;
        }
        Cursor a = C1426x.m6909a(this.f5389I).mo6192a(false);
        File h = this.f5401U.mo6347h();
        if (h == null) {
            m6614a(a);
            return true;
        }
        String absolutePath = h.getAbsolutePath();
        C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>,title = " + obj);
        if (obj.length() == 0) {
            this.f5388H.setTextColor(-65536);
            this.f5388H.setText(R.string.rename_not_support_null);
            mo5960a(dialogInterface, false);
        } else {
            if (C1426x.m6908a(a, obj + ".m4a") > 0) {
                C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, already have the file: " + obj);
                this.f5388H.setText(getString(R.string.tip));
                this.f5388H.setTextColor(-65536);
                this.f5390J.selectAll();
                mo5960a(dialogInterface, false);
            } else if (obj.startsWith(".")) {
                this.f5388H.setTextColor(-65536);
                this.f5388H.setText(R.string.errorNameStartWidthDot);
                mo5960a(dialogInterface, false);
            } else if (C1383b.m6745e(obj)) {
                this.f5388H.setTextColor(-65536);
                this.f5388H.setText(R.string.errorFileNameAllSpaces);
                mo5960a(dialogInterface, false);
            } else if (obj.getBytes().length > C1383b.f5641d) {
                C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>,INPUT_CHAR_MAX_LENGTH = " + C1383b.f5641d);
                mo5960a(dialogInterface, false);
            } else if (C1383b.m6744d(obj)) {
                if (!isFinishing()) {
                    new AlertDialog.Builder(this).setPositiveButton(R.string.autofilter, new C1265Ma(this, dialogInterface)).setNegativeButton(R.string.revise_byoneself, new C1263La(this)).setTitle(R.string.illchartip).setMessage(getString(R.string.illcharmessage)).show().setOwnerActivity(this);
                    mo5960a(dialogInterface, false);
                } else {
                    m6639d(this.f5411d);
                    mo5963a(dialogInterface);
                }
            } else if (C1383b.m6741a(obj)) {
                this.f5388H.setTextColor(-65536);
                this.f5388H.setText(R.string.rename_not_support_emoji);
                mo5960a(dialogInterface, false);
            } else if (obj != null && obj.length() > 0 && obj.getBytes().length <= C1383b.f5641d) {
                if (C1426x.m6908a(a, obj + ".m4a") == -1) {
                    if (!h.exists()) {
                        C1492b.m7431a((Context) this, (CharSequence) getString(R.string.file_rename_not_exit), 0).show();
                        finish();
                        overridePendingTransition(0, 0);
                        mo5960a(dialogInterface, true);
                        dialogInterface.cancel();
                    } else {
                        this.f5401U.mo6352m();
                        this.f5455z = 0;
                        String substring = absolutePath.substring(0, C1383b.m6740a(absolutePath, File.separatorChar, 2) + 1);
                        C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>,suffix=" + ".m4a");
                        String str = substring + obj + ".m4a";
                        File file = new File(str);
                        C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>,newFilePath = " + str);
                        if (absolutePath.equalsIgnoreCase(str)) {
                            File file2 = new File(absolutePath + Long.toString(C1383b.m6742b(absolutePath)));
                            h.renameTo(file2);
                            z = file2.renameTo(file);
                            C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, sampleFile != null --------4----bool: " + z);
                        } else if (file.exists()) {
                            this.f5388H.setText(getString(R.string.tip));
                            this.f5388H.setTextColor(-65536);
                            this.f5390J.selectAll();
                            mo5960a(dialogInterface, false);
                            C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, sampleFile != null ----------2---------");
                            m6614a(a);
                            return true;
                        } else {
                            z = h.renameTo(file);
                            C0938a.m5002a("SR/SoundRecorder", "<fileRenameEntry>, sampleFile != null --------5----bool: " + z);
                        }
                        if (z) {
                            this.f5401U.mo6339a(file);
                            new Thread(new C1267Na(this, str)).start();
                            this.f5445u = SystemClock.uptimeMillis();
                            getLoaderManager().initLoader(1, (Bundle) null, this).forceLoad();
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put("is_rename", "1");
                                C1390G.m6779b("A107|1|3|10", hashMap);
                            } catch (Exception e) {
                                C0938a.m5004b("SR/SoundRecorder", "A107|1|3|10Vcode error:" + e);
                            }
                        }
                        try {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("is_rename", "0");
                            C1390G.m6779b("A107|1|3|10", hashMap2);
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put("mark_num", String.valueOf(this.f5418ga));
                            C1390G.m6779b("A107|1|3|10", hashMap3);
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put("rec_time", String.valueOf(this.f5420ha));
                            C1390G.m6779b("A107|1|3|10", hashMap4);
                        } catch (Exception e2) {
                            C0938a.m5004b("SR/SoundRecorder", "A107|1|3|10Vcode error:" + e2);
                        }
                        if (C1413m.f5711i != null) {
                            C1413m.f5712j = 0;
                            mo5966c();
                        } else {
                            C1413m.f5712j = 0;
                            finish();
                            startActivity(new Intent(this, ReclistActivity.class));
                        }
                        mo5960a(dialogInterface, true);
                        dialogInterface.cancel();
                        m6614a(a);
                        return false;
                    }
                }
            }
        }
        m6614a(a);
        return true;
    }

    /* renamed from: b */
    public void mo5964b() {
        this.f5416fa.setVisibility(0);
        this.f5416fa.setImageBitmap(C1413m.f5711i);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f5416fa, "translationY", new float[]{0.0f, -((float) C1413m.f5711i.getHeight())}).setDuration(350);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f5416fa, "alpha", new float[]{1.0f, 0.9f, 0.8f, 0.7f, 0.55f, 0.35f, 0.2f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}).setDuration(350);
        duration.start();
        duration2.start();
        long j = (long) 240;
        ObjectAnimator.ofFloat(this.f5436pa, "alpha", new float[]{0.0f, 0.3f, 0.5f, 0.7f, 0.9f, 1.0f}).setDuration(j).start();
        this.f5438qa.getMeasuredHeight();
        this.f5384D.getmImageViewHeight();
        C1413m.m6828a(27, this.f5389I);
        ObjectAnimator.ofFloat(this.f5386F, "alpha", new float[]{0.0f, 1.0f}).setDuration(j).start();
        ObjectAnimator.ofFloat(this.f5384D, "alpha", new float[]{0.0f, 1.0f}).setDuration(j).start();
        ObjectAnimator.ofFloat(this.f5385E, "alpha", new float[]{0.0f, 1.0f}).setDuration(j).start();
        this.f5384D.getTexView().setText(getResources().getString(R.string.pause));
        this.f5384D.getmImageView().setImageResource(R.drawable.iqoo_buttonanimation);
        this.f5393M = (AnimationDrawable) this.f5384D.getmImageView().getDrawable();
        this.f5393M.start();
        duration.addListener(new C1300Wa(this));
    }

    /* renamed from: b */
    public void mo5965b(int i) {
        SharedPreferences.Editor edit = getSharedPreferences("setNightModeChangeVolumeValue", 0).edit();
        edit.putInt("vol", i);
        edit.apply();
    }

    /* renamed from: c */
    private void m6635c(String str) {
        this.f5456za = new C1289c(this, (C1296Ua) null);
        this.f5456za.execute(new String[]{str});
    }

    /* renamed from: c */
    public void mo5966c() {
        if (C1413m.m6844f()) {
            mo5967d();
        } else {
            mo5968e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6614a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                C0938a.m5005b("SR/SoundRecorder", "fail to close", th);
            }
        }
    }

    /* renamed from: a */
    private void m6613a(Intent intent) {
        C0938a.m5002a("SR/SoundRecorder", "<parseIntentFromListFragment>");
        if (intent != null) {
            String stringExtra = intent.getStringExtra("startMode");
            if (stringExtra != null && stringExtra.contains("startFromSelf")) {
                C0938a.m5002a("SR/SoundRecorder", "startMode: startFromSelf");
                if (this.f5435p == 0 && !this.f5427l && !C1413m.m6844f()) {
                    this.f5384D.mo6532a(getResources().getString(R.string.pause), R.drawable.btn_play_15);
                }
                this.f5444ta.sendEmptyMessageDelayed(5, 350);
            } else if (!this.f5427l) {
                this.f5444ta.sendEmptyMessageDelayed(6, 350);
            }
        }
    }

    /* renamed from: a */
    public void mo5958a(int i) {
        C0938a.m5002a("SR/SoundRecorder", "<onError>,error = " + i);
        if (i != 0) {
            Resources resources = getResources();
            String str = null;
            switch (i) {
                case 1:
                    String string = resources.getString(R.string.error_space_expired_save);
                    RecordService.C1445b bVar = this.f5401U;
                    if (bVar != null) {
                        if (bVar.mo6347h() != null) {
                            str = this.f5401U.mo6347h().getName().substring(0);
                        }
                        this.f5411d = str;
                    }
                    m6629b(this.f5411d);
                    C1492b.m7431a((Context) this, (CharSequence) string, 0).show();
                    return;
                case 2:
                    C1492b.m7431a((Context) this, (CharSequence) resources.getString(R.string.error_sdcard_access), 0).show();
                    C1425w wVar = this.f5399S;
                    if (wVar != null) {
                        wVar.mo6191v();
                        return;
                    }
                    return;
                case 4:
                    C1492b.m7431a((Context) this, (CharSequence) resources.getString(R.string.error_app_unsupported), 0).show();
                    return;
                case 6:
                    this.f5401U.mo6350k();
                    finish();
                    return;
                case 7:
                    C0938a.m5002a("SR/SoundRecorder", "<onError>,ERROR_INTERNAL_RECORDER_OCCUPIED");
                    C1492b.m7431a((Context) this, (CharSequence) resources.getString(R.string.error_app_recorder_occupied), 0).show();
                    return;
                case 9:
                    if (C1413m.m6844f()) {
                        this.f5392L.mo6499b();
                    } else if (m6595L()) {
                        this.f5391K.mo6584a();
                    } else {
                        this.f5392L.mo6499b();
                    }
                    C0938a.m5002a("SR/SoundRecorder", "<onError>,ERROR_INTERNAL_RECORDER_OCCUPIED");
                    C1492b.m7431a((Context) this, (CharSequence) resources.getString(R.string.savefail), 0).show();
                    return;
                case 10:
                    AlertDialog alertDialog = this.f5383C;
                    if (alertDialog != null && alertDialog.isShowing()) {
                        this.f5383C.getButton(-2).performClick();
                        return;
                    }
                    return;
                case 11:
                    RecordService.C1445b bVar2 = this.f5401U;
                    if (bVar2 != null && bVar2.mo6345f() == 2) {
                        if (this.f5401U.mo6347h() != null) {
                            str = this.f5401U.mo6347h().getName().substring(0);
                        }
                        this.f5411d = str;
                        m6629b(this.f5411d);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6621a(String str) {
        int i;
        ArrayList<C0937a> arrayList;
        C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB> filePath: " + str);
        boolean z = true;
        Cursor cursor = null;
        try {
            Cursor query = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, (String) null);
            if (query == null || query.getCount() != 1) {
                i = -1;
            } else {
                query.moveToFirst();
                i = query.getInt(0);
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e) {
                    C0938a.m5004b("SR/SoundRecorder", "<addMarksToDB> Exception: " + e.toString());
                }
            }
        } catch (Exception e2) {
            C0938a.m5004b("SR/SoundRecorder", "<addMarksToDB> cannot open meida database: " + e2.toString());
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    C0938a.m5004b("SR/SoundRecorder", "<addMarksToDB> Exception: " + e3.toString());
                }
            }
            i = -1;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    C0938a.m5004b("SR/SoundRecorder", "<addMarksToDB> Exception: " + e4.toString());
                }
            }
            throw th;
        }
        C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB> recFileId: " + i);
        C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB> insert start -------- ");
        StringBuilder sb = new StringBuilder();
        sb.append("<addMarksToDB> mDB is null ?");
        if (this.f5404X != null) {
            z = false;
        }
        sb.append(z);
        C0938a.m5002a("SR/SoundRecorder", sb.toString());
        if (!(this.f5404X == null || (arrayList = this.f5382B) == null || arrayList.size() < 0)) {
            int size = this.f5382B.size();
            this.f5418ga = size;
            C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB> mMarksList size: " + size);
            ContentValues contentValues = new ContentValues();
            for (int i2 = 0; i2 < size; i2++) {
                C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB>insert : " + i2);
                if (i != -1) {
                    contentValues.put("_mark_recfile_id", Integer.valueOf(i));
                    contentValues.put("_mark_path", str);
                    contentValues.put("_mark_time_length", Long.valueOf(this.f5382B.get(i2).mo5064b()));
                    contentValues.put("_mark_name", this.f5382B.get(i2).mo5061a());
                }
                try {
                    if (this.f5404X != null) {
                        this.f5404X.mo5341a("recordermarks", contentValues);
                    }
                } catch (Exception e5) {
                    C0938a.m5004b("SR/SoundRecorder", "<addMarksToDB>,Exception = " + e5);
                }
                contentValues.clear();
            }
        }
        C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB> insert end ------- ");
        ArrayList<C0937a> arrayList2 = this.f5382B;
        if (arrayList2 != null && arrayList2.size() > 0) {
            C0938a.m5002a("SR/SoundRecorder", "<addMarksToDB>, mMarksList.clear()!");
            this.f5382B.clear();
            this.f5394N.post(new C1308a(this));
        }
    }

    /* renamed from: a */
    public void mo5959a(long j) {
        C0938a.m5002a("SR/SoundRecorder", "<popClearDialogBoxAndReturn>,tempAvailSdStorage = " + j);
        if (this.f5399S.f5753j && -1 == j) {
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.no_sdcard_or_busy), 0).show();
            this.f5399S.f5753j = false;
        } else if (j <= 5120 && j >= 0) {
            m6597N();
        }
    }

    /* renamed from: a */
    public void mo5962a(String str, Activity activity) {
        new AlertDialog.Builder(activity).setMessage(String.format(C1424v.m6867a(), new Object[]{activity.getString(R.string.app_name), str})).setTitle(R.string.unable_to_use_xx_permissions_title).setCancelable(false).setOnCancelListener(new C1294Ta(this, activity)).setPositiveButton(R.string.permission_dialog_button_go_set, new C1286Sa(this, activity)).setNegativeButton(R.string.cancel, new C1274Ra(this, activity)).create().show();
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        int i;
        if (cursor == null || cursor.getCount() == 0) {
            i = 1;
        } else {
            cursor.moveToFirst();
            int length = (this.f5389I.getString(R.string.new_recording) + " ").length();
            i = 1;
            while (!cursor.isAfterLast()) {
                String string = cursor.getString(0);
                try {
                    int parseInt = Integer.parseInt(string.substring(length, string.length()));
                    if (parseInt != i) {
                        if (parseInt > i) {
                            break;
                        }
                    } else {
                        i++;
                    }
                    cursor.moveToNext();
                } catch (Exception unused) {
                    cursor.moveToNext();
                }
            }
        }
        this.f5411d = this.f5389I.getString(R.string.new_recording) + " " + NumberFormat.getIntegerInstance().format((long) i);
        StringBuilder sb = new StringBuilder();
        sb.append("Load new name: <onLoadFinished> the one is: ");
        sb.append(i);
        C0938a.m5002a("SR/SoundRecorder", sb.toString());
        EditText editText = this.f5390J;
        if (editText != null && editText.getVisibility() == 0 && loader.getId() == 0) {
            this.f5390J.setText(this.f5411d);
            EditText editText2 = this.f5390J;
            editText2.setSelection(editText2.getText().length());
            this.f5390J.selectAll();
        }
        TextView textView = this.f5412da;
        if (textView != null && !this.f5408ba) {
            textView.setText(this.f5411d);
            this.f5408ba = true;
        }
    }

    /* renamed from: a */
    public void mo5957a() {
        if (C1413m.m6844f()) {
            mo5964b();
        } else {
            mo5969f();
        }
    }
}
