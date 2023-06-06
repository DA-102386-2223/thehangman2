/**
 * Aquesta classe només és interessant pel requeriment d'ampliació 3
 * Si no estas fent aquest requeriment pots obviar-la
 */

package cat.udl.gtidic.course2223.teacher.thehangman.helpers;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class PreviousScoresViewHolder extends RecyclerView.ViewHolder {
    View itemView;

    TextView tvUserEmailVHValue, tvWonVHValue, tvTimeVHValue, tvSecretWordVHValue, tvLettersChosenVHValue, tvTotalRoundVHValue;

    public PreviousScoresViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;

        tvUserEmailVHValue = itemView.findViewById(R.id.tvUserEmailVHValue);
        tvWonVHValue = itemView.findViewById(R.id.tvWonVHValue);
        tvTimeVHValue = itemView.findViewById(R.id.tvTimeVHValue);
        tvSecretWordVHValue = itemView.findViewById(R.id.tvSecretWordVHValue);
        tvLettersChosenVHValue = itemView.findViewById(R.id.tvLettersChosenVHValue);
        tvTotalRoundVHValue = itemView.findViewById(R.id.tvTotalRoundVHValue);
    }

    /**
     * renderitza l'score segons el matchonline item rebut
     * @param item MatchOnline a renderitzar
     */
    public void render(MatchOnline item){
        tvUserEmailVHValue.setText(item.userEmail);
        tvWonVHValue.setText(item.playerWon.toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        tvTimeVHValue.setText(dateFormat.format(item.time));
        tvSecretWordVHValue.setText(item.secretWord);
        tvLettersChosenVHValue.setText(item.lettersChosenStr);
        tvTotalRoundVHValue.setText(String.valueOf(item.currentRound));
    }
}
