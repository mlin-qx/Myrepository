package org.imooc.util;

import org.apache.commons.fileupload.FileItem;

import java.io.File;

public class FileUtils {
    private static final String SAVE_PATH="d:/upload";
    public String save(FileItem fileItem, String path) throws Exception {
        String fileName = fileItem.getName() +"_"+System.currentTimeMillis();
        fileItem.write( new File( path+ fileName) );
        return fileName;
    }
}
