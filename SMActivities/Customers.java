import java.util.Scanner;
public class Customers
{
	private int code;
	private String name;
	private String surname;
	private String adress;
	private int card_code;
	private int telephone;
	private double points;

	static Customers[] customersArray=new Customers[20];

	static int counter_customers=0;
	public Customers(String name, String surname, String adress, int telephone, double points)
	{
		customersArray[counter_customers]=this;
		counter_customers++;
		this.name=name;
		this.surname=surname;
		this.adress=adress;
		this.telephone=telephone;
		this.card_code=counter_customers+100;
		this.code=counter_customers;
		this.points=points;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public String getName()
	{
		return name;
	}

	public void setSurname(String surname)
	{
		this.surname=surname;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setAdress(String adress)
	{
		this.adress=adress;
	}

	public String getAdress()
	{
		return adress;
	}

	public void setTelephone(int telephone)
	{
		this.telephone=telephone;
	}

	public int getTelephone()
	{
		return telephone;
	}

	public int getCardCode()
	{
		return card_code;
	}

    public void setPoints(double points)
    {
		this.points+=points;
	}

	public double getPoints()
	{
		return points;
	}

	public int getCode()
	{
		return code;
    }

    public String toString()
    {
		return "Customer [name=" + name + ", surname=" + surname + ", adress=" + adress + ", telephone=" + telephone + ", card_code=" + card_code + ", points=" + points + ", code=" + code +  "]";
	}

	public static int existanceOfCardCode(int card_number)
	{
		int existance=0;
		for(int i=0; i<customersArray.length; i++)
		{
			if (customersArray[i]!=null) {
				if (customersArray[i].getCardCode()==card_number)
				   existance=1;
			   }
		   }
		   return existance;
	   }

	public static void handlingOfPoints(int number, double poso)
	{
		int theshpelath=0;
		double pontoi;
		for(int i=0; i<customersArray.length; i++)
		{
			if (customersArray[i]!=null) {
				if (customersArray[i].getCardCode()==number)
				    theshpelath=i;
			   }
		}
		pontoi=poso/3;
		customersArray[theshpelath].setPoints(pontoi);
		if (customersArray[theshpelath].getPoints()>=200)
		{
			System.out.println("Congratulations! You won a discount check!");
			pontoi=-200;
			customersArray[theshpelath].setPoints(pontoi);
		}
	}

    public static void printCustomers()
    {
		for(int i=0; i<customersArray.length; i++) {
			if(customersArray[i]!=null)
			   System.out.println(customersArray[i].toString());
		   }
    }

    public static void insertCustomer()
    {
		Scanner input=new Scanner(System.in);
		String name1;
		String surname1;
		String adress1;
		int telephone1;
		System.out.println("Enter the customer's name: \n\n");
		name1=input.next();
		System.out.println("Enter the customer's surname: \n\n");
		surname1=input.next();
		System.out.println("Enter the customer's address: \n\n");
		adress1=input.next();
		System.out.println("Enter the customer's phone number: \n\n");
		telephone1=input.nextInt();

		customersArray[counter_customers]=new Customers(name1, surname1, adress1, telephone1, 0);
	}













}
