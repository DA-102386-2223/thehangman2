/**
 * Aquesta classe només és interessant pel requeriment d'ampliació 3
 * Si no estas fent aquest requeriment pots obviar-la
 */

package cat.udl.gtidic.course2223.teacher.thehangman.helpers;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;

public class MatchOnlineProvider {
    private static final List<MatchOnline> matchesOnlineList = new ArrayList<>();
    private static RecyclerView.Adapter adapter;

    public static List<MatchOnline> getList(){
        return matchesOnlineList;
    }

    /**
     * Ens guardem l'adapter per actualitzar la llista
     * @param adapter RecyclerView Adapter a actualitzar
     */
    public static void setAdapter(RecyclerView.Adapter adapter){
        MatchOnlineProvider.adapter = adapter;
    }

    public static void updateFromFirebase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Game.FB_REALTIME_DB);
        DatabaseReference matchesReference = database.getReference().child("matches");

        matchesReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                updateList(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Provider", "Problemes de connexio");
            }
        });
    }

    /**
     * S'encarrega de rebre l'snapshot des del firebase i emplenar i actualitzar la llista de l'adapter
     * Mètode ja implementat, es pot utilitzar i en principi no cal que sigui modificat
     * @param snapshot snapshot rebut de la crida a firebase
     */
    private static void updateList(DataSnapshot snapshot) {
        matchesOnlineList.clear();
        for (DataSnapshot matchOnlineSnapshot : snapshot.getChildren()){
            MatchOnline matchOnline = matchOnlineSnapshot.getValue(MatchOnline.class);
            matchesOnlineList.add(matchOnline);
        }
        adapter.notifyDataSetChanged();
    }
}
