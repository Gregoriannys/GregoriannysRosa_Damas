public class Ficha {

    //Representara ficha en el juego

    public enum ColorFicha {

        BLANCA, NEGRA
    }

    private ColorFicha color;
    private boolean esDama;


    public Ficha(ColorFicha color){
        this.color = color;
        this.esDama = false;

    }

    public ColorFicha getColor(){
        return color;
    }

    public boolean isDama(){
        return esDama;
    }

    public void setDama(boolean dama){
        this.esDama = dama;
    }

    
}

    

