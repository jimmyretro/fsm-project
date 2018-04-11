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


public class AuthRequestReceived extends AuthBaseState{

	public static final String NAME = "AUTH_REQUEST_RECEIVED";
	private static final long serialVersionUID = -8073714410489645438L;
	private static AuthRequestReceived instance = null;
	
	private AuthRequestReceived() {};
	
	public static AuthRequestReceived getInstance() {
		if(instance == null) {
			synchronized(AuthRequestReceived.class) {
				if(instance == null)
					instance = new AuthRequestReceived();
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
		
		//TODO put logic here
		String userName = context.getUserName();
		String passWord = context.getPassword();
		
		boolean isMessageValidated = false;

			isMessageValidated = checkValidMessage(userName,passWord);
			if (isMessageValidated) {
				setAuthStateOutcome(context, AuthTransitionCondition.SUCCESS);
			} else {
				System.out.println("Message was not validated");
				setAuthStateOutcome(context, AuthTransitionCondition.VALIDATION_ERROR);	
			}
	}

	private boolean checkValidMessage(String username, String password) {
		boolean isMessageValid = true;

		if((username == null) || (password ==null)) {
			isMessageValid = false;
			System.out.println("Auth Request message not valid");
		}
		return isMessageValid;
	}

}
