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

package org.fsm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.fsm.states.AuthFailure;
import org.fsm.states.AuthRequestReceived;
import org.fsm.states.AuthenticateUser;
import org.fsm.states.AuthSuccess;

public class AuthStateMachine implements IAuthStateMachine, Serializable {

	private static final long serialVersionUID = 6720478767582998846L;

	public static final String NAME = "AUTH_STATE_MACHINE";
	private static AuthStateMachine stateMachine = null;

	private AuthStateMachine() {
	}

	public static AuthStateMachine getInstance() {

		if (stateMachine == null) {
			synchronized (AuthStateMachine.class) {
				if (stateMachine == null)
					stateMachine = new AuthStateMachine();
			}
		}
		return stateMachine;

	}

	private static final Map<String, Map<AuthTransitionCondition, String>> TRANSITIONS = new HashMap<String, Map<AuthTransitionCondition, String>>() {

		{
			put(AuthState.INITIAL, new HashMap<AuthTransitionCondition, String>() {
				{
					put(AuthTransitionCondition.EMPTY, AuthRequestReceived.NAME);
				}
			});
			put(AuthRequestReceived.NAME, new HashMap<AuthTransitionCondition, String>() {
				{
					put(AuthTransitionCondition.SUCCESS, AuthenticateUser.NAME);
					put(AuthTransitionCondition.VALIDATION_ERROR, AuthFailure.NAME);
				}
			});
			put(AuthenticateUser.NAME,
					new HashMap<AuthTransitionCondition, String>() {
						{
							put(AuthTransitionCondition.SUCCESS,
									AuthSuccess.NAME);
							
							put(AuthTransitionCondition.ERROR, AuthFailure.NAME);
						}
					});

			
			// auth final FSM state
			put(AuthSuccess.NAME, new HashMap<AuthTransitionCondition, String>() {
				{
					put(AuthTransitionCondition.SUCCESS, AuthSuccess.NAME);
				}
			});
		}
	};

	@Override
	public String getNextStateName(String stateName, AuthTransitionCondition stateCondition) {

		String result = null;
		try {
			Map<AuthTransitionCondition, String> stateTransitionMap = TRANSITIONS
					.get(stateName);

			if (stateTransitionMap != null) {
				result = stateTransitionMap.get(stateCondition);
			}
		} catch (Exception x) {
			System.out.println("Unable to find transition from source state "
					+ stateName + " on outcome " + stateCondition, x);
		}
		return result;
	}

	@Override
	public AuthState getInstanceOf(String stateName) {

		if (stateName.equals(AuthRequestReceived.NAME)) {
			return AuthRequestReceived.getInstance();
		}
		if (stateName.equals(AuthenticateUser.NAME)) {
			return AuthenticateUser.getInstance();
		}
		if (stateName.equals(AuthFailure.NAME)) {
			return AuthFailure.getInstance();
		}
		return null;

	}

}
