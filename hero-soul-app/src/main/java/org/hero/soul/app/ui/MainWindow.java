package org.hero.soul.app.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.hero.soul.app.event.PrintHandler;
import org.hero.soul.app.ui.enums.LayoutEnum;

public class MainWindow extends JFrame {
    
    private static final long serialVersionUID = -7087676010480993430L;
    public static JTextArea textArea = new JTextArea();
    String[] options;
    public MainWindow() {
        super("末世日记");
        this.setBounds(LayoutEnum.FRAME.getX(), LayoutEnum.FRAME.getY(), LayoutEnum.FRAME.getWidth(), LayoutEnum.FRAME.getHeight());
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ======文本域设置 start =====
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
        
        this.addKeyListener(new KeyListener() {
            
            public void keyTyped(KeyEvent e) {
                
            }
            
            public void keyReleased(KeyEvent e) {
                
            }
            
            public void keyPressed(KeyEvent e) {
                
            }
        });
        this.requestFocus(); // 将焦点定位到此窗口，否则按钮监听无效
        // 必须在所有的界面定义后，否则部分内容不显示
        this.setVisible(true);
    }
    
    public void doOption(String[] options){
        this.options = options;
        textArea.append(PrintHandler.getOptions(new String[]{"新游戏", "继续游戏", "设置", "退出游戏"}) + "\n");
        
    }

}
