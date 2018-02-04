package seichitournament;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * ゲーム管理クラス
 * @author karayuu
 */
public class GameManager {
    /** エラーを送信するプレイヤー(コマンド送信者) */
    PlayerWarningExtension sender;

    /** チームを管理するMap */
    Map<Integer, Team> teamMap;

    /**
     * コンストラクタ
     * @param commandSender コマンドを送信したプレイヤー
     * @param teamNum チームの最大数
     * @param teamMax 1チームあたりの最大人数
     */
    GameManager(Player commandSender, int teamNum, int teamMax) {
        this.sender = new PlayerWarningExtension(commandSender);
        this.teamMap = new HashMap<>();
        for (int i = 1; i <= teamNum; i++) {
            this.teamMap.put(i, new Team(teamMax));
        }
    }

}
