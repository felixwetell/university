public class Ticket {

    private static Ticket ticket = new Ticket( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Ticket() { }

    /* Static 'instance' method */
    public static Ticket getInstance()
    {
        return ticket;
    }

    /* Other methods protected by singleton-ness */
    protected static void hello()
    {
        System.out.println( "test" );

    }
}