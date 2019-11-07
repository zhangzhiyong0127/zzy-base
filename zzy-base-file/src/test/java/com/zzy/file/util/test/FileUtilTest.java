package com.zzy.file.util.test;

import com.zzy.file.util.FileUtil;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public class FileUtilTest {

    public static void main(String[] args) throws Exception {

        File file = new File("E:/scas-doc/scas_file_download/openacc/开户文件/BATCH_OPEN_20191022_0001.TXT");

        BufferedReader bufferedReader = FileUtil.openBufferReaderFromFile(file, "UTF-8");
        String firstLine = FileUtil.readBatchLineWithReader(bufferedReader, 1).get(0);
        int countLines = Integer.parseInt(firstLine);

        System.err.println(countLines);

        int i = 0;
        for (; i < countLines; ) {
            List<String> lines = FileUtil.readBatchLineWithReader(bufferedReader, 100);
            int readLineNum = lines.size();
            if (readLineNum == 0) {
                //防止死循环
                break;
            }
            for (String line : lines) {
                BatchAccountAccess accountAccess = convertToObject(BatchAccountAccess.class, line);
                System.err.println(accountAccess);
            }
            i = i + readLineNum;
        }

        FileUtil.closeBufferReader(bufferedReader);
    }

    private static <T> T convertToObject(Class<T> clazz, String line) throws Exception {

        String[] filedNames = getFiledNames();

        String[] datas = StringUtils.split(line, "|");

        if (datas.length != filedNames.length) {
            System.err.println("error");
        }

        T instance = clazz.newInstance();

        for (int i = 0; i < datas.length; i++) {
            String data = datas[i];
            Field field = getDeclaredField(clazz, filedNames[i]);
            field.setAccessible(true);
            field.set(instance, ConvertUtils.convert(data, Class.forName(field.getType().getTypeName())));
        }
        return instance;

    }

    private static Field getDeclaredField(Class<?> clazz, String fieldName) throws Exception {
        while (clazz != Object.class) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (Exception e) {
                //这里的异常不能抛出去。
                clazz = clazz.getSuperclass();
            }
        }
        throw new Exception(fieldName + "not exists");
    }

    private static String[] getFiledNames() {

        return new String[]{
                "busiAccessSysNo",
                "busiAccessSerialNo",
                "busiAccessBatchNo",
                "sysAccDate",
                "busiPlatform",
                "accountOrg",
                "marketProduct",
                "mainBodyType",
                "accountType",
                "accountNo",
                "accountName",
                "customerNo",
                "userNo",
                "currency",
                "creditFlag",
                "creditAmt",
                "expiredDate"
        };
    }

}
