public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55, 0);
        Carro esportivo = new Carro("Esportivo", TipoCombustivel.GASOLINA, 6, 45, 0);
        Carro utilitario = new Carro("Utilitario", TipoCombustivel.DIESEL, 5, 70, 0);
        Carro suv = new Carro(TipoCombustivel.GASOLINA, 8, 55, "SUV");
        Carro suvFlex = new Carro("SUVflex", 8, 6, 65);
        Carro econo = new Carro("Econo", TipoCombustivel.GASOLINA, 20, 55, 50000);
        
        System.out.println("Tipos de veiculos:");
        System.out.println(basico);
        System.out.println(esportivo);
        System.out.println(utilitario);
        System.out.println(suv);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro esportivo com gasolina");
        esportivo.abastece(TipoCombustivel.GASOLINA, 45);
        System.out.println(esportivo);
        System.out.println("\nViajando com o carro esportivo");
        esportivo.viaja(250);
        System.out.println(esportivo);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro utilitario com diesel");
        utilitario.abastece(TipoCombustivel.DIESEL, 70);
        System.out.println(utilitario);
        System.out.println("\nViajando com o carro utilitario");
        utilitario.viaja(250);
        System.out.println(utilitario);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suv com diesel");
        suv.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suv);
        System.out.println("\nViajando com o carro suv");
        suv.viaja(250);
        System.out.println(suv); 


        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro suv flex com diesel");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 65);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro suv flex");
        suvFlex.viaja(9);
        System.out.println(suvFlex);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo econo com gasolina");
        econo.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o econo");
        econo.viaja(1100);
        System.out.println(econo);

    }
}
