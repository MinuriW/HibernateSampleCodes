import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
    	log.setLevel(Level.OFF);
    	System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");
    	
    	StallBO bo = new StallBO();

		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		do {
			System.out.println("Menu");
			System.out.println("1.Stall Registration");
			System.out.println("2.Stall Licensing");
			System.out.println("3.Show stalls");
			System.out.println("4.Exit");
			System.out.println("Enter choice");
			switch(Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("Enter stall id");
				int id1 = Integer.parseInt(br.readLine());
				
				System.out.println("Enter stall name");
				String name1 = br.readLine();
				
				System.out.println("Enter stall type");
				String type1 = br.readLine();
				
				Stall s1 = new Stall();
				s1.setStallId(id1);
				s1.setName(name1);
				s1.setType(type1);
				
				bo.registerStall(s1);
				
				break;
			case 2:

				System.out.println("Enter license id");
				int lid2 = Integer.parseInt(br.readLine());
				
				System.out.println("Enter expiry date");
				Date expireyDate2 = sdf.parse(br.readLine());
				
				System.out.println("Enter stall id");
				int id2 = Integer.parseInt(br.readLine());
				
				Stall s2 = bo.findStallById(id2);
				
				if(s2 == null) {
					System.out.println("Stall not found");
					break;
				}
				
				StallLicense license2 = new StallLicense();
				license2.setStall(s2);
				license2.setLicenseId(lid2);
				license2.setExpiryDate(expireyDate2);
				
				s2.setLicense(license2);
				
				bo.getLicense(s2);
				
				break;
			case 3:
				System.out.printf("%-15s %-15s %-15s %s\n","Stall id","Name","Type","License(Expiry)"); 
				
				List<Stall> list = bo.listStalls();
				
				for(Object o:list) {
					Stall stall=(Stall)o;
					if(stall.getLicense()==null)
						System.out.printf("%-15s %-15s %-15s %s\n",stall.getStallId(),stall.getName(),stall.getType(), "Not applied");
					else
						System.out.printf("%-15s %-15s %-15s %s\n",stall.getStallId(),stall.getName(),stall.getType(),stall.getLicense().getLicenseId()+"("+sdf.format(stall.getLicense().getExpiryDate())+")");
				}
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
	}
}