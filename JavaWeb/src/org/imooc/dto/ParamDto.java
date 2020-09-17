package org.imooc.dto;

import org.apache.commons.fileupload.FileItem;
import java.util.HashMap;

public class ParamDto {

    private HashMap<String,String> paramMap = new HashMap<>();
    private HashMap<String,FileItem> fileMap = new HashMap<>();

    public HashMap<String, String> getParamMap() {
        return paramMap;
    }

    public void setParamMap(HashMap<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public HashMap<String, FileItem> getFileMap() {
        return fileMap;
    }

    public void setFileMap(HashMap<String, FileItem> fileMap) {
        this.fileMap = fileMap;
    }
}
