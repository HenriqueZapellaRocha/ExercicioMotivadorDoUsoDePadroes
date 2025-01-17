public class Carro {

    private String modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    public Carro(String modelo, TipoCombustivel tipoCombustivel, int consumoMotor, int capacidadeTanque, int quilometragem) {
        if(modelo == "Econo") {
            if(quilometragem >= 50000) {
                consumoMotor -= 10;
            } else {
                consumoMotor -= (quilometragem / 5000);
            }
        }
        this.modelo = modelo;
        motor = new Motor(tipoCombustivel, consumoMotor);
        tanque = new TanqueCombustivel(tipoCombustivel, capacidadeTanque);
    }

    public Carro(TipoCombustivel tipoCombustivelMotor, int consumoMotor, int capacidadeTanque, String modelo) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivelMotor, consumoMotor);
        tanque = new TanqueCombustivel(capacidadeTanque);
    }

    public Carro(String modelo, int consumoGasolina,int consumoAlcool, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new MotorFlex(consumoGasolina, consumoAlcool);
        tanque = new TanqueCombustivel(capacidadeTanque);
    }


    public String getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel() {
        return tanque.getCombustivelDisponivel();
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            //altera o tipo de combustivel do motor flex
            if(motor instanceof MotorFlex) {
                ((MotorFlex)motor).alteraEstado(tipoCombustivel);
            }
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            //altera o tipo de combustivel do motor flex
            if(motor instanceof MotorFlex) {
                ((MotorFlex)motor).alteraEstado(tipoCombustivel);
            }
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel() >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel() * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            if(modelo == "Econo" && motor.getQuilometragem() <= 50000 && motor.getQuilometragem() % 5000 == 0) {
                motor.diminuiConsumo();
            }
            tanque.gasta(motor.combustivelNecessario(distancia));
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}