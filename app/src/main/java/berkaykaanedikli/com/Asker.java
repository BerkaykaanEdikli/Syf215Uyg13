package berkaykaanedikli.com;
import java.util.Random;
public class Asker {
    private Integer damage;
    private Integer sans;

    public Integer getSans() {
        return sans;
    }

    public void setSans(Integer sans) {
        this.sans = sans;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
    public Asker(Integer damage, Integer sans){
        this.damage = damage;
        this.sans = sans;
    }
    public Integer atesEt(Oyuncu dusman){
        Random random = new Random();
        int isabet = random.nextInt(sans)*damage;
        dusman.setHealth(dusman.getHealth()-isabet);
        return isabet;
    }
}
