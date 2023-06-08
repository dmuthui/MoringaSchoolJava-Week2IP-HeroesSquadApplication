package ke.co.safaricom.model;

public class Hero {
    private Integer heroId;
    private String heroName;
    private Integer age;
    private String specialPower;
    private String weakness;
    private String squad;
    private Boolean deleted = false;

    public Hero(Integer heroId, String heroName, Integer age, String specialPower, String weakness, String squad, Boolean deleted) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.squad = squad;
        this.deleted = deleted;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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
                ", deleted=" + deleted +
                '}';
    }
}