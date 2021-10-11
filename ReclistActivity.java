package com.android.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
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
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.C0324b;
import com.android.bbksoundrecorder.AppFeature;
import com.android.bbksoundrecorder.R;
import com.android.common.utils.C1384A;
import com.android.common.utils.C1386C;
import com.android.common.utils.C1390G;
import com.android.common.utils.C1407j;
import com.android.common.utils.C1411k;
import com.android.common.utils.C1413m;
import com.android.common.utils.C1416p;
import com.android.common.utils.C1424v;
import com.android.common.utils.C1425w;
import com.android.common.utils.C1426x;
import com.android.common.utils.p101a.C1395d;
import com.android.search.C1432a;
import com.android.search.C1433b;
import com.android.search.C1434c;
import com.android.search.SearchView;
import com.android.service.PlaybackService;
import com.android.view.widget.C1492b;
import com.android.view.widget.CustomViewPager;
import com.android.view.widget.IndicatorSeekBar;
import com.vivo.app.VivoContextListDialog;
import com.vivo.common.BbkTitleView;
import com.vivo.common.TabSelector;
import com.vivo.common.animation.FakeView;
import com.vivo.common.animation.LKListView;
import com.vivo.common.widget.TabTitleView;
import com.vivo.easytransfer.C1882a;
import com.vivo.provider.VivoSettings;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p050c.p051a.p055c.p056a.C0935b;
import p050c.p051a.p057d.C0937a;
import p050c.p051a.p058e.p059a.C0938a;
import p050c.p051a.p060f.C0953O;
import p050c.p051a.p060f.C0961S;
import p050c.p051a.p062g.p063a.C1018a;
import p050c.p051a.p062g.p063a.C1020b;
import p050c.p051a.p065i.p066a.C1028b;
import vivo.util.VivoThemeUtil;

public class ReclistActivity extends Activity implements AbsListView.OnScrollListener, C0953O.C0955b, SearchView.C1429a, SearchView.C1430b {

    /* renamed from: a */
    public static boolean f5246a = false;

    /* renamed from: b */
    public static boolean f5247b = false;

    /* renamed from: c */
    public static boolean f5248c = false;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f5249A = -1;
    /* access modifiers changed from: private */

    /* renamed from: Aa */
    public TextView f5250Aa;

    /* renamed from: B */
    private int f5251B = 0;

    /* renamed from: Ba */
    private TextView f5252Ba;

    /* renamed from: C */
    public int f5253C = 0;

    /* renamed from: Ca */
    private ReclistPageAddMarkReceiver f5254Ca = new ReclistPageAddMarkReceiver();
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f5255D = 0;

    /* renamed from: Da */
    private ArrayList<C0937a> f5256Da = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f5257E = 0;
    /* access modifiers changed from: private */

    /* renamed from: Ea */
    public boolean f5258Ea = false;

    /* renamed from: F */
    public C1282c f5259F = null;

    /* renamed from: Fa */
    private C1280a f5260Fa;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public Context f5261G;

    /* renamed from: Ga */
    private View.OnTouchListener f5262Ga = new C1237Ba(this);

    /* renamed from: H */
    private Cursor f5263H;

    /* renamed from: Ha */
    private AdapterView.OnItemClickListener f5264Ha = new C1239Ca(this);

    /* renamed from: I */
    private TelephonyManager f5265I;

    /* renamed from: Ia */
    private AdapterView.OnItemLongClickListener f5266Ia = new C1241Da(this);
    /* access modifiers changed from: private */

    /* renamed from: J */
    public BbkTitleView f5267J;

    /* renamed from: Ja */
    private View.OnClickListener f5268Ja = new C1251Fa(this);

    /* renamed from: K */
    private Dialog f5269K;

    /* renamed from: Ka */
    private View.OnClickListener f5270Ka = new C1312ba(this);

    /* renamed from: L */
    private TabTitleView f5271L;

    /* renamed from: La */
    AdapterView.OnItemClickListener f5272La = new C1315ca(this);

    /* renamed from: M */
    private TabSelector f5273M;

    /* renamed from: Ma */
    private View.OnClickListener f5274Ma = new C1318da(this);

    /* renamed from: N */
    private CustomViewPager f5275N;

    /* renamed from: Na */
    private View.OnClickListener f5276Na = new C1321ea(this);

    /* renamed from: O */
    private List<Fragment> f5277O;

    /* renamed from: Oa */
    private View.OnClickListener f5278Oa = new C1324fa(this);

    /* renamed from: P */
    private C0961S f5279P;

    /* renamed from: Pa */
    private View.OnClickListener f5280Pa = new C1327ga(this);
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public C0953O f5281Q = null;

    /* renamed from: Qa */
    private View.OnClickListener f5282Qa = new C1330ha(this);
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C0953O f5283R = null;

    /* renamed from: Ra */
    private DialogInterface.OnClickListener f5284Ra = new C1333ia(this);

    /* renamed from: S */
    private BroadcastReceiver f5285S = null;

    /* renamed from: Sa */
    private DialogInterface.OnClickListener f5286Sa = new C1336ja(this);

    /* renamed from: T */
    private Intent f5287T = null;

    /* renamed from: Ta */
    private DialogInterface.OnClickListener f5288Ta = new C1339ka(this);

    /* renamed from: U */
    public PlaybackService.C1442a f5289U;

    /* renamed from: Ua */
    private DialogInterface.OnClickListener f5290Ua = new C1345ma(this);

    /* renamed from: V */
    private C1281b f5291V;

    /* renamed from: Va */
    private BroadcastReceiver f5292Va = new C1368ua(this);

    /* renamed from: W */
    private ServiceConnection f5293W;

    /* renamed from: Wa */
    private DialogInterface.OnClickListener f5294Wa = new C1378za(this);

    /* renamed from: X */
    private Dialog f5295X = null;

    /* renamed from: Y */
    private AlertDialog f5296Y = null;

    /* renamed from: Z */
    private AlertDialog f5297Z = null;

    /* renamed from: aa */
    private AlertDialog f5298aa = null;

    /* renamed from: ba */
    public C1425w f5299ba = null;

    /* renamed from: ca */
    private C1018a f5300ca;

    /* renamed from: d */
    private boolean f5301d = true;

    /* renamed from: da */
    private C1395d f5302da;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f5303e = false;
    /* access modifiers changed from: private */

    /* renamed from: ea */
    public String f5304ea = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f5305f = false;
    /* access modifiers changed from: private */

    /* renamed from: fa */
    public C1426x f5306fa;

    /* renamed from: g */
    private boolean f5307g = false;
    /* access modifiers changed from: private */

    /* renamed from: ga */
    public List<C1432a> f5308ga = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f5309h = false;

    /* renamed from: ha */
    private C1284e f5310ha = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f5311i = false;

    /* renamed from: ia */
    private String[] f5312ia = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f5313j = false;

    /* renamed from: ja */
    private final Handler f5314ja = new Handler();

    /* renamed from: k */
    private boolean f5315k = false;

    /* renamed from: ka */
    private final Handler f5316ka = new Handler();

    /* renamed from: l */
    private boolean f5317l = false;

    /* renamed from: la */
    public boolean f5318la = false;

    /* renamed from: m */
    private boolean f5319m = false;

    /* renamed from: ma */
    public boolean f5320ma = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f5321n = false;
    /* access modifiers changed from: private */

    /* renamed from: na */
    public SearchView f5322na;

    /* renamed from: o */
    public boolean f5323o = false;
    /* access modifiers changed from: private */

    /* renamed from: oa */
    public LKListView f5324oa;

    /* renamed from: p */
    private boolean f5325p = false;

    /* renamed from: pa */
    private C1434c f5326pa = null;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f5327q = false;

    /* renamed from: qa */
    private View f5328qa = null;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f5329r = false;

    /* renamed from: ra */
    private FakeView f5330ra = null;

    /* renamed from: s */
    private boolean f5331s = false;

    /* renamed from: sa */
    private View f5332sa;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public String f5333t = null;
    /* access modifiers changed from: private */

    /* renamed from: ta */
    public TextView f5334ta;

    /* renamed from: u */
    public String f5335u = null;
    /* access modifiers changed from: private */

    /* renamed from: ua */
    public File f5336ua = null;

    /* renamed from: v */
    public String f5337v = null;

    /* renamed from: va */
    public boolean f5338va = true;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public long f5339w = 0;
    /* access modifiers changed from: private */

    /* renamed from: wa */
    public int f5340wa;

    /* renamed from: x */
    private long f5341x = 0;

    /* renamed from: xa */
    private ScreenPlayBroadcastReceiver f5342xa = new ScreenPlayBroadcastReceiver();
    /* access modifiers changed from: private */

    /* renamed from: y */
    public long f5343y = 0;
    /* access modifiers changed from: private */

    /* renamed from: ya */
    public ListPopupWindow f5344ya;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f5345z = -1;
    /* access modifiers changed from: private */

    /* renamed from: za */
    public VivoContextListDialog f5346za;

    public class ReclistPageAddMarkReceiver extends BroadcastReceiver {
        public ReclistPageAddMarkReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getIntExtra("addMark", -1) == 102) {
                C0938a.m5004b("SR/ReclistActivity", "add mark from notification page");
                if (!ReclistActivity.this.f5258Ea) {
                    ReclistActivity reclistActivity = ReclistActivity.this;
                    reclistActivity.mo5891c(reclistActivity.f5281Q.mo5100i(), ReclistActivity.this.f5281Q.mo5099h());
                    return;
                }
                ReclistActivity reclistActivity2 = ReclistActivity.this;
                reclistActivity2.mo5891c(reclistActivity2.f5283R.mo5100i(), ReclistActivity.this.f5283R.mo5099h());
            }
        }
    }

    public class ScreenPlayBroadcastReceiver extends BroadcastReceiver {
        public ScreenPlayBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            C0938a.m5002a("SR/ReclistActivity", "screen operationReclist" + action.toString());
            if (C1413m.f5702A != 0 || ReclistActivity.this.f5289U == null) {
                return;
            }
            if (action.equals("android.intent.action.SCREEN_OFF")) {
                if (ReclistActivity.this.f5289U.mo6310f() == 3 || ReclistActivity.this.f5289U.mo6310f() == 4) {
                    ReclistActivity.this.f5289U.mo6300a(101);
                    ReclistActivity.this.f5289U.mo6314j();
                }
            } else if (action.equals("android.intent.action.SCREEN_ON")) {
                ReclistActivity.this.f5289U.mo6300a(101);
                ReclistActivity.this.f5289U.mo6314j();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "2");
                    C1390G.m6779b("A107|8|2|7", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/ReclistActivity", "vcode error");
                }
            } else if (action.equals("android.intent.action.USER_PRESENT")) {
                ReclistActivity.this.f5289U.mo6300a(101);
                ReclistActivity.this.f5289U.mo6299a();
                if ((ReclistActivity.this.f5289U.mo6310f() == 3 || ReclistActivity.this.f5289U.mo6310f() == 4) && !ReclistActivity.f5247b) {
                    ReclistActivity.this.f5289U.mo6300a(101);
                    ReclistActivity.this.f5289U.mo6314j();
                }
            }
        }
    }

    /* renamed from: com.android.activity.ReclistActivity$b */
    private class C1281b extends BroadcastReceiver {
        private C1281b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int i = 0;
                if (intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_RESET_LIST")) {
                    if (intent.getBooleanExtra("need_reset_state", false)) {
                        ReclistActivity.this.mo5123a(0);
                        C1282c cVar = ReclistActivity.this.f5259F;
                        if ((cVar == null || cVar.getStatus() != AsyncTask.Status.RUNNING) && ReclistActivity.this.f5329r) {
                            boolean unused = ReclistActivity.this.f5329r = false;
                        }
                    }
                } else if (intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_HEADSET_CONNECTION")) {
                    boolean booleanExtra = intent.getBooleanExtra("headset_connection_state", false);
                    boolean unused2 = ReclistActivity.this.f5327q = booleanExtra;
                    C0938a.m5002a("SR/ReclistActivity", "MsgFromServiceReceiver headphone connection: " + booleanExtra);
                    boolean equals = ReclistActivity.this.f5299ba.mo6178i().equals("true");
                    if (ReclistActivity.this.f5255D == 0) {
                        if (ReclistActivity.this.f5281Q.f4041la != null) {
                            ReclistActivity.this.f5281Q.f4041la.mo5171a(!ReclistActivity.this.f5327q);
                        }
                    } else if (ReclistActivity.this.f5283R.f4041la != null) {
                        ReclistActivity.this.f5283R.f4041la.mo5171a(!ReclistActivity.this.f5327q);
                    }
                    ReclistActivity.this.f5281Q.f4033ha = ReclistActivity.this.f5327q;
                    ReclistActivity.this.f5283R.f4033ha = ReclistActivity.this.f5327q;
                    ReclistActivity reclistActivity = ReclistActivity.this;
                    if (equals) {
                        i = 3;
                    }
                    reclistActivity.setVolumeControlStream(i);
                } else {
                    PlaybackService.C1442a aVar = ReclistActivity.this.f5289U;
                    if ((aVar == null || aVar.mo6303b() == 101) && intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_PLAYBACK_STATE")) {
                        int intExtra = intent.getIntExtra("playback_state", 0);
                        C0938a.m5002a("SR/ReclistActivity", "MsgFromServiceReceiver state: " + intExtra);
                        if (intExtra != -1) {
                            ReclistActivity.this.mo5123a(intExtra);
                        }
                    }
                }
            }
        }

        /* synthetic */ C1281b(ReclistActivity reclistActivity, C1342la laVar) {
            this();
        }
    }

    /* renamed from: com.android.activity.ReclistActivity$c */
    private class C1282c extends AsyncTask<Integer, Integer, String> {
        private C1282c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Integer... numArr) {
            C0938a.m5002a("SR/ReclistActivity", "PlaybackProgressTask <doInBackground(Integer... params)>");
            if (isCancelled()) {
                return null;
            }
            ReclistActivity reclistActivity = ReclistActivity.this;
            reclistActivity.m6494f(reclistActivity.f5333t);
            return null;
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            C0938a.m5002a("SR/ReclistActivity", "PlaybackProgressTask <onCancelled>");
            PlaybackService.C1442a aVar = ReclistActivity.this.f5289U;
            if (aVar != null) {
                aVar.mo6315k();
            }
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            C0938a.m5002a("SR/ReclistActivity", "PlaybackProgressTask <onPreExecute>");
        }

        /* synthetic */ C1282c(ReclistActivity reclistActivity, C1342la laVar) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String str) {
            C0938a.m5002a("SR/ReclistActivity", "PlaybackProgressTask <onPostExecute(" + str + ")>,");
        }
    }

    /* renamed from: com.android.activity.ReclistActivity$d */
    private class C1283d implements ServiceConnection {
        private C1283d() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ReclistActivity reclistActivity = ReclistActivity.this;
            reclistActivity.f5289U = (PlaybackService.C1442a) iBinder;
            PlaybackService.C1442a aVar = reclistActivity.f5289U;
            if (aVar != null) {
                aVar.mo6300a(101);
                C0938a.m5002a("SR/ReclistActivity", "<onServiceConnected> itemClickFileId: " + ReclistActivity.this.f5345z);
                if (ReclistActivity.this.f5345z != -1) {
                    ReclistActivity reclistActivity2 = ReclistActivity.this;
                    long unused = reclistActivity2.f5339w = reclistActivity2.mo5887b(reclistActivity2.f5333t);
                    int f = ReclistActivity.this.f5289U.mo6310f();
                    C0938a.m5002a("SR/ReclistActivity", "<onServiceConnected> state: " + f);
                    C0938a.m5002a("SR/ReclistActivity", "<onServiceConnected> mOrdFragment.isListFragmentActive: " + ReclistActivity.this.f5281Q.f4039ka);
                    C0938a.m5002a("SR/ReclistActivity", "<onServiceConnected> mCallFragment.isListFragmentActive: " + ReclistActivity.this.f5283R.f4039ka);
                    if (ReclistActivity.this.f5281Q.f4039ka && ReclistActivity.this.f5283R.f4039ka) {
                        ReclistActivity.this.mo5123a(f);
                        if (ReclistActivity.this.f5255D == 0) {
                            ReclistActivity.this.f5281Q.mo5089a(ReclistActivity.this.f5333t, ReclistActivity.this.f5339w, ReclistActivity.this.f5345z, ReclistActivity.this.f5249A);
                        } else {
                            ReclistActivity.this.f5283R.mo5089a(ReclistActivity.this.f5333t, ReclistActivity.this.f5339w, ReclistActivity.this.f5345z, ReclistActivity.this.f5249A);
                        }
                    } else if (f != 0) {
                        ReclistActivity.this.f5289U.mo6315k();
                    }
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0938a.m5002a("SR/ReclistActivity", "<onServiceDisconnected>");
        }

        /* synthetic */ C1283d(ReclistActivity reclistActivity, C1342la laVar) {
            this();
        }
    }

    /* renamed from: J */
    private void m6440J() {
        C0938a.m5002a("SR/ReclistActivity", "<initViewPager> start >>>");
        this.f5275N = (CustomViewPager) findViewById(R.id.id_viewpager);
        this.f5275N.setScanScroll(false);
        this.f5277O = new ArrayList();
        this.f5281Q = new C0953O();
        this.f5281Q.mo5090a(false);
        this.f5283R = new C0953O();
        this.f5283R.mo5090a(true);
        this.f5277O.add(this.f5281Q);
        this.f5277O.add(this.f5283R);
        this.f5279P = new C0961S(getFragmentManager(), this.f5277O);
        this.f5275N.setAdapter(this.f5279P);
        C0938a.m5002a("SR/ReclistActivity", "<initViewPager> end <<<");
    }

    /* access modifiers changed from: private */
    /* renamed from: K */
    public boolean m6441K() {
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

    /* access modifiers changed from: private */
    /* renamed from: L */
    public boolean m6442L() {
        int i;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f5341x <= 500) {
            return true;
        }
        this.f5341x = uptimeMillis;
        if (this.f5321n || (i = this.f5251B) == 1 || i == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: M */
    private void m6443M() {
        if (C1411k.m6822d() || C1411k.m6823e() || C1411k.m6817a() || C1411k.m6824f() || C1411k.m6826h() || C1411k.m6821c() || C1411k.m6819b()) {
            this.f5271L.setCenterText(getString(R.string.list));
            this.f5271L.setVisibility(8);
        }
    }

    /* renamed from: N */
    private void m6444N() {
        if (C1413m.m6844f()) {
            setTheme(R.style.notitleBar_IQOO);
            setContentView(R.layout.iqoo_recorder_list_parent);
            return;
        }
        setTheme(R.style.notitleBar);
        setContentView(R.layout.recorder_list_parent);
    }

    /* renamed from: O */
    private void m6445O() {
        if (this.f5309h || this.f5311i) {
        }
    }

    /* renamed from: P */
    private void m6446P() {
        if (C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", this)) {
            m6448R();
        }
    }

    /* renamed from: Q */
    private void m6447Q() {
        AlertDialog create = new AlertDialog.Builder(this).setTitle(R.string.privacy_statement_and_terms_title).setMessage(R.string.privacy_statement_and_terms_details).setPositiveButton(R.string.agree_and_continue_button, new C1235Aa(this)).setNegativeButton(R.string.dialog_exit, new C1372wa(this)).create();
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        if (!isDestroyed() && !isFinishing()) {
            create.show();
        }
    }

    /* renamed from: R */
    private void m6448R() {
        C0938a.m5002a("SR/ReclistActivity", "<registerExternalStorageListener>");
        if (this.f5285S == null) {
            this.f5285S = new C1342la(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addDataScheme("file");
            registerReceiver(this.f5285S, intentFilter);
        }
    }

    /* renamed from: S */
    private void m6449S() {
        this.f5291V = new C1281b(this, (C1342la) null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_PLAYBACK_STATE");
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_RESET_LIST");
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_HEADSET_CONNECTION");
        registerReceiver(this.f5291V, intentFilter);
    }

    /* renamed from: T */
    private void m6450T() {
        C0938a.m5002a("SR/ReclistActivity", "<onCreate>3, itemClickFileId = " + this.f5345z);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f5292Va, intentFilter);
    }

    /* renamed from: U */
    private void m6451U() {
        String str;
        C0938a.m5002a("SR/ReclistActivity", "scanTempFiles()");
        String[] o = this.f5299ba.mo6184o();
        if (o != null) {
            for (String file : o) {
                File[] listFiles = new File(file).listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        C0938a.m5002a("SR/ReclistActivity", "scanTempFiles() file: " + file2.getName());
                        if (!file2.isDirectory()) {
                            if (AppFeature.f5615k) {
                                str = this.f5299ba.mo6171e() + File.separator + file2.getName();
                            } else {
                                str = file2.getAbsolutePath().replace(".temp" + File.separatorChar, C1882a.f6747d);
                            }
                            File file3 = new File(str);
                            boolean renameTo = file2.renameTo(file3);
                            C0938a.m5002a("SR/ReclistActivity", "scanTempFiles() renameTo result: " + renameTo);
                            if (renameTo) {
                                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                                intent.setData(Uri.parse("file://" + file3.getAbsolutePath()));
                                sendBroadcast(intent);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: V */
    public void m6452V() {
        C0938a.m5002a("SR/ReclistActivity", "<setClockTone>,mItemLongClickFileId = " + this.f5253C);
        Intent intent = new Intent();
        intent.setClassName("com.android.BBKClock", "com.android.BBKClock.Timer");
        intent.putExtra("songPath", ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5253C).toString());
        intent.setFlags(67108864);
        try {
            startActivity(intent);
        } catch (Exception e) {
            C0938a.m5002a("SR/ReclistActivity", "<setClockTone>,Exception : " + e);
            C1492b.m7431a((Context) this, (CharSequence) getString(R.string.clock_ring_set), 0).show();
        }
    }

    /* renamed from: W */
    private void m6453W() {
        if (C1413m.m6841c(this)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.window_background_nightmode_color));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.window_background_nightmode_color));
            return;
        }
        getWindow().setStatusBarColor(getResources().getColor(R.color.window_background_color));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.window_background_color));
    }

    /* renamed from: X */
    private void m6454X() {
        float f = AppFeature.f5619o;
        if (f < 11.0f && f >= 9.0f) {
            this.f5271L.showDivider(false);
        }
        if (AppFeature.f5619o >= 11.0f) {
            this.f5267J.showDivider(false);
        }
        if (C1413m.m6846h()) {
            this.f5271L.showDivider(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public void m6455Y() {
        mo5132b();
        mo5137d();
        if (this.f5257E == 0) {
            this.f5281Q.mo5103l();
            this.f5281Q.mo5105n();
        } else {
            this.f5283R.mo5103l();
            this.f5283R.mo5105n();
        }
        this.f5269K = new AlertDialog.Builder(this, 51314692).setTitle(getResources().getString(R.string.sort_title)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setSingleChoiceItems(this.f5312ia, getSharedPreferences("SortingData", 0).getInt("item", 0), new C1253Ga(this)).create();
        this.f5269K.setCanceledOnTouchOutside(true);
        if (!isFinishing()) {
            this.f5269K.show();
            this.f5269K.getWindow().setGravity(80);
        }
    }

    /* renamed from: Z */
    private void m6456Z() {
        if (C1411k.m6825g() && this.f5299ba.mo6182m().booleanValue()) {
            m6447Q();
        }
    }

    /* renamed from: aa */
    private void m6473aa() {
        if (C1413m.m6841c(this)) {
            this.f5267J.setRightButtonIcon(R.drawable.btn_reclist_choose_selector_night);
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_FIRST, R.drawable.btn_reclist_search_selector_night);
            if (!this.f5313j) {
                this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.btn_reclist_more_selector_night);
            } else {
                this.f5250Aa.setTextColor(getResources().getColor(R.color.vivo_color));
            }
        } else {
            this.f5267J.setRightButtonIcon(R.drawable.btn_reclist_choose_selector);
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_FIRST, R.drawable.btn_reclist_search_selector);
            if (!this.f5313j) {
                this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.btn_reclist_more_selector);
            } else {
                this.f5250Aa.setTextColor(getResources().getColor(R.color.vivo_color));
            }
        }
    }

    /* renamed from: ba */
    private void m6480ba() {
    }

    public long getCurrentPosition() {
        PlaybackService.C1442a aVar = this.f5289U;
        if (aVar == null) {
            return -1;
        }
        try {
            return (long) aVar.mo6306c();
        } catch (Exception e) {
            e.printStackTrace();
            mo5123a(0);
            return -1;
        }
    }

    public void lockScroll() {
        this.f5324oa.showNotifyText(false);
        this.f5324oa.setVisibility(0);
        this.f5324oa.setAdapter((ListAdapter) null);
        mo5893g(false);
    }

    public void onBackPressed() {
        if (this.f5257E == 0) {
            this.f5281Q.getView().findViewById(R.id.play_fos10).setVisibility(0);
            this.f5281Q.getView().findViewById(R.id.ll_play_bottom).setVisibility(0);
        } else {
            this.f5283R.getView().findViewById(R.id.play_fos10).setVisibility(0);
            this.f5283R.getView().findViewById(R.id.ll_play_bottom).setVisibility(0);
        }
        if (!this.f5321n) {
            if (this.f5313j) {
                mo5139e();
            } else if (!this.f5303e && !m6442L()) {
                C1434c cVar = this.f5326pa;
                if (cVar == null || cVar.mo6273e() != 4097) {
                    super.onBackPressed();
                    return;
                }
                this.f5326pa.mo6274f();
                mo5893g(false);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0938a.m5002a("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onConfigurationChanged " + configuration);
        m6453W();
        m6473aa();
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        String str;
        String str2;
        String str3;
        String str4;
        switch (menuItem.getItemId()) {
            case 6:
                this.f5320ma = true;
                this.f5281Q.mo5084a(this.f5253C, this.f5337v);
                break;
            case 7:
                this.f5323o = true;
                this.f5281Q.mo5102k();
                break;
            case 8:
                if (new File(this.f5337v).exists()) {
                    if (C1413m.m6843e()) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.addFlags(524288);
                        intent.setType("audio/*");
                        intent.putExtra("android.intent.extra.STREAM", ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5253C));
                        try {
                            startActivity(Intent.createChooser(intent, getString(R.string.share)));
                            break;
                        } catch (ActivityNotFoundException unused) {
                            C0938a.m5004b("SR/ReclistActivity", "shareDialog fail");
                            break;
                        }
                    } else {
                        Intent intent2 = new Intent(this, SpecifiedShareActivity.class);
                        intent2.putExtra("shareId", this.f5253C);
                        startActivity(intent2);
                        break;
                    }
                }
                break;
            case 9:
                mo5135c();
                break;
            case 10:
                if (new File(this.f5337v).exists()) {
                    View inflate = LayoutInflater.from(this).inflate(R.layout.property, (ViewGroup) null, false);
                    ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.file_style);
                    ((TextView) viewGroup.findViewById(R.id.itemPre)).setText(R.string.style);
                    TextView textView = (TextView) viewGroup.findViewById(R.id.itemMain);
                    ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.file_path);
                    ((TextView) viewGroup2.findViewById(R.id.itemPre)).setText(R.string.file_path);
                    TextView textView2 = (TextView) viewGroup2.findViewById(R.id.itemMain);
                    ViewGroup viewGroup3 = (ViewGroup) inflate.findViewById(R.id.size);
                    ((TextView) viewGroup3.findViewById(R.id.itemPre)).setText(R.string.size);
                    TextView textView3 = (TextView) viewGroup3.findViewById(R.id.itemMain);
                    ViewGroup viewGroup4 = (ViewGroup) inflate.findViewById(R.id.modified_time);
                    ((TextView) viewGroup4.findViewById(R.id.itemPre)).setText(R.string.modified_time);
                    TextView textView4 = (TextView) viewGroup4.findViewById(R.id.itemMain);
                    TextView textView5 = (TextView) inflate.findViewById(R.id.file_name);
                    if (this.f5336ua.exists()) {
                        if (this.f5336ua.length() >= 1048576) {
                            str = String.format("%.1f", new Object[]{Float.valueOf(((float) this.f5336ua.length()) / 1048576.0f)}) + "MB";
                        } else {
                            str = String.format("%.1f", new Object[]{Float.valueOf(((float) this.f5336ua.length()) / 1024.0f)}) + "KB";
                        }
                        this.f5296Y = new AlertDialog.Builder(this).setView(inflate).setTitle(R.string.file_information).setNegativeButton(R.string.dialog_button_got, this.f5294Wa).create();
                        if (!isDestroyed() && !isFinishing()) {
                            this.f5296Y.show();
                        }
                        this.f5296Y.setOwnerActivity(this);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String lowerCase = this.f5299ba.mo6173f().getAbsolutePath().toLowerCase();
                        String lowerCase2 = this.f5299ba.mo6167c().getAbsolutePath().toLowerCase();
                        String lowerCase3 = this.f5299ba.mo6177h().getAbsolutePath().toLowerCase();
                        if (C1411k.m6818a(this)) {
                            if (this.f5337v.startsWith(lowerCase)) {
                                str4 = this.f5337v.substring(lowerCase.length());
                            } else if (this.f5337v.startsWith(lowerCase2)) {
                                str4 = this.f5337v.substring(lowerCase2.length());
                            } else {
                                str4 = this.f5337v.startsWith(lowerCase3) ? this.f5337v.substring(lowerCase3.length()) : C1882a.f6747d;
                            }
                            String[] split = str4.split("/");
                            String str5 = C1882a.f6747d;
                            for (int i = 0; i < split.length; i++) {
                                str5 = str5 + "‏" + split[i] + "/";
                            }
                            if (split.length > 0) {
                                str5 = str5.substring(0, str5.length() - 1);
                            }
                            if (this.f5337v.startsWith(lowerCase2)) {
                                str2 = getString(R.string.external_sdcard) + str5;
                            } else if (this.f5337v.startsWith(lowerCase3)) {
                                str2 = getString(R.string.storage_otg_sda4) + str5;
                            } else if (this.f5337v.startsWith(lowerCase)) {
                                str2 = getString(R.string.sdcard_mtp) + str5;
                            } else {
                                str2 = null;
                            }
                        } else if (this.f5337v.startsWith(lowerCase2)) {
                            str2 = getString(R.string.external_sdcard) + this.f5337v.substring(lowerCase2.toLowerCase().length());
                        } else if (this.f5337v.startsWith(lowerCase)) {
                            str2 = getString(R.string.sdcard_mtp) + this.f5337v.substring(lowerCase.toLowerCase().length());
                        } else if (this.f5337v.startsWith(lowerCase3)) {
                            str2 = getString(R.string.storage_otg_sda4) + this.f5337v.substring(lowerCase3.toLowerCase().length());
                        } else {
                            str2 = this.f5337v;
                            C0938a.m5004b("SR/ReclistActivity", "<onContextItemSelected>,pathText = " + str2);
                        }
                        textView5.setText(this.f5335u);
                        textView.setText(this.f5281Q.mo5091b(this.f5337v).toUpperCase() + " " + getString(R.string.audio));
                        textView2.setText(str2);
                        textView3.setText(str);
                        if (!AppFeature.f5612h) {
                            textView4.setText(simpleDateFormat.format(Long.valueOf(this.f5336ua.lastModified())));
                            break;
                        } else {
                            String format = DateFormat.getDateFormat(this).format(new Date(this.f5336ua.lastModified()));
                            String string = Settings.System.getString(getContentResolver(), "use_thai_calendar");
                            if (string != null && "1".equals(string)) {
                                Calendar instance = Calendar.getInstance();
                                instance.setTimeInMillis(this.f5336ua.lastModified());
                                int i2 = instance.get(1);
                                format = format.replace(String.valueOf(i2), String.valueOf(i2 + 543));
                            }
                            String language = Locale.getDefault().getLanguage();
                            long lastModified = this.f5336ua.lastModified();
                            if ("24".equals(Settings.System.getString(getContentResolver(), "time_12_24"))) {
                                str3 = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(lastModified));
                            } else if ("zh".endsWith(language)) {
                                str3 = new SimpleDateFormat("aa h:mm:ss").format(Long.valueOf(lastModified));
                            } else {
                                str3 = new SimpleDateFormat("h:mm:ss aa").format(Long.valueOf(lastModified));
                            }
                            textView4.setText(format + " " + str3);
                            break;
                        }
                    }
                }
                break;
            case 11:
                if (!this.f5299ba.mo6163a(102400)) {
                    mo5132b();
                    Intent intent3 = new Intent();
                    intent3.putExtra("clip_filePath", this.f5337v);
                    intent3.putExtra("file_duration", this.f5340wa);
                    intent3.setClass(this, EditActivity.class);
                    startActivity(intent3);
                    break;
                } else {
                    C1492b.m7431a(this.f5261G, (CharSequence) getResources().getString(R.string.sdcard_not_enough), 0).show();
                    break;
                }
        }
        return super.onContextItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0938a.m5006c("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onCreate");
        m6425B();
        m6427C();
        m6516w();
        m6444N();
        mo5885a(bundle);
        m6431E();
        m6440J();
        m6446P();
        m6450T();
        m6476b(bundle);
        m6521z();
        m6456Z();
        m6480ba();
        mo5920p();
        m6469a(getIntent());
        mo5902o();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (f5248c) {
            contextMenu.setHeaderTitle(this.f5335u);
            if (!C1413m.m6847i()) {
                contextMenu.add(0, 6, 0, R.string.delete).setIcon(R.drawable.btn_listview_context_delete_selector_1);
                contextMenu.add(0, 7, 0, R.string.rename).setIcon(R.drawable.btn_listview_context_rename_selector_1);
                contextMenu.add(0, 8, 0, R.string.share).setIcon(R.drawable.btn_listview_context_share_selector_1);
            } else {
                contextMenu.add(1, 6, 0, R.string.delete).setIcon(R.drawable.btn_listview_context_delete_selector);
                contextMenu.add(1, 7, 0, R.string.rename).setIcon(R.drawable.btn_listview_context_rename_selector);
                contextMenu.add(1, 8, 0, R.string.share).setIcon(R.drawable.btn_listview_context_share_selector);
            }
            contextMenu.add(1, 9, 0, R.string.set_ringtone);
            if (this.f5338va) {
                contextMenu.add(1, 11, 0, R.string.rtot_crop);
            }
            contextMenu.add(1, 10, 0, R.string.file_information);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C0938a.m5006c("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onDestroy");
        m6512u();
        f5248c = false;
        this.f5304ea = null;
        HashMap hashMap = new HashMap();
        hashMap.put("duration", String.valueOf((System.currentTimeMillis() - AppFeature.f5620p) / 1000));
        C1390G.m6778a("A107|10002", hashMap);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C0938a.m5006c("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onPause");
        if (this.f5313j) {
            this.f5314ja.postDelayed(new C1363sa(this), 300);
        }
        if (this.f5289U != null) {
            if (isFinishing()) {
                this.f5289U.mo6315k();
            } else if (!this.f5325p) {
                if (this.f5281Q.f3983Ka || this.f5283R.f3983Ka) {
                    C0953O o = this.f5281Q;
                    if (o.f3983Ka) {
                        o.f3983Ka = false;
                    } else {
                        C0953O o2 = this.f5283R;
                        if (o2.f3983Ka) {
                            o2.f3983Ka = false;
                        }
                    }
                } else {
                    this.f5289U.mo6314j();
                }
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "1");
                    C1390G.m6779b("A107|8|2|7", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/ReclistActivity", "vcode error");
                }
            }
        }
        this.f5325p = false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        if (iArr.length != 0) {
            if (i != 111) {
                if (i != 112) {
                    if (i == 1001) {
                        if (!"android.permission.RECORD_AUDIO".equals(strArr[0]) || iArr[0] != 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("android.permission.RECORD_AUDIO", 0);
                            for (int i2 = 0; i2 < strArr.length; i2++) {
                                hashMap.put(strArr[i2], Integer.valueOf(iArr[i2]));
                            }
                            if (((Integer) hashMap.get("android.permission.RECORD_AUDIO")).intValue() == -1) {
                                str = C1882a.f6747d + getString(R.string.permission_microphone);
                            } else {
                                str = C1882a.f6747d;
                            }
                            if (!str.equals(C1882a.f6747d)) {
                                mo5889b(str, (Activity) this);
                                this.f5311i = true;
                            }
                        } else if (this.f5257E == 0) {
                            this.f5281Q.mo5088a("ReclistActivityonRequestPermissionsResult2");
                        } else {
                            this.f5283R.mo5088a("ReclistActivityonRequestPermissionsResult2");
                        }
                    }
                } else if ("android.permission.READ_PHONE_STATE".equals(strArr[0]) && iArr[0] == 0) {
                    mo5895i();
                } else if (!C0324b.m1599a(this, strArr[0])) {
                    C1424v.m6871b(getString(R.string.permission_phone), this);
                }
            } else if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[0]) || iArr[0] != 0) {
                this.f5309h = true;
                mo5886a(getString(R.string.permission_storage), (Activity) this);
            } else {
                m6448R();
                if (this.f5257E == 0) {
                    this.f5281Q.mo5088a("ReclistActivityonRequestPermissionsResult");
                } else {
                    this.f5283R.mo5088a("ReclistActivityonRequestPermissionsResult");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        C0938a.m5002a("SR/ReclistActivity", "<onRestoreInstanceState(" + bundle + ")>");
        if (bundle != null) {
            this.f5329r = true;
            this.f5345z = bundle.getInt("save_click_id");
            this.f5333t = bundle.getString("save_file_path");
            this.f5249A = bundle.getInt("save_click_pos");
            this.f5257E = bundle.getInt("save_current_pager");
            this.f5255D = bundle.getInt("save_current_play_pager");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C0938a.m5006c("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onResume");
        m6451U();
        m6445O();
        m6507s();
        m6429D();
        m6509t();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("save_click_id", this.f5345z);
        bundle.putString("save_file_path", this.f5333t);
        bundle.putInt("save_click_pos", this.f5249A);
        bundle.putInt("save_current_pager", this.f5257E);
        bundle.putInt("save_current_play_pager", this.f5255D);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.f5319m = false;
        } else if (i == 1) {
            this.f5319m = true;
        } else if (i == 2) {
            this.f5319m = true;
        }
    }

    public void onSearchTextChanged(String str) {
        this.f5324oa.setAdapter((ListAdapter) null);
        C1284e eVar = this.f5310ha;
        if (eVar != null) {
            eVar.cancel(true);
            this.f5310ha = null;
        }
        if (this.f5310ha == null && str != null) {
            this.f5310ha = new C1284e(this, (C1342la) null);
            this.f5310ha.execute(new String[]{str});
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        f5247b = true;
        C1413m.f5702A = 0;
        C0938a.m5006c("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStart");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C0938a.m5006c("SR/ReclistActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStop");
        f5247b = false;
    }

    public boolean processSearchClick() {
        f5248c = true;
        registerForContextMenu(this.f5324oa);
        return true;
    }

    public void unLockScroll() {
        f5248c = false;
        this.f5304ea = null;
        m6422A();
        this.f5324oa.setVisibility(8);
        mo5893g(false);
    }

    /* renamed from: com.android.activity.ReclistActivity$a */
    private class C1280a extends AsyncTask<Void, Void, Cursor> {

        /* renamed from: a */
        private Cursor f5349a;

        C1280a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Cursor doInBackground(Void... voidArr) {
            this.f5349a = ReclistActivity.this.f5306fa.mo6195b();
            return this.f5349a;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            Cursor cursor = this.f5349a;
            if (cursor != null) {
                cursor.close();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            if (cursor == null || cursor.getCount() == 0) {
                ReclistActivity.this.f5267J.hideRightButton();
                ReclistActivity.this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, false);
            } else {
                ReclistActivity.this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, true);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: A */
    private void m6422A() {
        SearchView searchView = this.f5322na;
        if (searchView != null && searchView.getVisibility() == 0) {
            this.f5322na.setVisibility(8);
        }
    }

    /* renamed from: B */
    private void m6425B() {
        this.f5261G = getApplicationContext();
        this.f5331s = false;
        this.f5265I = (TelephonyManager) this.f5261G.getSystemService("phone");
    }

    /* renamed from: C */
    private void m6427C() {
        if (this.f5299ba == null) {
            C0938a.m5002a("SR/ReclistActivity", "<initObjects>,mRecConfigFile==null,new RecConfigFile()");
            this.f5299ba = new C1425w(this.f5261G);
        }
        if (this.f5300ca == null) {
            C0938a.m5002a("SR/ReclistActivity", "<initObjects>,mDB==null,new AndroidSQLiteOpenHelper()");
            this.f5300ca = C1018a.m5416a(this.f5261G);
        }
        if (this.f5302da == null) {
            C0938a.m5002a("SR/ReclistActivity", "<initObjects>,mDB==null,new ShowFlagWrapper()");
            this.f5302da = new C1395d();
        }
    }

    /* renamed from: D */
    private void m6429D() {
        if (!this.f5331s) {
            m6434G();
        }
    }

    /* renamed from: E */
    private void m6431E() {
        C0938a.m5002a("SR/ReclistActivity", "<initRecources>");
        this.f5271L = findViewById(R.id.bbk_tabtitleview);
        this.f5267J = findViewById(R.id.costomized);
        m6437H();
        m6454X();
        m6438I();
        setVolumeControlStream(this.f5299ba.mo6178i().equals("true") ? 3 : 0);
        this.f5306fa = C1426x.m6909a((Context) this);
        ViewStub viewStub = (ViewStub) findViewById(R.id.viewstub_search);
        if (viewStub != null) {
            viewStub.inflate();
            this.f5322na = (SearchView) findViewById(R.id.search_view);
            this.f5334ta = (TextView) findViewById(R.id.search_emptyText);
            this.f5324oa = findViewById(R.id.search_list);
            this.f5324oa.setOnItemClickListener(this.f5264Ha);
            this.f5324oa.setOnItemLongClickListener(this.f5266Ia);
            this.f5260Fa = new C1280a();
            this.f5260Fa.execute(new Void[0]);
            m6453W();
            m6443M();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: F */
    public void m6433F() {
        if (C1413m.m6844f()) {
            this.f5322na.setBackgroundColor(-16777216);
        }
        this.f5322na.setSearchHint(getResources().getString(R.string.search_record_name_mark_location));
        this.f5322na.setOnButtonClickLinster(new C1243Ea(this));
        this.f5324oa.setChoiceMode(1);
        this.f5324oa.setHoldingModeEnabled(false);
        this.f5324oa.setSpringEffect(false);
        this.f5324oa.setEdgeEffect(false);
        this.f5324oa.setVerticalScrollBarEnabled(true);
        this.f5324oa.setItemsCanFocus(true);
        this.f5324oa.setOnTouchListener(this.f5262Ga);
        this.f5326pa = this.f5322na.getSearchControl();
        this.f5326pa.mo6267a(1);
        this.f5326pa.mo6269a((ListView) this.f5324oa);
        this.f5328qa = findViewById(R.id.listview_parent);
        this.f5332sa = findViewById(R.id.note_title);
        this.f5330ra = new FakeView(this);
        this.f5330ra.setFakedView(this.f5332sa);
        this.f5330ra.setVisibility(4);
        this.f5326pa.mo6271b(this.f5328qa);
        this.f5326pa.mo6272c(this.f5332sa);
        this.f5326pa.mo6268a((View) this.f5330ra);
        this.f5322na.setScrollLockImp(this);
        this.f5322na.setSearchLinstener(this);
        List<C1432a> list = this.f5308ga;
        if (list != null) {
            list.clear();
        }
    }

    /* renamed from: G */
    private void m6434G() {
        C0938a.m5002a("SR/ReclistActivity", "<initService>");
        this.f5287T = new Intent(this, PlaybackService.class);
        this.f5293W = new C1283d(this, (C1342la) null);
        try {
            C1386C.m6759a(this.f5287T);
        } catch (Exception unused) {
            C0938a.m5004b("SR/ReclistActivity", "startService(playbackServiceIntent)Failed");
        }
        bindService(this.f5287T, this.f5293W, 1);
        this.f5331s = true;
        m6449S();
    }

    /* renamed from: H */
    private void m6437H() {
        if (this.f5312ia == null) {
            this.f5312ia = new String[]{this.f5261G.getResources().getString(R.string.sort_by_time_dec), this.f5261G.getResources().getString(R.string.sort__by_time_asc), this.f5261G.getResources().getString(R.string.sort_by_name)};
        }
    }

    /* renamed from: I */
    private void m6438I() {
        this.f5267J.showLeftButton();
        mo5901n();
        if (C1413m.m6841c(this)) {
            this.f5267J.setRightButtonIcon(R.drawable.btn_reclist_choose_selector_night);
        } else {
            this.f5267J.setRightButtonIcon(R.drawable.btn_reclist_choose_selector);
        }
        C1413m.m6834a((View) this.f5267J.getRightButton(), 0);
        this.f5267J.initRightIconButton();
        this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, true);
        this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, true);
        this.f5267J.setLeftButtonClickListener(this.f5278Oa);
        this.f5267J.setRightButtonClickListener(this.f5282Qa);
        this.f5267J.setIconViewOnClickListner(BbkTitleView.RIGHT_ICON_FIRST, this.f5268Ja);
        this.f5267J.setIconViewOnClickListner(BbkTitleView.RIGHT_ICON_SEC, this.f5270Ka);
        this.f5267J.setOnTitleClickListener(this.f5280Pa);
        this.f5273M = this.f5271L.getTabSelector();
        this.f5273M.setTabTextSize(16.0f);
        this.f5273M.setTabString(TabSelector.TAB_LEFT, getString(R.string.recorderfile_ordinary));
        this.f5273M.setTabString(TabSelector.TAB_RIGHT, getString(R.string.recorderfile_call));
        this.f5273M.setTabOnClickListener(TabSelector.TAB_LEFT, this.f5274Ma);
        this.f5271L.setVisibility(8);
        if (C1411k.m6820b(this)) {
            this.f5267J.getLeftButton().setContentDescription(getResources().getString(R.string.backward_talkback));
            this.f5267J.getRightButton().setContentDescription(getResources().getString(R.string.search_record_name_mark_location));
            BbkTitleView bbkTitleView = this.f5267J;
            mo5884a(BbkTitleView.RIGHT_ICON_FIRST, (CharSequence) getResources().getString(R.string.sort_title));
        }
        if (C1413m.m6841c(this)) {
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_FIRST, R.drawable.btn_reclist_search_selector_night);
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.btn_reclist_more_selector_night);
        } else {
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_FIRST, R.drawable.btn_reclist_search_selector);
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.btn_reclist_more_selector);
        }
        this.f5273M.setTabOnClickListener(TabSelector.TAB_RIGHT, this.f5276Na);
        this.f5271L.setLeftButtonIcon(BbkTitleView.TITLE_BTN_BACK);
        this.f5271L.setLeftButtonClickListener(this.f5274Ma);
        this.f5271L.setRightButtonClickListener(this.f5276Na);
        this.f5250Aa = (TextView) C1384A.m6749a("com.vivo.common.BbkTitleView", "mRightIconSec", (Object) this.f5267J);
        this.f5252Ba = (TextView) C1384A.m6749a("com.vivo.common.BbkTitleView", "mRightIconFirst", (Object) this.f5267J);
        C1413m.m6834a((View) this.f5252Ba, 0);
        C1413m.m6834a((View) this.f5250Aa, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m6494f(String str) {
        IndicatorSeekBar indicatorSeekBar;
        int progress;
        C0938a.m5002a("SR/ReclistActivity", "<startPlayback(path)>: " + str);
        if (str != null && this.f5289U != null) {
            if (str.startsWith("content://")) {
                this.f5289U.mo6301a(Uri.parse(str));
                this.f5339w = m6460a(Uri.parse(str));
            } else {
                this.f5289U.mo6305b(str);
                this.f5339w = mo5887b(str);
            }
            if (this.f5255D == 0) {
                indicatorSeekBar = this.f5281Q.f4041la.mo5172b();
            } else {
                indicatorSeekBar = this.f5283R.f4041la.mo5172b();
            }
            if (indicatorSeekBar != null && (progress = indicatorSeekBar.getProgress()) != 0) {
                this.f5289U.mo6304b(((int) (((float) (((long) progress) * this.f5339w)) / indicatorSeekBar.getMax())) + 1);
            }
        }
    }

    /* renamed from: s */
    private void m6507s() {
        if (!C1424v.m6870a("android.permission.RECORD_AUDIO", this)) {
            this.f5316ka.postDelayed(new C1357qa(this, new String[]{"android.permission.RECORD_AUDIO"}), 50);
        } else if (!C1424v.m6870a("android.permission.WRITE_EXTERNAL_STORAGE", this)) {
            this.f5314ja.postDelayed(new C1360ra(this), 300);
        }
    }

    /* renamed from: t */
    private void m6509t() {
        PlaybackService.C1442a aVar = this.f5289U;
        if (aVar != null) {
            aVar.mo6299a();
            this.f5289U.mo6300a(101);
        }
    }

    /* renamed from: u */
    private void m6512u() {
        C1282c cVar = this.f5259F;
        if (cVar != null && cVar.getStatus() == AsyncTask.Status.RUNNING) {
            C0938a.m5002a("SR/ReclistActivity", "<destroyObjects> mPlaybackProgressTask status: RUNNING!");
            this.f5259F.cancel(true);
        }
        BroadcastReceiver broadcastReceiver = this.f5285S;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f5285S = null;
        }
        C1281b bVar = this.f5291V;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.f5291V = null;
        }
        ScreenPlayBroadcastReceiver screenPlayBroadcastReceiver = this.f5342xa;
        if (screenPlayBroadcastReceiver != null) {
            unregisterReceiver(screenPlayBroadcastReceiver);
            this.f5342xa = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.f5292Va;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
            this.f5292Va = null;
        }
        ReclistPageAddMarkReceiver reclistPageAddMarkReceiver = this.f5254Ca;
        if (reclistPageAddMarkReceiver != null) {
            unregisterReceiver(reclistPageAddMarkReceiver);
            this.f5254Ca = null;
        }
        Cursor cursor = this.f5263H;
        if (cursor != null && !cursor.isClosed()) {
            try {
                this.f5263H.close();
            } catch (Exception e) {
                C0938a.m5004b("SR/ReclistActivity", "<destroyObjects> Exception: " + e);
            }
        }
        C1425w wVar = this.f5299ba;
        if (wVar != null) {
            wVar.mo6189t();
            this.f5299ba = null;
        }
        C1018a aVar = this.f5300ca;
        if (aVar != null) {
            aVar.mo5345a();
            this.f5300ca = null;
        }
        if (this.f5302da != null) {
            this.f5302da = null;
        }
        ServiceConnection serviceConnection = this.f5293W;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
        C1281b bVar2 = this.f5291V;
        if (bVar2 != null) {
            unregisterReceiver(bVar2);
            this.f5291V = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public void m6514v() {
        C0938a.m5002a("SR/ReclistActivity", "doForRightButtonEdit");
        this.f5343y = SystemClock.uptimeMillis();
        this.f5313j = true;
        mo5900m();
        if (C1413m.m6844f()) {
            this.f5267J.getCenterView().setTextColor(Color.parseColor(C1413m.f5722t));
            this.f5267J.getRightButton().setText(getString(R.string.cancel));
            this.f5267J.setLeftButtonText(getString(R.string.select_all));
            this.f5267J.getCenterView().setVisibility(0);
            this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, false);
            this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, false);
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, 0);
            this.f5267J.setIconViewText(BbkTitleView.RIGHT_ICON_SEC, getString(R.string.cancel));
        } else {
            this.f5267J.setLeftButtonText(getString(R.string.select_all));
            this.f5267J.hideRightButton();
            this.f5267J.getCenterView().setVisibility(0);
            this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, false);
            this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, true);
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, 0);
            this.f5267J.setIconViewText(BbkTitleView.RIGHT_ICON_SEC, getString(R.string.cancel));
        }
        if (C1411k.m6820b(this)) {
            this.f5267J.getLeftButton().setContentDescription(getString(R.string.select_all));
        }
        if (this.f5257E == 0) {
            this.f5281Q.mo5095d();
        } else {
            this.f5283R.mo5095d();
        }
        this.f5271L.setVisibility(8);
        mo5123a(6);
    }

    /* renamed from: w */
    private void m6516w() {
        sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(this.f5299ba.mo6171e()))));
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m6518x() {
        if (C1413m.m6844f()) {
            this.f5273M.setTabStringColor(TabSelector.TAB_LEFT, Color.parseColor(C1413m.f5722t));
        }
        if (this.f5313j) {
            mo5139e();
        }
        CustomViewPager customViewPager = this.f5275N;
        if (customViewPager != null) {
            customViewPager.mo3962a(0, false);
            this.f5273M.setSelectorTab(TabSelector.TAB_LEFT);
            this.f5257E = 0;
        }
        if (this.f5281Q.f4035ia) {
            this.f5267J.showRightButton();
        } else {
            this.f5267J.hideRightButton();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public void m6520y() {
        C0938a.m5002a("SR/ReclistActivity", "<handleTabSelectorRightBottonClick");
        if (C1413m.m6844f()) {
            this.f5273M.setTabStringColor(TabSelector.TAB_RIGHT, Color.parseColor(C1413m.f5722t));
        }
        if (this.f5313j) {
            mo5139e();
        }
        CustomViewPager customViewPager = this.f5275N;
        if (customViewPager != null) {
            customViewPager.mo3962a(1, false);
            this.f5273M.setSelectorTab(TabSelector.TAB_RIGHT);
            this.f5257E = 1;
        }
        if (this.f5283R.f4035ia) {
            this.f5267J.showRightButton();
        } else {
            this.f5267J.hideRightButton();
        }
    }

    /* renamed from: z */
    private void m6521z() {
        if (this.f5281Q.f4035ia) {
            mo5130a(true, false);
        } else {
            mo5130a(false, false);
        }
        if (this.f5283R.f4035ia) {
            mo5130a(true, true);
        } else {
            mo5130a(false, true);
        }
    }

    /* renamed from: e */
    public void mo5139e() {
        C0938a.m5002a("SR/ReclistActivity", "doForExitRightButtonEdit");
        this.f5313j = false;
        if (C1411k.m6820b(this)) {
            this.f5267J.getLeftButton().setContentDescription(getResources().getString(R.string.backward_talkback));
        }
        this.f5315k = false;
        this.f5267J.showRightButton();
        if (C1413m.m6844f()) {
            this.f5267J.setRightButtonText(getString(R.string.edit));
        }
        this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, true);
        mo5901n();
        this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, true);
        if (C1413m.m6844f()) {
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.iqoo_more_iqoo);
        } else if (C1413m.m6841c(this)) {
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.btn_reclist_more_selector_night);
        } else {
            this.f5267J.setIconViewDrawableRes(BbkTitleView.RIGHT_ICON_SEC, R.drawable.btn_reclist_more_selector);
        }
        this.f5267J.setIconViewOnClickListner(BbkTitleView.RIGHT_ICON_SEC, this.f5270Ka);
        this.f5267J.setCenterText(C1882a.f6747d);
        if (this.f5275N.getCurrentItem() == 0) {
            this.f5281Q.mo5096e();
            this.f5281Q.getView().findViewById(R.id.play_fos10).setVisibility(0);
            this.f5281Q.getView().findViewById(R.id.ll_play_bottom).setVisibility(0);
        } else {
            this.f5283R.mo5096e();
            this.f5283R.getView().findViewById(R.id.play_fos10).setVisibility(0);
            this.f5283R.getView().findViewById(R.id.ll_play_bottom).setVisibility(0);
        }
        if (this.f5283R.f4035ia) {
            this.f5271L.setVisibility(0);
        }
    }

    /* renamed from: g */
    public void mo5893g(boolean z) {
        if (z) {
            this.f5334ta.setVisibility(0);
        } else {
            this.f5334ta.setVisibility(8);
        }
    }

    /* renamed from: h */
    public void mo5894h() {
        C0938a.m5002a("SR/ReclistActivity", "<checkItemLongDialog>");
        if (this.f5296Y != null && mo5898l()) {
            this.f5296Y.dismiss();
            this.f5296Y.cancel();
        }
    }

    /* renamed from: i */
    public void mo5895i() {
        DialogInterface.OnClickListener onClickListener;
        if (C1028b.m5456a().mo5371b()) {
            onClickListener = C1416p.m6851a().mo6152d() ? this.f5286Sa : this.f5290Ua;
        } else {
            onClickListener = C1416p.m6851a().mo6152d() ? this.f5284Ra : this.f5288Ta;
        }
        C1407j.m6809a().mo6146a(this, C1416p.m6851a().mo6150b(), onClickListener, R.string.set_ringtone);
    }

    /* renamed from: j */
    public String mo5896j() {
        return this.f5304ea;
    }

    /* renamed from: k */
    public Button mo5897k() {
        return this.f5271L.getLeftButton();
    }

    /* renamed from: l */
    public boolean mo5898l() {
        return !isDestroyed() && !isFinishing();
    }

    /* renamed from: m */
    public void mo5900m() {
        this.f5267J.getLeftButton().setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.mAppNameSelect));
        this.f5267J.getLeftButton().setTypeface((Typeface) null, 0);
        C1413m.m6834a((View) this.f5267J.getLeftButton(), 0);
        this.f5267J.getLeftButton().setTextColor(getResources().getColor(R.color.vivo_color));
        TextView textView = this.f5250Aa;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.vivo_color));
            this.f5250Aa.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.mAppNameSelect));
        }
        mo5890c(0);
    }

    /* renamed from: n */
    public void mo5901n() {
        C1413m.m6834a((View) this.f5267J.getLeftButton(), 1);
        this.f5267J.getLeftButton().setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.mAppName));
        this.f5267J.getLeftButton().setText(getString(R.string.app_name));
        this.f5267J.getLeftButton().setTypeface((Typeface) null, 1);
        if (C1413m.m6844f()) {
            this.f5267J.getLeftButton().setTextColor(Color.parseColor(C1413m.f5722t));
        } else {
            this.f5267J.getLeftButton().setTextColor(VivoThemeUtil.getColor(this, 16842806));
        }
    }

    /* renamed from: o */
    public void mo5902o() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.activity.ReclistActivity.MARKRECEIVER");
        registerReceiver(this.f5254Ca, intentFilter);
    }

    /* renamed from: p */
    public void mo5920p() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f5342xa, intentFilter);
    }

    /* renamed from: q */
    public void mo5922q() {
        SearchView searchView = this.f5322na;
        if (searchView != null && searchView.getVisibility() == 8) {
            this.f5322na.mo6213b();
            this.f5322na.setVisibility(0);
        }
    }

    /* renamed from: r */
    public void mo5923r() {
        C1284e eVar = this.f5310ha;
        if (eVar != null) {
            eVar.cancel(true);
            this.f5310ha = null;
        }
        if (this.f5310ha == null) {
            this.f5310ha = new C1284e(this, (C1342la) null);
            this.f5310ha.execute(new String[]{this.f5304ea});
        }
    }

    /* renamed from: d */
    private String m6485d(int i) {
        String str = "_mark_recfile_id='" + i + "'";
        C1018a aVar = this.f5300ca;
        Cursor cursor = null;
        if (aVar != null) {
            cursor = aVar.mo5343a("recordermarks", (String[]) null, str, "_mark_time_length");
        }
        if (cursor != null && cursor.getCount() > 0) {
            this.f5256Da.clear();
            while (cursor.moveToNext()) {
                long j = cursor.getLong(4);
                String string = cursor.getString(1);
                C0937a aVar2 = new C0937a();
                aVar2.mo5063a(string);
                aVar2.mo5062a(j);
                this.f5256Da.add(aVar2);
            }
        }
        return m6466a(this.f5256Da);
    }

    /* renamed from: c */
    public boolean mo5891c(int i, String str) {
        String d = m6485d(i);
        long c = (long) this.f5289U.mo6306c();
        if (m6478b(c)) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_mark_recfile_id", Integer.valueOf(i));
        contentValues.put("_mark_path", str);
        contentValues.put("_mark_time_length", Long.valueOf(c));
        contentValues.put("_mark_name", d);
        try {
            this.f5300ca.mo5341a("recordermarks", contentValues);
        } catch (Exception e) {
            C0938a.m5004b("SR/ReclistActivity", "<addMarksToDB>,Exception = " + e);
        }
        if (!this.f5258Ea) {
            this.f5281Q.mo5106o();
        } else {
            this.f5283R.mo5106o();
        }
        return false;
    }

    /* renamed from: g */
    public void mo5892g() {
        C0938a.m5002a("SR/ReclistActivity", "<checkItemClickDialog>");
        if (this.f5297Z != null && mo5898l()) {
            this.f5297Z.dismiss();
            this.f5297Z.cancel();
        }
        if (this.f5298aa != null && mo5898l()) {
            this.f5298aa.dismiss();
            this.f5298aa.cancel();
        }
    }

    /* renamed from: b */
    private void m6476b(Bundle bundle) {
        if (bundle != null) {
            C0938a.m5002a("SR/ReclistActivity", "<onCreate> savedInstanceState is not null");
            this.f5329r = true;
            this.f5345z = bundle.getInt("save_click_id");
            this.f5333t = bundle.getString("save_file_path");
            this.f5249A = bundle.getInt("save_click_pos");
            this.f5257E = bundle.getInt("save_current_pager");
            this.f5255D = bundle.getInt("save_current_play_pager");
            if (this.f5257E == 1) {
                this.f5273M.setSelectorTab(TabSelector.TAB_RIGHT);
                this.f5275N.mo3962a(1, false);
            }
        }
    }

    /* renamed from: com.android.activity.ReclistActivity$e */
    private class C1284e extends AsyncTask<String, Boolean, Boolean> {

        /* renamed from: a */
        private Cursor f5354a;

        /* renamed from: b */
        private Cursor f5355b;

        /* renamed from: c */
        private Cursor f5356c;

        /* renamed from: d */
        private List<HashMap<Integer, String>> f5357d;

        /* renamed from: e */
        private List<HashMap<Integer, String>> f5358e;

        /* renamed from: f */
        private List<C1432a> f5359f;

        /* renamed from: g */
        private C1433b f5360g;

        private C1284e() {
            this.f5354a = null;
            this.f5355b = null;
            this.f5356c = null;
            this.f5357d = new ArrayList();
            this.f5358e = new ArrayList();
            this.f5359f = new ArrayList();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0176 A[LOOP:4: B:41:0x0176->B:42:0x01a5, LOOP_START] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01a7  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x01b0  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x03ee  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Boolean doInBackground(java.lang.String... r15) {
            /*
                r14 = this;
                r0 = 0
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
                r2 = r15[r0]
                com.android.common.utils.C1413m.m6836a((java.lang.String) r2)
                com.android.activity.ReclistActivity r2 = com.android.activity.ReclistActivity.this
                r3 = r15[r0]
                java.lang.String unused = r2.f5304ea = r3
                com.android.activity.ReclistActivity r2 = com.android.activity.ReclistActivity.this
                com.android.search.SearchView r2 = r2.f5322na
                int r2 = r2.getVisibility()
                r3 = 8
                if (r2 != r3) goto L_0x0020
                return r1
            L_0x0020:
                r15 = r15[r0]
                boolean r15 = android.text.TextUtils.isEmpty(r15)
                if (r15 == 0) goto L_0x0029
                return r1
            L_0x0029:
                com.android.activity.ReclistActivity r15 = com.android.activity.ReclistActivity.this
                com.android.common.utils.x r15 = r15.f5306fa
                android.database.Cursor r15 = r15.mo6195b()
                r14.f5354a = r15
                android.database.Cursor r15 = r14.f5354a
                if (r15 == 0) goto L_0x040d
                int r15 = r15.getCount()
                if (r15 <= 0) goto L_0x040d
                android.database.Cursor r15 = r14.f5354a
                boolean r15 = r15.moveToFirst()
                if (r15 == 0) goto L_0x00a5
            L_0x0047:
                android.database.Cursor r15 = r14.f5354a
                java.lang.String r1 = "_data"
                int r1 = r15.getColumnIndex(r1)
                java.lang.String r3 = r15.getString(r1)
                android.database.Cursor r15 = r14.f5354a
                java.lang.String r1 = "_id"
                int r1 = r15.getColumnIndex(r1)
                int r5 = r15.getInt(r1)
                android.database.Cursor r15 = r14.f5354a
                java.lang.String r1 = "_display_name"
                int r1 = r15.getColumnIndex(r1)
                java.lang.String r15 = r15.getString(r1)
                java.lang.String r1 = "."
                int r1 = r15.lastIndexOf(r1)
                java.lang.String r6 = r15.substring(r0, r1)
                android.database.Cursor r15 = r14.f5354a
                java.lang.String r1 = "duration"
                int r1 = r15.getColumnIndex(r1)
                int r7 = r15.getInt(r1)
                android.database.Cursor r15 = r14.f5354a
                java.lang.String r1 = "date_modified"
                int r1 = r15.getColumnIndex(r1)
                long r8 = r15.getLong(r1)
                com.android.search.a r15 = new com.android.search.a
                r4 = 0
                r10 = 1
                r11 = 0
                r12 = 1
                r13 = 0
                r2 = r15
                r2.<init>(r3, r4, r5, r6, r7, r8, r10, r11, r12, r13)
                java.util.List<com.android.search.a> r1 = r14.f5359f
                r1.add(r15)
                android.database.Cursor r15 = r14.f5354a
                boolean r15 = r15.moveToNext()
                if (r15 != 0) goto L_0x0047
            L_0x00a5:
                com.android.activity.ReclistActivity r15 = com.android.activity.ReclistActivity.this
                com.android.common.utils.x r15 = r15.f5306fa
                android.database.Cursor r15 = r15.mo6197c()
                r14.f5356c = r15
                android.database.Cursor r15 = r14.f5356c
                java.lang.String r1 = ""
                if (r15 == 0) goto L_0x00ff
                int r15 = r15.getCount()
                if (r15 <= 0) goto L_0x00ff
                android.database.Cursor r15 = r14.f5356c
                boolean r15 = r15.moveToFirst()
                if (r15 == 0) goto L_0x00ff
            L_0x00c5:
                android.database.Cursor r15 = r14.f5356c
                java.lang.String r2 = "_recfile_id"
                int r2 = r15.getColumnIndex(r2)
                int r15 = r15.getInt(r2)
                android.database.Cursor r2 = r14.f5356c
                java.lang.String r3 = "_recfile_address"
                int r3 = r2.getColumnIndex(r3)
                java.lang.String r2 = r2.getString(r3)
                java.lang.String r3 = "NoAddress"
                boolean r3 = r3.equals(r2)
                if (r3 == 0) goto L_0x00e6
                r2 = r1
            L_0x00e6:
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
                r3.put(r15, r2)
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r15 = r14.f5357d
                r15.add(r3)
                android.database.Cursor r15 = r14.f5356c
                boolean r15 = r15.moveToNext()
                if (r15 != 0) goto L_0x00c5
            L_0x00ff:
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r15 = r14.f5357d
                java.util.Iterator r15 = r15.iterator()
            L_0x0105:
                boolean r2 = r15.hasNext()
                r3 = 1
                if (r2 == 0) goto L_0x0158
                java.lang.Object r2 = r15.next()
                java.util.HashMap r2 = (java.util.HashMap) r2
                r4 = r0
            L_0x0113:
                java.util.List<com.android.search.a> r5 = r14.f5359f
                int r5 = r5.size()
                if (r4 >= r5) goto L_0x0105
                java.util.List<com.android.search.a> r5 = r14.f5359f
                java.lang.Object r5 = r5.get(r4)
                com.android.search.a r5 = (com.android.search.C1432a) r5
                int r5 = r5.mo6258d()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                boolean r5 = r2.containsKey(r5)
                if (r5 == 0) goto L_0x0155
                java.util.List<com.android.search.a> r5 = r14.f5359f
                java.lang.Object r5 = r5.get(r4)
                com.android.search.a r5 = (com.android.search.C1432a) r5
                java.util.Collection r6 = r2.values()
                java.lang.String r6 = r6.toString()
                java.util.Collection r7 = r2.values()
                java.lang.String r7 = r7.toString()
                int r7 = r7.length()
                int r7 = r7 - r3
                java.lang.String r6 = r6.substring(r3, r7)
                r5.mo6252a((java.lang.String) r6)
            L_0x0155:
                int r4 = r4 + 1
                goto L_0x0113
            L_0x0158:
                com.android.activity.ReclistActivity r15 = com.android.activity.ReclistActivity.this
                com.android.common.utils.x r15 = r15.f5306fa
                android.database.Cursor r15 = r15.mo6198d()
                r14.f5355b = r15
                android.database.Cursor r15 = r14.f5355b
                if (r15 == 0) goto L_0x01a7
                int r15 = r15.getCount()
                if (r15 == 0) goto L_0x01a7
                android.database.Cursor r15 = r14.f5355b
                boolean r15 = r15.moveToFirst()
                if (r15 == 0) goto L_0x01a7
            L_0x0176:
                android.database.Cursor r15 = r14.f5355b
                java.lang.String r2 = "_mark_recfile_id"
                int r2 = r15.getColumnIndex(r2)
                int r15 = r15.getInt(r2)
                android.database.Cursor r2 = r14.f5355b
                java.lang.String r4 = "_mark_name"
                int r4 = r2.getColumnIndex(r4)
                java.lang.String r2 = r2.getString(r4)
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>()
                java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
                r4.put(r15, r2)
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r15 = r14.f5358e
                r15.add(r4)
                android.database.Cursor r15 = r14.f5355b
                boolean r15 = r15.moveToNext()
                if (r15 != 0) goto L_0x0176
            L_0x01a7:
                r15 = r0
            L_0x01a8:
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r2 = r14.f5358e
                int r2 = r2.size()
                if (r15 >= r2) goto L_0x0313
                r2 = r0
            L_0x01b1:
                java.util.List<com.android.search.a> r4 = r14.f5359f
                int r4 = r4.size()
                if (r2 >= r4) goto L_0x030f
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r4 = r14.f5358e
                java.lang.Object r4 = r4.get(r15)
                java.util.HashMap r4 = (java.util.HashMap) r4
                java.util.List<com.android.search.a> r5 = r14.f5359f
                java.lang.Object r5 = r5.get(r2)
                com.android.search.a r5 = (com.android.search.C1432a) r5
                int r5 = r5.mo6258d()
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                boolean r4 = r4.containsKey(r5)
                if (r4 == 0) goto L_0x030b
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r4 = r14.f5358e
                java.lang.Object r4 = r4.get(r15)
                java.util.HashMap r4 = (java.util.HashMap) r4
                java.util.Collection r4 = r4.values()
                java.lang.String r4 = r4.toString()
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r5 = r14.f5358e
                java.lang.Object r5 = r5.get(r15)
                java.util.HashMap r5 = (java.util.HashMap) r5
                java.util.Collection r5 = r5.values()
                java.lang.String r5 = r5.toString()
                int r5 = r5.length()
                int r5 = r5 - r3
                java.lang.String r4 = r4.substring(r3, r5)
                if (r4 == 0) goto L_0x030b
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r4 = r14.f5358e
                java.lang.Object r4 = r4.get(r15)
                java.util.HashMap r4 = (java.util.HashMap) r4
                java.util.Collection r4 = r4.values()
                java.lang.String r4 = r4.toString()
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r5 = r14.f5358e
                java.lang.Object r5 = r5.get(r15)
                java.util.HashMap r5 = (java.util.HashMap) r5
                java.util.Collection r5 = r5.values()
                java.lang.String r5 = r5.toString()
                int r5 = r5.length()
                int r5 = r5 - r3
                java.lang.String r4 = r4.substring(r3, r5)
                if (r4 == r1) goto L_0x030b
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                int r4 = r4.mo6265j()
                r5 = 2
                if (r4 == r5) goto L_0x027e
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                java.lang.String r4 = r4.mo6263h()
                if (r4 != 0) goto L_0x027e
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r6 = r14.f5358e
                java.lang.Object r6 = r6.get(r15)
                java.util.HashMap r6 = (java.util.HashMap) r6
                java.util.Collection r6 = r6.values()
                java.lang.String r6 = r6.toString()
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r7 = r14.f5358e
                java.lang.Object r7 = r7.get(r15)
                java.util.HashMap r7 = (java.util.HashMap) r7
                java.util.Collection r7 = r7.values()
                java.lang.String r7 = r7.toString()
                int r7 = r7.length()
                int r7 = r7 - r3
                java.lang.String r6 = r6.substring(r3, r7)
                r4.mo6255b((java.lang.String) r6)
            L_0x027e:
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r4 = r14.f5358e
                java.lang.Object r4 = r4.get(r15)
                java.util.HashMap r4 = (java.util.HashMap) r4
                java.util.Collection r4 = r4.values()
                java.lang.String r4 = r4.toString()
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r6 = r14.f5358e
                java.lang.Object r6 = r6.get(r15)
                java.util.HashMap r6 = (java.util.HashMap) r6
                java.util.Collection r6 = r6.values()
                java.lang.String r6 = r6.toString()
                int r6 = r6.length()
                int r6 = r6 - r3
                java.lang.String r4 = r4.substring(r3, r6)
                com.android.activity.ReclistActivity r6 = com.android.activity.ReclistActivity.this
                java.lang.String r6 = r6.f5304ea
                boolean r4 = r4.contains(r6)
                if (r4 == 0) goto L_0x030b
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                int r4 = r4.mo6265j()
                if (r4 == r5) goto L_0x030b
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r6 = r14.f5358e
                java.lang.Object r6 = r6.get(r15)
                java.util.HashMap r6 = (java.util.HashMap) r6
                java.util.Collection r6 = r6.values()
                java.lang.String r6 = r6.toString()
                java.util.List<java.util.HashMap<java.lang.Integer, java.lang.String>> r7 = r14.f5358e
                java.lang.Object r7 = r7.get(r15)
                java.util.HashMap r7 = (java.util.HashMap) r7
                java.util.Collection r7 = r7.values()
                java.lang.String r7 = r7.toString()
                int r7 = r7.length()
                int r7 = r7 - r3
                java.lang.String r6 = r6.substring(r3, r7)
                r4.mo6255b((java.lang.String) r6)
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                r4.mo6251a((int) r5)
                java.util.List<com.android.search.a> r4 = r14.f5359f
                java.lang.Object r4 = r4.get(r2)
                com.android.search.a r4 = (com.android.search.C1432a) r4
                r4.mo6256b((boolean) r3)
            L_0x030b:
                int r2 = r2 + 1
                goto L_0x01b1
            L_0x030f:
                int r15 = r15 + 1
                goto L_0x01a8
            L_0x0313:
                java.util.List<com.android.search.a> r15 = r14.f5359f
                int r15 = r15.size()
                if (r0 >= r15) goto L_0x03e2
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                java.lang.String r15 = r15.mo6264i()
                com.android.activity.ReclistActivity r1 = com.android.activity.ReclistActivity.this
                java.lang.String r1 = r1.f5304ea
                boolean r15 = r15.contains(r1)
                r1 = 4
                if (r15 == 0) goto L_0x037e
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                java.lang.String r15 = r15.mo6262g()
                if (r15 == 0) goto L_0x037e
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                java.lang.String r15 = r15.mo6262g()
                com.android.activity.ReclistActivity r2 = com.android.activity.ReclistActivity.this
                java.lang.String r2 = r2.f5304ea
                boolean r15 = r15.contains(r2)
                if (r15 == 0) goto L_0x0372
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                r1 = 5
                r15.mo6251a((int) r1)
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                r15.mo6253a((boolean) r3)
                goto L_0x03de
            L_0x0372:
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                r15.mo6251a((int) r1)
                goto L_0x03de
            L_0x037e:
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                java.lang.String r15 = r15.mo6264i()
                com.android.activity.ReclistActivity r2 = com.android.activity.ReclistActivity.this
                java.lang.String r2 = r2.f5304ea
                boolean r15 = r15.contains(r2)
                if (r15 == 0) goto L_0x03a2
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                r15.mo6251a((int) r1)
                goto L_0x03de
            L_0x03a2:
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                java.lang.String r15 = r15.mo6262g()
                if (r15 == 0) goto L_0x03de
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                java.lang.String r15 = r15.mo6262g()
                com.android.activity.ReclistActivity r1 = com.android.activity.ReclistActivity.this
                java.lang.String r1 = r1.f5304ea
                boolean r15 = r15.contains(r1)
                if (r15 == 0) goto L_0x03de
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                r15.mo6251a((int) r3)
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.lang.Object r15 = r15.get(r0)
                com.android.search.a r15 = (com.android.search.C1432a) r15
                r15.mo6253a((boolean) r3)
            L_0x03de:
                int r0 = r0 + 1
                goto L_0x0313
            L_0x03e2:
                java.util.List<com.android.search.a> r15 = r14.f5359f
                java.util.Iterator r15 = r15.iterator()
            L_0x03e8:
                boolean r0 = r15.hasNext()
                if (r0 == 0) goto L_0x03fe
                java.lang.Object r0 = r15.next()
                com.android.search.a r0 = (com.android.search.C1432a) r0
                int r0 = r0.mo6265j()
                if (r0 != 0) goto L_0x03e8
                r15.remove()
                goto L_0x03e8
            L_0x03fe:
                java.util.List<com.android.search.a> r15 = r14.f5359f
                com.android.activity.Ha r0 = new com.android.activity.Ha
                r0.<init>(r14)
                java.util.Collections.sort(r15, r0)
                java.lang.Boolean r15 = java.lang.Boolean.valueOf(r3)
                return r15
            L_0x040d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.activity.ReclistActivity.C1284e.doInBackground(java.lang.String[]):java.lang.Boolean");
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            Cursor cursor = this.f5354a;
            if (cursor != null) {
                cursor.close();
            }
            Cursor cursor2 = this.f5356c;
            if (cursor2 != null) {
                cursor2.close();
            }
            Cursor cursor3 = this.f5355b;
            if (cursor3 != null) {
                cursor3.close();
            }
            this.f5359f.clear();
            this.f5357d.clear();
            this.f5358e.clear();
            this.f5360g.clear();
            ReclistActivity.this.f5324oa.setAdapter((ListAdapter) null);
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            if (C1413m.m6844f()) {
                this.f5360g = new C1433b(ReclistActivity.this.f5261G, R.layout.iqoo_search_recorder_list_item, this.f5359f);
            } else {
                this.f5360g = new C1433b(ReclistActivity.this.f5261G, R.layout.search_recorder_list_item, this.f5359f);
            }
            this.f5359f.clear();
            this.f5357d.clear();
            this.f5358e.clear();
            this.f5360g.clear();
            if (ReclistActivity.this.f5308ga != null && ReclistActivity.this.f5308ga.size() > 0) {
                ReclistActivity.this.f5308ga.clear();
            }
            if (C1413m.m6844f()) {
                ReclistActivity.this.f5324oa.setBackgroundColor(Color.parseColor("#FF000000"));
            } else {
                ReclistActivity.this.f5324oa.setBackgroundColor(-1);
            }
        }

        /* synthetic */ C1284e(ReclistActivity reclistActivity, C1342la laVar) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            if (ReclistActivity.this.f5308ga != null && ReclistActivity.this.f5308ga.size() > 0) {
                ReclistActivity.this.f5308ga.clear();
            }
            List unused = ReclistActivity.this.f5308ga = this.f5359f;
            Cursor cursor = this.f5354a;
            if (cursor != null) {
                cursor.close();
            }
            Cursor cursor2 = this.f5356c;
            if (cursor2 != null) {
                cursor2.close();
            }
            Cursor cursor3 = this.f5355b;
            if (cursor3 != null) {
                cursor3.close();
            }
            if (bool.booleanValue()) {
                if (!isCancelled()) {
                    ReclistActivity.this.f5324oa.setAdapter(this.f5360g);
                }
                if (this.f5359f.size() == 0) {
                    ReclistActivity.this.f5334ta.setText(ReclistActivity.this.getResources().getString(R.string.search_no_result));
                    ReclistActivity.this.f5334ta.setVisibility(0);
                } else {
                    ReclistActivity.this.f5334ta.setVisibility(8);
                }
            } else {
                this.f5359f.clear();
                this.f5357d.clear();
                this.f5358e.clear();
                this.f5360g.clear();
                ReclistActivity.this.f5324oa.setAdapter((ListAdapter) null);
                ReclistActivity.this.f5324oa.showNotifyText(false);
                ReclistActivity.this.mo5893g(false);
            }
            super.onPostExecute(bool);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(Boolean... boolArr) {
            super.onProgressUpdate(boolArr);
        }
    }

    /* renamed from: a */
    private void m6469a(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("come_from")) != null && stringExtra.contains("incallui")) {
            try {
                m6520y();
            } catch (Exception unused) {
                C0938a.m5004b("SR/ReclistActivity", "parseIntentFromInCallUI error");
            }
        }
    }

    /* renamed from: b */
    public void mo5133b(boolean z) {
        this.f5258Ea = z;
    }

    /* renamed from: b */
    private boolean m6478b(long j) {
        C0938a.m5002a("SR/ReclistActivity", "<isNeedReturnForMark> marktime: " + j);
        int size = this.f5256Da.size();
        boolean z = false;
        if (size > 0) {
            int i = 0;
            while (true) {
                if (i < size && this.f5256Da.get(i).mo5064b() - j <= 1000) {
                    if (this.f5256Da.get(i).mo5064b() - j < 1000 && j - this.f5256Da.get(i).mo5064b() < 1000) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        C0938a.m5002a("SR/ReclistActivity", "<isNeedReturnForMark> temp: " + z);
        return z;
    }

    /* renamed from: a */
    public void mo5885a(Bundle bundle) {
        if (bundle != null) {
            this.f5257E = bundle.getInt("save_current_pager");
        }
    }

    /* renamed from: f */
    public int mo5141f() {
        return this.f5265I.getCallState();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m6457a(ListAdapter listAdapter) {
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

    /* renamed from: c */
    private String m6482c(String str) {
        C0938a.m5002a("SR/ReclistActivity", "<getRingToneToastTextGemini>,ringToneKeyName = " + str);
        String a = C1028b.m5456a().mo5369a(0);
        String a2 = C1028b.m5456a().mo5369a(1);
        if (VivoSettings.System.RINGTONE_SIM2.equals(str)) {
            return getString(R.string.ringtone_set_gemini, new Object[]{a2});
        }
        return getString(R.string.ringtone_set_gemini, new Object[]{a});
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6489d(String str) {
        C0938a.m5002a("SR/ReclistActivity", "<setSlotMessageTone>,(" + str + "),mItemLongClickFileId = " + this.f5253C);
        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5253C);
        Settings.System.putString(getContentResolver(), str, withAppendedId != null ? withAppendedId.toString() : null);
        C1492b.m7431a((Context) this, (CharSequence) C1416p.m6851a().mo6149a(C1028b.m5456a().mo5371b(), str), 0).show();
    }

    /* renamed from: f */
    public void mo5142f(boolean z) {
        this.f5325p = z;
    }

    /* renamed from: b */
    public void mo5889b(String str, Activity activity) {
        new AlertDialog.Builder(activity).setMessage(String.format(C1424v.m6867a(), new Object[]{activity.getString(R.string.app_name), str})).setTitle(R.string.unable_to_use_xx_permissions_title).setCancelable(false).setOnCancelListener(new C1354pa(this, activity)).setPositiveButton(R.string.permission_dialog_button_go_set, new C1351oa(this, activity)).setNegativeButton(R.string.cancel, new C1348na(this, activity)).create().show();
    }

    /* renamed from: c */
    public void mo5135c() {
        C0938a.m5002a("SR/ReclistActivity", "<menuSetOnItemLongClickListener>");
        if (!C1424v.m6870a("android.permission.READ_PHONE_STATE", this)) {
            this.f5314ja.postDelayed(new C1366ta(this), 300);
        } else {
            mo5895i();
        }
    }

    /* renamed from: d */
    public void mo5138d(boolean z) {
        this.f5321n = z;
    }

    /* renamed from: d */
    public void mo5137d() {
        C0938a.m5002a("SR/ReclistActivity", "<resetParameters>.");
        this.f5301d = true;
        this.f5303e = false;
        this.f5333t = null;
        this.f5345z = -1;
        this.f5253C = -1;
        this.f5249A = -1;
        C0938a.m5002a("SR/ReclistActivity", "<resetParameters>,mState = " + this.f5251B);
    }

    /* renamed from: a */
    public void mo5127a(String str) {
        int i = 8;
        if (this.f5283R.f4035ia) {
            C0938a.m5002a("SR/ReclistActivity", str + " " + this.f5283R.f4035ia);
            TabTitleView tabTitleView = this.f5271L;
            if (!this.f5313j) {
                i = 0;
            }
            tabTitleView.setVisibility(i);
            return;
        }
        C0938a.m5002a("SR/ReclistActivity", str + " " + this.f5271L.getVisibility());
        this.f5271L.setVisibility(8);
        m6518x();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6492e(String str) {
        C0938a.m5002a("SR/ReclistActivity", "<setSlotRingTone>,(" + str + "),mItemLongClickFileId = " + this.f5253C);
        m6487d(this.f5253C, str);
    }

    /* renamed from: c */
    public void mo5136c(boolean z) {
        mo5900m();
        if (z) {
            this.f5267J.setLeftButtonText(getString(R.string.deselect_all));
            if (C1411k.m6820b(this)) {
                this.f5267J.getLeftButton().setContentDescription(getString(R.string.deselect_all));
                return;
            }
            return;
        }
        this.f5267J.setLeftButtonText(getString(R.string.select_all));
        if (C1411k.m6820b(this)) {
            this.f5267J.getLeftButton().setContentDescription(getString(R.string.select_all));
        }
    }

    /* renamed from: e */
    public void mo5140e(boolean z) {
        this.f5303e = z;
    }

    /* renamed from: b */
    public void mo5132b() {
        PlaybackService.C1442a aVar = this.f5289U;
        if (aVar != null) {
            aVar.mo6315k();
        }
    }

    /* renamed from: a */
    private String m6466a(ArrayList<C0937a> arrayList) {
        return C1020b.m5434a(arrayList);
    }

    /* renamed from: a */
    private long m6460a(Uri uri) {
        StringBuilder sb;
        long j = 0;
        Cursor cursor = null;
        try {
            Cursor query = getContentResolver().query(uri, new String[]{"duration"}, (String) null, (String[]) null, (String) null);
            if (query != null && query.getCount() == 1) {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder();
                }
            }
        } catch (Exception e2) {
            C0938a.m5004b("SR/ReclistActivity", "<getFileDurationFromUri>, Exception 1: " + e2);
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
                    C0938a.m5004b("SR/ReclistActivity", "<getFileDurationFromUri>, Exception 2: " + e4);
                }
            }
            throw th;
        }
        C0938a.m5002a("SR/ReclistActivity", "<getFileDurationFromUri>, duration = " + j);
        return j;
        sb.append("<getFileDurationFromUri>, Exception 2: ");
        sb.append(e);
        C0938a.m5004b("SR/ReclistActivity", sb.toString());
        C0938a.m5002a("SR/ReclistActivity", "<getFileDurationFromUri>, duration = " + j);
        return j;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String, java.lang.String[], android.database.Cursor] */
    /* renamed from: d */
    private void m6487d(int i, String str) {
        StringBuilder sb;
        String str2;
        C0938a.m5002a("SR/ReclistActivity", "<setSlotRingtone(" + i + "," + str + ")>");
        ContentResolver contentResolver = getContentResolver();
        Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) i);
        try {
            ContentValues contentValues = new ContentValues(2);
            contentValues.put("is_ringtone", "1");
            contentValues.put("is_alarm", "1");
            ? r0 = 0;
            contentResolver.update(withAppendedId, contentValues, r0, r0);
            try {
                Cursor query = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "title"}, "_id='" + i + "'", (String[]) null, (String) null);
                if (query != null && query.getCount() == 1) {
                    query.moveToFirst();
                    Object string = query.getString(2);
                    Settings.System.putString(contentResolver, str, withAppendedId.toString());
                    if (C1028b.m5456a().mo5371b()) {
                        str2 = m6482c(str);
                    } else {
                        str2 = getString(R.string.ringtone_set, new Object[]{string});
                    }
                    C1492b.m7431a((Context) this, (CharSequence) str2, 0).show();
                }
                if (query != null) {
                    try {
                        query.close();
                        return;
                    } catch (Exception e) {
                        e = e;
                        sb = new StringBuilder();
                    }
                } else {
                    return;
                }
                sb.append("<setSlotRingtone> Exception 3: ");
                sb.append(e);
                C0938a.m5004b("SR/ReclistActivity", sb.toString());
            } catch (Exception e2) {
                C0938a.m5004b("SR/ReclistActivity", "<setSlotRingtone> Exception 2: " + e2);
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                    }
                }
            } catch (Throwable th) {
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (Exception e4) {
                        C0938a.m5004b("SR/ReclistActivity", "<setSlotRingtone> Exception 3: " + e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            C0938a.m5004b("SR/ReclistActivity", "<setSlotRingtone> Exception 1: " + e5);
        }
    }

    /* renamed from: b */
    public boolean mo5134b(int i, String str) {
        StringBuilder sb;
        C0938a.m5002a("SR/ReclistActivity", "<updateRecFileNameById>,sRecFileName = " + str + ",sRecFileId = " + i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_recfile_id='");
        sb2.append(i);
        sb2.append("'");
        String sb3 = sb2.toString();
        C0938a.m5002a("SR/ReclistActivity", "<updateRecFileNameById>,table = " + "notesimages" + ",where = " + sb3);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_reserved_bbb", str);
        C1018a aVar = this.f5300ca;
        boolean z = false;
        if (aVar != null) {
            try {
                this.f5263H = aVar.mo5342a("notesimages", C0935b.f3880b, sb3);
                boolean z2 = true;
                if (this.f5263H != null) {
                    int count = this.f5263H.getCount();
                    C0938a.m5002a("SR/ReclistActivity", "<updateRecFileNameById>,mRecFileCursor.getCount() = " + count);
                    if (count > 1) {
                        C0938a.m5008e("SR/ReclistActivity", "<updateRecFileNameById>,mRecFileCursor is more");
                    }
                }
                if (this.f5263H == null || this.f5263H.getCount() != 1) {
                    z2 = false;
                } else {
                    this.f5263H.moveToFirst();
                    int i2 = this.f5263H.getInt(0);
                    String string = this.f5263H.getString(1);
                    this.f5300ca.mo5346a("notesimages", sb3, contentValues);
                    C0938a.m5002a("SR/ReclistActivity", "<updateRecFileNameById>,sQueryRecFileId = " + i2 + ",sQueryRecFileName = " + string);
                }
                Cursor cursor = this.f5263H;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e) {
                        e = e;
                        sb = new StringBuilder();
                    }
                }
                z = z2;
            } catch (Exception e2) {
                C0938a.m5004b("SR/ReclistActivity", "<updateRecFileNameById>,Exception1 = " + e2);
                e2.printStackTrace();
                Cursor cursor2 = this.f5263H;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                    }
                }
            } catch (Throwable th) {
                Cursor cursor3 = this.f5263H;
                if (cursor3 != null) {
                    try {
                        cursor3.close();
                    } catch (Exception e4) {
                        C0938a.m5004b("SR/ReclistActivity", "<updateRecFileNameById>,Exception2 = " + e4);
                    }
                }
                throw th;
            }
        } else {
            C0938a.m5004b("SR/ReclistActivity", "<updateRecFileNameById>,mDB is null,error ");
        }
        C0938a.m5002a("SR/ReclistActivity", "<updateRecFileNameById>,sFlag = " + z);
        return z;
        sb.append("<updateRecFileNameById>,Exception2 = ");
        sb.append(e);
        C0938a.m5004b("SR/ReclistActivity", sb.toString());
        C0938a.m5002a("SR/ReclistActivity", "<updateRecFileNameById>,sFlag = " + z);
        return z;
    }

    /* renamed from: c */
    public void mo5890c(int i) {
        BbkTitleView bbkTitleView = this.f5267J;
        if (bbkTitleView != null) {
            Button leftButton = bbkTitleView.getLeftButton();
            if (i <= 100 && i >= 0) {
                if (TextUtils.getLayoutDirectionFromLocale(getResources().getConfiguration().locale) == 1) {
                    leftButton.setPivotX((float) (leftButton.getMeasuredWidth() - leftButton.getPaddingStart()));
                } else {
                    leftButton.setPivotX((float) leftButton.getPaddingStart());
                }
                leftButton.setPivotY(((float) leftButton.getMeasuredHeight()) / 2.0f);
                float f = (((float) i) * -0.0016500001f) + 1.0f;
                leftButton.setScaleX(f);
                leftButton.setScaleY(f);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6468a(DialogInterface dialogInterface) {
        try {
            Field declaredField = dialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
            boolean z = true;
            declaredField.setAccessible(true);
            if (m6441K()) {
                z = false;
            }
            declaredField.set(dialogInterface, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo5124a(int i, int i2, String str) {
        PlaybackService.C1442a aVar;
        this.f5333t = str;
        if (this.f5345z == i) {
            C0938a.m5002a("SR/ReclistActivity", "<onItemPlayClick>, nowBegin = " + this.f5301d);
            if (C1413m.f5710h && this.f5289U != null && this.f5251B == 3) {
                C0938a.m5002a("SR/ReclistActivity", "starting play in the list");
                try {
                    this.f5289U.mo6313i();
                    C1413m.f5710h = false;
                } catch (Exception unused) {
                    mo5123a(0);
                    C0938a.m5004b("SR/ReclistActivity", "<onItemPlayClick>,mplayer start again failed");
                    return;
                }
            } else if (!this.f5301d || (aVar = this.f5289U) == null) {
                PlaybackService.C1442a aVar2 = this.f5289U;
                if (aVar2 != null) {
                    aVar2.mo6311g();
                }
            } else if (this.f5251B == 4) {
                try {
                    aVar.mo6313i();
                    C0938a.m5002a("SR/ReclistActivity", "<onItemPlayClick>,-1,mState = " + this.f5251B);
                } catch (Exception unused2) {
                    mo5123a(0);
                    C0938a.m5004b("SR/ReclistActivity", "<onItemPlayClick>,mplayer start again failed");
                    return;
                }
            } else {
                this.f5259F = new C1282c(this, (C1342la) null);
                this.f5259F.execute(new Integer[0]);
                if (this.f5251B == 7) {
                    this.f5289U.mo6305b(ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) this.f5345z).toString());
                }
                C0938a.m5002a("SR/ReclistActivity", "<onItemPlayClick>,-2,mState = " + this.f5251B);
            }
            C1413m.f5710h = false;
            return;
        }
        mo5123a(6);
        if (this.f5255D != this.f5275N.getCurrentItem()) {
            if (this.f5255D == 0) {
                this.f5281Q.mo5105n();
                this.f5281Q.mo5103l();
            } else {
                this.f5283R.mo5105n();
                this.f5283R.mo5103l();
            }
            this.f5255D = this.f5275N.getCurrentItem();
        }
        this.f5345z = i;
        this.f5249A = i2;
        C0938a.m5002a("SR/ReclistActivity", "<onItemPlayClick>,-4,mState = " + this.f5251B);
        this.f5259F = new C1282c(this, (C1342la) null);
        this.f5259F.execute(new Integer[0]);
    }

    /* renamed from: b */
    public long mo5887b(String str) {
        StringBuilder sb;
        long j = 0;
        Cursor cursor = null;
        try {
            Cursor query = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"duration"}, "_data=?", new String[]{str}, (String) null);
            if (query != null && query.getCount() == 1) {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                try {
                    query.close();
                } catch (Exception e) {
                    e = e;
                    sb = new StringBuilder();
                }
            }
        } catch (Exception e2) {
            C0938a.m5004b("SR/ReclistActivity", "<getFileDurationFromUri> cannot open meida database: " + e2.toString());
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
                    C0938a.m5004b("SR/ReclistActivity", "<getFileDurationFromUri> Exception: " + e4.toString());
                }
            }
            throw th;
        }
        C0938a.m5002a("SR/ReclistActivity", "<getFileDurationFromUri>, duration = " + j);
        return j;
        sb.append("<getFileDurationFromUri> Exception: ");
        sb.append(e.toString());
        C0938a.m5004b("SR/ReclistActivity", sb.toString());
        C0938a.m5002a("SR/ReclistActivity", "<getFileDurationFromUri>, duration = " + j);
        return j;
    }

    /* renamed from: b */
    public void mo5888b(int i) {
        this.f5267J.setCenterText(String.format(this.f5261G.getString(R.string.already_choose_numbers), new Object[]{NumberFormat.getInstance().format((long) i)}));
    }

    /* renamed from: a */
    public void mo5126a(long j) {
        PlaybackService.C1442a aVar = this.f5289U;
        if (aVar != null) {
            aVar.mo6304b((int) j);
        }
    }

    /* renamed from: a */
    public boolean mo5131a() {
        return this.f5301d;
    }

    /* renamed from: a */
    public void mo5123a(int i) {
        C0938a.m5002a("SR/ReclistActivity", "<setState(" + i + ")>,mState = " + this.f5251B);
        if (i == 1 || i == 3 || i == 2) {
            this.f5301d = false;
        } else {
            this.f5301d = true;
        }
        this.f5251B = i;
        if (this.f5255D == 0) {
            C0953O o = this.f5281Q;
            o.f3988N = i;
            o.mo5093b(i);
            return;
        }
        C0953O o2 = this.f5283R;
        o2.f3988N = i;
        o2.mo5093b(i);
    }

    /* renamed from: a */
    public void mo5128a(String str, int i) {
        PlaybackService.C1442a aVar = this.f5289U;
        if (aVar != null && this.f5345z == i) {
            this.f5333t = str;
            aVar.mo6302a(str);
        }
    }

    /* renamed from: a */
    public void mo5129a(boolean z) {
        PlaybackService.C1442a aVar = this.f5289U;
        if (aVar != null) {
            aVar.mo6307c(z ^ true ? 1 : 0);
        }
    }

    /* renamed from: a */
    public void mo5125a(int i, String str) {
        this.f5253C = i;
    }

    /* renamed from: a */
    public void mo5130a(boolean z, boolean z2) {
        if (((this.f5257E == 0 && !z2) || (this.f5257E == 1 && z2)) && !this.f5313j) {
            if (this.f5281Q.f4035ia || this.f5283R.f4035ia) {
                int i = this.f5257E;
                if (i == 0) {
                    if (!this.f5281Q.f4035ia || this.f5313j) {
                        this.f5267J.hideRightButton();
                    } else {
                        this.f5267J.showRightButton();
                    }
                } else if (1 == i) {
                    if (!this.f5283R.f4035ia || this.f5313j) {
                        this.f5267J.hideRightButton();
                    } else {
                        this.f5267J.showRightButton();
                    }
                }
                if (!this.f5313j) {
                    this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, true);
                }
            } else {
                this.f5267J.hideRightButton();
                this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_FIRST, false);
            }
            boolean z3 = this.f5281Q.f4035ia;
            if (!z3) {
                this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, true);
            } else if (!z3) {
                this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, false);
            } else {
                this.f5267J.setIconViewVisible(BbkTitleView.RIGHT_ICON_SEC, true);
            }
        }
    }

    /* renamed from: a */
    public void mo5886a(String str, Activity activity) {
        new AlertDialog.Builder(activity).setMessage(String.format(C1424v.m6867a(), new Object[]{activity.getString(R.string.app_name), str})).setTitle(R.string.unable_to_use_xx_permissions_title).setCancelable(false).setOnCancelListener(new C1376ya(this, activity)).setPositiveButton(R.string.permission_dialog_button_go_set, new C1374xa(this, activity)).setNegativeButton(R.string.cancel, new C1370va(this, activity)).create().show();
    }

    /* renamed from: a */
    public LKListView mo5883a(Context context) {
        if (this.f5324oa == null) {
            this.f5324oa = new LKListView(context);
            this.f5324oa.setOnTouchListener(this.f5262Ga);
        }
        return this.f5324oa;
    }

    /* renamed from: a */
    public void mo5884a(int i, CharSequence charSequence) {
        if (C1413m.m6838b() >= 9.0f) {
            try {
                Method declaredMethod = BbkTitleView.class.getDeclaredMethod("setContentDescription", new Class[]{Integer.TYPE, CharSequence.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.f5267J, new Object[]{Integer.valueOf(i), charSequence});
            } catch (Exception e) {
                C0938a.m5002a("SR/ReclistActivity", "setContentDescriptionInherit FAILED!" + e);
                e.printStackTrace();
            }
        }
    }
}
