package self;

public class CargoBox extends Box {
    private Object cargo;
    public CargoBox(Object cargo) {
        this.cargo = cargo;
    }
    @Override
    public Object open() {
        return cargo;
    }
}
