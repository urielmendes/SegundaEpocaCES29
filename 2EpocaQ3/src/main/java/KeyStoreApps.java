import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


public class KeyStoreApps {
	public KeyStore ks;
	
	public void createKeyStore(String username,String pwd) throws Exception{
		if(!InputValidator.validate(pwd))
			throw new Exception("Invalid Password");
		
		try {
			ks = KeyStore.getInstance(KeyStore.getDefaultType());
			char[] password = "some password".toCharArray();
			ks.load(null, password);

			// Store away the keystore.
			FileOutputStream fos = new FileOutputStream("c:\\teste\\"+username+".ks");
			ks.store(fos, password);
			fos.close();

		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}