public class CarFactory {

    public enum EngineType {
        GASOLINE,
        ELECTRONIC,
        HYBRID
    }

    public Car createCar(EngineType engineType) {
        Engine engine = buildEngine(engineType);
        System.out.println("[CarFactory] Creating car with: " + engine.getType());
        return new Car(engine);
    }

    public void replaceEngine(Car car, EngineType engineType) {
        Engine newEngine = buildEngine(engineType);
        car.replaceEngine(newEngine);
    }

    private Engine buildEngine(EngineType engineType) {
        switch (engineType) {
            case GASOLINE:    return new GasolineEngine();
            case ELECTRONIC:  return new ElectronicEngine();
            case HYBRID:      return new MixedHybridEngine();
            default: throw new IllegalArgumentException("Unknown engine type: " + engineType);
        }
    }
}
