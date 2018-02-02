package seichitournament;

/**
 * Created by karayuu on 2018/01/28
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */

import org.bukkit.configuration.file.*;
import org.omg.PortableInterceptor.*;

import java.util.*;

/**
 * コンフィグ関連クラス
 */
public class Config {
    /** プラグインのインスタンス */
    private SeichiTournament plugin;

    /** FileConfigurationのインスタンス */
    private FileConfiguration fc;

    /**
     * コンストラクタ
     * @param plugin SeichiTournamentクラスのインスタンス
     */
    Config(SeichiTournament plugin) {
        this.plugin = plugin;
        this.fc = plugin.getConfig();
    }

    /**
     * 1チーム当たりの最大人数を取得します
     * @return 1チーム当たりの最大人数
     */
    public int getMemberMax() {
        return fc.getInt("MemberMax");
    }

    /**
     * 1ゲーム当たりのゲーム時間を取得します
     * @return 1ゲーム当たりの時間
     */
    public int getGameTime() {
        return fc.getInt("GameTime");
    }

    /**
     * ゲーム内での特別イベントを発生させるかどうかを取得します
     * @return true: 発生する / false: 発生させない
     */
    public Boolean isEventMode() {
        return fc.getBoolean("EventMode");
    }

    /**
     * プレイヤー名を取得します。
     * @return プレイヤー名List
     */
    public List<?> getPlayerNameList() {
        return fc.getStringList("member");
    }

    /**
     * 該当プレイヤーのチーム番号を取得します。
     * @param playerName 該当プレイヤーの名前
     * @return (configに存在しない場合) 0 / (存在する場合) チーム番号
     */
    public int getTeamNumber(String playerName) {
        if (fc.contains(playerName)) {
            fc.getInt("member." + playerName);
        }
        return 0;
    }
}
