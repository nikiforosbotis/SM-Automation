import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{


	public static void main( String[] args )
	{
		new Cashemployee("Giorgos", "Papadopoulos", 1, "gpap", 12345, "fulltime", 4);
		new Manager("Kostas", "Nikolaidis", 0, "knik", 1111, 0);
		new Customers("Dimitris", "Nikolaou", "ermou45", 2109999999, 0.0);
		new Customers("Hlias", "Xristodoulou", "kerkuras55", 2103333333, 0.0);
		int answer=1;
		int counter=0;
		int choice=-1;
    int elegxos=-1;

		Scanner input=new Scanner(System.in);

	  readProducts();

		answer=1;
		counter=0;
		System.out.println("Prepei na eisagete toulaxiston 2 pelates prin ksekinisei i diadikasia.Gia na eisagetai neo pelath pathste 1. Gia na stamathsete thn eisagwgh pathste 0\n\n");

		while (answer==1)
		{
			System.out.println("Eisagete to onoma tou pelath\n\n");
			name2=input.next();
			System.out.println("Eisagete to epwnumo tou pelath\n\n");
			surname=input.next();
			System.out.println("Eisagete thn dieuthinsh tou pelath\n\n");
			adress=input.next();
			System.out.println("Eisagete to thlefwno tou pelath\n\n");
			telephone=input.next();
			Customers.customersArray[Customers.counter_customers]=new Customers(name2, surname, adress, telephone, 0);
			counter++;
			System.out.println("Thelete na eisagete neo pelath?\n\n");
			answer=input.nextInt();
			if (counter<2 && answer==0)
			{
				System.out.printf("Prepei na eisagete toulaxiston 2 pelates, dhladh akoma toulaxiston %d\n\n", 2-counter);
				answer=1;
			}
		}

		while(elegxos==-1) {
			System.out.println("Doste to username\n\n");
			String username1=input.next();
			System.out.println("Eisagete to password\n\n");
			int password1=input.nextInt();

			elegxos=Employee.controlUsernamePass(username1, password1);
			if(elegxos!=-1)
			{
				if(Employee.employeeArray[elegxos] instanceof Cashemployee)
				{
					while(choice!=0)
					{
					System.out.println("----MENU-----\n"+
					       "1.Ektupwsh xarakthristikwn proiontos\n"+
					       "2.Kataxwrhsh neou pelath\n"+
					       "3.Plhrwmh proiontwn sto tameio\n");
					choice=input.nextInt();


			if (choice==1) 			{
				int kwdikos;
				int status=0;
				while (status==0) {
				System.out.println("Dose ton kwdiko tou proiontos tou opoiou theleis ta xarakthristika\n\n");
			    kwdikos=input.nextInt();
				if (Products.existanceOfCode(kwdikos)==1) {
					Products.printProduct(kwdikos);
					status=1; }
			    else {
			        System.out.println("O kwdikos pou dosate den antistoixei se kapoio proion. Parakalw eisagete ksana.\n\n");
				}
			 }
		   }

		   if (choice==2)
		   {
			   Customers.insertCustomer();
			   System.out.println("H kataxwrhsh tou neou pelath oloklirwthike me epityxia!\n\n");
		   }

		   if (choice==3)
		   {
			   Receipts.paymentOfProducts();
		   }
	   }
   }
	   else {
		   while(choice!=0)
		   {

	          System.out.println("-----MENU-----\n"+
	                "1.Ektupwsh olwn twn kataxwrhmenwn pelatwn\n"+
	                "2.Ektupwsh kai eggrafh se txt olwn twn kataxwrhmenwn ypallhlwn\n"+
	                "3.Ektupwsh twn mhniaiwn pwlhsewn kathe kataxwrhmenou proiontos\n");
	         choice=input.nextInt();

		      if (choice==1)
	          {
		          Customers.printCustomers();
		      }

		      if(choice==2)
		      {
				  Employee.printEmployeesCmdTxt();
			  }

		      if (choice==3)
		      {
		      	   Products.printOfAllSales();
		      }

	      }
      }


	    }
	   else
	   System.out.println("Ta stoixeia pou dosate einai lanthasmena.Parakalw, prospathiste ksana\n\n");
   }
}

   public static void readProducts()
   {
	   try{
		      FileInputStream fstream= new FileInputStream("Proionta.txt");
		      DataInputStream in= new DataInputStream(fstream);
		      BufferedReader br=new BufferedReader(new InputStreamReader(in));
		      String line;
		      String[] array;

		      while((line=br.readLine())!=null){
				  array=line.split(",");

				  String name= array[0];
				  String weight= array[1];
				  double price= Double.parseDouble(array[2]);

				  new Products(name, weight, price);
			  }
			  in.close();
			  System.out.println("To diavasma proiontwn oloklirothike epitixws!\n\n");

		  }
		  catch(Exception ex) {
			  System.out.println("An exception is caught!");
			  ex.printStackTrace();
		  }
	  }

}
