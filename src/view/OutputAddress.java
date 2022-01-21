package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import Controller.AddressController;
import model.Address;

public class OutputAddress {
	
	public static OutputAddress getInstance() throws IOException {
		if (instance == null) {
			
			instance = new OutputAddress();
		}
		return instance;
	}
	public OutputAddress() throws IOException{
		// TODO Auto-generated constructor stub
	}
	private static OutputAddress instance = null;
	
	
	public void WriteAddresses(String file) throws IOException {
		File f = new File(file);
		String line = "";
		int j = 0;
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"UTF8"));
	try {
		List<Address> addrList = AddressController.getInstance().getAddrList();

		while(j < addrList.size()) {
			line = addrList.get(j).getStreet() + ",";
			line = line + addrList.get(j).getNumber() + ",";
			line = line + addrList.get(j).getCity() + ",";
			line = line + addrList.get(j).getState();
		j++;
		writer.write(line);
		writer.write("\n");
		
		line = "";
		}
		} finally {
			writer.close();
		}
	}

}

