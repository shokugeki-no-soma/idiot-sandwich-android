package dev.michaelkimball.toolnextdoor.home;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;
import dev.michaelkimball.toolnextdoor.R;
import dev.michaelkimball.toolnextdoor.VerticalSpacingItemDecoration;

public class HomeActivity extends DaggerAppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView feed;

    @BindView(R.id.ask_a_neighbor_submit)
    Button askButton;

    @BindView(R.id.ask_a_neighbor_edit)
    EditText askEdit;

    @OnClick(R.id.ask_a_neighbor_submit)
    void submit(){
        askEdit.setText("");
        Toast.makeText(this, "Request submitted!", Toast.LENGTH_SHORT).show();
    }


    @Inject
    FeedRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView(){
        feed.setLayoutManager(new LinearLayoutManager(this));
        VerticalSpacingItemDecoration itemDecoration = new VerticalSpacingItemDecoration(15);
        feed.addItemDecoration(itemDecoration);
        feed.setAdapter(adapter);
        List<NeighborRequest> requests = new ArrayList<>();

        NeighborRequest test1 = new NeighborRequest();
        test1.setBody("Anybody have a screwdriver I can borrow? I just need to the back off my remote.");
        requests.add(test1);

        NeighborRequest test2 = new NeighborRequest();
        test2.setBody("I'm all out of milk! My dinner is almost done, can anyone help me out?");
        requests.add(test2);

        NeighborRequest test3 = new NeighborRequest();
        test3.setBody("I am having a BBQ and I ran out of lighter fluid. Anyone close by that can bring some? There's a burger with your name on it :)");
        requests.add(test3);

        NeighborRequest test4 = new NeighborRequest();
        test4.setBody("Anybody throwing out their egg shells? Let me pick them up for you!");
        requests.add(test4);

        adapter.setRequests(requests);
    }
}
