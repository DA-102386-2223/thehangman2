/**
 * Aquesta classe només és interessant pel requeriment d'ampliació 3
 * Si no estas fent aquest requeriment pots obviar-la
 * Aquesta classe es del model i hauria d'estar a /models
 * Però per usos pedagògics, totes les classes del requeriment ampliació 3 estan agrupades
 */

package cat.udl.gtidic.course2223.teacher.thehangman.helpers;

import java.util.Date;

public class MatchOnline {
    public int currentRound;
    public String lettersChosenStr;
    public Boolean playerWon;
    public String secretWord;
    public Date time;
    public String userEmail;

    /**
     * Constructor per crear les entitats al guardar el joc
     * @param currentRound currentRound
     * @param lettersChosenStr lettersChosenStr
     * @param playerWon playerWon
     * @param secretWord secretWord
     * @param time time
     * @param userEmail userEmail
     */
    public MatchOnline(int currentRound, String lettersChosenStr, Boolean playerWon, String secretWord, Date time, String userEmail) {
        this.currentRound = currentRound;
        this.lettersChosenStr = lettersChosenStr;
        this.playerWon = playerWon;
        this.secretWord = secretWord;
        this.time = time;
        this.userEmail = userEmail;
    }

    /**
     * Constructor per Realtime Firebase
     */
    @SuppressWarnings("unused")
    public MatchOnline() {}
}
