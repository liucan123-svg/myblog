package com.xsh.service;

import com.qiniu.common.QiniuException;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;


public interface FileService {
    /**
     * 多文件上传
     * @param file
     * @return
     * @throws QiniuException
     */
    Map uploadFile(File file,String filename) throws QiniuException;

}
