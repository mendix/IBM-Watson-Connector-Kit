// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package watsonservices.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import watsonservices.utils.DialogService;

public class GetDialogs extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private String username;
	private String password;

	public GetDialogs(IContext context, String username, String password)
	{
		super(context);
		this.username = username;
		this.password = password;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		return DialogService.getDialogs(getContext(), username, password);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "GetDialogs";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
