package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class EndGameActivity extends AppCompatActivity {
    TextView ResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        ResultText = findViewById(R.id.ResultText);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            boolean resultado = bundle.getBoolean("resultado");
            if (resultado){
                ResultText.setText("¡¡¡Que guay has ganado :)!!!");
            } else {
                ResultText.setText("Perdiste, admítelo no sabes jugar :(");
            }
        }
        findViewById(R.id.ReturnButton).setOnClickListener(v -> finish());
    }
}