package com.jumaojiang.utils;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
public class FileRenameUtil {

    public static String fileRename(MultipartFile file){
        String replace = UUID.randomUUID().toString().replace("-", "");
        String substring = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        return replace + substring;
    }
}
