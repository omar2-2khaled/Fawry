public class Main {

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        //Gasoline Car
        section("1. Gasoline Car");
        Car gasCar = factory.createCar(CarFactory.EngineType.GASOLINE);
        gasCar.start();
        gasCar.accelerate();
        gasCar.accelerate();
        gasCar.brake();
        gasCar.brake();
        gasCar.stop();

        // Electric Car
        section("2. Electric Car");
        Car electricCar = factory.createCar(CarFactory.EngineType.ELECTRONIC);
        electricCar.start();
        electricCar.accelerate();
        electricCar.accelerate();
        electricCar.stop();

        electricCar.brake();
        electricCar.brake();
        electricCar.stop();

        //Hybrid Car
        section("3. Hybrid Car — Electric below 50, Gas at 50+");
        Car hybridCar = factory.createCar(CarFactory.EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.accelerate();
        hybridCar.brake();
        hybridCar.brake();
        hybridCar.brake();
        hybridCar.brake();
        hybridCar.stop();

        //Engine Replacement
        section("4. Engine Replacement on existing car");
        System.out.println("Current engine: " + gasCar.getEngine().getType());
        factory.replaceEngine(gasCar, CarFactory.EngineType.HYBRID);
        System.out.println("New engine:     " + gasCar.getEngine().getType());
        gasCar.start();
        gasCar.accelerate();
        gasCar.brake();
        gasCar.stop();

        //Speed Limit
        section("5. Max speed (200 km/h) cap");
        Car speedCar = factory.createCar(CarFactory.EngineType.GASOLINE);
        speedCar.start();
        for (int i = 0; i < 11; i++) speedCar.accelerate(); // tries 11 x 20 = 220, capped at 200
        speedCar.brake();
        for (int i = 0; i < 10; i++) speedCar.brake();      // brake all the way to 0
        speedCar.stop();
    }

    private static void section(String title) {
        System.out.println("\n══════════════════════════════════════");
        System.out.println("  " + title);
        System.out.println("══════════════════════════════════════");
    }
}
