#include "prefixes.h"

int duplicate( int array[maxColumns], int number )
{
    int answer = 0, i;

    for ( i = 0; i < maxColumns; i++ )
    {
        if ( array[i] == number )
        {
            answer = 1;
        }
    }
    return answer;
}

int * randomise ( int array[maxColumns] )
{
    int random;

    for ( int i = 0; i < maxColumns; i++ )
    {
        random = rand() % max + min;

        while( duplicate( array, random ) == 1 )
        {
            random = rand() % max + min;
        }
        array[i] = random;
    }
    return array;
}

int main()
{
    srand(time(NULL));
    int input, rowInput, lotteryRows[maxRows][maxColumns], lotteryRow[maxColumns], temp = 0, rowTemp;

    char* filename = "/Users/felix/Documents/Github/university/C/Labs/lottery/lottery.txt";

    FILE * fileWrite;
    FILE * fileRead;

    char * line = NULL;
    size_t len = 0;

    do
    {
        // Menu
        printf(": : : : : : : : : : : : \n");
        printf(": : : : M E N U : : : : \n");
        printf("1. Randomise lottery row\n");
        printf("2. Save current lottery row to file\n");
        printf("3. Read an existing lottery row from a file\n");
        printf("0. Exit the program \n");
        printf( "\n" );
        printf("Enter your menu choice: ");
        scanf( "%i", &input );
        printf("\n");

        switch ( input )
        {
            case 0:
                printf( "Exiting program" );
                break;

            case 1:

                printf( "Max rows allowed: 10\n" );
                printf( "Enter number of rows: " );
                scanf( "%i", &rowInput );
                printf( "\n" );

                if( rowInput < 10 && rowInput > 1 )
                {
                    for( int i = 0; i < rowInput; ++i )
                    {
                        randomise( lotteryRow );

                        for( int j = 0; j < maxColumns; ++j )
                        {
                            lotteryRows[ i ][ j ] = lotteryRow[j];
                            printf( "%i ", lotteryRows[i][j] );
                        }
                        printf( "\n" );
                    }

                    printf( "\n" );
                    printf(": : : : : : : : : : : : : : : : : : : \n");
                    printf( "Lottery rows successfully generated \n" );
                    printf(": : : : : : : : : : : : : : : : : : : \n");

                    temp = 1;
                    rowTemp = rowInput;
                }
                else if( rowInput > 10 )
                {
                    printf( "To many rows\n" );
                }
                else
                {
                    printf( "To few rows\n" );
                }

                break;

            case 2:

                if( temp >= 1 )
                {
                    fileWrite = fopen( filename, "w" );

                    for( int i = 0; i < rowTemp; ++i )
                    {
                        for( int j = 0; j < maxColumns; ++j )
                        {
                            fprintf( fileWrite, "%i ", lotteryRows[i][j] );
                        }
                        fprintf( fileWrite, "\n" );
                    }

                    fclose( fileWrite );
                    printf(": : : : : : : : : : : : : : : : : : : : : \n");
                    printf( "Lottery rows successfully saved to file \n" );
                    printf(": : : : : : : : : : : : : : : : : : : : : \n");
                    temp = 2;
                }
                else
                {
                    printf(": : : : : : : : : : : : : \n");
                    printf( "Use menu choice 1 first \n" );
                    printf(": : : : : : : : : : : : : \n");
                    printf( "\n" );
                }

                break;

            case 3:

                fileRead = fopen( filename, "r" );

                while( getline( &line, &len, fileRead ) != -1 )
                {
                    printf("%s", line);
                }

                fclose( fileRead );

                printf( "\n" );
                printf(": : : : : : : : : : : : : : : : : : : : : \n");
                printf( "Lottery rows successfully read from file \n" );
                printf(": : : : : : : : : : : : : : : : : : : : : \n");

                temp = 3;

                break;

            default:
                break;
        }
        printf( "\n" );
    }
    while( input != 0 );

    return 0;
}