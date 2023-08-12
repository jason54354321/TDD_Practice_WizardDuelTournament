package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    @Test
    public void testWizardNameHealthSpells() {
        // 測試一個新的巫師 instance 被成功建立。
        // 驗證標準：確保巫師的名字和生命值被正確地設定，並且他開始時沒有任何法術。
        // Testing the initialization of a new wizard object.
        // Criteria：Ensuring the wizard's name and health are set correctly and he starts with no spells.

        Wizard wizard = new Wizard("Gandalf", 100);
        assertEquals("Gandalf", wizard.getName());
        assertEquals(100, wizard.getHealth());
        assertTrue(wizard.getSpells().isEmpty());
    }

    @Test
    public void testWizardLearnSpell() {
        // 測試巫師學習新法術。
        // 驗證標準：確保法術被正確地添加到巫師的法術列表中。
        // Testing the functionality of a wizard learning a new spell.
        // Criteria：Ensuring the spell is correctly added to the wizard's spell list.

        Wizard wizard = new Wizard("Gandalf", 100);
        Spell spell = new Spell("Fireball", 30);

        wizard.learnSpell(spell);

        assertEquals(1, wizard.getSpells().size());
        assertTrue(wizard.getSpells().contains(spell));
    }

    @Test
    public void testWizardCastSpell() {
        // 測試一名巫師對另一名巫師施放法術的功能。
        // 驗證標準：確保目標巫師的生命值正確地減少。
        // Testing the functionality of a wizard casting a spell on another wizard.
        // Criteria：Ensuring the target wizard's health is decreased correctly.

        Wizard attacker = new Wizard("Gandalf", 100);
        Wizard target = new Wizard("Saruman", 100);
        Spell spell = new Spell("Fireball", 30);

        attacker.learnSpell(spell);
        attacker.castSpell(target, spell);

        assertEquals(70, target.getHealth());
    }

    @Test
    public void testWizardHealthDecreaseAfterBeingHit() {
        // 測試當巫師被法術擊中時，他的生命值應該減少。
        // 驗證標準：確保巫師的生命值正確地減少。
        // Testing how a wizard's health should decrease when hit by a spell.
        // Criteria：Ensuring the wizard's health is decreased correctly.

        Wizard wizard = new Wizard("Gandalf", 100);
        Spell spell = new Spell("Fireball", 30);

        wizard.receiveSpell(spell);

        assertEquals(70, wizard.getHealth());
    }

    @Test
    public void testWizardDuelTournament() {
        // 測試一場巫師之間的對決。
        // 驗證標準：確保每個巫師施放的法術都正確地影響了對方的生命值。
        // Testing a duel between wizards.
        // Criteria：Ensuring each wizard's casted spell correctly affects the other's health.

        Wizard gandalf = new Wizard("Gandalf", 100);
        Wizard saruman = new Wizard("Saruman", 100);
        Spell fireball = new Spell("Fireball", 30);
        Spell lightningBolt = new Spell("Lightning Bolt", 40);

        gandalf.learnSpell(fireball);
        saruman.learnSpell(lightningBolt);

        gandalf.castSpell(saruman, fireball);
        saruman.castSpell(gandalf, lightningBolt);

        assertEquals(70, gandalf.getHealth());
        assertEquals(60, saruman.getHealth());
    }
}