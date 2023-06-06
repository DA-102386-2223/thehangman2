package cat.udl.gtidic.course2223.teacher.thehangman.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;

public class GameViewModel extends ViewModel {
    private MutableLiveData<List<String>> lettersChosen = new MutableLiveData<>();

    public LiveData<List<String>> getLettersChosen() {
        return lettersChosen;
    }

    public void addLetterChosen(String letter) {
        List<String> currentList = lettersChosen.getValue();
        if (currentList == null) {
            currentList = new ArrayList<>();
        }
        currentList.add(letter);
        lettersChosen.setValue(currentList);
    }


    public LiveData<String> getVisibleWord() {
        return visibleWord;
    }

    private final MutableLiveData<String> visibleWord = new MutableLiveData<>();

    public Game getGame() {
        return game;
    }

    Game game;

    public void startGame(){
        game = new Game();
        visibleWord.setValue(game.visibleWord());
    }

    public int addLetter(String novaLletra) {
        int value = game.addLetter(novaLletra);
        visibleWord.setValue(game.visibleWord());
        return value;
    }


}
