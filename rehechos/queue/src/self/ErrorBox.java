package self;

public class ErrorBox extends Box {
    @Override
    public Object open() {
        throw new Error("Queue is empty");
    }
}
