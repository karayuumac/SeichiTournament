package seichitournament.teams;


/**
 * Created by karayuu on 2018/01/28
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */

import seichitournament.*;

import java.util.*;

/**
 * チーム管理集合クラス
 * ※singleton
 */
public class Teams {
    /** チームのマップ */
    private Map<Integer, Team> teamMap;

    /** チーム作成上限 */
    private int MaxTeamsAmount;

    private Teams() {

    }

    public void setup(Config config) {

    }

    private Map<Integer, Team> makeTeamsAndLoad(Config config) {

    }

    private Map<Integer, String> getNumberToPlayerNameList(Config config) {
        Map<Integer, Team> result = new HashMap<>();
        List<?> playerNameList = config.getPlayerNameList();
        playerNameList.forEach(name -> {
            int number;
            if (name instanceof String) {
                number = config.getTeamNumber((String) name);
            } else {
                throw new IllegalStateException("Configのmember欄のプレイヤー名はStringで記入してください。");
            }

            if (result.get(number) == null) {
                List<String> teammate = new ArrayList<>();
                teammate.add((String) name);
                result.put(number, new Team(config.getMemberMax(), teammate);
            } else {
                if (result.get(number).canAddTeammate((String) name) == Team.reason.TRUE) {
                    result
                }
            }
        });
    }

    public static Teams getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Teams INSTANCE = new Teams();
    }
}
