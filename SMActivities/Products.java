import java.util.Scanner;
public class Products
{
    private int code;
    private String name;
    private String weight;
    private double price;
    static int i;

    static Products[] productsArray=new Products[20];

    static int counter_products=0;

    public Products(String name, String weight, double price)
    {
		productsArray[counter_products]=this;
		counter_products++;
		this.name=name;
		this.weight=weight;
		this.price=price;
		this.code=counter_products;
	}
	public void setName(String name)
	{
		this.name=name;
	}

	public String getName()
	{
		return name;
	}

	public void setWeight(String weight)
	{
		   this.weight=weight;
	}

	public String getWeight()
	{
		return weight;
	}

    public void setPrice(double price)
    {
		if (price>=0.0)
		    this.price=price;
    }

    public double getPrice()
    {
		return price;
	}

    public int getCode()
    {
		return code;
	}

	public String toString()
	{
		return "Product [name=" + name + ", weight=" + weight + ", price=" + price + ", code=" + code + "]";
    }

    public static void printProduct(int number)
    {
		for(i=0; i<productsArray.length; i++)
		{
			if(productsArray[i]!=null) {
			if(productsArray[i].getCode()==number)
			   System.out.println(productsArray[i].toString());
		   }
		}
	}

	public static int existanceOfCode(int number)
	{
		int existance=0;
		for(i=0; i<productsArray.length; i++)
		{
			if(productsArray[i]!=null) {
			if(productsArray[i].getCode()==number)
			existance=1;
		}
	    }
		return existance;
	}

	public static void printOfAllSales()
	{
		Scanner input=new Scanner(System.in);
		int month;
		int year;
		int [][] totalcodesquantities=new int[20][2];
		int realsize=0;

		for(int k=0; k<totalcodesquantities.length; k++)
		{
			if(productsArray[k]!=null) {
			totalcodesquantities[k][0]=productsArray[k].getCode();
			totalcodesquantities[k][1]=0;
			realsize++;
		}
		}

		System.out.println("Enter the month that you are interested in: \n\n");
		do {
		month=input.nextInt();
		} while(month<1 || month>12);
		System.out.println("Enter the year you are interested in: \n\n");
		do {
	    year=input.nextInt();
	    } while(year<0);

	    for(int i=0; i<Receipts.receiptsArray.length; i++)
	    {
			if(Receipts.receiptsArray[i]!=null) {
			if(Receipts.receiptsArray[i].getYear()==year)
			{
				if(Receipts.receiptsArray[i].getMonth()==month)
				{
					for(int l=0; l<=Receipts.receiptsArray[i].getCountercq(); l++)
					{
						totalcodesquantities[Receipts.receiptsArray[i].getCodesQuantities1(l)-1][1]+=Receipts.receiptsArray[i].getCodesQuantities2(l);
				    }
			   }
		   }
	    }
	   }

	   System.out.println("In the specified time interval, the following product sales were executed:\n\n");
	   System.out.println("Product number:       Sales:\n\n");
	   for(int i=0; i<realsize; i++)
	   {
		   System.out.println((productsArray[totalcodesquantities[i][0]-1].getName()) + "                            " + totalcodesquantities[i][1] + "\n\n");
	   }

	}











}
