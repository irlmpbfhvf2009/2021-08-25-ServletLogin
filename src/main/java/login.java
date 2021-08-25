

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Hashtable users = new Hashtable();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userid = request.getParameter("user");
		String password = request.getParameter("password");
		String webPassword=this.getInitParameter(password);
		String onclickhistoryback = "<input type=\'button' value=\'返回' onclick=\"window.history.back()\">";
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>homework</title></head>");
		out.println("<body>");
		if (userid != null && password.equals((String) users.get(userid))) {
			out.println("<script>window.alert('登入成功');</script><br>" + onclickhistoryback);
		} else {
			out.println("<script>window.alert('登入失敗');history.back();</script>");
		}
		out.println("</body></html>");
		out.close();
	}
	public void init() {
		users.put("ann", "aaa");
		users.put("john", "jjj");
		users.put("mark", "mmm");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
