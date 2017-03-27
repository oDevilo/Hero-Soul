package org.hero.soul.app.game;

import java.util.ArrayList;
import java.util.List;

import org.hero.soul.app.event.EventHandler;
import org.hero.soul.app.event.option.Option;
import org.hero.soul.app.event.option.OptionEvent;
import org.hero.soul.app.event.response.NewGameResponse;
import org.hero.soul.app.ui.MainWindow;
import org.hero.soul.model.career.Warrior;
import org.hero.soul.model.enemy.Crawler;

/**
 * 游戏主类
 */
public class Game {

    public static Warrior user;

    public static Crawler monster;

    private static boolean isWin = false;

    public static boolean flag = false;

    public void initGame() {
        user = new Warrior();
        monster = new Crawler();
        MainWindow.init();
        List<Option> options = getMenuOptions();
        MainWindow.addEvent(new OptionEvent(options));
    }
    
    // 菜单
    public List<Option> getMenuOptions(){
        List<Option> options = new ArrayList<Option>();
        Option newGame = new Option();
        newGame.setText("新游戏");
        newGame.setEvent(new NewGameResponse());
        options.add(newGame);
        Option loadGame = new Option();
        loadGame.setText("继续游戏");
        options.add(loadGame);
        Option setting = new Option();
        setting.setText("设置");
        options.add(setting);
        Option endGame = new Option();
        endGame.setText("退出游戏");
        options.add(endGame);
        return options;
    }

//    public static void startGame() {
//        int userProgressBar = initProgressBar(user.getSpd(), monster.getSpd());
//        int monsterProgressBar = initProgressBar(user.getSpd(), monster.getSpd());
//
//        while (!isWin) {
//            userProgressBar = userProgressBar - user.getSpd();
//            if (userProgressBar <= 0) {
//                // 玩家操作
//                MainWindow.textArea.append("你的回合,请输入操作指令:\n");
//               //  MainWindow.textArea.append(PrintHandler.getOptions(new String[] { "攻击", "防御" }) + "\n");
//                synchronized (MainWindow.textArea) {
//                    // 等待用户操作
//                    try {
//                        if (monster.getHp() <= 0) {
//                            isWin = true;
//                            MainWindow.textArea.notifyAll();
//                            break;
//                        }
//                        if (!flag) {
//                            flag = true;
//                            MainWindow.textArea.notify();
//                            MainWindow.textArea.wait();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//            }
//
//            monsterProgressBar = monsterProgressBar - monster.getSpd();
//            if (monsterProgressBar <= 0) {
//                // 怪物操作
//                user.setHp(user.getHp() - monster.getAtk());
//                MainWindow.textArea.append("怪物对你造成了" + monster.getAtk() + ",你剩余血量" + user.getHp() + "\n");
//                if (user.getHp() <= 0) {
//                    break;
//                }
//            }
//        }
//        if (isWin) {
//            MainWindow.textArea.append("游戏结束,你胜利了!");
//        } else {
//            MainWindow.textArea.append("游戏结束,你被怪物吃掉了!");
//        }
//
//    }

    public static int initProgressBar(int userSpd, int monsterSpd) {
        return userSpd * monsterSpd;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initGame();
    }

}
