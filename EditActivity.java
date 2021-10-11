package com.android.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.android.bbksoundrecorder.AppFeature;
import com.android.bbksoundrecorder.R;
import com.android.bbksoundrecorder.filename.C1382a;
import com.android.common.utils.C1386C;
import com.android.common.utils.C1390G;
import com.android.common.utils.C1411k;
import com.android.common.utils.C1413m;
import com.android.common.utils.C1418q;
import com.android.common.utils.C1425w;
import com.android.common.utils.C1428z;
import com.android.service.PlaybackService;
import com.android.service.RecordService;
import com.android.view.widget.C1492b;
import com.android.view.widget.TwoStateLayout;
import java.io.File;
import java.util.HashMap;
import p007b.p044k.p045a.C0900b;
import p050c.p051a.p058e.p059a.C0938a;
import p050c.p051a.p060f.C0999i;

public class EditActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor>, C0999i.C1000a {

    /* renamed from: A */
    private C1245b f5027A;

    /* renamed from: B */
    private C1246c f5028B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public TelephonyManager f5029C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f5030D = 0;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f5031E = 0;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public C1425w f5032F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public C1428z f5033G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public C1248e f5034H;

    /* renamed from: I */
    private long f5035I = 0;

    /* renamed from: J */
    private AudioManager f5036J;

    /* renamed from: K */
    private ScreenBroadcastReceiver f5037K = new ScreenBroadcastReceiver();

    /* renamed from: L */
    private ScreenPlayBroadcastReceiver f5038L = new ScreenPlayBroadcastReceiver();

    /* renamed from: M */
    private Vibrator f5039M;

    /* renamed from: N */
    private View.OnClickListener f5040N = new C1311b(this);

    /* renamed from: O */
    private View.OnClickListener f5041O = new C1314c(this);

    /* renamed from: P */
    private View.OnClickListener f5042P = new C1317d(this);

    /* renamed from: Q */
    private View.OnClickListener f5043Q = new C1320e(this);

    /* renamed from: R */
    private View.OnClickListener f5044R = new C1323f(this);
    /* access modifiers changed from: private */

    /* renamed from: S */
    public DialogInterface.OnClickListener f5045S = new C1326g(this);

    /* renamed from: a */
    private Context f5046a;

    /* renamed from: b */
    private Button f5047b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Button f5048c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TwoStateLayout f5049d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TwoStateLayout f5050e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TwoStateLayout f5051f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C0999i f5052g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ProgressDialog f5053h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f5054i = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public String f5055j = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f5056k = null;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f5057l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f5058m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f5059n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f5060o = false;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f5061p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f5062q = false;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f5063r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f5064s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public C1244a f5065t;

    /* renamed from: u */
    private Intent f5066u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public PlaybackService.C1442a f5067v;

    /* renamed from: w */
    private Intent f5068w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public RecordService.C1445b f5069x;

    /* renamed from: y */
    private ServiceConnection f5070y;

    /* renamed from: z */
    private ServiceConnection f5071z;

    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        public ScreenBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (EditActivity.this.f5069x != null && EditActivity.this.f5067v != null) {
                String action = intent.getAction();
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    if (EditActivity.this.f5069x.mo6345f() == 2) {
                        EditActivity.this.f5067v.mo6300a(103);
                        EditActivity.this.f5067v.mo6299a();
                        EditActivity.this.f5069x.mo6337a(EditActivity.this.f5052g.f4271x, false);
                    }
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("from", "2");
                        C1390G.m6779b("A107|7|2|7", hashMap);
                    } catch (Exception unused) {
                        C0938a.m5004b("SR/EditActivity", "vcode error");
                    }
                } else if (action.equals("android.intent.action.USER_PRESENT")) {
                    EditActivity.this.f5069x.mo6335a();
                    if ((EditActivity.this.f5069x.mo6345f() == 1 || EditActivity.this.f5069x.mo6345f() == 2 || EditActivity.this.f5069x.mo6345f() == 4) && !SoundRecorder.f5380b) {
                        EditActivity.this.f5069x.mo6337a(EditActivity.this.f5052g.f4271x, true);
                    }
                }
            }
        }
    }

    public class ScreenPlayBroadcastReceiver extends BroadcastReceiver {
        public ScreenPlayBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            C0938a.m5002a("SR/EditActivity", "screen operationEditActivity" + action.toString());
            if (C1413m.f5702A == 2 && EditActivity.this.f5069x.mo6345f() != 2 && EditActivity.this.f5067v != null) {
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    if (EditActivity.this.f5067v.mo6310f() == 3 || EditActivity.this.f5067v.mo6310f() == 4) {
                        EditActivity.this.f5067v.mo6300a(103);
                        EditActivity.this.f5067v.mo6314j();
                    }
                } else if (action.equals("android.intent.action.SCREEN_ON")) {
                    if (EditActivity.this.f5031E == 0) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("from", "2");
                            C1390G.m6779b("A107|8|2|7", hashMap);
                        } catch (Exception unused) {
                            C0938a.m5004b("SR/EditActivity", "vcode error");
                        }
                    }
                } else if (action.equals("android.intent.action.USER_PRESENT")) {
                    EditActivity.this.f5067v.mo6300a(103);
                    EditActivity.this.f5067v.mo6299a();
                    if ((EditActivity.this.f5067v.mo6310f() == 3 || EditActivity.this.f5067v.mo6310f() == 4) && !SoundRecorder.f5380b) {
                        EditActivity.this.f5067v.mo6300a(103);
                        EditActivity.this.f5067v.mo6314j();
                    }
                }
            }
        }
    }

    /* renamed from: com.android.activity.EditActivity$b */
    private class C1245b extends BroadcastReceiver {
        private C1245b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                int i = 0;
                if (intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_PLAYBACK_STATE")) {
                    int intExtra = intent.getIntExtra("playback_state", 0);
                    if (EditActivity.this.f5067v == null || EditActivity.this.f5067v.mo6303b() == 103) {
                        C0938a.m5002a("SR/EditActivity", "MsgFromServiceReceiver state: " + intExtra);
                        EditActivity.this.f5065t.m6225a(intExtra);
                    }
                } else if (intent.getAction().equals("com.android.bbksoundrecorder.intent.action.INFORM_HEADSET_CONNECTION")) {
                    boolean booleanExtra = intent.getBooleanExtra("headset_connection_state", false);
                    C0938a.m5002a("SR/EditActivity", "MsgFromServiceReceiver headphone connection: " + booleanExtra);
                    boolean equals = EditActivity.this.f5032F.mo6178i().equals("true");
                    EditActivity.this.f5052g.mo5290a(booleanExtra ^ true, equals);
                    EditActivity editActivity = EditActivity.this;
                    if (equals) {
                        i = 3;
                    }
                    editActivity.setVolumeControlStream(i);
                }
            }
        }

        /* synthetic */ C1245b(EditActivity editActivity, C1311b bVar) {
            this();
        }
    }

    /* renamed from: com.android.activity.EditActivity$c */
    private class C1246c extends BroadcastReceiver {
        private C1246c() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.android.bbksoundrecorder.intent.action.RECORDER_STATE")) {
                if (EditActivity.this.f5069x == null || EditActivity.this.f5069x.mo6342c() != 101) {
                    int intExtra = intent.getIntExtra("recorder_state", 0);
                    C0938a.m5002a("SR/EditActivity", "MsgFromServiceReceiver state: " + intExtra);
                    EditActivity.this.m6152a(intExtra);
                }
            } else if (action.equals("com.android.bbksoundrecorder.intent.action.HANDLE_ERROR")) {
                intent.getIntExtra("handle_error", 0);
            }
        }

        /* synthetic */ C1246c(EditActivity editActivity, C1311b bVar) {
            this();
        }
    }

    /* renamed from: com.android.activity.EditActivity$d */
    private class C1247d implements ServiceConnection {
        private C1247d() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0938a.m5002a("SR/EditActivity", "PlaybackServiceConnection <onServiceConnected>: " + iBinder);
            PlaybackService.C1442a unused = EditActivity.this.f5067v = (PlaybackService.C1442a) iBinder;
            EditActivity.this.f5067v.mo6300a(103);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0938a.m5002a("SR/EditActivity", "PlaybackServiceConnection <onServiceDisconnected>");
        }

        /* synthetic */ C1247d(EditActivity editActivity, C1311b bVar) {
            this();
        }
    }

    /* renamed from: com.android.activity.EditActivity$e */
    private class C1248e extends AsyncTask<Integer, Integer, Boolean> {
        private C1248e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Integer... numArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("RecordClipTask <doInBackground> params: ");
            boolean z = false;
            sb.append(numArr[0]);
            C0938a.m5002a("SR/EditActivity", sb.toString());
            C0938a.m5002a("SR/EditActivity", "RecordClipTask <doInBackground> mFilePath: " + EditActivity.this.f5054i);
            String b = EditActivity.this.f5032F.mo6165b();
            File file = new File(b);
            if (!file.exists()) {
                file.mkdirs();
            }
            String unused = EditActivity.this.f5055j = b + File.separator + EditActivity.this.f5056k + "_" + EditActivity.this.f5059n + ".m4a";
            String str = null;
            long j = 0;
            if (numArr[0].intValue() == 2) {
                str = b + File.separator + EditActivity.this.f5056k + "_record" + ".m4a";
                j = EditActivity.this.m6157b(str);
            }
            String str2 = str;
            if (numArr[0].intValue() == 0 || numArr[0].intValue() == 1) {
                int c = EditActivity.this.f5065t.f5075b / 1000;
                String format = String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(c / 3600), Integer.valueOf((c % 3600) / 60), Integer.valueOf(c % 60)});
                int d = EditActivity.this.f5065t.f5077d / 1000;
                C0938a.m5002a("SR/EditActivity", "RecordClipTask <doInBackground> selectStart: " + format + " ~ " + "selectEnd: " + String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(d / 3600), Integer.valueOf((d % 3600) / 60), Integer.valueOf(d % 60)}));
            } else {
                int b2 = EditActivity.this.f5065t.f5076c / 1000;
                C0938a.m5002a("SR/EditActivity", "RecordClipTask <doInBackground> RecordStart: " + String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(b2 / 3600), Integer.valueOf((b2 % 3600) / 60), Integer.valueOf(b2 % 60)}));
            }
            if (numArr[0].intValue() == 0) {
                z = EditActivity.this.f5033G.mo6199a(EditActivity.this.f5054i, EditActivity.this.f5055j, EditActivity.this.f5057l, EditActivity.this.f5065t.f5075b, EditActivity.this.f5065t.f5077d);
            } else if (numArr[0].intValue() == 1) {
                z = EditActivity.this.f5033G.mo6201b(EditActivity.this.f5054i, EditActivity.this.f5055j, EditActivity.this.f5057l, EditActivity.this.f5065t.f5075b, EditActivity.this.f5065t.f5077d);
            } else if (numArr[0].intValue() == 2) {
                z = EditActivity.this.f5033G.mo6200a(EditActivity.this.f5054i, str2, EditActivity.this.f5055j, EditActivity.this.f5057l, EditActivity.this.f5058m, EditActivity.this.f5058m + ((int) j));
            }
            return Boolean.valueOf(z);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            C0938a.m5002a("SR/EditActivity", "RecordClipTask <onPreExecute>");
        }

        /* synthetic */ C1248e(EditActivity editActivity, C1311b bVar) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            C0938a.m5002a("SR/EditActivity", "RecordClipTask <onPostExecute(" + bool + ")>,");
            if (bool.booleanValue()) {
                EditActivity editActivity = EditActivity.this;
                long unused = editActivity.f5057l = editActivity.m6157b(editActivity.f5055j);
                EditActivity.this.f5052g.mo5288a(EditActivity.this.f5055j, Long.valueOf(EditActivity.this.f5057l));
                boolean unused2 = EditActivity.this.f5060o = true;
                if (EditActivity.this.f5053h != null && EditActivity.this.f5053h.isShowing() && EditActivity.this.mo5767f()) {
                    try {
                        EditActivity.this.f5053h.dismiss();
                    } catch (Exception e) {
                        ProgressDialog unused3 = EditActivity.this.f5053h = null;
                        C0938a.m5002a("SR/EditActivity", "mProgressDialog.dismiss() Function Error:" + e.toString());
                    }
                }
                EditActivity.this.f5048c.setEnabled(true);
                if (!(EditActivity.this.f5067v == null || EditActivity.this.f5065t.f5074a == 0)) {
                    EditActivity.this.f5067v.mo6315k();
                }
                String unused4 = EditActivity.this.f5065t.f5078e = EditActivity.this.f5055j;
                if (EditActivity.this.f5059n > 0) {
                    C0938a.m5002a("SR/EditActivity", "RecordClipTask <onPostExecute>,delete() filePath: " + EditActivity.this.f5054i);
                    File file = new File(EditActivity.this.f5054i);
                    if (file.exists()) {
                        boolean delete = file.delete();
                        C0938a.m5002a("SR/EditActivity", "RecordClipTask <onPostExecute>,delete() result: " + delete);
                    }
                }
                EditActivity editActivity2 = EditActivity.this;
                String unused5 = editActivity2.f5054i = editActivity2.f5055j;
                EditActivity.m6201w(EditActivity.this);
            } else if (EditActivity.this.f5053h != null && EditActivity.this.f5053h.isShowing() && EditActivity.this.mo5767f()) {
                EditActivity.this.f5053h.dismiss();
            }
            if (EditActivity.this.f5031E == 3) {
                EditActivity.this.f5069x.mo6341b();
            }
            if (!EditActivity.this.f5063r) {
                EditActivity.this.getLoaderManager().initLoader(1, (Bundle) null, EditActivity.this).forceLoad();
            } else if (EditActivity.this.m6204x()) {
                C1413m.f5727y = -1;
                EditActivity.this.finish();
            }
        }
    }

    /* renamed from: com.android.activity.EditActivity$f */
    private class C1249f implements ServiceConnection {
        private C1249f() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            RecordService.C1445b unused = EditActivity.this.f5069x = (RecordService.C1445b) iBinder;
            C0938a.m5002a("SR/EditActivity", "RecordServiceConnection <onServiceConnected> , RecordState: " + EditActivity.this.f5069x.mo6345f());
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0938a.m5002a("SR/EditActivity", "RecordServiceConnection <onServiceDisconnected>");
        }

        /* synthetic */ C1249f(EditActivity editActivity, C1311b bVar) {
            this();
        }
    }

    /* renamed from: w */
    static /* synthetic */ int m6201w(EditActivity editActivity) {
        int i = editActivity.f5059n;
        editActivity.f5059n = i + 1;
        return i;
    }

    public void onBackPressed() {
        C0938a.m5002a("SR/EditActivity", "<onBackPressed> mRecordState: " + this.f5031E);
        C0938a.m5002a("SR/EditActivity", "<onBackPressed> mIsChanged: " + this.f5060o);
        C1413m.f5727y = -1;
        int i = this.f5031E;
        if (i == 2 || i == 4) {
            m6164c(true);
        } else if (this.f5060o) {
            m6164c(false);
        } else {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0938a.m5002a("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onConfigurationChanged " + configuration);
        m6182m();
        m6142B();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6200v();
        m6186o();
        m6188p();
        m6196t();
        m6193s();
        m6189q();
        m6192r();
        m6206y();
        getLoaderManager().initLoader(1, (Bundle) null, this).forceLoad();
        mo5769h();
        mo5768g();
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        C0938a.m5002a("SR/EditActivity", "Load new name: <onCreateLoader>");
        return new C1382a(i, this.f5046a);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        C0938a.m5006c("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onDestroy");
        ServiceConnection serviceConnection = this.f5070y;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
        Intent intent = this.f5066u;
        if (intent != null) {
            stopService(intent);
        }
        ServiceConnection serviceConnection2 = this.f5071z;
        if (serviceConnection2 != null) {
            unbindService(serviceConnection2);
        }
        Intent intent2 = this.f5068w;
        if (intent2 != null) {
            stopService(intent2);
        }
        C1245b bVar = this.f5027A;
        if (bVar != null) {
            unregisterReceiver(bVar);
            this.f5027A = null;
        }
        mo5771j();
        mo5770i();
        if (this.f5028B != null) {
            C0900b.m4902a(this.f5046a).mo4899a((BroadcastReceiver) this.f5028B);
            this.f5028B = null;
        }
        C1425w wVar = this.f5032F;
        if (wVar != null) {
            wVar.mo6189t();
            this.f5032F = null;
        }
        C1413m.f5727y = -1;
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        C0938a.m5002a("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onNewIntent");
        m6153a(intent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C0938a.m5006c("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onPause");
        if (this.f5067v != null && this.f5065t.f5074a == 3) {
            if (!isFinishing()) {
                this.f5067v.mo6314j();
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("from", "1");
                    C1390G.m6779b("A107|8|2|7", hashMap);
                } catch (Exception unused) {
                    C0938a.m5004b("SR/EditActivity", "vcode error");
                }
            } else {
                this.f5067v.mo6315k();
            }
        }
        if (isFinishing()) {
            SoundRecorder.f5380b = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C0938a.m5006c("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onResume");
        m6182m();
        if (this.f5067v != null) {
            if (this.f5065t.mo5786a() != this.f5067v.mo6310f()) {
                C0938a.m5002a("SR/EditActivity", "<onResume> playService state has been changed!");
                this.f5065t.m6225a(this.f5067v.mo6310f());
            }
            this.f5067v.mo6299a();
            this.f5067v.mo6300a(103);
        }
        RecordService.C1445b bVar = this.f5069x;
        if (bVar != null) {
            bVar.mo6335a();
        }
        if (!new File(this.f5054i).exists()) {
            int i = this.f5031E;
            if (i == 2 || i == 4) {
                RecordService.C1445b bVar2 = this.f5069x;
                if (bVar2 != null) {
                    bVar2.mo6352m();
                    this.f5069x.mo6341b();
                } else {
                    C0938a.m5004b("SR/EditActivity", "<onResume> mRecordServiceController == null!!");
                }
            }
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SoundRecorder.f5380b = true;
        C1413m.f5702A = 2;
        C0938a.m5006c("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStart");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        RecordService.C1445b bVar;
        super.onStop();
        C0938a.m5006c("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onStop isFinishing" + isFinishing());
        if (!isFinishing()) {
            SoundRecorder.f5380b = false;
        }
        if (!isFinishing() && (bVar = this.f5069x) != null) {
            if (bVar.mo6345f() == 2) {
                this.f5069x.mo6337a(this.f5052g.f4271x, false);
                this.f5069x.mo6340a(true);
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("from", "1");
                C1390G.m6779b("A107|7|2|7", hashMap);
            } catch (Exception unused) {
                C0938a.m5004b("SR/EditActivity", "vcode error");
            }
        }
    }

    /* renamed from: com.android.activity.EditActivity$a */
    public class C1244a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f5074a = 0;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f5075b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f5076c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f5077d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public String f5078e;

        /* renamed from: f */
        private Handler f5079f = new Handler();

        /* renamed from: g */
        private Runnable f5080g = new C1332i(this);

        public C1244a() {
            C0938a.m5002a("SR/EditActivity", "<MediaPlayerWrapper>,new");
        }

        /* renamed from: b */
        public void mo5788b(String str) {
            C0938a.m5002a("SR/EditActivity", "<startPlayback(path)>: " + str);
            if (EditActivity.this.f5067v != null) {
                EditActivity.this.f5067v.mo6305b(str);
                C0938a.m5002a("SR/EditActivity", "<startPlayback> mPlayNow: " + this.f5076c + ",mPlayEndMsec: " + EditActivity.this.f5052g.f4272y);
                if (this.f5076c >= 0) {
                    EditActivity.this.f5067v.mo6304b(this.f5076c);
                }
            }
        }

        /* renamed from: a */
        public void mo5787a(String str) {
            C0938a.m5002a("SR/EditActivity", "<processPlayback>, mPlayerPath = " + str + "  mPlayState = " + this.f5074a);
            this.f5078e = str;
            if (Math.abs(this.f5077d - this.f5076c) <= 10) {
                this.f5076c = this.f5075b;
                EditActivity.this.f5052g.mo5299g();
                this.f5079f.postDelayed(this.f5080g, 100);
                return;
            }
            this.f5079f.postDelayed(this.f5080g, 0);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m6225a(int i) {
            C0938a.m5002a("SR/EditActivity", "<setState(" + i + ")>,mPlayState = " + this.f5074a);
            this.f5074a = i;
            if (i != 0) {
                switch (i) {
                    case 2:
                        C0938a.m5002a("SR/EditActivity", "<updateListItemView(PREPARE_STATE)>");
                        return;
                    case 3:
                        C0938a.m5002a("SR/EditActivity", "<updateListItemView(PLAYING_STATE)>");
                        m6227a(true);
                        EditActivity.this.f5049d.setEnabled(false);
                        EditActivity.this.f5051f.setEnabled(false);
                        EditActivity.this.f5052g.mo5301i();
                        if (EditActivity.this.f5064s) {
                            boolean unused = EditActivity.this.f5064s = false;
                            return;
                        }
                        return;
                    case 4:
                        C0938a.m5002a("SR/EditActivity", "<updateListItemView(PAUSE_STATE)>");
                        m6227a(false);
                        EditActivity.this.f5049d.setEnabled(true);
                        EditActivity.this.f5051f.setEnabled(EditActivity.this.f5061p);
                        EditActivity.this.f5052g.mo5297e();
                        return;
                    case 5:
                        m6227a(false);
                        EditActivity.this.f5049d.setEnabled(true);
                        EditActivity.this.f5051f.setEnabled(EditActivity.this.f5061p);
                        return;
                    case 6:
                        C0938a.m5002a("SR/EditActivity", "<updateListItemView(COMPLETION_STATE)>");
                        EditActivity.this.f5052g.mo5295d();
                        if (EditActivity.this.f5067v != null) {
                            EditActivity.this.f5067v.mo6315k();
                        }
                        EditActivity.this.f5049d.setEnabled(true);
                        EditActivity.this.f5051f.setEnabled(EditActivity.this.f5061p);
                        m6227a(false);
                        return;
                    case 7:
                        C0938a.m5004b("SR/EditActivity", "<updateListItemView>,state is error");
                        EditActivity.this.f5049d.setEnabled(true);
                        EditActivity.this.f5051f.setEnabled(EditActivity.this.f5061p);
                        return;
                    default:
                        return;
                }
            } else {
                C0938a.m5002a("SR/EditActivity", "<updateListItemView(IDLE_STATE)>");
                if (!EditActivity.this.f5064s) {
                    m6227a(false);
                    EditActivity.this.f5049d.setEnabled(true);
                    EditActivity.this.f5051f.setEnabled(EditActivity.this.f5061p);
                    if (EditActivity.this.f5052g.f4232A) {
                        EditActivity.this.f5052g.mo5297e();
                    }
                }
            }
        }

        /* renamed from: a */
        public int mo5786a() {
            return this.f5074a;
        }

        /* renamed from: a */
        private void m6227a(boolean z) {
            C0938a.m5002a("SR/EditActivity", "<setPlayBackground>,isPlay = " + z);
            if (EditActivity.this.f5050e != null && z) {
                if (C1413m.m6844f()) {
                    EditActivity.this.f5050e.mo6532a(EditActivity.this.getResources().getString(R.string.pause), R.drawable.iqoo_btn_edit_pause_selector);
                } else {
                    EditActivity.this.f5050e.mo6532a(EditActivity.this.getResources().getString(R.string.pause), R.drawable.btn_edit_pause_selector);
                }
                if (C1411k.m6820b(EditActivity.this)) {
                    TwoStateLayout u = EditActivity.this.f5050e;
                    u.setContentDescription(EditActivity.this.getResources().getString(R.string.pause) + "," + EditActivity.this.getResources().getString(R.string.button_talkback));
                }
            } else if (EditActivity.this.f5050e == null || z) {
                C0938a.m5008e("SR/EditActivity", "<setPlayBackground>,mPlayBtn == null,isPlay = " + z);
            } else {
                if (C1413m.m6844f()) {
                    EditActivity.this.f5050e.mo6532a(EditActivity.this.getResources().getString(R.string.continue_recording), R.drawable.iqoo_btn_edit_play_selector);
                } else {
                    EditActivity.this.f5050e.mo6532a(EditActivity.this.getResources().getString(R.string.continue_recording), R.drawable.btn_edit_play_selector);
                }
                if (C1411k.m6820b(EditActivity.this)) {
                    TwoStateLayout u2 = EditActivity.this.f5050e;
                    u2.setContentDescription(EditActivity.this.getResources().getString(R.string.continue_recording) + "," + EditActivity.this.getResources().getString(R.string.button_talkback));
                }
            }
        }
    }

    /* renamed from: A */
    private void m6139A() {
        if (C1411k.m6820b(this)) {
            TwoStateLayout twoStateLayout = this.f5049d;
            twoStateLayout.setContentDescription(getResources().getString(R.string.manager_title) + "," + getResources().getString(R.string.button_talkback));
            TwoStateLayout twoStateLayout2 = this.f5050e;
            twoStateLayout2.setContentDescription(getResources().getString(R.string.continue_recording) + "," + getResources().getString(R.string.button_talkback));
            TwoStateLayout twoStateLayout3 = this.f5051f;
            twoStateLayout3.setContentDescription(getResources().getString(R.string.clip) + "，" + getResources().getString(R.string.button_talkback));
        }
    }

    /* renamed from: B */
    private void m6142B() {
        m6206y();
        if (!C1413m.m6844f()) {
            C1244a aVar = this.f5065t;
            if (aVar == null || aVar.f5074a != 3) {
                this.f5050e.mo6533a(getResources().getString(R.string.rtot_crop_page_playing), (int) R.drawable.btn_edit_play_selector, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
            } else {
                this.f5050e.mo6532a(getResources().getString(R.string.pause), R.drawable.btn_edit_pause_selector);
            }
            this.f5051f.mo6532a(getResources().getString(R.string.clip), R.drawable.btn_edit_clip_selector);
        }
    }

    /* renamed from: k */
    private void m6178k() {
        if (Build.VERSION.SDK_INT >= 26 && this.f5036J.getRingerMode() != 0) {
            this.f5039M.vibrate(VibrationEffect.createOneShot(12, 75));
        }
    }

    /* renamed from: l */
    private void m6180l() {
        Bundle bundle = new Bundle();
        bundle.putString("clip_filePath", this.f5054i);
        bundle.putLong("clip_fileDuration", this.f5057l);
        this.f5052g = (C0999i) getFragmentManager().findFragmentByTag("edit_fragment");
        StringBuilder sb = new StringBuilder();
        sb.append("<initResource> mEditFragment is null? ");
        sb.append(this.f5052g == null);
        C0938a.m5002a("SR/EditActivity", sb.toString());
        if (this.f5052g == null) {
            this.f5052g = C0999i.m5359a(bundle);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            beginTransaction.add(R.id.itemContainer, this.f5052g, "edit_fragment");
            beginTransaction.commit();
        }
    }

    /* renamed from: m */
    private void m6182m() {
        C0938a.m5002a("SR/EditActivity", "<changeNavigationBar>");
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.edit_control_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (C1418q.m6857a(this.f5046a)) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else if (C1413m.m6844f()) {
            layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.control_layout_margin_bottom_nonar));
        } else {
            layoutParams.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.margin_bottom_note_play_btn_nonar_x));
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    /* renamed from: n */
    private boolean m6184n() {
        boolean z;
        C0938a.m5002a("SR/EditActivity", "<conditionJudge>");
        boolean z2 = true;
        C1413m.f5709g = 1;
        if (1 == C1413m.f5712j) {
            C1492b.m7431a((Context) this, (CharSequence) getString(R.string.please_close_background_recorder), 0).show();
            finish();
            z = true;
        } else {
            z = false;
        }
        if (1 == C1413m.f5713k) {
            finish();
            C1413m.f5713k = 0;
            z = true;
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.f5054i = intent.getStringExtra("clip_filePath");
            String str = this.f5054i;
            if (str != null) {
                this.f5057l = m6157b(str);
                z2 = z;
            } else {
                finish();
            }
        } else {
            finish();
        }
        C0938a.m5002a("SR/EditActivity", "<onCreate> intent mFilePath: " + this.f5054i + ", mDuration: " + this.f5057l);
        return z2;
    }

    /* renamed from: o */
    private void m6186o() {
        this.f5029C = (TelephonyManager) this.f5046a.getSystemService("phone");
        this.f5032F = new C1425w(this.f5046a);
    }

    /* renamed from: p */
    private void m6188p() {
        if (this.f5065t == null) {
            this.f5065t = new C1244a();
        }
        if (this.f5033G == null) {
            this.f5033G = new C1428z();
        }
    }

    /* renamed from: q */
    private void m6189q() {
        C0938a.m5002a("SR/EditActivity", "<initPlayService>");
        this.f5066u = new Intent(this, PlaybackService.class);
        this.f5070y = new C1247d(this, (C1311b) null);
        try {
            C1386C.m6759a(this.f5066u);
        } catch (Exception e) {
            C0938a.m5004b("SR/EditActivity", "<initPlayService>" + e);
        }
        bindService(this.f5066u, this.f5070y, 1);
        this.f5027A = new C1245b(this, (C1311b) null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_PLAYBACK_STATE");
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.INFORM_HEADSET_CONNECTION");
        registerReceiver(this.f5027A, intentFilter);
    }

    /* renamed from: r */
    private void m6192r() {
        C0938a.m5002a("SR/EditActivity", "<initRecordService>");
        this.f5068w = new Intent(this, RecordService.class);
        this.f5068w.putExtra("record_activity_type", 102);
        this.f5071z = new C1249f(this, (C1311b) null);
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                startForegroundService(this.f5068w);
            } else {
                startService(this.f5068w);
            }
        } catch (Exception e) {
            C0938a.m5004b("SR/EditActivity", "initRecordService" + e);
        }
        bindService(this.f5068w, this.f5071z, 1);
        m6202w();
    }

    /* renamed from: s */
    private void m6193s() {
        C0938a.m5002a("SR/EditActivity", "<initResource>");
        m6180l();
        this.f5047b = (Button) findViewById(R.id.btn_edit_cancel);
        this.f5048c = (Button) findViewById(R.id.btn_edit_save);
        this.f5049d = (TwoStateLayout) findViewById(R.id.btn_edit_record);
        this.f5050e = (TwoStateLayout) findViewById(R.id.btn_edit_play);
        this.f5051f = (TwoStateLayout) findViewById(R.id.btn_edit_clip);
        this.f5047b.setOnClickListener(this.f5040N);
        this.f5048c.setOnClickListener(this.f5041O);
        this.f5050e.setOnClickListener(this.f5043Q);
        this.f5051f.setOnClickListener(this.f5044R);
        this.f5049d.setOnClickListener(this.f5042P);
        this.f5048c.setEnabled(false);
        this.f5051f.setEnabled(false);
        m6139A();
        m6208z();
    }

    /* renamed from: t */
    private void m6196t() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f5039M = (Vibrator) getSystemService("vibrator");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public boolean m6198u() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f5035I <= 500) {
            return true;
        }
        this.f5035I = uptimeMillis;
        return false;
    }

    /* renamed from: v */
    private void m6200v() {
        C0938a.m5006c("SR/EditActivity", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~onCreate");
        this.f5036J = (AudioManager) getSystemService("audio");
        if (C1413m.m6844f()) {
            setContentView(R.layout.iqoo_activity_edit);
        } else {
            setContentView(R.layout.activity_edit);
        }
        this.f5046a = getApplicationContext();
        if (m6184n()) {
        }
    }

    /* renamed from: w */
    private void m6202w() {
        this.f5028B = new C1246c(this, (C1311b) null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.RECORDER_STATE");
        intentFilter.addAction("com.android.bbksoundrecorder.intent.action.HANDLE_ERROR");
        C0900b.m4902a(this.f5046a).mo4900a(this.f5028B, intentFilter);
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public boolean m6204x() {
        C0938a.m5002a("SR/EditActivity", "<saveRecordFile> mTempFilePath: " + this.f5055j);
        File file = new File(this.f5055j);
        C1413m.f5726x = this.f5056k;
        if (this.f5032F.mo6163a((file.length() / 1024) + 1)) {
            C0938a.m5002a("SR/EditActivity", "<saveRecordFile> File size is larger than storage space, save false!");
            C1492b.m7431a((Context) this, (CharSequence) getResources().getString(R.string.sdcard_not_enough), 0).show();
            return false;
        } else if (!file.exists()) {
            return true;
        } else {
            String str = this.f5032F.mo6171e() + File.separator + this.f5056k + ".m4a";
            C0938a.m5002a("SR/EditActivity", "<saveRecordFile> renameTo newPath: " + str);
            File file2 = new File(str);
            boolean renameTo = file.renameTo(file2);
            C0938a.m5002a("SR/EditActivity", "<saveRecordFile> renameTo result: " + renameTo);
            if (!renameTo) {
                return true;
            }
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.parse("file://" + file2.getAbsolutePath()));
            sendBroadcast(intent);
            C1492b.m7431a((Context) this, (CharSequence) getString(R.string.record_edit_save_success), 0).show();
            return true;
        }
    }

    /* renamed from: y */
    private void m6206y() {
        if (C1413m.m6844f()) {
            getWindow().setStatusBarColor(C1413m.f5721s);
            getWindow().setNavigationBarColor(C1413m.f5721s);
        } else if (C1413m.m6841c(this)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.window_background_nightmode_color));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.window_background_nightmode_color));
        } else {
            getWindow().setStatusBarColor(getResources().getColor(R.color.window_background_color));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.window_background_color));
        }
    }

    /* renamed from: z */
    private void m6208z() {
        this.f5049d.mo6533a(getResources().getString(R.string.manager_title), (int) R.drawable.btn_edit_record_selector, getResources().getDimensionPixelSize(R.dimen.side_text_margin_diff));
        this.f5049d.setTextSize(14.0f);
        this.f5050e.mo6533a(getResources().getString(R.string.rtot_crop_page_playing), (int) R.drawable.btn_edit_play_selector, getResources().getDimensionPixelSize(R.dimen.middle_text_margin_diff));
        if (C1413m.m6845g()) {
            this.f5050e.setTextSize(12.0f);
        } else {
            this.f5050e.setTextSize(14.0f);
        }
        this.f5051f.mo6533a(getResources().getString(R.string.clip), (int) R.drawable.btn_edit_clip_selector, getResources().getDimensionPixelSize(R.dimen.side_text_margin_diff));
        if (C1413m.m6845g()) {
            this.f5051f.setTextSize(12.0f);
        } else {
            this.f5051f.setTextSize(14.0f);
        }
    }

    /* renamed from: f */
    public boolean mo5767f() {
        return !isDestroyed() && !isFinishing();
    }

    /* renamed from: g */
    public void mo5768g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        registerReceiver(this.f5038L, intentFilter);
    }

    /* renamed from: h */
    public void mo5769h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (AppFeature.f5621q) {
            registerReceiver(this.f5037K, intentFilter);
        }
    }

    /* renamed from: i */
    public void mo5770i() {
        try {
            if (this.f5038L != null) {
                unregisterReceiver(this.f5038L);
                this.f5038L = null;
            }
        } catch (Exception unused) {
            C0938a.m5004b("SR/EditActivity", "unregisterPlayScreen exception");
        }
    }

    /* renamed from: j */
    public void mo5771j() {
        if (AppFeature.f5621q) {
            try {
                if (this.f5037K != null) {
                    unregisterReceiver(this.f5037K);
                    this.f5037K = null;
                }
            } catch (Exception unused) {
                C0938a.m5004b("SR/EditActivity", "unregisterScreen exception");
            }
        }
    }

    /* renamed from: e */
    public long mo5315e() {
        return this.f5035I;
    }

    /* renamed from: d */
    public int mo5314d() {
        if (this.f5031E == 2) {
            return (int) this.f5069x.mo6348i();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public long m6157b(String str) {
        C0938a.m5002a("SR/EditActivity", "<getDuration> filePath: " + str);
        MediaExtractor mediaExtractor = new MediaExtractor();
        long j = 0;
        try {
            mediaExtractor.setDataSource(str);
            if (mediaExtractor.getTrackCount() > 0) {
                j = mediaExtractor.getTrackFormat(0).getLong("durationUs") / 1000;
            }
            mediaExtractor.release();
        } catch (Exception e) {
            C0938a.m5004b("SR/EditActivity", "<getDuration> mediaExtractor Exception: " + e.getMessage());
        }
        C0938a.m5002a("SR/EditActivity", "<getDuration> duration: " + j);
        return j;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6164c(boolean z) {
        C0938a.m5002a("SR/EditActivity", "<deleteTempFile> isRecording: " + z + ", mTempFilePath: " + this.f5055j);
        AlertDialog create = new AlertDialog.Builder(this, 51314692).setTitle(getString(R.string.record_clip_abandon_message)).setPositiveButton(R.string.abandon, new C1329h(this, z)).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.setOwnerActivity(this);
        if (!isDestroyed() && !isFinishing()) {
            create.show();
        }
        create.getWindow().setGravity(80);
    }

    /* renamed from: d */
    private void m6169d(boolean z) {
        C0938a.m5002a("SR/EditActivity", "<setRecordBackground>,isRecord = " + z);
        if (this.f5049d != null && z) {
            if (C1413m.m6844f()) {
                this.f5049d.mo6532a(getResources().getString(R.string.done), R.drawable.iqoo_btn_edit_record_pause_selector);
            } else {
                this.f5049d.mo6532a(getResources().getString(R.string.done), R.drawable.btn_edit_record_pause_selector);
            }
            if (C1411k.m6820b(this)) {
                TwoStateLayout twoStateLayout = this.f5049d;
                twoStateLayout.setContentDescription(getResources().getString(R.string.done) + "," + getResources().getString(R.string.button_talkback));
            }
        } else if (this.f5049d == null || z) {
            C0938a.m5008e("SR/EditActivity", "<setRecordBackground>,mRecordBtn == null,isRecord = " + z);
        } else {
            if (C1413m.m6844f()) {
                this.f5049d.mo6532a(getResources().getString(R.string.manager_title), R.drawable.iqoo_btn_edit_record_selector);
            } else {
                this.f5049d.mo6532a(getResources().getString(R.string.manager_title), R.drawable.btn_edit_record_selector);
            }
            if (C1411k.m6820b(this)) {
                TwoStateLayout twoStateLayout2 = this.f5049d;
                twoStateLayout2.setContentDescription(getResources().getString(R.string.manager_title) + "," + getResources().getString(R.string.button_talkback));
            }
        }
    }

    /* renamed from: a */
    private void m6153a(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            C0938a.m5002a("SR/EditActivity", "<parseQuickStartIntent> intent.getAction(): " + intent.getAction());
            if (action != null && action.equals("com.record.finish.eidtrecord")) {
                int i = this.f5031E;
                if (i == 2 || i == 4) {
                    this.f5052g.mo5298f();
                    this.f5069x.mo6352m();
                }
            }
        }
    }

    /* renamed from: b */
    public int mo5311b() {
        int i;
        if (this.f5067v == null) {
            C0938a.m5004b("SR/EditActivity", "mPlaybackControllerBinder == null");
            this.f5052g.mo5297e();
            return -1;
        }
        if (this.f5065t.f5074a == 3 || this.f5065t.f5074a == 4) {
            i = this.f5067v.mo6306c();
            if (i >= this.f5065t.f5077d) {
                i = this.f5065t.f5077d;
                this.f5052g.mo5295d();
                this.f5067v.mo6315k();
            }
        } else if (this.f5065t.f5074a == 6) {
            i = this.f5067v.mo6308d();
        } else {
            i = this.f5065t.f5075b;
        }
        int unused = this.f5065t.f5076c = i;
        return i;
    }

    /* renamed from: a */
    public void mo5309a(int i, int i2, int i3) {
        TwoStateLayout twoStateLayout;
        C1244a aVar = this.f5065t;
        if (aVar != null) {
            int unused = aVar.f5075b = i;
            int unused2 = this.f5065t.f5076c = i3;
            int unused3 = this.f5065t.f5077d = i2;
        }
        if (this.f5064s || (twoStateLayout = this.f5051f) == null) {
            return;
        }
        if (i > 0 || ((long) i2) < this.f5057l - 5) {
            this.f5051f.setEnabled(true);
            this.f5061p = true;
            return;
        }
        twoStateLayout.setEnabled(false);
        this.f5061p = false;
    }

    /* renamed from: c */
    public void mo5313c() {
        this.f5035I = SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public int mo5308a() {
        if (this.f5031E == 2) {
            return this.f5069x.mo6344e();
        }
        return 0;
    }

    /* renamed from: b */
    public void mo5312b(boolean z) {
        C0938a.m5002a("SR/EditActivity", "<isSupportRecord> isSupport: " + z);
        if (!z) {
            this.f5049d.setVisibility(4);
        }
    }

    /* renamed from: a */
    public void mo5310a(boolean z) {
        C0938a.m5002a("SR/EditActivity", "<switchAudioMode> isSpeakerMode: " + z);
        if (this.f5065t.f5074a == 3) {
            this.f5064s = true;
        }
        PlaybackService.C1442a aVar = this.f5067v;
        if (aVar != null) {
            aVar.mo6307c(z ^ true ? 1 : 0);
        }
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        int i = 1;
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            int length = (this.f5046a.getString(R.string.new_recording) + " ").length();
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
        C0938a.m5002a("SR/EditActivity", "Load new name: <onLoadFinished> offset: " + i);
        this.f5056k = this.f5046a.getString(R.string.new_recording) + " " + i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6152a(int i) {
        C0938a.m5002a("SR/EditActivity", "<setState>,state = " + i);
        this.f5031E = i;
        if (i == 0) {
            m6169d(false);
            this.f5050e.setEnabled(true);
            this.f5052g.mo5289a(true);
            C0938a.m5002a("SR/EditActivity", "<setState>,RECORDER_IDLE");
        } else if (i == 1) {
            C0938a.m5002a("SR/EditActivity", "<setState>,RECORDER_CREATED");
        } else if (i == 2) {
            m6178k();
            C0938a.m5002a("SR/EditActivity", "<setState>,RECORDER_STARTED");
            m6169d(true);
            this.f5050e.setEnabled(false);
            this.f5051f.setEnabled(false);
            this.f5052g.mo5289a(false);
            this.f5052g.mo5302j();
        } else if (i == 3) {
            C0938a.m5002a("SR/EditActivity", "<setState>,RECORDER_STOPPED");
            m6169d(false);
            this.f5050e.setEnabled(true);
            this.f5052g.mo5289a(true);
            this.f5052g.mo5298f();
            if (!this.f5062q) {
                this.f5053h = new ProgressDialog(this);
                this.f5053h.setProgressStyle(R.style.dialogExitStyle);
                this.f5053h.setMessage(getString(R.string.record_edit_merging));
                this.f5053h.setCancelable(false);
                if (!isDestroyed() && !isFinishing()) {
                    this.f5053h.show();
                }
                this.f5034H = new C1248e(this, (C1311b) null);
                this.f5034H.execute(new Integer[]{2});
            }
        } else if (i == 4) {
            C0938a.m5002a("SR/EditActivity", "<setState>,RECORDER_PAUSED");
            this.f5052g.mo5298f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6154a(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(0);
            int integer = trackFormat.containsKey("channel-count") ? trackFormat.getInteger("channel-count") : 1;
            C1413m.f5727y = integer;
            C0938a.m5002a("SR/EditActivity", "Encoding rate  ：" + trackFormat.getInteger("bitrate") + "Sampling rate：" + trackFormat.getInteger("sample-rate") + "Channels Num：" + integer + "File Path: " + str);
        } catch (Exception unused) {
        }
    }
}
