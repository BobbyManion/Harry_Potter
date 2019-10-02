public class Spell {
    private String name;
    private int damage;

    public Spell(String name, int damage) {
        this.name =  name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return (name + ": " + damage + " attack power");
    }

    public boolean equals(Spell o){
        if (this == o){
            return true;
        }

        if(this.name.equals(o.getName()) && this.damage == o.getDamage()){
            return true;
        }

        return false;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }
}