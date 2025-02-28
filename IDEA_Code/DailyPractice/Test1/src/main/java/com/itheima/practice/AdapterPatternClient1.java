package com.itheima.practice;

//目标接口
interface MediaPlayer {
    void play(String audioType, String fileName);
}

//实现MP3播放器
class Mp3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        System.out.println("Playing MP3: " + fileName);
    }
}

//适配器接口
interface AdvancedMediaPlayer {
    void playWav(String fileName);
}

//WAV播放器实现
class WavPlayer implements AdvancedMediaPlayer {
    @Override
    public void playWav(String fileName) {
        System.out.println("Playing WAV: " + fileName);
    }
}

//适配器类
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedMediaPlayer = new WavPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedMediaPlayer.playWav(fileName);
        }
    }
}

//测试播放器
class AudioPlayer implements MediaPlayer {
    MediaPlayer mediaPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            new Mp3Player().play(audioType, fileName);
        } else if (audioType.equalsIgnoreCase("wav")) {
            mediaPlayer = new MediaAdapter(audioType);
            mediaPlayer.play(audioType, fileName);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

public class AdapterPatternClient1 {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("wav", "song.wav");
        player.play("avi", "movie.avi");
    }
}
