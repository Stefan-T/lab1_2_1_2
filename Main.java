package com.company;
import java.util.Scanner;
class Ludi {
    String Fam, Name,Pol1;
    int Rost,Pol;
}
public class Main {
    public static Ludi [] setLudi(int k)
    {
        Scanner sc=new Scanner(System.in,"cp1251");
        Ludi []ludi=new Ludi[k];
        System.out.println("Введите информацию о людях: ");
        for (int i = 0; i < ludi.length; i++) {
            sc.nextLine();
            ludi[i]=new Ludi();
            System.out.print("Имя "+(i+1)+"-го человека => ");
            ludi[i].Name=sc.nextLine();
            System.out.print("Фамилия "+(i+1)+"-го человека => ");
            ludi[i].Fam=sc.nextLine();
            System.out.print("Рост "+(i+1)+"-го человека =>");
            ludi[i].Rost= (int) sc.nextDouble();
            System.out.print("Пол "+(i+1)+"-го человека: 1-мужчина, 2- женщина =>");
            ludi[i].Pol= (int) sc.nextDouble();
            if (ludi[i].Pol == 1){
                ludi[i].Pol1="Мужчина";
            }
            if (ludi[i].Pol == 2){
                ludi[i].Pol1="Женщина";
            }
        }
        return ludi;
    }
    public static void showLudi(Ludi[] lud) {
        for (int i = 0; i < lud.length; i++) {
            System.out.println("" + lud[i].Fam + "\t" + lud[i].Name + "\t" + lud[i].Rost + "см" + "\t" + lud[i].Pol1);
        }
    }

    public static double avgRostM(Ludi[] lud)
    {
        double s=0;
        int m=0;
        for (int i = 0; i < lud.length; i++)
            if (lud[i].Pol==1){
                m=m+1;
                s+=lud[i].Rost;
            }
        double sr=s/m;
        return (sr);
    }
    public static double avgRostZH(Ludi[] lud)
    {
        double s1=0;
        int zh=0;
        for (int i = 0; i < lud.length; i++)
            if (lud[i].Pol==2){
                zh=zh+1;
                s1+=lud[i].Rost;
            }
        double sr1=s1/zh;
        return (sr1);
    }
    public static int NomMax(Ludi[] lud)
    {
        int nommax=0;
        double max=lud[nommax].Rost;
        for (int i = 0; i < lud.length; i++)
            if (lud[i].Pol==1) {
                if (lud[i].Rost>max) {
                    max = lud[i].Rost;
                    nommax = i;
                }
            }
        return nommax;
    }
    public static void SortRost(Ludi[] lud)
    {

        for (int i = 0; i < lud.length-1; i++)
            for (int j = 0; j < lud.length-1-i; j++)
                if (lud[j].Rost>lud[j+1].Rost){
                    Ludi rab=lud[j]; // rab – рабочая переменная для перестановки
                    lud[j]=lud[j+1];
                    lud[j+1]=rab;
                }
    }
     public static Ludi findForFam(Ludi lud[], String Fam)
     {
         int nom=-1;
         for (int i = 0; i < lud.length; i++)
             if (Fam.equals(lud[i].Fam))
                 nom=i;
         if (nom!= -1){
               return lud[nom];
         }else return (null);
     }
        public static void main (String[]args){
            Scanner sc = new Scanner(System.in, "cp1251");
            System.out.println("Введите количество людей=> ");
            int n = sc.nextInt();
            Ludi[] ludi =setLudi(n);
            System.out.println("\nХарактеристики людей:");
            showLudi(ludi);
            System.out.println("Средний рост мужчин ="+avgRostM(ludi));
            System.out.println("Средний рост женщин ="+avgRostZH(ludi));
            int nommax=NomMax(ludi);
            System.out.println("\nСамый высокий мужчина :");
            showLudi (ludi[nommax]);
            SortRost(ludi);
            System.out.println("\nОтсортированный список по росту:");//
            showLudi(ludi);
            System.out.println("Введите фамилию искомых людей=> ");
            sc.nextLine();
            String sfam=sc.nextLine();
            Ludi sfind=findForFam(ludi,sfam);
            if (sfind!=null)
            {
                showLudi(sfind);
            }else System.out.println("Таких людей в списке нет");
        }
}