package com.apress.springbook.chapter09.web.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WritableWorkbook;
import jxl.write.WritableSheet;
import jxl.write.Label;

import org.springframework.web.servlet.view.document.AbstractJExcelView;

public class MatchExcelView extends AbstractJExcelView {

    

  protected void buildExcelDocument(Map model,
                                     WritableWorkbook workbook,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
   throws Exception {
    WritableSheet sheet = workbook.createSheet(
            "Sheet 1", workbook.getNumberOfSheets());

    sheet.addCell(new Label(0, 0, "This is a sample label"));
  }
}
