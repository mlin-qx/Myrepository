package org.imooc.servlet;

import org.imooc.dto.ExcelParamDto;
import org.imooc.dto.ExcelResultDto;
import org.imooc.dto.ParamDto;
import org.imooc.service.ExcelService;
import org.imooc.util.RequestUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class importExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParamDto dto = RequestUtil.paramParse( req );
        ExcelParamDto paramDto = new ExcelParamDto();
        paramDto.setTitle( dto.getParamMap().get( "title" ) );
        paramDto.setTitle( dto.getParamMap().get( "excel" ) );
        ExcelService excelService = new ExcelService();
        ExcelResultDto result = excelService.imp( paramDto );
        req.setAttribute( "result",result );
        req.getRequestDispatcher( "/WEB-INF/jsp/importExcelResult.jsp").forward( req,resp );
    }
}
