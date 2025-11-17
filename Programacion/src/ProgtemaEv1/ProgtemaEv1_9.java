package ProgtemaEv1;

import java.util.Scanner;

public class ProgtemaEv1_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia;
        int mes;
        String horoscopo = "";

        System.out.print("Di tu dia de nacimiento (1-31): ");
        dia = sc.nextInt();
        if(dia > 31){
            System.out.print("Dia invalido");
        } else{
            System.out.print("Di tu mes de nacimeinto (1-12): ");
            mes = sc.nextInt();  
            if (mes > 12){
                System.out.print("Mes invalido");
            } else{
                if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
            horoscopo = "Error: El día debe ser entre 1-31 y el mes entre 1-12.";
        } 
        
        

        else if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
            horoscopo = "Aries";
        }

        else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
            horoscopo = "Tauro";
        }

        else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
            horoscopo = "Géminis";
        }

        else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
            horoscopo = "Cáncer";
        }
   
        else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
            horoscopo = "Leo";
        }

        else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
            horoscopo = "Virgo";
        }
 
        else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
            horoscopo = "Libra";
        }

        else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
            horoscopo = "Escorpio";
        }

        else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
            horoscopo = "Sagitario";
        }

        else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
            horoscopo = "Capricornio";
        }

        else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            horoscopo = "Acuario";
        }

        else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
            horoscopo = "Piscis";
        }

        else {
            horoscopo = "Error: La combinación de día y mes es inválida (ej. 31 de Febrero o 31 de Abril).";
        }
        
        System.out.println("Tu horoscopo es: " + horoscopo);
                }
            }
        }

    }

