package com.jumaojiang.controller;

import com.jumaojiang.utils.FileRenameUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * SpringMVC_Practice
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/9/17
 */
@Controller
@RequestMapping("file")
public class FileController {

    @RequestMapping("upload")
    public String upload(HttpServletRequest request, MultipartFile file) throws IOException {
        // 封装了随机uuid生成工具, 实际开发中一般都需要给文件重命名以避免文件名冲突
        String reName = FileRenameUtil.fileRename(file);
        // 创建存储路径
        String realPath = request.getServletContext().getRealPath("/uploadFile");
        File path = new File(realPath);
        if(!path.exists())
            path.mkdir();
        // 存储文件
        file.transferTo(new File(path,reName));
        System.out.println("上传成功: " + realPath + "/" + reName);
        request.setAttribute("file", realPath + "/" + reName);
        return "file/index";
    }

    @ResponseBody
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
        // 指定文件的路径
        String file = request.getParameter("file");
        if(! new File(file).exists())
            throw new Exception("指定路径的文件不存在");
        // 创建响应头信息对象
        HttpHeaders httpHeaders = new HttpHeaders();
        // 标记以流的方式做出响应
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 以附件的形式响应给用户
        String fileName = URLEncoder.encode(file.substring(file.lastIndexOf("/") + 1), "utf-8");
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        // 响应数据
        File file1 = new File(file);
        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<>(FileUtils.readFileToByteArray(file1), httpHeaders, HttpStatus.CREATED);
        return responseEntity;
    }
}
