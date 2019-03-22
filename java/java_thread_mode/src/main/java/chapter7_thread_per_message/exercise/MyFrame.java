package chapter7_thread_per_message.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: MyFrame
 * @description: 测试窗口程序
 * @author: lian.zh
 * @create: 2019-01-22 09:59
 */
public class MyFrame extends JFrame implements ActionListener {

    private ServiceThread serviceThread = new ServiceThread();

    public MyFrame() throws HeadlessException {
        super("My Frame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Thread-Per-Message Sample"));
        JButton button = new JButton("Execute");
        getContentPane().add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Service.service();
        serviceThread.service();
    }
}
