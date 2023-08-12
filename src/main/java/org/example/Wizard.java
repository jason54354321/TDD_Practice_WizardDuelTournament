package org.example;

// Wizard .java
import java.util.ArrayList;
import java.util.List;

public class Wizard {
    private String name;
    private int health;
    private List<Spell> spells;

    public Wizard(String name, int health) {
        this.name = name;
        this.health = health;
        this.spells = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void learnSpell(Spell spell) {
        spells.add(spell);
    }

    public void castSpell(Wizard target, Spell spell) {
        if (spells.contains(spell))
            target.receiveSpell(spell);
    }

    public void receiveSpell(Spell spell) {
        health -= spell.getDamage();
    }
}