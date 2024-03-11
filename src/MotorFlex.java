public class MotorFlex extends Motor {

    private int consumoAlcool;
    private TipoCombustivel estadoAtual;

    public MotorFlex(int consumoGasolina, int consumoAlcool) {
        super(TipoCombustivel.FLEX, consumoGasolina);
        this.consumoAlcool = consumoAlcool;
        this.estadoAtual = null;
    }

    public int getConsumo() {
        if(estadoAtual == TipoCombustivel.GASOLINA) {
                   //consumo gasolina
            return super.getConsumo();
        } else {
            return consumoAlcool;
        }
    }

    public TipoCombustivel getTipoMotor(){
        return getTipoMotor();
    }

    public int combustivelNecessario(int distancia) {
        if(estadoAtual == TipoCombustivel.GASOLINA) {
                             //consumo gasolina
            return distancia / getConsumo();
        } else {
            return distancia / consumoAlcool;
        }
    }

    public void alteraEstado(TipoCombustivel estadoNovo) {
        estadoAtual = estadoNovo;
    }
    
    
}
