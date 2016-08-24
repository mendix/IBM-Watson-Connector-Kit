// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package watsonservices.actions;

import java.util.ArrayList;
import java.util.List;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.IdentifiableLanguage;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.MendixException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import watsonservices.proxies.Language;

public class GetIdentifiableLanguages extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private String username;
	private String password;

	public GetIdentifiableLanguages(IContext context, String username, String password)
	{
		super(context);
		this.username = username;
		this.password = password;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		LOGGER.debug("Executing IdentifiableLanagues Connector...");

		final LanguageTranslation service = new LanguageTranslation();
		service.setUsernameAndPassword(username, password);

	    List<IdentifiableLanguage> identifieableLanguages;
		try{
			identifieableLanguages = service.getIdentifiableLanguages().execute();
		} catch (Exception e) {
			LOGGER.error("Watson Service Connection - Failed retrieving the identifiable languages", e);
			throw new MendixException(e);
		}

		final List<IMendixObject> results = new ArrayList<IMendixObject>();
		for(IdentifiableLanguage language : identifieableLanguages){
			
			IMendixObject result = Core.instantiate(getContext(), Language.entityName);

			result.setValue(getContext(), "Name", language.getName());
			result.setValue(getContext(), "Code", language.getLanguage());
			results.add(result);
		}

		return results;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "GetIdentifiableLanguages";
	}

	// BEGIN EXTRA CODE
	private static final String WATSON_TRANSLATE_LOGNODE = "WatsonServices.IBM_WatsonConnector_Translate";
	private static ILogNode LOGGER = Core.getLogger(Core.getConfiguration().getConstantValue(WATSON_TRANSLATE_LOGNODE).toString());
	// END EXTRA CODE
}
