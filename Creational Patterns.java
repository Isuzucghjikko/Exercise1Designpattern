//a)Factory Pattern – Shape Factory
interface Shape { void draw(); }

class Circle implements Shape {
    public void draw(){ System.out.println("Drawing Circle"); }
}

class Square implements Shape {
    public void draw(){ System.out.println("Drawing Square"); }
}

class ShapeFactory {
    public static Shape getShape(String type){
        return switch(type.toLowerCase()){
            case "circle" -> new Circle();
            case "square" -> new Square();
            default -> throw new IllegalArgumentException("Unknown shape");
        };
    }
}

class FactoryDemo {
    public static void main(String[] args){
        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();
        Shape s2 = ShapeFactory.getShape("square");
        s2.draw();
    }
}
//b)class Config {
    private static Config instance;
    private Config(){}

    public static Config getInstance(){
        if (instance == null) instance = new Config();
        return instance;
    }

    public void show(){ System.out.println("Singleton Config Loaded"); }
}

class SingletonDemo {
    public static void main(String[] args){
        Config c1 = Config.getInstance();
        Config c2 = Config.getInstance();
        c1.show();
        System.out.println("Same instance? " + (c1 == c2));
    }
}

