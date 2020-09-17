package org.imooc.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.imooc.dto.ParamDto;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

public class RequestUtil  {
    public static ParamDto paramParse(HttpServletRequest req) {
        ParamDto paramDto = new ParamDto();
        ServletFileUpload upload = new ServletFileUpload( new DiskFileItemFactory() );
        upload.setHeaderEncoding( "UTF-8" );
            try {
                List<FileItem> fileItemList = upload.parseRequest( req );
                for (FileItem fileItem : fileItemList) {
                    if (fileItem.isFormField()) {
                        HashMap<String, String> paramMap = new HashMap<>();
                        paramMap.put( fileItem.getFieldName(), fileItem.getString( "UTF-8" ) );
                        paramDto.setParamMap( paramMap );
                    } else {
                        HashMap<String, FileItem> fileMap = new HashMap<>();
                        fileMap.put( fileItem.getFieldName(), fileItem );
                        paramDto.setFileMap( fileMap );
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return paramDto;
    }
}
