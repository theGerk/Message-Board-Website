
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PreHomePageServlet extends HttpServlet {

	protected void doGet( HttpServletRequest request,
			HttpServletResponse response ){

		response.setContentType( "text/html" );

		/*
		 * If the user doesn't have a session,
		 * forward request to "login.jsp".
		 */

		// Get the session.
		HttpSession session = request.getSession( false );

		if( session == null ){

			//No session.. forward to "login.jsp".

			try{

				request.getRequestDispatcher( "WEB-INF/JSP/login.jsp" )
					.forward( request, response );

			} catch( Exception e ) {

				System.out.println( e );
			
			}

			System.out.println( "This should never get printed." );

		}

		//There is a Session.. prepare for home page
		//and then forward to it.

		try{

			request.getRequestDispatcher( "WEB-INF/JSP/home.jsp" )
				.forward( request, response );

		} catch( Exception e ) {

			System.out.println( e );
			
		}

	}

	protected void doPost( HttpServletRequest request,
			HttpServletResponse response ){

		doGet( request, response );

	}

}
