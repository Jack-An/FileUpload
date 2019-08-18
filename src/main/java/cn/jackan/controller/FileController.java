package cn.jackan.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/fileupload1")
    public String fileUpload1(HttpServletRequest req) throws Exception {
        System.out.println("文件上传。。。");
        //使用Fileupload来解析文件
        //文件上传的位置
        String path = req.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        //解析request对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);


        System.out.println("开始写入文件");
        //
        List<FileItem> items = upload.parseRequest(req);
        for (FileItem item : items) {
            //判断当前item是否是上传文件项
            if (!item.isFormField()) {
                //文件项
                //获取上传文件的名称
                String filename = item.getName();
                int idx = filename.lastIndexOf("\\");
                filename = filename.substring(idx + 1);
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
//                System.out.println(filename);
//                System.out.println(filename);
//                System.out.println(path);
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();
            }
        }

        return "success";
    }


    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest req, MultipartFile upload) throws IOException {
        String path = req.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String filename = upload.getOriginalFilename();
        System.out.println(filename);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        upload.transferTo(new File(path, filename));
        return  "success";
    }


}
