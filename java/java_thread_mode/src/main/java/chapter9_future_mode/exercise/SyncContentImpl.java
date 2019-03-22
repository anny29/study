package chapter9_future_mode.exercise;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: SyncContentImpl
 * @description: 练习 9-3 同步获取URL内容
 * @author: lian.zh
 * @create: 2019-02-13 10:21
 */
@Slf4j
public class SyncContentImpl implements Content {

    private byte[] contentBytes;

    public SyncContentImpl(String urlStr) {
        log.info("开始获取URL:{}中的数据", urlStr);
        try {
            URL url = new URL(urlStr);
            try (DataInputStream in = new DataInputStream(url.openStream())) {
                byte[] buffer = new byte[1];
                int index = 0;
                try {
                    while (true) {
                        int c = in.readUnsignedByte();
                        if (buffer.length <= index) {
                            byte[] largerBuffer = new byte[buffer.length * 2];
                            System.arraycopy(buffer, 0, largerBuffer, 0, index);
                            buffer = largerBuffer;
                        }
                        buffer[index++] = (byte) c;
                    }
                } catch (EOFException eof) {
                    log.info("URL:{}中的流读取完毕", urlStr);
                }
                contentBytes = new byte[index];
                System.arraycopy(buffer, 0, contentBytes, 0, index);

            }  catch (IOException e) {
                log.error("获取URL：{}的流异常：{}", urlStr, e.getMessage());
            }

        } catch (MalformedURLException e) {
            log.error("URL：{} 解析报错，报错异常：{}", urlStr, e.getMessage());
        }
    }

    @Override
    public byte[] getBytes() {
        return contentBytes;
    }
}
