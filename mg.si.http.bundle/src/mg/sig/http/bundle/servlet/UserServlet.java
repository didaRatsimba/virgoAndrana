/**
 *
 */
package mg.sig.http.bundle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author did
 * 
 */
public class UserServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = getParameter(request, response, "name");
		super.doGet(request, response);
		System.out.println(name);
		response.setContentType("text/plain");
	}

	private String getParameter(HttpServletRequest request,
			HttpServletResponse response, String parameter)
			throws ServletException, IOException {
		String value = request.getParameter(parameter);
		if (value.isEmpty()) {
			response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE, parameter);
			throw new ServletException("parametre missing " + parameter);
		}
		return value;

	}

}
