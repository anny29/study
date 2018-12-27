package chapter1_single_thread_execution.gate;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: UserThread
 * @description: 模拟通过门的行人
 * @author: lian.zh
 * @create: 2018-11-20 11:11
 */
@Slf4j
public class UserThread extends Thread {

    private final String myName;
    private final String myAddress;
    private final Gate gate;

    public UserThread(String name, String address, Gate gate) {
        myName = name;
        myAddress = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        log.info("{} BEGIN", myName);
        while (true) {
            gate.pass(myName, myAddress);
        }
    }
}
