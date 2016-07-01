import java.util.Scanner;
public class Askisi1
{
    public static void main(String[] args)
    {
         Scanner input=new Scanner(System.in);
         double sum=0;
         int max=0;
         int min=10;
         int vathm;
         double voithitiki;
         double diakimansi=0;
         double typikh_apoklish;
         double mo;
         for (int counter=1; counter<=10; counter++)
         {
             do
             {
                System.out.printf("Dose tin %d vathmologia\n\n", counter);
                vathm=input.nextInt();
             } while (vathm<0 || vathm>10);
             // o elegxos egkurothtas den einai aparaithtos apla etsi eksasfalizetai oti oi times pou tha dosei o xrhsths einai mesa sta apodekta oria
             sum=sum+vathm;
             if (vathm>max)
               max=vathm;
             if (vathm<min)
               min=vathm;
          }
          mo=sum/10.0;
          System.out.printf("Mesos Oros: %f\n\n", mo);
          System.out.printf("Max: %d\n\n", max);
          System.out.printf("Min: %d\n\n", min);
          // Oi vathmologies ksanazhtountai apo ton xrhsth giati otan mas anatethike i ergasia den eixame didaxthei pinakes kai ap to na ginei xrhsh 10 metavlitwn, protimithike auto
          for (int counter=1; counter<=10; counter++)
          {
			   do
			   {
				   System.out.printf("Dose tin %d vathmologia\n\n", counter);
				   vathm=input.nextInt();
			   } while (vathm<0 || vathm>10);
			   // i metavliti "voithitiki" xrhsimopoieitai gia dieukolinsi to anagwnsth prokeimenou na einai perissotero emfanes to pws vrisketai i diakimansi, tetragwniki riza ths opoias einai i typikh apoklish
			   voithitiki=vathm-mo;
			   diakimansi=diakimansi+Math.pow(voithitiki,2);
		   }
		   diakimansi=diakimansi/10;
		   typikh_apoklish=Math.pow(diakimansi,(1/2));
		   System.out.printf("Typiki apoklisi %f\n\n", typikh_apoklish);
     }
 }

