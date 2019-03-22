package chapter10_two_phase_termination.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @program: MyFrame
 * @description: 练习10-5
 * @author: lian.zh
 * @create: 2019-03-06 10:14
 */
public class MyFrame extends JFrame implements ActionListener {

    private final JButton executeButton = new JButton("Execute");
    private final JButton cancelButton = new JButton("Cancel");
    private final Service service = new Service();

    public MyFrame() throws HeadlessException {
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(new JLabel("Two-Phase Termination Sample"));
        getContentPane().add(executeButton);
        getContentPane().add(cancelButton);
        executeButton.addActionListener(this);
        cancelButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == executeButton) {
            service.service();
        } else if (e.getSource() == cancelButton) {
            service.cancel();
        }
    }
}
