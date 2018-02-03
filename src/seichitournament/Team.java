package seichitournament;

import java.util.ArrayList;
import java.util.List;

/**
 * チーム管理クラス
 * @author karayuu
 */
public class Team {
    /** プレイヤーネームの保存用List */
    private List<String> players = new ArrayList<>();

    /** 1チームあたりの最大人数 */
    private int teamMax;

    /**
     * コンストラクタ
     * @param teamMax チームの最大人数
     */
    Team(int teamMax) {
        this.teamMax = teamMax;
    }

    /**
     * 安全にプレイヤーをチームに参加させます。
     * @param playersList 参加させるプレイヤー名
     * @return true: 参加可能(実際に参加させた) / false: 参加不可能
     */
    public boolean addPlayersSafely(List<String> playersList) {
        if (canAddPlayerToTeam()) {
            players.addAll(playersList);
            return true;
        } else {
            return false;
        }
    }

    /**
     * プレイヤーを参加可能かどうかを返します。
     * チーム人数に1でも余りがあった場合,trueを返します。
     * @return true: 参加可能 / false: 参加不可能
     */
    private boolean canAddPlayerToTeam() {
        return players.size() < teamMax;
    }
}
