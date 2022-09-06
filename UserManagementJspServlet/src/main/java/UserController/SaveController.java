package UserController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDao.UserDao;
import userDto.User;
@WebServlet("/save")
public class SaveController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		
		User u =new User();
		u.setId(Integer.parseInt(id));
		u.setName(name);
		u.setPhone(Long.parseLong(phone));
		u.setEmail(email);
		
		UserDao dao=new UserDao();
		try
		{
			dao.insertUser(u);//dao->data access object layer
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req,resp);
	}
}

