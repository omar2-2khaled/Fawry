public class MixedHybridEngine implements Engine {
    private static final int ELECTRIC_THRESHOLD = 50;

    private final ElectronicEngine electricEngine;
    private final GasolineEngine gasolineEngine;
    private Engine activeEngine;
    private int speed = 0;

    public MixedHybridEngine() {
        this.electricEngine = new ElectronicEngine();
        this.gasolineEngine = new GasolineEngine();
        this.activeEngine = electricEngine; // default to electric at start
    }

    @Override
    public void start() {
        speed = 0;
        activeEngine = electricEngine;
        activeEngine.start();
        System.out.println("[MixedHybridEngine] Started using Electric engine (speed < " + ELECTRIC_THRESHOLD + ").");
    }

    @Override
    public void stop() {
        activeEngine.stop();
        speed = 0;
        System.out.println("[MixedHybridEngine] Stopped.");
    }

    @Override
    public void increase() {
        speed++;
        syncActiveEngine();
        activeEngine.increase();
    }

    @Override
    public void decrease() {
        if (speed > 0) {
            speed--;
            syncActiveEngine();
            activeEngine.decrease();
        }
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
        syncActiveEngine();
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getType() {
        return "Mixed Hybrid Engine";
    }

    // Switches between electric and gasoline based on speed threshold — cost optimized.
    private void syncActiveEngine() {
        Engine targetEngine = (speed < ELECTRIC_THRESHOLD) ? electricEngine : gasolineEngine;

        if (targetEngine != activeEngine) {
            System.out.println("[MixedHybridEngine] Switching from " + activeEngine.getType()
                    + " to " + targetEngine.getType() + " at speed " + speed + " km/h.");
            activeEngine.stop();
            activeEngine = targetEngine;
            activeEngine.start();
            activeEngine.setSpeed(speed);
        }
    }
}
