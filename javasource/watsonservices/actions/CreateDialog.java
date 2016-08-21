// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package watsonservices.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import com.ibm.watson.developer_cloud.dialog.v1.DialogService;
import com.ibm.watson.developer_cloud.dialog.v1.model.Dialog;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.MendixException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class CreateDialog extends CustomJavaAction<String>
{
	private String dialogName;
	private IMendixObject __dialogContent;
	private system.proxies.FileDocument dialogContent;
	private String username;
	private String password;

	public CreateDialog(IContext context, String dialogName, IMendixObject dialogContent, String username, String password)
	{
		super(context);
		this.dialogName = dialogName;
		this.__dialogContent = dialogContent;
		this.username = username;
		this.password = password;
	}

	@Override
	public String executeAction() throws Exception
	{
		this.dialogContent = __dialogContent == null ? null : system.proxies.FileDocument.initialize(getContext(), __dialogContent);

		// BEGIN USER CODE
		LOGGER.debug("Executing CreateDialog Connector...");

		final DialogService dialogService = new DialogService();
		dialogService.setUsernameAndPassword(this.username, this.password);
		
		final File dialogTemplateFile = new File(Core.getConfiguration().getTempPath() + dialogName);
		try(final InputStream is = Core.getFileDocumentContent(getContext(), this.dialogContent.getMendixObject())){
		
			Files.copy(is, dialogTemplateFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}catch(IOException e){
			LOGGER.error("There was a problem with the template: " + dialogTemplateFile.getPath(), e);
			throw new MendixException(e);
		}
		
		Dialog dialog = null;
		try{
			dialog = dialogService.createDialog(dialogName, dialogTemplateFile).execute();
			
		}catch(Exception e){
			LOGGER.error("Watson Service connection - Failed creating the template: " + dialogName, e);	
			throw new MendixException(e);
		}finally{
			dialogTemplateFile.delete();
		}
		
		return dialog.getId();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "CreateDialog";
	}

	// BEGIN EXTRA CODE
	private static final String WATSON_DIALOG_LOGNODE = "WatsonServices.IBM_WatsonConnector_Dialog";
	private static final ILogNode LOGGER = Core.getLogger((Core.getConfiguration().getConstantValue(WATSON_DIALOG_LOGNODE).toString()));
	// END EXTRA CODE
}