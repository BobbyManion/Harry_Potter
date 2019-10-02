import java.util.Random;

public class Gryffindor extends Wizard {
    private static Random rand = new Random();
    private static Spell[] spellBook = {new Spell("Expulso Patronum", 3), new Spell("Expelliarmus", 2),
            new Spell("Ridikkulus", 1), new Spell("Wingardium Leviosa", 0)};
    private static int maxHealth = rand.nextInt(6) + 25;
    private static int attackPower = rand.nextInt(3) + 4;

    public Gryffindor(String name) {
        super(name, "scarlet", maxHealth, attackPower, spellBook);
    }

}