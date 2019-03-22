package chapter9_future_mode.exercise;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: Main
 * @description: 练习9-3 测试类
 * @author: lian.zh
 * @create: 2019-02-13 11:27
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Main begin.");
        Content content1 = Retriever.retrieve("http://eip.ccb.com/");
        Content content2 = Retriever.retrieve("http://zhyq.ccb.com:8008/dco/page/main/c_index.html");
        Content content3 = Retriever.retrieve("http://buy.ccb.com/");

        saveToFile("eip.html", content1);
        saveToFile("library.html", content2);
        saveToFile("buy_ccb.html", content3);
        log.info("Main End.");
    }

    private static void saveToFile(String fileName, Content content) {
        byte[] contentBytes = content.getBytes();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            out.write(contentBytes);
            out.flush();
            log.info("文件：{}创建完毕！", fileName);
        } catch (FileNotFoundException e) {
            log.error("文件创建异常", e);
        } catch (IOException e) {
            log.error("文件写入异常", e);
        }
    }
}
