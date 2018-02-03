package seichitournament;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * プレイヤーに警告を表示させるクラスです。
 * @author karayuu
 */

public class PlayerWarningExtension {
    /** 警告を表示させるプレイヤー */
    private Player receiver;

    /**
     * コンストラクタ
     * @param receiver 警告を表示させるプレイヤー
     */
    PlayerWarningExtension(Player receiver) {
        this.receiver = receiver;
    }

    /**
     * 警告を表示させます。デフォルトで強調表現(赤文字)になります
     * @param msg 警告メッセージ
     */
    public void sendWarning(String msg) {
        receiver.sendMessage(ChatColor.RED + msg);
    }
}
