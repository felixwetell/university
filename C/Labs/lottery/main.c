#include "prefixes.h"

// Searches for duplicates in array, by passing array and the number to the function
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

// Randomising numbers with value 1-35 and puts the in an array passed as an argument
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
    // Initializing random number generator
    srand(time(NULL));

    // Initializing variables
    int input, rowInput, temp = 0;
    int lotteryRow[maxColumns], lotteryRows[maxRows][maxColumns];

    // Initializing file
    char* filename = "/Users/felix/Documents/Github/university/C/Labs/lottery/lottery.txt";
    FILE * fileWrite;
    FILE * fileRead;

    // Variables for handling file output
    char * line = NULL;
    size_t len = 0;

    do
    {
        // Menu choices with input
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
            // Closes the program
            case 0:

                printf( "Exiting program" );
                break;
            // Creates a selection of arrays containing random number
            case 1:

                // Gets number of rows user want to have, max 10
                printf( "Max rows allowed: 10\n" );
                printf( "Enter number of rows: " );
                scanf( "%i", &rowInput );
                printf( "\n" );

                // Checks if rows are more than 0 and less than 10
                if( rowInput < 10 && rowInput > 1 )
                {
                    // Adds array with random numbers to 2D-array (lotteryRows)
                    for( int i = 0; i < rowInput; ++i )
                    {
                        // Sends in lotteryRow to randomise function
                        randomise( lotteryRow );

                        // Adds values from lotteryRow to lotteryRows at the correct position
                        // and prints the to the console
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

                // Checks if user have randomised numbers
                if( temp == 1 )
                {
                    // Opens file for writing
                    fileWrite = fopen( filename, "w" );

                    // Prints values from x and y positions in lotteryRows to file
                    // Gets the previous choosen number of rows
                    for( int i = 0; i < rowInput; ++i )
                    {
                        // maxColumns defined in "prefixes.h"
                        for( int j = 0; j < maxColumns; ++j )
                        {
                            fprintf( fileWrite, "%i ", lotteryRows[i][j] );
                        }
                        // Adds line break for easier reading and better formatting
                        fprintf( fileWrite, "\n" );
                    }

                    // Closes file
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

                // Opens file for reading
                fileRead = fopen( filename, "r" );

                // Looks on the file and prints each row (line) until file ends
                while( getline( &line, &len, fileRead ) != -1 )
                {
                    printf("%s", line);
                }

                // Closes file
                fclose( fileRead );

                printf( "\n" );
                printf(": : : : : : : : : : : : : : : : : : : : : \n");
                printf( "Lottery rows successfully read from file \n" );
                printf(": : : : : : : : : : : : : : : : : : : : : \n");

                break;

            default:
                break;
        }
        printf( "\n" );
    }
    // If input is 0 the do/while loop ends and the program exits
    while( input != 0 );

    return 0;
}