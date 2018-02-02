package seichitournament.teams;

/**
 * Created by karayuu on 2018/01/28
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */

import org.bukkit.*;
import org.bukkit.entity.*;
import seichitournament.*;

import java.util.*;

/**
 * チームクラス
 */
public class Team {
    /**
     * チーム最大人数
     */
    private int teamMax;
    /**
     * チームメンバー
     */
    private List<String> teamList;

    /**
     * コンストラクタ
     *
     * @param teamMax  チームの最大人数
     * @param teamList チームメンバーリスト(Player型)
     */
    Team(int teamMax, List<String> teamList) {
        this.teamMax = teamMax;
        this.teamList = teamList;
    }

    /**
     * チームの最大人数を取得します
     *
     * @return チーム最大人数
     */
    public int getTeamMax() {
        return teamMax;
    }

    /**
     * チームのメンバーのリストを取得します
     *
     * @return チームメンバーのリスト
     */
    public List<String> getTeamList() {
        return teamList;
    }

    /**
     * チームにプレイヤーを参加できるかどうかのステータスreasonEnumを返します。
     *
     * @return 該当するreasonEnum
     */
    public reason canAddTeammate(String player) {
        if (teamList.size() + 1 > teamMax) {
            return reason.OUT_OF_BOUNDS;
        } else if (teamList.contains(player)) {
            return reason.ALREADY_CONTAINS;
        }
        return reason.TRUE;
    }

    public boolean addTeammateSafety(String player, Player commandSender) {
        if (canAddTeammate(player) == reason.TRUE) {
            teamList.add(player);
            return true;
        } else {
            return false;
        }
    }
    /**
     * チーム参加時のエラーメッセージ＆ステートenum
     */
    public enum reason {
        OUT_OF_BOUNDS(ChatColor.RED + "(#team)チームの上限に達したため、プレイヤーを追加できませんでした。"),
        ALREADY_CONTAINS(ChatColor.RED + "プレイヤーは既に(#team)チームに参加しています"),
        TRUE("");

        /**
         * エラーメッセージ
         */
        private String errorMsg;

        /**
         * コンストラクタ
         *
         * @param errorMsg : 表示すべきエラーメッセージ
         */
        reason(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        /**
         * エラーメッセージを取得します。Prefix(#team)も置き換えます
         *
         * @return エラーメッセージ
         */
        public String getErrorMsg(int teamNum) {
            return Util.replacePrefix(this.errorMsg, teamNum);
        }
    }
}
