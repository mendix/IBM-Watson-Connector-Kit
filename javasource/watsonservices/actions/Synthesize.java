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
import watsonservices.utils.TextToSpeechService;

public class Synthesize extends CustomJavaAction<IMendixObject>
{
	private java.lang.String text;
	private watsonservices.proxies.VoiceEnum voice;
	private watsonservices.proxies.AudioFormats_TextToSpeech audioFormat;
	private java.lang.String apikey;
	private java.lang.String url;

	public Synthesize(IContext context, java.lang.String text, java.lang.String voice, java.lang.String audioFormat, java.lang.String apikey, java.lang.String url)
	{
		super(context);
		this.text = text;
		this.voice = voice == null ? null : watsonservices.proxies.VoiceEnum.valueOf(voice);
		this.audioFormat = audioFormat == null ? null : watsonservices.proxies.AudioFormats_TextToSpeech.valueOf(audioFormat);
		this.apikey = apikey;
		this.url = url;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		return TextToSpeechService.synthesize(getContext(), text, voice, audioFormat, apikey, url);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "Synthesize";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
