package com.whz.myblog.controller;

import com.whz.myblog.utils.Result;
import com.whz.myblog.utils.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 卫宏哲
 * @date 2020/3/9 17:58
 */
@RestController
@RequestMapping(value = "upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    /**
     * 作上传
     */
    @RequestMapping("/uploadImage")
    public Result<String> uploadImage(MultipartFile file) {
        String url = uploadService.uploadImage(file);
        return new Result<>("上传成功！", url);
    }
}