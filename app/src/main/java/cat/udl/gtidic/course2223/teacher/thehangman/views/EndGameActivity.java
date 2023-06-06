package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Button btnRestart = findViewById(R.id.return_init);
        ImageView endGameImage = findViewById(R.id.end_game_image);

        Bundle extras = getIntent().getExtras();
        boolean playerWinner = extras.getBoolean("playerWinner");

        if (playerWinner) {
            endGameImage.setImageResource(R.drawable.youwin);
        } else {
            endGameImage.setImageResource(R.drawable.loser);
        }

        btnRestart.setOnClickListener(view -> {
            Intent intent = new Intent(this, InitActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
