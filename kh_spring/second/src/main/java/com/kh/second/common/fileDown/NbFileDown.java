package com.kh.second.common.fileDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component("nbfiledown")
public class NbFileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Map<String, Object> fileInfo = (Map<String, Object>) model.get("downFile");
		
		String savePath = (String) fileInfo.get("savePath");
		String ofileName = (String) fileInfo.get("ofileName");
		String rfileName = (String) fileInfo.get("rfileName");
		String ecdofileName = URLEncoder.encode(ofileName, "utf-8").replaceAll("\\+", "%20");
		
		File file = new File(savePath + "\\" + rfileName);
		
		response.setContentType("text/plain; charset=utf-8");
		
		response.addHeader("Content-Disposition", "attachment; filename=\""
				+ new String(ecdofileName.getBytes("utf-8"),"ISO-8859-1")+"\"");
		
		response.setContentLength((int)file.length());

		OutputStream out = response.getOutputStream();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if(fis != null)
				try {
					fis.close();
				} catch(IOException ex) {
				}
		}
		out.flush();
		
	}
	
}
