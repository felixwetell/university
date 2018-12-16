public class Person
{
    private int shoeSize;
    private String firstaName, lastName, phoneNumber;

    private Person()
    {
        shoeSize = ( int )( Math.random() * 25 + 20 );
    }

   public void setFirstName( String name )
   {
       firstaName = name;
   }

    public void setLastName( String name )
    {
        lastName = name;
    }

    public void setShoeSize( int size )
    {
        shoeSize = size;
    }

    public String getFullName()
    {
        return firstaName + " " + lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public int getShoeSize()
    {
        return shoeSize;
    }

    public static void main(String[] args)
    {
        Person person = new Person();
        person.setFirstName( "Sven" );
        person.setLastName( "Svensson" );

        Person person2 = new Person();
        person2.setFirstName( "Sven" );
        person2.setLastName( "Svensson" );
        person2.setShoeSize( person.getShoeSize() );

        System.out.println( "Person har storlek " + person.getShoeSize() + " på fötterna" );
        System.out.println( "Person2 har storlek " + person2.getShoeSize() + " på fötterna" );
    }
}
