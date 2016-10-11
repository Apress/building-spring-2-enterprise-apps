package com.apress.springbook.chapter09.web.view;

import java.util.Map;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.apress.springbook.chapter09.Member;

public class MatchPdfView extends AbstractPdfView {

  protected void buildPdfDocument(Map model,
                                  Document document,
                                  PdfWriter writer,
                                  HttpServletRequest request,
                                  HttpServletResponse response)
   throws Exception {
    document.addTitle("Members");
    List<Member> memberList = (List<Member>) model.get("memberList");
    for  (Member member : memberList) {
      document.add(new Paragraph(member.getName().getLast() + ", " + 
        member.getName().getFirst()));
    }
  }
}
