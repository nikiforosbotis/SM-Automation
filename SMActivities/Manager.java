public class Manager extends Employee
{
	protected int years;

	public Manager(String e_name, String e_surname, int married, String username, int password, int years)
	{
		super(e_name, e_surname, married, username, password);
		this.years=years;
	}

	@Override
	public String toString()
	{
		return super.toString()+ ", year's salary=" + calculateSalary() + "euro" + ", years of previous experience=" + years + "]";
	}

	@Override
	public int calculateSalary()
	{
		int salary=800;
		salary+=(years/5)*50;

		return super.calculateSalary()+salary;
	}






}