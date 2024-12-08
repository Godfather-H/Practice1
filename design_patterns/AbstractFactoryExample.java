package design_patterns;

//抽象产品接口:操作系统
interface OperatingSystem {
    void run();
}

//具体产品: Windows操作系统
class WindowsOS implements OperatingSystem {
    @Override
    public void run() {
        System.out.println("Running Windows OS");
    }
}

//具体产品:Linux操作系统
class LinuxOS implements OperatingSystem {
    @Override
    public void run() {

    }
}

//抽象产品接口:应用程序
interface Application {
    void open();
}

//具体产品:Word应用程序
class WordApplication implements Application {
    @Override
    public void open() {
        System.out.println("Opening Word Application");
    }
}

//具体产品: Excel应用程序
class ExcelApplication implements Application {
    @Override
    public void open() {
        System.out.println("Opening Excel Application");
    }
}

//抽象工厂接口
interface SoftwareFactory {
    OperatingSystem creatingOperatingSystem();
    Application creatingApplication();
}

//具体工厂:Window工厂
class WindowsFactory implements SoftwareFactory {
    @Override
    public OperatingSystem creatingOperatingSystem() {
        return new WindowsOS();
    }

    @Override
    public Application creatingApplication() {
        return new ExcelApplication();
    }
}

//具体工厂:Linux工厂
class LinuxFactory implements SoftwareFactory {
    @Override
    public OperatingSystem creatingOperatingSystem() {
        return new LinuxOS();
    }

    @Override
    public Application creatingApplication() {
        return new WordApplication();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args){
        SoftwareFactory windowsFactory = new WindowsFactory();
        OperatingSystem windowsOS = windowsFactory.creatingOperatingSystem();
        Application windowApp = windowsFactory.creatingApplication();

        windowsOS.run();
        windowApp.open();

        SoftwareFactory linuxFactory = new LinuxFactory();
        OperatingSystem linuxOS = linuxFactory.creatingOperatingSystem();
        Application linuxApp = linuxFactory.creatingApplication();

        linuxOS.run();
        linuxApp.open();
    }
}
