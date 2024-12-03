public class UserImpl implements User{
    public String username;
    public int health;
    public int maxHealth;

    public UserImpl(String username){
        this.username = username;
        health = 5;
        maxHealth = 5;
    }

    @Override
    public void losehp(Integer value){
        if(value == null){
            health -= 1;
        }
        else{
            health -= value;
        }
    }

    @Override
    public void restorehp(Integer value) {
        if (value == null) {
            health = maxHealth;
        } else {
            if (health + value >= maxHealth) {
                health = maxHealth; // Directly set health to maxHealth
            } else {
                health += value;
            }
        }
    }

    @Override
    public int getHealth()
    {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getUsername() {
        return username;
    }
}
