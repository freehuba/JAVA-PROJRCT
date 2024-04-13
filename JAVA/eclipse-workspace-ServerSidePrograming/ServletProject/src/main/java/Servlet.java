
import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name = req.getParameter("name");
		
		PrintWriter out = res.getWriter();
		
		out.print(name);
		
	}

}
