public class Car {
    private static final int MAX_SPEED = 200;
    private static final int SPEED_STEP = 20;

    private Engine engine;
    private int speed = 0;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        speed = 0;
        engine.start();
        System.out.println("[Car] Car started with " + engine.getType() + ". Speed: " + speed + " km/h");
    }

    public void stop() {
        if (speed != 0) {
            System.out.println("[Car] Cannot stop: speed must be 0 before stopping. Current speed: " + speed + " km/h");
            return;
        }
        engine.stop();
        System.out.println("[Car] Car stopped.");
    }

    public void accelerate() {
        if (speed >= MAX_SPEED) {
            System.out.println("[Car] Already at maximum speed: " + MAX_SPEED + " km/h");
            return;
        }
        int targetSpeed = Math.min(speed + SPEED_STEP, MAX_SPEED);
        System.out.println("[Car] Accelerating from " + speed + " to " + targetSpeed + " km/h...");
        while (speed < targetSpeed) {
            speed++;
            engine.setSpeed(speed);
            engine.increase();
        }
    }

    public void brake() {
        if (speed <= 0) {
            System.out.println("[Car] Already stopped.");
            return;
        }
        int targetSpeed = Math.max(speed - SPEED_STEP, 0);
        System.out.println("[Car] Braking from " + speed + " to " + targetSpeed + " km/h...");
        while (speed > targetSpeed) {
            speed--;
            engine.setSpeed(speed);
            engine.decrease();
        }
    }

    public void replaceEngine(Engine newEngine) {
        System.out.println("[Car] Replacing " + engine.getType() + " with " + newEngine.getType());
        this.engine = newEngine;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getSpeed() {
        return speed;
    }
}
