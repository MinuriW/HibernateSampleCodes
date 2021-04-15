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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		StallBO sbo = new StallBO();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		do {
			System.out.println("Menu");
			System.out.println("1.Stall Registration");
			System.out.println("2.Stall Licensing");
			System.out.println("3.Show stalls");
			System.out.println("4.Exit");
			System.out.println("Enter choice");
			switch (Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("Enter stall id");
				int stallId = Integer.parseInt(br.readLine());

				System.out.println("Enter stall name");
				String name = br.readLine();

				System.out.println("Enter stall type");
				String type = br.readLine();

				Stall stall = new Stall(stallId, name, type);
				sbo.registerStall(stall);

				break;
			case 2:
				System.out.println("Enter license id");
				int licenseId = Integer.parseInt(br.readLine());
				System.out.println("Enter expiry date");
				Date date = sdf.parse(br.readLine());
				System.out.println("Enter stall id");
				int stalllId = Integer.parseInt(br.readLine());;
				
				Stall stallObj = sbo.findStallById(stalllId);
				if(stallObj == null) {
					System.out.println("Stall not found");
					break;
				} else {
					Stall stlUpdtObj = new Stall(stallObj.getStallId(), 
							stallObj.getName(), stallObj.getType()
							,new StallLicense(licenseId, date, stallObj));
					sbo.getLicense(stlUpdtObj);
				}
				//fill your code here
				break;
			case 3:
				System.out.printf("%-15s %-15s %-15s %s\n","Stall id","Name","Type","License(Expiry)"); 
				List<Stall> list = sbo.listStalls();
				for(Object o:list) {
					stall=(Stall)o;
					if(stall.getLicense()==null)
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
		} while (true);
	}
}