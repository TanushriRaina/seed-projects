package demo.test1;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.test1.model.Patient;
import demo.test1.model.PatientDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nm_del = request.getParameter("del_name").trim();
		String nm_edit = request.getParameter("edit_name").trim();
		
		System.out.println(nm_del);
		System.out.println(nm_edit);
		
		if(request.getParameter("delBtn")!=null) {
			
			//Students s = get
			PatientDao.delete(nm_del);
			//StudentsDao.shutdown();
		}
		else if(request.getParameter("editBtn")!=null) {
			
			PatientDao.tblUpdate(nm_edit, "x@gmail.com");
			//StudentsDao.shutdown();
		}
		
		List<Patient> patient = null;
		patient = PatientDao.display();
		
		
		
		request.setAttribute("patient", patient);
		
		request.getRequestDispatcher("page2.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int patientId =Integer.parseInt(request.getParameter("patientId").trim());
		String patientName =request.getParameter("patientName").trim();
		String patientEmail = request.getParameter("patientEmail").trim();

		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		String strdate =formatter.format(date);  
		
		Patient p = new Patient(patientId, patientName, patientEmail, strdate);
		
		PatientDao.create(p);
		
		List<Patient> patient = null;
		patient = PatientDao.display();
		
		//StudentsDao.shutdown();
		
		request.setAttribute("patient", patient);
		
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

}
