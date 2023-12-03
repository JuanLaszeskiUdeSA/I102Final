package emilio;

import java.util.List;
import java.util.function.Consumer;

public class Command {
  
  static public Command commandFor( char command ) {
    return List.of( new Command( 'd', nemo -> nemo.down() ), 
                    new Command( 'u', nemo -> nemo.up() ), 
                    new Command( 'l', nemo -> nemo.turnLeft() ), 
                    new Command( 'r', nemo -> nemo.turnRight() ), 
                    new Command( 'f', nemo -> nemo.forward() ), 
                    new Command( 'm', nemo -> nemo.fire() )
                   ).stream()
                    .filter( each -> each.applies( command ) )
                    .findAny()
                    .get();
  }
  protected char key;
  private Consumer<Nemo> action;
  
  public Command( char aKey, Consumer<Nemo> anAction ) {
    key = aKey;
    action = anAction;
  }
  
  public boolean applies( char command ) { return key == command; }
  public void performOn( Nemo nemo ) { action.accept( nemo );  }
}

