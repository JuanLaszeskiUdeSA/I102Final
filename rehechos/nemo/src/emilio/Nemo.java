package emilio;


public class Nemo {

  private Point position;
  private DepthNavigator depth = new DepthNavigator();
  private Heading heading;

  public Nemo( Point initialPosition, Heading h ) {
    position = initialPosition;
    heading = h;
  }
  
  public Point position() { 
    return position; 
  }

  public boolean isPositioned( Point p, int d, Heading h ) { 
    return position.equals( p ) && depth.depth() == d && heading.equals( h );
  }

  public void swimn( char c ) {
    Command.commandFor( c ).performOn( this );
  }

  public void fire() {
    depth.fire();
  }

  public Point forward() {
    return position = position.add( heading.forward() );
  }

  public Heading turnRight() {
    return heading = heading.turnRigth();
  }

  public void turnLeft() {
    heading = heading.turnLeft();
  }

  public void up() {
    depth.up();
  }

  public void down() {
    depth.down();
  }

  public int depth() {
    return depth.depth();
  }

  public void swimn( String string ) {
    string.chars().forEach( c -> swimn( (char)c ) );
  }
}
