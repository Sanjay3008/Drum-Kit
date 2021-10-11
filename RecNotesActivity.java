package com.android.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaExtractor;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.bbksoundrecorder.AppFeature;
import com.android.bbksoundrecorder.R;
import com.android.bbksoundrecorder.filename.C1383b;
import com.android.common.utils.C1384A;
import com.android.common.utils.C1386C;
import com.android.common.utils.C1387D;
import com.android.common.utils.C1390G;
import com.android.common.utils.C1407j;
import com.android.common.utils.C1411k;
import com.android.common.utils.C1413m;
import com.android.common.utils.C1416p;
import com.android.common.utils.C1418q;
import com.android.common.utils.C1419r;
import com.android.common.utils.C1424v;
import com.android.common.utils.C1425w;
import com.android.common.utils.C1426x;
import com.android.common.utils.C1427y;
import com.android.service.PlaybackService;
import com.android.service.RecognizeService;
import com.android.soundspeech.C1465b;
import com.android.soundspeech.C1468d;
import com.android.soundspeech.C1470f;
import com.android.soundspeech.C1472g;
import com.android.soundspeech.p104a.C1464a;
import com.android.view.widget.C1492b;
import com.android.view.widget.CustomViewPager;
import com.android.view.widget.IndicatorSeekBar;
import com.android.view.widget.IndicatorView;
import com.android.view.widget.TwoStateDetailLayout;
import com.vivo.app.VivoContextListDialog;
import com.vivo.common.BbkTitleView;
import com.vivo.easytransfer.C1882a;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p050c.p051a.p052a.p053a.C0927a;
import p050c.p051a.p055c.p056a.C0935b;
import p050c.p051a.p058e.p059a.C0938a;
import p050c.p051a.p060f.C0962T;
import p050c.p051a.p060f.C0989aa;
import p050c.p051a.p060f.p061a.C0974e;
import p050c.p051a.p060f.p061a.C0982k;
import p050c.p051a.p060f.p061a.C0987n;
import p050c.p051a.p062g.p063a.C1018a;
import p050c.p051a.p062g.p063a.C1020b;
import p050c.p051a.p065i.p066a.C1028b;

public class RecNotesActivity extends Activity implements C0974e.C0976b, C0989aa.C0990a, C0987n.C0988a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f5120a = false;

    /* renamed from: A */
    private AlertDialog f5121A = null;
    /* access modifiers changed from: private */

    /* renamed from: Aa */
    public TwoStateDetailLayout f5122Aa;

    /* renamed from: B */
    private AlertDialog f5123B = null;
    /* access modifiers changed from: private */

    /* renamed from: Ba */
    public TwoStateDetailLayout f5124Ba;

    /* renamed from: C */
    private Context f5125C;

    /* renamed from: Ca */
    private TwoStateDetailLayout f5126Ca;

    /* renamed from: D */
    private Bundle f5127D;

    /* renamed from: Da */
    private RelativeLayout f5128Da;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public C1276b f5129E;

    /* renamed from: Ea */
    private String f5130Ea = null;

    /* renamed from: F */
    private C1426x f5131F;

    /* renamed from: Fa */
    private long f5132Fa = 0;

    /* renamed from: G */
    private C1018a f5133G;
    /* access modifiers changed from: private */

    /* renamed from: Ga */
    public boolean f5134Ga = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public C0974e f5135H;

    /* renamed from: Ha */
    private long f5136Ha = 0;

    /* renamed from: I */
    private C0982k f5137I;

    /* renamed from: Ia */
    private View.OnClickListener f5138Ia = new C1236B(this);

    /* renamed from: J */
    private C0987n f5139J;

    /* renamed from: Ja */
    DialogInterface.OnClickListener f5140Ja = new C1238C(this);

    /* renamed from: K */
    private IndicatorView f5141K;

    /* renamed from: Ka */
    DialogInterface.OnClickListener f5142Ka = new C1240D(this);
    /* access modifiers changed from: private */

    /* renamed from: L */
    public PlaybackService.C1442a f5143L;

    /* renamed from: La */
    DialogInterface.OnClickListener f5144La = new C1242E(this);

    /* renamed from: M */
    private C1277c f5145M;

    /* renamed from: Ma */
    DialogInterface.OnClickListener f5146Ma = new C1252G(this);

    /* renamed from: N */
    private ServiceConnection f5147N;

    /* renamed from: Na */
    CompoundButton.OnCheckedChangeListener f5148Na = new C1254H(this);

    /* renamed from: O */
    private TelephonyManager f5149O;

    /* renamed from: Oa */
    DialogInterface.OnClickListener f5150Oa = new C1256I(this);

    /* renamed from: P */
    private int f5151P = 0;

    /* renamed from: Pa */
    DialogInterface.OnClickListener f5152Pa = new C1258J(this);

    /* renamed from: Q */
    private final Handler f5153Q = new Handler();

    /* renamed from: Qa */
    DialogInterface.OnClickListener f5154Qa = new C1260K(this);
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C0989aa f5155R = null;

    /* renamed from: Ra */
    private C1464a f5156Ra = new C1262L(this);

    /* renamed from: S */
    public BbkTitleView f5157S;

    /* renamed from: Sa */
    private Handler f5158Sa = new C1268O(this);

    /* renamed from: T */
    private C1279e f5159T;

    /* renamed from: U */
    private RecognizeService.C1443a f5160U;
    /* access modifiers changed from: private */

    /* renamed from: V */
    public long f5161V = 0;
    /* access modifiers changed from: private */

    /* renamed from: W */
    public ObjectAnimator f5162W;

    /* renamed from: X */
    private boolean f5163X = true;
    /* access modifiers changed from: private */

    /* renamed from: Y */
    public boolean f5164Y = false;
    /* access modifiers changed from: private */

    /* renamed from: Z */
    public boolean f5165Z = false;

    /* renamed from: aa */
    private ScreenBroadcastReceiver f5166aa = new ScreenBroadcastReceiver();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C1425w f5167b = null;

    /* renamed from: ba */
    private RecNotePageAddMarkReceiver f5168ba = new RecNotePageAddMarkReceiver();

    /* renamed from: c */
    private LinearLayout f5169c;
    /* access modifiers changed from: private */

    /* renamed from: ca */
    public VivoContextListDialog f5170ca;

    /* renamed from: d */
    private CustomViewPager f5171d;
    /* access modifiers changed from: private */

    /* renamed from: da */
    public ListPopupWindow f5172da;

    /* renamed from: e */
    private C0962T f5173e;

    /* renamed from: ea */
    private boolean f5174ea = false;

    /* renamed from: f */
    private List<Fragment> f5175f;
    /* access modifiers changed from: private */

    /* renamed from: fa */
    public long f5176fa = 0;

    /* renamed from: g */
    private BroadcastReceiver f5177g = null;

    /* renamed from: ga */
    private View.OnClickListener f5178ga = new C1250F(this);

    /* renamed from: h */
    private BroadcastReceiver f5179h = null;

    /* renamed from: ha */
    private View.OnClickListener f5180ha = new C1270P(this);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f5181i = false;

    /* renamed from: ia */
    private View.OnClickListener f5182ia = new C1272Q(this);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f5183j = false;

    /* renamed from: ja */
    private View.OnClickListener f5184ja = new C1285S(this);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f5185k = false;

    /* renamed from: ka */
    AdapterView.OnItemClickListener f5186ka = new C1293T(this);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f5187l = false;

    /* renamed from: la */
    private DialogInterface.OnClickListener f5188la = new C1299W(this);

    /* renamed from: m */
    private boolean f5189m = false;

    /* renamed from: ma */
    private DialogInterface.OnClickListener f5190ma = new C1347n(this);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f5191n = false;

    /* renamed from: na */
    private DialogInterface.OnClickListener f5192na = new C1350o(this);

    /* renamed from: o */
    public boolean f5193o = true;

    /* renamed from: oa */
    private DialogInterface.OnClickListener f5194oa = new C1353p(this);

    /* renamed from: p */
    private boolean f5195p = false;

    /* renamed from: pa */
    private DialogInterface.OnClickListener f5196pa = new C1356q(this);
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f5197q;
    /* access modifiers changed from: private */

    /* renamed from: qa */
    public boolean f5198qa = false;

    /* renamed from: r */
    private int f5199r = 1;

    /* renamed from: ra */
    private View.OnClickListener f5200ra = new C1359r(this);
    /* access modifiers changed from: private */

    /* renamed from: s */
    public long f5201s;

    /* renamed from: sa */
    private View.OnClickListener f5202sa = new C1362s(this);

    /* renamed from: t */
    private long f5203t = 0;

    /* renamed from: ta */
    private View.OnClickListener f5204ta = new C1365t(this);

    /* renamed from: u */
    private String f5205u;

    /* renamed from: ua */
    private View.OnClickListener f5206ua = new C1369v(this);
    /* access modifiers changed from: private */

    /* renamed from: v */
    public String f5207v;

    /* renamed from: va */
    private TextView f5208va;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public TextView f5209w;

    /* renamed from: wa */
    private TextView f5210wa;

    /* renamed from: x */
    TextView f5211x = null;

    /* renamed from: xa */
    private IndicatorSeekBar f5212xa;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public EditText f5213y = null;
    /* access modifiers changed from: private */

    /* renamed from: ya */
    public TwoStateDetailLayout f5214ya;

    /* renamed from: z */
    private AlertDialog f5215z = null;

    /* renamed from: za */
    private TwoStateDetailLayout f5216za;

    public class RecNotePageAddMarkReceiver extends BroadcastReceiver {
        public RecNotePageAddMarkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("addMark", -1) == 101) {
                RecNotesActivity.this.f5122Aa.performClick();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "1");
                    C1390G.m6779b("A107|8|1|10", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/RecNotesActivity", "vcode error");
                }
                try {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("from", "2");
                    C1390G.m6779b("A107|8|1|10", hashMap2);
                } catch (Exception unused2) {
                    C0938a.m5004b("SR/RecNotesActivity", "vcode error");
                }
            }
        }
    }

    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        public ScreenBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            C0938a.m5002a("SR/RecNotesActivity", "screen operationRecNotes" + action.toString());
            if (C1413m.f5702A != 1 || RecNotesActivity.this.f5143L == null) {
                return;
            }
            if (action.equals("android.intent.action.SCREEN_OFF")) {
                if (RecNotesActivity.this.f5143L.mo6310f() == 3 || RecNotesActivity.this.f5143L.mo6310f() == 4) {
                    RecNotesActivity.this.f5143L.mo6300a(102);
                    RecNotesActivity.this.f5143L.mo6314j();
                }
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                RecNotesActivity.this.f5143L.mo6300a(102);
                RecNotesActivity.this.f5143L.mo6314j();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "2");
                    C1390G.m6779b("A107|8|2|7", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/RecNotesActivity", "vcode error");
                }
            } else if (action.equals("android.intent.action.USER_PRESENT")) {
                RecNotesActivity.this.f5143L.mo6300a(102);
                RecNotesActivity.this.f5143L.mo6299a();
                if ((RecNotesActivity.this.f5143L.mo6310f() == 3 || RecNotesActivity.this.f5143L.mo6310f() == 4) && !ReclistActivity.f5246a) {
                    RecNotesActivity.this.f5143L.mo6300a(102);
                    RecNotesActivity.this.f5143L.mo6314j();
                }
            }
        }
    }

    /* renamed from: com.android.activity.RecNotesActivity$a */
    class C1275a implements Runnable {
        C1275a() {
        }

        public void run() {
            RecNotesActivity.this.m6254F();
        }
    }

    /* renamed from: com.android.activity.RecNotesActivity$b */
    public class C1276b {

        /* renamed from: a */
        public String f5220a = "00:00";

        /* renamed from: b */
        public String f5221b = "00:00";

        /* renamed from: c */
        public LinearLayout f5222c;

        /* renamed from: d */
        public TextView f5223d;

        /* renamed from: e */
        public TextView f5224e;

        /* renamed from: f */
        public IndicatorSeekBar f5225f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public long f5226g = 0;

        /* renamed from: h */
        private long f5227h = 0;

        /* renamed from: i */
        private int f5228i = 0;

        /* renamed from: j */
        private int f5229j = 0;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public boolean f5230k = false;
        /* access modifiers changed from: private */

        /* renamed from: l */
        public List<Long> f5231l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public Handler f5232m = new Handler();
        /* access modifiers changed from: private */

        /* renamed from: n */
        public int f5233n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public int f5234o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public int f5235p;
        /* access modifiers changed from: private */

        /* renamed from: q */
        public String f5236q;
        /* access modifiers changed from: private */

        /* renamed from: r */
        public int f5237r = 0;

        /* renamed from: s */
        private Runnable f5238s = new C1301X(this);

        /* renamed from: t */
        private Handler f5239t = new Handler();

        /* renamed from: u */
        private final Handler f5240u = new Handler();

        /* renamed from: v */
        private Runnable f5241v = new C1305Z(this);
        /* access modifiers changed from: private */

        /* renamed from: w */
        public IndicatorSeekBar.C1485a f5242w = new C1309aa(this);

        public C1276b() {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<MediaPlayerWrapper>,new");
            this.f5231l = new ArrayList();
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public void m6406f() {
            if (this.f5228i == 3 && RecNotesActivity.this.f5143L != null) {
                try {
                    this.f5227h = (long) RecNotesActivity.this.f5143L.mo6306c();
                    if (!this.f5230k) {
                        long j = this.f5227h;
                        if (j > 0) {
                            mo5872a(j, this.f5226g);
                        }
                    }
                    this.f5240u.postDelayed(this.f5241v, 500);
                } catch (Exception e) {
                    e.printStackTrace();
                    this.f5228i = 0;
                }
            }
        }

        /* renamed from: g */
        private void m6407g() {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<updateUi>");
            mo5872a(this.f5227h, this.f5226g);
        }

        /* renamed from: c */
        public void mo5877c() {
            this.f5223d.setText("00:00:00");
            this.f5220a = m6400c(RecNotesActivity.this.f5201s);
            this.f5224e.setText(this.f5220a);
            C0938a.m5002a("SR/MediaPlayerWrapper", "<idleStateProgressUi>,progressBarTotalTimeText = " + this.f5220a);
            this.f5225f.setProgress(0.0f);
        }

        /* renamed from: d */
        public void mo5878d() {
            this.f5240u.removeCallbacks(this.f5241v);
        }

        /* renamed from: e */
        public void mo5879e() {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<setSeekbarMarks> ");
            try {
                if (this.f5231l != null && this.f5231l.size() > 0) {
                    int size = this.f5231l.size();
                    for (int i = 0; i < size; i++) {
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<setSeekbarMarks> markList[" + i + "]: " + this.f5231l.get(i));
                        this.f5225f.setTickPosition((float) ((this.f5231l.get(i).longValue() * 100) / (RecNotesActivity.this.f5201s + 1)));
                    }
                    this.f5225f.invalidate();
                }
                this.f5225f.invalidate();
            } catch (Exception unused) {
                C0938a.m5002a("SR/MediaPlayerWrapper", "<setSeekbarMarks> exception");
            }
        }

        /* renamed from: b */
        public void mo5876b(String str) {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<startPlayback(path)>: " + str);
            if (RecNotesActivity.this.f5143L != null) {
                if (C1413m.f5720r) {
                    RecNotesActivity.this.f5143L.mo6315k();
                    RecNotesActivity.this.f5155R.mo5248a(C1413m.f5719q);
                    this.f5239t.postDelayed(new C1303Y(this), 300);
                    C1413m.f5720r = false;
                    return;
                }
                RecNotesActivity.this.f5143L.mo6305b(str);
                int i = C1413m.f5719q;
                if (i <= -2 || i >= 0) {
                    C0938a.m5002a("SR/MediaPlayerWrapper", "<mCurrentPlayingTime2> = " + C1413m.f5719q);
                    RecNotesActivity.this.f5143L.mo6304b(C1413m.f5719q);
                    C1413m.f5719q = -1;
                    return;
                }
                C0938a.m5002a("SR/MediaPlayerWrapper", "<mCurrentPlayingTime1> = " + C1413m.f5719q);
                if (this.f5234o >= 0) {
                    RecNotesActivity.this.f5143L.mo6304b(this.f5234o);
                }
            }
        }

        /* renamed from: a */
        public void mo5873a(String str) {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<processPlayback>, mPlayerPath = " + str + "  mPlayState = " + this.f5237r);
            this.f5236q = str;
            if (RecNotesActivity.this.f5155R != null && this.f5232m != null) {
                if (Math.abs(this.f5235p - this.f5234o) <= 10) {
                    this.f5234o = this.f5233n;
                    RecNotesActivity.this.f5155R.mo5255d();
                }
                this.f5232m.postDelayed(this.f5238s, 0);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public String m6400c(long j) {
            long j2 = j / 1000;
            long j3 = j2 % 3600;
            this.f5221b = String.format("%02d:%02d:%02d", new Object[]{Long.valueOf(j2 / 3600), Long.valueOf(j3 / 60), Long.valueOf(j3 % 60)});
            return this.f5221b;
        }

        /* renamed from: a */
        public void mo5871a(long j) {
            this.f5225f.setTickPosition((float) ((j * 100) / (RecNotesActivity.this.f5201s + 1)));
            this.f5225f.invalidate();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6390a(int i) {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<setState(" + i + ")>,mState = " + this.f5228i);
            this.f5228i = i;
            if (i != 0) {
                switch (i) {
                    case 2:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(PREPARE_STATE)>");
                        this.f5240u.removeCallbacks(this.f5241v);
                        return;
                    case 3:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(PLAYING_STATE)>");
                        m6393a(true);
                        this.f5226g = RecNotesActivity.this.f5201s;
                        this.f5240u.removeCallbacks(this.f5241v);
                        mo5879e();
                        m6406f();
                        return;
                    case 4:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(PAUSE_STATE)>");
                        m6393a(false);
                        try {
                            if (RecNotesActivity.this.f5143L != null) {
                                this.f5227h = (long) RecNotesActivity.this.f5143L.mo6306c();
                            }
                            mo5879e();
                            m6407g();
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            this.f5228i = 0;
                            return;
                        }
                    case 5:
                        this.f5227h = 0;
                        this.f5240u.removeCallbacks(this.f5241v);
                        return;
                    case 6:
                        this.f5227h = 0;
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(COMPLETION_STATE)>");
                        if (RecNotesActivity.this.f5143L != null) {
                            RecNotesActivity.this.f5143L.mo6315k();
                        }
                        m6393a(false);
                        m6407g();
                        RecNotesActivity.this.f5135H.mo5187c();
                        return;
                    case 7:
                        C0938a.m5004b("SR/MediaPlayerWrapper", "<updateListItemView>,state is error");
                        return;
                    default:
                        return;
                }
            } else {
                C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(IDLE_STATE)>");
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m6395b(int i) {
            C0938a.m5002a("SR/MediaPlayerWrapper", "change the player state <setStateWave(" + i + ")>,mPlayState = " + this.f5237r);
            this.f5237r = i;
            if (i != 0) {
                switch (i) {
                    case 2:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(PREPARE_STATE)>");
                        return;
                    case 3:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(PLAYING_STATE)>");
                        m6393a(true);
                        RecNotesActivity.this.f5155R.mo5257f();
                        if (RecNotesActivity.this.f5134Ga) {
                            boolean unused = RecNotesActivity.this.f5134Ga = false;
                            return;
                        }
                        return;
                    case 4:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(PAUSE_STATE)>");
                        m6393a(false);
                        RecNotesActivity.this.f5155R.mo5254c();
                        return;
                    case 5:
                        m6393a(false);
                        return;
                    case 6:
                        C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(COMPLETION_STATE)>");
                        m6393a(false);
                        RecNotesActivity.this.f5155R.mo5252b();
                        if (RecNotesActivity.this.f5143L != null) {
                            RecNotesActivity.this.f5143L.mo6315k();
                            return;
                        }
                        return;
                    case 7:
                        C0938a.m5004b("SR/MediaPlayerWrapper", "<updateListItemView>,state is error");
                        m6393a(false);
                        return;
                    default:
                        return;
                }
            } else {
                C0938a.m5002a("SR/MediaPlayerWrapper", "<updateListItemView(IDLE_STATE)>");
                if (!RecNotesActivity.this.f5198qa) {
                    C0938a.m5002a("SR/MediaPlayerWrapper", "step into");
                    m6393a(false);
                }
                boolean unused2 = RecNotesActivity.this.f5198qa = false;
                if (!RecNotesActivity.this.f5134Ga && RecNotesActivity.this.f5155R.f4218x) {
                    RecNotesActivity.this.f5155R.mo5254c();
                }
            }
        }

        /* renamed from: a */
        public int mo5870a() {
            return this.f5228i;
        }

        /* renamed from: a */
        public void mo5872a(long j, long j2) {
            if (j2 < 512) {
                j2 = 1;
            }
            this.f5221b = m6400c(j);
            this.f5223d.setText(this.f5221b);
            this.f5220a = m6400c(j2);
            this.f5224e.setText(this.f5220a);
            if (j2 != 0) {
                this.f5225f.setProgress((float) ((int) ((100 * j) / j2)));
            } else {
                this.f5225f.setProgress((float) ((int) ((100 * j) / (j2 + 1))));
            }
            mo5875b(j);
        }

        /* renamed from: b */
        public int mo5874b() {
            return this.f5237r;
        }

        /* renamed from: b */
        public void mo5875b(long j) {
            if (RecNotesActivity.this.f5187l) {
                int size = this.f5231l.size();
                int i = this.f5229j;
                if (size <= i || i < 0) {
                    this.f5229j = 0;
                } else if (RecNotesActivity.this.f5135H != null) {
                    if (this.f5231l.get(this.f5229j).longValue() <= j) {
                        int i2 = this.f5229j;
                        int i3 = size - 1;
                        if (i2 < i3) {
                            while (true) {
                                i2++;
                                if (i2 >= size) {
                                    break;
                                } else if (this.f5231l.get(i2).longValue() > j) {
                                    this.f5229j = i2 - 1;
                                    break;
                                } else if (i2 == i3) {
                                    this.f5229j = i2;
                                }
                            }
                        }
                        RecNotesActivity.this.f5135H.mo5184a(this.f5229j);
                        return;
                    }
                    int i4 = this.f5229j;
                    if (i4 > 0) {
                        for (int i5 = i4 - 1; i5 >= 0; i5--) {
                            if (this.f5231l.get(i5).longValue() <= j) {
                                this.f5229j = i5;
                                RecNotesActivity.this.f5135H.mo5184a(this.f5229j);
                                return;
                            }
                            if (i5 == 0) {
                                RecNotesActivity.this.f5135H.mo5184a(-1);
                            }
                        }
                        return;
                    }
                    RecNotesActivity.this.f5135H.mo5184a(-1);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6393a(boolean z) {
            C0938a.m5002a("SR/MediaPlayerWrapper", "<setNotesBackground>,isPlay = " + z);
            if (RecNotesActivity.this.f5214ya != null && z) {
                if (C1413m.m6844f()) {
                    RecNotesActivity.this.f5214ya.mo6520a(RecNotesActivity.this.getResources().getString(R.string.pause), R.drawable.iqoo_btn_edit_pause_selector);
                } else {
                    RecNotesActivity.this.f5214ya.mo6520a(RecNotesActivity.this.getResources().getString(R.string.pause), R.drawable.btn_edit_pause_selector);
                }
                RecNotesActivity.this.m6252E();
                if (C1411k.m6820b(RecNotesActivity.this) && !RecNotesActivity.this.f5167b.mo6178i().equals("false")) {
                    TwoStateDetailLayout x = RecNotesActivity.this.f5214ya;
                    x.setContentDescription(RecNotesActivity.this.getResources().getString(R.string.pause) + ",");
                }
            } else if (RecNotesActivity.this.f5214ya == null || z) {
                C0938a.m5008e("SR/MediaPlayerWrapper", "<setNotesBackground>,mNotesPlay == null,isPlay = " + z);
            } else {
                if (C1413m.m6844f()) {
                    RecNotesActivity.this.f5214ya.mo6520a(RecNotesActivity.this.getResources().getString(R.string.continue_recording), R.drawable.iqoo_btn_edit_play_selector);
                } else {
                    RecNotesActivity.this.f5214ya.mo6520a(RecNotesActivity.this.getResources().getString(R.string.continue_recording), R.drawable.btn_edit_play_selector);
                }
                if (C1411k.m6820b(RecNotesActivity.this) && !RecNotesActivity.this.f5167b.mo6178i().equals("false")) {
                    TwoStateDetailLayout x2 = RecNotesActivity.this.f5214ya;
                    x2.setContentDescription(RecNotesActivity.this.getResources().getString(R.string.playing) + ",");
                }
            }
        }
    }

    /* renamed from: com.android.activity.RecNotesActivity$c */
    private class C1277c extends BroadcastReceiver {
        private C1277c() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int i = 0;
                if (intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_HEADSET_CONNECTION")) {
                    boolean booleanExtra = intent.getBooleanExtra("headset_connection_state", false);
                    C0938a.m5002a("SR/RecNotesActivity", "MsgFromServiceReceiver headphone connection: " + booleanExtra);
                    boolean unused = RecNotesActivity.this.f5181i = booleanExtra;
                    if (RecNotesActivity.this.f5155R != null) {
                        RecNotesActivity.this.f5155R.mo5251a(!booleanExtra);
                    }
                    if (RecNotesActivity.this.f5167b != null) {
                        boolean equals = RecNotesActivity.this.f5167b.mo6178i().equals("true");
                        RecNotesActivity.this.m6325f(equals);
                        RecNotesActivity recNotesActivity = RecNotesActivity.this;
                        recNotesActivity.m6318d(!recNotesActivity.f5181i);
                        RecNotesActivity recNotesActivity2 = RecNotesActivity.this;
                        if (equals) {
                            i = 3;
                        }
                        recNotesActivity2.setVolumeControlStream(i);
                    }
                } else if ((RecNotesActivity.this.f5143L == null || RecNotesActivity.this.f5143L.mo6303b() == 102) && intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_PLAYBACK_STATE")) {
                    int intExtra = intent.getIntExtra("playback_state", 0);
                    if (RecNotesActivity.this.f5143L == null || RecNotesActivity.this.f5143L.mo6303b() == 102) {
                        if (intent.getStringExtra("LoadingWaveFinished") != null && intent.getStringExtra("LoadingWaveFinished").contains("YES")) {
                            if (!RecNotesActivity.this.m6273P()) {
                                RecNotesActivity.this.mo5844o();
                            } else {
                                return;
                            }
                        }
                        RecNotesActivity.this.f5129E.m6395b(intExtra);
                        RecNotesActivity.this.f5129E.m6390a(intExtra);
                    }
                }
            }
        }

        /* synthetic */ C1277c(RecNotesActivity recNotesActivity, C1367u uVar) {
            this();
        }
    }

    /* renamed from: com.android.activity.RecNotesActivity$d */
    private class C1278d implements ServiceConnection {
        private C1278d() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0938a.m5002a("SR/RecNotesActivity", "<onServiceConnected>: " + iBinder);
            PlaybackService.C1442a unused = RecNotesActivity.this.f5143L = (PlaybackService.C1442a) iBinder;
            if (RecNotesActivity.this.f5143L != null && RecNotesActivity.this.f5207v != null) {
                RecNotesActivity.this.f5143L.mo6300a(102);
                if (RecNotesActivity.this.f5183j) {
                    RecNotesActivity.this.f5143L.mo6302a((String) null);
                }
                if (RecNotesActivity.this.f5207v.equals(RecNotesActivity.this.f5143L.mo6309e())) {
                    RecNotesActivity.this.f5129E.m6395b(RecNotesActivity.this.f5143L.mo6310f());
                    if (RecNotesActivity.this.f5129E.mo5874b() == 4) {
                        try {
                            RecNotesActivity.this.f5129E.mo5872a((long) RecNotesActivity.this.f5143L.mo6306c(), (long) RecNotesActivity.this.f5143L.mo6308d());
                        } catch (Exception unused2) {
                        }
                    }
                } else if (RecNotesActivity.f5120a) {
                    boolean unused3 = RecNotesActivity.f5120a = false;
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0938a.m5002a("SR/RecNotesActivity", "<onServiceDisconnected>");
        }

        /* synthetic */ C1278d(RecNotesActivity recNotesActivity, C1367u uVar) {
            this();
        }
    }

    /* renamed from: com.android.activity.RecNotesActivity$e */
    private class C1279e implements ServiceConnection {
    }

    /* renamed from: O */
    private boolean m6272O() {
        return this.f5197q == C1465b.f5983a;
    }

    /* access modifiers changed from: private */
    /* renamed from: P */
    public boolean m6273P() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f5203t <= 500) {
            return true;
        }
        this.f5203t = uptimeMillis;
        C1276b bVar = this.f5129E;
        if (bVar == null || bVar.mo5870a() == 1 || this.f5129E.mo5870a() == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: Q */
    private void m6274Q() {
        C0938a.m5002a("SR/RecNotesActivity", "<performDeleteOperation>");
        int[] iArr = {this.f5197q};
        String[] strArr = {this.f5207v};
        AlertDialog create = new AlertDialog.Builder(this, 51314692).setTitle(getString(R.string.delete_file_new)).setPositiveButton(R.string.delete, new C1295U(this, iArr, strArr)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        create.setCanceledOnTouchOutside(false);
        create.setOwnerActivity(this);
        if (!isDestroyed() && !isFinishing()) {
            create.show();
            create.getButton(-1).setTextColor(Color.parseColor(C1413m.f5728z));
            create.getWindow().setGravity(80);
        }
    }

    /* renamed from: R */
    private void m6275R() {
        C0938a.m5002a("SR/RecNotesActivity", "<registerListener>");
        m6277T();
    }

    /* renamed from: S */
    private void m6276S() {
        if (this.f5179h == null) {
            this.f5179h = new C1371w(this);
            registerReceiver(this.f5179h, new IntentFilter("android.vivo.bbklog.action.CHANGED"));
        }
    }

    /* renamed from: T */
    private void m6277T() {
        if (this.f5177g == null) {
            this.f5177g = new C1234A(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_SHARED");
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addDataScheme("file");
            registerReceiver(this.f5177g, intentFilter);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: U */
    public void m6278U() {
        TwoStateDetailLayout twoStateDetailLayout;
        int i = C1413m.f5709g;
        if (i == 0) {
            TwoStateDetailLayout twoStateDetailLayout2 = this.f5126Ca;
            if (twoStateDetailLayout2 != null) {
                twoStateDetailLayout2.mo6521a(getResources().getString(R.string.chage_speed_os_ten), R.drawable.rate_detail_zero_five_selector, false);
            }
        } else if (i == 1) {
            TwoStateDetailLayout twoStateDetailLayout3 = this.f5126Ca;
            if (twoStateDetailLayout3 != null) {
                twoStateDetailLayout3.mo6521a(getResources().getString(R.string.chage_speed_os_ten), R.drawable.rate_detail_one_zero_selector, false);
            }
        } else if (i == 2) {
            TwoStateDetailLayout twoStateDetailLayout4 = this.f5126Ca;
            if (twoStateDetailLayout4 != null) {
                twoStateDetailLayout4.mo6521a(getResources().getString(R.string.chage_speed_os_ten), R.drawable.rate_detail_one_five_selector, false);
            }
        } else if (i == 3 && (twoStateDetailLayout = this.f5126Ca) != null) {
            twoStateDetailLayout.mo6521a(getResources().getString(R.string.chage_speed_os_ten), R.drawable.rate_detail_two_zero_selector, false);
        }
    }

    /* renamed from: V */
    private void m6279V() {
        getWindow().setStatusBarColor(C1413m.f5721s);
        getWindow().setNavigationBarColor(C1413m.f5721s);
    }

    /* renamed from: W */
    private void m6280W() {
        if (new File(this.f5207v).exists()) {
            if (!C1413m.m6843e()) {
                this.f5174ea = true;
                Intent intent = new Intent(this, SpecifiedShareActivity.class);
                intent.putExtra("shareId", this.f5197q);
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.SEND");
            intent2.addFlags(524288);
            intent2.setType("audio/*");
            intent2.putExtra("android.intent.extra.STREAM", ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5197q));
            try {
                startActivity(Intent.createChooser(intent2, getString(R.string.share)));
            } catch (ActivityNotFoundException unused) {
                C0938a.m5004b("SR/RecNotesActivity", "<shareOperation> shareDialog fail");
            }
        }
    }

    /* renamed from: X */
    private void m6281X() {
        String str;
        SimpleDateFormat simpleDateFormat;
        TextView textView;
        String str2;
        String str3;
        String str4;
        C0938a.m5002a("SR/RecNotesActivity", "<onContextItemSelected>,MENU_PROPERTY");
        if (new File(this.f5207v).exists()) {
            File file = new File(this.f5207v);
            View inflate = LayoutInflater.from(this).inflate(R.layout.property, (ViewGroup) null, false);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.file_style);
            ((TextView) viewGroup.findViewById(R.id.itemPre)).setText(R.string.style);
            TextView textView2 = (TextView) viewGroup.findViewById(R.id.itemMain);
            ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.file_path);
            ((TextView) viewGroup2.findViewById(R.id.itemPre)).setText(R.string.file_path);
            TextView textView3 = (TextView) viewGroup2.findViewById(R.id.itemMain);
            ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.size);
            ((TextView) viewGroup3.findViewById(R.id.itemPre)).setText(R.string.size);
            TextView textView4 = (TextView) viewGroup3.findViewById(R.id.itemMain);
            ViewGroup viewGroup4 = (ViewGroup) inflate.findViewById(R.id.modified_time);
            ((TextView) viewGroup4.findViewById(R.id.itemPre)).setText(R.string.modified_time);
            TextView textView5 = (TextView) viewGroup4.findViewById(R.id.itemMain);
            TextView textView6 = (TextView) inflate.findViewById(R.id.file_name);
            if (file.exists()) {
                C0938a.m5002a("SR/RecNotesActivity", "<onContextItemSelected>,longClickFileSize=" + file.length());
                if (file.length() >= 1048576) {
                    str = String.format("%.1f", new Object[]{Float.valueOf(((float) file.length()) / 1048576.0f)}) + "MB";
                } else {
                    str = String.format("%.1f", new Object[]{Float.valueOf(((float) file.length()) / 1024.0f)}) + "KB";
                }
                if (this.f5125C != null && !isFinishing()) {
                    this.f5121A = new AlertDialog.Builder(this).setView(inflate).setTitle(R.string.file_information).setNegativeButton(R.string.dialog_button_got, this.f5188la).create();
                    if (!isDestroyed() && !isFinishing()) {
                        this.f5121A.show();
                    }
                    this.f5121A.setOwnerActivity(this);
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    C0938a.m5002a("SR/RecNotesActivity", "<onContextItemSelected>,mFileIdToPathStr=" + this.f5207v);
                    String lowerCase = this.f5167b.mo6173f().getAbsolutePath().toLowerCase();
                    String lowerCase2 = this.f5167b.mo6167c().getAbsolutePath().toLowerCase();
                    String lowerCase3 = this.f5167b.mo6177h().getAbsolutePath().toLowerCase();
                    C0938a.m5002a("SR/RecNotesActivity", "<onContextItemSelected>,UDISK_1=" + lowerCase);
                    C0938a.m5002a("SR/RecNotesActivity", "<onContextItemSelected>,UDISK_2=" + lowerCase2);
                    C0938a.m5002a("SR/RecNotesActivity", "<onContextItemSelected>,UDISK_3=" + lowerCase3);
                    if (C1411k.m6818a(this)) {
                        if (this.f5207v.startsWith(lowerCase)) {
                            str4 = this.f5207v.substring(lowerCase.length());
                        } else if (this.f5207v.startsWith(lowerCase2)) {
                            str4 = this.f5207v.substring(lowerCase2.length());
                        } else {
                            str4 = this.f5207v.startsWith(lowerCase3) ? this.f5207v.substring(lowerCase3.length()) : C1882a.f6747d;
                        }
                        String[] split = str4.split("/");
                        simpleDateFormat = simpleDateFormat2;
                        textView = textView5;
                        String str5 = C1882a.f6747d;
                        for (int i = 0; i < split.length; i++) {
                            str5 = str5 + "‏" + split[i] + "/";
                        }
                        if (split.length > 0) {
                            str5 = str5.substring(0, str5.length() - 1);
                        }
                        if (this.f5207v.startsWith(lowerCase2)) {
                            str2 = getString(R.string.external_sdcard) + str5;
                        } else if (this.f5207v.startsWith(lowerCase3)) {
                            str2 = getString(R.string.storage_otg_sda4) + str5;
                        } else if (this.f5207v.startsWith(lowerCase)) {
                            str2 = getString(R.string.sdcard_mtp) + str5;
                        } else {
                            str2 = null;
                        }
                    } else {
                        simpleDateFormat = simpleDateFormat2;
                        textView = textView5;
                        if (this.f5207v.startsWith(lowerCase2)) {
                            str2 = getString(R.string.external_sdcard) + this.f5207v.substring(lowerCase2.toLowerCase().length());
                        } else if (this.f5207v.startsWith(lowerCase)) {
                            str2 = getString(R.string.sdcard_mtp) + this.f5207v.substring(lowerCase.toLowerCase().length());
                        } else if (this.f5207v.startsWith(lowerCase3)) {
                            str2 = getString(R.string.storage_otg_sda4) + this.f5207v.substring(lowerCase3.toLowerCase().length());
                        } else {
                            str2 = this.f5207v;
                            C0938a.m5004b("SR/RecNotesActivity", "<onContextItemSelected>,pathText = " + str2);
                        }
                    }
                    textView6.setText(this.f5205u);
                    textView2.setText(mo5834a(this.f5207v).toUpperCase() + " " + getString(R.string.audio));
                    textView3.setText(str2);
                    textView4.setText(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("<onContextItemSelected>,ateFormat.format(longClickFile.lastModified())=");
                    SimpleDateFormat simpleDateFormat3 = simpleDateFormat;
                    sb.append(simpleDateFormat3.format(Long.valueOf(file.lastModified())));
                    C0938a.m5002a("SR/RecNotesActivity", sb.toString());
                    if (AppFeature.f5612h) {
                        String format = DateFormat.getDateFormat(this).format(new Date(file.lastModified()));
                        C0938a.m5002a("SR/RecNotesActivity", "date" + format);
                        String string = Settings.System.getString(getContentResolver(), "use_thai_calendar");
                        if (string != null && "1".equals(string)) {
                            Calendar instance = Calendar.getInstance();
                            instance.setTimeInMillis(file.lastModified());
                            int i2 = instance.get(1);
                            format = format.replace(String.valueOf(i2), String.valueOf(i2 + 543));
                        }
                        String language = Locale.getDefault().getLanguage();
                        long lastModified = file.lastModified();
                        if ("24".equals(Settings.System.getString(getContentResolver(), "time_12_24"))) {
                            str3 = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(lastModified));
                        } else if ("zh".endsWith(language)) {
                            str3 = new SimpleDateFormat("aa h:mm:ss").format(Long.valueOf(lastModified));
                        } else {
                            str3 = new SimpleDateFormat("h:mm:ss aa").format(Long.valueOf(lastModified));
                        }
                        textView.setText(format + " " + str3);
                        return;
                    }
                    textView.setText(simpleDateFormat3.format(Long.valueOf(file.lastModified())));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m6282Y() {
        if (this.f5160U != null && !TextUtils.isEmpty(this.f5207v)) {
            m6315ca();
            this.f5160U.mo6323a(this.f5207v, this.f5205u, this.f5197q, this.f5156Ra);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Z */
    public void m6283Z() {
        if (this.f5160U != null && !TextUtils.isEmpty(this.f5207v)) {
            m6315ca();
            this.f5160U.mo6325b(this.f5207v, this.f5205u, this.f5197q, this.f5156Ra);
            if (this.f5201s > 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("rec_time", String.valueOf(this.f5201s));
                C1390G.m6778a("A107|4|4|10", hashMap);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: aa */
    public void m6302aa() {
        RecognizeService.C1443a aVar = this.f5160U;
        if (aVar != null) {
            aVar.mo6324b();
            C1390G.m6778a("A107|4|5|10", (HashMap) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ba */
    public void m6309ba() {
        int i = (this.f5189m ? 1 : 0) + true + 1;
        if (!this.f5187l || this.f5175f.size() != i) {
            boolean z = this.f5189m;
            m6299a(z, true, z ? 1 : 0);
            return;
        }
        CustomViewPager customViewPager = this.f5171d;
        if (customViewPager != null && this.f5141K != null) {
            customViewPager.setCurrentItem(this.f5189m ? 1 : 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ca */
    public void m6315ca() {
        if (!this.f5189m) {
            m6299a(true, this.f5187l, 0);
            return;
        }
        CustomViewPager customViewPager = this.f5171d;
        if (customViewPager != null && this.f5141K != null) {
            customViewPager.setCurrentItem(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: da */
    public void m6320da() {
        if (this.f5193o) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_CLIP");
            if (this.f5167b.mo6163a(102400)) {
                C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.sdcard_not_enough), 0).show();
                return;
            }
            if (this.f5143L != null && (this.f5129E.f5237r == 3 || this.f5129E.f5237r == 4)) {
                this.f5143L.mo6315k();
                this.f5129E.m6393a(false);
            }
            Intent intent = new Intent();
            intent.putExtra("clip_filePath", this.f5207v);
            intent.putExtra("file_duration", this.f5201s);
            intent.setClass(this, EditActivity.class);
            startActivity(intent);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("button_name", "5");
                C1390G.m6779b("A107|4|3|10", hashMap);
            } catch (Exception e) {
                C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e);
            }
        } else {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_PROPERTY");
            m6281X();
        }
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("button_name", "5");
            C1390G.m6779b("A107|4|3|10", hashMap2);
        } catch (Exception e2) {
            C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e2);
        }
    }

    /* renamed from: a */
    public int mo5263a() {
        return 0;
    }

    /* renamed from: b */
    public void mo5267b(boolean z) {
    }

    /* renamed from: d */
    public int mo5269d() {
        return 0;
    }

    public void onBackPressed() {
        C1413m.f5709g = 1;
        if (!m6273P()) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0938a.m5002a("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onConfigurationChanged " + configuration);
        ((RelativeLayout) findViewById(R.id.note_seekbar_relative_layout)).setLayoutParams(new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.notes_seekbar_layout_height)));
        m6351y();
        this.f5137I.mo5220f();
        this.f5155R.mo5256e();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onCreate");
        super.onCreate(bundle);
        C0938a.f3944b = C1384A.m6752a("persist.sys.log.ctrl", "no").equals("yes");
        this.f5125C = getApplicationContext();
        m6258H();
        requestWindowFeature(1);
        if (C1413m.m6844f()) {
            setContentView(R.layout.iqoo_recorder_notes_parent);
        } else {
            setContentView(R.layout.recorder_notes_parent);
        }
        mo5837a(bundle);
        m6264K();
        m6270N();
        m6261I();
        m6269M();
        if (C1413m.m6844f()) {
            m6279V();
        }
        this.f5195p = false;
        m6275R();
        mo5864v();
        mo5865w();
        mo5863u();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onDestroy");
        m6250D();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onNewIntent");
        if (this.f5143L == null) {
            C0938a.m5002a("SR/RecNotesActivity", "<onNewIntent> mPlaybackControllerBinder is null");
            return;
        }
        List<Fragment> list = this.f5175f;
        if (list != null) {
            for (Fragment next : list) {
                if (next instanceof C0982k) {
                    this.f5127D = m6289a(intent);
                    if (this.f5183j) {
                        ((C0982k) next).mo5211a(this.f5127D);
                        this.f5151P = this.f5149O.getCallState();
                        C0938a.m5002a("SR/RecNotesActivity", "<onNewIntent> mCallState = " + this.f5151P);
                        if (this.f5151P == 2) {
                            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.call_not_play), 0).show();
                            return;
                        }
                        this.f5129E.m6395b(6);
                        this.f5129E.mo5876b(this.f5207v);
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f5163X = true;
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onPause");
        if (this.f5143L != null) {
            C0938a.m5006c("SR/RecNotesActivity", "<onPause> isFinishing: " + isFinishing());
            if (!isFinishing()) {
                if (this.f5174ea) {
                    this.f5174ea = false;
                } else {
                    this.f5143L.mo6314j();
                }
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "1");
                    C1390G.m6779b("A107|8|2|7", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/RecNotesActivity", "vcode error");
                }
            } else {
                this.f5143L.mo6315k();
            }
        }
        if (this.f5160U != null && C1472g.m7218a()) {
            this.f5160U.mo6322a(0);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        C0938a.m5002a("SR/RecNotesActivity", "<onRequestPermissionsResult>");
        if (iArr.length != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("android.permission.READ_EXTERNAL_STORAGE", 0);
            hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", 0);
            if (i == 123) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                }
                if (((Integer) hashMap.get("android.permission.READ_EXTERNAL_STORAGE")).intValue() == -1) {
                    str = C1882a.f6747d + getString(R.string.permission_storage);
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
                    mo5838a(str, (Activity) this);
                    this.f5185k = true;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        C0938a.m5002a("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            m6307b(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str = this.f5207v;
        if (str == null || !new File(str).exists()) {
            finish();
        }
        super.onResume();
        m6278U();
        this.f5163X = false;
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onResume");
        if (!this.f5185k) {
            this.f5153Q.postDelayed(new C1367u(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), 300);
            if (!this.f5195p) {
                m6263J();
            }
            m6351y();
            PlaybackService.C1442a aVar = this.f5143L;
            if (aVar != null) {
                aVar.mo6299a();
                this.f5143L.mo6300a(102);
            }
            m6325f("true".equals(this.f5167b.mo6178i()));
            if (this.f5143L != null) {
                if (this.f5129E.mo5874b() != this.f5143L.mo6310f()) {
                    C0938a.m5002a("SR/RecNotesActivity", "<onResume> playService state has been changed!");
                    this.f5129E.m6395b(this.f5143L.mo6310f());
                }
                this.f5143L.mo6299a();
                this.f5143L.mo6300a(102);
            }
            RecognizeService.C1443a aVar2 = this.f5160U;
            if (aVar2 != null) {
                aVar2.mo6321a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        C0938a.m5002a("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onSaveInstanceState");
        bundle.putString("RecListViewFileName", this.f5205u);
        bundle.putInt("RecListViewFileId", this.f5197q);
        bundle.putString("FileIdToPath", this.f5207v);
        bundle.putLong("FileDuration", this.f5201s);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        ReclistActivity.f5246a = true;
        C1413m.f5702A = 1;
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStart");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        ReclistActivity.f5246a = false;
        C0938a.m5006c("SR/RecNotesActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStop");
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public boolean m6244A() {
        if (C1387D.m6766b(getApplicationContext())) {
            return true;
        }
        C1468d.m7210b(this, this.f5140Ja);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public boolean m6246B() {
        if (C1419r.m6860b()) {
            return true;
        }
        C1468d.m7211c(this, this.f5144La);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public boolean m6248C() {
        if (C1387D.m6768c(AppFeature.m6734b())) {
            return true;
        }
        C1468d.m7212d(this, this.f5142Ka);
        return false;
    }

    /* renamed from: D */
    private void m6250D() {
        C0938a.m5002a("SR/RecNotesActivity", "<destroyObjects>");
        this.f5129E.mo5878d();
        this.f5129E.f5232m.removeCallbacksAndMessages((Object) null);
        BroadcastReceiver broadcastReceiver = this.f5177g;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f5177g = null;
        }
        ScreenBroadcastReceiver screenBroadcastReceiver = this.f5166aa;
        if (screenBroadcastReceiver != null) {
            unregisterReceiver(screenBroadcastReceiver);
            this.f5166aa = null;
        }
        RecNotePageAddMarkReceiver recNotePageAddMarkReceiver = this.f5168ba;
        if (recNotePageAddMarkReceiver != null) {
            unregisterReceiver(recNotePageAddMarkReceiver);
            this.f5168ba = null;
        }
        PlaybackService.C1442a aVar = this.f5143L;
        if (aVar != null) {
            aVar.mo6312h();
        }
        ServiceConnection serviceConnection = this.f5147N;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
        C1279e eVar = this.f5159T;
        if (eVar != null) {
            unbindService(eVar);
        }
        C1277c cVar = this.f5145M;
        if (cVar != null) {
            unregisterReceiver(cVar);
            this.f5145M = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.f5179h;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
            this.f5179h = null;
        }
        C1018a aVar2 = this.f5133G;
        if (aVar2 != null) {
            aVar2.mo5345a();
            this.f5133G = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: E */
    public void m6252E() {
        TwoStateDetailLayout twoStateDetailLayout = this.f5122Aa;
        if (twoStateDetailLayout != null) {
            twoStateDetailLayout.setEnabled(true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0069, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0069, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047 A[Catch:{ Exception -> 0x00cb, all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f A[Catch:{ Exception -> 0x00cb, all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af A[Catch:{ Exception -> 0x00cb, all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00be A[SYNTHETIC, Splitter:B:34:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5 A[SYNTHETIC, Splitter:B:45:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0101 A[SYNTHETIC, Splitter:B:53:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* renamed from: F */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6254F() {
        /*
            r10 = this;
            java.lang.String r0 = "_mark_time_length"
            java.lang.String r1 = "<findCursor>,Exception2 = "
            java.lang.String r2 = "SR/RecNotesActivity"
            java.lang.String r3 = "<findCursor>"
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r3)
            java.lang.String r3 = "recordermarks"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "_mark_recfile_id='"
            r4.append(r5)
            int r5 = r10.f5197q
            r4.append(r5)
            java.lang.String r5 = "'"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            c.a.g.a.a r5 = r10.f5133G
            if (r5 == 0) goto L_0x0119
            r6 = 0
            java.lang.String r7 = "_mark_path"
            java.lang.String[] r7 = new java.lang.String[]{r0, r7}     // Catch:{ Exception -> 0x00ce }
            android.database.Cursor r0 = r5.mo5343a(r3, r7, r4, r0)     // Catch:{ Exception -> 0x00ce }
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0041
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r5 <= 0) goto L_0x0041
            r10.f5187l = r4     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            goto L_0x0043
        L_0x0041:
            r10.f5187l = r3     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
        L_0x0043:
            android.os.Handler r5 = r10.f5158Sa     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r5 == 0) goto L_0x004d
            android.os.Handler r5 = r10.f5158Sa     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r7 = 2
            r5.sendEmptyMessage(r7)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
        L_0x004d:
            if (r0 == 0) goto L_0x00ad
            com.android.activity.RecNotesActivity$b r5 = r10.f5129E     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r5 == 0) goto L_0x00ad
            com.android.activity.RecNotesActivity$b r5 = r10.f5129E     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.util.List r5 = r5.f5231l     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r5 < 0) goto L_0x00ad
            com.android.activity.RecNotesActivity$b r5 = r10.f5129E     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.util.List r5 = r5.f5231l     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r5.clear()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r5 = r3
        L_0x0069:
            boolean r7 = r0.moveToNext()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r7 == 0) goto L_0x00ac
            com.android.activity.RecNotesActivity$b r7 = r10.f5129E     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.util.List r7 = r7.f5231l     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            long r8 = r0.getLong(r3)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r7.add(r8)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r5 != 0) goto L_0x0069
            java.lang.String r7 = r10.f5207v     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r7 == 0) goto L_0x0069
            java.lang.String r7 = r10.f5207v     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.lang.String r8 = r0.getString(r4)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            if (r7 != 0) goto L_0x0069
            java.lang.String r6 = r0.getString(r4)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r5.<init>()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.lang.String r7 = "<getMarkList> prePath: "
            r5.append(r7)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r5.append(r6)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r5)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r5 = r4
            goto L_0x0069
        L_0x00ac:
            r3 = r5
        L_0x00ad:
            if (r3 == 0) goto L_0x00bc
            c.a.g.a.b$a r3 = new c.a.g.a.b$a     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r3.<init>()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            java.lang.String r4 = r10.f5207v     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r3.mo5356a(r6, r4)     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
            r3.run()     // Catch:{ Exception -> 0x00cb, all -> 0x00c9 }
        L_0x00bc:
            if (r0 == 0) goto L_0x0119
            r0.close()     // Catch:{ Exception -> 0x00c2 }
            goto L_0x0119
        L_0x00c2:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00ef
        L_0x00c9:
            r3 = move-exception
            goto L_0x00ff
        L_0x00cb:
            r3 = move-exception
            r6 = r0
            goto L_0x00cf
        L_0x00ce:
            r3 = move-exception
        L_0x00cf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r0.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = "<findCursor>,Exception1 = "
            r0.append(r4)     // Catch:{ all -> 0x00fd }
            r0.append(r3)     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00fd }
            p050c.p051a.p058e.p059a.C0938a.m5004b(r2, r0)     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x0119
            r6.close()     // Catch:{ Exception -> 0x00e9 }
            goto L_0x0119
        L_0x00e9:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x00ef:
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            p050c.p051a.p058e.p059a.C0938a.m5004b(r2, r0)
            goto L_0x0119
        L_0x00fd:
            r3 = move-exception
            r0 = r6
        L_0x00ff:
            if (r0 == 0) goto L_0x0118
            r0.close()     // Catch:{ Exception -> 0x0105 }
            goto L_0x0118
        L_0x0105:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            p050c.p051a.p058e.p059a.C0938a.m5004b(r2, r0)
        L_0x0118:
            throw r3
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.activity.RecNotesActivity.m6254F():void");
    }

    /* renamed from: G */
    private void m6256G() {
        this.f5124Ba.setVisibility(8);
        this.f5216za.setVisibility(8);
    }

    /* renamed from: H */
    private void m6258H() {
        if (this.f5167b == null) {
            C0938a.m5002a("SR/RecNotesActivity", "<onCreate>,mRecConfigFile==null,new RecConfigFile()");
            this.f5167b = new C1425w(this.f5125C);
        }
        if (this.f5129E == null) {
            this.f5129E = new C1276b();
        }
        if (this.f5131F == null) {
            C0938a.m5002a("SR/RecNotesActivity", "<initObjects>,mFileInfoUtils==null,new RecFileInfoUtils(mRecConfigFile, mAppContext)");
            this.f5131F = C1426x.m6909a(this.f5125C);
        }
        if (this.f5133G == null) {
            C0938a.m5002a("SR/RecNotesActivity", "<initObjects>,mDB==null,new AndroidSQLiteOpenHelper()");
            this.f5133G = C1018a.m5416a(this.f5125C);
        }
        this.f5149O = (TelephonyManager) this.f5125C.getSystemService("phone");
    }

    /* renamed from: I */
    private void m6261I() {
        C0938a.m5002a("SR/RecNotesActivity", "<initRecNotesResource>");
        this.f5124Ba = (TwoStateDetailLayout) findViewById(R.id.add_text_layout);
        this.f5122Aa = (TwoStateDetailLayout) findViewById(R.id.add_mark_layout);
        this.f5214ya = (TwoStateDetailLayout) findViewById(R.id.btn_detail_play);
        this.f5216za = (TwoStateDetailLayout) findViewById(R.id.edit);
        this.f5126Ca = (TwoStateDetailLayout) findViewById(R.id.double_rate);
        m6256G();
        int i = 0;
        if (C1413m.m6844f()) {
            this.f5124Ba.mo6521a(getResources().getString(R.string.rtot_recording_to_text), R.drawable.iqoo_btn_recorder_convert_selector, false);
            this.f5122Aa.mo6521a(getResources().getString(R.string.new_mark_name), R.drawable.iqoo_btn_recorder_mark_selector, false);
            this.f5214ya.mo6521a(getResources().getString(R.string.continue_recording), R.drawable.iqoo_btn_edit_play_selector, true);
            this.f5216za.mo6521a(getResources().getString(R.string.rtot_crop), R.drawable.iqoo_btn_recorder_edit_selector, false);
        } else {
            this.f5124Ba.mo6521a(getResources().getString(R.string.rtot_recording_to_text), R.drawable.btn_recorder_convert_selector, false);
            this.f5122Aa.mo6521a(getResources().getString(R.string.new_mark_name), R.drawable.btn_recorder_mark_selector, false);
            this.f5214ya.mo6521a(getResources().getString(R.string.continue_recording), R.drawable.btn_edit_play_selector, true);
            this.f5216za.mo6521a(getResources().getString(R.string.rtot_crop), R.drawable.btn_recorder_edit_selector, false);
        }
        if (C1411k.m6820b(this)) {
            TwoStateDetailLayout twoStateDetailLayout = this.f5122Aa;
            twoStateDetailLayout.setContentDescription(getResources().getString(R.string.new_mark_name) + "，" + getResources().getString(R.string.button_talkback));
        }
        this.f5124Ba.setOnClickListener(this.f5138Ia);
        this.f5122Aa.setOnClickListener(this.f5180ha);
        this.f5214ya.setOnClickListener(this.f5204ta);
        this.f5216za.setOnClickListener(this.f5206ua);
        this.f5126Ca.setOnClickListener(this.f5202sa);
        boolean equals = "true".equals(this.f5167b.mo6178i());
        m6325f(equals);
        if (equals) {
            i = 3;
        }
        setVolumeControlStream(i);
        this.f5169c = (LinearLayout) findViewById(R.id.control_layout);
        this.f5129E.f5222c = this.f5169c;
        this.f5128Da = (RelativeLayout) findViewById(R.id.note_seekbar_relative_layout);
        this.f5128Da.setVisibility(8);
        this.f5208va = (TextView) findViewById(R.id.notes_playetime);
        this.f5129E.f5223d = this.f5208va;
        this.f5210wa = (TextView) findViewById(R.id.notes_totalduration);
        this.f5129E.f5224e = this.f5210wa;
        this.f5212xa = (IndicatorSeekBar) findViewById(R.id.notes_seekbar);
        C1276b bVar = this.f5129E;
        IndicatorSeekBar indicatorSeekBar = this.f5212xa;
        bVar.f5225f = indicatorSeekBar;
        indicatorSeekBar.setOnSeekChangeListener(bVar.f5242w);
        this.f5129E.mo5877c();
        this.f5141K = (IndicatorView) findViewById(R.id.viewpager_indicator);
        m6278U();
        m6351y();
        if (m6272O()) {
            m6328g(C1472g.m7218a());
        }
    }

    /* renamed from: J */
    private void m6263J() {
        C0938a.m5002a("SR/RecNotesActivity", "<initService>");
        Intent intent = new Intent(this, PlaybackService.class);
        this.f5147N = new C1278d(this, (C1367u) null);
        try {
            C1386C.m6759a(intent);
        } catch (Exception unused) {
            C0938a.m5004b("SR/RecNotesActivity", "startService(playbackServiceIntent)Failed");
        }
        bindService(intent, this.f5147N, 1);
        this.f5195p = true;
        if (this.f5183j) {
            m6276S();
        }
    }

    /* renamed from: K */
    private void m6264K() {
        this.f5157S = findViewById(R.id.details_page_wave);
        this.f5157S.setVisibility(0);
        if (AppFeature.f5619o >= 11.0f) {
            this.f5157S.showDivider(false);
        }
        this.f5157S.showLeftButton();
        this.f5157S.setLeftButtonIcon(R.drawable.btn_titleview_back_selector);
        this.f5157S.setLeftButtonClickListener(this.f5178ga);
        this.f5157S.setCenterText(this.f5205u);
        this.f5157S.initRightIconButton();
        this.f5157S.showRightButton();
        this.f5157S.setRightButtonClickListener(this.f5200ra);
        this.f5157S.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, true);
        if (C1413m.m6844f()) {
            this.f5157S.getCenterView().setTextColor(Color.parseColor("#FFFFFF"));
            this.f5157S.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_FIRST, R.drawable.iqoo_more_iqoo);
            this.f5157S.setLeftButtonIcon(R.drawable.iqoo_details_backup);
        } else {
            this.f5157S.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_FIRST, R.drawable.btn_reclist_more_selector);
        }
        this.f5157S.setIconViewOnClickListner(BbkTitleView.RIGHT_ICON_FIRST, this.f5184ja);
        this.f5211x = (TextView) C1384A.m6749a("com.vivo.common.BbkTitleView", "mRightIconFirst", (Object) this.f5157S);
    }

    /* access modifiers changed from: private */
    /* renamed from: L */
    public void m6266L() {
        if (this.f5189m) {
            this.f5175f.add(this.f5139J);
        }
        if (this.f5187l) {
            this.f5175f.add(this.f5135H);
        }
        this.f5175f.add(this.f5137I);
        this.f5173e = new C0962T(getFragmentManager(), this.f5175f);
        this.f5171d.setAdapter(this.f5173e);
        this.f5171d.setOffscreenPageLimit(2);
        if (this.f5175f.size() > 1) {
            this.f5141K.setViewPager(this.f5171d);
            this.f5141K.setmIsDisplay(true);
            this.f5171d.setCurrentItem(0);
            return;
        }
        this.f5141K.setmIsDisplay(false);
    }

    /* renamed from: M */
    private void m6269M() {
        this.f5171d = (CustomViewPager) findViewById(R.id.id_viewpager);
        this.f5175f = new ArrayList();
        this.f5139J = C0987n.m5304a(this.f5127D);
        this.f5135H = C0974e.m5223a(this.f5127D);
        C0927a.m4982a().mo5050a(new C1275a(), 0);
        this.f5137I = C0982k.m5263b(this.f5127D);
    }

    /* renamed from: N */
    private void m6270N() {
        this.f5130Ea = C1413m.f5714l;
        String str = this.f5130Ea;
        if (str != null) {
            this.f5132Fa = m6304b(str);
            C1413m.f5716n = (int) this.f5132Fa;
            Bundle bundle = new Bundle();
            bundle.putString("clip_filePath", this.f5130Ea);
            bundle.putLong("clip_fileDuration", this.f5132Fa);
            this.f5155R = (C0989aa) getFragmentManager().findFragmentByTag("recnotes_fragment");
            StringBuilder sb = new StringBuilder();
            sb.append("<initResource> mEditFragment is null? ");
            sb.append(this.f5155R == null);
            C0938a.m5002a("SR/RecNotesActivity", sb.toString());
            if (this.f5155R == null) {
                this.f5155R = C0989aa.m5311a(bundle);
                FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
                beginTransaction.add(R.id.itemRecNotesContainer, this.f5155R, "recnotes_fragment");
                beginTransaction.commit();
            }
        }
    }

    /* renamed from: y */
    private void m6351y() {
        C0938a.m5002a("SR/RecNotesActivity", "<changeNavigationBar>");
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.control_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (C1418q.m6857a(this.f5125C)) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (C1413m.m6844f()) {
            layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.margin_bottom_note_play_btn_nonar));
        } else {
            layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.margin_bottom_note_play_btn_nonar_x));
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public boolean m6354z() {
        if (!C1419r.m6859a() || C1387D.m6762a((Context) AppFeature.m6734b())) {
            return false;
        }
        this.f5164Y = false;
        C1468d.m7207a((Activity) this, this.f5146Ma, this.f5148Na);
        return true;
    }

    /* renamed from: k */
    public boolean mo5840k() {
        String str = this.f5207v;
        if (str == null) {
            return false;
        }
        if (str.endsWith(".m4a") || this.f5207v.endsWith(".amr") || this.f5207v.endsWith(".wav")) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    public void mo5841l() {
        if (C1413m.m6844f()) {
            this.f5124Ba.mo6521a(getResources().getString(R.string.rtot_stop), R.drawable.iqoo_btn_recorder_stop_convert_selector, false);
        } else {
            this.f5124Ba.mo6521a(getResources().getString(R.string.rtot_stop), R.drawable.btn_recorder_stop_convert_selector, false);
        }
        if (this.f5162W == null) {
            this.f5162W = ObjectAnimator.ofFloat(this.f5124Ba.getmImageView(), "rotation", new float[]{0.0f, 45.0f, 90.0f, 135.0f, 180.0f, 225.0f, 270.0f, 315.0f, 360.0f}).setDuration(1000);
        }
        this.f5162W.setRepeatCount(-1);
        this.f5162W.start();
        this.f5162W.addListener(new C1264M(this));
    }

    /* renamed from: m */
    public void mo5842m() {
        C0938a.m5002a("SR/RecNotesActivity", "<checkItemLongDialog>");
        if (this.f5123B != null && mo5860r()) {
            this.f5123B.dismiss();
            this.f5123B.cancel();
        }
        if (this.f5121A != null && mo5860r()) {
            this.f5121A.dismiss();
            this.f5121A.cancel();
        }
    }

    /* renamed from: n */
    public void mo5843n() {
        DialogInterface.OnClickListener onClickListener;
        if (C1028b.m5456a().mo5371b()) {
            onClickListener = C1416p.m6851a().mo6152d() ? this.f5190ma : this.f5196pa;
        } else {
            onClickListener = C1416p.m6851a().mo6152d() ? this.f5192na : this.f5194oa;
        }
        C1407j.m6809a().mo6146a(this, C1416p.m6851a().mo6150b(), onClickListener, R.string.set_ringtone);
    }

    /* renamed from: o */
    public void mo5844o() {
        C0938a.m5002a("SR/RecNotesActivity", this.f5207v + "executePlayBack " + this.f5130Ea);
        this.f5151P = this.f5149O.getCallState();
        C0938a.m5002a("SR/RecNotesActivity", "<executePlayBack>,mOldCallState = " + this.f5151P);
        if (this.f5151P == 2) {
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.call_not_play), 0).show();
        } else {
            this.f5129E.mo5873a(this.f5207v);
        }
    }

    /* renamed from: p */
    public void mo5858p() {
        if (C1472g.m7218a()) {
            if (m6272O()) {
                C1468d.m7213e(this, this.f5150Oa);
            } else {
                C1468d.m7208a((Activity) this, this.f5152Pa, C1465b.f5984b);
            }
        } else if (C1470f.m7214a().mo6409b(this.f5197q)) {
            C1468d.m7206a(this, this.f5154Qa);
        } else {
            m6283Z();
        }
    }

    /* renamed from: q */
    public void mo5859q() {
        ObjectAnimator objectAnimator = this.f5162W;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f5162W = null;
        }
        if (C1413m.m6844f()) {
            this.f5124Ba.mo6521a(getResources().getString(R.string.rtot_recording_to_text), R.drawable.iqoo_btn_recorder_convert_selector, false);
        } else {
            this.f5124Ba.mo6521a(getResources().getString(R.string.rtot_recording_to_text), R.drawable.btn_recorder_convert_selector, false);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f5124Ba.getmImageView(), "rotation", new float[]{0.0f}).setDuration(10);
        duration.start();
        duration.addListener(new C1266N(this, duration));
    }

    /* renamed from: r */
    public boolean mo5860r() {
        return !isDestroyed() && !isFinishing();
    }

    /* renamed from: s */
    public void mo5861s() {
        C0938a.m5002a("SR/RecNotesActivity", "<menuSetOnItemLongClickListener>");
        if (!C1424v.m6870a("android.permission.READ_PHONE_STATE", this)) {
            this.f5153Q.postDelayed(new C1344m(this), 300);
        } else {
            mo5843n();
        }
    }

    /* renamed from: t */
    public void mo5862t() {
        C0938a.m5002a("SR/RecNotesActivity", "<performRenameOperation>");
        C1407j.m6809a().mo6144a(this, new C1297V(this), this.f5205u);
    }

    /* renamed from: u */
    public void mo5863u() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.activity.RecNotesActivity.MARKRECEIVER");
        registerReceiver(this.f5168ba, intentFilter);
    }

    /* renamed from: v */
    public void mo5864v() {
        this.f5145M = new C1277c(this, (C1367u) null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_PLAYBACK_STATE");
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_HEADSET_CONNECTION");
        registerReceiver(this.f5145M, intentFilter);
    }

    /* renamed from: w */
    public void mo5865w() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f5166aa, intentFilter);
    }

    /* renamed from: x */
    public void mo5866x() {
        HashMap hashMap = new HashMap();
        int i = C1413m.f5709g;
        if (i == 0) {
            hashMap.put("speed", "0.5");
        } else if (i == 1) {
            hashMap.put("speed", "1.0");
        } else if (i == 2) {
            hashMap.put("speed", "1.5");
        } else if (i == 3) {
            hashMap.put("speed", "2.0");
        }
        hashMap.put("file_type", this.f5193o ? "1" : "2");
        hashMap.put("zone", "2");
        C1390G.m6778a("A107|10011", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6323e(boolean z) {
        m6325f(z);
        PlaybackService.C1442a aVar = this.f5143L;
        if (aVar != null) {
            aVar.mo6307c(z ^ true ? 1 : 0);
        }
        setVolumeControlStream(z ? 3 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6325f(boolean z) {
        if (this.f5157S != null) {
            if (z) {
                if (C1413m.m6844f()) {
                    this.f5157S.setRightButtonIcon(R.drawable.iqoo_detail_play_speaker_mode);
                } else {
                    this.f5157S.setRightButtonIcon(R.drawable.btn_detail_play_speaker_selector);
                }
            } else if (C1413m.m6844f()) {
                this.f5157S.setRightButtonIcon(R.drawable.iqoo_detail_play_handset_mode);
            } else {
                this.f5157S.setRightButtonIcon(R.drawable.btn_detail_play_handset_selector);
            }
        }
    }

    /* renamed from: g */
    public void mo5199g() {
        C0938a.m5002a("SR/RecNotesActivity", "<returnNotesFragment>");
        m6299a(this.f5189m, false, 0);
    }

    /* renamed from: h */
    public void mo5245h() {
        m6299a(false, this.f5187l, 0);
    }

    /* renamed from: i */
    public void mo5200i() {
        C0927a.m4982a().mo5050a(new C1275a(), 0);
        this.f5129E.f5225f.mo6450a();
        this.f5129E.mo5879e();
    }

    /* renamed from: b */
    private void m6307b(Bundle bundle) {
        if (bundle != null) {
            this.f5205u = bundle.getString("RecListViewFileName");
            this.f5197q = bundle.getInt("RecListViewFileId");
            this.f5207v = bundle.getString("FileIdToPath");
            this.f5201s = bundle.getLong("FileDuration");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6318d(boolean z) {
        BbkTitleView bbkTitleView = this.f5157S;
        if (bbkTitleView != null) {
            bbkTitleView.getRightButton().setEnabled(z);
            if (z) {
                this.f5157S.getRightButton().setAlpha(1.0f);
            } else {
                this.f5157S.getRightButton().setAlpha(0.5f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m6312c(long j) {
        C0938a.m5002a("SR/RecNotesActivity", "<isNeedReturnForMark> marktime: " + j);
        int size = this.f5129E.f5231l.size();
        boolean z = false;
        if (size > 0) {
            int i = 0;
            while (true) {
                if (i < size && ((Long) this.f5129E.f5231l.get(i)).longValue() - j <= 1000) {
                    if (((Long) this.f5129E.f5231l.get(i)).longValue() - j < 1000 && j - ((Long) this.f5129E.f5231l.get(i)).longValue() < 1000) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        C0938a.m5002a("SR/RecNotesActivity", "<isNeedReturnForMark> temp: " + z);
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m6328g(boolean z) {
        if (z) {
            mo5841l();
        } else {
            mo5859q();
        }
    }

    /* renamed from: e */
    public long mo5270e() {
        return this.f5136Ha;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m6306b(long j) {
        C0938a.m5002a("SR/RecNotesActivity", "<addMarkTimeToDB> marktime: " + j);
        if (this.f5143L != null) {
            String b = this.f5135H.mo5185b();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_mark_recfile_id", Integer.valueOf(this.f5197q));
            contentValues.put("_mark_path", this.f5207v);
            contentValues.put("_mark_time_length", Long.valueOf(j));
            contentValues.put("_mark_name", b);
            C1018a aVar = this.f5133G;
            if (aVar != null) {
                try {
                    aVar.mo5341a("recordermarks", contentValues);
                } catch (Exception e) {
                    C0938a.m5004b("SR/RecNotesActivity", "<addMarksToDB>,Exception = " + e);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo5268c() {
        this.f5136Ha = SystemClock.uptimeMillis();
    }

    /* renamed from: f */
    public void mo5271f() {
        if (this.f5143L != null) {
            if (this.f5129E.f5234o >= 0) {
                this.f5143L.mo6304b(this.f5129E.f5234o);
            }
            if (this.f5129E.mo5874b() == 3) {
                this.f5143L.mo6313i();
            }
        }
    }

    /* renamed from: a */
    public void mo5837a(Bundle bundle) {
        C1424v.m6869a(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 123, (Activity) this);
        if (C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", this) && C1424v.m6870a("android.permission.READ_EXTERNAL_STORAGE", this)) {
            this.f5127D = m6289a(getIntent());
        }
        if (bundle != null) {
            C0938a.m5002a("SR/RecNotesActivity", "<onCreate> savedInstanceState is not null");
            m6307b(bundle);
        }
        if (this.f5127D != null) {
            C1413m.f5714l = this.f5207v;
        }
    }

    /* renamed from: b */
    private long m6304b(String str) {
        C0938a.m5002a("SR/RecNotesActivity", "<getDuration> filePath: " + str);
        MediaExtractor mediaExtractor = new MediaExtractor();
        long j = 0;
        try {
            mediaExtractor.setDataSource(str);
            if (mediaExtractor.getTrackCount() > 0) {
                j = mediaExtractor.getTrackFormat(0).getLong("durationUs") / 1000;
            }
        } catch (Exception e) {
            C0938a.m5004b("SR/RecNotesActivity", "<getDuration> mediaExtractor Exception: " + e.getMessage());
        } catch (Throwable th) {
            mediaExtractor.release();
            throw th;
        }
        mediaExtractor.release();
        C0938a.m5002a("SR/RecNotesActivity", "<getDuration> duration: " + j);
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c2 A[SYNTHETIC, Splitter:B:23:0x00c2] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.os.Bundle m6289a(android.content.Intent r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L_0x0004
            r9 = 0
            return r9
        L_0x0004:
            java.lang.String r0 = "dataFromFileManager"
            android.os.Parcelable r1 = r9.getParcelableExtra(r0)
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "<parseForFileManagerIntent> has uriFromFileManager: "
            r2.append(r3)
            boolean r0 = r9.hasExtra(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "SR/RecNotesActivity"
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r0)
            com.android.common.utils.x r0 = r8.f5131F
            r3 = 0
            android.database.Cursor r0 = r0.mo6192a((boolean) r3)
            r4 = 1
            if (r1 == 0) goto L_0x0087
            java.lang.String r5 = r1.toString()
            int r5 = r5.length()
            if (r5 <= 0) goto L_0x0087
            r8.f5183j = r4
            com.android.common.utils.C1413m.f5709g = r4
            java.lang.String r9 = r1.getScheme()
            java.lang.String r5 = "file"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x0067
            java.lang.String r9 = r1.getPath()
            int r9 = r8.m6284a((android.database.Cursor) r0, (java.lang.String) r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "<parseForFileManagerIntent> that is a file type, fileId is "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r1)
            goto L_0x0080
        L_0x0067:
            long r5 = android.content.ContentUris.parseId(r1)
            int r9 = (int) r5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "<parseForFileManagerIntent> that is a URI type, fileId is "
            r1.append(r5)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            p050c.p051a.p058e.p059a.C0938a.m5002a(r2, r1)
        L_0x0080:
            com.android.common.utils.x r1 = r8.f5131F
            android.os.Bundle r9 = r1.mo6193a((int) r9)
            goto L_0x008d
        L_0x0087:
            r8.f5183j = r3
            android.os.Bundle r9 = r9.getExtras()
        L_0x008d:
            if (r9 == 0) goto L_0x0097
            r8.m6307b((android.os.Bundle) r9)
            java.lang.String r1 = r8.f5205u
            r8.setTitle(r1)
        L_0x0097:
            java.lang.String r1 = r8.f5207v
            if (r1 == 0) goto L_0x00be
            java.lang.String r5 = ".m4a"
            boolean r1 = r1.contains(r5)
            if (r1 == 0) goto L_0x00be
            java.lang.String r1 = r8.f5207v
            java.lang.String r6 = "."
            int r6 = r1.lastIndexOf(r6)
            java.lang.String r7 = r8.f5207v
            int r7 = r7.length()
            java.lang.String r1 = r1.substring(r6, r7)
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x00be
            r8.f5193o = r4
            goto L_0x00c0
        L_0x00be:
            r8.f5193o = r3
        L_0x00c0:
            if (r0 == 0) goto L_0x00cc
            r0.close()     // Catch:{ Throwable -> 0x00c6 }
            goto L_0x00cc
        L_0x00c6:
            r0 = move-exception
            java.lang.String r1 = "fail to close"
            p050c.p051a.p058e.p059a.C0938a.m5005b(r2, r1, r0)
        L_0x00cc:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.activity.RecNotesActivity.m6289a(android.content.Intent):android.os.Bundle");
    }

    /* renamed from: b */
    public int mo5266b() {
        int i;
        if (this.f5143L == null) {
            C0938a.m5004b("SR/RecNotesActivity", "mPlaybackControllerBinder == null");
            this.f5155R.mo5254c();
            return -1;
        }
        if (this.f5129E.f5237r == 3 || this.f5129E.f5237r == 4) {
            i = this.f5143L.mo6306c();
            if (i >= this.f5129E.f5235p) {
                i = this.f5129E.f5235p;
                this.f5155R.mo5252b();
                this.f5143L.mo6315k();
            }
        } else if (this.f5129E.f5237r == 6) {
            i = this.f5143L.mo6308d();
        } else {
            i = this.f5129E.f5233n;
        }
        int unused = this.f5129E.f5234o = i;
        return i;
    }

    /* renamed from: a */
    private int m6284a(Cursor cursor, String str) {
        if (cursor == null || cursor.getCount() == 0 || str == null) {
            C0938a.m5008e("SR/RecNotesActivity", "<getFileIdFromFilePath> error");
            return -1;
        }
        C0938a.m5002a("SR/RecNotesActivity", "<getFileIdFromFilePath>, filePath = " + str);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (str.equals(cursor.getString(1))) {
                return cursor.getInt(0);
            }
            cursor.moveToNext();
        }
        C0938a.m5002a("SR/RecNotesActivity", "<getFileIdFromFilePath>, targetFileId:" + -1);
        return -1;
    }

    /* renamed from: a */
    public void mo5198a(long j) {
        C0938a.m5002a("SR/RecNotesActivity", "<changeToMarkTime> currentTime: " + j);
        int i = (int) j;
        PlaybackService.C1442a aVar = this.f5143L;
        if (aVar != null) {
            aVar.mo6304b(i);
        }
        C0989aa aaVar = this.f5155R;
        if (aaVar != null) {
            aaVar.mo5248a(i);
        }
        this.f5129E.mo5875b(j);
        C1276b bVar = this.f5129E;
        bVar.mo5872a((long) i, bVar.f5226g);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m6285a(ListAdapter listAdapter) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.list_popup_window_min);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.list_popup_window_max);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i3 = 0; i3 < count; i3++) {
            int itemViewType = listAdapter.getItemViewType(i3);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(this);
            }
            view = listAdapter.getView(i3, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth > i) {
                i = measuredWidth;
            }
        }
        if (i < dimensionPixelSize) {
            return dimensionPixelSize;
        }
        return i > dimensionPixelSize2 ? dimensionPixelSize2 : i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6296a(int i) {
        HashMap hashMap = new HashMap();
        if (i == 0) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_DELETED");
            m6274Q();
            try {
                hashMap.put("button_name", "1");
                C1390G.m6779b("A107|4|3|10", hashMap);
            } catch (Exception e) {
                C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e);
            }
        } else if (i == 1) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_RENAME");
            mo5862t();
            try {
                hashMap.put("button_name", "2");
                C1390G.m6779b("A107|4|3|10", hashMap);
            } catch (Exception e2) {
                C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e2);
            }
        } else if (i == 2) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_SHARE");
            m6280W();
            try {
                hashMap.put("button_name", "3");
                C1390G.m6779b("A107|4|3|10", hashMap);
            } catch (Exception e3) {
                C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e3);
            }
        } else if (i == 3) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_SET");
            mo5861s();
            try {
                hashMap.put("button_name", "4");
                C1390G.m6779b("A107|4|3|10", hashMap);
            } catch (Exception e4) {
                C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e4);
            }
        } else if (i == 4) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, isSupportEdit: " + this.f5193o);
            m6320da();
        } else if (i == 5) {
            C0938a.m5002a("SR/RecNotesActivity", "<mMoreListener>, MENU_PROPERTY");
            m6281X();
            try {
                hashMap.put("button_name", "6");
                C1390G.m6779b("A107|4|3|10", hashMap);
            } catch (Exception e5) {
                C0938a.m5004b("SR/RecNotesActivity", "A107|4|3|10Vcode error:" + e5);
            }
        }
        VivoContextListDialog vivoContextListDialog = this.f5170ca;
        if (vivoContextListDialog != null && vivoContextListDialog.isShowing() && !isFinishing() && !isDestroyed()) {
            this.f5170ca.dismiss();
        }
        ListPopupWindow listPopupWindow = this.f5172da;
        if (listPopupWindow != null && listPopupWindow.isShowing() && !isFinishing() && !isDestroyed()) {
            this.f5172da.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6300a(int[] iArr, String[] strArr) {
        PlaybackService.C1442a aVar;
        C0938a.m5002a("SR/RecNotesActivity", "<performDelete>");
        if ("mounted".equals(this.f5167b.mo6175g())) {
            if (C1465b.f5983a == this.f5197q) {
                C1465b.m7197b().mo6399a();
            } else {
                C1470f.m7214a().mo6408a(this.f5197q);
            }
            if ((this.f5129E.f5237r == 3 || this.f5129E.f5237r == 4) && (aVar = this.f5143L) != null) {
                aVar.mo6315k();
            }
            boolean a = C1427y.m6927a(this.f5125C, iArr);
            C0938a.m5002a("SR/RecNotesActivity", "<performDelete>,deleteFlag = " + a);
            if (a) {
                C1427y.m6921a(this.f5125C, a, iArr);
                C1427y.m6922a(this.f5125C, strArr);
            }
            if (a) {
                finish();
            }
        }
    }

    /* renamed from: a */
    public void mo5836a(DialogInterface dialogInterface, boolean z) {
        C0938a.m5002a("SR/RecNotesActivity", "<checkDialogExit(DialogInterface dialogRename, " + z + ")>");
        if (dialogInterface != null && mo5860r()) {
            try {
                Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
                declaredField.setAccessible(true);
                declaredField.set(dialogInterface, Boolean.valueOf(z));
                if (mo5860r()) {
                    dialogInterface.dismiss();
                }
            } catch (Exception e) {
                C0938a.m5004b("SR/RecNotesActivity", "<checkDialogExit>,Exception = " + e);
            }
        }
    }

    /* renamed from: a */
    public void mo5835a(DialogInterface dialogInterface) {
        boolean z;
        DialogInterface dialogInterface2 = dialogInterface;
        C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry(DialogInterface dialogRename)>");
        String obj = this.f5213y.getText().toString();
        Cursor a = C1426x.m6909a(this.f5125C).mo6192a(false);
        String str = this.f5207v;
        int i = this.f5197q;
        if (obj == null || str == null) {
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry> title or selectedPath is null !");
            return;
        }
        File file = new File(str);
        String c = C1383b.m6743c(str);
        C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,title = " + obj);
        if (obj.length() == 0) {
            mo5836a(dialogInterface2, false);
            return;
        }
        if (C1426x.m6908a(a, obj + c) > 0 && !obj.equals(this.f5205u)) {
            this.f5209w.setText(getString(R.string.tip));
            this.f5209w.setTextColor(-65536);
            this.f5213y.selectAll();
            mo5836a(dialogInterface2, false);
        } else if (obj.startsWith(".")) {
            this.f5209w.setTextColor(-65536);
            this.f5209w.setText(R.string.errorNameStartWidthDot);
            mo5836a(dialogInterface2, false);
        } else if (C1383b.m6745e(obj)) {
            this.f5209w.setTextColor(-65536);
            this.f5209w.setText(R.string.errorFileNameAllSpaces);
            mo5836a(dialogInterface2, false);
        } else if (obj.getBytes().length > C1383b.f5641d) {
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,INPUT_CHAR_MAX_LENGTH = " + C1383b.f5641d);
            mo5836a(dialogInterface2, false);
        } else if (C1383b.m6744d(obj)) {
            new AlertDialog.Builder(this).setPositiveButton(R.string.autofilter, new C1341l(this, dialogInterface2)).setNegativeButton(R.string.revise_byoneself, new C1338k(this)).setTitle(R.string.illchartip).setMessage(getString(R.string.illcharmessage)).show().setOwnerActivity(this);
            mo5836a(dialogInterface2, false);
        } else if (C1383b.m6741a(obj)) {
            this.f5209w.setTextColor(-65536);
            this.f5209w.setText(R.string.rename_not_support_emoji);
            mo5836a(dialogInterface2, false);
        } else if (obj != null && obj.length() > 0 && obj.getBytes().length <= C1383b.f5641d) {
            if (C1426x.m6908a(a, obj + c) != -1) {
                if (C1426x.m6908a(a, obj + c) != i) {
                    return;
                }
            }
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,selectedId=" + i);
            if (!file.exists()) {
                C1492b.m7431a((Context) this, (CharSequence) getString(R.string.file_rename_not_exit), 0).show();
                mo5836a(dialogInterface2, true);
                dialogInterface.cancel();
                return;
            }
            String substring = str.substring(0, str.lastIndexOf("/") + 1);
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,suffix=" + c);
            String str2 = substring + obj + c;
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,newFilePath = " + str2);
            File file2 = new File(str2);
            if (C1426x.m6908a(a, obj + c) == i) {
                C1492b.m7431a((Context) this, (CharSequence) getString(R.string.renamed_message), 0).show();
                mo5836a(dialogInterface2, true);
                dialogInterface.cancel();
                return;
            }
            if (str.equalsIgnoreCase(str2)) {
                File file3 = new File(str + Long.toString(C1383b.m6742b(str)));
                file.renameTo(file3);
                z = file3.renameTo(file2);
            } else if (file2.exists()) {
                this.f5209w.setText(getString(R.string.tip));
                this.f5209w.setTextColor(-65536);
                this.f5213y.selectAll();
                mo5836a(dialogInterface2, false);
                return;
            } else {
                z = file.renameTo(file2);
            }
            if (!z) {
                mo5836a(dialogInterface2, true);
                C1492b.m7431a((Context) this, (CharSequence) getString(R.string.renamed_message_fail), 0).show();
                dialogInterface.cancel();
                return;
            }
            ContentResolver contentResolver = getContentResolver();
            ContentValues contentValues = new ContentValues();
            String c2 = C1383b.m6743c(file2.getAbsolutePath());
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,newSuffix=" + c2);
            contentValues.put("_display_name", obj + c2);
            contentValues.put("title", obj);
            contentValues.put("_data", str2);
            if (c2.equals(".m4a")) {
                contentValues.put("mime_type", "audio/mp4");
            } else if (c2.equals(".amr")) {
                contentValues.put("mime_type", "audio/amr");
            }
            C0938a.m5002a("SR/RecNotesActivity", "<fileRenameEntry>,title = " + obj + ",newSuffix = " + c2 + ",selectedId = " + i + ",newFilePath = " + str2);
            boolean a2 = mo5839a(i, obj);
            StringBuilder sb = new StringBuilder();
            sb.append("<fileRenameEntry>,sUpdateFlag = ");
            sb.append(a2);
            C0938a.m5002a("SR/RecNotesActivity", sb.toString());
            try {
                if (contentResolver.update(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues, "_id=?", new String[]{Long.valueOf((long) i).toString()}) == -1) {
                    C1492b.m7431a((Context) this, (CharSequence) getString(R.string.renamed_message_fail), 0).show();
                } else {
                    C1492b.m7431a((Context) this, (CharSequence) getString(R.string.renamed_message), 0).show();
                    if (C1472g.m7218a() && this.f5197q == C1465b.f5983a && !TextUtils.isEmpty(obj)) {
                        C1465b.f5984b = obj;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                C1492b.m7431a((Context) this, (CharSequence) getString(R.string.renamed_message_fail), 0).show();
            }
            C1020b.m5436a(this.f5207v, str2);
            C0974e eVar = this.f5135H;
            eVar.f4110f = str2;
            eVar.mo5188d();
            this.f5207v = str2;
            this.f5205u = obj;
            this.f5157S.setCenterText(this.f5205u);
            PlaybackService.C1442a aVar = this.f5143L;
            if (aVar != null) {
                aVar.mo6302a(str2);
            }
            mo5836a(dialogInterface2, true);
            dialogInterface.cancel();
        }
    }

    /* renamed from: a */
    public boolean mo5839a(int i, String str) {
        StringBuilder sb;
        C0938a.m5002a("SR/RecNotesActivity", "<updateRecFileNameById>,sRecFileName = " + str + ",sRecFileId = " + i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_recfile_id='");
        sb2.append(i);
        sb2.append("'");
        String sb3 = sb2.toString();
        C0938a.m5002a("SR/RecNotesActivity", "<updateRecFileNameById>,table = " + "notesimages" + ",where = " + sb3);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_reserved_bbb", str);
        C1018a aVar = this.f5133G;
        boolean z = false;
        if (aVar != null) {
            Cursor cursor = null;
            try {
                Cursor a = aVar.mo5342a("notesimages", C0935b.f3880b, sb3);
                boolean z2 = true;
                if (a != null) {
                    int count = a.getCount();
                    C0938a.m5002a("SR/RecNotesActivity", "<updateRecFileNameById>,mRecFileCursor.getCount() = " + count);
                    if (count > 1) {
                        C0938a.m5008e("SR/RecNotesActivity", "<updateRecFileNameById>,mRecFileCursor is more");
                    }
                }
                if (a == null || a.getCount() != 1) {
                    z2 = false;
                } else {
                    a.moveToFirst();
                    int i2 = a.getInt(0);
                    String string = a.getString(1);
                    this.f5133G.mo5346a("notesimages", sb3, contentValues);
                    C0938a.m5002a("SR/RecNotesActivity", "<updateRecFileNameById>,sQueryRecFileId = " + i2 + ",sQueryRecFileName = " + string);
                }
                if (a != null) {
                    try {
                        a.close();
                    } catch (Exception e) {
                        e = e;
                        sb = new StringBuilder();
                    }
                }
                z = z2;
            } catch (Exception e2) {
                C0938a.m5004b("SR/RecNotesActivity", "<updateRecFileNameById>,Exception1 = " + e2);
                e2.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        C0938a.m5004b("SR/RecNotesActivity", "<updateRecFileNameById>,Exception2 = " + e4);
                    }
                }
                throw th;
            }
        } else {
            C0938a.m5004b("SR/RecNotesActivity", "<updateRecFileNameById>,mDB is null,error ");
        }
        C0938a.m5002a("SR/RecNotesActivity", "<updateRecFileNameById>,sFlag = " + z);
        return z;
        sb.append("<updateRecFileNameById>,Exception2 = ");
        sb.append(e);
        C0938a.m5004b("SR/RecNotesActivity", sb.toString());
        C0938a.m5002a("SR/RecNotesActivity", "<updateRecFileNameById>,sFlag = " + z);
        return z;
    }

    /* renamed from: a */
    public String mo5834a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = str.substring(str.lastIndexOf(".") + 1, str.length());
            } catch (Exception e) {
                C0938a.m5004b("SR/RecNotesActivity", "<getFileSuffix>,Exception = " + e);
            }
        }
        C0938a.m5002a("SR/RecNotesActivity", "<getFileSuffix>,suffix = " + str2);
        if (str2 != null) {
            return str2;
        }
        C0938a.m5008e("SR/RecNotesActivity", "<getFileSuffix>,return error");
        return "m4a";
    }

    /* renamed from: a */
    private void m6299a(boolean z, boolean z2, int i) {
        C0938a.m5002a("SR/RecNotesActivity", "resetViewPager");
        this.f5189m = z;
        this.f5187l = z2;
        if (z && !this.f5175f.contains(this.f5139J)) {
            this.f5175f.add(0, this.f5139J);
        }
        if (!z) {
            this.f5175f.remove(this.f5139J);
        }
        if (z2 && !this.f5175f.contains(this.f5135H)) {
            if (z) {
                this.f5175f.add(1, this.f5135H);
            } else {
                this.f5175f.add(0, this.f5135H);
            }
        }
        if (!z2) {
            this.f5175f.remove(this.f5135H);
        }
        C0962T t = this.f5173e;
        if (t != null) {
            t.mo4032b();
        }
        this.f5141K.removeAllViews();
        if (this.f5175f.size() > 1) {
            this.f5141K.mo6471a(this.f5171d, i);
            this.f5141K.setmIsDisplay(true);
            this.f5171d.setCurrentItem(i);
            return;
        }
        this.f5141K.setmIsDisplay(false);
    }

    /* renamed from: a */
    public void mo5838a(String str, Activity activity) {
        new AlertDialog.Builder(activity).setMessage(String.format(C1424v.m6867a(), new Object[]{activity.getString(R.string.app_name), str})).setTitle(R.string.unable_to_use_xx_permissions_title).setCancelable(false).setOnCancelListener(new C1377z(this, activity)).setPositiveButton(R.string.permission_dialog_button_go_set, new C1375y(this, activity)).setNegativeButton(R.string.cancel, new C1373x(this, activity)).create().show();
    }

    /* renamed from: a */
    public void mo5264a(int i, int i2, int i3) {
        int unused = this.f5129E.f5233n = i;
        int unused2 = this.f5129E.f5234o = i3;
        int unused3 = this.f5129E.f5235p = i2;
        if (this.f5134Ga) {
        }
    }

    /* renamed from: a */
    public void mo5265a(boolean z) {
        if (this.f5129E.f5237r == 3) {
            this.f5134Ga = true;
        }
        PlaybackService.C1442a aVar = this.f5143L;
        if (aVar != null) {
            aVar.mo6307c(z ^ true ? 1 : 0);
        }
    }
}
