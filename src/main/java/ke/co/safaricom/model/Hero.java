package ke.co.safaricom.model;

public class Hero {
    private Integer heroId;
    private String heroName;
    private Integer age;
    private String specialPower;
    private String weakness;
    private String squad;

    public Hero(Integer heroId, String heroName, Integer age, String specialPower, String weakness, String squad) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.squad = squad;
    }


    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName.toUpperCase();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "heroId=" + heroId +
                ", heroName='" + heroName + '\'' +
                ", age=" + age +
                ", specialPower='" + specialPower + '\'' +
                ", weakness='" + weakness + '\'' +
                ", squad='" + squad + '\'' +
                '}';
    }
}
