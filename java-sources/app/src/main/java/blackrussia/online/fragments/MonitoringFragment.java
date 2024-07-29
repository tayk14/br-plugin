package blackrussia.online.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.adapters.ServerAdapter;
import blackrussia.online.adapters.StoriesAdapter;
import blackrussia.online.network.DataService;
import blackrussia.online.network.ServerListener;
import blackrussia.online.network.Story;
import com.rockstargames.gtacr.BrChooseServerDialog;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class MonitoringFragment extends Fragment {
    private ServerAdapter serverAdapter;
    private ServerListener serverListener;
    private StoriesAdapter storiesAdapter;
    private LinearLayout storiesLL;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_monitoring, container, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.ourServersRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ServerAdapter serverAdapter = new ServerAdapter(this, App.getInstance().getServerList());
        this.serverAdapter = serverAdapter;
        recyclerView.setAdapter(serverAdapter);
        this.serverListener = new ServerListener() { // from class: blackrussia.online.fragments.-$$Lambda$MonitoringFragment$9S0mTGgMq5-nxOaXX7AHVMxGFDg
            @Override // blackrussia.online.network.ServerListener
            public final void onChange() {
                MonitoringFragment.this.lambda$onCreateView$0$MonitoringFragment();
            }
        };
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.storiesRV);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        StoriesAdapter storiesAdapter = new StoriesAdapter(getActivity());
        this.storiesAdapter = storiesAdapter;
        recyclerView2.setAdapter(storiesAdapter);
        this.storiesLL = (LinearLayout) inflate.findViewById(R.id.storiesLL);
        DataService.getInstance().getApiService().getStories().enqueue(new Callback<ArrayList<Story>>() { // from class: blackrussia.online.fragments.MonitoringFragment.1
            @Override // retrofit2.Callback
            public void onResponse(Call<ArrayList<Story>> call, Response<ArrayList<Story>> response) {
                if (response.body() != null) {
                    ArrayList<Story> body = response.body();
                    MonitoringFragment.this.storiesAdapter.addItems(body);
                    App.getInstance().setStories(body);
                    if (body.size() == 0) {
                        MonitoringFragment.this.storiesLL.setVisibility(8);
                    }
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ArrayList<Story>> call, Throwable t) {
                MonitoringFragment.this.storiesLL.setVisibility(8);
            }
        });
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$MonitoringFragment() {
        BrChooseServerDialog.setServers(App.getInstance().getServerList());
        this.serverAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        App.getInstance().setServerListener(this.serverListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        App.getInstance().setServerListener(null);
    }
}
