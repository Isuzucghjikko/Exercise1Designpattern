//a)Adapter Pattern – Legacy Printer
interface Printer { void print(String msg); }

class LegacyPrinter {
    void printText(String text){ System.out.println("Legacy: " + text); }
}

class PrinterAdapter implements Printer {
    private LegacyPrinter legacy;
    PrinterAdapter(LegacyPrinter lp){ this.legacy = lp; }
    public void print(String msg){ legacy.printText(msg); }
}
//b)proxy pattern
interface FileAccess { void read(); }

class RealFile implements FileAccess {
    public void read(){ System.out.println("Reading file contents"); }
}

class FileProxy implements FileAccess {
    private RealFile file;
    private boolean authorized;
    FileProxy(boolean authorized){ this.authorized = authorized; }

    public void read(){
        if (!authorized) System.out.println("Access Denied!");
        else {
            if (file == null) file = new RealFile();
            file.read();
        }
    }
}

class ProxyDemo {
    public static void main(String[] args){
        FileAccess file1 = new FileProxy(false);
        file1.read();
        FileAccess file2 = new FileProxy(true);
        file2.read();
    }
}


class AdapterDemo {
    public static void main(String[] args){
        Printer p = new PrinterAdapter(new LegacyPrinter());
        p.print("Hello via Adapter");
    }
}
