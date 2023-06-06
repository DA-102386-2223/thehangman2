/**
 * Aquesta classe només és interessant pel requeriment d'ampliació 3
 * Si no estas fent aquest requeriment pots obviar-la
 */

package cat.udl.gtidic.course2223.teacher.thehangman.helpers;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PreviousScoresAdapter extends RecyclerView.Adapter<PreviousScoresViewHolder> {

    List<MatchOnline> matchesOnlineList;

    public PreviousScoresAdapter(List<MatchOnline> matchesOnlineList){
        this.matchesOnlineList = matchesOnlineList;
    }

    @NonNull
    @Override
    public PreviousScoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Developer despistat: pending to do
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousScoresViewHolder holder, int position) {
        // Developer despistat: pending to do
    }

    @Override
    public int getItemCount() {
        // Developer despistat: pending to do
        return 0;
    }
}
