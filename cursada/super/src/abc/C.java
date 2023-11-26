package abc;
public class C extends B{
    void print() {
        System.out.println( "Soy una C\n" );
    }
    void doSomething(){super.print();}
}
