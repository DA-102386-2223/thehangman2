package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cat.udl.gtidic.course2223.teacher.thehangman.databinding.ActivityGameBinding;
import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;
import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.viewmodels.GameViewModel;

public class EndGameActivity extends AppCompatActivity {

    Button homeButton;
    TextView winnerConditionsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        winnerConditionsText = (TextView) findViewById(R.id.winnerConditionsText);

        findViewById(R.id.homeButton).setOnClickListener(v -> home());

    }
    private void checkGameOver(){

        // variable actualment sense us..
        boolean playerWinner = false;

        GameViewModel gameViewModel = null;
        if (gameViewModel.getGame().isPlayerTheWinner()){
            Log.d(Game.TAG, "El jugador ha guanyat!");
            playerWinner = true;
        }

        if (gameViewModel.getGame().isGameOver()){
            Log.d(Game.TAG, "El Joc ha acabat");
            finish();
        }
    }
        private void home() {
            Intent i = new Intent (this, InitActivity.class);
            startActivity(i);
            finish();
        }


}