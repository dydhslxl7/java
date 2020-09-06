package com.kh.second.fileDown.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("nbfileDown")
public class NbfileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HashMap<String, String> map = (HashMap<String, String>)model.get("map");
		String savePath = map.get("savePath");
		String ofileName = map.get("ofileName");
		String rfileName = map.get("rfileName");
		
		File rfile = new File(savePath + "\\" + rfileName);
		
		response.setContentType("text/plain; charset=utf-8");
		response.addHeader("Content-Dispositon", "attachment; filename=\""
						+ new String(ofileName.getBytes("utf-8"), "ISO-8859-1")+"\"");
		response.setContentLength((int)rfile.length());
		
		OutputStream out = response.getOutputStream();
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(rfile);
			FileCopyUtils.copy(fin, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fin != null) {
				try {
					fin.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		out.flush();
		out.close();
	}
	
}
