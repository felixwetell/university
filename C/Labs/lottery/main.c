#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>
#include <time.h>

int * randomise ( int array[7] )
{

    for ( int i = 0; i < 7; ++i )
    {
        int r = rand() % 34 + 1;
        array[i] = r;
    }

    return array;
}

int main()
{
    int input, lotteryRow[7];

    do
    {
        // Menu
        printf(": : : : : : : : : : : : \n");
        printf(": : : : M E N U : : : : \n");
        printf("1. Randomise lottery row\n");
        printf("2. Save current lottery row to file\n");
        printf("3. Read an existing lottery row from a file\n");
        printf("0. Exit the program \n");
        printf("Enter your menu choice: ");
        scanf("%i", &input);
        printf("\n");

        switch ( input )
        {
            case 0:
                printf( "Exiting program" );
                printf( "\n" );
                break;

            case 1:
                randomise( lotteryRow );
                for (int i = 0; i < (int)( sizeof(lotteryRow) / sizeof(lotteryRow[7]) ); ++i)
                {
                    printf( "%i ", lotteryRow[i] );
                }
                printf( "\n" );
                break;

            case 2:

                break;

            case 3:

                break;


            default:
                break;
        }
        printf( "\n" );
    }
    while( input != 0 );

    return 0;
}