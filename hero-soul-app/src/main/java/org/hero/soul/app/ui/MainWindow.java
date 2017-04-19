package org.hero.soul.app.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.hero.soul.app.constant.LayoutEnum;
import org.hero.soul.app.event.Event;
import org.hero.soul.app.event.EventHandler;
import org.hero.soul.core.util.ThreadUtils;

/**
 * 
 * 游戏界面
 * 
 * @author Devil
 *
 */
public class MainWindow extends JFrame {

    private static final long serialVersionUID = -7087676010480993430L;
    private static JTextArea textArea;
    private static EventHandler eventHandler;

    public static void init() {
        new MainWindow();
    }

    public MainWindow() {
        super("末世日记");
        setBounds(LayoutEnum.WINDOW.getX(), LayoutEnum.WINDOW.getY(), LayoutEnum.WINDOW.getWidth(), LayoutEnum.WINDOW.getHeight());
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ======文本域设置 start =====
        textArea = new JTextArea();
        textArea.setTabSize(4); // 设置选项卡要扩大到的字符数。
        textArea.setFont(new Font("标楷体", Font.BOLD, 16));
        textArea.setLineWrap(true);// 激活自动换行功能
        textArea.setWrapStyleWord(true);// 激活断行不断字功能
        textArea.setBackground(Color.WHITE); // 文本区域颜色
        textArea.setEnabled(false); // 不可编辑

        JScrollPane talkPane = new JScrollPane(textArea);
        talkPane.setBounds(LayoutEnum.TALK_AREA.getX(), LayoutEnum.TALK_AREA.getY(), LayoutEnum.TALK_AREA.getWidth(), LayoutEnum.TALK_AREA.getHeight());

        add(talkPane);
        // =====文本域设置 end =====

        // 事件相关
        eventHandler = new EventHandler();
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {

            }

            public void keyReleased(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                eventHandler.excuteEvent(e.getKeyCode());
            }
        });
        requestFocus(); // 将焦点定位到此窗口，否则按钮监听无效

        // 必须在所有的界面定义后，否则部分内容不显示
        setVisible(true);
    }

    /**
     * 为窗口添加事件
     * 
     * @param event
     */
    public static void addEvent(Event event) {
        eventHandler.setEvent(event);
    }

    /**
     * 替换文本框内容
     * 
     * @param text
     */
    public static void changeText(String text) {
        textArea.setText(text);
    }

    /**
     * 每隔一段时间连续输出文本
     * 
     * @param texts
     */
    public static void changeText(String[] texts) {
        /**
         * 需要新起一个线程，否则Thread.sleep则选择的是主线程 这样，屏幕会停顿x秒后直接输出所有的信息
         */
        new Thread(new Runnable() {
            public void run() {
                textArea.setText(texts[0]);
                ThreadUtils.sleep(1000);
                for (int i = 1; i < texts.length; i++) {
                    textArea.append(texts[i]);
                    ThreadUtils.sleep(1000);
                }

            }
        }).start();
    }

    /**
     * 文本框追加
     * 
     * @param text
     */
    public static void appendText(String text) {
        textArea.append(text);
    }

}
