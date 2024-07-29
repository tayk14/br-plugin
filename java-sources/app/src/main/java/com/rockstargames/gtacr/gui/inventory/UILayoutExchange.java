package com.rockstargames.gtacr.gui.inventory;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.InventoryDialogValueApplyBinding;
import blackrussia.online.databinding.InventoryLayoutExchangeWithUserBinding;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.InventoryExchangeAndTrunkAdapter;
import com.rockstargames.gtacr.adapters.InventoryItemsInSlotAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.NewInvItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u008a\u0001\u001a\u00020\n2\u0006\u00104\u001a\u0002032\u0006\u0010C\u001a\u00020\u000eH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020\n2\t\u0010\u008c\u0001\u001a\u0004\u0018\u000103J\u0012\u0010\u008d\u0001\u001a\u00020\n2\u0007\u0010\u008e\u0001\u001a\u00020\u0006H\u0002J\u0010\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\u000eJ\u0018\u0010\u0091\u0001\u001a\u00020\n2\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u0002030;H\u0002J\u0007\u0010\u0093\u0001\u001a\u00020\nJ\t\u0010\u0094\u0001\u001a\u00020\nH\u0002J\t\u0010\u0095\u0001\u001a\u00020\nH\u0002J\t\u0010\u0096\u0001\u001a\u00020\nH\u0002J\t\u0010\u0097\u0001\u001a\u00020\nH\u0002J\t\u0010\u0098\u0001\u001a\u00020\nH\u0002J\t\u0010\u0099\u0001\u001a\u00020\nH\u0002J\t\u0010\u009a\u0001\u001a\u00020\nH\u0002J#\u0010\u009b\u0001\u001a\u00020\n2\u0007\u0010\u009c\u0001\u001a\u00020\u000e2\u0007\u0010\u009d\u0001\u001a\u00020\u000e2\b\u0010\u009e\u0001\u001a\u00030\u0083\u0001J\t\u0010\u009f\u0001\u001a\u00020\nH\u0002J\t\u0010 \u0001\u001a\u00020\nH\u0002J\t\u0010¡\u0001\u001a\u00020\nH\u0002J\t\u0010¢\u0001\u001a\u00020\nH\u0002J\t\u0010£\u0001\u001a\u00020\nH\u0002J\t\u0010¤\u0001\u001a\u00020\nH\u0002J\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u0002030;J\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u0002030;J\u0007\u0010§\u0001\u001a\u00020\u000eJ\t\u0010¨\u0001\u001a\u00020\nH\u0002J!\u0010©\u0001\u001a\u00020\u000e2\u0007\u0010ª\u0001\u001a\u0002032\r\u0010«\u0001\u001a\b\u0012\u0004\u0012\u0002030;H\u0002J\u0007\u0010¬\u0001\u001a\u00020\u000eJ\u0007\u0010\u00ad\u0001\u001a\u00020\u000eJ\u0007\u0010®\u0001\u001a\u00020\u000eJ\n\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\u0018\u0010±\u0001\u001a\u00020\n2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0003\u0010²\u0001J\u0007\u0010³\u0001\u001a\u00020\nJ\u0007\u0010´\u0001\u001a\u00020\nJ\t\u0010µ\u0001\u001a\u00020\nH\u0002J\u0007\u0010¶\u0001\u001a\u00020\nJ\t\u0010·\u0001\u001a\u00020\nH\u0002J\t\u0010¸\u0001\u001a\u00020\nH\u0002J \u0010¹\u0001\u001a\u00030°\u00012\b\u0010º\u0001\u001a\u00030»\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020\nH\u0016J\t\u0010¿\u0001\u001a\u00020\nH\u0016J\t\u0010À\u0001\u001a\u00020\nH\u0002J\u0007\u0010Á\u0001\u001a\u00020\nJ\t\u0010Â\u0001\u001a\u00020\nH\u0002J\u0011\u0010Ã\u0001\u001a\u00020\n2\u0006\u00104\u001a\u000203H\u0002J\u0012\u0010Ä\u0001\u001a\u00020\n2\u0007\u0010Å\u0001\u001a\u00020\u000eH\u0002J\t\u0010Æ\u0001\u001a\u00020\nH\u0002J\t\u0010Ç\u0001\u001a\u00020\nH\u0002J\t\u0010È\u0001\u001a\u00020\nH\u0002J\t\u0010É\u0001\u001a\u00020\nH\u0002J\u0017\u0010Ê\u0001\u001a\u00020\n2\u000e\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010;J\u0017\u0010Í\u0001\u001a\u00020\n2\u000e\u0010Ë\u0001\u001a\t\u0012\u0005\u0012\u00030Ì\u00010;J\t\u0010Î\u0001\u001a\u00020\nH\u0002J\t\u0010Ï\u0001\u001a\u00020\nH\u0002J\t\u0010Ð\u0001\u001a\u00020\nH\u0002J\t\u0010Ñ\u0001\u001a\u00020\nH\u0002J\t\u0010Ò\u0001\u001a\u00020\nH\u0002J\u0010\u0010Ó\u0001\u001a\u00020\n2\u0007\u0010Å\u0001\u001a\u00020\u000eJ\u0007\u0010Ô\u0001\u001a\u00020\nJ\u0007\u0010Õ\u0001\u001a\u00020\nJ\u0010\u0010Ö\u0001\u001a\u00020\n2\u0007\u0010×\u0001\u001a\u00020\u000eJ\u001d\u0010Ø\u0001\u001a\u00020\n2\u000e\u0010Ù\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0Ú\u0001¢\u0006\u0003\u0010Û\u0001J\u0013\u0010Ü\u0001\u001a\u00020\n2\n\u0010Ý\u0001\u001a\u0005\u0018\u00010\u0083\u0001J\u0018\u0010Þ\u0001\u001a\u00020\n2\r\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u0002030;H\u0002J\u0007\u0010ß\u0001\u001a\u00020\nJ\t\u0010à\u0001\u001a\u00020\nH\u0002J\u0019\u0010á\u0001\u001a\u00020\n2\u0007\u0010Å\u0001\u001a\u00020\u000e2\u0007\u0010â\u0001\u001a\u00020\u0006J\u0012\u0010ã\u0001\u001a\u00020\n2\u0007\u0010ä\u0001\u001a\u00020\u000eH\u0002J\t\u0010å\u0001\u001a\u00020\nH\u0002J\u0012\u0010æ\u0001\u001a\u00020\n2\u0007\u0010×\u0001\u001a\u00020\u000eH\u0002J\t\u0010ç\u0001\u001a\u00020\nH\u0002J\u0010\u0010è\u0001\u001a\u00020\n2\u0007\u0010é\u0001\u001a\u00020\u000eJ*\u0010ê\u0001\u001a\u00020\n2\u0007\u0010ª\u0001\u001a\u0002032\r\u0010ë\u0001\u001a\b\u0012\u0004\u0012\u0002030;2\u0007\u0010ì\u0001\u001a\u00020\u000eH\u0002J*\u0010í\u0001\u001a\u00020\n2\u0007\u0010ª\u0001\u001a\u0002032\r\u0010ë\u0001\u001a\b\u0012\u0004\u0012\u0002030;2\u0007\u0010ì\u0001\u001a\u00020\u000eH\u0002J$\u0010î\u0001\u001a\u00020\n2\u0007\u0010ï\u0001\u001a\u0002032\u0007\u0010ª\u0001\u001a\u0002032\u0007\u0010ð\u0001\u001a\u00020\u0006H\u0002J%\u0010ñ\u0001\u001a\u00020\n2\r\u0010ò\u0001\u001a\b\u0012\u0004\u0012\u0002030;2\r\u0010ó\u0001\u001a\b\u0012\u0004\u0012\u0002030;J\u0010\u0010ô\u0001\u001a\u00020\n2\u0007\u0010õ\u0001\u001a\u00020\u000eR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u0011\u0010$\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u001a\u0010&\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u0011\u0010,\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017R\u001a\u0010.\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013RY\u00101\u001aM\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\n02j\u0002`7X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u0002030;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010A\u001a6\u0012\u0013\u0012\u001103¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\n0Bj\u0002`DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0011\"\u0004\bH\u0010\u0013R\u0011\u0010I\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0017R\u001a\u0010K\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0011\"\u0004\bM\u0010\u0013R\u000e\u0010N\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0011\"\u0004\bS\u0010\u0013R\u0011\u0010T\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0017R\u001a\u0010V\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0011\"\u0004\bX\u0010\u0013R\u000e\u0010Y\u001a\u00020ZX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u0002030;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u0002030;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010]\u001a\b\u0012\u0004\u0012\u0002030;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\b\u0012\u0004\u0012\u0002030;X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0011\"\u0004\bb\u0010\u0013R\u000e\u0010c\u001a\u00020dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010i\u001a6\u0012\u0013\u0012\u001103¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\n0Bj\u0002`DX\u0082.¢\u0006\u0002\n\u0000RB\u0010j\u001a6\u0012\u0013\u0012\u001103¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\n0Bj\u0002`DX\u0082.¢\u0006\u0002\n\u0000RB\u0010k\u001a6\u0012\u0013\u0012\u001103¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\n0Bj\u0002`DX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0011\"\u0004\bn\u0010\u0013R\u0011\u0010o\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u0017R\u001a\u0010q\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0011\"\u0004\bs\u0010\u0013R\u000e\u0010t\u001a\u00020uX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010y\u001a\b\u0012\u0004\u0012\u0002030;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020uX\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020uX\u0082.¢\u0006\u0002\n\u0000¨\u0006ö\u0001"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/UILayoutExchange;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "listenerForChangeStatus", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "statusBlocker", "", "Lcom/rockstargames/gtacr/gui/inventory/ListenerForChangeStatus;", "(Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;Lkotlin/jvm/functions/Function1;)V", "activeSlotsInInventory", "", "allInvHeight", "getAllInvHeight", "()I", "setAllInvHeight", "(I)V", "allInvLocation", "", "getAllInvLocation", "()[I", "allInvWidth", "getAllInvWidth", "setAllInvWidth", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/InventoryLayoutExchangeWithUserBinding;", "bindingDialogApply", "Lblackrussia/online/databinding/InventoryDialogValueApplyBinding;", "buttonApplyHeight", "getButtonApplyHeight", "setButtonApplyHeight", "buttonApplyLocation", "getButtonApplyLocation", "buttonApplyWidth", "getButtonApplyWidth", "setButtonApplyWidth", "buttonChangeInvHeight", "getButtonChangeInvHeight", "setButtonChangeInvHeight", "buttonChangeInvLocation", "getButtonChangeInvLocation", "buttonChangeInvWidth", "getButtonChangeInvWidth", "setButtonChangeInvWidth", "clickDialogMenu", "Lkotlin/Function3;", "Lblackrussia/online/network/InvItems;", "item", "action", "applyAction", "Lcom/rockstargames/gtacr/gui/inventory/ActionListenerFromDialogApply;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "copyListWithYourItems", "", "counterForGetValueOfMoney", "dialogApplyMigrate", "Lcom/rockstargames/gtacr/gui/inventory/LogicForMigrateItemsInCar;", "dialogApplyPopupWindow", "Landroid/widget/PopupWindow;", "emptyClickListener", "Lkotlin/Function2;", "position", "Lcom/rockstargames/gtacr/gui/inventory/OnItemsClickListener;", "exchangeYourMoney", "firstOthersItemHeight", "getFirstOthersItemHeight", "setFirstOthersItemHeight", "firstOthersItemLocation", "getFirstOthersItemLocation", "firstOthersItemWidth", "getFirstOthersItemWidth", "setFirstOthersItemWidth", "intermediatePositionFromSlot", "intermediatePositionWithExchangeItem", "intermediatePositionWithItem", "inventoryHeight", "getInventoryHeight", "setInventoryHeight", "inventoryLocation", "getInventoryLocation", "inventoryWidth", "getInventoryWidth", "setInventoryWidth", "itemsInSlotAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryItemsInSlotAdapter;", "listItemsInSlots", "listOtherPlayersItems", "listYourExchangeItems", "listYourItems", "maxWeightInventory", "myId", "getMyId", "setMyId", "objectStatusBlocker", "Lcom/rockstargames/gtacr/gui/inventory/GlobalValue;", "oldTimeAfterCheck", "", "oldTimeWithMigrate", "oldValue", "onItemsInSlotClickListener", "onYourExchangeItemsClickListener", "onYourItemsClickListener", "otherPlayersInvHeight", "getOtherPlayersInvHeight", "setOtherPlayersInvHeight", "otherPlayersInvLocation", "getOtherPlayersInvLocation", "otherPlayersInvWidth", "getOtherPlayersInvWidth", "setOtherPlayersInvWidth", "otherPlayersItemsAndTrunkAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryExchangeAndTrunkAdapter;", "positionFromSlot", "positionWithExchangeItem", "positionWithItem", "savedListForInv", "sendCounter", "sizeSlots", "startThisWeight", "statusApply", "statusViewExchange", "testCopyListWithYourItems", "Lcom/rockstargames/gtacr/data/NewInvItem;", "testListWithPositionYourExchangeItems", "textIsFromOtherPlayer", "", "textIsFromYou", "textValueMoney", "thisWeightInventory", "yourAllMoney", "yourExchangeItemsAndTrunkAdapter", "yourItemsAndTrunkAdapter", "addNewItemInSafeList", "addNewItemsOtherPlayers", "newItems", "changeButtonAndHelpInfo", "isBothApply", "changeStatusInInterface", "status", "changeStatusWhoseItem", "myList", "clearAllMigrateItem", "clearCheckIfFromExchangeToUser", "clearCheckIfFromUserToExchange", "clearInfoAboutExchange", "clearInfoAboutInv", "clearInfoAboutSlot", "clearMyInterface", "closePopupWindowApply", "editValueItems", "idItems", "valueItems", "numberPlate", "getAllInvParameters", "getAllItemsAfterClear", "getButtonApplyParameters", "getButtonChangeInvParameters", "getFirstOthersItemParameters", "getInventoryParameters", "getItemsFromActiveSlots", "getItemsFromInventory", "getMaxWeight", "getOtherPlayersInvParameters", "getPositionInNewList", "migrateItem", "whichList", "getSizeSlots", "getStatusApply", "getThisWeight", "getView", "Landroid/view/View;", "listenerStatusAfterClickCancel", "(Ljava/lang/Integer;)V", "migrateFromExchangeToInv", "migrateFromSlotToInventory", "migrateItemFromExchange", "migrateItemFromInvToExchange", "migrateItemFromInventory", "migrateItemFromSlotToInventory", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setClearClickInLists", "setContext", "setDataInSlotsView", "setEmptyItem", "setEmptyListInInventory", "size", "setEmptyListOtherPlayers", "setEmptyListYour", "setEmptyListsForExchange", "setExchangeItemsInView", "setItems", FirebaseAnalytics.Param.ITEMS, "", "setItemsInSlot", "setLogicForClickInSlot", "setLogicForDialogApply", "setLogicForEmptyClickListener", "setLogicForYourExchangeItemsClickListener", "setLogicForYourItemsClickListener", "setMaxWeightInventory", "setOldValueOnMyExchangeList", "setOldValueOnMyList", "setOtherPlayersMoney", "money", "setPlayersInfo", "array", "", "([Ljava/lang/Integer;)V", "setPlayersNick", "nick", "setPositionFromMainList", "setStartParametersInLayout", "setStartViewSlots", "setThisWeightInventory", "isStartParameter", "setViewExchangeList", "thisView", "setYourItemsInView", "setYourMoney", "startPopupWindowApply", "updateCountWithNewMessages", "count", "updateDataAfterMigrate", "newList", "positionInNewList", "updateDataAfterMigrateToSlot", "updateItemAfterMigrate", "thisItem", "ifToSlot", "updateItems", "listItemsInActiveSlot", "listItemsInInventory", "updateSizeInventory", "newSize", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UILayoutExchange extends UILayout {
    private int activeSlotsInInventory;
    private int allInvHeight;
    private final int[] allInvLocation;
    private int allInvWidth;
    private Animation anim;
    private InventoryLayoutExchangeWithUserBinding binding;
    private InventoryDialogValueApplyBinding bindingDialogApply;
    private int buttonApplyHeight;
    private final int[] buttonApplyLocation;
    private int buttonApplyWidth;
    private int buttonChangeInvHeight;
    private final int[] buttonChangeInvLocation;
    private int buttonChangeInvWidth;
    private Function3<? super InvItems, ? super Integer, ? super Integer, Unit> clickDialogMenu;
    private NvEventQueueActivity context;
    private final List<InvItems> copyListWithYourItems;
    private int counterForGetValueOfMoney;
    private LogicForMigrateItemsInCar dialogApplyMigrate;
    private PopupWindow dialogApplyPopupWindow;
    private Function2<? super InvItems, ? super Integer, Unit> emptyClickListener;
    private int exchangeYourMoney;
    private int firstOthersItemHeight;
    private final int[] firstOthersItemLocation;
    private int firstOthersItemWidth;
    private int intermediatePositionFromSlot;
    private int intermediatePositionWithExchangeItem;
    private int intermediatePositionWithItem;
    private int inventoryHeight;
    private final int[] inventoryLocation;
    private int inventoryWidth;
    private InventoryItemsInSlotAdapter itemsInSlotAdapter;
    private List<InvItems> listItemsInSlots;
    private List<InvItems> listOtherPlayersItems;
    private List<InvItems> listYourExchangeItems;
    private List<InvItems> listYourItems;
    private final Function1<Boolean, Unit> listenerForChangeStatus;
    private final GUIUsersInventory mainRoot;
    private int maxWeightInventory;
    private int myId;
    private GlobalValue objectStatusBlocker;
    private long oldTimeAfterCheck;
    private long oldTimeWithMigrate;
    private int oldValue;
    private Function2<? super InvItems, ? super Integer, Unit> onItemsInSlotClickListener;
    private Function2<? super InvItems, ? super Integer, Unit> onYourExchangeItemsClickListener;
    private Function2<? super InvItems, ? super Integer, Unit> onYourItemsClickListener;
    private int otherPlayersInvHeight;
    private final int[] otherPlayersInvLocation;
    private int otherPlayersInvWidth;
    private InventoryExchangeAndTrunkAdapter otherPlayersItemsAndTrunkAdapter;
    private int positionFromSlot;
    private int positionWithExchangeItem;
    private int positionWithItem;
    private List<InvItems> savedListForInv;
    private int sendCounter;
    private final int sizeSlots;
    private int startThisWeight;
    private int statusApply;
    private boolean statusBlocker;
    private int statusViewExchange;
    private List<NewInvItem> testCopyListWithYourItems;
    private List<Integer> testListWithPositionYourExchangeItems;
    private String textIsFromOtherPlayer;
    private String textIsFromYou;
    private String textValueMoney;
    private int thisWeightInventory;
    private int yourAllMoney;
    private InventoryExchangeAndTrunkAdapter yourExchangeItemsAndTrunkAdapter;
    private InventoryExchangeAndTrunkAdapter yourItemsAndTrunkAdapter;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutExchange(GUIUsersInventory mainRoot, Function1<? super Boolean, Unit> listenerForChangeStatus) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(listenerForChangeStatus, "listenerForChangeStatus");
        this.mainRoot = mainRoot;
        this.listenerForChangeStatus = (Function1<Boolean, Unit>) listenerForChangeStatus;
        this.positionWithItem = -1;
        this.positionWithExchangeItem = -1;
        this.positionFromSlot = -1;
        this.intermediatePositionWithItem = -1;
        this.intermediatePositionWithExchangeItem = -1;
        this.intermediatePositionFromSlot = -1;
        this.listYourItems = new ArrayList();
        this.listOtherPlayersItems = new ArrayList();
        this.listYourExchangeItems = new ArrayList();
        this.testListWithPositionYourExchangeItems = new ArrayList();
        this.copyListWithYourItems = new ArrayList();
        this.testCopyListWithYourItems = new ArrayList();
        this.savedListForInv = new ArrayList();
        this.textIsFromOtherPlayer = "";
        this.textIsFromYou = "";
        this.textValueMoney = "";
        this.sizeSlots = 8;
        this.listItemsInSlots = new ArrayList();
        this.objectStatusBlocker = GlobalValue.INSTANCE;
        this.counterForGetValueOfMoney = -1;
        this.inventoryLocation = new int[]{0, 0};
        this.otherPlayersInvLocation = new int[]{0, 0};
        this.allInvLocation = new int[]{0, 0};
        this.buttonChangeInvLocation = new int[]{0, 0};
        this.firstOthersItemLocation = new int[]{0, 0};
        this.buttonApplyLocation = new int[]{0, 0};
    }

    public final int getStatusApply() {
        return this.statusApply;
    }

    public final void setContext() {
        this.context = this.mainRoot.getMainContext();
    }

    public final void setPlayersNick(String str) {
        if (str == null) {
            str = "";
        }
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = null;
        this.textIsFromOtherPlayer = nvEventQueueActivity == null ? null : nvEventQueueActivity.getString(R.string.inv_title_other_player_exchange, new Object[]{str});
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        this.textIsFromYou = nvEventQueueActivity2 == null ? null : nvEventQueueActivity2.getString(R.string.inv_title_your_exchange, new Object[]{str});
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding2 = null;
        }
        inventoryLayoutExchangeWithUserBinding2.exchangeTextPlayersNick.setText(this.textIsFromYou);
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding3 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding3 = null;
        }
        inventoryLayoutExchangeWithUserBinding3.exchangeBgPlayersName.setBackgroundResource(R.drawable.inv_bg_button_action);
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding4 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutExchangeWithUserBinding = inventoryLayoutExchangeWithUserBinding4;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeMoneyFromText.setText(str);
    }

    public final void setOtherPlayersMoney(int i) {
        this.counterForGetValueOfMoney++;
        String priceWithSpaces = GUIManager.getPriceWithSpaces(i);
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = null;
        String string = nvEventQueueActivity == null ? null : nvEventQueueActivity.getString(R.string.inv_your_value_money, new Object[]{priceWithSpaces.toString()});
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutExchangeWithUserBinding = inventoryLayoutExchangeWithUserBinding2;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeValueMoneyFrom.setText(string);
        int i2 = this.counterForGetValueOfMoney;
        if (i2 == 1) {
            this.mainRoot.setNewMessage(false, 2, "", 3, "", i);
            GUIUsersInventory gUIUsersInventory = this.mainRoot;
            gUIUsersInventory.updateCountWithNewMessages(gUIUsersInventory.getCounter());
        } else if (i2 > 1) {
            this.mainRoot.setNewMessage(false, 2, "", 4, "", i);
            GUIUsersInventory gUIUsersInventory2 = this.mainRoot;
            gUIUsersInventory2.updateCountWithNewMessages(gUIUsersInventory2.getCounter());
        }
    }

    public final void setStartParametersInLayout() {
        changeButtonAndHelpInfo(false);
    }

    public final void setPlayersInfo(Integer[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (i == 0) {
                setThisWeightInventory(array[0].intValue(), true);
            } else if (i == 1) {
                setMaxWeightInventory(array[1].intValue());
            } else if (i == 2) {
                this.activeSlotsInInventory = array[2].intValue();
            } else if (i == 3) {
                setYourMoney(array[3].intValue());
            } else if (i == 4) {
                if (array[4].intValue() == 0) {
                    setEmptyItem(this.listItemsInSlots.get(0));
                } else {
                    InvItems objectSimCard = this.mainRoot.getObjectSimCard();
                    objectSimCard.setTextIfException(String.valueOf(array[4].intValue()));
                    this.listItemsInSlots.remove(0);
                    this.listItemsInSlots.add(0, objectSimCard);
                }
            }
            i = i2;
        }
        setEmptyListInInventory(this.activeSlotsInInventory);
        setEmptyListsForExchange();
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UILayoutExchange.m345setPlayersInfo$lambda1(UILayoutExchange.this);
            }
        }, 200L);
    }

    public static final void m345setPlayersInfo$lambda1(UILayoutExchange this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getInventoryParameters();
        this$0.getOtherPlayersInvParameters();
        this$0.getAllInvParameters();
        this$0.getButtonChangeInvParameters();
        this$0.getFirstOthersItemParameters();
        this$0.getButtonApplyParameters();
    }

    public final void setThisWeightInventory(int i, boolean z) {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeTitleActualWeightUsers.setText(String.valueOf(i));
        if (z) {
            this.startThisWeight = i;
        }
    }

    public final void setMaxWeightInventory(int i) {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeTitleMaxWeightUsers.setText(String.valueOf(i));
    }

    private final void setYourMoney(int i) {
        this.yourAllMoney = i;
        String priceWithSpaces = GUIManager.getPriceWithSpaces(i);
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = null;
        String string = nvEventQueueActivity == null ? null : nvEventQueueActivity.getString(R.string.inv_your_value_money, new Object[]{priceWithSpaces.toString()});
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutExchangeWithUserBinding = inventoryLayoutExchangeWithUserBinding2;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeValueMyMoney.setText(string);
    }

    public final void setItems(List<Object> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mainRoot.migrateDataFromAnyToObject(items, this.listYourItems, false);
        changeStatusWhoseItem(this.listYourItems);
        List<InvItems> list = this.copyListWithYourItems;
        list.clear();
        list.addAll(this.listYourItems);
        this.testCopyListWithYourItems.clear();
        setPositionFromMainList(this.listYourItems);
        this.savedListForInv.clear();
        this.savedListForInv.addAll(this.listYourItems);
    }

    private final void changeStatusWhoseItem(List<InvItems> list) {
        for (InvItems invItems : list) {
            if (invItems.getItemsValue() != 0) {
                invItems.setWhoseItem(1);
            }
        }
    }

    private final void setPositionFromMainList(List<InvItems> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (list.get(i2).getId() != 0) {
                i = size;
                this.testCopyListWithYourItems.add(new NewInvItem(list.get(i2).getId(), list.get(i2).getName(), list.get(i2).getDesc(), list.get(i2).getModelid(), list.get(i2).getWeight(), list.get(i2).getAddw(), list.get(i2).getFold(), list.get(i2).getShiftX(), list.get(i2).getShiftY(), list.get(i2).getShiftZ(), list.get(i2).getX(), list.get(i2).getY(), list.get(i2).getZ(), list.get(i2).getZoom(), list.get(i2).getItemsValue(), list.get(i2).getTextIfException(), list.get(i2).getWhoseItem(), list.get(i2).getThisBitmap(), list.get(i2).getCheck(), i2));
            } else {
                i = size;
            }
            i2 = i3;
            size = i;
        }
    }

    private final void addNewItemInSafeList(InvItems invItems, int i) {
        this.testCopyListWithYourItems.add(new NewInvItem(invItems.getId(), invItems.getName(), invItems.getDesc(), invItems.getModelid(), invItems.getWeight(), invItems.getAddw(), invItems.getFold(), invItems.getShiftX(), invItems.getShiftY(), invItems.getShiftZ(), invItems.getX(), invItems.getY(), invItems.getZ(), invItems.getZoom(), invItems.getItemsValue(), invItems.getTextIfException(), invItems.getWhoseItem(), invItems.getThisBitmap(), invItems.getCheck(), i));
    }

    public final void setItemsInSlot(List<Object> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mainRoot.migrateDataFromAnyToObject(items, this.listItemsInSlots, true);
    }

    public final void updateSizeInventory(int i) {
        int i2 = this.activeSlotsInInventory;
        if (i > i2) {
            if (i2 <= i) {
                while (true) {
                    int i3 = i2 + 1;
                    this.listYourItems.add(Constants.INSTANCE.emptyItem());
                    if (i2 == i) {
                        break;
                    }
                    i2 = i3;
                }
            }
        } else if (i < i2 && i <= i2) {
            while (true) {
                int i4 = i2 - 1;
                this.listYourItems.remove(i2);
                if (i2 == i) {
                    break;
                }
                i2 = i4;
            }
        }
        if (i != this.activeSlotsInInventory) {
            this.activeSlotsInInventory = i;
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourItemsAndTrunkAdapter;
            if (inventoryExchangeAndTrunkAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
                inventoryExchangeAndTrunkAdapter = null;
            }
            inventoryExchangeAndTrunkAdapter.notifyDataSetChanged();
        }
    }

    public final void addNewItemsOtherPlayers(InvItems invItems) {
        int i = 0;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (invItems != null && invItems.getFold() == 0) {
            int size = this.listOtherPlayersItems.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                if (this.listOtherPlayersItems.get(i2).getId() == invItems.getId()) {
                    InvItems invItems2 = this.listOtherPlayersItems.get(i2);
                    invItems2.setItemsValue(invItems2.getItemsValue() + invItems.getItemsValue());
                    InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.otherPlayersItemsAndTrunkAdapter;
                    if (inventoryExchangeAndTrunkAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                    } else {
                        inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
                    }
                    inventoryExchangeAndTrunkAdapter.notifyItemChanged(i2);
                    this.mainRoot.setNewMessage(false, 2, "", 1, this.listOtherPlayersItems.get(i2).getName(), 0);
                    GUIUsersInventory gUIUsersInventory = this.mainRoot;
                    gUIUsersInventory.updateCountWithNewMessages(gUIUsersInventory.getCounter());
                    return;
                }
                i2 = i3;
            }
        }
        int size2 = this.listOtherPlayersItems.size();
        while (i < size2) {
            int i4 = i + 1;
            if (this.listOtherPlayersItems.get(i).getItemsValue() == 0) {
                if (invItems != null) {
                    this.listOtherPlayersItems.get(i).setId(invItems.getId());
                    this.listOtherPlayersItems.get(i).setName(invItems.getName());
                    this.listOtherPlayersItems.get(i).setDesc(invItems.getDesc());
                    this.listOtherPlayersItems.get(i).setModelid(invItems.getModelid());
                    this.listOtherPlayersItems.get(i).setWeight(invItems.getWeight());
                    this.listOtherPlayersItems.get(i).setAddw(invItems.getAddw());
                    this.listOtherPlayersItems.get(i).setFold(invItems.getFold());
                    this.listOtherPlayersItems.get(i).setShiftX(invItems.getShiftX());
                    this.listOtherPlayersItems.get(i).setShiftY(invItems.getShiftY());
                    this.listOtherPlayersItems.get(i).setShiftZ(invItems.getShiftZ());
                    this.listOtherPlayersItems.get(i).setX(invItems.getX());
                    this.listOtherPlayersItems.get(i).setY(invItems.getY());
                    this.listOtherPlayersItems.get(i).setZ(invItems.getZ());
                    this.listOtherPlayersItems.get(i).setZoom(invItems.getZoom());
                    this.listOtherPlayersItems.get(i).setItemsValue(invItems.getItemsValue());
                    this.listOtherPlayersItems.get(i).setTextIfException(invItems.getTextIfException());
                    this.listOtherPlayersItems.get(i).setWhoseItem(invItems.getWhoseItem());
                    this.listOtherPlayersItems.get(i).setThisBitmap(invItems.getThisBitmap());
                    this.listOtherPlayersItems.get(i).setCheck(invItems.getCheck());
                }
                this.mainRoot.setNewMessage(false, 2, "", 1, this.listOtherPlayersItems.get(i).getName(), 0);
                GUIUsersInventory gUIUsersInventory2 = this.mainRoot;
                gUIUsersInventory2.updateCountWithNewMessages(gUIUsersInventory2.getCounter());
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.otherPlayersItemsAndTrunkAdapter;
                if (inventoryExchangeAndTrunkAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                } else {
                    inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter3;
                }
                inventoryExchangeAndTrunkAdapter.notifyItemChanged(i);
                return;
            }
            i = i4;
        }
    }

    public final void editValueItems(int i, int i2, String numberPlate) {
        Intrinsics.checkNotNullParameter(numberPlate, "numberPlate");
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        int i3 = 0;
        if (i == 58) {
            int size = this.listOtherPlayersItems.size();
            int i4 = 0;
            while (i4 < size) {
                int i5 = i4 + 1;
                if (i == this.listOtherPlayersItems.get(i4).getId() && i2 == Integer.parseInt(this.listOtherPlayersItems.get(i4).getTextIfException())) {
                    this.listOtherPlayersItems.get(i4).setItemsValue(0);
                    this.mainRoot.setNewMessage(false, 2, "", 2, this.listOtherPlayersItems.get(i4).getName(), 0);
                    GUIUsersInventory gUIUsersInventory = this.mainRoot;
                    gUIUsersInventory.updateCountWithNewMessages(gUIUsersInventory.getCounter());
                    setEmptyItem(this.listOtherPlayersItems.get(i4));
                    InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.otherPlayersItemsAndTrunkAdapter;
                    if (inventoryExchangeAndTrunkAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                    } else {
                        inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
                    }
                    inventoryExchangeAndTrunkAdapter.notifyItemChanged(i4);
                    return;
                }
                i4 = i5;
            }
            return;
        }
        if (i != 59) {
            if (i == 134) {
                int size2 = this.listOtherPlayersItems.size();
                int i6 = 0;
                while (i6 < size2) {
                    int i7 = i6 + 1;
                    if (i == this.listOtherPlayersItems.get(i6).getId() && i2 == this.listOtherPlayersItems.get(i6).getModelid()) {
                        this.listOtherPlayersItems.get(i6).setItemsValue(0);
                        this.mainRoot.setNewMessage(false, 2, "", 2, this.listOtherPlayersItems.get(i6).getName(), 0);
                        GUIUsersInventory gUIUsersInventory2 = this.mainRoot;
                        gUIUsersInventory2.updateCountWithNewMessages(gUIUsersInventory2.getCounter());
                        setEmptyItem(this.listOtherPlayersItems.get(i6));
                        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.otherPlayersItemsAndTrunkAdapter;
                        if (inventoryExchangeAndTrunkAdapter3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                        } else {
                            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter3;
                        }
                        inventoryExchangeAndTrunkAdapter.notifyItemChanged(i6);
                        return;
                    }
                    i6 = i7;
                }
                return;
            }
            switch (i) {
                case 81:
                case 82:
                case 83:
                    break;
                default:
                    int size3 = this.listOtherPlayersItems.size();
                    while (i3 < size3) {
                        int i8 = i3 + 1;
                        if (i == this.listOtherPlayersItems.get(i3).getId()) {
                            InvItems invItems = this.listOtherPlayersItems.get(i3);
                            invItems.setItemsValue(invItems.getItemsValue() - i2);
                            if (this.listOtherPlayersItems.get(i3).getItemsValue() == 0) {
                                this.mainRoot.setNewMessage(false, 2, "", 2, this.listOtherPlayersItems.get(i3).getName(), 0);
                                GUIUsersInventory gUIUsersInventory3 = this.mainRoot;
                                gUIUsersInventory3.updateCountWithNewMessages(gUIUsersInventory3.getCounter());
                                setEmptyItem(this.listOtherPlayersItems.get(i3));
                            }
                            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter4 = this.otherPlayersItemsAndTrunkAdapter;
                            if (inventoryExchangeAndTrunkAdapter4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                            } else {
                                inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter4;
                            }
                            inventoryExchangeAndTrunkAdapter.notifyItemChanged(i3);
                            return;
                        }
                        i3 = i8;
                    }
                    return;
            }
        }
        int size4 = this.listOtherPlayersItems.size();
        int i9 = 0;
        while (i9 < size4) {
            int i10 = i9 + 1;
            if (i == this.listOtherPlayersItems.get(i9).getId() && Intrinsics.areEqual(numberPlate, this.listOtherPlayersItems.get(i9).getTextIfException())) {
                this.listOtherPlayersItems.get(i9).setItemsValue(0);
                this.mainRoot.setNewMessage(false, 2, "", 2, this.listOtherPlayersItems.get(i9).getName(), 0);
                GUIUsersInventory gUIUsersInventory4 = this.mainRoot;
                gUIUsersInventory4.updateCountWithNewMessages(gUIUsersInventory4.getCounter());
                setEmptyItem(this.listOtherPlayersItems.get(i9));
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter5 = this.otherPlayersItemsAndTrunkAdapter;
                if (inventoryExchangeAndTrunkAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                } else {
                    inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter5;
                }
                inventoryExchangeAndTrunkAdapter.notifyItemChanged(i9);
                return;
            }
            i9 = i10;
        }
    }

    public final void updateItems(List<InvItems> listItemsInActiveSlot, List<InvItems> listItemsInInventory) {
        Intrinsics.checkNotNullParameter(listItemsInActiveSlot, "listItemsInActiveSlot");
        Intrinsics.checkNotNullParameter(listItemsInInventory, "listItemsInInventory");
        this.listItemsInSlots.clear();
        this.listItemsInSlots.addAll(listItemsInActiveSlot);
        this.listYourItems.clear();
        List<InvItems> list = listItemsInInventory;
        this.listYourItems.addAll(list);
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (inventoryItemsInSlotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            inventoryItemsInSlotAdapter = null;
        }
        inventoryItemsInSlotAdapter.notifyDataSetChanged();
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.yourItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
        }
        inventoryExchangeAndTrunkAdapter.notifyDataSetChanged();
        this.copyListWithYourItems.clear();
        this.copyListWithYourItems.addAll(list);
        this.savedListForInv.clear();
        this.savedListForInv.addAll(list);
    }

    private final void setEmptyItem(InvItems invItems) {
        invItems.setId(0);
        invItems.setName("");
        invItems.setDesc("");
        invItems.setModelid(0);
        invItems.setWeight(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        invItems.setAddw(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        invItems.setFold(0);
        invItems.setShiftX(0.0f);
        invItems.setShiftY(0.0f);
        invItems.setShiftZ(0.0f);
        invItems.setX(0.0f);
        invItems.setY(0.0f);
        invItems.setZ(0.0f);
        invItems.setZoom(0.0f);
        invItems.setTextIfException("");
        invItems.setWhoseItem(0);
        invItems.setThisBitmap(null);
    }

    private final void updateItemAfterMigrate(InvItems invItems, InvItems invItems2, boolean z) {
        invItems.setId(invItems2.getId());
        invItems.setName(invItems2.getName());
        invItems.setDesc(invItems2.getDesc());
        invItems.setModelid(invItems2.getModelid());
        invItems.setWeight(invItems2.getWeight());
        invItems.setAddw(invItems2.getAddw());
        invItems.setFold(invItems2.getFold());
        invItems.setShiftX(invItems2.getShiftX());
        invItems.setShiftY(invItems2.getShiftY());
        invItems.setShiftZ(invItems2.getShiftZ());
        invItems.setX(invItems2.getX());
        invItems.setY(invItems2.getY());
        invItems.setZ(invItems2.getZ());
        invItems.setZoom(invItems2.getZoom());
        invItems.setItemsValue(!z ? invItems2.getItemsValue() : 1);
        invItems.setTextIfException(invItems2.getTextIfException());
        invItems.setWhoseItem(1);
        invItems.setThisBitmap(invItems2.getThisBitmap());
    }

    @Override
    public View getView() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        ConstraintLayout root = inventoryLayoutExchangeWithUserBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        InventoryLayoutExchangeWithUserBinding inflate = InventoryLayoutExchangeWithUserBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        setContext();
        setLogicForDialogApply();
        setLogicForYourItemsClickListener();
        setLogicForYourExchangeItemsClickListener();
        setLogicForEmptyClickListener();
        setYourItemsInView();
        setExchangeItemsInView();
        setStartViewSlots();
        setLogicForClickInSlot();
        setDataInSlotsView();
        setOtherPlayersMoney(0);
        setYourMoney(0);
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = null;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeBgValuesForBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutExchange.m342onCreateView$lambda6(UILayoutExchange.this, view);
            }
        });
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding3 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding3 = null;
        }
        inventoryLayoutExchangeWithUserBinding3.exchangeButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutExchange.m343onCreateView$lambda7(UILayoutExchange.this, view);
            }
        });
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding4 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding4 = null;
        }
        inventoryLayoutExchangeWithUserBinding4.exchangeButtonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutExchange.m344onCreateView$lambda8(UILayoutExchange.this, view);
            }
        });
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding5 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding5 = null;
        }
        inventoryLayoutExchangeWithUserBinding5.exchangeEdittextMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4;
                InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding6;
                int i5;
                InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding7;
                String valueOf = String.valueOf(charSequence);
                UILayoutExchange uILayoutExchange = UILayoutExchange.this;
                int i6 = 0;
                if ((valueOf.length() > 0) && valueOf.charAt(0) != '0') {
                    i6 = Integer.parseInt(valueOf);
                }
                uILayoutExchange.exchangeYourMoney = i6;
                i4 = UILayoutExchange.this.exchangeYourMoney;
                InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding8 = null;
                if (i4 == 0) {
                    inventoryLayoutExchangeWithUserBinding7 = UILayoutExchange.this.binding;
                    if (inventoryLayoutExchangeWithUserBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        inventoryLayoutExchangeWithUserBinding8 = inventoryLayoutExchangeWithUserBinding7;
                    }
                    inventoryLayoutExchangeWithUserBinding8.exchangeTextMoney.setText("");
                    return;
                }
                inventoryLayoutExchangeWithUserBinding6 = UILayoutExchange.this.binding;
                if (inventoryLayoutExchangeWithUserBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    inventoryLayoutExchangeWithUserBinding8 = inventoryLayoutExchangeWithUserBinding6;
                }
                TextView textView = inventoryLayoutExchangeWithUserBinding8.exchangeTextMoney;
                i5 = UILayoutExchange.this.exchangeYourMoney;
                textView.setText(GUIManager.getPriceWithSpaces(i5));
            }
        });
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding6 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding6 = null;
        }
        CustomEditText customEditText = inventoryLayoutExchangeWithUserBinding6.exchangeEdittextMoney;
        customEditText.setGUIManager(this.mainRoot.getGUIManager());
        customEditText.setMainRoot(this.mainRoot);
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding7 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding7 = null;
        }
        inventoryLayoutExchangeWithUserBinding7.exchangeBgButtonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UILayoutExchange.m341onCreateView$lambda10(UILayoutExchange.this, view);
            }
        });
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding8 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutExchangeWithUserBinding2 = inventoryLayoutExchangeWithUserBinding8;
        }
        ConstraintLayout root = inventoryLayoutExchangeWithUserBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m342onCreateView$lambda6(UILayoutExchange this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.statusViewExchange == 0 ? 1 : 0;
        this$0.statusViewExchange = i;
        this$0.setViewExchangeList(i);
    }

    public static final void m343onCreateView$lambda7(UILayoutExchange this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.sendPressButton(7);
    }

    public static final void m344onCreateView$lambda8(UILayoutExchange this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = this$0.exchangeYourMoney;
        if (i > 20000000) {
            this$0.mainRoot.sendMessageError("Нельзя передать за раз больше 20.000.000 ₽");
        } else if (this$0.yourAllMoney < i) {
            this$0.mainRoot.sendMessageError("У Вас недостаточно денег для передачи");
        } else {
            int i2 = this$0.statusApply;
            if (i2 == 0) {
                this$0.mainRoot.sendPressButton(8);
                this$0.objectStatusBlocker.setGlobalStatusBlocker(true);
            } else if (i2 == 2) {
                this$0.mainRoot.sendPressButton(9);
                this$0.objectStatusBlocker.setGlobalStatusBlocker(true);
            }
            this$0.listenerForChangeStatus.invoke(Boolean.valueOf(this$0.objectStatusBlocker.getGlobalStatusBlocker()));
            if (this$0.mainRoot.isTutor()) {
                this$0.mainRoot.getGuideClass().visibleHelp(false);
            }
        }
    }

    public static final void m341onCreateView$lambda10(UILayoutExchange this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.openChat();
        this$0.mainRoot.setCounter(0);
        this$0.updateCountWithNewMessages(this$0.mainRoot.getCounter());
    }

    private final void setEmptyListInInventory(int i) {
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                this.listYourItems.add(Constants.INSTANCE.emptyItem());
                if (i2 == i) {
                    break;
                }
                i2 = i3;
            }
        }
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeListItemsInInventory.setItemViewCacheSize(i);
    }

    private final void setEmptyListsForExchange() {
        setEmptyListOtherPlayers();
        setEmptyListYour();
    }

    private final void setEmptyListOtherPlayers() {
        this.listOtherPlayersItems.clear();
        int i = this.activeSlotsInInventory;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                this.listOtherPlayersItems.add(Constants.INSTANCE.emptyItem());
                if (i2 == i) {
                    break;
                }
                i2 = i3;
            }
        }
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeListItemsInCar.setItemViewCacheSize(this.activeSlotsInInventory);
    }

    private final void setEmptyListYour() {
        this.listYourExchangeItems.clear();
        int i = this.activeSlotsInInventory;
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                this.listYourExchangeItems.add(Constants.INSTANCE.emptyItem());
                if (i3 == i) {
                    break;
                }
                i3 = i4;
            }
        }
        this.testListWithPositionYourExchangeItems.clear();
        int i5 = this.activeSlotsInInventory;
        if (i5 < 0) {
            return;
        }
        while (true) {
            int i6 = i2 + 1;
            this.testListWithPositionYourExchangeItems.add(-1);
            if (i2 == i5) {
                return;
            }
            i2 = i6;
        }
    }

    private final void setLogicForYourItemsClickListener() {
        this.onYourItemsClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                GlobalValue globalValue;
                long j;
                long j2;
                int i2;
                int i3;
                List list;
                int i4;
                List list2;
                int i5;
                int i6;
                List list3;
                int i7;
                int i8;
                int i9;
                GUIUsersInventory gUIUsersInventory;
                List list4;
                int i10;
                int i11;
                GUIUsersInventory gUIUsersInventory2;
                List list5;
                int i12;
                List list6;
                int i13;
                List list7;
                int i14;
                List list8;
                int i15;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding2;
                Function3 function3;
                Function3 function32;
                NvEventQueueActivity nvEventQueueActivity;
                LogicForMigrateItemsInCar logicForMigrateItemsInCar;
                long j3;
                int i16;
                int i17;
                GUIUsersInventory gUIUsersInventory3;
                long j4;
                List list9;
                int i18;
                List list10;
                int i19;
                int parseInt;
                int i20;
                GUIUsersInventory gUIUsersInventory4;
                List list11;
                int i21;
                List list12;
                int i22;
                List list13;
                int i23;
                List list14;
                int i24;
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter;
                int unused;
                Intrinsics.checkNotNullParameter(item, "item");
                globalValue = UILayoutExchange.this.objectStatusBlocker;
                if (globalValue.getGlobalStatusBlocker()) {
                    return;
                }
                j = UILayoutExchange.this.oldTimeAfterCheck;
                if (j != System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = UILayoutExchange.this.oldTimeAfterCheck;
                    if (currentTimeMillis - j2 > 500) {
                        UILayoutExchange.this.oldTimeAfterCheck = System.currentTimeMillis();
                        UILayoutExchange.this.positionWithItem = i;
                        LogicForMigrateItemsInCar logicForMigrateItemsInCar2 = null;
                        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
                        if (item.getItemsValue() == 0) {
                            i2 = UILayoutExchange.this.positionWithExchangeItem;
                            if (i2 != -1) {
                                list6 = UILayoutExchange.this.listYourExchangeItems;
                                i13 = UILayoutExchange.this.positionWithExchangeItem;
                                if (((InvItems) list6.get(i13)).getItemsValue() != 0) {
                                    list7 = UILayoutExchange.this.listYourExchangeItems;
                                    i14 = UILayoutExchange.this.positionWithExchangeItem;
                                    if (((InvItems) list7.get(i14)).getItemsValue() == 1) {
                                        j3 = UILayoutExchange.this.oldTimeWithMigrate;
                                        if (j3 != System.currentTimeMillis()) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            j4 = UILayoutExchange.this.oldTimeWithMigrate;
                                            if (currentTimeMillis2 - j4 > 1200) {
                                                UILayoutExchange.this.oldTimeWithMigrate = System.currentTimeMillis();
                                                list9 = UILayoutExchange.this.listYourExchangeItems;
                                                i18 = UILayoutExchange.this.positionWithExchangeItem;
                                                int id = ((InvItems) list9.get(i18)).getId();
                                                if (id == 58) {
                                                    list10 = UILayoutExchange.this.listYourExchangeItems;
                                                    i19 = UILayoutExchange.this.positionWithExchangeItem;
                                                    parseInt = Integer.parseInt(((InvItems) list10.get(i19)).getTextIfException());
                                                } else if (id != 134) {
                                                    list14 = UILayoutExchange.this.listYourExchangeItems;
                                                    i24 = UILayoutExchange.this.positionWithExchangeItem;
                                                    parseInt = ((InvItems) list14.get(i24)).getItemsValue();
                                                } else {
                                                    list13 = UILayoutExchange.this.listYourExchangeItems;
                                                    i23 = UILayoutExchange.this.positionWithExchangeItem;
                                                    parseInt = ((InvItems) list13.get(i23)).getModelid();
                                                }
                                                UILayoutExchange uILayoutExchange = UILayoutExchange.this;
                                                i20 = uILayoutExchange.positionWithExchangeItem;
                                                uILayoutExchange.intermediatePositionWithExchangeItem = i20;
                                                gUIUsersInventory4 = UILayoutExchange.this.mainRoot;
                                                list11 = UILayoutExchange.this.listYourExchangeItems;
                                                i21 = UILayoutExchange.this.positionWithExchangeItem;
                                                int id2 = ((InvItems) list11.get(i21)).getId();
                                                list12 = UILayoutExchange.this.testListWithPositionYourExchangeItems;
                                                i22 = UILayoutExchange.this.positionWithExchangeItem;
                                                gUIUsersInventory4.sendIdWithCountToServer(24, id2, parseInt, ((Number) list12.get(i22)).intValue());
                                                UILayoutExchange.this.sendCounter = 0;
                                                return;
                                            }
                                        }
                                        i16 = UILayoutExchange.this.sendCounter;
                                        if (i16 == 0) {
                                            gUIUsersInventory3 = UILayoutExchange.this.mainRoot;
                                            gUIUsersInventory3.sendMessageError("Перекладывать предмет можно раз в 1 сек");
                                        }
                                        UILayoutExchange uILayoutExchange2 = UILayoutExchange.this;
                                        i17 = uILayoutExchange2.sendCounter;
                                        uILayoutExchange2.sendCounter = i17 + 1;
                                        unused = uILayoutExchange2.sendCounter;
                                        UILayoutExchange.this.clearInfoAboutSlot();
                                        UILayoutExchange.this.clearInfoAboutExchange();
                                        UILayoutExchange.this.clearInfoAboutInv();
                                        return;
                                    }
                                    UILayoutExchange.this.startPopupWindowApply();
                                    UILayoutExchange uILayoutExchange3 = UILayoutExchange.this;
                                    list8 = uILayoutExchange3.listYourExchangeItems;
                                    i15 = UILayoutExchange.this.positionWithExchangeItem;
                                    InvItems invItems = (InvItems) list8.get(i15);
                                    inventoryDialogValueApplyBinding = UILayoutExchange.this.bindingDialogApply;
                                    if (inventoryDialogValueApplyBinding == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bindingDialogApply");
                                        inventoryDialogValueApplyBinding2 = null;
                                    } else {
                                        inventoryDialogValueApplyBinding2 = inventoryDialogValueApplyBinding;
                                    }
                                    function3 = UILayoutExchange.this.clickDialogMenu;
                                    if (function3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("clickDialogMenu");
                                        function32 = null;
                                    } else {
                                        function32 = function3;
                                    }
                                    nvEventQueueActivity = UILayoutExchange.this.context;
                                    uILayoutExchange3.dialogApplyMigrate = new LogicForMigrateItemsInCar(invItems, inventoryDialogValueApplyBinding2, 5, function32, nvEventQueueActivity);
                                    logicForMigrateItemsInCar = UILayoutExchange.this.dialogApplyMigrate;
                                    if (logicForMigrateItemsInCar == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("dialogApplyMigrate");
                                    } else {
                                        logicForMigrateItemsInCar2 = logicForMigrateItemsInCar;
                                    }
                                    logicForMigrateItemsInCar2.openDialogApply();
                                    return;
                                }
                            }
                            i3 = UILayoutExchange.this.positionFromSlot;
                            if (i3 != -1) {
                                list = UILayoutExchange.this.listItemsInSlots;
                                i4 = UILayoutExchange.this.positionFromSlot;
                                if (((InvItems) list.get(i4)).getItemsValue() != 0) {
                                    list2 = UILayoutExchange.this.copyListWithYourItems;
                                    i5 = UILayoutExchange.this.positionWithItem;
                                    if (((InvItems) list2.get(i5)).getItemsValue() == 0) {
                                        i6 = UILayoutExchange.this.positionFromSlot;
                                        if (i6 != 0) {
                                            list3 = UILayoutExchange.this.listItemsInSlots;
                                            i7 = UILayoutExchange.this.positionFromSlot;
                                            if (((InvItems) list3.get(i7)).getId() == 134) {
                                                UILayoutExchange uILayoutExchange4 = UILayoutExchange.this;
                                                i11 = uILayoutExchange4.positionFromSlot;
                                                uILayoutExchange4.intermediatePositionFromSlot = i11;
                                                UILayoutExchange.this.intermediatePositionWithItem = i;
                                                gUIUsersInventory2 = UILayoutExchange.this.mainRoot;
                                                list5 = UILayoutExchange.this.listItemsInSlots;
                                                i12 = UILayoutExchange.this.positionFromSlot;
                                                gUIUsersInventory2.sendIdWithOldAndNewPositionsToServer(27, ((InvItems) list5.get(i12)).getId(), 6, i);
                                                return;
                                            }
                                            UILayoutExchange uILayoutExchange5 = UILayoutExchange.this;
                                            i8 = uILayoutExchange5.positionFromSlot;
                                            uILayoutExchange5.intermediatePositionFromSlot = i8;
                                            UILayoutExchange.this.intermediatePositionWithItem = i;
                                            i9 = UILayoutExchange.this.positionFromSlot;
                                            gUIUsersInventory = UILayoutExchange.this.mainRoot;
                                            list4 = UILayoutExchange.this.listItemsInSlots;
                                            i10 = UILayoutExchange.this.positionFromSlot;
                                            gUIUsersInventory.sendIdWithOldAndNewPositionsToServer(27, ((InvItems) list4.get(i10)).getId(), i9 - 2, i);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            UILayoutExchange.this.clearCheckIfFromExchangeToUser();
                            return;
                        }
                        UILayoutExchange.this.oldValue = item.getItemsValue();
                        UILayoutExchange.this.clearInfoAboutSlot();
                        UILayoutExchange.this.clearInfoAboutExchange();
                        item.setCheck(true);
                        inventoryExchangeAndTrunkAdapter = UILayoutExchange.this.yourItemsAndTrunkAdapter;
                        if (inventoryExchangeAndTrunkAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
                        } else {
                            inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter;
                        }
                        inventoryExchangeAndTrunkAdapter2.notifyItemChanged(i);
                        inventoryExchangeAndTrunkAdapter2.setCheckOnlyElement(i);
                    }
                }
            }
        };
    }

    public final void migrateFromExchangeToInv() {
        migrateItemFromExchange();
        clearAllMigrateItem();
    }

    private final void migrateItemFromExchange() {
        int intValue;
        int i = this.intermediatePositionWithExchangeItem;
        if (i == -1 || (intValue = this.testListWithPositionYourExchangeItems.get(i).intValue()) == -1) {
            return;
        }
        InvItems invItems = this.listYourItems.get(intValue);
        if (invItems.getItemsValue() != 0 && invItems.getFold() != 1) {
            invItems.setItemsValue(invItems.getItemsValue() + this.listYourExchangeItems.get(this.intermediatePositionWithExchangeItem).getItemsValue());
        } else {
            updateItemAfterMigrate(invItems, this.listYourExchangeItems.get(this.intermediatePositionWithExchangeItem), false);
        }
        InvItems invItems2 = this.listYourExchangeItems.get(this.intermediatePositionWithExchangeItem);
        int itemsValue = this.oldValue - invItems2.getItemsValue();
        this.oldValue = itemsValue;
        if (itemsValue == 0) {
            setEmptyItem(invItems2);
            this.testListWithPositionYourExchangeItems.set(this.intermediatePositionWithExchangeItem, -1);
        }
        invItems2.setItemsValue(this.oldValue);
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourItemsAndTrunkAdapter;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.notifyItemChanged(intValue);
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.yourExchangeItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter3;
        }
        inventoryExchangeAndTrunkAdapter2.notifyItemChanged(this.intermediatePositionWithExchangeItem);
    }

    public final void clearCheckIfFromExchangeToUser() {
        this.positionWithExchangeItem = -1;
        this.intermediatePositionWithExchangeItem = -1;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourExchangeItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.notifyItemChanged(this.positionWithExchangeItem);
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(this.positionWithExchangeItem);
    }

    private final void setLogicForYourExchangeItemsClickListener() {
        this.onYourExchangeItemsClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                GlobalValue globalValue;
                long j;
                long j2;
                int i2;
                List list;
                int i3;
                List list2;
                int i4;
                List list3;
                int i5;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding;
                InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding2;
                Function3 function3;
                Function3 function32;
                NvEventQueueActivity nvEventQueueActivity;
                LogicForMigrateItemsInCar logicForMigrateItemsInCar;
                long j3;
                int i6;
                int i7;
                GUIUsersInventory gUIUsersInventory;
                long j4;
                List list4;
                int i8;
                List list5;
                int i9;
                int parseInt;
                int i10;
                GUIUsersInventory gUIUsersInventory2;
                List list6;
                int i11;
                int i12;
                List list7;
                int i13;
                List list8;
                int i14;
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter;
                int unused;
                Intrinsics.checkNotNullParameter(item, "item");
                globalValue = UILayoutExchange.this.objectStatusBlocker;
                if (globalValue.getGlobalStatusBlocker()) {
                    return;
                }
                j = UILayoutExchange.this.oldTimeAfterCheck;
                if (j != System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    j2 = UILayoutExchange.this.oldTimeAfterCheck;
                    if (currentTimeMillis - j2 > 500) {
                        UILayoutExchange.this.oldTimeAfterCheck = System.currentTimeMillis();
                        UILayoutExchange.this.positionWithExchangeItem = i;
                        LogicForMigrateItemsInCar logicForMigrateItemsInCar2 = null;
                        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
                        if (item.getItemsValue() == 0) {
                            i2 = UILayoutExchange.this.positionWithItem;
                            if (i2 != -1) {
                                list = UILayoutExchange.this.listYourItems;
                                i3 = UILayoutExchange.this.positionWithItem;
                                if (((InvItems) list.get(i3)).getItemsValue() != 0) {
                                    list2 = UILayoutExchange.this.listYourItems;
                                    i4 = UILayoutExchange.this.positionWithItem;
                                    if (((InvItems) list2.get(i4)).getItemsValue() == 1) {
                                        j3 = UILayoutExchange.this.oldTimeWithMigrate;
                                        if (j3 != System.currentTimeMillis()) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            j4 = UILayoutExchange.this.oldTimeWithMigrate;
                                            if (currentTimeMillis2 - j4 > 1200) {
                                                UILayoutExchange.this.oldTimeWithMigrate = System.currentTimeMillis();
                                                list4 = UILayoutExchange.this.listYourItems;
                                                i8 = UILayoutExchange.this.positionWithItem;
                                                int id = ((InvItems) list4.get(i8)).getId();
                                                if (id == 58) {
                                                    list5 = UILayoutExchange.this.listYourItems;
                                                    i9 = UILayoutExchange.this.positionWithItem;
                                                    parseInt = Integer.parseInt(((InvItems) list5.get(i9)).getTextIfException());
                                                } else if (id != 134) {
                                                    list8 = UILayoutExchange.this.listYourItems;
                                                    i14 = UILayoutExchange.this.positionWithItem;
                                                    parseInt = ((InvItems) list8.get(i14)).getItemsValue();
                                                } else {
                                                    list7 = UILayoutExchange.this.listYourItems;
                                                    i13 = UILayoutExchange.this.positionWithItem;
                                                    parseInt = ((InvItems) list7.get(i13)).getModelid();
                                                }
                                                UILayoutExchange uILayoutExchange = UILayoutExchange.this;
                                                i10 = uILayoutExchange.positionWithItem;
                                                uILayoutExchange.intermediatePositionWithItem = i10;
                                                gUIUsersInventory2 = UILayoutExchange.this.mainRoot;
                                                list6 = UILayoutExchange.this.listYourItems;
                                                i11 = UILayoutExchange.this.positionWithItem;
                                                int id2 = ((InvItems) list6.get(i11)).getId();
                                                i12 = UILayoutExchange.this.positionWithItem;
                                                gUIUsersInventory2.sendIdWithCountAndSlotToServer(5, id2, parseInt, i12);
                                                UILayoutExchange.this.sendCounter = 0;
                                                return;
                                            }
                                        }
                                        i6 = UILayoutExchange.this.sendCounter;
                                        if (i6 == 0) {
                                            gUIUsersInventory = UILayoutExchange.this.mainRoot;
                                            gUIUsersInventory.sendMessageError("Перекладывать предмет можно раз в 1 сек");
                                        }
                                        UILayoutExchange uILayoutExchange2 = UILayoutExchange.this;
                                        i7 = uILayoutExchange2.sendCounter;
                                        uILayoutExchange2.sendCounter = i7 + 1;
                                        unused = uILayoutExchange2.sendCounter;
                                        UILayoutExchange.this.clearInfoAboutSlot();
                                        UILayoutExchange.this.clearInfoAboutExchange();
                                        UILayoutExchange.this.clearInfoAboutInv();
                                        return;
                                    }
                                    UILayoutExchange.this.startPopupWindowApply();
                                    UILayoutExchange uILayoutExchange3 = UILayoutExchange.this;
                                    list3 = uILayoutExchange3.listYourItems;
                                    i5 = UILayoutExchange.this.positionWithItem;
                                    InvItems invItems = (InvItems) list3.get(i5);
                                    inventoryDialogValueApplyBinding = UILayoutExchange.this.bindingDialogApply;
                                    if (inventoryDialogValueApplyBinding == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bindingDialogApply");
                                        inventoryDialogValueApplyBinding2 = null;
                                    } else {
                                        inventoryDialogValueApplyBinding2 = inventoryDialogValueApplyBinding;
                                    }
                                    function3 = UILayoutExchange.this.clickDialogMenu;
                                    if (function3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("clickDialogMenu");
                                        function32 = null;
                                    } else {
                                        function32 = function3;
                                    }
                                    nvEventQueueActivity = UILayoutExchange.this.context;
                                    uILayoutExchange3.dialogApplyMigrate = new LogicForMigrateItemsInCar(invItems, inventoryDialogValueApplyBinding2, 4, function32, nvEventQueueActivity);
                                    logicForMigrateItemsInCar = UILayoutExchange.this.dialogApplyMigrate;
                                    if (logicForMigrateItemsInCar == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("dialogApplyMigrate");
                                    } else {
                                        logicForMigrateItemsInCar2 = logicForMigrateItemsInCar;
                                    }
                                    logicForMigrateItemsInCar2.openDialogApply();
                                    return;
                                }
                            }
                            UILayoutExchange.this.clearCheckIfFromUserToExchange();
                            return;
                        }
                        UILayoutExchange.this.oldValue = item.getItemsValue();
                        UILayoutExchange.this.clearInfoAboutInv();
                        UILayoutExchange.this.clearInfoAboutSlot();
                        item.setCheck(true);
                        inventoryExchangeAndTrunkAdapter = UILayoutExchange.this.yourExchangeItemsAndTrunkAdapter;
                        if (inventoryExchangeAndTrunkAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
                        } else {
                            inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter;
                        }
                        inventoryExchangeAndTrunkAdapter2.notifyItemChanged(i);
                        inventoryExchangeAndTrunkAdapter2.setCheckOnlyElement(i);
                    }
                }
            }
        };
    }

    public final void setOldValueOnMyList() {
        int i = this.intermediatePositionWithItem;
        if (i != -1) {
            this.listYourItems.get(i).setItemsValue(this.oldValue);
        }
    }

    public final void setOldValueOnMyExchangeList() {
        int i = this.intermediatePositionWithExchangeItem;
        if (i != -1) {
            this.listYourExchangeItems.get(i).setItemsValue(this.oldValue);
        }
    }

    public final void migrateItemFromInvToExchange() {
        migrateItemFromInventory();
        clearAllMigrateItem();
    }

    public final void clearAllMigrateItem() {
        clearCheckIfFromUserToExchange();
        clearCheckIfFromExchangeToUser();
    }

    private final void migrateItemFromInventory() {
        int i = this.intermediatePositionWithItem;
        if (i != -1) {
            int positionInNewList = getPositionInNewList(this.listYourItems.get(i), this.listYourExchangeItems);
            InvItems invItems = this.listYourExchangeItems.get(positionInNewList);
            if (invItems.getItemsValue() != 0) {
                invItems.setItemsValue(invItems.getItemsValue() + this.listYourItems.get(this.intermediatePositionWithItem).getItemsValue());
            } else {
                updateItemAfterMigrate(invItems, this.listYourItems.get(this.intermediatePositionWithItem), false);
            }
            this.testListWithPositionYourExchangeItems.set(positionInNewList, Integer.valueOf(this.intermediatePositionWithItem));
            InvItems invItems2 = this.listYourItems.get(this.intermediatePositionWithItem);
            int itemsValue = this.oldValue - invItems2.getItemsValue();
            this.oldValue = itemsValue;
            if (itemsValue == 0) {
                setEmptyItem(invItems2);
            }
            invItems2.setItemsValue(this.oldValue);
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourExchangeItemsAndTrunkAdapter;
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
            if (inventoryExchangeAndTrunkAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
                inventoryExchangeAndTrunkAdapter = null;
            }
            inventoryExchangeAndTrunkAdapter.notifyItemChanged(positionInNewList);
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.yourItemsAndTrunkAdapter;
            if (inventoryExchangeAndTrunkAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            } else {
                inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter3;
            }
            inventoryExchangeAndTrunkAdapter2.notifyItemChanged(this.intermediatePositionWithItem);
            if (this.mainRoot.isTutor() && this.listYourItems.get(this.intermediatePositionWithItem).getId() == 346) {
                this.mainRoot.getGuideClass().visibleHelp(false);
                this.mainRoot.getGuideClass().getHelp(7);
            }
        }
    }

    private final int getPositionInNewList(InvItems invItems, List<InvItems> list) {
        int i;
        int i2 = 0;
        if (invItems.getFold() == 0) {
            int size = list.size();
            i = 0;
            while (i < size) {
                int i3 = i + 1;
                if (list.get(i).getId() == invItems.getId()) {
                    break;
                }
                i = i3;
            }
        }
        i = -1;
        if (i == -1) {
            int size2 = list.size();
            while (i2 < size2) {
                int i4 = i2 + 1;
                if (list.get(i2).getItemsValue() == 0) {
                    return i2;
                }
                i2 = i4;
            }
            return i;
        }
        return i;
    }

    public final void clearCheckIfFromUserToExchange() {
        this.positionWithItem = -1;
        this.intermediatePositionWithItem = -1;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.notifyItemChanged(this.positionWithItem);
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(this.positionWithItem);
    }

    private final void updateDataAfterMigrate(InvItems invItems, List<InvItems> list, int i) {
        updateItemAfterMigrate(list.get(i), invItems, false);
    }

    private final void updateDataAfterMigrateToSlot(InvItems invItems, List<InvItems> list, int i) {
        updateItemAfterMigrate(list.get(i), invItems, true);
    }

    public final void startPopupWindowApply() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        Object systemService = nvEventQueueActivity == null ? null : nvEventQueueActivity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        InventoryDialogValueApplyBinding inflate = InventoryDialogValueApplyBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.bindingDialogApply = inflate;
        InventoryDialogValueApplyBinding inventoryDialogValueApplyBinding = this.bindingDialogApply;
        if (inventoryDialogValueApplyBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bindingDialogApply");
            inventoryDialogValueApplyBinding = null;
        }
        PopupWindow popupWindow = new PopupWindow((View) inventoryDialogValueApplyBinding.getRoot(), -1, -1, true);
        this.dialogApplyPopupWindow = popupWindow;
        if (popupWindow == null) {
            return;
        }
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        popupWindow.showAtLocation(nvEventQueueActivity2 != null ? nvEventQueueActivity2.getParentLayout() : null, 17, 0, 0);
    }

    private final void setLogicForEmptyClickListener() {
        this.emptyClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter;
                int i2;
                List list;
                int i3;
                GUIUsersInventory gUIUsersInventory;
                Intrinsics.checkNotNullParameter(item, "item");
                inventoryExchangeAndTrunkAdapter = UILayoutExchange.this.otherPlayersItemsAndTrunkAdapter;
                if (inventoryExchangeAndTrunkAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                    inventoryExchangeAndTrunkAdapter = null;
                }
                inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(i);
                i2 = UILayoutExchange.this.positionWithItem;
                if (i2 != -1) {
                    list = UILayoutExchange.this.listYourItems;
                    i3 = UILayoutExchange.this.positionWithItem;
                    if (((InvItems) list.get(i3)).getItemsValue() != 0) {
                        gUIUsersInventory = UILayoutExchange.this.mainRoot;
                        gUIUsersInventory.sendMessageError("Поменяйте поле обмена");
                    }
                }
            }
        };
    }

    private final void setYourItemsInView() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (nvEventQueueActivity != null) {
            List<InvItems> list = this.listYourItems;
            Function2<? super InvItems, ? super Integer, Unit> function2 = this.onYourItemsClickListener;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onYourItemsClickListener");
                function2 = null;
            }
            this.yourItemsAndTrunkAdapter = new InventoryExchangeAndTrunkAdapter(list, function2, nvEventQueueActivity, 0);
        }
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutExchangeWithUserBinding.exchangeListItemsInInventory;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding2 = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(inventoryLayoutExchangeWithUserBinding2.getRoot().getContext(), 4));
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.yourItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
        }
        recyclerView.setAdapter(inventoryExchangeAndTrunkAdapter);
    }

    private final void setExchangeItemsInView() {
        NvEventQueueActivity nvEventQueueActivity = this.context;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (nvEventQueueActivity != null) {
            List<InvItems> list = this.listYourExchangeItems;
            Function2<? super InvItems, ? super Integer, Unit> function2 = this.onYourExchangeItemsClickListener;
            if (function2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("onYourExchangeItemsClickListener");
                function2 = null;
            }
            this.yourExchangeItemsAndTrunkAdapter = new InventoryExchangeAndTrunkAdapter(list, function2, nvEventQueueActivity, 1);
        }
        NvEventQueueActivity nvEventQueueActivity2 = this.context;
        if (nvEventQueueActivity2 != null) {
            List<InvItems> list2 = this.listOtherPlayersItems;
            Function2<? super InvItems, ? super Integer, Unit> function22 = this.emptyClickListener;
            if (function22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyClickListener");
                function22 = null;
            }
            this.otherPlayersItemsAndTrunkAdapter = new InventoryExchangeAndTrunkAdapter(list2, function22, nvEventQueueActivity2, 2);
        }
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutExchangeWithUserBinding.exchangeListItemsInCar;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding2 = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(inventoryLayoutExchangeWithUserBinding2.getRoot().getContext(), 4));
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.yourExchangeItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
        }
        recyclerView.setAdapter(inventoryExchangeAndTrunkAdapter);
    }

    private final void setViewExchangeList(int i) {
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (i == 0) {
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
            if (inventoryLayoutExchangeWithUserBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding = null;
            }
            inventoryLayoutExchangeWithUserBinding.exchangeTextPlayersNick.setText(this.textIsFromYou);
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding2 = null;
            }
            inventoryLayoutExchangeWithUserBinding2.exchangeBgPlayersName.setBackgroundResource(R.drawable.inv_bg_button_action);
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding3 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding3 = null;
            }
            RecyclerView recyclerView = inventoryLayoutExchangeWithUserBinding3.exchangeListItemsInCar;
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.yourExchangeItemsAndTrunkAdapter;
            if (inventoryExchangeAndTrunkAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
            } else {
                inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
            }
            recyclerView.setAdapter(inventoryExchangeAndTrunkAdapter);
        } else if (i != 1) {
        } else {
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding4 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding4 = null;
            }
            inventoryLayoutExchangeWithUserBinding4.exchangeTextPlayersNick.setText(this.textIsFromOtherPlayer);
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding5 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding5 = null;
            }
            inventoryLayoutExchangeWithUserBinding5.exchangeBgPlayersName.setBackgroundResource(R.drawable.inv_bg_title_other_users_nick);
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding6 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding6 = null;
            }
            RecyclerView recyclerView2 = inventoryLayoutExchangeWithUserBinding6.exchangeListItemsInCar;
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.otherPlayersItemsAndTrunkAdapter;
            if (inventoryExchangeAndTrunkAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
            } else {
                inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter3;
            }
            recyclerView2.setAdapter(inventoryExchangeAndTrunkAdapter);
            if (this.mainRoot.isTutor()) {
                this.mainRoot.getGuideClass().visibleHelp(false);
                if (this.mainRoot.getGuideClass().getClosedState() == 7) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            UILayoutExchange.m346setViewExchangeList$lambda26(UILayoutExchange.this);
                        }
                    }, 100L);
                }
            }
        }
    }

    public static final void m346setViewExchangeList$lambda26(UILayoutExchange this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.getGuideClass().getHelp(8);
    }

    private final void setLogicForDialogApply() {
        this.clickDialogMenu = new Function3<InvItems, Integer, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num, Integer num2) {
                invoke(invItems, num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems invItems, int i, int i2) {
                int i3;
                int i4;
                GUIUsersInventory gUIUsersInventory;
                List list;
                int i5;
                List list2;
                int i6;
                int i7;
                int i8;
                int i9;
                GUIUsersInventory gUIUsersInventory2;
                List list3;
                int i10;
                List list4;
                int i11;
                List list5;
                int i12;
                if (i == 4) {
                    if (i2 == 11) {
                        i3 = UILayoutExchange.this.positionWithItem;
                        if (i3 != -1) {
                            UILayoutExchange uILayoutExchange = UILayoutExchange.this;
                            i4 = uILayoutExchange.positionWithItem;
                            uILayoutExchange.intermediatePositionWithItem = i4;
                            gUIUsersInventory = UILayoutExchange.this.mainRoot;
                            list = UILayoutExchange.this.listYourItems;
                            i5 = UILayoutExchange.this.positionWithItem;
                            int id = ((InvItems) list.get(i5)).getId();
                            list2 = UILayoutExchange.this.listYourItems;
                            i6 = UILayoutExchange.this.positionWithItem;
                            int itemsValue = ((InvItems) list2.get(i6)).getItemsValue();
                            i7 = UILayoutExchange.this.positionWithItem;
                            gUIUsersInventory.sendIdWithCountAndSlotToServer(5, id, itemsValue, i7);
                        }
                    }
                    UILayoutExchange.this.closePopupWindowApply();
                } else if (i != 5) {
                } else {
                    if (i2 == 11) {
                        i8 = UILayoutExchange.this.positionWithExchangeItem;
                        if (i8 != -1) {
                            UILayoutExchange uILayoutExchange2 = UILayoutExchange.this;
                            i9 = uILayoutExchange2.positionWithExchangeItem;
                            uILayoutExchange2.intermediatePositionWithExchangeItem = i9;
                            gUIUsersInventory2 = UILayoutExchange.this.mainRoot;
                            list3 = UILayoutExchange.this.listYourExchangeItems;
                            i10 = UILayoutExchange.this.positionWithExchangeItem;
                            int id2 = ((InvItems) list3.get(i10)).getId();
                            list4 = UILayoutExchange.this.listYourExchangeItems;
                            i11 = UILayoutExchange.this.positionWithExchangeItem;
                            int itemsValue2 = ((InvItems) list4.get(i11)).getItemsValue();
                            list5 = UILayoutExchange.this.testListWithPositionYourExchangeItems;
                            i12 = UILayoutExchange.this.positionWithExchangeItem;
                            gUIUsersInventory2.sendIdWithCountToServer(24, id2, itemsValue2, ((Number) list5.get(i12)).intValue());
                        }
                    }
                    UILayoutExchange.this.closePopupWindowApply();
                }
            }
        };
    }

    private final void setStartViewSlots() {
        int i = this.sizeSlots;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            this.listItemsInSlots.add(Constants.INSTANCE.emptyItem());
        }
    }

    private final void setDataInSlotsView() {
        List<InvItems> list = this.listItemsInSlots;
        Function2<? super InvItems, ? super Integer, Unit> function2 = this.onItemsInSlotClickListener;
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemsInSlotClickListener");
            function2 = null;
        }
        this.itemsInSlotAdapter = new InventoryItemsInSlotAdapter(list, function2, this.context, false);
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutExchangeWithUserBinding.playersSlotsInExchange;
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(inventoryLayoutExchangeWithUserBinding2.getRoot().getContext(), 1, false));
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter2 = this.itemsInSlotAdapter;
        if (inventoryItemsInSlotAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
        } else {
            inventoryItemsInSlotAdapter = inventoryItemsInSlotAdapter2;
        }
        recyclerView.setAdapter(inventoryItemsInSlotAdapter);
    }

    private final void setLogicForClickInSlot() {
        this.onItemsInSlotClickListener = new Function2<InvItems, Integer, Unit>() {
            @Override
            public Unit invoke(InvItems invItems, Integer num) {
                invoke(invItems, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(InvItems item, int i) {
                int i2;
                InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter;
                Intrinsics.checkNotNullParameter(item, "item");
                i2 = UILayoutExchange.this.statusApply;
                if (i2 == 0) {
                    UILayoutExchange.this.positionFromSlot = i;
                    UILayoutExchange.this.clearInfoAboutInv();
                    UILayoutExchange.this.clearInfoAboutExchange();
                    if (item.getItemsValue() != 0) {
                        item.setCheck(true);
                        inventoryItemsInSlotAdapter = UILayoutExchange.this.itemsInSlotAdapter;
                        if (inventoryItemsInSlotAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
                            inventoryItemsInSlotAdapter = null;
                        }
                        inventoryItemsInSlotAdapter.notifyItemChanged(i);
                        inventoryItemsInSlotAdapter.setCheckOnlyElement(i);
                    }
                }
            }
        };
    }

    public final void migrateFromSlotToInventory() {
        migrateItemFromSlotToInventory();
    }

    private final void migrateItemFromSlotToInventory() {
        int i = this.intermediatePositionFromSlot;
        if (i != -1 && this.intermediatePositionWithItem != -1) {
            updateDataAfterMigrate(this.listItemsInSlots.get(i), this.listYourItems, this.intermediatePositionWithItem);
            updateDataAfterMigrate(this.listItemsInSlots.get(this.intermediatePositionFromSlot), this.copyListWithYourItems, this.intermediatePositionWithItem);
            updateDataAfterMigrate(this.listItemsInSlots.get(this.intermediatePositionFromSlot), this.savedListForInv, this.intermediatePositionWithItem);
            addNewItemInSafeList(this.listItemsInSlots.get(this.intermediatePositionFromSlot), this.intermediatePositionWithItem);
            InvItems invItems = this.listItemsInSlots.get(this.intermediatePositionFromSlot);
            setEmptyItem(invItems);
            invItems.setItemsValue(0);
            InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
            if (inventoryItemsInSlotAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
                inventoryItemsInSlotAdapter = null;
            }
            inventoryItemsInSlotAdapter.notifyItemChanged(this.intermediatePositionFromSlot);
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.yourItemsAndTrunkAdapter;
            if (inventoryExchangeAndTrunkAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            } else {
                inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter2;
            }
            inventoryExchangeAndTrunkAdapter.notifyItemChanged(this.intermediatePositionWithItem);
        }
        clearInfoAboutSlot();
        clearInfoAboutInv();
    }

    public final void closePopupWindowApply() {
        PopupWindow popupWindow = this.dialogApplyPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        GUIManager.hideSystemUI(inventoryLayoutExchangeWithUserBinding.getRoot());
    }

    private final void changeButtonAndHelpInfo(boolean z) {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        if (z) {
            TextView textView = inventoryLayoutExchangeWithUserBinding.exchangeButtonApply;
            NvEventQueueActivity nvEventQueueActivity = this.context;
            textView.setText(nvEventQueueActivity == null ? null : nvEventQueueActivity.getText(R.string.inv_title_button_apply));
            TextView textView2 = inventoryLayoutExchangeWithUserBinding.exchangeTextInfo;
            NvEventQueueActivity nvEventQueueActivity2 = this.context;
            textView2.setText(nvEventQueueActivity2 != null ? nvEventQueueActivity2.getText(R.string.inv_text_info_if_apply_exchange) : null);
            if (this.mainRoot.isTutor()) {
                this.mainRoot.getGuideClass().visibleHelp(false);
                if (this.mainRoot.getGuideClass().getClosedState() == 9) {
                    this.mainRoot.getGuideClass().getHelp(10);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView3 = inventoryLayoutExchangeWithUserBinding.exchangeButtonApply;
        NvEventQueueActivity nvEventQueueActivity3 = this.context;
        textView3.setText(nvEventQueueActivity3 == null ? null : nvEventQueueActivity3.getText(R.string.inv_title_button_exchange));
        TextView textView4 = inventoryLayoutExchangeWithUserBinding.exchangeTextInfo;
        NvEventQueueActivity nvEventQueueActivity4 = this.context;
        textView4.setText(nvEventQueueActivity4 != null ? nvEventQueueActivity4.getText(R.string.inv_text_info) : null);
    }

    private final void setClearClickInLists() {
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourItemsAndTrunkAdapter;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = null;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(-1);
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.yourExchangeItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter3 = null;
        }
        inventoryExchangeAndTrunkAdapter3.setCheckOnlyElement(-1);
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter4 = this.otherPlayersItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter2 = inventoryExchangeAndTrunkAdapter4;
        }
        inventoryExchangeAndTrunkAdapter2.setCheckOnlyElement(-1);
        this.intermediatePositionWithItem = -1;
        this.intermediatePositionWithExchangeItem = -1;
        this.intermediatePositionFromSlot = -1;
        this.positionWithItem = -1;
        this.positionWithExchangeItem = -1;
        this.positionFromSlot = -1;
        this.oldValue = 0;
    }

    public final void changeStatusInInterface(int i) {
        if (i == 8) {
            this.objectStatusBlocker.setGlobalStatusBlocker(true);
            this.statusApply = 1;
            setClearClickInLists();
        } else if (i != 26) {
        } else {
            this.objectStatusBlocker.setGlobalStatusBlocker(true);
            this.statusApply = 2;
            changeButtonAndHelpInfo(true);
        }
    }

    public final void listenerStatusAfterClickCancel(Integer num) {
        if (num != null && num.intValue() == 1) {
            this.statusApply = 1;
            this.objectStatusBlocker.setGlobalStatusBlocker(true);
            changeButtonAndHelpInfo(false);
        } else if (num != null && num.intValue() == 2) {
            this.statusApply = 0;
            this.objectStatusBlocker.setGlobalStatusBlocker(false);
            changeButtonAndHelpInfo(false);
        } else if (num != null && num.intValue() == 3) {
            this.statusApply = 0;
            this.objectStatusBlocker.setGlobalStatusBlocker(false);
            clearMyInterface();
        } else if (num != null && num.intValue() == 4) {
            this.objectStatusBlocker.setGlobalStatusBlocker(false);
            this.mainRoot.layoutListener(0, false);
        } else if (num != null && num.intValue() == 5) {
            this.objectStatusBlocker.setGlobalStatusBlocker(false);
            setEmptyListOtherPlayers();
            InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.otherPlayersItemsAndTrunkAdapter;
            if (inventoryExchangeAndTrunkAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherPlayersItemsAndTrunkAdapter");
                inventoryExchangeAndTrunkAdapter = null;
            }
            inventoryExchangeAndTrunkAdapter.notifyDataSetChanged();
            setOtherPlayersMoney(0);
        }
        this.listenerForChangeStatus.invoke(Boolean.valueOf(this.objectStatusBlocker.getGlobalStatusBlocker()));
    }

    private final void clearMyInterface() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = null;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        Editable text = inventoryLayoutExchangeWithUserBinding.exchangeEdittextMoney.getText();
        Intrinsics.checkNotNull(text);
        text.clear();
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding2 = null;
        }
        inventoryLayoutExchangeWithUserBinding2.exchangeTextMoney.setText("");
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding3 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding3 = null;
        }
        inventoryLayoutExchangeWithUserBinding3.exchangeTitleActualWeightUsers.setText(String.valueOf(this.startThisWeight));
        getAllItemsAfterClear();
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter2 = this.yourItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter2 = null;
        }
        inventoryExchangeAndTrunkAdapter2.notifyDataSetChanged();
        setEmptyListsForExchange();
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter3 = this.yourExchangeItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
        } else {
            inventoryExchangeAndTrunkAdapter = inventoryExchangeAndTrunkAdapter3;
        }
        inventoryExchangeAndTrunkAdapter.notifyDataSetChanged();
    }

    private final void getAllItemsAfterClear() {
        this.listYourItems.clear();
        setEmptyListInInventory(this.activeSlotsInInventory);
        int size = this.listYourItems.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            for (NewInvItem newInvItem : this.testCopyListWithYourItems) {
                if (newInvItem.getPosition() == i) {
                    this.listYourItems.get(i).setId(newInvItem.getId());
                    this.listYourItems.get(i).setName(newInvItem.getName());
                    this.listYourItems.get(i).setDesc(newInvItem.getDesc());
                    this.listYourItems.get(i).setModelid(newInvItem.getModelid());
                    this.listYourItems.get(i).setWeight(newInvItem.getWeight());
                    this.listYourItems.get(i).setAddw(newInvItem.getAddw());
                    this.listYourItems.get(i).setFold(newInvItem.getFold());
                    this.listYourItems.get(i).setShiftX(newInvItem.getShiftX());
                    this.listYourItems.get(i).setShiftY(newInvItem.getShiftY());
                    this.listYourItems.get(i).setShiftZ(newInvItem.getShiftZ());
                    this.listYourItems.get(i).setX(newInvItem.getX());
                    this.listYourItems.get(i).setY(newInvItem.getY());
                    this.listYourItems.get(i).setZ(newInvItem.getZ());
                    this.listYourItems.get(i).setZoom(newInvItem.getZoom());
                    this.listYourItems.get(i).setItemsValue(newInvItem.getItemsValue());
                    this.listYourItems.get(i).setTextIfException(newInvItem.getTextIfException());
                    this.listYourItems.get(i).setWhoseItem(newInvItem.getWhoseItem());
                    this.listYourItems.get(i).setThisBitmap(newInvItem.getThisBitmap());
                    this.listYourItems.get(i).setCheck(false);
                }
            }
            i = i2;
        }
    }

    public final void updateCountWithNewMessages(int i) {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = null;
        if (i > 0) {
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding2 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                inventoryLayoutExchangeWithUserBinding2 = null;
            }
            inventoryLayoutExchangeWithUserBinding2.exchangeTextValueMessage.setVisibility(0);
            InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding3 = this.binding;
            if (inventoryLayoutExchangeWithUserBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                inventoryLayoutExchangeWithUserBinding = inventoryLayoutExchangeWithUserBinding3;
            }
            inventoryLayoutExchangeWithUserBinding.exchangeTextValueMessage.setText(String.valueOf(i));
            return;
        }
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding4 = this.binding;
        if (inventoryLayoutExchangeWithUserBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            inventoryLayoutExchangeWithUserBinding = inventoryLayoutExchangeWithUserBinding4;
        }
        inventoryLayoutExchangeWithUserBinding.exchangeTextValueMessage.setVisibility(4);
    }

    public final void clearInfoAboutSlot() {
        this.intermediatePositionFromSlot = -1;
        this.positionFromSlot = -1;
        InventoryItemsInSlotAdapter inventoryItemsInSlotAdapter = this.itemsInSlotAdapter;
        if (inventoryItemsInSlotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsInSlotAdapter");
            inventoryItemsInSlotAdapter = null;
        }
        inventoryItemsInSlotAdapter.setCheckOnlyElement(this.positionFromSlot);
    }

    public final void clearInfoAboutInv() {
        this.positionWithItem = -1;
        this.intermediatePositionWithItem = -1;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(this.positionWithItem);
    }

    public final void clearInfoAboutExchange() {
        this.intermediatePositionWithExchangeItem = -1;
        this.positionWithExchangeItem = -1;
        InventoryExchangeAndTrunkAdapter inventoryExchangeAndTrunkAdapter = this.yourExchangeItemsAndTrunkAdapter;
        if (inventoryExchangeAndTrunkAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yourExchangeItemsAndTrunkAdapter");
            inventoryExchangeAndTrunkAdapter = null;
        }
        inventoryExchangeAndTrunkAdapter.setCheckOnlyElement(this.positionWithExchangeItem);
    }

    public final List<InvItems> getItemsFromActiveSlots() {
        return this.listItemsInSlots;
    }

    public final List<InvItems> getItemsFromInventory() {
        return this.savedListForInv;
    }

    public final int getSizeSlots() {
        return this.activeSlotsInInventory;
    }

    public final int getThisWeight() {
        return this.thisWeightInventory;
    }

    public final int getMaxWeight() {
        return this.maxWeightInventory;
    }

    public final int getMyId() {
        return this.myId;
    }

    public final void setMyId(int i) {
        this.myId = i;
    }

    public final int[] getInventoryLocation() {
        return this.inventoryLocation;
    }

    public final int getInventoryHeight() {
        return this.inventoryHeight;
    }

    public final void setInventoryHeight(int i) {
        this.inventoryHeight = i;
    }

    public final int getInventoryWidth() {
        return this.inventoryWidth;
    }

    public final void setInventoryWidth(int i) {
        this.inventoryWidth = i;
    }

    private final void getInventoryParameters() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        View view = inventoryLayoutExchangeWithUserBinding.exchangeBgItemsInBag;
        view.getLocationInWindow(getInventoryLocation());
        setInventoryHeight(view.getHeight());
        setInventoryWidth(view.getWidth());
    }

    public final int[] getOtherPlayersInvLocation() {
        return this.otherPlayersInvLocation;
    }

    public final int getOtherPlayersInvHeight() {
        return this.otherPlayersInvHeight;
    }

    public final void setOtherPlayersInvHeight(int i) {
        this.otherPlayersInvHeight = i;
    }

    public final int getOtherPlayersInvWidth() {
        return this.otherPlayersInvWidth;
    }

    public final void setOtherPlayersInvWidth(int i) {
        this.otherPlayersInvWidth = i;
    }

    private final void getOtherPlayersInvParameters() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        View view = inventoryLayoutExchangeWithUserBinding.exchangeBgItemsInCar;
        view.getLocationInWindow(getOtherPlayersInvLocation());
        setOtherPlayersInvHeight(view.getHeight());
        setOtherPlayersInvWidth(view.getWidth());
    }

    public final int[] getAllInvLocation() {
        return this.allInvLocation;
    }

    public final int getAllInvHeight() {
        return this.allInvHeight;
    }

    public final void setAllInvHeight(int i) {
        this.allInvHeight = i;
    }

    public final int getAllInvWidth() {
        return this.allInvWidth;
    }

    public final void setAllInvWidth(int i) {
        this.allInvWidth = i;
    }

    private final void getAllInvParameters() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        View view = inventoryLayoutExchangeWithUserBinding.helpExchangeView;
        view.getLocationInWindow(getAllInvLocation());
        setAllInvHeight(view.getHeight());
        setAllInvWidth(view.getWidth());
    }

    public final int[] getButtonChangeInvLocation() {
        return this.buttonChangeInvLocation;
    }

    public final int getButtonChangeInvHeight() {
        return this.buttonChangeInvHeight;
    }

    public final void setButtonChangeInvHeight(int i) {
        this.buttonChangeInvHeight = i;
    }

    public final int getButtonChangeInvWidth() {
        return this.buttonChangeInvWidth;
    }

    public final void setButtonChangeInvWidth(int i) {
        this.buttonChangeInvWidth = i;
    }

    private final void getButtonChangeInvParameters() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        ImageButton imageButton = inventoryLayoutExchangeWithUserBinding.exchangeBgValuesForBag;
        imageButton.getLocationInWindow(getButtonChangeInvLocation());
        setButtonChangeInvHeight(imageButton.getHeight());
        setButtonChangeInvWidth(imageButton.getWidth());
    }

    public final int[] getFirstOthersItemLocation() {
        return this.firstOthersItemLocation;
    }

    public final int getFirstOthersItemHeight() {
        return this.firstOthersItemHeight;
    }

    public final void setFirstOthersItemHeight(int i) {
        this.firstOthersItemHeight = i;
    }

    public final int getFirstOthersItemWidth() {
        return this.firstOthersItemWidth;
    }

    public final void setFirstOthersItemWidth(int i) {
        this.firstOthersItemWidth = i;
    }

    private final void getFirstOthersItemParameters() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        RecyclerView recyclerView = inventoryLayoutExchangeWithUserBinding.exchangeListItemsInCar;
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null) {
            childAt.getLocationInWindow(getFirstOthersItemLocation());
        }
        if (childAt == null) {
            return;
        }
        setFirstOthersItemHeight(recyclerView.getHeight());
        setFirstOthersItemWidth(recyclerView.getWidth());
    }

    public final int[] getButtonApplyLocation() {
        return this.buttonApplyLocation;
    }

    public final int getButtonApplyHeight() {
        return this.buttonApplyHeight;
    }

    public final void setButtonApplyHeight(int i) {
        this.buttonApplyHeight = i;
    }

    public final int getButtonApplyWidth() {
        return this.buttonApplyWidth;
    }

    public final void setButtonApplyWidth(int i) {
        this.buttonApplyWidth = i;
    }

    private final void getButtonApplyParameters() {
        InventoryLayoutExchangeWithUserBinding inventoryLayoutExchangeWithUserBinding = this.binding;
        if (inventoryLayoutExchangeWithUserBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inventoryLayoutExchangeWithUserBinding = null;
        }
        TextView textView = inventoryLayoutExchangeWithUserBinding.exchangeButtonApply;
        textView.getLocationInWindow(getButtonApplyLocation());
        setButtonApplyHeight(textView.getHeight());
        setButtonApplyWidth(textView.getWidth());
    }
}
