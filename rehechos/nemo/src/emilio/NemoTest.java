package emilio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class NemoTest {

  @Test public void test00() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test01() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test02() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( 'd' );

    assertTrue( nemo.isPositioned( initialPosition, 1, Heading.headingNorth() ) );
  }

  @Test public void test02a() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "dd" );
    assertTrue( nemo.isPositioned( initialPosition, 2, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 1, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test02b() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "ddd" );
    assertTrue( nemo.isPositioned( initialPosition, 3, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 2, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 1, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test02c() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "ddd" );

    assertTrue( nemo.isPositioned( initialPosition, 3, Heading.headingNorth() ) );
  }

  @Test public void test03() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( 'u' );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test04() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( 'l' );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingWest() ) );
  }

  @Test public void test04b() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "ll" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingSouth() ) );
  }

  @Test public void test04c() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "lll" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingEast() ) );
  }

  @Test public void test04d() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "llll" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test05() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( 'r' );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingEast() ) );
  }

  @Test public void test05b() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "rr" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingSouth() ) );
  }

  @Test public void test05c() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "rrr" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingWest() ) );
  }

  @Test public void test05d() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "rrrr" );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test06() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( 'f' );

    assertTrue( nemo.isPositioned( new Point( 2, 1 ), 0, Heading.headingNorth() ) );
  }

  @Test public void test06b() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "lf" );

    assertTrue( nemo.isPositioned( new Point( 1, 0 ), 0, Heading.headingWest() ) );
  }

  @Test public void test06c() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "llf" );

    assertTrue( nemo.isPositioned( new Point( 0, 1 ), 0, Heading.headingSouth() ) );
  }

  @Test public void test06d() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "lllf" );

    assertTrue( nemo.isPositioned( new Point( 1, 2 ), 0, Heading.headingEast() ) );
  }

  @Test public void test07() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( 'm' );

    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
  }

  @Test public void test08() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "dm" );

    assertTrue( nemo.isPositioned( initialPosition, 1, Heading.headingNorth() ) );
  }

  @Test public void test09() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    assertThrows( Exception.class, () -> nemo.swimn( "ddm" ) );
  }

  @Test public void test09b() {
    Point initialPosition = new Point( 1, 1 );
    Nemo nemo = new Nemo( initialPosition, Heading.headingNorth() );

    nemo.swimn( "ddd" );
    assertTrue( nemo.isPositioned( initialPosition, 3, Heading.headingNorth() ) );
    assertThrows( Exception.class, () -> nemo.swimn( "m" ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 2, Heading.headingNorth() ) );
    assertThrows( Exception.class, () -> nemo.swimn( "m" ) );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 1, Heading.headingNorth() ) );
    nemo.swimn( "m" );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
    nemo.swimn( "m" );
    nemo.swimn( "u" );
    assertTrue( nemo.isPositioned( initialPosition, 0, Heading.headingNorth() ) );
    nemo.swimn( "m" );
  }

}
