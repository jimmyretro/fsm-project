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

public class AuthFailure extends AuthBaseState {

	public static final String NAME = "AUTH_FAILURE";
	private static final long serialVersionUID = -8073714410489645438L;
	private static AuthFailure instance = null;
	
	private AuthFailure() {};
	
	public static AuthFailure getInstance() {
		if(instance == null) {
			synchronized(AuthFailure.class) {
				if(instance == null)
					instance = new AuthFailure();
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
		System.out.println("Action for AuthFailure State");		
		
	}

}
