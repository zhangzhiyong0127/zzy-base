package com.zzy.file.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang.zy
 * @Date 2019/10/26
 * @Time 15:32
 */
public class FileUtil {

    /**
     * 打开文件访问通道
     */
    public static BufferedReader openBufferReaderFromFile(File file, String encode) {
        BufferedReader reader;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileInputStream, encode);
            reader = new BufferedReader(input);
        } catch (IOException e) {
            throw new RuntimeException("openBufferReaderFromFile error:" + e.getMessage());
        }
        return reader;
    }

    /**
     * 获取按行读取文件记录
     */
    public static List<String> readBatchLineWithReader(BufferedReader reader, int batchNum) {
        List<String> lines = new ArrayList<String>(batchNum);
        try {
            if (reader != null) {
                String line;
                int count = 0;
                while (count < batchNum && (line = reader.readLine()) != null) {
                    if (line.trim().length() > 0) {
                        lines.add(line);
                        count = count + 1;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("readBatchLineFromReader error:" + e.getMessage());
        }
        return lines;
    }

    /**
     * 关闭文件访问通道
     */
    public static void closeBufferReader(BufferedReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("closeBufferReader error:" + e.getMessage());
            }
        }
    }

}
