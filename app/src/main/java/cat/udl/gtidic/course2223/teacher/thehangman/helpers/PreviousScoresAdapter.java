/**
 * Aquesta classe només és interessant pel requeriment d'ampliació 3
 * Si no estas fent aquest requeriment pots obviar-la
 */

package cat.udl.gtidic.course2223.teacher.thehangman.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class PreviousScoresAdapter extends RecyclerView.Adapter<PreviousScoresViewHolder> {

    List<MatchOnline> matchesOnlineList;

    public PreviousScoresAdapter(List<MatchOnline> matchesOnlineList){
        this.matchesOnlineList = matchesOnlineList;
    }

    @NonNull
    @Override
    public PreviousScoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_score_item, parent, false);
        return new PreviousScoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousScoresViewHolder holder, int position) {
        holder.render(matchesOnlineList.get(position));
    }

    @Override
    public int getItemCount() {
        return matchesOnlineList.size();
    }
}
