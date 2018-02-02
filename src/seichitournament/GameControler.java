package seichitournament;

/**
 * Created by karayuu on 2018/01/31
 * Developer of Gigantic☆Seichi Server
 * Support at dev-basic or dev-extreme channel of Discord
 */

import seichitournament.teams.*;

/**
 * ゲーム管理クラス
 * ※singleton
 */
class GameControler {
    /** SeichiTournamentインスタンス */
    private SeichiTournament plugin;

    /** Configクラス */
    private final Config config = SeichiTournament.config;

    /** 1チームあたりの最大人数 */
    private int teamMax;

    /** ゲーム時間 */
    private int gameTime;

    /** 特殊イベント発生可否 */
    private int isEventMode;

    /** チーム全体クラス */
    private Teams teams = Teams.getInstance();

    public void setup() {
        //チーム全体クラスに初期化＋読み込み指示
        teams.setup(config);
    }

    private GameControler(SeichiTournament plugin) {
        SingletonHolder.plugin = plugin;
    }

    static GameControler getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static SeichiTournament plugin = SeichiTournament.plugin;
        private static final GameControler INSTANCE = new GameControler(plugin);
    }
}
