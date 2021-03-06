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
import watsonservices.utils.LanguageTranslationService;

public class GetIdentifiableLanguages extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String apikey;
	private java.lang.String url;

	public GetIdentifiableLanguages(IContext context, java.lang.String apikey, java.lang.String url)
	{
		super(context);
		this.apikey = apikey;
		this.url = url;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		return LanguageTranslationService.getIdentifiableLanguages(getContext(), apikey, url);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "GetIdentifiableLanguages";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
