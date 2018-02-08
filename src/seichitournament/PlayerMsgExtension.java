package seichitournament;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

/**
 * プレイヤーに警告を表示させるクラスです。
 * @author karayuu
 */

class PlayerMsgExtension {
    /** 警告を表示させる対象 */
    private CommandSender receiver;

    /**
     * コンストラクタ
     * @param receiver 警告を表示させるプレイヤー
     */
    PlayerMsgExtension(CommandSender receiver) {
        this.receiver = receiver;
    }

    /**
     * 警告を表示させます。デフォルトで強調表現([ERROR]+赤文字)になります
     * @param msg 警告メッセージ
     */
    void sendWarning(String msg) {
        receiver.sendMessage(ChatColor.RED + "[ERROR]" + msg);
    }

    /**
     * メッセージを表示させます。
     * #sendWarning(msg)とは異なり強調表示を行いません。
     * @param msg 送信するメッセージ
     */
    void sendMsg(String msg) {
        receiver.sendMessage(msg);
    }
}
