
package Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.sendgrid.Attachments;
import com.sendgrid.Client;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class commons {

  //SOmnath DID it 
 static String workingDir = System.getProperty("user.dir"); 
  public static void sendMail(String ReportFileName) throws IOException {
	  String host = "api.sendgrid.com";
		int port = 443;
		System.setProperty("http.proxyHost", "api.sendgrid.com");
		System.setProperty("http.proxyPort", "443");
		Email from = new Email("pim_it@hm.com");
		String subject = "PIM Automation Report for H&M and NBO Test environment";
		//Email to = new Email("sobihaagnal.alphonse@hm.com","somnath.g@hm.com");
		Content content = new Content("text/plain",
				"Hi Team, \n\nPlease find the Report Attached for the Test Results of Regression Automation in H&M Test environment. \n \nThanks, \n PIM Team");
		//Mail mail = new Mail(from, subject, to, content);
		Personalization p1 = new Personalization();
		p1.addTo(new Email("indirani.azhagarsamy@hm.com"));
     	p1.addTo(new Email("somnath.g@hm.com"));
		//p1.addTo(new Email("thangavel.vaiyapuri@hm.com"));	
		//p1.addTo(new Email("Juli.Patel@hm.com"));
		//p1.addTo(new Email("abinaya.thanabalan@hm.com"));
		//p1.addCc(new Email("Mukesh.Upadhaya@hm.com"));
	//	mail.addPersonalization(p1); 
	
		File file = new File(workingDir + "\\Reports\\" + ReportFileName);
		byte[] fileData = null;
		try {
			fileData = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file));
		} catch (IOException ex) {
		}

		Attachments attachments3 = new Attachments();
		Base64 x = new Base64();
		String imageDataString = x.encodeAsString(fileData);
		attachments3.setContent(imageDataString);
		attachments3.setType("application/html");// "application/pdf"
		attachments3.setFilename(ReportFileName);
		attachments3.setDisposition("attachment");
		attachments3.setContentId("Banner");
	//	mail.addAttachments(attachments3);

			CloseableHttpClient httpclient = HttpClients.custom().useSystemProperties().setProxy(new HttpHost(host, port))
				.build();

		Client client = new Client(httpclient);
		// Pss key
//	    SendGrid sg = new SendGrid(System.getenv("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"));
		SendGrid sg = new SendGrid("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", client);
		// TestKey for DAM PIM
//	    SendGrid sg = new SendGrid("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",client);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
//	      request.addHeader("User-Agent", "Mozilla");
		//	request.setBody(mail.build());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			throw ex;
		}
	}

}