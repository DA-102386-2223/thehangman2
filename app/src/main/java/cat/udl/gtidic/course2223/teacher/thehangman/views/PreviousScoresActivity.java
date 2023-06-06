package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.helpers.MatchOnlineProvider;
import cat.udl.gtidic.course2223.teacher.thehangman.helpers.PreviousScoresAdapter;
import cat.udl.gtidic.course2223.teacher.thehangman.helpers.PreviousScoresViewHolder;

public class PreviousScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_scores);
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.Adapter<PreviousScoresViewHolder> adapter = new PreviousScoresAdapter(MatchOnlineProvider.getList());
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        MatchOnlineProvider.setAdapter(adapter);
        MatchOnlineProvider.updateFromFirebase();
    }
}