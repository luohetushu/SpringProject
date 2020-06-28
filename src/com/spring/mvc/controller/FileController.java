package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件上传处理控制器：获取并处理文件
 */
@Controller
public class FileController {

    /**
     * 获取并处理单个文件
     * @param file  用来获取客户端上传的单个文件 todo 注解参数值应与表单中 <input type="file" name="file"/> 的 name 一致
     * @param content 用来获取表单中填写的内容 todo 注解参数值应与表单中 <input type="text" name="content"/> 的 name 一致
     * @param request
     */
    @RequestMapping("/upload/file.form")
    public void uploadFile(@RequestParam("file") CommonsMultipartFile file,
                           @RequestParam("content") String content,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        //获取上传文件的文件名
        String fileName = file.getOriginalFilename();
        System.out.println("fileName: " + fileName);
        //获取上传文件的输入流 todo 获取到输入流，还不知道怎么读取文件或者输出文件嘛。。
        //InputStream is = file.getInputStream();

        //保存的路径，如果父路径不存在需要手动创建或者代码创建
        String path = request.getServletContext().getRealPath("file-upload" + File.separator + fileName);
        System.out.println("path: " + path);

        //保存的目标文件
        File dest = new File(path);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        //保存文件到指定路径文件
        file.transferTo(dest);

        //
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().print("文件保存成功");

    }

    /**
     * 获取并处理多个文件
     * @param files  用来获取客户端上传的多个文件 todo 注解参数值应与表单中 <input type="file" name="file"/> 的 name 一致
     * @param request
     */
    @RequestMapping("/upload/files.form")
    public void uploadFiles(@RequestParam("file") CommonsMultipartFile[] files,
                           HttpServletRequest request, HttpServletResponse response) throws Exception{

        for (CommonsMultipartFile file: files) {
            //获取上传文件的文件名
            String fileName = file.getOriginalFilename();
            System.out.println("fileName: " + fileName);
            //获取上传文件的输入流 todo 获取到输入流，还不知道怎么读取文件或者输出文件嘛。。
            //InputStream is = file.getInputStream();
            //保存的路径，如果父路径不存在需要手动创建或者代码创建
            String path = request.getServletContext().getRealPath("file-upload" + File.separator + fileName);
            System.out.println("path: " + path);

            //保存的目标文件
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }


            //保存文件到指定路径文件
            file.transferTo(dest);
        }

        //
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().print("文件保存成功");

    }



}
