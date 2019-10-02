import java.util.Random;

public class Wizard {
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private Spell[] spellBook;
    private String color;

    public Wizard(String name, String color, int attackPower, Spell[] spellBook) {
        this(name, color, 25, attackPower, spellBook);
    }

    public Wizard(String name, String color, int maxHealth, int attackPower, Spell[] spellBook) {
        this.name = name;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.attackPower = attackPower;

        if (spellBook.length != 0) {
            this.spellBook = spellBook;
        } else {
            this.spellBook = new Spell[1];
            this.spellBook[0] = new Spell("Wingardiun Leviosa", 0);
        }

        this.color = color;
    }

    public Spell cast() {
        int numSpells = spellBook.length;
        Random rand = new Random();
        int temp = rand.nextInt(numSpells);
        //System.out.println(spellBook[temp]);
        return (spellBook[temp]);
    }

    @Override
    public String toString() {
        return (name + " wishes to join the " + color + " house at Hogwarts! They have " + health +
                " health points and " + attackPower + " attackPower.");
    }

    public void duel(Wizard o) {
        while (this.health > 0 && o.getHealth() > 0) {

            Random percent = new Random();
            int temp_1 = percent.nextInt(5);
            if (temp_1 == 1) {
                if (this.health < o.getHealth()) {
                    this.gainHealth(3);
                    System.out.println(this.name + " drinks an invigoration potion and restores 3 health! " +
                            this.name + " now has " + this.health + " health.");
                } else if (this.health > o.getHealth()) {
                    o.gainHealth(3);
                    System.out.println(o.getName() + " drinks an invigoration potion and restores 3 health! " +
                            o.getName() + " now has " + o.getHealth() + " health.");
                }
            }

            Spell thisCast = this.cast();
            Spell oCast = o.cast();
            String thisName =  thisCast.getName();
            int thisDamage = thisCast.getDamage();
            String oName = oCast.getName();
            int oDamage = oCast.getDamage();

            if (this.health < o.getHealth()) {
                o.setHealth(o.getHealth() - (this.attackPower + thisDamage));
                if (o.getHealth() <= 0) {
                    System.out.println(o.getName() + " falls to the ground. " + this.name +
                            " wins the duel!");
                    continue;
                } else {
                    System.out.println(this.name + " casts " + thisName + " and deals " +
                            (this.attackPower + thisDamage) + " damage. " + o.getName() + " now has " + o.getHealth() + " health.");
                }
                this.health = this.health - (o.getAttackPower() + oDamage);
                if (this.health <= 0) {
                    System.out.println(this.name + " falls to the ground. " + o.getName() +
                            " wins the duel!");
                    continue;
                } else {
                    System.out.println(o.getName() + " casts " + oName + " and deals " +
                            (o.getAttackPower() + oDamage) + " damage. " + this.name + " now has " + this.health + " health.");
                }
            } else {
                this.health = this.health - (o.getAttackPower() + oDamage);
                if (this.health <= 0) {
                    System.out.println(this.name + " falls to the ground. " + o.getName() +
                            " wins the duel!");
                    continue;
                } else {
                    System.out.println(o.getName() + " casts " + oName + " and deals " +
                            (o.getAttackPower() + oDamage) + " damage. " + this.name + " now has " + this.health + " health.");
                }
                o.setHealth(o.getHealth() - (this.attackPower + thisDamage));
                if (o.getHealth() <= 0) {
                    System.out.println(o.getName() + " falls to the ground. " + this.name +
                            " wins the duel!");
                    continue;
                } else {
                    System.out.println(this.name + " casts " + thisName + " and deals " +
                            (this.attackPower + thisDamage) + " damage. " + o.getName() + " now has " + o.getHealth() + " health.");
                }
            }
        }
        this.health = this.maxHealth;
        o.setHealth(o.getMaxHealth());
    }

    public void interact(Wizard o) {
        System.out.println(this.name + ": Hey " + o.name + " , let's be friends!");
        duel(o);
    }

    public boolean equals(Wizard o) {
        if (this == o) {
            return true;
        }

        if (this.name.equals(o.getName()) && this.health == o.getHealth() && this.attackPower == o.getAttackPower()
                && this.color.equals(o.getColor()) && this.spellBook.equals(o.getSpellBook())) {
            return true;
        }

        return false;
    }

    public void gainHealth(int heal) {
        health += heal;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public String getColor(){
        return color;
    }

    public Spell[] getSpellBook(){
        return spellBook;
    }

    public void setHealth(int temp){
        health = temp;
    }
}