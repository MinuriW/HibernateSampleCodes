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
    	
    	//Stall stall = new Stall();
        StallBO bo = new StallBO();
        StallLicense license = new StallLicense();
        
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
                Stall stall1 = new Stall();
				System.out.println("Enter stall id");
				int id = Integer.parseInt(br.readLine());
				System.out.println("Enter stall name");
				String name = br.readLine();
				System.out.println("Enter stall type");
				String type = br.readLine();
				
				stall1.setStallId(id);
				stall1.setName(name);
				stall1.setType(type);
				
				bo.registerStall(stall1);
				break;
			case 2:
                Stall stall2 = new Stall();
               
				System.out.println("Enter license id");
				int lid = Integer.parseInt(br.readLine());
				System.out.println("Enter expiry date");
				Date date= new SimpleDateFormat("dd/MM/yyyy").parse(br.readLine());
				System.out.println("Enter stall id");
				int stallId =  Integer.parseInt(br.readLine());
				
				license.setLicenseId(lid);
				license.setExpiryDate(date);
				stall2.setStallId(stallId);
				stall2.setLicense(license);
				license.setStall(stall2);
				bo.findStallById(stallId);
				
				if(bo.findStallById(stallId) == null) {
					System.out.println("Stall not found");
					break;
				}
				bo.getLicense(stall2);
				break;
			case 3:
				//Stall stall = new Stall();
				System.out.printf("%-15s %-15s %-15s %s\n","Stall id","Name","Type","License(Expiry)"); 
				List<Stall> list= bo.listStalls();
				for(Object o:list) {
					Stall stall=(Stall)o;
					if(o ==  null)
						System.out.printf("%-15s %-15s %-15s %s\n",stall.getStallId(),stall.getName(),stall.getType(),"Not applied");
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