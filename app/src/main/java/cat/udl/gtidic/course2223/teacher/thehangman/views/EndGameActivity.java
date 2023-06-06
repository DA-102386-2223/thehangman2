package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.views.InitActivity;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        TextView tv = findViewById(R.id.tvWinner);
        String res;
        boolean playerWinnerRebut = getIntent().getExtras().getBoolean("playerWinner");
        if (playerWinnerRebut) {
            res = getString(R.string.youWin);
        } else {
            res = getString(R.string.youLost);
        }
        tv.setText(res);
        findViewById(R.id.btnReturnToInitActivity).setOnClickListener(view -> returnToInit());
    }

    private void returnToInit() {
        Intent i = new Intent(this, InitActivity.class);
        startActivity(i);
        finish();
    }
}
