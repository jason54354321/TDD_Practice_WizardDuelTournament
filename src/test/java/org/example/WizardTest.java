package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    @Test
    public void testWizardNameHealthSpells() {
        // Step 1-3
        // 測試一個新的巫師 instance 被成功建立。
        // 驗證標準：確保巫師的名字和生命值被正確地設定，並且他開始時沒有任何法術。
        // Testing the initialization of a new wizard object.
        // Criteria：Ensuring the wizard's name and health are set correctly and he starts with no spells.
        final String name = "BIIG";
        final int health = 500;
        Wizard wizard = new Wizard(name, health);

        Assertions.assertEquals(wizard.getName(), name);
        Assertions.assertEquals(wizard.getHealth(), health);
    }

    @Test
    public void testWizardLearnSpell() {
        // Step 4-6
        // 測試巫師學習新法術。
        // 驗證標準：確保法術被正確地添加到巫師的法術列表中。
        // Testing the functionality of a wizard learning a new spell.
        // Criteria：Ensuring the spell is correctly added to the wizard's spell list.
        final String name = "BIIG";
        final int health = 500;
        Wizard wizard = new Wizard(name, health);

        final String spellName = "smallSpell";
        final int spellDamage = 9;
        Spell smallSpell = new Spell(spellName, spellDamage);
        wizard.learnSpell(smallSpell);

        Assertions.assertEquals(wizard.getSpells().get(0), smallSpell);
    }

    @Test
    public void testWizardCastSpell() {
        // Step 7-9
        // 測試一名巫師對另一名巫師施放法術的功能。
        // 驗證標準：確保目標巫師的生命值正確地減少。
        // Testing the functionality of a wizard casting a spell on another wizard.
        // Criteria：Ensuring the target wizard's health is decreased correctly.
        final  int targetMaxHealth = 20;
        Wizard wizardBIG = new Wizard("BIIIG", 999);
        Wizard wizardSmol = new Wizard("small", targetMaxHealth);
        Spell smallSpell = new Spell("goodSpell", 19);


        wizardBIG.learnSpell(smallSpell);
        wizardBIG.castSpell(wizardSmol, smallSpell);

        final int expectedHealth = targetMaxHealth - smallSpell.getDamage();
        Assertions.assertEquals(wizardSmol.getHealth(), expectedHealth);

    }

    @Test
    public void testWizardHealthDecreaseAfterBeingHit() {
        // Step 10-12
        // 測試當巫師被法術擊中時，他的生命值應該減少。
        // 驗證標準：確保巫師的生命值正確地減少。
        // Testing how a wizard's health should decrease when hit by a spell.
        // Criteria：Ensuring the wizard's health is decreased correctly.
        final  int targetMaxHealth = 20;
        Wizard wizardBIG = new Wizard("BIIIG", 999);
        Wizard wizardSmol = new Wizard("small", targetMaxHealth);
        Spell smallSpell = new Spell("goodSpell", 19);


        wizardBIG.learnSpell(smallSpell);
        wizardBIG.castSpell(wizardSmol, smallSpell);

        final int expectedHealth = targetMaxHealth - smallSpell.getDamage();
        Assertions.assertEquals(wizardSmol.getHealth(), expectedHealth);
    }

    @Test
    public void testWizardDuelTournament() {
        // Step 13-15
        // 測試一場巫師之間的對決。
        // 驗證標準：確保每個巫師施放的法術都正確地影響了對方的生命值。
        // Testing a duel between wizards.
        // Criteria：Ensuring each wizard's casted spell correctly affects the other's health.
        Wizard wizardBIG = new Wizard("BIIIG", 999);
        Wizard wizardSmol = new Wizard("small", 20);
        Spell smallSpell = new Spell("goodSpell", 19);

        wizardBIG.learnSpell(smallSpell);
        wizardSmol.learnSpell(smallSpell);

        wizardBIG.castSpell(wizardSmol, smallSpell);
        Assertions.assertEquals(wizardSmol.getHealth(), 20 - 19);
        wizardSmol.castSpell(wizardBIG, smallSpell);
        Assertions.assertEquals(wizardBIG.getHealth(), 999 - 19);

    }
}