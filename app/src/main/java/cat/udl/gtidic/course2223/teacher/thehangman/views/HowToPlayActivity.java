package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class HowToPlayActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
//        nothing interesting here
        TextView textView = findViewById(R.id.tvDescription);

        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}