package com.itheima.practice;

//子系统类:灯光
class Light {
    public void on() {
        System.out.println("Light on");
    }

    public void off() {
        System.out.println("The lights are off.");
    }
}

//子系统: 投影仪
class Projector {
    public void on() {
        System.out.println("Projector is on.");
    }

    public void off() {
        System.out.println("Projector is off.");
    }

    public void setInput(String input) {
        System.out.println("Projector input set to: " + input);
    }
}

//子系统: DVD播放器
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on.");
    }

    public void off() {
        System.out.println("DVD Player id off.");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }
}

//外观模式: 封装子系统的复杂操作
class HomeTheaterFacade {
    private Light light;
    private Projector projector;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(Light light, Projector projector, DVDPlayer dvdPlayer) {
        this.light = light;
        this.projector = projector;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie: " + movie);
        light.off();
        projector.on();
        projector.setInput("DVD");
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the theater...");
        light.on();
        dvdPlayer.off();
        projector.off();
    }
}

//客户端
public class FacadeClient {
    public static void main(String[] args) {
        Light light = new Light();
        Projector projector = new Projector();
        DVDPlayer dvdPlayer = new DVDPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(light, projector, dvdPlayer);

        //观看电影
        homeTheater.watchMovie("Inception");
        //结束电影
        homeTheater.endMovie();
    }
}
