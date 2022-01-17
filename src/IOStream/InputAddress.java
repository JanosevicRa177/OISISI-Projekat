package IOStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import Controller.AddressController;
import model.Address;

public class InputAddress {

	public InputAddress() throws IOException{
		// TODO Auto-generated constructor stub
	}
	public static void ReadAddresses(String file) throws IOException {
		File f = new File(file);
		String line = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
	try {
		while((line = reader.readLine()) != null) {
				String[] address = line.split(",");
					AddressController.getInstance().addAddress(new Address(address[0],address[1],address[2],address[3]));
				}
		} finally {
			reader.close();
		}
	}
}
