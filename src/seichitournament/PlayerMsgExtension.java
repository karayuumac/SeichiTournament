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
     * コマンド使用方法を表示させます。
     */
    void sendUsage() {
        receiver.sendMessage("コマンド「seichitourn」は公式イベント「整地大会」用のコマンドです。");
        receiver.sendMessage("「/seichitourn members」：参加者の一覧を表示します。");
        receiver.sendMessage("「/seichitourn addmember」：参加者を追加・チーム移動する為のコマンド");
        receiver.sendMessage("「/seichitourn removemember」：参加者を削除する為のコマンド");
        receiver.sendMessage("「/seichitourn setregion」：チーム情報をサーバに反映します");
        receiver.sendMessage("「/seichitourn teleport」：参加者をテレポートさせます");
        receiver.sendMessage("「/seichitourn gamestart」：試合を開始します");
        receiver.sendMessage("「/seichitourn setting」：試合設定を確認・変更します");
    }
}
