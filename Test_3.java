public class Test_3{
    public static void main(String[] args){
        Gryffindor Harry = new Gryffindor("Harry Pottor");
        Slytherin Draco = new Slytherin("Draco");
        System.out.println(Harry);
        System.out.println(Draco);
        Harry.interact(Draco);
    }
}