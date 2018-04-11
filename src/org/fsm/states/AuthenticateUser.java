/**
 * FSM Project
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of version 2 of the GNU General Public License as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA
 *
 */

package org.fsm.states;

import org.fsm.AuthBaseState;
import org.fsm.AuthContext;
import org.fsm.AuthTransitionCondition;

public class AuthenticateUser extends AuthBaseState{
	
	public static final String NAME = "AUTHENTICATE_USER";
	private static final long serialVersionUID = -1L;
	private static AuthenticateUser instance = null;

	private AuthenticateUser() {};

	public static AuthenticateUser getInstance() {
		if(instance == null) {
			synchronized(AuthenticateUser.class) {
				if(instance == null)
					instance = new AuthenticateUser();
			}
		}
		return instance;
	}
	
	@Override
	public String getStateName() {
		return NAME;
	}

	@Override
	public void doAction(AuthContext context) {
		
		String userName = context.getUserName();
		String passWord = context.getPassword();
		
		boolean isAuthenticated = false;

		isAuthenticated = checkCredentials(userName,passWord);
			if (isAuthenticated) {
				setAuthTransitionCondition(context, AuthTransitionCondition.SUCCESS);
			} else {
				System.out.println("Login failed");
				setAuthTransitionCondition(context, AuthTransitionCondition.ERROR);	
			}
		
	}

	private boolean checkCredentials(String username, String password) {
		boolean isAllowed = true;

		if((username == "mike") && (password == "pass")) {
			isAllowed = false;
			System.out.println("Check credentials failed");
		}
		return isAllowed;
	}
	

}
