package org.hero.soul.app.game;

import java.util.List;

import org.hero.soul.app.event.option.Option;
import org.hero.soul.app.event.option.OptionEvent;
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
        List<Option> options = MenuOptions.getMenuOptions();
        MainWindow.addEvent(new OptionEvent(options));
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
