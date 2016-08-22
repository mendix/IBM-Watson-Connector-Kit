// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package watsonservices.actions;

import java.io.InputStream;
import org.apache.commons.lang3.StringUtils;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.MendixException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import watsonservices.proxies.Speech;
import watsonservices.proxies.VoiceEnum;

public class Synthesize extends CustomJavaAction<IMendixObject>
{
	private String Username;
	private String Password;
	private String Text;
	private watsonservices.proxies.VoiceEnum VoiceEnumParameter1;

	public Synthesize(IContext context, String Username, String Password, String Text, String VoiceEnumParameter1)
	{
		super(context);
		this.Username = Username;
		this.Password = Password;
		this.Text = Text;
		this.VoiceEnumParameter1 = VoiceEnumParameter1 == null ? null : watsonservices.proxies.VoiceEnum.valueOf(VoiceEnumParameter1);
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		LOGGER.debug("Executing Synthetize Connector...");
		
		final TextToSpeech service = new TextToSpeech();
		service.setUsernameAndPassword(Username, Password);
		
		final Voice voice = getVoice(VoiceEnumParameter1);
		
		InputStream stream;
		try {
			stream = service.synthesize(Text, voice, AudioFormat.OGG).execute();
		} catch (Exception e) {
			LOGGER.error("Watson Service Connection - Failed text to speech: " + StringUtils.abbreviate(Text, 20), e);
			throw new MendixException(e);
		}

		final IMendixObject speechObject = Core.instantiate(getContext(), Speech.entityName);
		Core.storeFileDocumentContent(getContext(), speechObject, stream);		
		
		return speechObject;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "Synthesize";
	}

	// BEGIN EXTRA CODE
	private static final String WATSON_TEXT_TO_SPEECH_LOGNODE = "WatsonServices.IBM_WatsonConnector_TextToSpeech";
	private static ILogNode LOGGER = Core.getLogger(Core.getConfiguration().getConstantValue(WATSON_TEXT_TO_SPEECH_LOGNODE).toString());
	
    private Voice getVoice(VoiceEnum parameter) throws MendixException {
		Voice voice = null;
		
		switch(parameter){
			case DE_DIETER:
				voice = Voice.DE_DIETER;
				break;
			case EN_ALLISON:
				voice = Voice.EN_ALLISON;
				break;
			case EN_LISA:
				voice = Voice.EN_LISA;
				break;
			case ES_ENRIQUE:
				voice = Voice.ES_ENRIQUE;
				break;
			case ES_LAURA:
				voice = Voice.ES_LAURA;
				break;
			case ES_SOFIA:
				voice = Voice.ES_SOFIA;
			case FR_RENEE:
				voice = Voice.FR_RENEE;
				break;
			case GB_KATE:
				voice = Voice.GB_KATE;
				break;
			case IT_FRANCESCA:
				voice = Voice.IT_FRANCESCA;
				break;
		default:
			break;
		}
		
		if(voice == null){
			throw new MendixException("The supplied parameter doesn't correspond to any voice: " + parameter);
		}
		
		return voice;	
	}
	// END EXTRA CODE
}
