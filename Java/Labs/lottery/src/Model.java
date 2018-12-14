import java.util.Arrays;

public class Model
{
    public String lotteryRow;

    public static void main(String[] args)
    {

    }

    /**
     * Method creates an array containing 7 number with values ranging
     * from 1 to 35. After creating the random number the method checks if
     * array already contains that value. If it does, the value is randomised again.
     * Array is then converted to string and returned.
     *
     * @return lotteryRow as string
     */
    public String randomise()
    {
        int[] lottery = new int[ 7 ];
        int random;

        for( int i = 0; i < 7; i++ )
        {
            random = ( int )( Math.random() * 35 );

            for( int number = 0; number < i; number++ )
            {
                if( lottery[ i ] == random )
                {
                    random = ( int )( Math.random() * 35 );
                }
            }
            lottery[ i ] = random;
        }

        lotteryRow = Arrays.toString( lottery );

        return lotteryRow;
    }
}
