import java.util.Scanner;
public class Receipts
{
	private int code;
	private int day;
	private int countercq;
	private int month;
	private int year;
	private double total_cost;
	private double cash;
	private int [][] codesQuantities=new int[20][2];

	static Receipts[] receiptsArray=new Receipts[20];
	static int counter_receipts=0;

	public Receipts(int day, int month, int year,  double cash, double total_cost, int[][] codesQuantitiesArray, int countercq)
	{
		receiptsArray[counter_receipts]=this;
		counter_receipts++;
		this.day=day;
		this.month=month;
		this.year=year;
		this.cash=cash;
		this.code=counter_receipts;
		this.total_cost=total_cost;
		this.countercq=countercq;
		codesQuantities=codesQuantitiesArray;
	}

	public void setDay(int day)
	{
		this.day=day;
	}

	public int getDay()
	{
		return day;
	}

	public void setMonth(int month)
	{
		this.month=month;
	}

	public int getMonth()
	{
		return month;
	}

	public void setYear(int year)
	{
		this.year=year;
	}

	public int getYear()
	{
		return year;
	}

	public void setCash(double cash)
	{
		this.cash=cash;
	}

	public double getCash()
	{
		return cash;
	}

	public int getCountercq()
	{
		return countercq;
	}

    public int getCodesQuantities1(int i)
    {
		return codesQuantities[i][0];
	}

	public int getCodesQuantities2(int i)
	{
		return codesQuantities[i][1];
	}

	public double getTotalCost()
	{
		return total_cost;
	}

	public int getCode()
	{
		return code;
	}


	public String toString()
	{
		return "********** #" + receiptsArray[counter_receipts-1].getCode() + " **********" + "\n\n" +
		" " + receiptsArray[counter_receipts-1].getDay() + "/" + receiptsArray[counter_receipts-1].getMonth() + "/" + receiptsArray[counter_receipts-1].getYear() + "\n\n";
	}

	public static void paymentOfProducts()
	{
		Scanner input=new Scanner(System.in);
		int answer;
		int day;
		int month;
		int year;
		int quantity;
		int number=0;
		int card_number=0;
		int found=0;
		int counter1=0;
		double cash_amount;
		double total_amount=0;
		System.out.println("Will the customer use the points card for this transaction? If yes, press 1; otherwise press 0. \n\n");
		answer=input.nextInt();
		if (answer==1)
		{
			while (found==0) {
			System.out.println("Please enter the number of the points card");
			card_number=input.nextInt();
			if (Customers.existanceOfCardCode(card_number)==0)
				System.out.println("The card number that you entered does not exist in our Database. Please try again. \n\n");
		    else
		        found=1;
			}
		}

		System.out.println("The procedure of the checkout for the products is now being started. If you wish to stop, please enter -1 (in the product number field). \n\n");
		while (number!=-1)
		{
			System.out.println("Please enter the number of the next product");
			number=input.nextInt();
			if (Products.existanceOfCode(number)==1)
			{
				System.out.println("Now enter the quantity");
				do {
				quantity=input.nextInt();
			} while (quantity<=0);
			cqarray[counter1][0]=number;
			cqarray[counter1][1]=quantity;
			total_amount+=Products.productsArray[number-1].getPrice()*quantity;
			counter1++;
		}
		else if(number!=-1) {
		    System.out.println("The number that you entered does not exist. Please give another code number. \n\n");
		}
	    }
		System.out.println("Now enter the day of the transaction. \n\n");
		do {
		day=input.nextInt();
	    } while(day<1 || day>30);
		System.out.println("the month.. \n\n");
		do {
		month=input.nextInt();
	    } while(month<1 || month>12);
		System.out.println("and the year. \n\n");
		do {
		year=input.nextInt();
	    } while(year<0);
		System.out.println("now enter the amount of cash that was given by the customer. ");
		do {
		cash_amount=input.nextDouble();
	    } while(cash_amount<total_amount);

		receiptsArray[counter_receipts]=new Receipts(day, month, year, cash_amount, total_amount, cqarray, counter1-1);

		System.out.println(receiptsArray[counter_receipts-1].toString());
		for (int i=0; i<counter1; i++) {
			System.out.printf("%s  ", Products.productsArray[cqarray[i][0]-1].getName());
	        System.out.printf("%d * %f = ", cqarray[i][1], Products.productsArray[cqarray[i][0]-1].getPrice());
	        System.out.printf("%f\n\n", cqarray[i][1]*Products.productsArray[cqarray[i][0]-1].getPrice());
	   }
	   System.out.printf("Total Cost:  %f\n\n", receiptsArray[counter_receipts-1].getTotalCost());
	   System.out.printf("Amount of Cash:  %f\n\n", receiptsArray[counter_receipts-1].getCash());
	   System.out.printf("Change:  %f\n\n",receiptsArray[counter_receipts-1].getCash()-receiptsArray[counter_receipts-1].getTotalCost());

	   if (answer==1)
			Customers.handlingOfPoints(card_number, total_amount);

     }






































}
