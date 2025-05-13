/*
Ultimate Number Checker Program:
Available Number Testers:-
> Abundant Number:
    - Number where the sum of the factors of the number 
    (excluding the number itself) is greater than the number.
    Example(s): 12; 18; 20 etc.
> Armstrong Number:
    - Number that is equal to the sum of the cube of its digits.
    Example(s): 153; 370; 407 etc. 
> Automorphic Number:
    - Number when squared, has the original number in the same position.
    Example(s): 5; 6; 76 etc.
> *Buzz Number:
    - Number ending with 7 or divisible by 7.
    Example(s): 28; 57; 187 etc.
> Deficient Number:
    - Number where the sum of the factors of the number
    (excluding the number itself) is lesser than the number.
    Example(s): 8; 15; 27 etc.
> Disarium Number:
    - Number  that is equal to the sum of each of its digits
    raised to the power of their position in the number.
    Example(s): 89; 175; 518 etc.
> Harshad | Niven Number:
    - Number that is divisible by the sum of its digits.
    Example(s): 18; 50; 216 etc.
> *Magic Number:
    - Number that is the product of its sum and the reverse of its sum.
    Example(s): 1729 etc.
> *Neon Number:
    - Number that is equal to the sum of the digits of its square.
    Example(s): 0; 1; 9 (No other neon numbers known).
[Version 1.2 - 12 | 02 | 2024 -> 15 | 02 | 2024 -- Radical Aviator]
*/
import java.util.*;
class UltimateNumberChecker_V3
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
        for (int i = 0; i < (Factors.size()); i++)
        {
            System.out.print("| " + (Factors.get(i)) + " |");
            Sum += (Factors.get(i));
        }
        System.out.println();
        Sum -= no;
        return Sum;
    }
    static long SumOfDigits (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no);
        int no_digits;
        no_digits = NumberOfDigits(no);
        long SumOfDigits = 0;
        for (int i = 0; i < no_digits; i++)
        {
            SumOfDigits += Digits.get(i);
        }
        return SumOfDigits;
    }
    static long ReverseOfNumber (long no)
    {
        long Reverse_Number = 0;
        long digit;
        int no_digits;
        no_digits = NumberOfDigits(no);
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no);
        for (int i = no_digits; i > 0; i--)
        {
            digit = Digits.get(no_digits - i);
            Reverse_Number += (digit * Math.pow(10,i-1));
        }
        return Reverse_Number;
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
    static boolean IsNumberArmstrong (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no);
        long cube_no;
        long Sum = 0;
        System.out.print("Digits: ");
        for (int i = 0; i < (Digits.size()); i++)
        {
            System.out.print("| " + Digits.get(i) + " --> ");
            cube_no = (long)(Math.pow((Digits.get(i)),3));
            System.out.print(cube_no + " |");
            Sum += cube_no;
        }
        System.out.println("\nSum = " + Sum);
        if (Sum == no)
        {
            System.out.println(Sum + " = " + no);
            return true;
        }
        else
        {
            System.out.println(Sum + " != " + no);
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
    static boolean IsNumberBuzz (long no)
    {
        long final_digit;
        long rest_no;
        final_digit = no % 10;
        rest_no = no / 10;
        long remainder;
        remainder = no % 7;
        if ((final_digit == 7)||(remainder == 0))
        {
            if (final_digit == 7)
            {
                System.out.println(no + " --> " + rest_no + " | " + final_digit);
            }
            if (remainder == 0)
            {
                System.out.println(no + " / 7 = " + (no / 7));
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    static boolean IsNumberDeficient (long no)
    {
        long sum = SumOfFactors(no);
        System.out.println("Sum of Factors = " + sum);
        if (sum < no)
        {
            System.out.println(sum + " < " + no);
            return true;
        }
        else 
        {
            System.out.println(sum + " >= " + no);
            return false;
        }
    }    
    static boolean IsNumberDisarium (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no);
        long digit;
        int no_digits = NumberOfDigits(no);
        int power;
        long value;
        long sum = 0;
        System.out.print("Digits: ");
        for (int i = no_digits - 1; i >= 0; i--)
        {
            digit = Digits.get(i);
            System.out.print("|" + digit + "^");
            power = no_digits - i;
            System.out.print(power + " --> ");
            value = (long)(Math.pow(digit, power));
            System.out.print(value + "|");    
            sum += value;
        }
        if ((long)sum == no)
        {
            System.out.println("\n" + sum + " = " + no);
            return true;
        }
        else
        {
            System.out.println("\n" + sum + " != " + no);
            return false;
        }
    }
    static boolean IsNumberHarshad(long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no);
        int no_digits = NumberOfDigits(no);
        long digit;
        long s_factor = 0;
        System.out.print("Digits:");
        for (int i = 0; i <  no_digits; i++)
        {
            digit = Digits.get(i);
            System.out.print("|" + digit + "|");
            s_factor += digit;
        }
        System.out.println("\nSum of Digits = " + s_factor);
        if (no % s_factor == 0)
        {
            System.out.println(s_factor + " is a factor of " + no);
            System.out.println(no + " / " + s_factor + " = " + (no / s_factor));
            return true;
        }
        else
        {
            System.out.println(s_factor + " is not a factor of " + no);
            return false;
        }
    } 
    static boolean IsNumberMagic (long no)
    {
        long sum_digits;
        sum_digits = SumOfDigits(no);
        long reverse_sum;
        reverse_sum = ReverseOfNumber(sum_digits);
        long f_product;
        f_product = sum_digits * reverse_sum;
        System.out.println("Sum of Digits of " + no + " = " + sum_digits);
        System.out.println("Reverse of Sum of Digits of " + no + " = " + reverse_sum);
        System.out.println("Product = " + sum_digits + " * " + reverse_sum + " = " + f_product);
        if (f_product == no)
        {
            System.out.println(f_product + " = " + no);
            return true;
        }
        else
        {
            System.out.println(f_product + " != " + no);
            return false;
        }
    }
    static boolean IsNumberNeon (long no)
    {
        long square_no;
        square_no = (long)Math.pow(no,2);
        System.out.println("Square of " + no + " = " + square_no);
        ArrayList<Long> Digits = new ArrayList<>();
        long digit;
        Digits = DigitsOfNumber(square_no);
        System.out.print("Digits of " + square_no + ": ");
        for (int i = Digits.size() - 1; i >= 0; i--)
        {
            digit = Digits.get(i);
            System.out.print("|" + digit + "|");
        }
        System.out.println();
        long sum_sq_digits;
        sum_sq_digits = SumOfDigits(square_no);
        System.out.println("Sum of Digits of " + square_no + " = " + sum_sq_digits);
        if (sum_sq_digits == no)
        {
            System.out.println(sum_sq_digits + " = " + no);
            return true;
        }
        else
        {
            System.out.println(sum_sq_digits + " != " + no);
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
            System.out.println("2 - Armstrong Number");
            System.out.println("3 - Automorphic Number");
            System.out.println("4 - Buzz Number");
            System.out.println("5 - Deficient Number");
            System.out.println("6 - Disarium Number");
            System.out.println("7 - Harshad Number | Niven Number");
            System.out.println("8 - Magic Number");
            System.out.println("9 - Neon Number");
            System.out.println();
            choice = sc.nextInt();
            System.out.println();
            switch(choice)
            {
                case 1:
                    System.out.println("ABUNDANT NUMBER?");
                    boolean IsNoAbundant = false;
                    IsNoAbundant = IsNumberAbundant(no);
                    if(IsNoAbundant == true)
                    {
                        System.out.println(no + " IS an Abundant Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T an Abundant Number!");
                    }
                break;
                case 2:
                    System.out.println("ARMSTRONG NUMBER?");
                    boolean IsNoArmstrong = false;
                    IsNoArmstrong = IsNumberArmstrong(no);
                    if(IsNoArmstrong == true)
                    {
                        System.out.println(no + " IS an Armstrong Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T an Armstrong Number!");
                    }
                break;
                case 3:
                    System.out.println("AUTOMORPHIC NUMBER?");
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
                case 4:
                    System.out.println("BUZZ NUMBER?");
                    boolean IsNoBuzz = false;
                    IsNoBuzz = IsNumberBuzz(no);
                    if(IsNoBuzz == true)
                    {
                        System.out.println(no + " IS a Buzz Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Buzz Number!");
                    }
                break;
                case 5:
                    System.out.println("DEFICIENT NUMBER?");
                    boolean IsNoDeficient = false;
                    IsNoDeficient = IsNumberDeficient(no);
                    if(IsNoDeficient == true)
                    {
                        System.out.println(no + " IS a Deficient Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Deficient Number!");
                    }
                break;
                case 6:
                    System.out.println("DISARIUM NUMBER?");
                    boolean IsNoDisarium = false;
                    IsNoDisarium = IsNumberDisarium(no);
                    if(IsNoDisarium == true)
                    {
                        System.out.println(no + " IS a Disarium Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Disarium Number!");
                    }
                break;
                case 7:
                    System.out.println("HARSHAD NUMBER? | NIVEN NUMBER?");
                    boolean IsNoHarshad = false;
                    IsNoHarshad = IsNumberHarshad(no);
                    if(IsNoHarshad == true)
                    {
                        System.out.println(no + " IS a Harshad | Niven Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Harshad | Niven Number!");
                    }
                break;
                case 8:
                    System.out.println("MAGIC NUMBER?");
                    boolean IsNoMagic = false;
                    IsNoMagic = IsNumberMagic(no);
                    if(IsNoMagic == true)
                    {
                        System.out.println(no + " IS a Magic Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Magic Number!");
                    }
                break;
                case 9:
                    System.out.println("NEON NUMBER?");
                    boolean IsNoNeon = false;
                    IsNoNeon = IsNumberNeon(no);
                    if(IsNoNeon == true)
                    {
                        System.out.println(no + " IS a Neon Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Neon Number!");
                    }
                break;
                default:
                    System.out.println("-Unknown Tester-");
                break;
            }
            System.out.println("Do you want to restart the |ULTIMATE NUMBER? PROGRAM|?"); //*
            System.out.print("Yes = Y/ y |No =  [Any  other  letter] \t");
            restart = sc.next().charAt(0);
            System.out.println("\n");
        }
        while (restart == 'Y' || restart == 'y');
    }
}
