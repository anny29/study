package chapter4_balking;

import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: Data
 * @description: 被保护对象
 * @author: lian.zh
 * @create: 2019-01-07 16:47
 */
@Slf4j
public class Data {

    private final String fileNm;
    private String content;
    private boolean changed;

    public Data(String fileNm) {
        this.fileNm = fileNm;
    }

    public synchronized  void change(String text) {
        changed = true;
        content = text;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            log.debug("线程：{}执行save()不满足保存条件，balk返回！", Thread.currentThread().getName());
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        log.info("{}线程调用doSave()，文件内容：{}", Thread.currentThread().getName(), content);
        FileWriter writer = new FileWriter(fileNm);
        writer.write(content);
        writer.flush();
        writer.close();
    }
}
