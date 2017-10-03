
/**
 *
 * @author GonçaloSilva
 */
public class Hero {
    public int x;
    public  int y;
    private boolean life;
    
    //metodos

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
        this.life=true;
    }
    //metodos
    
    public void mov_up(){
        this.x--;
    }
    public void mov_down(){
        this.x++;
    }
    public void mov_right(){
        this.y++;
    }     
    public void mov_left(){
        this.y--;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }
    
    
}
