package monitor.hadoop;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import monitor.utils.MailSenderFactory;
import monitor.utils.SimpleMail;
import monitor.utils.SimpleMailSender;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void mailTest() throws Exception{
		
		SimpleMail sendMail = new SimpleMail("wangsonggen@126.com","8426791350.qaz");
		sendMail.setToMail("wsg96321@126.com");
		sendMail.setContent("123123");
		sendMail.setSubject("test");
		SimpleMailSender mailSender = MailSenderFactory.getSender(sendMail);
		mailSender.send(sendMail);
		
	}

}
