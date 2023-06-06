package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class EndGameActivity extends AppCompatActivity {
    TextView ResultText;
    TextView noTimeToDieText;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        ResultText = findViewById(R.id.ResultText);
        noTimeToDieText = findViewById(R.id.noTimeToDieText);
        findViewById(R.id.ReturnButton).setOnClickListener(v -> finish());
        findViewById(R.id.ReturnButton).setVisibility(View.INVISIBLE);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            boolean resultado = bundle.getBoolean("resultado");
            if (resultado){
                ResultText.setText("¡¡¡Que guay has ganado :)!!!");
            } else {
                ResultText.setText("Perdiste, admítelo no sabes jugar :(");
            }
        }
        handler = new Handler();
        noTimeToDie();
    }
    public void noTimeToDie(){
        int i;
        for (i = 5; i > 0; i--) {
            final int countdownValue = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    noTimeToDieText.setText(String.valueOf(countdownValue));
                }
            }, (5 - i) * 1000);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                noTimeToDieText.setText("0");
                finish();
            }
        }, 5000);
    }
}