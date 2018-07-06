package com.indream.userlogin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.indream.model.User;
import com.indream.service.UserLoginService;
import com.indream.util.Utility;

/**
 * APP IS THE MAIN CLASS AUTOWIRING IS DONE FOR USERLOGINSERVICE
 *
 */
public class App {

	private UserLoginService service;// SERVICE CLASS REF
	ApplicationContext context = null;// APPLICATION CONTEXT REFERENCE

	public UserLoginService getService() {
		return service;
	}

	public void setService(UserLoginService service) {
		this.service = service;
	}

	public App() {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

	/**
	 * OPERATION METHOD WILL PERFORM INSERT DELETE AND SELECT OPERATION FOR THE
	 * USERS
	 */
	private void operations() {
		try {
			service = context.getBean("service", UserLoginService.class);
			System.out.println("1.Add User \n2.Delete User");
			int choice = Utility.getInt();
			switch (choice) {
			case 1:
				addUser();
				break;
			case 2:

				deleteUser();

				break;
			case 3:

				selectUser();

				break;
			default:
				System.out.println("Invalid choice");
				System.exit(1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((AbstractApplicationContext) context).close();
		}

	}
/**
 * SELECTUSER TO TAKE ID VALUE FROM THE USER AND RETURN A USER {NULL,NOT NULL}
 */
	private void selectUser() {
		User user = null;
		try {
			System.out.println("Enter the id for the user to be searched");
			int id = Utility.getInt();
			user = service.selectUser(id);
			if (user == null) {
				throw new Exception("No records found [main]");
			}
			System.out.println("Details");
			System.out.println(user);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
/**
 * DELETEUSER METHOD TAKES THE ID VALUE FOR THE USER TO BE DELETED
 * 
 */
	private void deleteUser()  {
		try {

			System.out.println("Enter the value of id");
			int id = Utility.getInt();

			boolean isDeleted = service.deleteUser(id);

			if (!isDeleted) {
				throw new Exception("Could not delete user");
			}
			System.out.println("Deleted user success");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * ADDUSER METHOD CALL TO UTILITY TO GET THE USER OBJECT
	 * return void 
	 * 
	 */
	private void addUser() {
		int id = service.adduser(Utility.getUser());//CALL TO SERVICE IS MADE
		if (id > 0) {
			System.out.println("Your id is " + id);
		} else {
			System.out.println("Could not add user");
		}
	}

	/**
	 * MAIN METHOD FOR ENTRY POINT CREATES THE INSTANCE OF THIS CLASS
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		App app = new App();
		app.operations();// CALLED THIS METHOD FOR PERFORMING SELECT INSERT AND DELETE OPERATIONS
	}
}//CLASS END
