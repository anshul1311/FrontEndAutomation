package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	private static ReadConfig conf;
	private static Properties prop;

	private ReadConfig(){

	}

	public static ReadConfig getInstance(String str) throws IOException{
		if(conf==null){
			prop=new Properties();
		File file=new File("src/main/resources/Config/"+str);
		if(file.exists()){
			FileInputStream fi=new FileInputStream(file);
			prop.load(fi);
			conf=new ReadConfig();
		}

		}

		return conf;

	}

	public String getTo(){
		return prop.getProperty("To");
	}

	public String getFrom(){
		return prop.getProperty("From");
	}

	public String getName(){
		return prop.getProperty("Name");
	}

	public String getCardNumber(){
		return prop.getProperty("CardNumber");
	}

	public String getCardMonth(){
		return prop.getProperty("CardMonth");
	}

	public String getCardYear(){
		return prop.getProperty("CardYear");
	}

	public String getPinCode(){
		return prop.getProperty("PinCode");
	}

	public String getCardType(){
		return prop.getProperty("CardType");
	}

	public String getCity(){
		return prop.getProperty("City");
	}

	public String getAddress(){
		return prop.getProperty("Address");
	}

	public String getUrl(){
		return prop.getProperty("url");
	}

}
