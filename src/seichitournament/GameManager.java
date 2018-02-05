package seichitournament;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * ゲーム管理クラス
 * @author karayuu
 */
class GameManager {
    /** エラーを送信するコマンド送信者 */
    private PlayerWarningExtension sender;

    /** チームを管理するMap */
    private Map<Integer, Team> teamMap;

    /** どのチームにも所z串内プレイヤーの溜まり場 */
    private List<String> noTeamPlayer = new ArrayList<>();

    /** チームの最大数 */
    private int teamMax;

    /**
     * コンストラクタ
     * @param commandSender コマンドを送信したプレイヤー
     * @param teamNum チームの最大数
     * @param teamMax 1チームあたりの最大人数
     */
    GameManager(CommandSender commandSender, int teamNum, int teamMax) {
        this.sender = new PlayerWarningExtension(commandSender);
        this.teamMap = new HashMap<>();
        this.teamMax = teamMax;
        for (int i = 1; i <= teamNum; i++) {
            this.teamMap.put(i, new Team(teamMax));
        }
    }


    /**
     * Ymlからプレイヤーチームを取得し、チームを準備します。
     * @param fc FileConfiguartion
     */
    void SyncFromYml(FileConfiguration fc) {
        List<String> playerList = fc.getStringList("member");

        for (String playerName : playerList) {
            if (fc.getInt(playerName) == 0) {
                //チーム番号が0の時はぽい
                noTeamPlayer.add(playerName);
                return;
            }

            Team team = teamMap.get(fc.getInt(playerName));
            if (team == null) {
                //そもそもチームが存在しない。
                sender.sendWarning("プレイヤー[" + playerName + "]のチーム指定番号が不正な値です。");
                return;
            }

            if (team.addPlayersSafely(playerName)) {
                //重複＆満員チェック
                sender.sendWarning("プレイヤー[" + playerName + "はチーム[No." + fc.getInt(playerName) + "]にすでに参加済みか,"
                    + "チーム[No." + fc.getInt(playerName) + "]が満員です");
            }
        }
    }

    /*
    private List<String> getMembersList() {
        List<String> playersList = new ArrayList<>();
        for (Map.Entry<Integer, Team> entry : teamMap.entrySet()) {
            playersList.addAll(entry.getValue().getPlayersList());
        }
        return playersList;
    }

    String getAllMembers() {
        StringBuilder shapingStr = new StringBuilder();
        List<String> playersList = getMembersList();
        for (String playerName : playersList) {
            shapingStr.append(" ").append(playerName);
        }
        return shapingStr.toString();
    }
    */

    /**
     * 各チームのプレイヤーを全員表示させます。
     * @param sender 送信する対象
     */
    void sendPlayers(CommandSender sender) {
        for (Map.Entry<Integer, Team> entry : teamMap.entrySet()) {
            sender.sendMessage(entry.getKey() + " : " + entry.getValue().getShapedPlayerName());
        }
    }

    /**
     * 該当するチームNo.のプレイヤーを表示させます。
     * 該当するチームNo.が存在しない場合、警告メッセージを送信します。
     * @param sender 送信する対象
     * @param teamNum チームNo.
     */
    void sendPlayersAtTeamNum(CommandSender sender, int teamNum) {
        if (teamNum > teamMax) {
            sender.sendMessage(ChatColor.RED + "[ERROR]チーム番号が不正です。");
            return;
        }
        sender.sendMessage("チームNo." + teamNum + " : " + teamMap.get(teamNum).getShapedPlayerName());
    }
}
