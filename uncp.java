/*
Ultimate Number Checker Program:
Available Number Testers:- (2)
> Abundant Number
    - Number where the sum of the factors of the number 
    (excluding the number itself) is greater than the number.
    Examples: 12; 18; 20 etc.
> Automorphic Number
    - Number when squared, has the original number in the same position.
    Examples: 5; 6; 76 etc.
[Version 1.0 - 30 | 01 | 2024 -- Radical-Aviator]
*/
import java.util.*;
class UltimateNumberCheckerProgram
{
    static int NumberOfDigits (long no)
    {
        int no_digits = 0;
        long copy_no = no;
        while (copy_no > 0)
        {
            copy_no /= 10;
            no_digits++;
        }
        return no_digits;
    }
    static ArrayList<Long> DigitsOfNumber (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        long copy_no = no;
        long digit;
        while (copy_no > 0)
        {
            digit = copy_no % 10;
            copy_no /= 10;
            Digits.add(digit);
        }
        return Digits;
    }
    static int NumberOfFactors (long no)
    {
        int no_factors = 0;
        for (int i = 1; i <= no; i++)
        {
            if (no % i == 0)
            {
                no_factors++;
            }
        }
        return no_factors;
    }
    static ArrayList<Long> FactorsOfNumber (long no)
    {
        ArrayList<Long> Factors = new ArrayList<>();
        for (long i = 1; i <= no; i++)
        {
            if (no % i == 0)
            {
                Factors.add(i);
            }
        }
        return Factors;
    }
    static long SumOfFactors (long no)
    {
        ArrayList<Long> Factors = new ArrayList<>();
        Factors = FactorsOfNumber(no);
        long Sum = 0;
        System.out.print("Factors of " + no + ": ");
        for (int i = 0; i < (Factors.size() - 1); i++)
        {
            System.out.print("| " + (Factors.get(i)) + " |");
            Sum += (Factors.get(i));
        }
        System.out.println();
        return Sum;
    }
    
    static boolean IsNumberAbundant (long no)
    {
        long sum = SumOfFactors(no);
        System.out.println("Sum of Factors = " + sum);
        if (sum > no)
        {
            System.out.println(sum + " > " + no);
            return true;
        }
        else 
        {
            System.out.println(sum + " <= " + no);
            return false;
        }
    }
    static boolean IsNumberAutomorphic (long no)
    {
        int no_digits = NumberOfDigits(no);
        long square_no = (long)(Math.pow(no,2));
        System.out.println("Square Of " + no + " = " + square_no);
        long no2 = square_no % (long)(Math.pow(10,no_digits));
        System.out.println(square_no + " -_-_- " + no2);
        if (no2 == no)
        {
            System.out.println(no2 + " = " + no);
            return true;
        }
        else
        {
            System.out.println(no2 + " != " + no);
            return false;
        }
    }
    
    public static void main (String[]args)
    {
        System.out.print("\u000c");
        char restart = 'Y';
        do
        {
            Scanner sc = new Scanner (System.in);
            int choice;
            long no;
            System.out.print("The Ultimate Number Checker! - Enter Number: ");
            no = sc.nextLong();
            System.out.println("Enter Requested Tester: \t");
            System.out.println("1 - Abundant Number");
            System.out.println("2 - Automorphic Number");
            choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("ABUNDANT NUMBER CHECKER");
                    boolean IsNoAbundant = false;
                    IsNoAbundant = IsNumberAbundant(no);
                    if(IsNoAbundant == true)
                    {
                        System.out.println(no + " IS an Abdundant Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T an Abundant Number!");
                    }
                break;
                case 2:
                    System.out.println("AUTOMORPHIC NUMBER CHECKER");
                    boolean IsNoAutomorphic = false;
                    IsNoAutomorphic = IsNumberAutomorphic(no);
                    if(IsNoAutomorphic == true)
                    {
                        System.out.println(no + " IS an Automorphic Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T an Automorphic Number!");
                    }
                break;
                default:
                    System.out.println("-Unknown Tester-");
                break;
            }
            System.out.println("Do you want to restart the |ULTIMATE NUMBER CHECKER PROGRAM|?");
            System.out.print("Yes = Y/ y |No =  [Any  other  letter] \t");
            restart = sc.next().charAt(0);
            System.out.println("\n");
        }
        while (restart == 'Y' || restart == 'y');
        }
}
