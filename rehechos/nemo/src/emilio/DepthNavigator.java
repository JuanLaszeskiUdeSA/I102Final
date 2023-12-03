package emilio;

public class DepthNavigator {
  DepthLevel level = new SurfaceDepth();
  
  public void up() { level = level.up();  }
  public void down() { level = level.down();  }
  public int depth() { return level.depth(); }
  public void fire() { level.fire();  }
}

abstract class DepthLevel {
  public abstract DepthLevel up();
  public void fire() {     System.out.println( "Puf!" ); }
  public abstract DepthLevel down();
  public abstract int depth();
}

class SurfaceDepth extends DepthLevel {
  public DepthLevel up() {    return this;  }  
  public DepthLevel down() {  return new UnderSurfaceDepth();  }
  public int depth() {        return 0;  }  
}

class UnderSurfaceDepth extends DepthLevel {
  public DepthLevel up() {    return new SurfaceDepth();  }  
  public DepthLevel down() {  return new DeepDepth( this );  }  
  public int depth() {        return 1;  }  
}

class DeepDepth extends DepthLevel {
  DepthLevel previous;
  public DeepDepth( DepthLevel upperLevel ) { previous = upperLevel;   }
  
  public DepthLevel up() {    return previous;  }  
  public DepthLevel down() {  return new DeepDepth( this );  }  
  public int depth() {        return 1 + previous.depth();  }  
  public void fire() {        throw new RuntimeException("boom!"); }
}