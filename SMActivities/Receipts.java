import java.util.Scanner;
public class Receipts
{
	private int code;
	private int day; //υποθέτουμε οτι ο υπάλληλος εισάγει την ημέρα με τον αριθμό (όπως και τον μήνα) και όχι με το όνομά της
	private int countercq; //μετρητής των στοιχείων του δισδιάστατου
	private int month;
	private int year;
	private double total_cost;
	private double cash;
	private int [][] codesQuantities=new int[20][2]; //στην πρώτη στήλη αποθηκεύονται οι κωδικοί των προιόντων και στην δεύτεροι οι αντίστοιχες ποσότητες

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

    public int getCodesQuantities1(int i) //επιστρέφει τον κωδικό που βρίσκεται στη θέση i του πίνακα codesQuantities
    {
		return codesQuantities[i][0];
	}

	public int getCodesQuantities2(int i) //επιστρέφει την ποσότητα που αντιστοιχεί στον κωδικό που βρίσκεται στη θέση i του πίνακα codesQuantities
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
		return "********** Έκδοση απόδειξης #" + receiptsArray[counter_receipts-1].getCode() + " **********" + "\n\n" +
		"Ημερομηνία έκδοσης " + receiptsArray[counter_receipts-1].getDay() + "/" + receiptsArray[counter_receipts-1].getMonth() + "/" + receiptsArray[counter_receipts-1].getYear() + "\n\n";
	}

	public static void paymentOfProducts()
	{
		Scanner input=new Scanner(System.in);
		int answer;
		int mera;
		int mhnas;
		int xronos;
		int quantity;
		int kwdikos=0;
		int kwdikoskartas=0;
		int found=0; //αναφέρεται στο αν βρέθηκε ο κωδικός της κάρτας του πελάτη στο σύστημα (θεωρούμε δεδομένο ότι εφόσοσον ο χρήστης επιλέξει να εισάγει αριθμό κάρτας, θα το επαναλάβει μέχρι να βάλει τον σωστό-δηλ. κάποιον υπαρκτό για μας)
		int [][] cqarray=new int[20][2];
		int counter1=0;
		double metrhta;
		double synolikokostos=0;
		System.out.println("Tha xrhsimopoihsei o pelaths thn karta me tous pontous tou gia thn synallagh?An nai pata 1, alliws 0\n\n");
		answer=input.nextInt();
		if (answer==1)
		{
			while (found==0) {
			System.out.println("Dose ton kwdiko ths kartas pontwn");
			kwdikoskartas=input.nextInt();
			if (Customers.existanceOfCardCode(kwdikoskartas)==0)
				System.out.println("O kwdikos kartas pou eisagate den yparxei kataxwrhmenos sto systhma pelatwn. Parakalw eisagete ksana.\n\n");
		    else
		        found=1;
			}
		}

		System.out.println("Ksekinaei i diadikasia perasmatos twn proiontwn. Gia na stamathsete eisagete ston kwdiko proiontos to -1\n\n");
		while (kwdikos!=-1)
		{
			System.out.println("Dose ton kwdiko tou epomenou proiontos");
			kwdikos=input.nextInt();
			if (Products.existanceOfCode(kwdikos)==1)
			{
				System.out.println("Tora dose thn posothta");
				do {
				quantity=input.nextInt();
			} while (quantity<=0);
			cqarray[counter1][0]=kwdikos;
			cqarray[counter1][1]=quantity;
			synolikokostos+=Products.productsArray[kwdikos-1].getPrice()*quantity; //το όρισμα του πίνακα είναι kwdikos-1 επειδή οι κωδικοί των προιόντων αρχίζουν απ'το 1 ενώ τα κελιά του πίνακα απ'το 0
			counter1++;
		}
		else if(kwdikos!=-1) {
		    System.out.println("O kwdikos pou eisagate den yparxei. Parakalw eisagete neo kwdiko.\n\n");
		}
	    }
		System.out.println("Tora dwse thn hmera pou pragmatopoihthike i synallagh\n\n");
		do {
		mera=input.nextInt();
	    } while(mera<1 || mera>30);
		System.out.println("ton mhna..\n\n");
		do {
		mhnas=input.nextInt();
	    } while(mhnas<1 || mhnas>12);
		System.out.println("kai ton xrono\n\n");
		do {
		xronos=input.nextInt();
	    } while(xronos<0);
		System.out.println("tora eisagete ton arithmo twn metrhtwn pou edose o xrhsths");
		do {
		metrhta=input.nextDouble();
	    } while(metrhta<synolikokostos);

		receiptsArray[counter_receipts]=new Receipts(mera, mhnas, xronos, metrhta, synolikokostos, cqarray, counter1-1);

		System.out.println(receiptsArray[counter_receipts-1].toString());
		for (int i=0; i<counter1; i++) {
			System.out.printf("%s  ", Products.productsArray[cqarray[i][0]-1].getName());
	        System.out.printf("%d * %f = ", cqarray[i][1], Products.productsArray[cqarray[i][0]-1].getPrice());
	        System.out.printf("%f\n\n", cqarray[i][1]*Products.productsArray[cqarray[i][0]-1].getPrice());
	   }
	   System.out.printf("Σύνολο:   %f\n\n", receiptsArray[counter_receipts-1].getTotalCost());
	   System.out.printf("Μετρητά:   %f\n\n", receiptsArray[counter_receipts-1].getCash());
	   System.out.printf("Ρέστα:   %f\n\n",receiptsArray[counter_receipts-1].getCash()-receiptsArray[counter_receipts-1].getTotalCost());

	   if (answer==1) //η περίπτωση που ο χρήστης επιλέξει να δώσει τον αριθμό της κάρτας πόντων του
			Customers.handlingOfPoints(kwdikoskartas, synolikokostos);

     }






































}