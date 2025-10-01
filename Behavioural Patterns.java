//a) Observer Pattern – Weather Station
import java.util.*;

interface Observer {
    void update(int temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    public void setTemperature(int temp) {
        this.temperature = temp;
        observers.forEach(o -> o.update(temp));
    }
}

class PhoneDisplay implements Observer {
    public void update(int temperature) {
        System.out.println("Phone Display: Temp = " + temperature + "°C");
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.setTemperature(30);
        station.setTemperature(22);
    }
}
//(b) Command Pattern – Remote Control
interface Command { void execute(); }

class Light {
    void on(){ System.out.println("Light ON"); }
    void off(){ System.out.println("Light OFF"); }
}

class LightOnCommand implements Command {
    private Light light;
    LightOnCommand(Light l){ light = l; }
    public void execute(){ light.on(); }
}

class LightOffCommand implements Command {
    private Light light;
    LightOffCommand(Light l){ light = l; }
    public void execute(){ light.off(); }
}

class RemoteControl {
    private Command command;
    void setCommand(Command c){ command = c; }
    void press(){ command.execute(); }
}

class CommandDemo {
    public static void main(String[] args){
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.press();
        remote.setCommand(new LightOffCommand(light));
        remote.press();
    }
}

