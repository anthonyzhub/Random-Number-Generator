import java.security.SecureRandom;

public class RandomIntegers
{

    public static boolean lookForElem(Integer[] currNumbers, Integer diceSide)
    {
        // Iterate array
        for(Integer i: currNumbers)
        {
            // If number exist, return true
            if (i == diceSide)
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // Create an instance of SecureRandom
        SecureRandom numberGenerator = new SecureRandom();

        // Create an array and a iterator
        Integer[] currNumbers = new Integer[6];
        int it = 0;
        
        // Call instance N-times
        for (int i = 1; i <= 20; i++)
        {
            // Get a random number from 0-5
            Integer diceSide = Integer.valueOf(numberGenerator.nextInt(6) + 1); // <= "+1" was added because generator starts at 0

            // If number is already inside element, generate another number
            boolean doesElemExist = lookForElem(currNumbers, diceSide);
            while (doesElemExist == true)
            {
                diceSide = Integer.valueOf(numberGenerator.nextInt(6) + 1);
                doesElemExist = lookForElem(currNumbers, diceSide);
            }

            // Add number to array and print it
            currNumbers[it] = diceSide;
            it += 1;
            System.out.printf("%d ", diceSide);

            // After every 5th number, create a new line
            if (i % 5 == 0)
            {
                // Restart array and iterator
                currNumbers = new Integer[6]; // <= Used to clear array
                it = 0;

                System.out.println();
            }
        }
    }
}