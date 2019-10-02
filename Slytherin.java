import java.util.Random;

public class Slytherin extends Wizard{
    private static Random rand = new Random();
    private static Spell[] spellBook = {new Spell("Expulso", 3), new Spell("Levicorpus", 2), new Spell("Oppugno", 1),
            new Spell("Flipendo", 1), new Spell("Wingardium Leviosa", 0)};
    private static int maxHealth= rand.nextInt(6) + 22;
    private static int attackPower = rand.nextInt(3) + 5;

    public Slytherin(String name) {
        super(name, "green", maxHealth, attackPower, spellBook);
    }
}