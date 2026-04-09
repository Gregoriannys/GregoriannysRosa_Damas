public class Ficha {

    //Representara ficha en el juego

    public enum ColorFicha {

        BLANCA, NEGRA
    }

    private ColorFicha color;
    private boolean dama;


    public Ficha(ColorFicha color){
        this.color = color;
        this.dama = false;

    }

    public ColorFicha getColor(){
        return color;
    }

    public boolean isDama(){
        return dama;
    }

    public void setDama(boolean dama){
        this.dama = dama;
    }

    
}

    

