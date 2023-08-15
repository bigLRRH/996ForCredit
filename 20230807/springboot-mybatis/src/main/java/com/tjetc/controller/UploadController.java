package com.tjetc.controller;

import com.tjetc.common.FileUploadUtils;
import com.tjetc.common.ImageInfo;
import com.tjetc.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {
    //@Autowired
    //private UserConstants userConstants;

    @Autowired
    private ImageInfo imageInfo;

    @RequestMapping("file")
    public JsonResult uploadFile(@RequestParam("file") MultipartFile file) {
        //使用配置的上传的文件存储基础路径
        String basePath = "d:/temp";
        return FileUploadUtils.upload(file, basePath, "file");
    }

    @RequestMapping("image")
    public JsonResult uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        //使用配置图片的文件存储基础路径
//        String basePath = "d:/temp";
//        return FileUploadUtils.upload(imageFile, basePath,"image");
        String basePath = imageInfo.getBasePath();
        return FileUploadUtils.upload(imageFile, basePath, "image");
    }


    @RequestMapping("video")
    public JsonResult uploadVideo(@RequestParam("videoFile") MultipartFile videoFile) {
        //使用配置视频的文件存储基础路径
        String basePath = "d:/temp";
        return FileUploadUtils.upload(videoFile, basePath, "video");
    }

}
