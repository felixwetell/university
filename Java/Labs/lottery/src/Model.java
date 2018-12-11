import java.util.Arrays;

public class Model
{
    public String lotteryRow;

    public static void main(String[] args)
    {

    }



    public String randomize()
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
