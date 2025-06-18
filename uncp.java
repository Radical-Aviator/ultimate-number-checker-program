/*
Ultimate Number? Program:
Available Number Testers:-
> *AbuDePe Block:-
    > Abundant Number:
        - Number where the sum of the factors of the number 
        (excluding the number itself) is greater than the number.
        Example(s): 12; 18; 20 etc.
    > Deficient Number:
        - Number where the sum of the factors of the number 
        (excluding the number itself) is lesser than the number.
        Example(s): 2; 10; 29 etc.
    > *Perfect Number: 
        - Number where the sum of the factors of the number 
        (excluding the number itself) is equal to the number.
        Example(s): 6; 28; 496 etc.
> Armstrong Number:
    - Number that is equal to the sum of the cube of its digits.
    Example(s): 153; 370; 407 etc. 
> Automorphic Number:
    - Number when squared, has the original number in the same position.
    Example(s): 5; 6; 76 etc.
> Buzz Number:
    - Number ending with 7 or divisible by 7.
    Example(s): 28; 57; 187 etc.
> Disarium Number:
    - Number  that is equal to the sum of each of its digits
    raised to the power of their position in the number.
    Example(s): 89; 175; 518 etc.
> Harshad | Niven Number:
    - Number that is divisible by the sum of its digits.
    Example(s): 18; 50; 216 etc.
> Magic Number:
    - Number that is the product of its sum and the reverse of its sum.
    Example(s): 1729 etc.
> Neon Number:
    - Number that is equal to the sum of the digits of its square.
    Example(s): 0; 1; 9 (No other neon numbers known).
> *Palindrome Number:
    - Number that is equal to the reverse of itself.
    Example(s): 11; 353; 9889 etc.
> *Perfect Cube:
    - Number whose cube root is a whole number.
    Example(s): 27; 729; 1000 etc.
> *Perfect Square:
    - Number whose square root is a whole number.
    Example(s): 16; 81; 800 etc.
> *PriCo Block:-
    > *Prime Number:
        - Number that only has two factors, 1 and itself.
        Example(s): 3; 11; 223 etc.
    > *Composite Number:
        - Number that has more than two factors.
        Example(s): 9; 21; 217 etc.
    > *Neither Prime nor Composite Number:
        - Number having only one factor (i.e. 1).
        - Number having no factors (i.e 0).
        - Negative Numbers (i.e. -21; -19; -3 etc.).
> *Pronic Number:
    - Number that is equal to the product of two consecutive numbers.
    Example(s): 6; 12; 210 etc.
> *Spy Number:
    - Number whose sum of its digits is equal to the product of its digits.
    Example(s): 7; 22; 123 etc.
> *Strong Number:
    - Number whose sum of the factorial of its digits is equal to the number.
    Example(s): 2; 145; 40585 etc.
> *Sunny Number:
    - Number when increased by 1, its square root is a whole number.
    Example(s): 8; 24; 99 etc.
> *Trimorphic Number:
    - Number when cubed, has the original number in the same position.
    Example(s): 5; 6; 25 etc.
[Version 2.0 - 27 | 02 | 2024 - Radical Aviator]
*/
import java.util.*;
class UltimateNumberChecker_V4
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
    static ArrayList<Long> DigitsOfNumber (long no, char c)
    {
        ArrayList<Long> Digits_r = new ArrayList<>();
        ArrayList<Long> Digits_n = new ArrayList<>();
        long copy_no = no;
        long digit;
        int no_digits;
        no_digits = NumberOfDigits(no);
        while (copy_no > 0)
        {
            digit = copy_no % 10;
            copy_no /= 10;
            Digits_r.add(digit);
        }
        for (int i = Digits_r.size() - 1; i >= 0; i--)
        {
            digit = Digits_r.get(i);
            Digits_n.add(digit);
        }
        if (c == 'n')
        {
            return Digits_n;
        }
        else if (c == 'r')
        {
            return Digits_r;
        }
        return Digits_n;
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
        Digits = DigitsOfNumber(no, 'n');
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
        Digits = DigitsOfNumber(no, 'r');
        for (int i = no_digits; i > 0; i--)
        {
            digit = Digits.get(no_digits - i);
            Reverse_Number += (digit * Math.pow(10,i-1));
        }
        return Reverse_Number;
    }
    
    static int IsNumberAbDePe (long no)
    {
        long sum = SumOfFactors(no);
        System.out.println("Sum of Factors = " + sum);
        if (sum > no)
        {
            System.out.println(sum + " > " + no);
            return 1;
        }
        else if (sum < no)
        {
            System.out.println(sum + " < " + no);
            return -1;
        }
        else if (sum == no)
        {
            System.out.println(sum + " < " + no);
            return 0;
        }
        return 0;
    }
    static boolean IsNumberArmstrong (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no, 'n');
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
    static boolean IsNumberDisarium (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no, 'n');
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
        Digits = DigitsOfNumber(no, 'n');
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
        Digits = DigitsOfNumber(square_no, 'n');
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
    static boolean IsNumberPalindrome (long no)
    {
        long reverse_no = 0;
        reverse_no = ReverseOfNumber(no);
        System.out.println("Reverse of Number = " + reverse_no);
        if (reverse_no == no)
        {
            System.out.println(reverse_no + " = " + no);
            return true;
        }
        else
        {
            System.out.println(reverse_no + " != " + no);
            return false;
        }
    }
    static boolean IsPerfectCube (long no)
    {
        double cbrt_no;
        cbrt_no = Math.cbrt(no);
        double r_cbrt_no;
        r_cbrt_no = (double)((int)Math.cbrt(no));
        if (cbrt_no == r_cbrt_no)
        {
            System.out.println("Cube Root of " + no + " = " + (int)cbrt_no);
            return true;
        }
        else
        {
            System.out.println("Cube Root of " + no + " = " + cbrt_no);
            return false;
        }
    }
    static boolean IsPerfectSquare (long no)
    {
        double sqrt_no;
        sqrt_no = Math.sqrt(no);
        double r_sqrt_no;
        r_sqrt_no = (double)((int)Math.sqrt(no));
        if (sqrt_no == r_sqrt_no)
        {
            System.out.println("Square Root of " + no + " = " + (int)sqrt_no);
            return true;
        }
        else
        {
            System.out.println("Square Root of " + no + " = " + sqrt_no);
            return false;
        }
    }
    static int IsNumberPriCo (long no)
    {
        if (no < 0)
        {
            return 0;
        }
        ArrayList <Long> Factors = new ArrayList<>();
        Factors = FactorsOfNumber(no);
        System.out.print("Factors of " + no + ": ");
        for (int i = 0; i < (Factors.size()); i++)
        {
            System.out.print("| " + (Factors.get(i)) + " |");
        }
        int no_factors;
        no_factors = NumberOfFactors(no);
        System.out.println("\nNumber of Factors of " + no + " = " + no_factors);
        if (no_factors == 2)
        {
            return 1;
        }
        else if (no_factors > 2)
        {
            return 2;
        }
        else if (no_factors < 2)
        {
            return 0;
        }
        return 2;
    }
    static boolean IsNumberPronic (long no)
    {
        ArrayList<Long> Factors = FactorsOfNumber(no);
        long f1;
        long f2;
        for (int i = 1; i < Factors.size(); i++)
        {
            if (((Factors.get(i - 1) + 1) == Factors.get(i)) && (Factors.get(i - 1) * Factors.get(i) == no))
            {
                f1 = Factors.get(i-1);
                f2 = Factors.get(i);
                System.out.println(f1 + " * " + f2 + " = " + no);
                return true;
            }
        }
        return false;
    }
    static boolean IsNumberSpy (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no, 'n');
        int no_digits = NumberOfDigits(no);
        long digit;
        long s_digits = 0;
        long p_digits = 1;
        System.out.print("Digits of " + no + ": ");
        for (int i = 0; i <  no_digits; i++)
        {
            digit = Digits.get(i);
            System.out.print("|" + digit + "|");
            s_digits += digit;
            p_digits *= digit;
        }
        System.out.println("\nSum of Digits = " + s_digits);
        System.out.println("\nProduct of Digits = " + p_digits);
        if (s_digits == p_digits)
        {
            System.out.println(s_digits + " = " + p_digits);
            return true;
        }
        else
        {
            System.out.println(s_digits + " != " + p_digits);
            return false;
        }
    }
    static boolean IsNumberStrong (long no)
    {
        ArrayList<Long> Digits = new ArrayList<>();
        Digits = DigitsOfNumber(no, 'n');
        int no_digits;
        no_digits = NumberOfDigits(no);
        long digit;
        long factorial;
        long s_factorial = 0;
        for (int i = 0; i < no_digits; i++)
        {
            factorial = 1;
            digit = Digits.get(i);
            for (int j = 1; j <= digit; j++)
            {
                factorial *= j;
            }
            System.out.print("|" + digit + "! = " + factorial + "|");
            s_factorial += factorial;
        }
        System.out.println();
        if (s_factorial == no)
        {
            System.out.println(s_factorial + " = " + no);
            return true;
        }
        else
        {
            System.out.println(s_factorial + " != " + no);
            return false;
        }
    }
    static boolean IsNumberSunny (long no)
    {
        long no2;
        no2 = no + 1;
        System.out.println(no + " + 1 = " + no2);
        double sqrt_no2;
        sqrt_no2 = Math.sqrt(no2);
        double r_sqrt_no2;
        r_sqrt_no2 = (double)((int)Math.sqrt(no2));
        if (sqrt_no2 == r_sqrt_no2)
        {
            System.out.println("Square Root of " + no2 + " = " + (int)sqrt_no2);
            return true;
        }
        else
        {
            System.out.println("Square Root of " + no2 + " = " + sqrt_no2);
            return false;
        }
    }
    static boolean IsNumberTrimorphic (long no)
    {
        int no_digits = NumberOfDigits(no);
        long cube_no = (long)(Math.pow(no,3));
        System.out.println("Cube Of " + no + " = " + cube_no);
        long no2 = cube_no % (long)(Math.pow(10,no_digits));
        System.out.println(cube_no + " -_-_- " + no2);
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
            System.out.println("Welcome to the UN?P-V4! ");
            System.out.println("Available Testers: 17");
            System.out.println("1 - Abundant / Deficient / Perfect Number");
            System.out.println("2 - Armstrong Number");
            System.out.println("3 - Automorphic Number");
            System.out.println("4 - Buzz Number");
            System.out.println("5 - Disarium Number");
            System.out.println("6 - Harshad Number | Niven Number");
            System.out.println("7 - Magic Number");
            System.out.println("8 - Neon Number");
            System.out.println("9 - Palindrome Number");
            System.out.println("10 - Perfect Cube");
            System.out.println("11 - Perfect Square");
            System.out.println("12 - Prime / Composite Number");
            System.out.println("13 - Pronic Number");
            System.out.println("14 - Spy Number");
            System.out.println("15 - Strong Number");
            System.out.println("16 - Sunny Number");
            System.out.println("17 - Trimorphic Number");
            System.out.print("\nEnter Requested Tester: ");
            choice = sc.nextInt();
            System.out.print("Enter Number to be Tested: ");
            no = sc.nextLong();
            System.out.println();
            switch(choice)
            {
                case 1:
                    System.out.println("ABUNDANT / DEFICIENT / PERFECT NUMBER?");
                    int IsNoAbDePe = 0;
                    IsNoAbDePe = IsNumberAbDePe(no);
                    if(IsNoAbDePe == 1)
                    {
                        System.out.println(no + " is an Abundant Number!");
                    }
                    else if (IsNoAbDePe == -1)
                    {
                        System.out.println(no + " is a Deficient Number!");
                    }
                    else if (IsNoAbDePe == 0)
                    {
                        System.out.println(no + " is a Perfect Number!");
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
                case 6:
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
                case 7:
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
                case 8:
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
                case 9:
                    System.out.println("PALINDROME NUMBER?");
                    boolean IsNoPalindrome = false;
                    IsNoPalindrome = IsNumberPalindrome(no);
                    if(IsNoPalindrome == true)
                    {
                        System.out.println(no + " IS a Palindrome Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Palindrome Number!");
                    }
                break;
                case 10:
                    System.out.println("PERFECT CUBE?");
                    boolean IsPerfectCube = false;
                    IsPerfectCube = IsPerfectCube(no);
                    if(IsPerfectCube == true)
                    {
                        System.out.println(no + " IS a Perfect Cube!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Perfect Cube!");
                    }
                break;
                case 11:
                    System.out.println("PERFECT SQUARE?");
                    boolean IsPerfectSquare = false;
                    IsPerfectSquare = IsPerfectSquare(no);
                    if(IsPerfectSquare == true)
                    {
                        System.out.println(no + " IS a Perfect Square!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Perfect Square!");
                    }
                break;
                case 12:
                    System.out.println("PRIME / COMPOSITE NUMBER?");
                    int IsNoPriCo = 0;
                    IsNoPriCo = IsNumberPriCo(no);
                    if(IsNoPriCo == 1)
                    {
                        System.out.println(no + " is a Prime Number!");
                    }
                    else if (IsNoPriCo == 2)
                    {
                        System.out.println(no + " is a Composite Number!");
                    }
                    else if (IsNoPriCo == 0)
                    {
                        System.out.println(no + " is neither a Prime Number nor a Composite Number!");
                    }
                break;
                case 13:
                    System.out.println("PRONIC NUMBER?");
                    boolean IsNoPronic = false;
                    IsNoPronic = IsNumberPronic(no);
                    if(IsNoPronic == true)
                    {
                        System.out.println(no + " IS a Pronic Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Pronic Number!");
                    }
                break;
                case 14:
                    System.out.println("SPY NUMBER?");
                    boolean IsNoSpy = false;
                    IsNoSpy = IsNumberSpy(no);
                    if(IsNoSpy == true)
                    {
                        System.out.println(no + " IS a Spy Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Spy Number!");
                    }
                break;
                case 15:
                    System.out.println("STRONG NUMBER?");
                    boolean IsNoStrong = false;
                    IsNoStrong = IsNumberStrong(no);
                    if(IsNoStrong == true)
                    {
                        System.out.println(no + " IS a Strong Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Strong Number!");
                    }
                break;
                case 16:
                    System.out.println("SUNNY NUMBER?");
                    boolean IsNoSunny = false;
                    IsNoSunny = IsNumberSunny(no);
                    if(IsNoSunny == true)
                    {
                        System.out.println(no + " IS a Sunny Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Sunny Number!");
                    }
                break;
                case 17:
                    System.out.println("TRIMORPHIC NUMBER?");
                    boolean IsNoTrimorphic = false;
                    IsNoTrimorphic = IsNumberTrimorphic(no);
                    if(IsNoTrimorphic == true)
                    {
                        System.out.println(no + " IS a Trimorphic Number!");
                    }
                    else
                    {
                        System.out.println(no + " ISN'T a Trimorphic Number!");
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
