
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import com.google.gson.Gson;

public class HomePageServlet extends HttpServlet {

	protected void doGet( HttpServletRequest request,
			HttpServletResponse response )
	throws ServletException, IOException {

		List< String > list = new ArrayList< String >();

		list.add( "number one" );
		list.add( "number two" );
		list.add( "number three" );

		String json = new Gson().toJson( list );

		response.setContentType( "application/json" );
		response.setCharacterEncoding( "UTF-8" );

		try{

			response.getWriter().write( json );

		}catch( Exception e ){

			System.out.println( e );

		}

	}

	protected void doPost( HttpServletRequest request,
			HttpServletResponse response )
	throws ServletException, IOException {

		doGet( request, response );

	}

}
