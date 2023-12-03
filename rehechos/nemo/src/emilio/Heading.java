package emilio;

public class Heading {
  static public Heading headingNorth;
  static public Heading headingWest;
  static public Heading headingEast;
  static public Heading headingSouth;

  private Heading left;
  private Heading right;
  private Point forward;

  public Heading turnLeft()  {   return left;    }
  public Heading turnRigth() {   return right;   }
  public Point forward()     {   return forward; }

  static public Heading headingNorth() {
    if ( headingNorth == null) {
      headingNorth = new Heading();
      headingNorth.initialize( headingWest(), headingEast(), new Point( 1, 0 ) );
    }
    return headingNorth;
  }
  static public Heading headingSouth() {
    if ( headingSouth == null) {
      headingSouth = new Heading();
      headingSouth.initialize( headingEast(), headingWest(), new Point( -1, 0 ) );
    }
    return headingSouth;
  }
  static public Heading headingWest() {
    if ( headingWest == null) {
      headingWest = new Heading();
      headingWest.initialize( headingSouth(), headingNorth(), new Point( 0, -1 ) );
    }
    return headingWest;
  }
  static public Heading headingEast() {
    if ( headingEast == null) {
      headingEast = new Heading();
      headingEast.initialize( headingNorth(), headingSouth(), new Point( 0, 1 ) );
    }
    return headingEast;
  }

  public Heading() {}
  public void initialize( Heading actionLeft, Heading actionRight, Point actionForward ) {
    left = actionLeft;
    right = actionRight;
    forward = actionForward;
  }
  
  public boolean equals(Object obj) {
      return getClass().equals( obj.getClass() );
  }
}
