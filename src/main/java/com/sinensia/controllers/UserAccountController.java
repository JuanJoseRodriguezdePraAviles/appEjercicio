package com.sinensia.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinensia.model.UserAccount;
import com.sinensia.services.UserAccountService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/userAccount")
public class UserAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String captcha = request.getParameter("g-recaptcha-response");
		if(captcha=="")
			response.sendRedirect("nuevoUserAccount.jsp");
		else {
			String nombre = request.getParameter("nombre");
			String apellidos = request.getParameter("apellidos");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			LocalDate fechaNacimiento = null;
			try {
				fechaNacimiento = format.parse(request.getParameter("fechaNacimiento")).toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
			}catch(ParseException e) {
				e.printStackTrace();
			}
			String email = request.getParameter("email");
			UserAccount userAccount = new UserAccount();
			userAccount.setNombre(nombre);
			userAccount.setApellidos(apellidos);
			userAccount.setFechaNacimiento(fechaNacimiento);
			userAccount.setEmail(email);
			userAccount.setFechaRegistro(LocalDate.now());
			
			UserAccountService listaIUserAccountDao = new UserAccountService();
			try {
				listaIUserAccountDao.add(userAccount);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			//Send email
			String destinatario = userAccount.getEmail();
			String origen = "jjpratest@gmail.com";
			String host = "smtp.gmail.com";
			
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        
	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication("jjpratest@gmail.com", ",:~Jnh8/?wZt<Ck[");

	            }
	            

	        });
			
	     // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(origen));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

	            // Set Subject: header field
	            message.setSubject("Creación cuenta");

	            // Now set the actual message
	            message.setText("La cuenta de usuario: "+userAccount.getNombre()+ " " +userAccount.getApellidos()+" ha sido creada con éxito");

	            System.out.println("enviando...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Enviado mensaje con éxito...");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	        
			response.sendRedirect("index.jsp");
		}
	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		UserAccountService userAccountService = new UserAccountService();
		UserAccount userAccount = userAccountService.getById(Integer.parseInt(request.getParameter("id")));
		userAccountService.remove(userAccount.getUserAccountId());
		
		response.sendRedirect("index.jsp");
	}
}
