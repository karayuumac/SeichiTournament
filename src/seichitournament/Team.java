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
     * @param playerName 参加させるプレイヤー名
     * @return true: 参加可能(実際に参加させた) / false: 参加不可能
     */
    public boolean addPlayersSafely(String playerName) {
        if (canAddPlayerToTeam() && !hasDuplication(playerName)) {
            players.add(playerName);
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

    /**
     * プレイヤーが既にチームに参加しているかを返します。
     * @param addPlayerName 参加すると予想されるプレイヤー名
     * @return true: 重複する(既に参加) / false: 重複しない
     */
    private boolean hasDuplication(String addPlayerName) {
        for (String checkName : players) {
            if (checkName.equals(addPlayerName)) return true;
        }
        return false;
    }
}
