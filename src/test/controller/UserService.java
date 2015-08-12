/**
 * Author : 
 * Bamb Bakang Tonjé
 * Edited on 21/01/2014
 */
package test.controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.management.Query;
import javax.websocket.Session;

import test.objects.Group;
import test.objects.User;
import controller.Service;
import entry.Gate;


public class UserService extends Service {

	public static final String NB_SHARED_NOTES_REC = "nb_shared_notes_rec";
	public static final String USER_NAME_STYLE1 = "user_name_style1";
	public static final String USER_ID = "user_id";
	
	

	public HashMap<String, Object> executes(HashMap<String, String> args) {
		load();
		return executes(this.getClass(), args);

	}

	/**
	 * Authentication procedure response for appropriate request
	 * 
	 * @param args
	 * @return
	 * @throws SQLException
	 */
	public HashMap<String, Object> authentication(HashMap<String, Object> argsIn)
			throws SQLException {

		String clis_email = (String) argsIn.get("clis_email");
		String clis_pass = (String) argsIn.get("clis_pass");

		System.out.println("Email : " + clis_email + "\nPassword : "
				+ clis_pass);

		

		User user = new User("Bamb", "bakang");



		HashMap<String, Object> argsOut = new HashMap<String, Object>();
		if(user!=null){

		


				// give new location to go
				argsOut.put(Gate.NEW_LOCATION, "/connected/menu.jsp");
				// authorization is given
				argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, true);

			}
			else 
				argsOut.put(Service.SERVICE_VALIDATION_RESPONSE_LBL, false);
		}
		return argsOut;
	}

	@Override
	public void load() {

		/*
		 * this load available services in this class If a service is not here
		 * then the user won't be able to discover it
		 */
		if (this.servicesList.isEmpty()) {
			this.servicesList.add("authentication");
			
		}

	}
}
