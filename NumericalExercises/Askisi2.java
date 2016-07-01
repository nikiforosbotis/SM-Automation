import java.util.Scanner;
public class Askisi2
{
    public static void main(String[] args)
    {
        int arithmos;
        int counter=2;
        int exei_allo_diaireth=0;
        int arithmos_psifiwn=1;
        int neos_arithmos;
        int ipoloipo;
        double sum_gia_armstrong=0;
        Scanner input=new Scanner(System.in);
        System.out.println("Dose ton arithmo\n\n");
        do
        {
             arithmos=input.nextInt();
        } while (arithmos<=0);
        // elegxos gia to an eine zygos i monos
        if (arithmos%2==0)
          System.out.println("O arithmos eine zygos\n\n");
         else
          System.out.println("O arithmos eine monos\n\n");
        // elegxos gia to an eine protos
        while (counter<arithmos)
          {
             if (arithmos%counter==0)
               exei_allo_diaireth=1;
             counter=counter+1;
          }
        if (exei_allo_diaireth==0)
          System.out.println("O arithmos eine protos\n\n");
        else
          System.out.println("O arithmos den eine protos\n\n");
        // elegxos gia to an eine arithmos Armstrong
        neos_arithmos=arithmos/10;
        while (neos_arithmos!=0)
        {
           arithmos_psifiwn=arithmos_psifiwn+1;
           neos_arithmos=neos_arithmos/10;
	    }
	    neos_arithmos=arithmos;
	    while (neos_arithmos!=0)
	    {
			ipoloipo=neos_arithmos%10;
			sum_gia_armstrong=sum_gia_armstrong+Math.pow(ipoloipo,arithmos_psifiwn);
			neos_arithmos=neos_arithmos/10;
		}
		if (sum_gia_armstrong==arithmos)
		   System.out.println("O arithmos eine arithmos Armstrong\n\n");
		else
		   System.out.println("O arithmos den eine arithmos Armstrong\n\n");
     }
}






