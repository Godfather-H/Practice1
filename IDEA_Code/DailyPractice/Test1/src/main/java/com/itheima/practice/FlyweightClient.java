package com.itheima.practice;

import java.util.HashMap;
import java.util.Map;

//享元接口
interface Character {
    void display(int fontSize);
}

//具体享元类
class ConcreteCharacter implements Character {
    private final char symbol;//字符

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int fontSize) {
        System.out.println("Character: " + symbol + ", Font Size: " + fontSize);
    }
}

//享元工厂
class CharacterFactory {
    private final Map<java.lang.Character, Character> characters = new HashMap<>();

    public Character getCharacter(char symbol) {
        Character character = characters.get(symbol);
        if (character == null) {
            character = new ConcreteCharacter(symbol);
            characters.put(symbol, character);
            System.out.println("Creating new character: " + symbol);
        }
        return character;
    }
}

public class FlyweightClient {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        //字体大小可以通过参数传递
        Character a = factory.getCharacter('a');
        a.display(12);

        Character b = factory.getCharacter('b');
        b.display(10);

        Character anotherA = factory.getCharacter('a');//使用共享的实例
        anotherA.display(14);

        //输出共享的字符实例的内存地址
        System.out.println("Character 'a' instance is the same: " + (a == anotherA));
    }
}
