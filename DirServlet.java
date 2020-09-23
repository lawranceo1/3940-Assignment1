/**
 * @author Brian Duong
 * @version 2020
 */

import java.io.*;

public class DirServlet {

	public void doGet(HttpRequest request, HttpResponse response)
			 {
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		String topPart = "<!DOCTYPE html><html><body><ul>";
		String bottomPart = "</ul></body></html>";
		response.setBody(topPart+getListing("C:\\" + request.getParameter())+bottomPart);
	}

	private String getListing(String path) {
		String dirList =  "";
		File dir = new File(path);
		String[] chld = dir.list();
		for(int i = 0; i < chld.length; i++){
			if ((new File(path+chld[i])).isDirectory())
				dirList += "<li><button type=\"button\">"+chld[i]+"</button></li>";
			else
				dirList += "<li>"+chld[i]+"</li>";
		}
		return dirList;
	}

}