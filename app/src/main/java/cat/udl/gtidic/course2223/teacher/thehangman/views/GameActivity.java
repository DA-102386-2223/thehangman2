package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cat.udl.gtidic.course2223.teacher.thehangman.databinding.ActivityGameBinding;
import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;
import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.viewmodels.GameViewModel;

public class GameActivity extends AppCompatActivity {

    Button btnNewLetter;
    TextView lettersChosen;
    EditText etNewLetter;
    ImageView ivState;
    private GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Implementing MVVM
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        ActivityGameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        binding.setViewmodel(gameViewModel);
        binding.setLifecycleOwner(this);

        // Initializing views
        btnNewLetter = findViewById(R.id.btnNewLetter);
        btnNewLetter.setOnClickListener(v -> newLetter());
        lettersChosen = findViewById(R.id.tvLettersChosen);
        etNewLetter = findViewById(R.id.etNewLetter);
        ivState = findViewById(R.id.ivState);
        updateUserName();

        setInputLetterAlwaysUppercase();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // starting game mechanics
        startGame();
    }

    /**
     * Escriu el nom d'usuari logat
     */
    private void updateUserName() {
        TextView tv = findViewById(R.id.tvUserNameRebut);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        tv.setText(currentUser.getEmail());
    }

    /**
     * Retorna el Drawable segons l'estat correcte
     */
    private Drawable getDrawableFromState(int state){
        int r_desired = -1;

        switch (state){
            case 0: r_desired = R.drawable.round_0; break;
            case 1: r_desired = R.drawable.round_1; break;
            case 2: r_desired = R.drawable.round_2; break;
            case 3: r_desired = R.drawable.round_3; break;
            case 4: r_desired = R.drawable.round_4; break;
            case 5: r_desired = R.drawable.round_5; break;
            case 6: r_desired = R.drawable.round_6; break;
            case 7: r_desired = R.drawable.round_7; break;
        }
        return ContextCompat.getDrawable(this, r_desired);
    }

    /**
     * Actualitza les letters chosen pel player
     */
    private void refreshLettersChosen(){
        lettersChosen.setText(gameViewModel.getGame().lettersChosen());
    }

    /**
     * Actualitza les imatges del penjat
     */
    private void refreshHangmanImages(){
        ivState.setImageDrawable(getDrawableFromState(gameViewModel.getGame().getCurrentRound()));
    }

    /**
     * Afegeix la lletra al joc
     */
    private void newLetter(){
        String novaLletra = etNewLetter.getText().toString().toUpperCase();
        etNewLetter.setText("");

        int validLetter = gameViewModel.addLetter(novaLletra);
        if (validLetter != Game.LETTER_VALIDATION_OK){
            Log.d(Game.TAG, "Lletra no vàlida");
            if (validLetter == Game.LETTER_VALIDATION_NO_VALID_BECAUSE_ALREADY_SELECTED){
                Toast.makeText(this, R.string.notValidBecauseAlreadyChoosen, Toast.LENGTH_SHORT ).show();
            }
            if (validLetter == Game.LETTER_VALIDATION_NO_VALID_BECAUSE_SIZE){
                Toast.makeText(this, R.string.notValidBecauseSize, Toast.LENGTH_SHORT ).show();
            }
        }
        Log.d(Game.TAG, "Estat actual: " + gameViewModel.getGame().getCurrentRound());

        refreshLettersChosen();
        refreshHangmanImages();
        hideKeyboard();
        checkGameOver();
    }

    /**
     * Revisa si el joc ha acabat i informa via Log (de moment)
     */
    private void checkGameOver(){

        // variable actualment sense us..
        boolean playerWinner = false;

        if (gameViewModel.getGame().isPlayerTheWinner()){
            Log.d(Game.TAG, "El jugador ha guanyat!");
            playerWinner = true;
        }

        if (gameViewModel.getGame().isGameOver()){
            Log.d(Game.TAG, "El Joc ha acabat");
            btnNewLetter.setEnabled(false);
            etNewLetter.setEnabled(false);
            finish();
            Intent i = new Intent(this, EndGameActivity.class);
            i.putExtra("gameWin", playerWinner);
            startActivity(i);}
    }

    /**
     * Inicia el joc i actualitza l'activitat
     */
    private void startGame(){
        gameViewModel.startGame();
        refreshLettersChosen();
        refreshHangmanImages();
    }

    /* -------- METODES AUXILIARS --------- */

    /**
     * Amaga el teclat virtual de la pantalla
     */
    private void hideKeyboard(){
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Fa que la lletra introduida sempre sigui en majúscules
     * (i manté els altres filtres existents)
     */
    private void setInputLetterAlwaysUppercase() {
        InputFilter[] editFilters = etNewLetter.getFilters();
        InputFilter[] newFilters = new InputFilter[editFilters.length + 1];
        System.arraycopy(editFilters, 0, newFilters, 0, editFilters.length);
        newFilters[editFilters.length] = new InputFilter.AllCaps();
        etNewLetter.setFilters(newFilters);
    }
}