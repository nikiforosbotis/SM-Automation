import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
public class Employee
{
	protected int employee_code;
	protected String e_name;
	protected String e_surname;
	protected int married; //υποθέτουμε ότι αν είναι παντρεμένος η μεταβλητή θα έχει την τιμή 1, αλλιώς την τιμή 0
	protected String username;
	protected int password;

	protected static Employee[] employeeArray=new Employee[20];
	protected static int counter_employee=0;

	public Employee(String e_name, String e_surname, int married, String username, int password)
	{
		employeeArray[counter_employee]=this;
		counter_employee++;
		this.e_name=e_name;
		this.e_surname=e_surname;
		this.married=married;
		this.username=username;
		this.password=password;
		this.employee_code=counter_employee;
	}

	@Override
	public String toString()
	{
		return "Empoloyee [employee's code="+ employee_code + ", employee's name=" + e_name + ", employee's surname=" + e_surname + ", employee's personal statement (1 for married, 0 for single)=" + married + ", employee's username="+ username + ", employee's password="+ password;
	}

	public int calculateSalary()
	{
		int salary=0;
		for(int i=0; i<employeeArray.length; i++)
		{
			if(employeeArray[i]!=null)
			{
				if(employeeArray[i].married==1)
				   salary+=150;
	        }
		 }
		 return salary;
	 }

	 public static int controlUsernamePass(String username1, int password1)
	 {
		 int thesi=-1;
		 for(int i=0; i<employeeArray.length; i++)
		 {
			 if(employeeArray[i]!=null) {
			 if((employeeArray[i].username).equals(username1))
			 {
				 if (employeeArray[i].password==password1)
				    thesi=i;
				}
			}
		}
		return thesi;
	}

	 public static void printEmployeesCmdTxt()
		  {
			  String employees="";
			  for(int i=0; i<Employee.employeeArray.length; i++)
			  {
				  if(employeeArray[i]!=null)
				  {
					  employees=employees+employeeArray[i]+"\r\n";
				  }
			  }
			  try {
				  FileWriter fstream =new FileWriter ("employees.txt");
				  BufferedWriter out= new BufferedWriter(fstream);
				  out.write(employees);
				  out.close();
				  System.out.println("**Writing in txt done!!**\n" + employees);
			  } catch (Exception ex) {
				  ex.printStackTrace();
			  }
		  }










}