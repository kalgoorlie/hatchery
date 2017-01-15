//
//  ========================================================================
//  Copyright (c) 1995-2013 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package a9bjb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a9bjb.core.DrillController;

@SuppressWarnings("serial")
@WebServlet("/getFileList")
public class GetFileListServlet extends HttpServlet //Join이 필요한 경우에만 사용합니다.
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	PrintWriter out = response.getWriter();
    	
		try {
			System.out.println("getFileList");
			ServletContext sc = request.getSession().getServletContext();			
			DrillController dc = (DrillController) sc.getAttribute("drillController");
	    		    	
	    	ArrayList<String> files = dc.getFileList();
	    	response.setContentType("text/plain; charset=UTF-8");
	    	
	    	for(int i = 0; i < files.size(); i++){	    		
	    		out.print("<tr><td>"+(i+1)+"</td><td>"+files.get(i)+"</td></tr>");
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendError(500, "Error : " + e.getMessage());
		}
    }
}
