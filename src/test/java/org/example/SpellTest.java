package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellTest {

    @Test
    void getName() {
        // 測試 Spell 的 getName 方法是否能正確返回法術名
        Spell spell = new Spell("Fireball", 30);
        String expectName = "Fireball";
        assertEquals(expectName, spell.getName());
    }

    @Test
    void getDamage() {
        // 測試 Spell 的 getDamage 方法是否能正確返回法術傷害
        Spell spell = new Spell("Fireball", 30);
        int expectDamage = 30;
        assertEquals(expectDamage, spell.getDamage());
    }
}