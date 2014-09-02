package net.txm.fdi.constants;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {

	private String SecretKey 		= "0123456789abcdef";
	private String iv 				= "1111111111111111";//"fedcba9876543210";

	//byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

	private IvParameterSpec ivspec;
	private SecretKeySpec keyspec;
	private Cipher cipher;
	/*	byte[] bytes 	= cmF.encrypt("String to Encrypt");
	String aa 		= cmF.bytesToHex(bytes);
	//System.out.println(aa+"  \naaaaaaaaaaa\naa  "+bytes.toString());

	bytes = cmF.decrypt(aa);
	String aa1 = new String(bytes);
	//System.out.println(aa1+"  \naaaaaaaaaaa\naaa  "+bytes.toString());*/
	public EncryptDecrypt() 
	{
		try 
		{
			ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));
			keyspec = new SecretKeySpec(SecretKey.getBytes("UTF-8"), "AES");
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"AES/CBC/PKCS5Padding");//"RIJNDAEL-256/AES");
		}
		catch (NoSuchAlgorithmException e) 
		{
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e) 
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
	}

	public byte[] encrypt(String text) throws Exception
	{
		if(text == null || text.length() == 0)
			throw new Exception("Empty string");

		byte[] encrypted = null;
		try 
		{
			System.out.println("Algo   "+cipher.getAlgorithm()+"  "+cipher.getBlockSize());
			cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
			encrypted = cipher.doFinal((text).getBytes("UTF-8"));
			//cipher.doFinal(plainText.getBytes("UTF-8"))
		}
		catch (Exception e)
		{    
			e.printStackTrace();
			throw new Exception("[encrypt] " + e.getMessage());
		}
		return encrypted;
	}

	public String decrypt(String code) throws Exception
	{
		if(code == null || code.length() == 0)
			throw new Exception("Empty string");

		String str_decrypted = "";
		try 
		{
			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
			byte[] decrypted 	= cipher.doFinal(hexToBytes(code));
			str_decrypted 		= new String(decrypted,"UTF-8");
		}
		catch (Exception e)
		{
			throw new Exception("[decrypt] " + e.getMessage());
		}
		return str_decrypted;
	}

	public String bytesToHex(byte[] data)
	{
		if (data==null)
		{
			return null;
		}

		int len = data.length;
		String str = "";
		for (int i=0; i<len; i++) 
		{
			if ((data[i]&0xFF)<16)
				str = str + "0" + java.lang.Integer.toHexString(data[i]&0xFF);
			else
				str = str + java.lang.Integer.toHexString(data[i]&0xFF);
		}
		return str;
	}


	public byte[] hexToBytes(String str) 
	{
		if (str==null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i=0; i<len; i++) 
			{
				buffer[i] = (byte) Integer.parseInt(str.substring(i*2,i*2+2),16);
			}
			return buffer;
		}
	}

	private String padString(String source)
	{
		char paddingChar = ' ';
		int size = 16;
		int x = source.length() % size;
		int padLength = size - x;

		for (int i = 0; i < padLength; i++)
		{
			source += paddingChar;
		}
		return source;
	}
}
