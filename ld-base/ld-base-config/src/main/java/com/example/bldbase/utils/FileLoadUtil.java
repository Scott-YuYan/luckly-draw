package com.example.bldbase.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.example.bldbase.exception.BldException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;

@Slf4j
public class FileLoadUtil {

    public static String read(String fileName) {
        String val = "";
        try {
            val = IoUtil.read(new FileInputStream(FileUtil.file(fileName)), CharEncoding.UTF_8);
        } catch (Exception e) {
            //错误处理
            log.error("文件路径读取失败：{}", fileName, e);
            throw new BldException(String.format("文件路径读取失败: %s", fileName));
        }
        return val;
    }
}
