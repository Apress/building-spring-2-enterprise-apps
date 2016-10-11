package com.apress.springbook.chapter09.web.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Node;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import org.springframework.core.io.Resource;

import org.springframework.web.servlet.view.xslt.AbstractXsltView;

public class XmlView extends AbstractXsltView {

  protected Node createDomNode(Map model,
                               String root,
                               HttpServletRequest request,
                               HttpServletResponse response)
   throws Exception {
    Resource resource = (Resource) model.get("xmlResource");
    SAXBuilder builder = new SAXBuilder();
    Document doc = builder.build(resource.getInputStream());
    return new org.jdom.output.DOMOutputter().output(doc);
  }
}
