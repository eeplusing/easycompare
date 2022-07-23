package com.cmbi.tradingmo.bookingbond.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * OTC交易
 *
 * @author cpp
 * @date 2021-11-30
 */
@Api(value = "OTC交易", tags = "OTC交易")
@RestController
@RequestMapping("/compare")
@Slf4j
public class CompareController {

    @GetMapping(value = "/test")
    public void test(HttpServletResponse response){
        List<String> diffString = DiffHandleUtils.diffString("D:\\workspacecmbi\\easycompare\\src\\main\\resources\\ACCOUNT_4-7-2022_1041-26190.csv","D:\\workspacecmbi\\easycompare\\src\\main\\resources\\ACCOUNT_4-7-2022_1041-26191.csv");
        //在F盘生成一个diff.html文件，打开便可看到两个文件的对比
        DiffHandleUtils.generateDiffHtml(diffString,"D:\\workspacecmbi\\easycompare\\src\\main\\resources\\diffjava.html");



        File file = new File("D:\\workspacecmbi\\easycompare\\src\\main\\resources\\diffjava.html");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             OutputStream os = response.getOutputStream();) {
            response.setContentType("text/html;charset=utf-8");

            //response.setHeader("Content-Disposition", "attachment;filename=diff.html");
            byte[] buffer = new byte[1024];
            int bytes = bis.read(buffer);
            while (bytes != -1) {
                os.write(buffer, 0, bytes);
                buffer = new byte[1024];
                bytes = bis.read(buffer);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
