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


package org.authentication;

import org.fsm.AuthContext;
import org.fsm.AuthState;
import org.fsm.AuthTransitionCondition;

public class AuthenticationService implements AuthContext{

	public static void main(String[] args) {
		// TODO 

	}

	@Override
	public void moveNextState() {
		// TODO 
		
	}

	@Override
	public boolean checkTransitionNeeded() {
		// TODO 
		return false;
	}

	@Override
	public AuthState getCurrentState() {
		// TODO 
		return null;
	}

	@Override
	public void setCurrentState() {
		// TODO 
		
	}

	@Override
	public void initialize() {
		// TODO 
		
	}

	@Override
	public AuthTransitionCondition getAuthStateOutcome() {
		// TODO 
		return null;
	}

	@Override
	public void setAuthStateOutcome(AuthTransitionCondition stateOutcome) {
		// TODO 
		
	}


}
