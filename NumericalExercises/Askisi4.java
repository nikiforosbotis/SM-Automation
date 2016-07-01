import java.util.Random;
import java.util.Scanner;
public class Askisi4
{
  public static void main(String[] args)
  {
	  Random randomNumbers=new Random();
	  Scanner input=new Scanner(System.in);
	  int zari1;
	  int zari2;
	  int zari3;
	  int set=2;
	  int apanthsh;
	  int apanthsh_zaria;
	  System.out.println("Ta zaria gia to 1 set exoun tis ekshs times:\n\n");
	  zari1=1+randomNumbers.nextInt(6);
	  zari2=1+randomNumbers.nextInt(6);
	  zari3=1+randomNumbers.nextInt(6);
	  System.out.printf("zari1: %d, zari2: %d, zari3: %d\n\n", zari1, zari2, zari3);
	  System.out.println("An thes na ksanarikseis pata 1, an thes na stamathseis 0\n\n");
	  apanthsh=input.nextInt();
	  if (apanthsh==1) {
		  System.out.println("Thes na ksanarikseis to zari1? An nai pata 1 alliws 0\n\n");
		  apanthsh_zaria=input.nextInt();
		  if (apanthsh_zaria==1)
		      zari1=1+randomNumbers.nextInt(6);
		  System.out.println("Thes na ksanarikseis to zari2? An nai pata 1 alliws 0\n\n");
		  apanthsh_zaria=input.nextInt();
		  if (apanthsh_zaria==1)
		      zari2=1+randomNumbers.nextInt(6);
		   System.out.println("Thes na ksanarikseis to zari3? An nai pata 1 alliws 0\n\n");
		   apanthsh_zaria=input.nextInt();
		  if (apanthsh_zaria==1)
		     zari3=1+randomNumbers.nextInt(6);
			 }
	  while (set<=3 && apanthsh==1)
	  {
	  System.out.printf("Ta zaria gia to %d set exoun tis ekshs times:\n\n", set);
	  set=set+1;
	  System.out.printf("zari1: %d, zari2: %d, zari3: %d\n\n", zari1, zari2, zari3);
	  System.out.println("An thes na ksanarikseis pata 1, an thes na stamathseis 0\n\n");
	  apanthsh=input.nextInt();
	  if (set==4)
		  System.out.println("Den boreis na rikseis allh fora\n\n");
	 else {
	  if (apanthsh==1) {
	      System.out.println("Thes na ksanarikseis to zari1? An nai pata 1 alliws 0\n\n");
		  apanthsh_zaria=input.nextInt();
		  if (apanthsh_zaria==1)
		     zari1=1+randomNumbers.nextInt(6);
		  System.out.println("Thes na ksanarikseis to zari2? An nai pata 1 alliws 0\n\n");
		  apanthsh_zaria=input.nextInt();
		  if (apanthsh_zaria==1)
		     zari2=1+randomNumbers.nextInt(6);
		  System.out.println("Thes na ksanarikseis to zari3? An nai pata 1 alliws 0\n\n");
		  apanthsh_zaria=input.nextInt();
		  if (apanthsh_zaria==1)
		     zari3=1+randomNumbers.nextInt(6);

    }
   }

   }

      if ((zari1==1 && zari2==2 && zari3==3) || (zari1==1 && zari2==3 && zari3==2) || (zari1==2 && zari2==1 && zari3==3) || (zari1==2 && zari2==3 && zari3==2) || (zari1==3 && zari2==1 && zari3==2) || (zari1==3 && zari2==2 && zari3==1))
         System.out.println("Auto pou petyxes einai: Three High Straight");
      else if ((zari1==zari2) && (zari2==zari3))
         System.out.println("Auto pou petyxes einai: Three-of-a-kind");
      else if ((zari1==zari2) || (zari1==zari3) || (zari2==zari3))
         System.out.println("Auto pou petyxes einai: Pair");
      else
         System.out.println("Auto pou petyxes einai: Nothing");

  }
 }