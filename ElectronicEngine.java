public class ElectronicEngine implements Engine {
    private int speed = 0;
    private boolean running = false;

    @Override
    public void start() {
        running = true;
        speed = 0;
        System.out.println("[ElectronicEngine] Started.");
    }

    @Override
    public void stop() {
        running = false;
        speed = 0;
        System.out.println("[ElectronicEngine] Stopped.");
    }

    @Override
    public void increase() {
        if (running) {
            speed++;
            System.out.println("[ElectronicEngine] Speed increased to: " + speed + " km/h");
        }
    }

    @Override
    public void decrease() {
        if (running && speed > 0) {
            speed--;
            System.out.println("[ElectronicEngine] Speed decreased to: " + speed + " km/h");
        }
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getType() {
        return "Electronic Engine";
    }
}
