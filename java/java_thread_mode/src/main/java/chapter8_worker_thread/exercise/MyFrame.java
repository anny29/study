package chapter8_worker_thread.exercise;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

/**
 * @program: MyFrame
 * @description: 习题8-5 测试数字展示
 * @author: lian.zh
 * @create: 2019-01-24 15:24
 */
@Slf4j
public class MyFrame extends JFrame implements ActionListener {

    private final JLabel label = new JLabel("Event Dispatching Thread Sample");
    private final JButton button = new JButton("countUp");

    public MyFrame() throws HeadlessException {
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        getContentPane().add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            countUp();
        }

    }

    private void countUp() {
        /*for (int i = 0; i < 10; i++) {
            log.info("{}:countUp:setText({})", Thread.currentThread().getName(), i);
            label.setText("" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("睡眠异常！", e);
            }
        }*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    log.info("{}:countUp:setText({})", Thread.currentThread().getName(), i);
                    final int index = i;
                    try {
                        SwingUtilities.invokeAndWait(new Runnable() {
                            @Override
                            public void run() {
                                label.setText("" + index);
                            }
                        });
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        log.error("睡眠异常！", e);
                    } catch (InvocationTargetException e) {
                        log.error("调用异常！", e);
                    }
                }
            }
        }).start();
    }
}
