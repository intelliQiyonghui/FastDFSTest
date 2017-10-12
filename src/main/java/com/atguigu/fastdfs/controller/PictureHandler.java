package com.atguigu.fastdfs.controller;

import com.atguigu.fastdfs.utils.FastDFSUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PictureHandler {

    @RequestMapping(value = "/doUpload")
    public String uploadFile(@RequestParam("picTitle") String picTitle,
                             @RequestParam("pictureFile") MultipartFile pictureFile,
                              Model model) throws IOException {
        //设计Utils获取文件扩展名
        if (pictureFile.isEmpty()) {
            return "";
        }
        byte[] bytes;
        String orginFileName = pictureFile.getOriginalFilename();
        bytes = pictureFile.getBytes();
        String[] results = FastDFSUtils.uploadFile(orginFileName, bytes);
        String groupName = results[0];
        String remoteFileName = results[1];
        model.addAttribute("groupName",groupName);
        model.addAttribute("remoteFileName",remoteFileName);
        System.out.println("groupName:"+groupName);
        System.out.println("remoteFileName:"+remoteFileName);
        System.out.println("picTitle:"+picTitle);
        return "success";
    }

}
