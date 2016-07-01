import java.util.Scanner;
public class Askisi3
{
	public static void main(String[] args)
	{
		float arxiko_poso;
		float resta;
		float poso_pou_apomenei;
		int prohgoumeno_xartonomisma;
		int trexon_poso=0;
		int xartonomisma=0;
		Scanner input=new Scanner(System.in);
		System.out.println("Parakalw eisagete to poso plhrwmhs\n\n");
		arxiko_poso=input.nextFloat();
		if (arxiko_poso>1000)
		{
			System.out.println("I synnalagh den borei na pragmatopoihthei\n\n");
		}
		else {
			do {
				System.out.println("Dose to epomeno xartonomisma (to systhma dexetai mono xartonomismata twn 50,20,10,5 euro)\n\n");
				xartonomisma=input.nextInt();
			}  while (xartonomisma!=5 && xartonomisma!=10 && xartonomisma!=20 && xartonomisma!=50);
			// Apothikeuoume to proto xartonomisma wste na epomena pou tha dosei na einai isa i mikrotera apo auto efoson i ekfwnhsh leei oti o xrhsths "dinei diadoxika" xartonomismata twn 50,20,10 & 5 eurw
			prohgoumeno_xartonomisma=xartonomisma;
			trexon_poso=trexon_poso+xartonomisma;
			while (trexon_poso<arxiko_poso)
			{
				poso_pou_apomenei=arxiko_poso-trexon_poso;
				System.out.printf("To poso pou apomenei gia na oloklirothei i synallagh einai: %f\n\n", poso_pou_apomenei);
				do
				{
				System.out.println("Dose to epomeno xartonomisma (to systhma dexetai mono xartonomismata twn 50,20,10,5 euro)\n\n");
				xartonomisma=input.nextInt();
			    } while ((xartonomisma!=5 && xartonomisma!=10 && xartonomisma!=20 && xartonomisma!=50) || (xartonomisma>prohgoumeno_xartonomisma));
			    trexon_poso=trexon_poso+xartonomisma;
			    prohgoumeno_xartonomisma=xartonomisma;
			}
			if (trexon_poso==arxiko_poso)
			    System.out.println("I synallagh oloklirothike!\n\n");
			else {
				resta=trexon_poso-arxiko_poso;
				System.out.printf("I sinallagh oloklirothike! Ta resta sas einai: %f\n\n", resta);
			}
		}

}
    }