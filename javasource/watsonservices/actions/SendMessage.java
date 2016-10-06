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
import watsonservices.utils.ConversationService;

/**
 * Add a natural language interface to your application to automate interactions with your end users. Common applications include virtual agents and chat bots that can integrate and communicate on any channel or device.
 */
public class SendMessage extends CustomJavaAction<IMendixObject>
{
	private String username;
	private String password;
	private String input;
	private IMendixObject __conversationContext;
	private watsonservices.proxies.ConversationContext conversationContext;

	public SendMessage(IContext context, String username, String password, String input, IMendixObject conversationContext)
	{
		super(context);
		this.username = username;
		this.password = password;
		this.input = input;
		this.__conversationContext = conversationContext;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.conversationContext = __conversationContext == null ? null : watsonservices.proxies.ConversationContext.initialize(getContext(), __conversationContext);

		// BEGIN USER CODE
		return ConversationService.sendMessage(getContext(), conversationContext, input, username, password);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "SendMessage";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
