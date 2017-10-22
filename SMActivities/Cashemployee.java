public class Cashemployee extends Employee
{
	protected String kind;
	protected int overtime;

	public Cashemployee(String e_name, String e_surname, int married, String username, int password, String kind, int overtime)
	{
		super(e_name, e_surname, married, username, password);
		this.kind=kind;
		this.overtime=overtime;
	}

	@Override
	public String toString()
	{
		return super.toString()+ ", year's salary=" + calculateSalary() + "euro" + ", kind of employement=" + kind + ", overtime hours=" + overtime + "]";
	}

	@Override
	public int calculateSalary()
	{
		int salary=0;
		if(kind.equals("fulltime"))
		   salary+=800;
		else
		   salary+=400;

		salary+=overtime*7;

		return super.calculateSalary()+salary;

	}

}
