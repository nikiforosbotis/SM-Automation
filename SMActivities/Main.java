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
    int control=-1;

		Scanner input=new Scanner(System.in);

	  readProducts();

		answer=1;
		counter=0;
		System.out.println("You should enter at least 2 customers before the procedure start"
		+ "In order to enter a new customer, please press 1. If you wish to stop the procedure of "
		+ "registering the new customer, please press 0 \n\n");

		while (answer==1)
		{
			System.out.println("Enter the name of the customer \n\n");
			name2=input.next();
			System.out.println("Enter the surname of the customer \n\n");
			surname=input.next();
			System.out.println("Enter the address of the customer \n\n");
			adress=input.next();
			System.out.println("Enter the address of the customer \n\n");
			telephone=input.next();
			Customers.customersArray[Customers.counter_customers]=new Customers(name2, surname, adress, telephone, 0);
			counter++;
			System.out.println("Do you want to add a new customer? \n\n");
			answer=input.nextInt();
			if (counter<2 && answer==0)
			{
				System.out.printf("You should add at least 2 customers, this means you still have to enter: %d\n\n", 2-counter);
				answer=1;
			}
		}

		while(control==-1) {
			System.out.println("Enter your username \n\n");
			String username1=input.next();
			System.out.println("Enter your password\n\n");
			int password1=input.nextInt();

			control=Employee.controlUsernamePass(username1, password1);
			if(control!=-1)
			{
				if(Employee.employeeArray[control] instanceof Cashemployee)
				{
					while(choice!=0)
					{
					System.out.println("----MENU-----\n"+
					       "1.Print product's characteristics\n"+
					       "2.Register a new customer\n"+
					       "3.Pay product in the cashier\n");
					choice=input.nextInt();

			if (choice==1) 			{
				int password;
				int status=0;
				while (status==0) {
				System.out.println("Enter the product's code for which you want to see its characteristics \n\n");
			    password=input.nextInt();
				if (Products.existanceOfCode(password)==1) {
					Products.printProduct(password);
					status=1; }
			    else {
			        System.out.println("The given password does not match with any product code. Please try again.\n\n");
				}
			 }
		   }

		   if (choice==2)
		   {
			   Customers.insertCustomer();
			   System.out.println("The product's registration was successful!\n\n");
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
	                "1.Print all the registered customers. \n"+
	                "2.Print and extract as .txt all the registered employees. \n"+
	                "3.Print the monthly sales for each registered product. \n");
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
	   System.out.println("The credential that you gave are not correct. Please try again. \n\n");
   }
}

   public static void readProducts()
   {
	   try{
		      FileInputStream fstream= new FileInputStream("Products.txt");
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
			  System.out.println("The procut's parsing has finished successfully. \n\n");

		  }
		  catch(Exception ex) {
			  System.out.println("An exception is caught!");
			  ex.printStackTrace();
		  }
	  }

}
