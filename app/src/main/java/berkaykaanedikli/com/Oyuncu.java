package berkaykaanedikli.com;

public class Oyuncu {
    private String isim;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    private Integer health;

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
    public Oyuncu(String isim, Integer health){
        this.isim = isim;
        this.health = health;
    }
    public Asker tankci = new Tankci();
    public Asker topcu = new Topcu();
}
