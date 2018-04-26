package task2;

public class FinderThree {

    public static int getThreeNumberCount(int[] numbers)
    {
        int count = 0;
        try{
            if (numbers.length == 0)
                throw new Exception("Массив пуст!");
            for(int number:numbers)
            {
                String number_str = String.valueOf(number);
                int count3 = 0;
                for (int i = 0; i < number_str.length(); i++)
                {
                    char[] digit = new char[1];
                    number_str.getChars(i,i + 1, digit,0);
                    if (String.valueOf(digit).equals("3"))
                        count3++;
                }
                count += count3;
            }
        }
        catch (Exception e)
        {
            throw new NullPointerException("Массив не существует!");
        }
        return count;
    }
}
